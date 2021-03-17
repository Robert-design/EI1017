package Proyecto;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tarea {

   private String titulo, descripcion;
    static ArrayList<Persona> personasATarea =  new ArrayList<Persona>();
    Persona responsable;
    private int prioridad;
    private LocalDate fechaCreacion, fechaFinalizacion; //Esta última puede estar en blanco
    boolean finalizado;
    Resultado resultadoEsperado;
    //Me falta añadir lista de etiquetas, pero no sé si debe de ser una clase o lista normal

    /*La idea en principio es reducir la clase Tarea que tiene muchos atributos, esto puede sobrecargar la clase, esta clase puede extender
    * de la clase persona, así tendría acceso al Array de las personas y al responsable, esta misma clase puede crear el array de tareas.
    * Por otro lado, la clase tarea podria tener una clase auxiliar para aliviar la carga de la clase tarea por ejemplo una clase llamada
    * estadoTarea que contenga el atributo finalizado y el resultado.
    * */

    public  Tarea () {
        super();
        //personasATarea = new ArrayList<>();
    }

    public static void main(String[] args) {
        Persona prueba = new Persona("Robert", "marica@uji.es");
        System.out.println(prueba.toString());
        personasATarea.add(prueba);
        System.out.println(personasATarea.toString());
    }


}
