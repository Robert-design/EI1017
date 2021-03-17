package Proyecto;

public class Programa extends Resultado {

    private String lenguajeEmpleado;
    private int numeroLineasCodigo;
    private int numeroModulos;

    public Programa () {
        super();
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
}
