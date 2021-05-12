package Modelo;
import Interfaces.utilidadesParaListas;
import Vista.*;

import java.util.Scanner;

public class impletaModelo implements interrogaModelo, cambioModelo {
    private Proyecto proy;
    private implementaVista vista;
    private cambioModelo modelo;

    @Override
    public Persona altaPersona() throws añadirPersonaATareaException, NoElementException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nombre de la persona: ");
        String nombrePersona = vista.getPersona();
        if (utilidadesParaListas.elementosInsertables(nombrePersona, proy.getListaPersonas())) {
            proy.añadirPersonaProyecto(nombrePersona);
            System.out.println("Persona dada de alta\n");
        }
        throw new NoElementException();
    }
}
