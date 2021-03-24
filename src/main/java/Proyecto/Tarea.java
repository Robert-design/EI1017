package Proyecto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;

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
    }

    public String getTitulo() { return titulo; }

    public String getDescripcion() { return descripcion; }

    public Persona getResponsable() { return responsable; }

    public int getPrioridad() { return prioridad; }

    public LocalDate getFechaCreacion() { return fechaCreacion; }

    public LocalDate getFechaFinalizacion() { return fechaFinalizacion; }

    public boolean isFinalizado() { return finalizado; }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Resultado getResultadoEsperado() { return resultadoEsperado; }

    public void setResponsable(Persona responsable) {
        if (personasATarea.contains(responsable))
            this.responsable = responsable;
        else
            System.out.println("El responsable tiene que estar asignado a la tarea");
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public void setResultadoEsperado(Resultado resultadoEsperado) {
        this.resultadoEsperado = resultadoEsperado;
    }

    public Persona existeResponsable(String nombre) throws NoSuchElementException {
        for (Persona pers: personasATarea) {
            if (nombre.compareTo(pers.getNombre())==0) {
                return pers;
            }
        }
        throw new NoSuchElementException();
    }

    public boolean añadirPersonaTarea(String nombre, String nombreTarea) {
        Persona nueva = new Persona(nombre, "@gmail.com");
        return personasATarea.add(nueva);
    }
}
