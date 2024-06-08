package ejercicio1;

import javax.swing.*;

public class ObservadorMensseger implements Observer {
    @Override
    public void actualizar(String temperatura) {
        JOptionPane.showMessageDialog(null, "Temperatura actualizada: " + temperatura+" °C");
    }
}
