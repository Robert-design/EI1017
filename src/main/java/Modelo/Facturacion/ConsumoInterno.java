package Modelo.Facturacion;

public class ConsumoInterno implements Facturacion {

    public ConsumoInterno() {
        super();
    }

    @Override
    public double coste(double coste) {
        return coste;
    }
}