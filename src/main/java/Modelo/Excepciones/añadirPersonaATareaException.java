package Modelo.Excepciones;

public class añadirPersonaATareaException extends Exception {
    public añadirPersonaATareaException () {
        super("No puedes añadir a la persona a la tarea porque ya está dada de alta");
    }
}
