package ejercicio5.model;

public record PlatoPrincipal(String nombre, Double precio) {
    @Override
    public String toString() {
        return  " "+nombre.toUpperCase() +" -- " + precio +"  $ ";
    }
}
