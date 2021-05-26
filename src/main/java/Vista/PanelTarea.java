package Vista;

import Controlador.implementacionControlador;
import Modelo.Proyecto;
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


        JButton buscarTareasProyecto = new JButton("Seleccionar Proyecto"); //listar Tareas?
        JButton insertarTarea = new JButton("Añadir Tarea");
        JButton insertarPersonaTarea = new JButton("Añadir persona a tarea");
        JButton eliminarPersonaTarea = new JButton("Eliminar Persona de  Tarea");
        JButton marcarFinalizada = new JButton("Marcar Finalizada");
        JButton añadirPersona = new JButton("Añadir Persona");
        JButton Guardar = new JButton("Guardar");

        JLabel nombreProyecto = new JLabel("Nombre de proyecto");
        nombre = new JTextField(10);


        JScrollPane panel = new JScrollPane(areaDatos);
        panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        JPanel boton1 = new JPanel();
        boton1.add(nombreProyecto);
        boton1.add(nombre);
        boton1.add(buscarTareasProyecto);
        boton1.add(añadirPersona);
        boton1.add(Guardar);

        JPanel boton2 = new JPanel();
        boton2.add(insertarTarea);
        boton2.add(insertarPersonaTarea);
        boton2.add(eliminarPersonaTarea);
        boton2.add(marcarFinalizada);

        JPanel recuadroDatos = new JPanel();
        recuadroDatos.add(areaDatos);

        Container contenedor = new Container();
        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));;
        contenedor.add(boton1);
        contenedor.add(boton2);

        contenedor.add(recuadroDatos);

        //rellenarInformacion();
        add(contenedor);
        areaDatos.setForeground(Color.BLACK);
        areaDatos.setEditable(false);
        insertarTarea.setEnabled(false);
        insertarPersonaTarea.setEnabled(false);
        eliminarPersonaTarea.setEnabled(false);
        marcarFinalizada.setEnabled(false);

        buscarTareasProyecto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(nombre.getText());
                Proyecto proyecto =modelo.buscarProyecto(nombre.getText());
                System.out.println(proyecto.mostrarTareas());

                rellenarInformacion(proyecto.mostrarTareas());
                insertarTarea.setEnabled(true);
                insertarPersonaTarea.setEnabled(true);
                eliminarPersonaTarea.setEnabled(true);
                marcarFinalizada.setEnabled(true);
                modelo.setProyectoNombre(nombre.getText());
            }
        });

        insertarTarea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormularioAñadirTarea(controlador);
            }
        });
        Guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    modelo.guardarProyecto();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
    public void rellenarInformacion() {
        System.out.println("rellenarInformacion");
        areaDatos.setText("");
        areaDatos.append(modelo.obtenerInfo());

    }
    public void rellenarInformacion(String datos) {
        System.out.println("rellenarInformacion");
        areaDatos.setText("");
        areaDatos.append(datos);

    }

}
