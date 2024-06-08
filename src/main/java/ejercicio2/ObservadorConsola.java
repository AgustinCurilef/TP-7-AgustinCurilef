package ejercicio2;

import ejercicio1.Observer;

public class ObservadorConsola implements Observer {

    @Override
    public void actualizar(String temperatura) {
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
