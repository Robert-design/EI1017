package Proyecto;


import java.util.ArrayList;

public class Persona {
    private String nombre, correo;
    ArrayList<Tarea> responsables;


    public Persona(String nombre, String correo) {
        super();

    }

    public String getNombre () {
        return this.nombre;
    }
    public String getCorreo() {
        return this.correo;
    }

    @Override
    public String toString() {
        return "Persona {" +
                "Nombre = '" + nombre + '\'' +
                ", Correo = '" + correo + '\'' +
                '}';
    }



}
