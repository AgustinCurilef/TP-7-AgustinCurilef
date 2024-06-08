package ejercicio5.model;


import ejercicio5.exceptions.MesaIncorrectaException;

import java.util.List;

public class Mesa extends sujeto {
    private final int numeroMesa;
    private Tarjeta tarjeta;
    private Pedido unPedido;
    private String correoElectronico;

    public Mesa(int numeroMesa, String correoElectronico, List<Observador> observadores) {
        super(observadores);
        this.numeroMesa = numeroMesa;
        this.correoElectronico = correoElectronico;
    }

    public void realizarPedido(Pedido miPedido, PlatoPrincipal unPlato) throws MesaIncorrectaException {
        miPedido.tomarPedido(unPlato, this);
    }

    public void realizarPedido(Pedido miPedido, Bebida unaBebida) throws MesaIncorrectaException {
        miPedido.tomarPedido(unaBebida, this);
    }

    public void pagarCuenta(Pedido miPedido, Tarjeta miTarjeta, Propina propina) {

        notificar(this.numeroMesa, miPedido.calcularTotal(miTarjeta));
        miTarjeta.realizarPago(miPedido, propina);

    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Mesa)) {
            return false;
        } else {
            Mesa mesa = (Mesa) o;
            return this.numeroMesa == mesa.numeroMesa ;
        }
    }

    public String obtenerCorreo() {
        return this.correoElectronico;
    }
    public void modificarCorreo(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}