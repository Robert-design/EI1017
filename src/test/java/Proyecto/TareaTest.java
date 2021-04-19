package Proyecto;

import Excepciones.añadirPersonaATareaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TareaTest {

    @org.junit.jupiter.api.Test
    void añadirPersonaTarea() {
        Tarea prueba = new Tarea();
        Persona prueba1 = new Persona("probando","@gmail.com");
        try {
            prueba.añadirPersonaTarea(prueba1);
        } catch (añadirPersonaATareaException e) {
            e.printStackTrace();
        }
        ArrayList<Persona> lista_prueba1 = new ArrayList<>();
        lista_prueba1.add(prueba1);
        Persona[] vector1 = new Persona[0];
        Persona[] vector2 = new Persona[0];
        prueba.personasATarea.toArray(vector1);
        lista_prueba1.toArray(vector2);
        assertArrayEquals(vector2,vector1);

        Persona prueba2 = new Persona("probando2", "@gmail.com");
        try {
            prueba.añadirPersonaTarea(prueba2);
        } catch (añadirPersonaATareaException e) {
            e.printStackTrace();
        }
        lista_prueba1.add(prueba2);
        prueba.personasATarea.toArray(vector1);
        lista_prueba1.toArray(vector2);
        assertArrayEquals(vector2,vector1);
    }

    @org.junit.jupiter.api.Test
    void eliminarPersonaTarea() {
        Tarea prueba = new Tarea();
        ArrayList<Persona> pr1 = new ArrayList<>();
        Persona p1 = new Persona("p1","@gmail.com");
        Persona p2 = new Persona("p2","@gmail.com");
        Persona p3 = new Persona("p3","@gmail.com");
        Persona p4 = new Persona("p4","@gmail.com");
        try {
            prueba.añadirPersonaTarea(p1);
        } catch (añadirPersonaATareaException e) {
            e.printStackTrace();
        }
        try {
            prueba.añadirPersonaTarea(p2);
        } catch (añadirPersonaATareaException e) {
            e.printStackTrace();
        }
        try {
            prueba.añadirPersonaTarea(p3);
        } catch (añadirPersonaATareaException e) {
            e.printStackTrace();
        }
        try {
            prueba.añadirPersonaTarea(p4);
        } catch (añadirPersonaATareaException e) {
            e.printStackTrace();
        }
        pr1.add(p1);
        pr1.add(p2);
        pr1.add(p4);
        prueba.eliminarPersonaTarea(p3);
        Persona[] res1 = new Persona[prueba.personasATarea.size()];
        Persona[] res2 = new Persona[pr1.size()];
        pr1.toArray(res2);
        prueba.personasATarea.toArray(res1);
        assertArrayEquals(res2, res1);


    }

    @org.junit.jupiter.api.Test
    void mostrarPersonasProyecto() {
        Tarea prueba = new Tarea();
        Persona prueba1 = new Persona("Prueba1", "@gmail.com");
        try {
            prueba.añadirPersonaTarea(prueba1);
        } catch (añadirPersonaATareaException e) {
            e.printStackTrace();
        }
        String[] res = prueba.mostrarPersonasProyecto();
        String[] p1 = new String[prueba.personasATarea.size()];
        p1[0] = String.valueOf(prueba1);
        assertArrayEquals(p1,res);
    }
}