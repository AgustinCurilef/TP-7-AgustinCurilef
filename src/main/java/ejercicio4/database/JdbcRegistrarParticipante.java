package ejercicio4.database;
import ejercicio4.model.RegistrarParticipante;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcRegistrarParticipante extends RegistrarParticipante {
    private String url;
    private String user;
    private String password;


    public JdbcRegistrarParticipante() {
        this.url = "jdbc:mysql://localhost:3306/tp6-ejercicio4-patronobserver";
        this.user = "root";
        this.password = "";

    }

    protected void registrarParticipante(String nombre, String telefono,String email, String region) {
        java.sql.Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, user, password);
            PreparedStatement st = conexion.prepareStatement("insert into participantes(nombre,telefono,correoElectronico,region) values(?,?,?,?)");
            try {
                st.setString(1, nombre);
                st.setString(2, telefono);
                st.setString(3, email);
                st.setString(4, region);
                st.executeUpdate();
            } finally {
                st.close();

            }
        } catch (SQLException e) {
            throw new RuntimeException("Error de conexion", e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}

