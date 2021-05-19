package Modelo;

import Modelo.Excepciones.NoElementException;
import Modelo.Excepciones.añadirPersonaATareaException;

public interface cambioModelo {
    //Metodos controlador
    void  altaPersona() throws añadirPersonaATareaException, NoElementException;
    void creaTarea();
    void marcarFinalizado();
    void añadirPersonaTarea();
    void eliminarPersonaTarea();


}
