package Vista;
import Controlador.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Modelo.*;
public class implementaVista  implements informaVista, interrogaVista {
    private implementacionControlador controlador;
    private impletaModelo modelo;
    private PanelTarea panel;
    //private PanelTarea
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
        ventana.setSize(400, 400); //.pack()
        Image icono = Toolkit.getDefaultToolkit().getImage("src/iconos/icono.png"); //Creamos una IMAGE
        ventana.setIconImage(icono); //Añadimos la IMAGE creada
        JTabbedPane pestanyas = new JTabbedPane();
        panel = new PanelTarea(controlador,modelo,ventana);

        pestanyas.add("Proyectos",panel );
        ventana.add(pestanyas);
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

