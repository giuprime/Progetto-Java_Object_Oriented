package Allenamento;

import java.util.List;

public class AssegnaCalorie {
    
    private final List<Object> listaMomenti;
    private final Diario diario;
    private final List<Double> listaMetRep;
    private final List<Double> listaKcalRipetizione;
    //QUESTA CLASSE è USATA PER OTTENERE I SUOI ATTRIBUTI PER VEDERE IL SUO UTILIZZO ANDARE IN DIARIO
    public AssegnaCalorie(List<Object> listaMomenti, Diario diario, List<Double> listaMetRep, List<Double> listaKcalRipetizione) {
        this.listaMomenti = listaMomenti;
        this.diario = diario;
        this.listaMetRep = listaMetRep;
        this.listaKcalRipetizione = listaKcalRipetizione;
    }

    public List<Object> getListaMomenti() {
        return listaMomenti;
    }

    public Diario getDiario() {
        return diario;
    }

    public List<Double> getListaMetRep() {
        return listaMetRep;
    }

    public List<Double> getListaKcalRipetizione() {
        return listaKcalRipetizione;
    }
    
    
   
    
}
