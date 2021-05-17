package Vista;

import javax.swing.*;
import Controlador.*;
import Modelo.impletaModelo;
public class PanelTarea extends JPanel {
    private implementacionControlador controlador;
    private impletaModelo modelo;
    private JTextArea areaTarea = new JTextArea(20, 10);
    private JTextField correoPersona;
    private JFrame vista;

    public PanelTarea(implementacionControlador controlador, impletaModelo modelo, JFrame vista){
        this.controlador = controlador;
        this.modelo = modelo;
        this.vista = vista;
        JButton buscarTarea = new JButton("Buscar Tarea");
        JButton insertarTarea = new JButton("Añadir Tarea");
        JButton borrarTarea = new JButton("Borrar tarea");
        JButton editarCoste = new JButton("Editar Coste");
        JButton editarFacturacion = new JButton("Editar Facturación");

        JLabel correo = new JLabel("Correo del cliente: ");
        correoPersona = new JTextField(10);

        String datos = "metodo modelo";
        JScrollPane panel = new JScrollPane(areaTarea);
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    }
}
