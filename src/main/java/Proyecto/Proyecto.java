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

    public String [] listarPersonasProyecto() {
        String [] res = new String[listaPersonas.size()];
        for (int i = 0; i < listaPersonas.size(); i++) {
            res[i] = String.valueOf(listaPersonas.get(i));
        }
        return res;
    }

    public ArrayList<Tarea> listarTareasPoyecto() {
        return null;
    }

    public void añadirPersonaTarea (Persona persona) {
        listaPersonas.add(persona);
    }

    public void borrarPersonaTarea (String nombre) {
        for(Persona elem : listaPersonas){
            if(elem.getNombre().equals(nombre))
                listaPersonas.remove(elem);
                break;
        }
    }


}
