package Proyecto;

public class PaginaWeb extends Resultado {

    private String tipo; //Estática o Dinámica
    private String lenguaje; // Lenguaje de programación
    private String back_end;

    public PaginaWeb() {
        super();

    }

    public String getTipo() {
        return this.tipo;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public String getBack_end() {
        return back_end;
    }
}