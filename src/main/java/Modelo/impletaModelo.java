package Modelo;
import Interfaces.utilidadesParaListas;
import Modelo.Facturacion.ConsumoInterno;
import Modelo.Facturacion.Descuento;
import Modelo.Facturacion.Urgente;
import Modelo.Tarea.*;
import Vista.*;
import Controlador.implementacionControlador;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class impletaModelo   {
    private ArrayList<Proyecto> proyectos = new ArrayList<>();

    private implementaVista vista;
    private cambioModelo modelo;
    private implementacionControlador controlador;
    String proyectoNombre;

    public void setVista(implementaVista vista) {
        this.vista = vista;
    }

    public void setProyectoNombre(String proyectoNombre) {
        this.proyectoNombre = proyectoNombre;
    }

    public String getProyectoNombre() {
        return this.proyectoNombre;
    }

    public void crearProyecto(String nombre){
        Proyecto nuevo = new Proyecto(nombre);
        System.out.println(nombre);
        proyectos.add(nuevo);
        try {
            guardarProyecto();
        } catch (Exception e){
            System.out.println("Error al guardar"+e);
        }

    }
    public String obtenerInfo(){
        System.out.println("Cargando info");
        String resultado = "";
        for (Proyecto proyecto : proyectos){
            resultado += (proyecto.mostrarinfo());
        }
        return resultado;
    }

    public void setControlador(implementacionControlador controlador) {
        this.controlador = controlador;
    }

    public Proyecto buscarProyecto(String nombreProyecto){
        for (Proyecto proyecto : proyectos){
            if (proyecto.getNombre().equals(nombreProyecto)){
                return proyecto;
            }
        }
        return null;
    }

    public void altaPersona(String nombreProyecto,String nombrePersona) throws añadirPersonaATareaException, NoElementException {
        Proyecto proyecto =  buscarProyecto(nombreProyecto);
        System.out.println(utilidadesParaListas.elementosInsertables(nombrePersona, proyecto.getListaPersonas()));
        if (utilidadesParaListas.elementosInsertables(nombrePersona, proyecto.getListaPersonas())) {
            proyecto.añadirPersonaProyecto(nombrePersona);

            System.out.println("Persona dada de alta\n");
        } else
            throw new NoElementException();
    }

    private Resultado crearResultado(String nombreResultado) {
        Resultado resultado = null;
        switch (nombreResultado) {
            case "D":
                resultado = new Documentacion("1D", 12, "Interno", "Word", 84, 8.4);
                break;
            case "P":
                resultado = new Programa("1P", 10, "Interno", "Java", 100, 8);
                break;
            case "PW":
                resultado = new PaginaWeb("1PW", 10, "Comercial", "Estática", "Python", "Hecho");
                break;
            case "B":
                resultado = new Biblioteca("1PW", 10, "Comercial", "C++", 50, 1);
                break;
            default:
                System.out.println("No has introducido una opción correcta\n");
                break;
        }
        return resultado;
    }
    public void creaTarea(String nombreProyecto,String nombreTarea,String nombreResultado, double coste,String tipo, double porcentaje) {
        Tarea tarea = new Tarea();
        Proyecto proyecto =  buscarProyecto(nombreProyecto);


        tarea.setTitulo(nombreTarea);
        tarea.setDescripcion("Hacer código en Java");
        tarea.setPrioridad(1);
        tarea.setFechaFinalizacion(null);
        tarea.setFinalizado(false);
        Resultado resultado = crearResultado(nombreResultado);
        tarea.setResultadoEsperado(resultado);
        tarea.setCoste(coste);


        if (tipo.equals("Consumo Interno")) {
            tarea.setFacturacion(new ConsumoInterno());
        }
        else if (tipo.equals("Descuento")) {
            tarea.setFacturacion(new Descuento(porcentaje));
        }
        else if (tipo.equals("Urgente")) {
            tarea.setFacturacion(new Urgente(porcentaje));
        }

        System.out.println("El importe es de " + tarea.getImporte() + "\n");

        try {
            proyecto.añadirTareaProyecto(tarea);
        } catch (añadirTareaExistenteException e) {
            e.printStackTrace();
        }
    }

    public void marcarFinalizado(String nombreProyecto,String nombreTarea) {
        Proyecto proyecto =  buscarProyecto(nombreProyecto);


        Tarea tarea = proyecto.dameTarea(nombreTarea);
        if (!tarea.getFinalizado()) {
            tarea.setFinalizado(true);
            System.out.println("Tarea finalizada\n");
        } else
            System.out.println("La tarea ya se encontraba finalizada\n");
    }

    public void añadirPersonaTarea(String nombreProyecto,String nombre, String titulo, String respuesta) {
        Proyecto proyecto =  buscarProyecto(nombreProyecto);

        Tarea tarea = proyecto.dameTarea(titulo);

        if (!tarea.getFinalizado()) {
            Tarea existente = proyecto.dameTarea(titulo);
            Persona nueva = proyecto.damePersona(nombre);
            boolean tieneResponsable = existente.tieneResponsable();
            try {
                existente.añadirPersonaTarea(nueva);
            } catch (añadirPersonaATareaException e) {
                e.printStackTrace();
            }
            if (!tieneResponsable) {

                if (respuesta.equals("Y")) {
                    try {
                        existente.setResponsable(nueva);
                    } catch (existeResponsableException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("Persona añadida a la tarea.\n");
        } else {
            System.out.println("No se ha podido dar de alta a la persona, has introducido algún campo incorrecto o la tarea estaba finalizada\n");
        }
    }

    public void eliminarPersonaTarea(String nombreProyecto,String nombre, String titulo,String nombreNuevo) {
        Proyecto proyecto = buscarProyecto(nombreProyecto);

        Tarea existente = proyecto.dameTarea(titulo);
        Persona eliminada = proyecto.damePersona(nombre);
        Tarea tarea = proyecto.dameTarea(titulo);
        Persona esResponsable = tarea.getResponsable();
        if (!utilidadesParaListas.elementosConListaVacia(tarea.getPersonasATarea()).isEmpty()) {
            if (esResponsable.getNombre().equals(eliminada.getNombre())) {
                boolean hecho = false;
                while (!hecho) {
                    Persona nueva = proyecto.damePersona(nombreNuevo);
                    if (tarea.getPersonasATarea().contains(nueva)) {
                        try {
                            tarea.setResponsable(nueva);
                            existente.eliminarPersonaTarea(eliminada);
                            System.out.println("Persona eliminada correctamente\n");
                        } catch (existeResponsableException e) {
                            e.printStackTrace();
                        }
                        hecho = true;
                    }
                }
            } else if(!esResponsable.getNombre().equals(eliminada.getNombre())) {
               existente.eliminarPersonaTarea(eliminada);
                System.out.println("Persona eliminada correctamente\n");
            }else
                System.out.println("Sólo hay una persona en la tarea y es el responsable, no puedes eliminarlo. O bien no hay nadie en la tarea\n");
        }

    }

    public String getPersona() {
       return getPersona();
    }

    public String getNombreProyecto() {
        return proyectoNombre;
    }

    public void cargarProyecto () throws Exception, ClassNotFoundException {
        try {
            FileInputStream fichero = new FileInputStream("DatosProyecto.bin");
            ObjectInputStream obj = new ObjectInputStream(fichero);
            this.proyectos = (ArrayList<Proyecto>) obj.readObject();
            obj.close();
            for(Proyecto p : proyectos){
                System.out.println(p.mostrarinfo());
            }
        }catch (Exception error){
            System.out.println("No hay datos");
        }
    }

    public void guardarProyecto () throws Exception {
        FileOutputStream fichero = new FileOutputStream("DatosProyecto.bin");
        ObjectOutputStream obj = new ObjectOutputStream(fichero);
        obj.writeObject(proyectos);
        obj.close();
    }

    public void modificarCoste (String nombreProyecto, double coste, String titulo) {
        Proyecto proyecto = buscarProyecto(nombreProyecto);
        proyecto.dameTarea(titulo).setCoste(coste);
    }

    public void modificarFacturacion (String nombreProyecto, double porcentaje, String titulo, String tipo) {
        Proyecto proyecto = buscarProyecto(nombreProyecto);
        Tarea tarea = proyecto.dameTarea(titulo);

        if (tipo.equals("Consumo Interno")) {
            tarea.setFacturacion(new ConsumoInterno());
        }
        else if (tipo.equals("Descuento")) {
            tarea.setFacturacion(new Descuento(porcentaje));
        }
        else if (tipo.equals("Urgente")) {
            tarea.setFacturacion(new Urgente(porcentaje));
        }
    }
}
