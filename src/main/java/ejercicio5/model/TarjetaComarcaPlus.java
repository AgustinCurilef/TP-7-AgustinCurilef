package ejercicio5.model;

import ejercicio5.model.Pedido;
import ejercicio5.model.Tarjeta;

public class TarjetaComarcaPlus extends Tarjeta {
    private double descuento = 0.02;

    public TarjetaComarcaPlus(String titular, int codigo) {
        super("Comarca Plus", titular, codigo);
    }

    public double aplicarDescuento(Pedido pedido) {
        double total = pedido.calcularPlatos() + pedido.calcularBebidas();
        return total * this.descuento;
    }
}