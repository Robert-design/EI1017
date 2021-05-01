package Patrones;

public class Descuento implements Facturacion {

    @Override
    public double coste(double coste, double porcentaje) {
        return  coste - (coste * (porcentaje / 100));
    }
}
