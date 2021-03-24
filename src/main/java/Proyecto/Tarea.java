package Proyecto;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tarea {
    ArrayList<Persona> personasATarea;
    ArrayList<String> listaEtiquetas;
    private String titulo, descripcion;
    private Persona responsable;
    private int prioridad;
    private LocalDate fechaCreacion, fechaFinalizacion; //Esta última puede estar en blanco
    boolean finalizado;
    private Resultado resultadoEsperado;


    public Tarea () {
        super();
        personasATarea = new ArrayList<>();
        listaEtiquetas = new ArrayList<>();
        this.titulo = "Hacer una app";
        this.descripcion = "Realizar código";
        this.responsable = null;
        this.prioridad = 1;
        this.fechaCreacion = LocalDate.now();
        this.finalizado = false;
        this.resultadoEsperado = null;
    }

    public String getTitulo() { return titulo; }

    public String getDescripcion() { return descripcion; }

    public Persona getResponsable() { return responsable; }

    public int getPrioridad() { return prioridad; }

    public LocalDate getFechaCreacion() { return fechaCreacion; }

    public LocalDate getFechaFinalizacion() { return fechaFinalizacion; }

    public boolean isFinalizado() { return finalizado; }

    public void setFinalizado() {
        this.finalizado = true;
    }

    public Resultado getResultadoEsperado() { return resultadoEsperado; }

}
