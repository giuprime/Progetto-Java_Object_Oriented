package Autenticazione;

import Dashboard_Admin.Pannello_Admin;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Admin extends Persona implements LoginInterface{
    
    public Admin(){
    }
    
    @Override
    public void accedi(String email, String password) {
        //SCRIVO FILEXML.SAVE CON I VALORI PRELEVATI DAL DB
        Map dati = new HashMap();
        dati.put("email", email);
        getXmlpars2().ScriviXML("Admin", dati);
        //
        Pannello_Admin pannello_admin = new Pannello_Admin();
        pannello_admin.setVisible(true);
    }
    
     //METODO USATO NELL'ADMIN DASHBOARD PER PRELEVARE L'EMAIL, NOME E COGOME DI OGNI TRAINER E MEDICO
    public Map visualizzaRighe(){
        
        //CREA UN HASHMAP CONTENENTE I VALORI
        Map dati = new HashMap();
        dati.put("tabella","dottore");
        dati.put("tabella1", "trainer");
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/admin/visualizzaRighe", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        
        return dati; 
    }  
    
    public Map mostra(){
        
        //CREA UN HASHMAP CONTENENTE I VALORI
        Map dati = new HashMap();
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/gestione/visualizzaRighe", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);

        return dati;
    }  
    
    public Map mostra (String trainer){
        //CREA UN HASHMAP CONTENENTE I VALORI
            Map dati = new HashMap();
            //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
            InputStream richiesta = getRichieste().GetRichiesta("/gestione/prelevaTrainer", dati, null);
            //PUSLISCE L'HASHMAP
            dati.clear();
            //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
            dati = getJson().LeggiJson(richiesta);
            return dati;
    }
    
    public void inseriscicorso (String nomecorso, String ese1, String ese2, String ese3, String ese4, String ese5, String ese6, String ese7, String ese8, String ese9, String ese10, String nometrainer){
           //CREA UN HASHMAP CONTENENTE I VALORI
            Map dati = new HashMap();
            dati.put("nomecorso", nomecorso);
            dati.put("ese1", ese1);
            dati.put("ese2", ese2);
            dati.put("ese3", ese3);
            dati.put("ese4", ese4);
            dati.put("ese5", ese5);
            dati.put("ese6", ese6);
            dati.put("ese7", ese7);
            dati.put("ese8", ese8);
            dati.put("ese9", ese9);
            dati.put("ese10", ese10);
            dati.put("nometrainer", nometrainer);

            //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
            InputStream richiesta = getRichieste().GetRichiesta("/gestione/inseriscicorso", dati, null);
            //PUSLISCE L'HASHMAP
            dati.clear();
            //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
            dati = getJson().LeggiJson(richiesta);
    }
    
    public Map prelevaEsercizi(String nomecorso){
        Map dati = new HashMap();
        dati.put("nomecorso", nomecorso);
        InputStream richiesta = getRichieste().GetRichiesta("/gestione/prelevaEsercizi", dati, null);
        dati.clear();
        dati = getJson().LeggiJson(richiesta);
        
        return dati;
    }
    
    public String aggiornaEsercizi(String nomecorso, String ese1, String ese2, String ese3, String ese4, String ese5, String ese6, String ese7, String ese8, String ese9, String ese10, String ese11, String ese12, String ese13){
        String msg = "Esercizi Aggiornati";
        Map dati = new HashMap();
        dati.put("nomecorso", nomecorso);
        dati.put("ese1", ese1);
        dati.put("ese2", ese2);
        dati.put("ese3", ese3);
        dati.put("ese4", ese4);
        dati.put("ese5", ese5);
        dati.put("ese6", ese6);
        dati.put("ese7", ese7);
        dati.put("ese8", ese8);
        dati.put("ese9", ese9);
        dati.put("ese10", ese10);
        dati.put("ese11", ese11);
        dati.put("ese12", ese12);
        dati.put("ese13", ese13);
        
        InputStream richiesta = getRichieste().GetRichiesta("/gestione/aggiornaEsercizi", dati, null);
        dati.clear();
        dati = getJson().LeggiJson(richiesta);
        if (!dati.get("result").equals("Esercizi Aggiornati")) {
            msg= "Esercizi Non Aggiornati";
        }
        return msg;
    }
    
    
    public String eliminaCorso(String nomecorso){
        String msg = "Corso Eliminato!";
        Map dati = new HashMap();
        dati.put("nomecorso", nomecorso);
        
        InputStream richiesta = getRichieste().GetRichiesta("/gestione/eliminaCorso", dati, null);
        dati.clear();
        dati = getJson().LeggiJson(richiesta);
        if (!dati.get("result").equals("Corso Eliminato!")) {
            msg= "Corso Non Eliminato!";
        }
        return msg;
    }
    
}
