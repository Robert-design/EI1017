package Proyecto;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        System.out.print("Escoge la opción deseada: ");
        Scanner scan = new Scanner(System.in);
        int operacion = scan.nextInt();
        switch (operacion) {
            case 1: {
                Proyecto proyecto = new Proyecto();
                System.out.print("Introduce el nombre: ");
                String nombre = scan.next();
                proyecto.setNombre(nombre);
                System.out.println(nombre);
                break;
            }
        }
    }
}
