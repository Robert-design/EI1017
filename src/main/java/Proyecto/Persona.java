package Proyecto;

import java.util.ArrayList;

public class Persona {
    private String nombre, correo;
    ArrayList<Tarea> tareasResponsable;

    public Persona(String nombre, String correo) {
        super();
        this.nombre = nombre;
        this.correo = correo;
        tareasResponsable = new ArrayList<>();
    }

    public String getNombre () {
        return this.nombre;
    }

    public String getCorreo() {
        return this.correo;
    }
}
