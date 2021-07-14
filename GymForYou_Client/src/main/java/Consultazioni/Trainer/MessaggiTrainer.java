package Consultazioni.Trainer;

import Autenticazione.Trainer;
import Consultazioni.Messaggi;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MessaggiTrainer extends Messaggi{
    
    private Trainer trainer;
    
    @Override
    public Map visualizzaDomande(String tabella, String email,String coach){
             
        Map dati = new HashMap();
        dati.put("tabella", tabella);
        dati.put("persona",email);
        dati.put("coach", coach);
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/consultazione/visualizzaDomande", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        
        return dati; 
    }
    
    @Override
    public String inviaRisposta(String id, String risposta){

        String msg = "Risposta inviata!";

        if (risposta.length() < 250) {
            Map dati = new HashMap();
            dati.put("id", id);
            dati.put("risposta", risposta);

            InputStream richiesta = getRichieste().GetRichiesta("/consultazione/inviaRisposta", dati, null);
            dati.clear();
            dati = getJson().LeggiJson(richiesta);
            String result = (String) dati.get("result");
            if(!result.equals("Risposta inviata!")) {
                msg = "Risposta non inviata";
            }
        }else{
            msg = "Risposta non inviata! La domanda contiene più di 250 caratteri!";
        }
        
        return msg;
    }
    
    @Override
    public String mediaVoti(String coach){
        
        String msg = "Media voti ottenuta!";
        String risultato = "";
        Map dati = new HashMap();
        
        if (coach.equals("trainer")) {
            trainer = new Trainer();
            dati.put("email", trainer.getEmail());
        }
        dati.put("tabella", "consultazione");
        dati.put("coach", coach);

        InputStream richiesta = getRichieste().GetRichiesta("/consultazione/mediaVoti", dati, null);
        dati.clear();
        dati = getJson().LeggiJson(richiesta);
        String result = (String) dati.get("result");
        if(result.equals("Media voti ottenuta!")) {
            risultato = (String) dati.get("risultato");   
        }
        return risultato;
    }
    
    @Override
    public float prelevaMediaVoto(String tabella){
        
        float risultato = 0;
        
        trainer = new Trainer();
        Map dati = new HashMap();
        dati.put("email", trainer.getEmail());
        dati.put("tabella", tabella);

        InputStream richiesta = getRichieste().GetRichiesta("/recensioni/prelevaMediaVoto", dati, null);
        dati.clear();
        dati = getJson().LeggiJson(richiesta);
        String result = (String) dati.get("result");
        if(!result.equals("Voto prelevato!")) {
            risultato = 0;
        }else{
            risultato = Float.parseFloat("" + dati.get("risultato"));
        }
        return risultato;
    }
    
    
}
