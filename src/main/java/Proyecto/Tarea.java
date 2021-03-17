package Proyecto;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tarea {

   private String titulo, descripcion;
    ArrayList<Persona> personasATarea;
    Persona responsable;
    private int prioridad;
    private LocalDate fechaCreacion, fechaFinalizacion; //Esta última puede estar en blanco
    boolean finalizado;
    Resultado resultadoEsperado;
    ArrayList<String> listaEtiquetas;


    public  Tarea () {
        super();
        personasATarea = new ArrayList<>();
        listaEtiquetas = new ArrayList<>();
    }

}
