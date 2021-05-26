package Vista;

import Controlador.implementacionControlador;
import Modelo.impletaModelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTarea extends JPanel {
    private implementacionControlador controlador;
    private impletaModelo modelo;
    private JFrame vista;
    private JTextField nombre;
    private JTextArea areaDatos = new JTextArea(30, 50);

    public PanelTarea (implementacionControlador controlador, impletaModelo modelo, JFrame vista) {
        this.controlador = controlador;
        this.modelo = modelo;
        this.vista = vista;


        JButton buscarTareasProyecto = new JButton("Buscar Tareas"); //listar Tareas?
        JButton insertarTarea = new JButton("Añadir Tarea");
        JButton insertarPersonaTarea = new JButton("Añadir persona a tarea");
        JButton eliminarPersonaTarea = new JButton("Eliminar Persona de  Tarea");
        JButton marcarFinalizada = new JButton("Marcar Finalizada");

        JLabel nombreProyecto = new JLabel("Nombre de proyecto");
        nombre = new JTextField(30);


        JScrollPane panel = new JScrollPane(areaDatos);
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        JPanel boton1 = new JPanel();
        boton1.add(nombreProyecto);
        boton1.add(nombre);
        boton1.add(buscarTareasProyecto);

        JPanel boton2 = new JPanel();
       //boton1.add(nombre);
        //boton1.add(nombreProyecto); //Esto tal vez no vaya aquí. Es solo para mostrar el boton de momento
        boton1.add(insertarTarea);

        JPanel boton3 = new JPanel();
        //boton1.add(nombre);
        //boton1.add(nombreProyecto); //Esto tal vez no vaya aquí. Es solo para mostrar el boton de momento
        boton1.add(insertarPersonaTarea);

        JPanel boton4 = new JPanel();
        //boton1.add(nombre);
        //boton1.add(nombreProyecto); //Lo mismo que en la linea 41
        boton1.add(eliminarPersonaTarea);

        JPanel boton5 = new JPanel();
        //boton1.add(nombre);
        //boton1.add(nombreProyecto);
        boton1.add(marcarFinalizada);

        JPanel recuadroDatos = new JPanel();
        recuadroDatos.add(areaDatos);

        Container contenedor = new Container();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));;
       /*contenedor.add(nombreProyecto);
        contenedor.add(nombre);*/ //
        contenedor.add(boton1);
        contenedor.add(boton2);
        contenedor.add(boton3);
        contenedor.add(boton4);
        contenedor.add(boton5);
        contenedor.add(recuadroDatos);

        rellenarInformacion();
        add(contenedor);
        areaDatos.setForeground(Color.BLACK);
        areaDatos.setEditable(false);

        buscarTareasProyecto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(nombre.getText());
                modelo.buscarProyecto(nombre.getText());
                rellenarInformacion();
            }
        });

        insertarTarea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(nombre.getText());
                //modelo.insertarTarea(nombre.getText());
                rellenarInformacion();
            }
        });

        buscarTareasProyecto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(nombre.getText());
                modelo.buscarProyecto(nombre.getText());
                rellenarInformacion();
            }
        });


    }
    public void rellenarInformacion() {
        System.out.println("rellenarInformacion");
        areaDatos.setText("");
        areaDatos.append(modelo.obtenerInfo());

    }

}
