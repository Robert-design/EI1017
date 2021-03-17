package Proyecto;

public class Documentacion extends Resultado {
    private String formato; //Word, PDF, texto plano...
    private int numPaginas;
    private float espacioDisco; //Float porque puede dar ¿8,4MB?

    public Documentacion () {
        super();
    }
}
