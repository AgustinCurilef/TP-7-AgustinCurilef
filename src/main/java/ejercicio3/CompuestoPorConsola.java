package ejercicio3;

import ejercicio1.ClimaOnline;

public class CompuestoPorConsola extends MedidorCompuesto {

    public CompuestoPorConsola( Medidor medidor, ClimaOnline clima) {
        super(clima, medidor);

    }
    @Override
    public String leerTemperatura() {
    actualizar(clima.temperatura());
        return medidor.leerTemperatura();
    }
    private void actualizar(String temperatura) {
        float temperaturaFloat = Float.parseFloat(temperatura);
        String temperaturaActualizada ="Temperatura actualizada: " + temperatura + " °C";
        if (temperaturaFloat < 12.0) {
            temperaturaActualizada = temperaturaActualizada + "\nHace frio, se encenderá la caldera";
        }
        if (temperaturaFloat >17.0) {
            temperaturaActualizada = temperaturaActualizada + "\nHace calor, se encenderá el aire acondicionado";
        }
        System.out.println(temperaturaActualizada );
    }
}
