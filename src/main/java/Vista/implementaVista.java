package Vista;
import Controlador.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
public class implementaVista implements informaVista, interrogaVista {
    private Controlador controlador;
    private interrogaModelo modelo;

    public void setModelo(interrogaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(Controlador controlador){
        this.controlador = controlador;
    }

    private void GUI() {
        JFrame ventana = new JFrame("Modelo/Vista/Controlador");
        Container contenedor = ventana.getContentPane();
        JPanel jpEntrada = new JPanel();
        JPanel jpContador = new JPanel();
        JTextField jtfNombre = new JTextField(20);
        //EscuchadorOpcion1 escuchador = new EscuchadorOpcion1();
        JButton jbMenu = new JButton("Menú");
        //jbNuevo.addActionListener(escuchador);
        JButton jbAceptar = new JButton("Aceptar");
        //jbAtras.addActionListener(escuchador);
        JButton jbSalir = new JButton("Salir");
        // jbAdelante.addActionListener(escuchador);
        //JLabel jlContador = new JLabel(infoEstadoEntradas());
        jpEntrada.add(jtfNombre);
        jpEntrada.add(jbMenu);
        jpEntrada.add(jbAceptar);
        jpEntrada.add(jbSalir);
        //jpContador.add(jlContador);
        contenedor.add(jpEntrada, BorderLayout.NORTH);
        contenedor.add(jpContador, BorderLayout.SOUTH);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }


    public void creaGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI();
            }
        });
    }

    @Override
    public String getPersona() {
        return modelo.getPersona();
    }

    @Override
    public String getNombreProyecto() {
        return modelo.getNombreProyecto();
    }


    public class Escuchador implements ActionListener {
        private implementacionControlador controlador;

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton1 = (JButton) e.getSource();
            String text = boton1.getText();
            /*if(text.equals("Nuevo"))
                //controlador.nuevoProyecto();
           /* else if(text.equals("Aceptar"))
                //controlador.forward();

           else if(text.equals("Salir"))
                System.exit(0);
                */
        }
    }

}

