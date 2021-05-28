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
    public impletaModelo getModelo() {
        return this.modelo;
    }

    public void setVista(implementaVista vista) {
        this.vista = vista;
    }

    public void guardarDatos(){
        try {
            modelo.guardarProyecto();
        } catch (IOException e) {
            System.out.println("Error al guardar datos.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarDatos() throws IOException {
        try {
            modelo.cargarProyecto();
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar datos.");;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void altaPersona(String nomProy, String persona) throws añadirPersonaATareaException, NoElementException {
       modelo.altaPersona(nomProy, persona);
    }

    @Override
    public void crearTarea(String nombreProyecto,String nombreTarea,String nombreResultado, double coste,String tipo, double porcentaje) {
        modelo.creaTarea(nombreProyecto, nombreTarea, nombreResultado, coste, tipo, porcentaje);
    }

    @Override
    public void marcarFinalizado(String nombreProyecto, String nombreTarea) {
        modelo.marcarFinalizado(nombreProyecto, nombreTarea);
    }

    @Override
    public void añadirPersonaATarea(String proyecto, String persona, String titulo, String resultado) {
       modelo.añadirPersonaTarea(proyecto, persona, titulo, resultado);
       //comentarios
    }

    @Override
    public void eliminarPersonaDeTarea(String proyecto, String tituloTarea, String personaNueva, String nuevaPersonaRespon) {
        modelo.eliminarPersonaTarea(proyecto, personaNueva, tituloTarea, nuevaPersonaRespon);
    }

    @Override
    public void listarPersonasProyecto(String nombreProyecto) {
        modelo.listarPersonas(nombreProyecto);
    }

    @Override
    public void listarTareasProyecto() {

    }

    @Override
    public void modificarTarea (String proyecto, double coste, double porcentaje, String titulo, String tipo) {
        modelo.modificarCoste(proyecto, coste, titulo);
        modelo.modificarFacturacion(proyecto, porcentaje, titulo, tipo);
    }

}
