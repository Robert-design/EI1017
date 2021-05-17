package Modelo.Tarea;

import Modelo.Tarea.Resultado;

import java.io.Serializable;

public class PaginaWeb extends Resultado implements Serializable {

    private String tipo; //Estática o Dinámica
    private String lenguaje; // Lenguaje de programación
    private String back_end;

    public PaginaWeb(String identificadorResultado, int numHorasInvertidas, String opcion, String tipo, String lenguaje, String back_end) {
        super(identificadorResultado, numHorasInvertidas, opcion);
        this.tipo = tipo;
        this.lenguaje = lenguaje;
        this.back_end = back_end;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public String getBack_end() {
        return back_end;
    }

    @Override
    public String toString() {
        return "Página web {" +
                " Tipo = '" + tipo + '\'' +
                ", Lenguaje = " + lenguaje +
                ", Back end = " + back_end +
                " }";
    }
}
