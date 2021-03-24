package Proyecto;

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
            System.out.println("4. Introducir o eliminar una persona de una tarea.");
            System.out.println("5. Listar las personas asignadas a un proyecto.");
            System.out.println("6. Listar las tarea de un proyecto.");
            System.out.println("7. Salir del menú.");
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


                    break;
                }
                case 3 : {
                    break;
                }
                case 7 : {
                    acabado = false;
                    System.out.println("Hasta luego");
                    break;
                }
            }
        }
    }
}
