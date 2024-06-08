package ejercicio5.model;

import ejercicio5.model.Propina;

public class Propina5porciento extends Propina {
    public Propina5porciento() {
        super.propina = 5;
    }

    public Double calcularPropina(Double totalPedido) {
        return totalPedido * (propina*1/100);
    }
}
