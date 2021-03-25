package Proyecto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        System.out.print("Introduce el nombre del nuevo proyecto para comenzar: ");
        Scanner scan = new Scanner(System.in);
        Proyecto proyecto = new Proyecto();
        String nombreProyecto = scan.next();
        proyecto.setNombre(nombreProyecto);
        boolean acabado = false;
        while (!acabado) {
            System.out.println("Escoja la opción deseada.");
            System.out.println("1. Dar de dalta personas que trabajan en el proyecto.");
            System.out.println("2. Dar de alta las tareas con sus datos.");
            System.out.println("3. Marcar una tarea como finalizada.");
            System.out.println("4. Introducir una persona en una tarea.");
            System.out.println("5. Eliminar una persona de una tarea.");
            System.out.println("6. Listar las personas asignadas a un proyecto.");
            System.out.println("7. Listar las tarea de un proyecto.");
            System.out.println("8. Salir del menú.");
            System.out.println("Escoge la opción deseada: ");
            int operacion = scan.nextInt();
            switch (operacion) {
                case 1 : {
                    System.out.println("Introduce el nombre de la persona: ");
                    String nombrePersona = scan.next();
                    proyecto.añadirPersonaProyecto(nombrePersona);
                    System.out.println("Las personas asignadas al proyecto son: ");
                    proyecto.listarPersonasProyecto();
                    break;
                }
                case 2 : {
                    crearTarea(proyecto);
                    break;
                }
                case 3 : {
                    marcarFinalizada(proyecto);
                    break;
                }
                case 4 : {
                    introducirPersonaATarea(proyecto);
                    break;
                }
                case 5: {
                    eliminarPersonaDeTarea(proyecto);
                    break;
                }
                case 6 : {
                    String[] personasEnProyecto = proyecto.listarPersonasProyecto();
                    System.out.println(Arrays.toString(personasEnProyecto));
                    break;
                }

                case 7 : {

                }
                case 8 : {
                    System.out.println("¡Hasta luego!");
                    acabado = true;
                    break;
                }
            }
        }
    }

    public static void crearTarea(Proyecto proyecto) {
        Tarea tarea = new Tarea();
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce la tarea: ");
        String nombreTarea = scan.next();
        tarea.setTitulo(nombreTarea);
        tarea.setDescripcion("Hacer código en Java");
        tarea.setPrioridad(1);
        tarea.setFechaCreacion(LocalDate.now());
        tarea.setFechaFinalizacion(null);
        tarea.setFinalizado(false);
        tarea.setResultadoEsperado(null);
        System.out.println(tarea.getTitulo());
    }

    public static void marcarFinalizada(Proyecto proyecto) {
        Scanner scan = new Scanner(System.in);
        System.out.println("¿Qué tarea ha sido finalizada?");
        String nombreTarea = scan.next();
        Tarea tarea = proyecto.dameTarea(nombreTarea);
        tarea.setFinalizado(true);
        System.out.println("Tarea finalizada");
    }

    public static void introducirPersonaATarea(Proyecto proyecto) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el nombre a añadir: ");
        String nombre = scan.next();
        System.out.println("Introduce el título de la tarea: ");
        String titulo = scan.next();
        boolean tareaExistente = proyecto.existeTarea(titulo);
        boolean personaExistente = proyecto.existePersona(nombre);
        if(personaExistente && tareaExistente) {
            Tarea existente = proyecto.dameTarea(titulo);
            Persona nueva = proyecto.damePersona(nombre);
            System.out.print("¿Quieres que esta persona sea respoable de la tarea? (Y/N)");
            String respuesta = scan.next();
            if (respuesta.equals("Y"))
                existente.setResponsable(nueva);
            existente.añadirPersonaTarea(nueva);
            System.out.println("Persona añadida a la tarea.");
        }
    }


    public static void eliminarPersonaDeTarea(Proyecto proyecto) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el nombre de la persona para eliminarlo de la tarea: ");
        String nombre = scan.next();
        System.out.println("Introduce el título de la tarea: ");
        String titulo = scan.next();
        boolean tareaExistente = proyecto.existeTarea(titulo);
        boolean personaExistente = proyecto.existePersona(nombre);
        if(personaExistente && tareaExistente) {
            Tarea existente = proyecto.dameTarea(titulo);
            Persona eliminada = proyecto.damePersona(nombre);
            existente.eliminarPersonaTarea(eliminada);
            System.out.println("Persona eliminada correctamente");
        }
    }

}
