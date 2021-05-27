package Modelo.Facturacion;

import java.io.Serializable;

public class Urgente implements Facturacion, Serializable {

    private double porcentajeUrgente;
    private String nombre;
    public Urgente (double porcentajeUrgente) {
        super();
        this.porcentajeUrgente = porcentajeUrgente;
    }

    @Override
    public double coste(double coste) {
        return coste + (coste * (porcentajeUrgente / 100));
    }

    public String getNombre() {
        return "Urgente";
    }
}
