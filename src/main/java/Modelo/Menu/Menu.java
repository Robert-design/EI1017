package Modelo.Menu;

import Interfaces.utilidadesParaListas;
import Modelo.NoElementException;
import Modelo.añadirPersonaATareaException;
import Modelo.añadirTareaExistenteException;
import Modelo.existeResponsableException;
import Modelo.Facturacion.ConsumoInterno;
import Modelo.Facturacion.Descuento;
import Modelo.Facturacion.Urgente;
import Modelo.Persona;
import Modelo.Proyecto;
import Modelo.Tarea.*;

import java.io.*;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws IOException, ClassNotFoundException, añadirPersonaATareaException, NoElementException {
        System.out.print("Introduce el nombre del nuevo proyecto para comenzar: ");
        Scanner scan = new Scanner(System.in);
        Proyecto proyecto = new Proyecto();
        String nombreProyecto = scan.next();
        proyecto.setNombre(nombreProyecto);
        boolean acabado = false;
        while (!acabado) {
            System.out.println("Escoja la opción deseada.");
            System.out.println("1. Dar de alta personas que trabajan en el proyecto.");
            System.out.println("2. Dar de alta las tareas con sus datos.");
            System.out.println("3. Marcar una tarea como finalizada.");
            System.out.println("4. Introducir una persona en una tarea.");
            System.out.println("5. Eliminar una persona de una tarea.");
            System.out.println("6. Listar las personas asignadas a un proyecto.");
            System.out.println("7. Listar las tarea de un proyecto.");
            System.out.println("8. Guardar los datos del proyecto");
            System.out.println("9. Cargar los datos de un proyecto");
            System.out.println("10. Cambiar coste de una tarea");
            System.out.println("11. Cambiar tipo de facturación de una tarea");
            System.out.println("12. Conocer importe total proyecto");
            System.out.println("13. Salir del menú.");
            System.out.print("Escoge la opción deseada: ");
            int operacion = scan.nextInt();
            switch (operacion) {
                case 1: {
                    altaPersona(proyecto);
                    break;
                }
                case 2: {
                    crearTarea(proyecto);
                    break;
                }
                case 3: {
                    marcarFinalizada(proyecto);
                    break;
                }
                case 4: {
                    introducirPersonaATarea(proyecto);
                    break;
                }
                case 5: {
                    eliminarPersonaDeTarea(proyecto);
                    break;
                }
                case 6: {
                    proyecto.listarPersonasProyecto();
                }
                case 7: {
                    proyecto.listarTareasPoyecto();
                }
                case 8: {
                    guardarProyecto(proyecto);
                    break;
                }
                case 9: {
                    cargarProyecto(proyecto);
                    break;
                }
                case 10: {
                    modificarCoste(proyecto);
                    break;
                }
                case 11: {
                    modificarFacturacion(proyecto);
                    break;
                }
                case 12: {
                    importeTotal(proyecto);
                    break;
                }
                case 13: {
                    System.out.println("¡Hasta luego!");
                    acabado = true;
                    break;
                }
            }
        }
    }


    public static void altaPersona(Proyecto proyecto) throws añadirPersonaATareaException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nombre de la persona: ");
        String nombrePersona = scan.next();
        if (utilidadesParaListas.elementosInsertables(nombrePersona, proyecto.getListaPersonas())) {
            proyecto.añadirPersonaProyecto(nombrePersona);
            System.out.println("Persona dada de alta\n");
        }
        else
            System.out.println("Ya existe esa persona");
    }

    public static Resultado crearResultado(String nombreResultado){
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

    public static void crearTarea(Proyecto proyecto) {
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
            proyecto.añadirTareaProyecto(tarea);
        } catch (añadirTareaExistenteException e) {
            e.printStackTrace();
        }
    }


    public static void marcarFinalizada(Proyecto proyecto) {
        Scanner scan = new Scanner(System.in);
        System.out.print("¿Qué tarea ha sido finalizada? ");
        String nombreTarea = scan.next();
        Tarea tarea = proyecto.dameTarea(nombreTarea);
        if (!tarea.getFinalizado()) {
            tarea.setFinalizado(true);
            System.out.println("Tarea finalizada\n");
        } else
            System.out.println("La tarea ya se encontraba finalizada\n");
    }

    public static void introducirPersonaATarea(Proyecto proyecto)  {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nombre a añadir: ");
        String nombre = scan.next();
        System.out.print("Introduce el nombre de la tarea: ");
        String titulo = scan.next();
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


    public static void eliminarPersonaDeTarea(Proyecto proyecto) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nombre de la persona para eliminarlo de la tarea: ");
        String nombre = scan.next();
        System.out.print("Introduce el título de la tarea: ");
        String titulo = scan.next();
        Tarea existente = proyecto.dameTarea(titulo);
        Persona eliminada = proyecto.damePersona(nombre);
        Tarea tarea = proyecto.dameTarea(titulo);
        Persona esResponsable = tarea.getResponsable();
        //existente.personasATarea.size() > 1
        if (!utilidadesParaListas.elementosConListaVacia(tarea.getPersonasATarea()).isEmpty()) {
            if (esResponsable.getNombre().equals(eliminada.getNombre())) {
                System.out.print("Vas a eliminar al responsable de la tarea, escoge a otro antes por favor: ");
                boolean hecho = false;
                while (!hecho) {
                    nombre = scan.next();
                    Persona nueva = proyecto.damePersona(nombre);
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

    public static void modificarCoste (Proyecto proyecto) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nuevo coste: ");
        double coste = scan.nextDouble();
        System.out.print("Dime el título de la tarea: ");
        String titulo = scan.next();
        proyecto.dameTarea(titulo).setCoste(coste);
        System.out.println("El nuevo coste es " + proyecto.dameTarea(titulo).getImporte() + "\n");
    }

    public static void modificarFacturacion (Proyecto proyecto) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce la inicial del tipo de facturación - Consumo interno (C), Descuento (D), Urgente (U): ");
        String tipo = scan.next();
        System.out.print("Dime el título de la tarea: ");
        String titulo = scan.next();
        Tarea tarea = proyecto.dameTarea(titulo);

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
        System.out.println("El nuevo precio por la facturación es " + tarea.getImporte() + "\n");
    }

    public static void importeTotal (Proyecto proyecto) {
        System.out.println("El importa total del proyecto es de " + proyecto.importeTotal() + "\n");
    }


    public static void cargarProyecto (Proyecto proyecto) throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print(" ¿Qué proyecto deseas cargar?:");
        String cargarProyecto = scan.next();
        FileInputStream fichero = new FileInputStream(cargarProyecto+".bin");
        ObjectInputStream obj = new ObjectInputStream(fichero);
        proyecto = (Proyecto) obj.readObject();
        obj.close();
        System.out.println("Datos cargados");
    }

    public static void guardarProyecto (Proyecto proyecto) throws IOException {
        String nombreProyecto = proyecto.getNombre();
        FileOutputStream fichero = new FileOutputStream(nombreProyecto+".bin");
        ObjectOutputStream obj = new ObjectOutputStream(fichero);
        obj.writeObject(proyecto);
        obj.close();
        System.out.println("Guardando los datos...");
    }

}
