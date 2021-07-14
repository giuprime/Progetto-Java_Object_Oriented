package Consultazioni.Utente;

import Autenticazione.Utente;
import Impostazioni.JSON;
import Impostazioni.Richieste;
import Impostazioni.Xmlpars;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MessaggiUtente{
    
    private final Xmlpars xmlpars = new Xmlpars("Impostazioni.xml");
    private final JSON json = new JSON();
    private final Richieste richieste = new Richieste(xmlpars.getElement("PROTOCOL"), xmlpars.getElement("SERVER_ADDRES"), xmlpars.getElement("SERVER_PORTA"));
    private Utente utente;

    public MessaggiUtente() {
         //INIZIALIZZA LA VARIABILE XMLPARS CON IL FILE IMPOSTAZIONI.XML
        if (!xmlpars.exists()) xmlpars.ImpoDefault();           
    }
    
    public String invia(String coach,String categoria,String email, String domanda){
        utente = new Utente();
        String msg = "Domanda inviata correttamente!";
        if(!categoria.isEmpty()){
            if(!domanda.isEmpty()){
                if(domanda.length() < 250){
                    Map dati = new HashMap();
                    dati.put("utente", utente.getEmail());
                    dati.put("coach", coach);
                    dati.put("emailMedicoTrainer", email);
                    dati.put("categoria", categoria);
                    dati.put("domanda", domanda);
                    InputStream richiesta = getRichieste().GetRichiesta("/consultazione/utenteInvia", dati, null);
                    dati.clear();
                    dati = getJson().LeggiJson(richiesta);
                    String result = (String) dati.get("result");
                    if(!result.equals("Domanda inviata correttamente!")) {
                        msg = "Domanda non inviata";
                    }
                }else{
                    msg = "Domanda non inviata! La domanda contiene più di 250 caratteri!";
                }
            }else{
                msg = "Scrivi il testo della domanda";
            }
        }else{
            msg = "Selezionare la categoria della domanda";
        }
        
        return msg;
    }
    
    public Map visualizzaMediciTrainer(String tabella){
        
        Map dati = new HashMap();
        dati.put("tabella", tabella);
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/consultazione/visualizzaMediciTrainer", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        
        return dati; 
    }
    
    public String inviaValutazione(String id, String valutazione){

        String msg = "Valutazione inviata!";

        Map dati = new HashMap();
        dati.put("id", id);
        dati.put("valutazione", valutazione);

        InputStream richiesta = getRichieste().GetRichiesta("/consultazione/inviaValutazione", dati, null);
        dati.clear();
        dati = getJson().LeggiJson(richiesta);
        String result = (String) dati.get("result");
        if(!result.equals("Valutazione inviata!")) {
            msg = "Valutazione non inviata";
        }
        
        return msg;
    }
    public Map visualizzaRisposte(String coach){
        
        utente = new Utente();
        
        Map dati = new HashMap();
        dati.put("coach", coach);
        dati.put("tabella", "consultazione");
        dati.put("utente", utente.getEmail());
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/consultazione/visualizzaRisposte", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        return dati; 
    }
    
    public String recensione(String email, String voto,String tabella){
        
        String msg = "Recensione effettuata!";
        if (!email.equals("")) {
            if (!voto.equals("")) {
                Map dati = new HashMap();
                dati.put("email", email);
                dati.put("voto", voto);
                dati.put("tabella", tabella);

                InputStream richiesta = getRichieste().GetRichiesta("/recensioni/inviaRecensione", dati, null);
                dati.clear();
                dati = getJson().LeggiJson(richiesta);
                String result = (String) dati.get("result");
                if(!result.equals("Recensione effettuata!")) {
                    msg = "Recensione non effettuata!";
                }
            }else{
                msg = "Inserisci voto!";
            }
        }else{
            msg = "Seleziona un'email!";
        }
        
        return msg;
    }

    public Xmlpars getXmlpars() {
        return xmlpars;
    }

    public JSON getJson() {
        return json;
    }

    public Richieste getRichieste() {
        return richieste;
    }
    
    
}
