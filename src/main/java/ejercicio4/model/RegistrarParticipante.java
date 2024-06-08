package ejercicio4.model;

public abstract class RegistrarParticipante implements Observer {
    public void Actualizar(String nombre, String telefono, String email, String region) {
        registrarParticipante(nombre, telefono,email, region);
    }
    protected abstract void registrarParticipante(String nombre, String telefono,String email, String region);

}
