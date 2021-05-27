package Vista;

import Controlador.implementacionControlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FormularioAñadirPersonaTarea {
    private JTextField nombreProyecto;
    private JTextField nombrePersona;
    private JTextField nombreTarea;
    private JCheckBox resp;
    private String esResponsable;
    private implementacionControlador controlador;
    private JFrame formularioPerso;
    private JButton añadirPersona;

    public FormularioAñadirPersonaTarea(implementacionControlador controlador) {
        this.nombreProyecto = new JTextField(10);
        this.nombreTarea = new JTextField(10);
        this.nombrePersona = new JTextField(10);
        this.resp = new JCheckBox("¿Responsable? ");
        this.esResponsable = null;
        this.añadirPersona = new JButton("Añadir Persona");

        this.controlador = controlador;
        formularioPerso = new JFrame("Añadir Persona a Tarea");

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
        contenedor.add(añadirPersona);


        formularioPerso.pack();
        formularioPerso.setVisible(true);

        añadirPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarPersonaTarea();
            }
        });

        resp.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                switch (e.getStateChange()) {//Preguntamos al evento
                    case ItemEvent.SELECTED:
                        esResponsable = "Y";
                        break;
                    /*case ItemEvent.DESELECTED:
                       esResponsable;

                        break;*/
                }
            }
        });
        
    }
    private void insertarPersonaTarea() {
        if(nombreProyecto.getText().length() > 0 && nombreTarea.getText().length() > 0 && nombrePersona.getText().length() > 0){
            System.out.println("Añadiendo persona...");

            controlador.añadirPersonaATarea(nombreProyecto.getText(),nombrePersona.getText(),nombreTarea.getText(),esResponsable);
        } else {
            System.out.println("Error añadiendo persona...");
        }
    }
}
