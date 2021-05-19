package Main;
import Controlador.implementacionControlador;
import  Vista.*;
import Modelo.impletaModelo;
public class Main {
    public static void main (String args[]) {
        implementacionControlador controlador = new implementacionControlador();
        implementaVista vista = new implementaVista();
        impletaModelo modelo = new impletaModelo();

        vista.setModelo(modelo);
        vista.setControlador(controlador);
        controlador.setModelo(modelo);
        controlador.setVista(vista);
        modelo.setVista(vista);
        modelo.setControlador(controlador);

        vista.run();

    }

}