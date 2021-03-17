package Proyecto;

public class Biblioteca extends Resultado {

    private String lenguaje; // Lenguanje de programación
    private int numModulos;
    private int numLineas;

    public Biblioteca() {
        super();
    }

    public String getLenguaje() {
        return this.lenguaje;
    }

    public int getNumModulos() {
        return this.numModulos;
    }

    public int getNumLineas(){
        return this.numLineas;
    }
}
