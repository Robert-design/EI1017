package Vista;
import javax.swing.*;

public abstract class Formulario {
    public int fieldSize(JTextField camp) {
        return camp.getText().length();
    }
    public int intConvertion(JTextField camp) {
        return Integer.valueOf(String.valueOf(camp.getText()));
    }
    public boolean isEmpty(JTextField objeto) {
        return (fieldSize(objeto) <= 0);
    }

    public abstract boolean emptyFields();

}
