package Proyecto;

import java.io.Serializable;

public class Programa extends Resultado implements Serializable {

    private String lenguajeEmpleado;
    private int numeroLineasCodigo;
    private int numeroModulos;

    public Programa(String identificadorResultado, int numHorasInvertidas, String opcion, String lenguajeEmpleado, int numeroLineasCodigo, int numeroModulos) {
        super(identificadorResultado, numHorasInvertidas, opcion);
        this.lenguajeEmpleado = lenguajeEmpleado;
        this.numeroLineasCodigo = numeroLineasCodigo;
        this.numeroModulos = numeroModulos;
    }

    public String getLenguajeEmpleado() {
        return lenguajeEmpleado;
    }

    public int getNumeroLineasCodigo() {
        return numeroLineasCodigo;
    }

    public int getNumeroModulos() {
        return numeroModulos;
    }

    @Override
    public String toString() {
        return "Programa {" +
                " lenguajeEmpleado = '" + lenguajeEmpleado + '\'' +
                ", numeroLineasCodigo = " + numeroLineasCodigo +
                ", numeroModulos = " + numeroModulos +
                " }";
    }
}
