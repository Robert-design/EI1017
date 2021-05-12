package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controlador.implementacionControlador;


public class Escuchador implements ActionListener {
    private implementacionControlador controlador;
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton1 = (JButton) e.getSource();
        String text = boton1.getText();
        if(text.equals("Nuevo"))
            controlador.addEntrance();
        else if(text.equals("Avanzar"))
            controlador.forward();
        else if(text.equals("Atrás"))
            controlador.backwards();
    }
}
