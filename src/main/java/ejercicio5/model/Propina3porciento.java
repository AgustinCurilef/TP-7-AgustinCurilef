package ejercicio5.model;

import ejercicio5.model.Propina;

public class Propina3porciento extends Propina {
    public Propina3porciento() {
        super.propina = 3;
    }

    public Double calcularPropina(Double totalPedido) {
        return totalPedido * (propina*1/100);
    }
}
