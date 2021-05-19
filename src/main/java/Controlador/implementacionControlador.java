package Controlador;
import Modelo.NoElementException;
import Modelo.añadirPersonaATareaException;
import Vista.*;

import Modelo.*;

import java.io.IOException;

public class implementacionControlador implements Controlador {
    private implementaVista vista;
    private impletaModelo modelo;

    public void setModelo(impletaModelo modelo) {
        this.modelo = modelo;
    }

    public void setVista(implementaVista vista) {
        this.vista = vista;
    }

    public void guardarDatos(){
        try {
            modelo.guardarProyecto();
        } catch (IOException e) {
            System.out.println("Error al guardar datos.");
        }
    }

    public void cargarDatos() throws IOException {
        try {
            modelo.cargarProyecto();
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar datos.");;
        }
    }

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
