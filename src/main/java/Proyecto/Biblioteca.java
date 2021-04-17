package Proyecto;

import java.io.Serializable;

public class Biblioteca extends Resultado implements Serializable {

    private String lenguaje; // Lenguanje de programación
    private int numModulos;
    private int numLineas;

    public Biblioteca(String identificadorResultado, int numHorasInvertidas, String opcion, String lenguaje, int numModulos, int numLineas) {
        super(identificadorResultado, numHorasInvertidas, opcion);
        this.lenguaje = lenguaje;
        this.numModulos = numModulos;
        this.numLineas = numLineas;
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

    @Override
    public String toString() {
        return "Biblioteca {" +
                " Lenguaje = '" + lenguaje + '\'' +
                ", numModulos = " + numModulos +
                ", numLineas = " + numLineas +
                " }";
    }
}
