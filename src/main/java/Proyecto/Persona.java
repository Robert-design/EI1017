package Proyecto;


import java.util.ArrayList;

public class Persona implements tieneClave, tieneLista{
    private String nombre, correo;
    ArrayList<Tarea> tareasResponsables;


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
