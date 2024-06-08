package ejercicio1;

import ejercicio1.ClimaOnline;

import java.util.List;

public class Medidor extends Sujeto {
    private String temperatura;
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima, List<Observer> observadores) {
        super(observadores);
        this.clima = clima;
    }

    public String leerTemperatura() {
        //leo la temperatura del servicio web
        this.temperatura = this.clima.temperatura();
        notificar(temperatura);
        return this.temperatura;

    }
}
