package Modelo;

import java.util.ArrayList;

public interface cambioModelo {
    void crearProyecto(String nombre);
    Proyecto buscarProyecto(String nombreProyecto);
    void altaPersona(String nombreProyecto,String nombrePersona) throws a├▒adirPersonaATareaException, NoElementException;
    void creaTarea(String nombreProyecto,String nombreTarea,String nombreResultado, double coste,String tipo, double porcentaje);
    void marcarFinalizado(String nombreProyecto,String nombreTarea);
    void a├▒adirPersonaTarea(String nombreProyecto,String nombre, String titulo, String respuesta);
    void eliminarPersonaTarea(String nombreProyecto, String titulo, String nombre, String nombreNuevo);
    ArrayList<Persona> listarPersonas(String nombreProyecto);

}
