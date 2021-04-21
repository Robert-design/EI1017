package Patrones;

public class descuento implements precio{

    @Override
    public double coste(double coste, double porcentaje) {
        return  coste * porcentaje;
    }
}
