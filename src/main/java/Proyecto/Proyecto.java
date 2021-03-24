package Proyecto;

import java.util.ArrayList;

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

    public void listarPersonasProyecto() {
        String [] res = new String[listaPersonas.size()];
        for (int i = 0; i < listaPersonas.size(); i++) {
            res[i] = String.valueOf(listaPersonas.get(i));
            System.out.println(res[i]);
        }
    }

    public ArrayList<Tarea> listarTareasPoyecto() {
        return null;
    }

    public boolean añadirPersonaProyecto(String nombre) {
        Persona persona = new Persona(nombre,"@gmail.com");
        return listaPersonas.add(persona);
    }

}
