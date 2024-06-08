package ejercicio5.model;
import ejercicio5.database.EnDiscoRegistro;
import ejercicio5.ui.VentanaGerenteObservador;
import ejercicio5.ui.VentanaTomarPedido;

import java.time.LocalDate;
import java.util.List;

public class main {
    public static void main(String[] args) {
        CorreoElectronico micuenta = new CorreoElectronico("fd5c2b624ae696", "78b2ddb2667cc9", "sandbox.smtp.mailtrap.io");
        var fecha=new ProveedorDeFechas() {
            @Override
            public LocalDate fecha() {
                return LocalDate.now();
            }
        };

        VentanaTomarPedido ventana = new VentanaTomarPedido(new EnDiscoRegistro("src/main/resources/RestauranteConObserver"), micuenta,fecha,new Tarjeta( "Naranja","Agustin", 123456), List.of(new VentanaGerenteObservador()));
    }
}

