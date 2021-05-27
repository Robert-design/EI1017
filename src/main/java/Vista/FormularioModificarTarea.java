package Vista;

import javax.swing.*;
import  Controlador.*;
import Modelo.NoElementException;
import Modelo.añadirPersonaATareaException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class FormularioModificarTarea {

    private JTextField nombreProyecto;
    private JTextField nombreTarea;
    private JTextField precio;
    private JTextField tipoFAC;
    private JTextField porcentaje;
    private JFrame formulario;
    private JButton modificar;
    private JCheckBox marcar;
    private implementacionControlador controlador;

    public FormularioModificarTarea(implementacionControlador controlador) {
        this.controlador = controlador;
        this.nombreProyecto = new JTextField(25);
        this.nombreTarea = new JTextField(25);
        this.precio = new JTextField(10);
        this.tipoFAC = new JTextField(10);
        this.porcentaje = new JTextField(4);
        this.marcar = new JCheckBox("Marcar como finalizada");

        this.formulario = new JFrame("Modificar tarea");
        JLabel nombreProy = new JLabel("Nombre del proyecto: ");
        JLabel nombreTar = new JLabel("Nombre de la tarea: ");
        JLabel coste = new JLabel("Precio de la tarea: ");
        JLabel facturacion = new JLabel("Tipo de facturación: ");
        JLabel label_porcentage = new JLabel("Porcentaje: ");
        modificar = new JButton("Modificar tarea");

        //añadimos icono?

        //Creamos tabla fila x col
        formulario.setLayout(new GridLayout(10,2));

        //Contenedor
        Container contenedor = formulario.getContentPane();

        //añadimos
        contenedor.add(nombreProy);
        contenedor.add(nombreProyecto);
        nombreProyecto.setEditable(false);
        nombreProyecto.setText(controlador.getModelo().getNombreProyecto());
        contenedor.add(nombreTar);
        contenedor.add(nombreTarea);
        contenedor.add(coste);
        contenedor.add(precio);
        contenedor.add(facturacion);
        contenedor.add(tipoFAC);
        contenedor.add(label_porcentage);
        contenedor.add(porcentaje);
        contenedor.add(modificar);
        contenedor.add(marcar);

        formulario.pack();
        formulario.setVisible(true);

        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarTarea();
            }
        });

        marcar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (marcar.isSelected()) {
                    System.out.println(nombreProyecto.getText());
                    controlador.marcarFinalizado(nombreProyecto.getText(), nombreTarea.getText());
                }
            }
        });

        /*marcar.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                switch (e.getStateChange()) {//Preguntamos al evento
                    case ItemEvent.SELECTED:
                        controlador.marcarFinalizado(nombreProy.getText(), nombreTarea.getText());
                        break;
                    /*case ItemEvent.DESELECTED:
                       esResponsable;

                        break;
                }
            }
        });*/
    }

    private void modificarTarea() {
        if(nombreProyecto.getText().length() > 0 && nombreTarea.getText().length() > 0){
            int coste = Integer.valueOf(String.valueOf(precio.getText()));
            int porcen = Integer.valueOf(String.valueOf(porcentaje.getText()));

            System.out.println("Modificando tarea...");

            controlador.modificarTarea(nombreProyecto.getText(),coste, porcen, nombreTarea.getText(), tipoFAC.getText());
        } else {
            System.out.println("Error modificando tarea...");
        }
    }
}
