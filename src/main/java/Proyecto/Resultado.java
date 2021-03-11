package Proyecto;

public class Resultado {
    private String identificadorResultado;
    private int numHorasInvertidas;
    private String opcion; //Interno o comercializado, de esto no estoy muy seguro

    public Resultado (String identificadorResultado, int numHorasInvertidas, String opcion) {
        super();
        this.identificadorResultado = identificadorResultado;
        this.numHorasInvertidas = numHorasInvertidas;
        this.opcion =opcion;
    }

    public String getIdentificadorResultado() { return this.identificadorResultado; } //Devuelve el ID

    public int getNumHorasInvertidas() { return this.numHorasInvertidas; } //Devuelve horas

    public String getOpcion() { return this.opcion; } // Devuelve op
}
