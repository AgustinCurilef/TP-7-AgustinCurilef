package ejercicio1;

import ejercicio2.ObservadorArchivoTxt;
import ejercicio2.ObservadorConsola;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String apiKey = "d1a4e2d8136d8bcfc3cbc73ac92e1501";
        ClimaOnline clima = new WeatherChannelService("https://api.openweathermap.org/data/2.5/weather?lat=-40.811909&lon=-62.996204&units=metric&appid="+ apiKey);
        Medidor medidor = new Medidor(clima, List.of(new ObservadorConsola(), new ObservadorMensseger(),new ObservadorArchivoTxt("src/main/resources/RegistroTemperaturasClimaticas")));
        medidor.leerTemperatura();
    }
}
