package ejercicio5.model;

public abstract class Propina {
    protected int propina;

    public Propina() {
        propina=0;
    }

    protected abstract Double calcularPropina(Double var1);

    @Override
    public String toString() {
        return " " + propina + " %" ;
    }
}
