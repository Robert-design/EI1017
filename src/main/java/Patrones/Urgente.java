package Patrones;

public class Urgente implements Facturacion {

    @Override
    public double coste(double coste, double porcentaje) {
        return coste + (coste * (porcentaje / 100));
    }
}
