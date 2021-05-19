package Modelo;
import Interfaces.utilidadesParaListas;
import Modelo.Facturacion.ConsumoInterno;
import Modelo.Facturacion.Descuento;
import Modelo.Facturacion.Urgente;
import Modelo.Tarea.*;
import Vista.*;
import Controlador.implementacionControlador;

import java.util.Scanner;

public class impletaModelo implements interrogaModelo, cambioModelo {
    private Proyecto proy;
    private implementaVista vista;
    private cambioModelo modelo;
    private implementacionControlador controlador;

    public void setVista(implementaVista vista) {
        this.vista = vista;
    }

    public void setControlador(implementacionControlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void altaPersona() throws añadirPersonaATareaException, NoElementException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nombre de la persona: ");
        String nombrePersona = vista.getPersona();
        if (utilidadesParaListas.elementosInsertables(nombrePersona, proy.getListaPersonas())) {
            proy.añadirPersonaProyecto(nombrePersona);
            System.out.println("Persona dada de alta\n");
        }
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
    @Override
    public void creaTarea() {
        Tarea tarea = new Tarea();
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce la tarea: ");
        String nombreTarea = scan.next();
        tarea.setTitulo(nombreTarea);
        tarea.setDescripcion("Hacer código en Java");
        tarea.setPrioridad(1);
        tarea.setFechaFinalizacion(null);
        tarea.setFinalizado(false);
        System.out.print("Introduce el tipo de resultado esperado: Documentación (D), Programa (P), Página web (PW), Biblioteca (B): ");
        String nombreResultado = scan.next();
        Resultado resultado = crearResultado(nombreResultado);
        while (resultado == null) {
            System.out.print("Introduce una opción correcta por favor: Documentación (D), Programa (P), Página web (PW), Biblioteca (B): ");
            nombreResultado = scan.next();
            resultado = crearResultado(nombreResultado);
        }
        tarea.setResultadoEsperado(resultado);

        System.out.print("Introduce el coste de la tarea: ");
        double coste = scan.nextDouble();
        tarea.setCoste(coste);

        System.out.print("¿Qué tipo de facturación es? Consumo interno (C), Descuento (D), Urgente (U): ");
        String tipo = scan.next();
        if (tipo.equals("C")) {
            tarea.setFacturacion(new ConsumoInterno());
        }
        else if (tipo.equals("D")) {
            System.out.print("Introduce el descuento (del 1 al 100%): ");
            double desc = scan.nextDouble();
            tarea.setFacturacion(new Descuento(desc));
        }
        else if (tipo.equals("U")) {
            System.out.print("Introduce el porcentaje a aplicar (del 1 al 100%): ");
            double urg = scan.nextDouble();
            tarea.setFacturacion(new Urgente(urg));
        }

        System.out.println("El importe es de " + tarea.getImporte() + "\n");

        try {
            proy.añadirTareaProyecto(tarea);
        } catch (añadirTareaExistenteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void marcarFinalizado() {
        Scanner scan = new Scanner(System.in);
        System.out.print("¿Qué tarea ha sido finalizada? ");
        String nombreTarea = scan.next();
        Tarea tarea = proy.dameTarea(nombreTarea);
        if (!tarea.getFinalizado()) {
            tarea.setFinalizado(true);
            System.out.println("Tarea finalizada\n");
        } else
            System.out.println("La tarea ya se encontraba finalizada\n");
    }

    @Override
    public void añadirPersonaTarea() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nombre a añadir: ");
        String nombre = scan.next();
        System.out.print("Introduce el nombre de la tarea: ");
        String titulo = scan.next();
        Tarea tarea = proy.dameTarea(titulo);

        if (!tarea.getFinalizado()) {
            Tarea existente = proy.dameTarea(titulo);
            Persona nueva = proy.damePersona(nombre);
            boolean tieneResponsable = existente.tieneResponsable();
            try {
                existente.añadirPersonaTarea(nueva);
            } catch (añadirPersonaATareaException e) {
                e.printStackTrace();
            }
            if (!tieneResponsable) {
                System.out.print(" ¿Quieres que esta persona sea responsable de la tarea? (Y/N)");
                String respuesta = scan.next();
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

    @Override
    public void eliminarPersonaTarea() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nombre de la persona para eliminarlo de la tarea: ");
        String nombre = scan.next();
        System.out.print("Introduce el título de la tarea: ");
        String titulo = scan.next();
        Tarea existente = proy.dameTarea(titulo);
        Persona eliminada = proy.damePersona(nombre);
        Tarea tarea = proy.dameTarea(titulo);
        Persona esResponsable = tarea.getResponsable();
        //existente.personasATarea.size() > 1
        if (!utilidadesParaListas.elementosConListaVacia(tarea.getPersonasATarea()).isEmpty()) {
            if (esResponsable.getNombre().equals(eliminada.getNombre())) {
                System.out.print("Vas a eliminar al responsable de la tarea, escoge a otro antes por favor: ");
                boolean hecho = false;
                while (!hecho) {
                    nombre = scan.next();
                    Persona nueva = proy.damePersona(nombre);
                    if (tarea.getPersonasATarea().contains(nueva)) {
                        try {
                            tarea.setResponsable(nueva);
                            existente.eliminarPersonaTarea(eliminada);
                            System.out.println("Persona eliminada correctamente\n");
                        } catch (existeResponsableException e) {
                            e.printStackTrace();
                        }
                        hecho = true;
                    } else
                        System.out.println("Introduce una persona dada de alta en la tarea");
                }
            } else {
                existente.eliminarPersonaTarea(eliminada);
                System.out.println("Persona eliminada correctamente\n");

            }
        } else
            System.out.println("Sólo hay una persona en la tarea y es el responsable, no puedes eliminarlo. O bien no hay nadie en la tarea\n");
    }


    @Override
    public String getPersona() {
       return getPersona();
    }

    @Override
    public String getNombreProyecto() {
        return getNombreProyecto();
    }

}
