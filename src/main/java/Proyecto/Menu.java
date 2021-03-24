package Proyecto;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Proyecto proyecto = new Proyecto();
        boolean acabado = true;
        while (acabado) {
            System.out.println("1. Iniciar un nuevo proyecto y darle nombre.");
            System.out.println("2. Dar de dalta personas que trabajan en el proyecto.");
            System.out.println("3. Dar de alta las tareas con sus datos.");
            System.out.println("4. Marcar una tarea como finalizada.");
            System.out.println("5. Introducir o eliminar una persona de una tarea.");
            System.out.println("6. Listar las personas asignadas a un proyecto.");
            System.out.println("7. Listar las tarea de un proyecto.");
            System.out.println("8. Salir del menú.");
            System.out.println("Escoge la opción deseada: ");
            int operacion = scan.nextInt();
            switch (operacion) {
                case 1: {
                    proyecto = new Proyecto();
                    System.out.print("Introduce el nombre: ");
                    String nombre = scan.next();
                    proyecto.setNombre(nombre);
                    break;
                }
                case 2: {
                    Persona persona = new Persona("juan", "@gmail.com");
                    proyecto.añadirPersona(persona);
                    proyecto.listarPersonasProyecto();
                    break;
                }
                case 3: {
                    Tarea tarea = new Tarea();
                    break;
                }
                case 4: {
                    break;
                }
                case 8: {
                    acabado = false;
                    System.out.println("Hasta luego");
                    break;
                }
            }
        }
    }
}
