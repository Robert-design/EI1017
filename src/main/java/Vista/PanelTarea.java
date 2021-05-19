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

    public PanelTarea(implementacionControlador controlador, impletaModelo modelo, JFrame vista) throws IOException, ClassNotFoundException {
        this.controlador = controlador;
        this.modelo = modelo;
        this.vista = vista;
        JFrame prueba = new JFrame("Gestión de Proyectos");
        prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JToolBar toolBar = new JToolBar();
        toolBar.setRollover(true);
        JButton boton1 = new JButton("Probamos");
        toolBar.addSeparator();
        toolBar.add(new Button("Menú"));
        toolBar.add(new JComboBox(new String[]{"Añadir Tarea","Añadir Persona","Eliminar Persona","Marcar Finalizado"}));
        Container contentPane = prueba.getContentPane();
        contentPane.add(toolBar,BorderLayout.NORTH);
        JTextArea areaTexto = new JTextArea();
        JScrollPane miPanel = new JScrollPane(areaTexto);
        contentPane.add(miPanel,BorderLayout.EAST);
        prueba.setSize(450,450);
        prueba.setVisible(true);

    }
}
