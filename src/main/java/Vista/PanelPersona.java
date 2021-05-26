package Vista;

import Controlador.*;
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


        JButton buscarPersonaProyecto = new JButton("Buscar persona");
        JButton insertarPersona = new JButton("Añadir persona");

        JLabel nombrePersona = new JLabel("Nombre de la persona");
        nombre = new JTextField(30);

        JScrollPane panel = new JScrollPane(areaDatos);
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JPanel boton1 = new JPanel();
        boton1.add(nombrePersona);
        boton1.add(nombre);
        boton1.add(buscarPersonaProyecto);

        JPanel boton2 = new JPanel();
        boton1.add(insertarPersona);

        JPanel recuadroDatos = new JPanel();
        recuadroDatos.add(areaDatos);

        Container contenedor = new Container();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));
        contenedor.add(boton1);
        contenedor.add(boton2);
        contenedor.add(recuadroDatos);

        rellenarInformacion();
        //add(contenedor);
        areaDatos.setForeground(Color.BLACK);
        areaDatos.setEditable(false);


        buscarPersonaProyecto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(nombre.getText());
                modelo.getPersona();
                rellenarInformacion();
            }
        });
    }


    public void rellenarInformacion() {
        System.out.println("rellenarInformacion");
        areaDatos.setText("");
        areaDatos.append(modelo.obtenerInfo());
    }
}