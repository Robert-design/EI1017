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
    private boolean finalizado;
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

    public boolean getFinalizado() { return finalizado; }

    public LocalDate getFechaFinalizacion() { return fechaFinalizacion; }

    public boolean isFinalizado() { return finalizado; }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Resultado getResultadoEsperado() { return resultadoEsperado; }

    public void setResponsable(Persona responsable) {
        if (personasATarea.contains(responsable))
            this.responsable = responsable;
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

     public boolean tieneResponsable(){
         return this.responsable != null;
     }



    public void añadirPersonaTarea(Persona persona) {
        personasATarea.add(persona);
    }

    public void eliminarPersonaTarea(Persona eliminar) {
        personasATarea.remove(eliminar);
    }

    public String [] mostrarPersonasProyecto() {
        String [] res = new String[personasATarea.size()];
        for (int i = 0; i < personasATarea.size(); i++) {
            res[i] = String.valueOf(personasATarea.get(i));
        }
        return res;
    }
}
