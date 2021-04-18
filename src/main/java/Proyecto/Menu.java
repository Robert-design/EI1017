package Proyecto;

import Excepciones.añadirPersonaATareaException;
import Excepciones.añadirTareaExistenteException;
import Excepciones.existeResponsableException;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.print("Introduce el nombre del nuevo proyecto para comenzar: ");
        Scanner scan = new Scanner(System.in);
        Proyecto proyecto = new Proyecto();
        String nombreProyecto = scan.next();
        proyecto.setNombre(nombreProyecto);
        boolean acabado = false;
        while (!acabado) {
            System.out.println("Escoja la opción deseada.");
            System.out.println("1. Dar de alta personas que trabajan en el proyecto.");
            System.out.println("2. Dar de alta las tareas con sus datos.");
            System.out.println("3. Marcar una tarea como finalizada.");
            System.out.println("4. Introducir una persona en una tarea.");
            System.out.println("5. Eliminar una persona de una tarea.");
            System.out.println("6. Listar las personas asignadas a un proyecto.");
            System.out.println("7. Listar las tarea de un proyecto.");
            System.out.println("8. Guardar los datos del proyecto");
            System.out.println("9. Cargar los datos de un proyecto");
            System.out.println("10. Salir del menú.");
            System.out.print("Escoge la opción deseada: ");
            int operacion = scan.nextInt();
            switch (operacion) {
                case 1: {
                    altaPersona(proyecto);
                    break;
                }
                case 2: {
                    crearTarea(proyecto);
                    break;
                }
                case 3: {
                    marcarFinalizada(proyecto);
                    break;
                }
                case 4: {
                    introducirPersonaATarea(proyecto);
                    break;
                }
                case 5: {
                    eliminarPersonaDeTarea(proyecto);
                    break;
                }
                case 6: {
                    String[] personasEnProyecto = proyecto.listarPersonasProyecto();
                    if (personasEnProyecto.length != 0)
                        System.out.println(Arrays.toString(personasEnProyecto));
                    else
                        System.out.println("No hay niguna persona dada de alta en el proyecto");
                    break;
                }

                case 7: {
                    String[] tareasEnProyecto = proyecto.listarTareasPoyecto();
                    if (tareasEnProyecto.length != 0)
                        System.out.println(Arrays.toString(tareasEnProyecto) + "\n");
                    else
                        System.out.println("No hay ninguna tarea dada de alta en el proyecto");
                    break;
                }
                case 8: {
                    FileOutputStream fichero = new FileOutputStream(nombreProyecto+".bin");
                    ObjectOutputStream obj = new ObjectOutputStream(fichero);
                    obj.writeObject(proyecto);
                    obj.close();
                    System.out.println("Guardando los datos...");
                    break;
                }
                case 9: {
                    System.out.print(" ¿Qué proyecto deseas cargar?:");
                    String cargarProyecto = scan.next();
                    FileInputStream fichero = new FileInputStream(cargarProyecto+".bin");
                    ObjectInputStream obj = new ObjectInputStream(fichero);
                    proyecto = (Proyecto) obj.readObject();
                    obj.close();
                    System.out.println("Datos cargados");
                    break;
                }
                case 10: {
                    System.out.println("¡Hasta luego!");
                    acabado = true;
                    break;
                }
            }
        }
    }


    public static void altaPersona(Proyecto proyecto) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nombre de la persona: ");
        String nombrePersona = scan.next();
        if (utilidadesParaListas.elementosInsertables(nombrePersona, proyecto.listaPersonas)) {
            proyecto.añadirPersonaProyecto(nombrePersona);
            System.out.println("Persona dada de alta\n");
        }
        else
            System.out.println("Ya existe esa persona");
    }

    public static Resultado crearResultado(String nombreResultado){
        Resultado resultado = null;
        switch (nombreResultado) {
            case "D":
                resultado = new Documentacion("1D", 12, "Interno", "Word", 84, 8.4);
                break;
            case "P":
                resultado = new Programa("1P", 10, "Interno", "Java", 100, 8);
                break;
            case "PW":
                resultado = new PaginaWeb("1PW", 10, "Comercial", "Estática", "Python", "Hecho");
                break;
            case "B":
                resultado = new Biblioteca("1PW", 10, "Comercial", "C++", 50, 1);
                break;
            default:
                System.out.println("No has introducido una opción correcta\n");
                break;
        }
        return resultado;
    }

    public static void crearTarea(Proyecto proyecto) {
        Tarea tarea = new Tarea();
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce la tarea: ");
        String nombreTarea = scan.next();
        tarea.setTitulo(nombreTarea);
        tarea.setDescripcion("Hacer código en Java");
        tarea.setPrioridad(1);
        tarea.setFechaFinalizacion(null);
        tarea.setFinalizado(false);
        System.out.print("Introduce el tipo de resultado esperado: Documentación (D), Programa (P), Página web (PW), Biblioteca (B): ");
        String nombreResultado = scan.next();
        Resultado resultado = crearResultado(nombreResultado);
        while (resultado == null) {
            System.out.print("Introduce una opción correcta por favor: Documentación (D), Programa (P), Página web (PW), Biblioteca (B): ");
            nombreResultado = scan.next();
            resultado = crearResultado(nombreResultado);
        }
        tarea.setResultadoEsperado(resultado);
        try {
            proyecto.añadirTareaProyecto(tarea);
        } catch (añadirTareaExistenteException e) {
            e.printStackTrace();
        }
    }


    public static void marcarFinalizada(Proyecto proyecto) {
        Scanner scan = new Scanner(System.in);
        System.out.print("¿Qué tarea ha sido finalizada? ");
        String nombreTarea = scan.next();
        Tarea tarea = proyecto.dameTarea(nombreTarea);
        if (!tarea.getFinalizado()) {
            tarea.setFinalizado(true);
            System.out.println("Tarea finalizada\n");
        } else
            System.out.println("La tarea ya se encontraba finalizada\n");
    }

    public static void introducirPersonaATarea(Proyecto proyecto) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nombre a añadir: ");
        String nombre = scan.next();
        System.out.print("Introduce el nombre de la tarea: ");
        String titulo = scan.next();
        Tarea tarea = proyecto.dameTarea(titulo);

        if (!tarea.getFinalizado()) {
            Tarea existente = proyecto.dameTarea(titulo);
            Persona nueva = proyecto.damePersona(nombre);
            boolean tieneResponsable = existente.tieneResponsable();
            try {
                existente.añadirPersonaTarea(nueva);
            } catch (añadirPersonaATareaException e) {
                e.printStackTrace();
            }
            if (!tieneResponsable) {
                System.out.print(" ¿Quieres que esta persona sea responsable de la tarea? (Y/N)");
                String respuesta = scan.next();
                if (respuesta.equals("Y")) {
                        try {
                            existente.setResponsable(nueva);
                        } catch (existeResponsableException e) {
                            e.printStackTrace();
                        }
                }
            }

            System.out.println("Persona añadida a la tarea.\n");
        } else {
            System.out.println("No se ha podido dar de alta a la persona, has introducido algún campo incorrecto o la tarea estaba finalizada\n");
        }

    }


    public static void eliminarPersonaDeTarea(Proyecto proyecto) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduce el nombre de la persona para eliminarlo de la tarea: ");
        String nombre = scan.next();
        System.out.print("Introduce el título de la tarea: ");
        String titulo = scan.next();
        Tarea existente = proyecto.dameTarea(titulo);
        Persona eliminada = proyecto.damePersona(nombre);
        Tarea tarea = proyecto.dameTarea(titulo);
        Persona esResponsable = tarea.getResponsable();
        //existente.personasATarea.size() > 1
        if (!utilidadesParaListas.elementosConListaVacia(tarea.personasATarea).isEmpty()) {
            if (esResponsable.getNombre().equals(eliminada.getNombre())) {
                System.out.print("Vas a eliminar al responsable de la tarea, escoge a otro antes por favor: ");
                boolean hecho = false;
                while (!hecho) {
                    nombre = scan.next();
                    Persona nueva = proyecto.damePersona(nombre);
                    if (tarea.personasATarea.contains(nueva)) {
                        try {
                            tarea.setResponsable(nueva);
                            existente.eliminarPersonaTarea(eliminada);
                            System.out.println("Persona eliminada correctamente\n");
                        } catch (existeResponsableException e) {
                            e.printStackTrace();
                        }
                        hecho = true;
                    } else
                        System.out.println("Introduce una persona dada de alta en la tarea");
                }
            }
        } else
            System.out.println("Sólo hay una persona en la tarea y es el responsable, no puedes eliminarlo. O bien no hay nadie en la tarea\n");
    }
}