package Proyecto;

import java.io.Serializable;

public class Resultado implements Serializable {
    private String identificadorResultado;
    private int numHorasInvertidas;
    private String opcion; //Interno o comercializado

    public Resultado(String identificadorResultado, int numHorasInvertidas, String opcion) {
        super();
        this.identificadorResultado = identificadorResultado;
        this.numHorasInvertidas = numHorasInvertidas;
        this.opcion = opcion;
    }

    public String getIdentificadorResultado() { return this.identificadorResultado; }

    public int getNumHorasInvertidas() { return this.numHorasInvertidas; }

    public String getOpcion() { return this.opcion; }
}
