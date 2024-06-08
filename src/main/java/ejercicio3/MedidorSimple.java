package ejercicio3;

import ejercicio1.ClimaOnline;
import ejercicio1.Observer;

import java.util.List;

public class MedidorSimple implements Medidor {
    private String temperatura;
    private ClimaOnline clima;

    public MedidorSimple(ClimaOnline clima) {
        this.clima = clima;
    }

    public String leerTemperatura() {
        //leo la temperatura del servicio web
        this.temperatura = this.clima.temperatura();
        return this.temperatura;
    }
}
