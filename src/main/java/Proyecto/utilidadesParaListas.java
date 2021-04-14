package Proyecto;

import java.util.ArrayList;

public class utilidadesParaListas<E> {

    public static <E extends tieneLista<E>> ArrayList<E> elementosConListaVacia(ArrayList<E> lista) {
        ArrayList<E> res = new ArrayList<>();
        for (E e : lista)
            if (e.getLista().isEmpty())
                res.add(e);
        return res;
    }

    public static <E extends tieneClave<E>> Boolean elementosInsertables(E nombre, ArrayList<E> lista) {
        for (E e : lista)
            if (e.getClave().equals(nombre))
                return false;
        return true;
        }
    }