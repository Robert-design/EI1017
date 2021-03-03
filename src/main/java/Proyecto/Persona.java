package Proyecto;

import java.util.ArrayList;

public class Persona {
    String nombre, correo;
    ArrayList<Tarea> tareasResponsable;

    public Persona() {
        super();
        tareasResponsable = new ArrayList<>();
    }
}
