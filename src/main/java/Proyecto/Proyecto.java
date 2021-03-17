package Proyecto;

import java.util.ArrayList;

public class Proyecto extends Tarea {
    ArrayList<Persona> listaPersonas;
    ArrayList<Tarea> listaTareas;

    public Proyecto() {
        listaPersonas = personasATarea;
        listaTareas = new ArrayList<>();
    }
    /* Esta clase puede extender de persona y de tarea, de esta forma tendrá accesso a los arrays sin crear atributos. */


}
