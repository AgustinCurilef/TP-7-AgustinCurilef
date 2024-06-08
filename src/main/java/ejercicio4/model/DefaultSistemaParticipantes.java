package ejercicio4.model;

import java.util.List;

public class DefaultSistemaParticipantes extends Sujeto implements SistemaParticipantes{
    RegistrarParticipante registrarParticipante;


    public DefaultSistemaParticipantes( List<Observer> observadores) {
        super(observadores);

    }

    public void altaParticipante(String nombre, String telefono,String email, String region) {
        if (validarInformacion(nombre, telefono,email, region))
            notificar(nombre, telefono,email, region);
    }


    private boolean validarInformacion(String nombre, String telefono,String email, String region) {
        if (nombre.isEmpty()) {
            throw new RuntimeException("Debe cargar un nombre");
        }
        if (telefono.isEmpty()) {
            throw new RuntimeException("Debe cargar un telefono");
        }
        if (!validarTelefono(telefono)) {
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (!checkEmail(email)) {
            throw new RuntimeException("email debe ser válido debe ingresarse de la siguiente forma, por ejemplo: ejemplo@email.com");
        }
        if (!region.equals("China") && !region.equals("US") && !
                region.equals("Europa")) {
            throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");
        }
        return true;
    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }
    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

}
