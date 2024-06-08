package ejercicio1;

import ejercicio1.Observer;

import java.util.List;

public class Sujeto {
    private List<Observer> observadores;

    public Sujeto(List<Observer> observadores) {
        this.observadores = observadores;
    }
    protected void notificar(String temperatura) {
        this.observadores.stream().forEach((o) -> o.actualizar(temperatura));
    }
}
