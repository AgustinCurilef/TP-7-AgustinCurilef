package ejercicio2;

import ejercicio1.Observer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ObservadorArchivoTxt implements Observer{
    private String ruta;

    public ObservadorArchivoTxt(String ruta) {
        this.ruta = ruta;
    }
    @Override
    public void actualizar(String temperatura) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String registro = temperatura +" °C, Fecha: "+ LocalDateTime.now().format(formatter) + "\n";
        try {
            Files.write(Paths.get(this.ruta), registro.getBytes(), new OpenOption[]{StandardOpenOption.APPEND});
        } catch (IOException var3) {
            throw new RuntimeException("No se puedo Inscribir en disco", var3);
        }
    }
}
