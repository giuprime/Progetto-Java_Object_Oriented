package Allenamento;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SchedaCorso extends Diario {
    
    public Map prelevaCorsi(){ //MOSTRA I CORSI NEL COMBO BOX
        
        Map dati = new HashMap();
        InputStream richiesta = getRichieste().GetRichiesta("/scelta/prelevaCorsi", dati, null);
        dati.clear();
        dati = getJson().LeggiJson(richiesta);
               
        return dati;
    }
    
    public String ottieniEmail(String nomecorso){//OTTIENE LA MAIL DEL TRAINER CHE TIENE IL CORSO
        
        //CREA UN HASHMAP CONTENENTE I VALORI
        Map dati = new HashMap();
        dati.put("nomecorso", nomecorso);
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/scelta/ottieniEmail", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        
        String email = (String)dati.get("email"); 
        
        return email;
    }
    
    public Map prendiEserciziCorso(String tipo){//PRELEVA GLI ESERCIZI DEL CORSO NEL CASO IN CUI VANNO MODIFICATI
        //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
        Map dati = new HashMap();
        //
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/scelta/prendiEserciziCorso", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        Map risultati = new HashMap();
        
        for (int i = 1; i < 14; i++) {
            if (!((String)dati.get(tipo+"_"+i) == null)) {
                
                risultati.put(tipo+"_"+i, dati.get(tipo+"_"+i));
                risultati.put(tipo+"_"+i+"_met", dati.get(tipo+"_"+i+"_met"));
                risultati.put(tipo+"_"+i+"_rep", dati.get(tipo+"_"+i+"_rep"));
            }
        }
        return risultati;
    }

    
}