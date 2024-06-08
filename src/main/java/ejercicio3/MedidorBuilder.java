package ejercicio3;

import ejercicio1.ClimaOnline;

public class MedidorBuilder {
    private Medidor medidorFinal;
    private MedidorSimple medidorSimple;
    private ClimaOnline clima;

    public MedidorBuilder(MedidorSimple medidorSimple, ClimaOnline clima) {
        this.medidorFinal= medidorSimple;
        this.clima = clima;
    }
    public MedidorBuilder ConPersistenciaEnDisco(String ruta){
        this.medidorFinal = new CompuestoPorArchivoTxt(ruta,this.medidorFinal,clima);
        return this;
    }
    public MedidorBuilder ConEnvioPorConsola(){
        this.medidorFinal = new CompuestoPorConsola(this.medidorFinal,clima);
        return this;
    }
    public MedidorBuilder ConMensseger(){
        this.medidorFinal = new CompuestoPorMensseger(this.medidorFinal,clima);
        return this;
    }
    public Medidor build(){
        return this.medidorFinal;
    }
}
