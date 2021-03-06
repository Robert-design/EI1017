package Modelo.Tarea;
import Modelo.Facturacion.Facturacion;
import Interfaces.tieneClave;
import Interfaces.tieneLista;
import Modelo.a├▒adirPersonaATareaException;
import Modelo.existeResponsableException;
import Modelo.Persona;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tarea implements tieneClave, tieneLista, Serializable {
    public ArrayList<Persona> personasATarea;
    public ArrayList<String> listaEtiquetas;
    private String titulo, descripcion;
    private Persona responsable;
    private int prioridad;
    private LocalDate fechaCreacion, fechaFinalizacion; //Esta ├║ltima puede estar en blanco
    private boolean finalizado;
    private Resultado resultadoEsperado;
    private double coste;
    private Facturacion facturacion;

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

    public void setResponsable(Persona responsable) throws existeResponsableException {
        if (!responsable.equals(getResponsable()))
            this.responsable = responsable;
        else
            throw new existeResponsableException();
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

    public void setFechaCreacion(LocalDate fechaCreacion)  {
            this.fechaCreacion = fechaCreacion;
    }

    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public void setResultadoEsperado(Resultado resultadoEsperado) {
        this.resultadoEsperado = resultadoEsperado;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public Facturacion getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(Facturacion facturacion) {
        this.facturacion = facturacion;
    }

    public ArrayList<Persona> getPersonasATarea() {
        return personasATarea;
    }

    public boolean tieneResponsable(){
         return this.responsable != null;
     }

    public void a├▒adirPersonaTarea(Persona persona) throws a├▒adirPersonaATareaException {
        if (personasATarea.contains(persona))
            throw new a├▒adirPersonaATareaException();
        else
            personasATarea.add(persona);
    }

    public void eliminarPersonaTarea(Persona eliminar) {
        personasATarea.remove(eliminar);
    }

    public String  mostrarPersonasProyecto() {
        String  res = "";
        for (int i = 0; i < personasATarea.size(); i++) {
            res += String.valueOf(personasATarea.get(i));
        }
        return res;
    }
    public Persona personaEnTarea(String nombre){
        for (Persona persona : personasATarea)
            if (persona.getNombre().equals(nombre))
                return persona;
        return null;
    }

    @Override
    public String getClave() {
        return getTitulo();
    }

    @Override
    public ArrayList getLista() {
        return personasATarea;
    }

    public double getImporte () {
        return facturacion.coste(coste);
    }
}
