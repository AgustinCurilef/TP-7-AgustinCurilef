package ejercicio5.model;
import java.util.List;
public class sujeto {
    private List<Observador> observadores;
    public sujeto(List<Observador> observadores) {
        this.observadores = observadores;
    }
    protected void notificar(int nroMesa, double nuevoValor) {
        for (Observador o : this.observadores) {
            o.actualizar(nroMesa, nuevoValor);
        }
    }
}
