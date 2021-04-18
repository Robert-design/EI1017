package Proyecto;

import Excepciones.añadirPersonaATareaException;
import Excepciones.añadirTareaExistenteException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {

    @Test
    void listarPersonasProyecto() {
        Proyecto proyect = new Proyecto();
        ArrayList<Persona> pr1 = new ArrayList<>();
        Persona p1 = new Persona("p1","@gmail.com");
        Persona p2 = new Persona("p2","@gmail.com");
        Persona p3 = new Persona("p3","@gmail.com");
        proyect.añadirPersonaProyecto("p1");
        proyect.añadirPersonaProyecto("p2");
        proyect.añadirPersonaProyecto("p3");
        pr1.add(p1);
        pr1.add(p2);
        pr1.add(p3);
        String[] res = proyect.listarPersonasProyecto();
        String[] v1 = new String[pr1.size()];
        for(int i = 0; i < pr1.size();i++){
            v1[i] = "Nombre: "+pr1.get(i).getNombre() + "----"+ pr1.get(i).getCorreo();
        }
        assertArrayEquals(v1,res);
    }

    @Test
    void añadirPersonaProyecto() {
        Proyecto proyecto = new Proyecto();
        assertTrue(proyecto.añadirPersonaProyecto("p1"));
        assertTrue(proyecto.añadirPersonaProyecto("p12"));
        assertTrue(proyecto.añadirPersonaProyecto("p3"));
    }

    @Test
    void añadirTareaProyecto() throws añadirTareaExistenteException {
        Proyecto proyecto = new Proyecto();
        Tarea t1 = new Tarea();
        t1.setTitulo("programar");
        t1.setResultadoEsperado(new Programa("1PW", 10, "Comercial", "C++", 50, 1));
        Tarea t2 = new Tarea();
        t2.setTitulo("comer");
        t2.setResultadoEsperado(new Programa("1PW", 10, "Comercial", "C++", 50, 1));
        Tarea t3 = new Tarea();
        t3.setTitulo("estudiar");
        t3.setResultadoEsperado(new Programa("1PW", 10, "Comercial", "C++", 50, 1));
        assertTrue(proyecto.añadirTareaProyecto(t1));
        assertTrue(proyecto.añadirTareaProyecto(t2));
        assertTrue(proyecto.añadirTareaProyecto(t3));
        assertThrows(añadirTareaExistenteException.class, () -> proyecto.añadirTareaProyecto(t1));


    }
}