package Vista;

import javax.swing.*;
import Controlador.*;
import Modelo.impletaModelo;

import java.awt.*;
import java.io.IOException;

public class PanelTarea extends JPanel {
    private implementacionControlador controlador;
    private impletaModelo modelo;
    private JTextArea areaTarea = new JTextArea(20, 10);
    private JTextField correoPersona;
    private JFrame vista;
    private JTextArea areaDatos = new JTextArea(20, 10);

    public PanelTarea(implementacionControlador controlador, impletaModelo modelo, JFrame vista) throws IOException, ClassNotFoundException {
        this.controlador = controlador;
        this.modelo = modelo;
        this.vista = vista;

        JButton bBuscarCliente = new JButton("Buscar Cliente");
        JLabel jDNI = new JLabel("DNI del cliente: ");
        correoPersona = new JTextField(10);

        JScrollPane panel = new JScrollPane(areaDatos);
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //rellenarInformacion(datos);
        //Añadimos los elementos

        JPanel panelDNI = new JPanel();
        panelDNI.add(jDNI);
        panelDNI.add(correoPersona);

        Container contenedor = new Container();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));
        JPanel panelOption = new JPanel();
        panelOption.add(panelDNI);
        contenedor.add(panelOption);
        add(contenedor);





    }
    public void rellenarInformacion(String datos) {
        areaDatos.setText("");
        areaDatos.append(datos);

    }
}
