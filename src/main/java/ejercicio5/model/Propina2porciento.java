package ejercicio5.model;

import ejercicio5.model.Propina;

public class Propina2porciento extends Propina {
    public Propina2porciento() {
        super.propina = 2;
    }

    public Double calcularPropina(Double totalPedido) {
        return totalPedido *(propina*1/100);
    }
}
