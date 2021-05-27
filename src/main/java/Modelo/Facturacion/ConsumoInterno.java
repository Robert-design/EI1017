package Modelo.Facturacion;

import java.io.Serializable;

public class ConsumoInterno implements Facturacion, Serializable {

    private String nombre;

    public ConsumoInterno() {
        super();
    }

    @Override
    public double coste(double coste) {
        return coste;
    }

    @Override
    public String getNombre() {
        return "Consumo interno";
    }
}
