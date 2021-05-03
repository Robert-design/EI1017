package Patrones;

public class Urgente implements Facturacion {

    private double porcentajeUrgente;

    public Urgente (double porcentajeUrgente) {
        super();
        this.porcentajeUrgente = porcentajeUrgente;
    }

    @Override
    public double coste(double coste) {
        return coste + (coste * (porcentajeUrgente / 100));
    }
}
