package Patrones;

public class ConsumoInterno implements Facturacion {

    @Override
    public double coste(double coste, double porcentaje) {
        return coste * 1;
    }
}
