
package Allenamento;

import java.util.List;

public class Esercizio {
    
    private final int size;
    private final int eserciziDB;
    private final int eserciziDB1;
    private final String tipo;
    private final List esercizi;
    private final List<Object> listaEsercizi;
    private final List<Object> listaMomenti;
    private final List<Object> listaPartiCorpo;
    private final List<Double> listaMetRep;
    private final List<Integer> shuffle;
    private final List<Integer> shuffle1;
    
    public Esercizio(List<Object> listaEsercizi,List<Object> listaMomenti,List<Object> listaPartiCorpo,List<Double> listaMetRep, List<Integer> shuffle,List<Integer> shuffle1,int size, int eserciziDB, int eserciziDB1, String tipo, List esercizi) {
        this.size = size;
        this.eserciziDB = eserciziDB;
        this.eserciziDB1 = eserciziDB1;
        this.tipo = tipo;
        this.esercizi = esercizi;
        this.listaEsercizi = listaEsercizi;
        this.listaMomenti = listaMomenti;
        this.listaPartiCorpo = listaPartiCorpo;
        this.listaMetRep = listaMetRep;
        this.shuffle = shuffle;
        this.shuffle1 = shuffle1;
    }


    public int getSize() {
        return size;
    }

    public int getEserciziDB() {
        return eserciziDB;
    }

    public int getEserciziDB1() {
        return eserciziDB1;
    }

    public String getTipo() {
        return tipo;
    }

    public List getEsercizi() {
        return esercizi;
    }

    public List<Object> getListaEsercizi() {
        return listaEsercizi;
    }

    public List<Object> getListaMomenti() {
        return listaMomenti;
    }

    public List<Object> getListaPartiCorpo() {
        return listaPartiCorpo;
    }

    public List<Double> getListaMetRep() {
        return listaMetRep;
    }

    public List<Integer> getShuffle() {
        return shuffle;
    }

    public List<Integer> getShuffle1() {
        return shuffle1;
    }

  
        
}
