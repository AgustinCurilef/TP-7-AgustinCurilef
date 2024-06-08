package ejercicio3;

import ejercicio1.ClimaOnline;
import ejercicio1.Medidor;
import ejercicio1.WeatherChannelService;

public class Main {
    public static void main(String[] args) {
        String apiKey = "d1a4e2d8136d8bcfc3cbc73ac92e1501";
        ClimaOnline clima = new WeatherChannelService("https://api.openweathermap.org/data/2.5/weather?lat=-40.811909&lon=-62.996204&units=metric&appid="+ apiKey);
        var medidor = new MedidorBuilder(new MedidorSimple(clima),clima);
       System.out.println(medidor.ConPersistenciaEnDisco("src/main/resources/RegistroTemperaturasClimaticas").ConMensseger().ConEnvioPorConsola().build().leerTemperatura());
    }
}
