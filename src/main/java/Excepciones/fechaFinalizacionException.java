package Excepciones;

public class fechaFinalizacionException extends Exception{
    public fechaFinalizacionException () {
        super("La fecha de finalización tiene que ser anterior a la fecha actual.");
    }
}
