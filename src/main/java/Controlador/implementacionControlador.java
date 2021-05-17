package Controlador;
import Modelo.Excepciones.NoElementException;
import Modelo.Excepciones.añadirPersonaATareaException;
import Modelo.Proyecto;
import Vista.*;

import Modelo.*;
public class implementacionControlador implements Controlador {
    private implementaVista vista;
    private Proyecto proyecto;
    private impletaModelo modelo;
    @Override
    public void altaPersona() throws añadirPersonaATareaException, NoElementException {
        String persona = vista.getPersona();
        modelo.altaPersona();
    }

    @Override
    public void crearTarea() {

    }

    @Override
    public void marcarFinalizado() {

    }

    @Override
    public void introducirPersonaATarea() {

    }

    @Override
    public void eliminarPersonaDeTarea() {

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
