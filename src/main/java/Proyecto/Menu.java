package Proyecto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        System.out.print("Introduce el nombre del nuevo proyecto para comenzar: ");
        Scanner scan = new Scanner(System.in);
        Proyecto proyecto = new Proyecto();
        String nombreProyecto = scan.next();
        proyecto.setNombre(nombreProyecto);
        boolean acabado = true;
        while (acabado) {
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
                    Tarea tarea = new Tarea();
                    tarea.setTitulo("Programar");
                    tarea.setDescripcion("Hacer código en Java");
                    String nombreResponsable = scan.next();
                    Persona responsable = tarea.existeResponsable(nombreResponsable);
                    tarea.setResponsable(responsable);
                    tarea.setPrioridad(1);
                    tarea.setFechaCreacion(LocalDate.now());
                    tarea.setFechaFinalizacion(null);
                    tarea.setFinalizado(false);
                    tarea.setResultadoEsperado(null);
                    break;
                }
                case 3 : {
                    System.out.println("¿Qué tarea ha sido finalizada?");
                    String nombreTarea = scan.next();
                    Tarea tarea = proyecto.dameTarea(nombreTarea);
                    tarea.setFinalizado();
                    System.out.println("Tarea finalizada");
                    break;
                }
                case 4 : {
                    System.out.println("Introduce el nombre a añadir: ");
                    String nombre = scan.next();
                    System.out.println("Introduce el título de la tarea: ");
                    String titulo = scan.next();
                    boolean tareaExistente = proyecto.existeTarea(titulo);
                    boolean personaExistente = proyecto.existePersona(nombre);
                    if(personaExistente && tareaExistente) {
                        Tarea existente = proyecto.dameTarea(titulo);
                        existente.añadirPersonaTarea(p);
                    }

                }
                case 5: {
                    /*Tarea nueva = new Tarea();
                    System.out.println("Introduce el nombre a añadir: ");
                    String nombre = scan.next();
                    if(nueva.eliminarPerosnaTarea(nombre)){
                        System.out.println("Se ha eliminado la persona correctamente.");
                    }
                    break */
                }
                case 6 : {
                    String[] personasEnProyecto = proyecto.listarPersonasProyecto();
                    System.out.println(personasEnProyecto.toString());
                    break;
                }
            }
        }
    }
}
