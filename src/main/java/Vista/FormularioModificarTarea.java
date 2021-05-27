package Vista;

import javax.swing.*;
import  Controlador.*;
import Modelo.NoElementException;
import Modelo.añadirPersonaATareaException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FormularioModificarTarea {

    private JTextField nombrePersona;
    private JTextField nombreProyecto;
    private JFrame formulario;
    private JButton modificar;
    private implementacionControlador controlador;

    public FormularioModificarTarea(implementacionControlador controlador) {
        this.controlador = controlador;
        this.nombrePersona = new JTextField(25);
        this.formulario = new JFrame("Añadir persona");
        this.nombreProyecto = new JTextField(25);
        JLabel nombrePers = new JLabel("Nombre de la persona: ");
        modificar = new JButton("Modificar tarea");
    }
}
