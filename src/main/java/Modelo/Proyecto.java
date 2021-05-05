package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Proyecto implements Serializable {
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

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public String[] listarPersonasProyecto() {
        String [] res = new String[listaPersonas.size()];
        for (int i = 0; i < listaPersonas.size(); i++) {
            res[i] = "Nombre: "+ listaPersonas.get(i).getNombre() + "----" + listaPersonas.get(i).getCorreo();
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
            //res[i] = "Tarea: " + listaTareas.get(i).getTitulo() +"; Finalizado: "+ listaTareas.get(i).isFinalizado() + "; Resultado: " + listaTareas.get(i).getResultadoEsperado().toString() + "; Trabajan en tarea: " + Arrays.toString(listaTareas.get(i).mostrarPersonasProyecto()) + "; El responsable es: " + listaTareas.get(i).getResponsable() + "\n";
            res[i] = "Tarea: " + listaTareas.get(i).getTitulo();
            res[i] += "; Finalizado: "+ listaTareas.get(i).isFinalizado();
            res[i] += "; Resultado: " + listaTareas.get(i).getResultadoEsperado().toString();
            res[i] += "; Trabajan en tarea: " + Arrays.toString(listaTareas.get(i).mostrarPersonasProyecto());
            res[i] += "; El responsable es: " + listaTareas.get(i).getResponsable() + "\n";
        }
        return res;
    }


    public boolean añadirPersonaProyecto(String nombre) throws añadirPersonaATareaException {
        Persona persona = new Persona(nombre,"@gmail.com");
        return listaPersonas.add(persona);
    }

    public boolean añadirTareaProyecto(Tarea tarea) throws añadirTareaExistenteException {
        if (dameTarea(tarea.getTitulo()) != null)
            throw new añadirTareaExistenteException();
        else
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

    public double importeTotal() {
        double res = 0;
        for (Tarea tarea: listaTareas) {
            res += tarea.getImporte();
        }
        return res;
    }
}
