package ejercicio5.model;

import ejercicio5.model.Pedido;
import ejercicio5.model.Tarjeta;

public class TarjetaVisa extends Tarjeta {
    private Double descuento = 0.03;

    public TarjetaVisa(String titular, int codigo) {
        super("Visa", titular, codigo);
    }

    public double aplicarDescuento(Pedido pedido) {
        return pedido.calcularBebidas() * this.descuento;
    }
}