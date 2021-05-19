package Modelo;

public class NoElementException extends Exception {
    public NoElementException() {
        System.out.println("No existe persona ó lista");
    }
}
