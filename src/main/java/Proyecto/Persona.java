package Proyecto;


import java.util.ArrayList;

public class Persona implements tieneClave {
    private String nombre, correo;
    ArrayList<Tarea> tareas_responsables;


    public Persona(String nombre, String correo) {
        super();
        this.nombre = nombre;
        this.correo = nombre+correo;
        tareas_responsables = new ArrayList<>();
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
        tareas_responsables.add(tarea);
    }
//comentrioo de prueba
    @Override
    public Boolean getClave(Object item) {
        int repeticiones = 0;
        for (Tarea titulo : tareas_responsables) {
            if (titulo.getTitulo().equals(item))
                repeticiones++;
        }

        if(repeticiones > 1)
            return false;
        return true;
    }
}
