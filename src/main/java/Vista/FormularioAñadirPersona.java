package Vista;

import javax.swing.*;
import  Controlador.*;
import Modelo.NoElementException;
import Modelo.añadirPersonaATareaException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FormularioAñadirPersona {
    private JTextField nombrePersona;
    private JTextField nombreProyecto;
    private JFrame formulario;
    private JButton añadir;
    private implementacionControlador controlador;

    public FormularioAñadirPersona(implementacionControlador controlador) {
        this.controlador = controlador;
        this.nombrePersona = new JTextField(25);
        this.formulario = new JFrame("Añadir persona");
        this.nombreProyecto = new JTextField(25);
        JLabel nombrePers = new JLabel("Nombre de la persona: ");
        añadir = new JButton("Añadir persona");

        //Creamos tabla fila x col
        formulario.setLayout(new GridLayout(5,2));

        //Contenedor
        Container contenedor = formulario.getContentPane();

        //añadimos
        contenedor.add(nombrePers);
        contenedor.add(nombrePersona);
        nombrePersona.setEditable(true);
        contenedor.add(añadir);

        contenedor.add(nombreProyecto);
        nombreProyecto.setEditable(false);
        nombreProyecto.setText(controlador.getModelo().getNombreProyecto());

        formulario.pack();
        formulario.setVisible(true);

        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    insertarPersona();
                } catch (Modelo.añadirPersonaATareaException añadirPersonaATareaException) {
                    añadirPersonaATareaException.printStackTrace();
                } catch (NoElementException noElementException) {
                    noElementException.printStackTrace();
                }
            }
        });
    }

    private void insertarPersona() throws añadirPersonaATareaException, NoElementException {
        if (nombrePersona.getText().length() > 0){
            String nombre = String.valueOf(nombrePersona.getText());

            System.out.println("Añadiendo persona...");

            controlador.altaPersona(nombreProyecto.getText(),nombrePersona.getText());
        } else {
            System.out.println("Error añadiendo persona...");
        }
    }
}
