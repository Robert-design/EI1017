package Modelo.Facturacion;

import java.io.Serializable;

public class Descuento implements Facturacion, Serializable {

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
