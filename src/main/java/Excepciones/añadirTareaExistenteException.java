package Excepciones;

public class añadirTareaExistenteException extends Exception {
    public añadirTareaExistenteException () {
        super("La tarea ya existe");
    }
}
