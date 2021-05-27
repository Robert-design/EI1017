package Vista;

import Controlador.*;
import Modelo.Persona;
import Modelo.Proyecto;
import Modelo.impletaModelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPersona extends JPanel {

    private implementacionControlador controlador;
    private impletaModelo modelo;
    private JFrame vista;
    private JTextField nombre;
    private JTextArea areaDatos = new JTextArea(30, 50);

    public PanelPersona(implementacionControlador controlador, impletaModelo modelo, JFrame vista) {
        this.controlador = controlador;
        this.modelo = modelo;
        this.vista = vista;


        JLabel nombreProyecto = new JLabel("Nombre de proyecto");
        nombre = new JTextField(10);
        JButton buscarPersonas = new JButton("Listar personas del proyecto");


        JScrollPane panel = new JScrollPane(areaDatos);
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JPanel boton1 = new JPanel();
        boton1.add(nombreProyecto);
        boton1.add(nombre);
        boton1.add(buscarPersonas);

        JPanel recuadroDatos = new JPanel();
        recuadroDatos.add(areaDatos);

        Container contenedor = new Container();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));
        contenedor.add(boton1);
        contenedor.add(recuadroDatos);

        add(contenedor);
        areaDatos.setForeground(Color.BLACK);
        areaDatos.setEditable(false);


       buscarPersonas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rellenarInformacion2();
            }
        });
    }


    public void rellenarInformacion2() {
        System.out.println("rellenarInformacion");
        areaDatos.setText("");
        Proyecto proyecto = modelo.buscarProyecto(nombre.getText());
        for (Persona p : proyecto.getListaPersonas())
            areaDatos.append(p.getClave() + "\t");
    }

}