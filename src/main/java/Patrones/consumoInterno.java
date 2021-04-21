package Patrones;

public class consumoInterno implements precio {
    @Override
    public double coste(double coste, double porcentaje) {
        return coste * porcentaje;
    }
}
