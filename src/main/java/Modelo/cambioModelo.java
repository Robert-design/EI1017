package Modelo;

import Modelo.Excepciones.NoElementException;
import Modelo.Excepciones.añadirPersonaATareaException;

public interface cambioModelo {
    //Metodos controlador
    Persona altaPersona() throws añadirPersonaATareaException, NoElementException;
}
