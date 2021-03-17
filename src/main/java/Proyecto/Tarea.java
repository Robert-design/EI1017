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
    //Me falta añadir lista de etiquetas, pero no sé si debe de ser una clase o lista normal


    public  Tarea () {
        super();
        personasATarea = new ArrayList<>();
    }

}
