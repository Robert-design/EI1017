package Main;
import Controlador.implementacionControlador;
import  Vista.*;
import Modelo.impletaModelo;

import java.io.IOException;

public class Main {
    public static void main (String args[]) throws Exception {
        implementacionControlador controlador = new implementacionControlador();
        implementaVista vista = new implementaVista();
        impletaModelo modelo = new impletaModelo();

        vista.setModelo(modelo);
        vista.setControlador(controlador);
        controlador.setModelo(modelo);
        controlador.setVista(vista);
        controlador.cargarDatos();


        modelo.setVista(vista);
        modelo.setControlador(controlador);
        vista.run();



    }

}