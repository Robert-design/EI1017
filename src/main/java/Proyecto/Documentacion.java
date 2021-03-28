package Proyecto;

public class Documentacion extends Resultado {


    private String formato; //Word, PDF, texto plano...
    private int numPaginas;
    private double espacioDisco; //Float porque puede dar 8,4MB

    public Documentacion(String identificadorResultado, int numHorasInvertidas, String opcion, String formato, int numPaginas, double espacioDisco) {
        super(identificadorResultado, numHorasInvertidas, opcion);
        this.formato = formato;
        this.numPaginas = numPaginas;
        this.espacioDisco = espacioDisco;
    }

    public String getFormato() {
        return formato;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public double getEspacioDisco() {
        return espacioDisco;
    }

    @Override
    public String toString() {
        return "Documentacion {" +
                " Formato = '" + formato + '\'' +
                ", numPaginas = " + numPaginas +
                ", espacioDisco = " + espacioDisco +
                " }";
    }
}
