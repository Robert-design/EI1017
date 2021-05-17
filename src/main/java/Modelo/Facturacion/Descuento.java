package Modelo.Facturacion;

public class Descuento implements Facturacion {

    private double porcentajeDescuento;

    public Descuento (double porcentajeDescuento) {
        super();
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double coste(double coste) {
        return  coste - (coste * (porcentajeDescuento / 100));
    }
}
