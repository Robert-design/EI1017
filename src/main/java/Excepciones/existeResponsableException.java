package Excepciones;

public class existeResponsableException extends Exception{
    public existeResponsableException () {
        super("Ya existe un responsable en la tarea o es el mismo");
    }
}
