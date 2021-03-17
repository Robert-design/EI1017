package Proyecto;

import java.util.ArrayList;
import java.util.Scanner;

public class Proyecto  {
    private static String nombre;
    ArrayList<Persona> listaPersonas;
    ArrayList<Tarea> listaTareas;

    public Proyecto() {
        listaPersonas = new ArrayList<>();
        listaTareas = new ArrayList<>();
    }

    public static void setNombre() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nombre del proyecto: ");
        nombre = scan.next();
    }

    public static String getNombre() {
        return nombre;
    }

    public static void main(String[] args) {
        setNombre();
        System.out.println(getNombre());
    }
}
