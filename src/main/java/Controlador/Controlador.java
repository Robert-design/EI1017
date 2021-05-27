package Controlador;

import Modelo.NoElementException;
import Modelo.añadirPersonaATareaException;

public interface Controlador {

    void altaPersona(String nomProy, String persona) throws añadirPersonaATareaException, NoElementException;
    void crearTarea(String nombreProyecto,String nombreTarea,String nombreResultado, double coste,String tipo, double porcentaje); //opt2
    void marcarFinalizado(String nombreProyecto, String nombreTarea);
    void añadirPersonaATarea(String proyecto, String persona,String titulo, String resultado);
    void eliminarPersonaDeTarea(String proyecto, String tituloTarea ,String personaNueva, String nuevaPersonaRespon);
    void listarPersonasProyecto(String nombreProyecto);
    void listarTareasProyecto();
    //void guardarProycto();
    //void cargarProyecto();
    void modificarTarea(String proyecto, double coste, double porcentaje, String titulo, String tipo);

}
