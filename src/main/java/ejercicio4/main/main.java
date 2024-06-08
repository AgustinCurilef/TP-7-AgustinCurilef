package ejercicio4.main;
import ejercicio4.database.*;
import ejercicio4.model.*;
import ejercicio4.ui.*;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    var correoEmpresa= new CorreoElectronico("fd5c2b624ae696", "78b2ddb2667cc9", "sandbox.smtp.mailtrap.io","Sistema1@gmail.com","Bienvenido a Sistema1","Hola, este es el sistema de inscripcion de Sistema1, gracias por inscribirte");
                    var sistemaParticipante = new DefaultSistemaParticipantes(List.of(new JdbcRegistrarParticipante(),correoEmpresa));
                    new VentanaAgregarParticipante(sistemaParticipante);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}