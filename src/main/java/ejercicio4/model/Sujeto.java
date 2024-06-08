package ejercicio4.model;


import java.util.List;

public class Sujeto {
    private List<Observer> observadores;

    public Sujeto(List<Observer> observadores) {
        this.observadores = observadores;
    }
    protected void notificar(String nombre, String telefono,String email, String region) {
        for (Observer o : this.observadores) {
            o.Actualizar(nombre, telefono, email, region);
        }
    }
}
