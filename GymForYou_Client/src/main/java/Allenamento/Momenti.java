package Allenamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Momenti {
    private final List<String> primomomento;
    private final List<Object> esercizi;
    private final List<Object> esercizi1mom;
    private final List<Object> esercizi2mom;
    private final List<Object> esercizi3mom;
    private final int numeroMomento;
    private final int sizePartiOrdinate;
    private final int[] unodue = new int[]{ 2,3,5 };
    private final int[] tre = new int[]{ 3,5,7 }; 
    private final int[] quattro = new int[]{ 4,7,9 }; 
    private final int[] cinque = new int[]{ 5,8,10 }; 
    private final String[] intensita = new String[]{"Leggero", "Medio", "Pesante"};
    private final Map dati = new HashMap(){{
            put(1, getUnodue());
            put(2, getUnodue());
            put(3, getTre());
            put(4, getQuattro());
            put(5, getCinque());
        }};
    
    //QUESTA CLASSE è USATA PER OTTENERE I SUOI ATTRIBUTI PER VEDERE IL SUO UTILIZZO ANDARE IN DIARIO
    public Momenti(List<String> primomomento,List<Object> esercizi, List<Object> esercizi1mom, List<Object> esercizi2mom, List<Object> esercizi3mom, int numeroMomento, int sizePartiOrdinate) {
        this.primomomento = primomomento;
        this.esercizi = esercizi;
        this.esercizi1mom = esercizi1mom;
        this.esercizi2mom = esercizi2mom;
        this.esercizi3mom = esercizi3mom;
        this.numeroMomento = numeroMomento;
        this.sizePartiOrdinate = sizePartiOrdinate;
    }
    
    public int[] getUnodue() {
        return unodue;
    }

    public int[] getTre() {
        return tre;
    }

    public int[] getQuattro() {
        return quattro;
    }

    public int[] getCinque() {
        return cinque;
    }

    public String[] getIntensita() {
        return intensita;
    }


    public Map getDati() {
        return dati;
    }

    public List<String> getPrimomomento() {
        //getPrimomomento()[Lunedi Mattina (Leggero) 56, Lunedi Sera (Leggero) 56]
        //RESTITUISCE TUTTI I GIORNI E I MOMENTI SCELTI
        return primomomento;
    }

    public List<Object> getEsercizi() {
        //SONO PRESENTI LE PARTI DEL CORPO DA ALLENARE, IL NUMEROD DI ESERCIZI, LE KCAL DA BRUCIARE PER OGNI MOMENTO
        return esercizi;
    }

    public List<Object> getEsercizi1mom() {
        //Esercizi1mom [1, 2, 56] INDICA IL NUMERO DI PARTI DEL CORPO DA ALLENARE, GLI ESERCIZI DA FARE, LE KCAL DA BRUCIARE PER IL PRIMO MOMENTO
        return esercizi1mom;
    }

    public List<Object> getEsercizi2mom() {
        //INDICA IL NUMERO DI PARTI DEL CORPO DA ALLENARE, GLI ESERCIZI DA FARE, LE KCAL DA BRUCIARE PER IL SECONDO MOMENTO
        return esercizi2mom;
    }

    public List<Object> getEsercizi3mom() {
        //INDICA IL NUMERO DI PARTI DEL CORPO DA ALLENARE, GLI ESERCIZI DA FARE, LE KCAL DA BRUCIARE PER IL TERZO MOMENTO
        return esercizi3mom;
    }

    public int getNumeroMomento() {
        return numeroMomento;
    }

    public int getSizePartiOrdinate() {
        //INDICA IL NUMERO DI PARTI DEL CORPO DA ALLENARE 
        return sizePartiOrdinate;
    }

    
}
