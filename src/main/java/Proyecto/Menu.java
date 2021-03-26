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
                    String[] personasEnProyecto = proyecto.listarPersonasProyecto();
                    if (personasEnProyecto.length != 0)
                        System.out.println(Arrays.toString(personasEnProyecto));
                    else
                        System.out.println("No hay niguna persona dada de alta en el proyecto");
                    break;
                }

                case 7: {
                    String[] tareasEnProyecto = proyecto.listarTareasPoyecto();
                    if (tareasEnProyecto.length != 0)
                        System.out.println(Arrays.toString(tareasEnProyecto) + "\n");
                    else
                        System.out.println("No hay ninguna tarea dada de alta en el proyecto");
                    break;
                }
                case 8: {
                    System.out.println("¡Hasta luego!");
                    acabado = true;
                    break;
                }
            }
        }
    }


    public static void altaPersona(Proyecto proyecto) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nombre de la persona: ");
        String nombrePersona = scan.next();
        if (!proyecto.existePersona(nombrePersona))
            proyecto.añadirPersonaProyecto(nombrePersona);
        else
            System.out.println("Ya existe esa persona");
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
        proyecto.añadirTareaProyecto(tarea);
        System.out.println("Tarea creada exitosamente");
    }

    public static void marcarFinalizada(Proyecto proyecto) {
        Scanner scan = new Scanner(System.in);
        System.out.print("¿Qué tarea ha sido finalizada? ");
        String nombreTarea = scan.next();
        Tarea tarea = proyecto.dameTarea(nombreTarea);
        if (tarea.getFinalizado()) {
            tarea.setFinalizado(true);
            System.out.println("Tarea finalizada");
        } else
            System.out.println("La tarea ya se encontraba finalizada");
    }

    public static void introducirPersonaATarea(Proyecto proyecto) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nombre a añadir: ");
        String nombre = scan.next();
        System.out.print("Introduce el nombre de la tarea: ");
        String titulo = scan.next();
        boolean tareaExistente = proyecto.existeTarea(titulo);
        boolean personaExistente = proyecto.existePersona(nombre);
        Tarea tarea = proyecto.dameTarea(titulo);
        if ((personaExistente && tareaExistente) && !tarea.getFinalizado()) {
            Tarea existente = proyecto.dameTarea(titulo);
            Persona nueva = proyecto.damePersona(nombre);

            //Aquí empieza mi idea. el método está en la clase TAREA.
            boolean tieneResponsable = existente.tieneResponsable();
            if (!tieneResponsable) {
                System.out.print("¿Quieres que esta persona sea responsable de la tarea? (Y/N)");
                String respuesta = scan.next();
                if (respuesta.equals("Y\n"))
                    existente.setResponsable(nueva);
            }
            //aquí termina
            existente.añadirPersonaTarea(nueva);
            System.out.println("Persona añadida a la tarea.");
        } else {
            System.out.println("No se ha podido dar de alta a la persona");
        }

    }


    public static void eliminarPersonaDeTarea(Proyecto proyecto) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nombre de la persona para eliminarlo de la tarea: ");
        String nombre = scan.next();
        System.out.print("Introduce el título de la tarea: ");
        String titulo = scan.next();
        boolean tareaExistente = proyecto.existeTarea(titulo);
        boolean personaExistente = proyecto.existePersona(nombre);
        Tarea tarea = proyecto.dameTarea(titulo);
        Persona esResponsable = tarea.getResponsable();
        if (personaExistente && tareaExistente) {
            Tarea existente = proyecto.dameTarea(titulo);
            Persona eliminada = proyecto.damePersona(nombre);
            if (esResponsable.getNombre().equals(eliminada.getNombre())) {
                boolean hecho = false;
                while (!hecho) {
                    System.out.print("Has eliminado al responsable de la tarea, escoge a otro por favor: ");
                    nombre = scan.next();
                    Persona nueva = proyecto.damePersona(nombre);
                    if (tarea.personasATarea.contains(nueva)) {
                        tarea.setResponsable(proyecto.damePersona(nombre));
                        hecho = true;
                    }
                    System.out.println("Introduce una persona dada de alta en la tarea");
                }
                existente.eliminarPersonaTarea(eliminada);
                System.out.println("Persona eliminada correctamente");
            } else
                System.out.println("No se ha podido eliminar a la persona, la persona y/o tarea no existen");
        }
    }
}
