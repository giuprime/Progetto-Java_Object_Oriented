package Allenamento;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SchedaPersonalizzata extends Diario {
    
    public Map prelevaTrainer(){ //SERVE PER PRELEVARE I DATI DEL TRAINER DA FAR VEDERE AL NOSTRO UTENTE NEL COMBO BOX QUANDO SCEGLIE UNA SCHEDA PERSONALIZZATA
        
        Map dati = new HashMap();
        InputStream richiesta = getRichieste().GetRichiesta("/scelta/prelevaTrainer", dati, null);
        dati.clear();
        dati = getJson().LeggiJson(richiesta);
                
        return dati;
    }
    
    public Map modificaSchedaPersonalizzata(List<Object> esercizi){
        
        Map dati = new HashMap();
        for (int i = 0; i < esercizi.size(); i++) {
            dati.put(""+i, trovaEsercizi((String)esercizi.get(i)));
        }
        return dati;
    }
    
   public List<String> trovaEsercizi(String nomeEsercizio){ //SERVE PER TROVARE GLI ESERCIZI DA METTERE NEL COMBO BOX QUANDO SI FA LA MODIFICA 
       
       //CREA UN HASHMAP CONTENENTE I VALORI
        Map dati = new HashMap();
        dati.put("nomeEsercizio",nomeEsercizio);
        
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/scelta/trovaEsercizi", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < dati.size(); i++) {
           lista.add((String) dati.get(i+""));
       }
        System.out.println("listaaaa " + lista);
       return lista;
   }
   
   public List<Double> getMetRep(List<Object> esercizi){//OTTIENE I MET E I REP PER OGNI ESERCIZIO GRAZIE AL METODO SOTTOSTANTE
        
        List<Double> repMin  = new ArrayList<>();
        for (int i = 0; i < esercizi.size(); i++) {
            Map dati = trovaRepMin((String) esercizi.get(i));
            double met = Double.parseDouble((String) dati.get("Met"));
            double rep = Double.parseDouble((String) dati.get("Rep"));
            repMin.add(met);
            repMin.add(rep);
        }
        return repMin ;
    }
    
    
    public Map trovaRepMin(String nomeEsercizio){//SERVE PER CERCARE I MER E REP PER OGNI ESERCIZIO 
       
       //CREA UN HASHMAP CONTENENTE I VALORI
        Map dati = new HashMap();
        dati.put("nomeEsercizio",nomeEsercizio);
        
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/scelta/trovaRepMin", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        
       return dati;
   } 
   
}
