package Modelo;

public interface cambioModelo {
    //Metodos controlador
    void altaPersona() throws añadirPersonaATareaException, NoElementException;
    void creaTarea();
    void marcarFinalizado();
    void añadirPersonaTarea();
    void eliminarPersonaTarea();


}
