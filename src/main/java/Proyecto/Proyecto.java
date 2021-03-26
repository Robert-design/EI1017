package Proyecto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Proyecto  {
    private String nombre;
    ArrayList<Persona> listaPersonas;
    ArrayList<Tarea> listaTareas;

    public Proyecto() {
        listaPersonas = new ArrayList<>();
        listaTareas = new ArrayList<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public  String getNombre() {
        return nombre;
    }

    public String[] listarPersonasProyecto() {
        String [] res = new String[listaPersonas.size()];
        for (int i = 0; i < listaPersonas.size(); i++) {
            res[i] = "Nombre: "+listaPersonas.get(i).getNombre()+"----"+listaPersonas.get(i).getCorreo();
        }
        return res;
    }

    public boolean existeTarea(String titulo) {
        for (Tarea tarea : listaTareas){
            if(tarea.getTitulo().equals(titulo))
                return true;
        }
        return false;
    }

    public boolean existePersona(String nombre) {
        for(Persona persona : listaPersonas){
            if(persona.getNombre().equals(nombre))
                return true;
        }
        return false;
    }

    public String [] listarTareasPoyecto() {
        String [] res = new String[listaTareas.size()];
        for (int i = 0; i < listaTareas.size(); i++) {
            res[i] = "Tarea: " + listaTareas.get(i).getTitulo() +"\n "+"Estado: "+ listaTareas.get(i).isFinalizado() + "\n"+"Resultado: " + listaTareas.get(i).getResultadoEsperado() + "\n"+"Trabajan en tarea: " + Arrays.toString(listaTareas.get(i).mostrarPersonasProyecto())+"\n";
        }
        return res;
    }


    public boolean añadirPersonaProyecto(String nombre) {
        Persona persona = new Persona(nombre,"@gmail.com");
        return listaPersonas.add(persona);
    }

    public boolean añadirTareaProyecto(Tarea tarea) {
        return listaTareas.add(tarea);
    }

    public Tarea dameTarea(String titulo) {
        for (Tarea tarea : listaTareas)
            if (tarea.getTitulo().equals(titulo) && existeTarea(titulo))
                return tarea;
        return null;
    }

    public Persona damePersona(String nombre) {
        for (Persona persona : listaPersonas)
            if (persona.getNombre().equals(nombre) && existePersona(nombre))
                return persona;
        return null;
    }
}
