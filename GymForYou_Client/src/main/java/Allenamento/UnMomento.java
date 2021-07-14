package Allenamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnMomento  implements Interfaccia {


    @Override
    public Map assegnaEsercizi(Esercizio product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> assegnaNumEsercizi(Momenti momenti) {
        
        int numEse1= 0;

        for(int i = 0; i<momenti.getIntensita().length; i++){
            if(momenti.getPrimomomento().get(0).contains(momenti.getIntensita()[i])){ //Verifica l'intensita in base al giorno 
                int[] a = (int[]) momenti.getDati().get(momenti.getSizePartiOrdinate());// a = AD UNO DEGLI ARRAY PRESENTI IN MOMENTI (CLASSE) CHE CONTEBGONO IL NUMERO DEGLI 
                                                                                             //ESERCIZI IN BASE ALL'INTENSITà
                numEse1= a[i]; //PRELEVA IL NUMERO DI ESERCIZI DA ASSEGNARE AL PRIMO MOMENTO
            }
        }
        //CREIAMO UN ARRAY DI TIPO STRINGA E INSERIAMO IL PRIMO MOMENTO SEPARATO DAGLI SPAZI
        String[] str = momenti.getPrimomomento().get(0).split(" ");//--> str = {Lunedi Mattina (Leggero) 56}
        //AGGIUNGIAMO IL NUMERO DI PARTI DEL CORPO DA ALENARE A ESERCIZI1MOM
        momenti.getEsercizi().add(momenti.getSizePartiOrdinate());
        //AGGIUNGIAMO IL NUMERO DI ESERCIZI DA SVOLGERE PER IL PRIMO MOMENTO A ESERCIZI1MOM
        momenti.getEsercizi().add(numEse1);
        //PRELEVIAMO L'ELEMENTO IN POSIZIONE TRE DELL'ARRAY STR CHE EQUIVALE ALLE KCAL DA BRUCIARE
        momenti.getEsercizi().add(str[3]);
        //ALLA FINE ESERCIZI SARà COMPOSTA DALLE PARTI DEL CORPO DA ALLENARE, DAL NUM DI ESE DA FARE IL PRIMO MOMENTO E DALLE KCAL DA BRUCIARE PER IL PRIMO MOMENTO,            
        return momenti.getEsercizi();
        
    }

    @Override
    public List<ArrayList> calcoloCalorie(Intensita intensita) {//IN BASE ALL'INTENSITà INDICATA ANDREMO A SUDDIVIDERE IL MODO IN CUI DOVRANNO ESSERE BRUCIATE LE CALORIE
                                                                //TENENDO IN CONSIDERAZIONE GLI ARRAY DICHIARATI SOPRA
        //OTTIENIAMO L'INTENSITà SOTTO FORMA DI SGTRINGHE [L L, M M, ECC]
        //NON SI USA L'HASMAP PERCHé NON DOBBIAMO DIVIDERE NIENTE LE CALORIE VERRANNO BRUCIATE TUTTE IN UN SOLO MOMENTO
        //caso in cui c'è solo la sera
        if (((String) intensita.getWeeklist().get(intensita.getI()).get(0)).equals("-") && ((String) intensita.getWeeklist().get(intensita.getI()).get(1)).equals("-")) {
            intensita.getWeeklist().get(intensita.getI()).set(2, (String) intensita.getWeeklist().get(intensita.getI()).get(2) + " " + Math.round(intensita.getCalorie()) );
        //caso in cui c'è solo il pomeriggio
        }else if(((String) intensita.getWeeklist().get(intensita.getI()).get(0)).equals("-") && ((String) intensita.getWeeklist().get(intensita.getI()).get(2)).equals("-")) {
            intensita.getWeeklist().get(intensita.getI()).set(1, (String) intensita.getWeeklist().get(intensita.getI()).get(1) + " " + Math.round(intensita.getCalorie()) );
        //caso in cui c'è solo la mattina
        }else if(((String) intensita.getWeeklist().get(intensita.getI()).get(1)).equals("-") && ((String) intensita.getWeeklist().get(intensita.getI()).get(2)).equals("-")) {
            intensita.getWeeklist().get(intensita.getI()).set(0, (String) intensita.getWeeklist().get(intensita.getI()).get(0) + " " + Math.round(intensita.getCalorie()) );
        }  
        
        return intensita.getWeeklist();
    }

    @Override
    public Map assegnaCalorie(AssegnaCalorie assegna) {
        //ListaMomenti [4, 9, 133, 4, 7, 89] 4=parti del corpo 9=gli esercizi da fare 133= calorie da perdere
        //FACCIAMO LA CONVERSIONE PERCHé LISTA MOMENTI C'è IN DIARIO è DI TIPO OBJECT
        int numeroEse = Integer.parseInt((String)assegna.getListaMomenti().get(1));
        assegna.getDiario().calcoloCalorie(numeroEse, assegna.getListaMomenti(), assegna.getListaMetRep()).forEach((n) -> assegna.getListaKcalRipetizione().add(n));
        
        Map risultati = new HashMap();
        
        risultati.put("RepMin", assegna.getListaKcalRipetizione());
        risultati.put("ListaMomenti", assegna.getListaMomenti());
        
        return risultati;
    }
    
}
