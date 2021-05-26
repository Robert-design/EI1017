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
    private PanelProyecto panel;
    private PanelTarea panel2;
    //Private PanelPersona

    public void setModelo(impletaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(implementacionControlador controlador){
        this.controlador = controlador;
    }

    public void run() throws IOException, ClassNotFoundException {
        //controlador.cargarDatos();

        JFrame ventana = new JFrame("Gestión de Proyectos");
        ventana.setSize(30, 50); //.pack()
        Image icono = Toolkit.getDefaultToolkit().getImage("src/iconos/icono.png"); //Creamos una IMAGE
        ventana.setIconImage(icono); //Añadimos la IMAGE creada
        JTabbedPane tabs = new JTabbedPane();
        panel = new PanelProyecto(controlador,modelo,ventana);
        panel2 = new PanelTarea(controlador, modelo, ventana);
        tabs.add("Proyectos", panel );
        tabs.add("Tareas", panel2);
        ventana.add(tabs);
        ventana.add(tabs);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

