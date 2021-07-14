package Allenamento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnaParte extends PartiCorpo implements Interfaccia{
   
    
    @Override
    public Map assegnaEsercizi(Esercizio product) {
        for (int i = 0; i < product.getSize(); i++) {
            if (i >= (product.getSize()-2)) {
                product.getListaPartiCorpo().add(product.getEsercizi().get(i));
            }else{
                product.getListaMomenti().add(product.getEsercizi().get(i));
            }
        }   
        
        for (int j = 0; j < product.getListaMomenti().size(); j = j+3) {
            Collections.shuffle(product.getShuffle());
            Collections.shuffle(product.getShuffle1());
            int numeroEsercizi = (int) product.getListaMomenti().get(j+1);
            for (int i = 1; i <= numeroEsercizi; i++) {
                
                if (!product.getTipo().equals("Scheda Personalizzata")) {
                    
                    schedaCorso(i, product.getTipo(), product.getShuffle1(), product.getListaEsercizi(), product.getListaMetRep());
                
                }else{
                
                    schedaPersonalizzata(i, 1,1, product.getTipo(), product.getShuffle(), product.getListaEsercizi(),  product.getListaPartiCorpo(), product.getListaMetRep());
                
                }
            }
        }   
        Map dati = new HashMap();
        dati.put("ListaMomenti", product.getListaMomenti());
        dati.put("ListaEsercizi", product.getListaEsercizi());
        dati.put("ListaMetRep", product.getListaMetRep());
        /*
        System.out.println("size "+ product.getSize()); SIZE = 8
        System.out.println("esercizi "+ product.getEsercizi()); esercizi [1, 2, 56, 1, 2, 56, 0.8316008316008316, Bicipiti] IL PRIMO ELEMENTO è LA PARTE DEL CORPO DA ALLENARE IL SECONDO GLI ESERCIZI DA FARE E IL TERZO LA PARTE DEL COPRO DA ALLENARE
        System.out.println("ListaMomenti " +product.getListaMomenti()); ListaMomenti [4, 9, 133, 4, 7, 89]
        System.out.println("ListaEsercizi " + product.getListaEsercizi()); ListaEsercizi [Barchetta, Plank addominali, Affondi frontali, Plank laterale, Hollow push ups, Triceps Dips, V push ups, Piegamenti a terra, Crunch addominale, Barchetta, Plank laterale, Piegamenti in verticale, Affondi frontali, Piegamenti a terra, Crunch addominale, Plank addominali]
        System.out.println("ListaMetRep "+ product.getListaMetRep()); ListaMetRep [8.0, 11.0, 7.0, 10.0, 8.0, 14.0, 9.0, 10.0, 8.0, 12.0, 7.0, 15.0, 8.0, 10.0, 8.0, 13.0, 8.0, 15.0, 8.0, 11.0, 9.0, 10.0, 9.0, 7.0, 8.0, 14.0, 8.0, 13.0, 8.0, 15.0, 7.0, 10.0]        
        System.out.println("Shuffle "+ product.getShuffle()); //Shuffle [1, 2, 4, 3, 5]
        System.out.println("Shuffle 1 " + product.getShuffle1()); Shuffle 1 [3, 7, 2, 8, 1, 4, 9, 6, 5, 10]
        */
        return dati;
    }

    @Override
    public List<Object> assegnaNumEsercizi(Momenti momenti) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ArrayList> calcoloCalorie(Intensita intensita) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map assegnaCalorie(AssegnaCalorie assegna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
