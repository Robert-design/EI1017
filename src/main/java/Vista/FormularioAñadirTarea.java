package Vista;

import javax.swing.*;
import  Controlador.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioAñadirTarea {
    private JTextField nombreProyecto;
    private JTextField nombreTarea;
    private JTextField resultadoTarea;
    private JTextField precio;
    private JTextField tipoFAC;
    private JTextField porcentaje;
    private JFrame formulario;
    private JButton añadir;
    private implementacionControlador controlador;

    public FormularioAñadirTarea(implementacionControlador controlador) {
        this.controlador = controlador;
        this.nombreProyecto = new JTextField(25);
        this.nombreTarea = new JTextField(25);
        this.resultadoTarea = new JTextField(2);
        this.precio = new JTextField(10);
        this.tipoFAC = new JTextField(10);
        this.porcentaje = new JTextField(4);

        this.formulario = new JFrame("Añadir Tarea");
        JLabel nombreProy = new JLabel("Nombre del Proyecto: ");
        JLabel nombreTar = new JLabel("Nombre de la Tarea: ");
        JLabel resultado = new JLabel("Resultado: ");
        JLabel coste = new JLabel("Precio de la Tarea: ");
        JLabel facturacion = new JLabel("Tipo de Facturación: ");
        JLabel label_porcentage = new JLabel("Porcentaje: ");
        añadir = new JButton("Añadir Tarea");

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
        contenedor.add(resultado);
        contenedor.add(resultadoTarea);
        contenedor.add(coste);
        contenedor.add(precio);
        contenedor.add(facturacion);
        contenedor.add(tipoFAC);
        contenedor.add(label_porcentage);
        contenedor.add(porcentaje);
        contenedor.add(añadir);


        formulario.pack();
        formulario.setVisible(true);

        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarTarea();
            }
        });

    }

    private void insertarTarea() {
        if(nombreProyecto.getText().length() > 0 && nombreTarea.getText().length() > 0 && resultadoTarea.getText().length() > 0){
            int coste = Integer.valueOf(String.valueOf(precio.getText()));
            int porcen = Integer.valueOf(String.valueOf(porcentaje.getText()));

            System.out.println("Añadiendo Tarea...");

            controlador.crearTarea(nombreProyecto.getText(),nombreTarea.getText(),resultadoTarea.getText(),coste,tipoFAC.getText(),porcen);
        } else {
            System.out.println("Error añadiendo tarea...");
        }
    }
}
