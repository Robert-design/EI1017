package Vista;
import Controlador.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Modelo.*;
public class implementaVista implements informaVista, interrogaVista {
    private implementacionControlador controlador;
    private impletaModelo modelo;
    private JFrame window = new JFrame("Gestión de Proyectos");
    //private Panelproyecto
    //private PanelTarea
    //Private PanelPersona

    public void setModelo(impletaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(implementacionControlador controlador){
        this.controlador = controlador;
    }

    public void run() throws IOException, ClassNotFoundException {
        new PanelTarea(controlador,modelo,window);
        controlador.cargarDatos();
    }


    @Override
    public String getPersona() {
        return modelo.getPersona();
    }

    @Override
    public String getNombreProyecto() {
        return modelo.getNombreProyecto();
    }



}

