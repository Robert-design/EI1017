package Controlador;
import Modelo.Excepciones.NoElementException;
import Modelo.Excepciones.añadirPersonaATareaException;
import Vista.*;

import Modelo.*;
public class implementacionControlador implements Controlador {
    private implementaVista vista;
    private impletaModelo modelo;
    @Override
    public void altaPersona() throws añadirPersonaATareaException, NoElementException {
        String persona = vista.getPersona();
        modelo.altaPersona();
    }

    @Override
    public void crearTarea() {
    String proyecto = vista.getNombreProyecto();
    modelo.creaTarea();
    }

    @Override
    public void marcarFinalizado() {
        //String proyecto = vista.getNombreProyecto();
        modelo.marcarFinalizado();
    }

    @Override
    public void introducirPersonaATarea() {
        String proyecto = vista.getNombreProyecto();
        modelo.añadirPersonaTarea();
    }

    @Override
    public void eliminarPersonaDeTarea() {
        String proyecto = vista.getNombreProyecto();
        modelo.getNombreProyecto();
    }

    @Override
    public void listarPersonasProyecto() {

    }

    @Override
    public void listarTareasProyecto() {

    }

    @Override
    public void modificarCoste() {

    }

    @Override
    public void modificarFacturación() {

    }

    @Override
    public void importeTotal() {

    }
}
