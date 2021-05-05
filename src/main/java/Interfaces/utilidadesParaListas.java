package Interfaces;

import Modelo.Persona;

import java.util.ArrayList;

public class utilidadesParaListas<E> {

    public static <E extends tieneLista<E>> ArrayList<E> elementosConListaVacia(ArrayList<E> lista) {
        ArrayList<E> res = new ArrayList<>();
        for (E e : lista)
            if (e.getLista().isEmpty())
                res.add(e);
        return res;
    }

    public static <E extends Persona, Tarea> Boolean elementosInsertables(String nombre, ArrayList<E> lista) {
        for (E e : lista)
            if (e.getClave().equals(nombre))
                return false;
        return true;
        }
}