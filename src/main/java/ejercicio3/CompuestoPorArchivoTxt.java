package ejercicio3;

import ejercicio1.ClimaOnline;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CompuestoPorArchivoTxt extends MedidorCompuesto{
    private String ruta;


    public CompuestoPorArchivoTxt(String ruta, Medidor medidor, ClimaOnline clima) {
        super(clima, medidor);
        this.ruta = ruta;
    }
    @Override
    public String leerTemperatura() {
        actualizar(clima.temperatura());
        return medidor.leerTemperatura()  ;
    }
    private void actualizar(String temperatura) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String registro = temperatura +" °C, Fecha: "+ LocalDateTime.now().format(formatter) + "\n";
        try {
            Files.write(Paths.get(this.ruta), registro.getBytes(), new OpenOption[]{StandardOpenOption.APPEND});
        } catch (IOException var3) {
            throw new RuntimeException("No se puedo Inscribir en disco", var3);
        }
    }
}
