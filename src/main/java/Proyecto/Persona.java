package Proyecto;

import java.util.ArrayList;

public class Persona {
    String nombre;
    String correo;
    ArrayList<Tarea> tareasResponsable;

    public Persona(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
        tareasResponsable = new ArrayList<>();
    }
}
