package Modelo.Facturacion;

import java.io.Serializable;

public class ConsumoInterno implements Facturacion, Serializable {

    public ConsumoInterno() {
        super();
    }

    @Override
    public double coste(double coste) {
        return coste;
    }
}
