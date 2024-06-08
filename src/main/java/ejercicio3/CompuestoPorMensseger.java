package ejercicio3;

import ejercicio1.ClimaOnline;

import javax.swing.*;

public class CompuestoPorMensseger extends MedidorCompuesto {

    public CompuestoPorMensseger( Medidor medidor, ClimaOnline clima) {
        super(clima, medidor);

    }
    @Override
    public String leerTemperatura() {
        JOptionPane.showMessageDialog(null, "Temperatura actualizada: " + clima.temperatura()+" °C");
        return medidor.leerTemperatura();
    }
}
