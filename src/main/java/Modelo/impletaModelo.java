package Modelo;
import Vista.informaVista;
public class impletaModelo implements interrogaModelo, cambioModelo {
    private Proyecto proy;
    private informaVista vista;
    private cambioModelo modelo;
    @Override
    public void addEntrance(String entrance) {
        modelo.addEntrance(entrance);
    }

    @Override
    public void incrementsActualPosition() {
        ///proy.listarPersonasProyecto();
    }

    @Override
    public void decrementsActualPosition() {

    }

    @Override
    public int getEntranceNumbers() {
        return 0;
    }

    @Override
    public String getActualEntrance() {
        return null;
    }

    @Override
    public int getActualEntrancePosition() {
        return 0;
    }
}
