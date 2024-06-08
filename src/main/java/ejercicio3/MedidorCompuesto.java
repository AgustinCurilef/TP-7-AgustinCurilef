package ejercicio3;

import ejercicio1.ClimaOnline;

public abstract class MedidorCompuesto implements Medidor {
    protected ClimaOnline clima;
    protected Medidor medidor;
    public MedidorCompuesto(ClimaOnline climaOnline, Medidor medidor) {
        this.clima = climaOnline;
        this.medidor = medidor;
    }
}
