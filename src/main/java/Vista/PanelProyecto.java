package Vista;

import javax.swing.*;
import Controlador.*;
import Modelo.impletaModelo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PanelProyecto extends JPanel {
    private implementacionControlador controlador;
    private impletaModelo modelo;
    private JTextField nombreProyecto;
    private JFrame vista;
    private JTextArea areaDatos = new JTextArea(30, 50);

    public PanelProyecto(implementacionControlador controlador, impletaModelo modelo, JFrame vista) throws IOException, ClassNotFoundException {
        this.controlador = controlador;
        this.modelo = modelo;
        this.vista = vista;

        JButton insertarProyecto = new JButton("Crear Proyecto");
        JButton añadirPersonaProy = new JButton("Añadir persona a  Proyecto");
        JLabel nombrePryecto = new JLabel("Nombre de Proyecto: ");
        nombreProyecto = new JTextField(30);

        JScrollPane panel = new JScrollPane(areaDatos);
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //rellenarInformacion(datos);
        //Añadimos los elementos

        JPanel linea = new JPanel();
        linea.add(nombrePryecto);
        linea.add(nombreProyecto);
        linea.add(insertarProyecto);

        JPanel linea3 = new JPanel();
        //linea.add(nombrePryecto);
        //linea.add(nombreProyecto);
        linea.add(añadirPersonaProy);

        JPanel linea2 = new JPanel();
        linea2.add(areaDatos);

        Container contenedor = new Container();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));
        contenedor.add(linea);
        contenedor.add(linea2);
        rellenarInformacion();
        add(contenedor);
        areaDatos.setForeground(Color.BLACK);
        areaDatos.setEditable(false);


        insertarProyecto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(nombreProyecto.getText());
                modelo.crearProyecto(nombreProyecto.getText());
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
