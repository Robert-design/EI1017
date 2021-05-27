package Vista;

import Controlador.implementacionControlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FormularioEliminarPersona {

    private JTextField nombreProyecto;
    private JTextField nombrePersona;
    private JTextField nombreTarea;
    private JCheckBox resp;
    private String esResponsable;
    private implementacionControlador controlador;
    private JFrame formularioPerso;
    private JButton eliminarPersona;

    public FormularioEliminarPersona(implementacionControlador controlador) {
        this.nombreProyecto = new JTextField(10);
        this.nombreTarea = new JTextField(10);
        this.nombrePersona = new JTextField(10);
        this.resp = new JCheckBox("¿Responsable? ");
        this.esResponsable = null;
        this.eliminarPersona = new JButton("Eliminar persona");

        this.controlador = controlador;
        formularioPerso = new JFrame("Eliminar persona de tarea");

        JLabel nombProy = new JLabel("Nombre Proyecto: ");
        JLabel nombTarea = new JLabel("Nombre Tarea: ");
        JLabel nombPerso = new JLabel("Nombre Persona: ");
        JLabel responsable = new JLabel("Responsable: ");

        formularioPerso.setLayout(new GridLayout(10,2));

        Container contenedor = formularioPerso.getContentPane();
        JPanel panel = new JPanel();
        panel.add(resp);

        contenedor.add(nombProy);
        contenedor.add(nombreProyecto);
        nombreProyecto.setEditable(false);
        nombreProyecto.setText(controlador.getModelo().getNombreProyecto());
        contenedor.add(nombTarea);
        contenedor.add(nombreTarea);
        contenedor.add(nombPerso);
        contenedor.add(nombrePersona);
        contenedor.add(responsable);
        contenedor.add(resp);
        contenedor.add(eliminarPersona);


        formularioPerso.pack();
        formularioPerso.setVisible(true);

        eliminarPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPersonaTarea();
            }
        });


    }
    private void eliminarPersonaTarea() {
        if(nombreProyecto.getText().length() > 0 && nombreTarea.getText().length() > 0 && nombrePersona.getText().length() > 0){
            System.out.println("Eliminando persona...");

            controlador.eliminarPersonaDeTarea(nombreProyecto.getText(),nombrePersona.getText(),nombreTarea.getText(),esResponsable);
        } else {
            System.out.println("Error añadiendo persona...");
        }
    }
}
