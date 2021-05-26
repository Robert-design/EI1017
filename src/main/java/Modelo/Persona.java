package Modelo;


import Interfaces.tieneClave;
import Interfaces.tieneLista;
import Modelo.Tarea.Tarea;

import java.io.Serializable;
import java.util.ArrayList;

public class Persona implements tieneClave, tieneLista, Serializable {
    private String nombre;
    private String  correo;
    ArrayList<Tarea> tareasResponsables;

    public Persona() {
        super();
        this.nombre = "Sin asignar";

    }
    public Persona(String nombre, String correo) {
        super();
        this.nombre = nombre;
        this.correo = nombre+correo;
        tareasResponsables = new ArrayList<>();
    }

    public String getNombre () {
        return this.nombre;
    }
    public String getCorreo() {
        return this.correo;
    }

    @Override
    public String toString() {
        return
                "Nombre = '" + nombre + '\'' +
                ", Correo = '" + correo + '\''
                ;
    }

    public void añadirResponsable(Tarea tarea) {
        tareasResponsables.add(tarea);
    }

    @Override
    public String getClave() {
        return getNombre();
    }


    @Override
    public ArrayList getLista() {
        return tareasResponsables;
    }


}
