package Vista;
import Controlador.*;
import Modelo.interrogaModelo;
public class implementaVista implements informaVista, interrogaVista {
     private Controlador controlador;
     private interrogaModelo modelo;

    @Override
    public void actualEntranceChange() {

    }

    @Override
    public void newEntrance() {
        String entranceState = "Número de entradas: " +
        modelo.getActualEntrancePosition() + " de" +
        modelo.getEntranceNumbers();
    }

    @Override
    public String getEntrance() {
        return modelo.getActualEntrance() ;
    }
}
