package Patrones;

public class urgente implements precio{
    @Override
    public double coste(double coste, double porcentaje) {
        return coste * porcentaje;
    }
}
