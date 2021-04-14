package Proyecto;


import java.util.ArrayList;

public class Persona implements tieneClave {
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
//comentrioo de persona
    @Override
    public Boolean getClave(Object item) {
        int repeticiones = 0;
        for (Tarea titulo : tareasResponsables) {
            if (titulo.getTitulo().equals(item))
                repeticiones++;
        }
        if(repeticiones > 1)
            return false;
        return true;
    }
}
