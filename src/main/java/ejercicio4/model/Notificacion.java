package ejercicio4.model;

public abstract class Notificacion implements Observer {
    public void Actualizar(String nombre, String telefono,String email, String region) {
        enviarNotificacion(email);
    }


    protected abstract void enviarNotificacion(String destinario);
}
