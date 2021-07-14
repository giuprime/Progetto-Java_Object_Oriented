package Autenticazione;

import Dashboard_Medico.Pannello_Medico;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Medico extends Persona implements LoginInterface{
        
    public Medico(){
    }    
    
   @Override
    public void accedi(String email, String password) {
        Map dati = new HashMap();
        dati.put("email", email);
        getXmlpars2().ScriviXML("Medico", dati);
        //
        Pannello_Medico pannello = new Pannello_Medico();
        //MOSTRA FINESTRA DASHBOARD DOTTORE
        pannello.setVisible(true);
    }

    // METODO PER PRELEVARE L'EMAIL DEGLI UTENTI CHE HANNO COMPILATO IL QUESTIONARIO
    public Map visualizzaUtenti(){
        //CREA UN HASHMAP CONTENENTE I VALORI
        Map dati = new HashMap();
        dati.put("tabella", "questionario");
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/dottore/visualizzaQuestionari", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        
        return dati;     
    } 
    
    //METODO PER PRELEVARE LE RISPOSTE DEI QUESTIONARI DEI VARI UTENTI
    public Map prelevaRisposte(String email_riga){
        //CREA UN HASHMAP CONTENENTE I VALORI
        Map dati = new HashMap();
        dati.put("email", email_riga);
        dati.put("tabella", "questionario");
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/dottore/prelevaRisposte", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        
        return dati;     
    }
    
    //METODO USATO PER EFFETTUARE L'UPDATE DELL'ESITO DI UN UTENTE
    public String esito(String email_riga, String esito){
        
        String msg = "Esito Positivo";
        if (!email_riga.isEmpty()) {
            //CREA UN HASHMAP CONTENENTE I VALORI
            Map dati = new HashMap();
            dati.put("email", email_riga);
            dati.put("esito", esito);
            dati.put("Tabella", "questionario");
            dati.put("Tabella1", "utente");
            //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
            InputStream richiesta = getRichieste().GetRichiesta("/dottore/esito", dati, null);
            //PUSLISCE L'HASHMAP
            dati.clear();
            //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
            dati = getJson().LeggiJson(richiesta);
            //INSERISCO NELLA VARIABILE RESULT IL VALORE DELLA CHIAVE RESULT DELL'HASHMAP DATI
            String result = (String) dati.get("result");
            msg = result;
            if(!result.equals("Esito Positivo")) {
                msg = "Modifiche Fallite";
            }
        }else{
            msg = "Campo vuoto!";
        }
        return msg;
    }
}
