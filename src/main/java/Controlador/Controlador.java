package Controlador;

import Modelo.Excepciones.NoElementException;
import Modelo.Excepciones.añadirPersonaATareaException;

public interface Controlador {

    void altaPersona() throws añadirPersonaATareaException, NoElementException; //opt 1
    void crearTarea(); //opt2
    void marcarFinalizado(); //....
    void introducirPersonaATarea();
    void eliminarPersonaDeTarea();
    void listarPersonasProyecto();
    void listarTareasProyecto();
    //void guardarProycto();
    //void cargarProyecto();
    void modificarCoste();
    void modificarFacturación();
    void importeTotal(); //opt12



}
