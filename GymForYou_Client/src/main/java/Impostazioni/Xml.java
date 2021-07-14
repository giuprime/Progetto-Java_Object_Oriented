package Impostazioni;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class Xml {
    
    private Xmlpars xmlpars = new Xmlpars("Impostazioni.xml");
    private Xmlpars xmlpars2 = new Xmlpars("filexml.save");
    private JSON json = new JSON();
    private Richieste richieste = new Richieste(xmlpars.getElement("PROTOCOL"), xmlpars.getElement("SERVER_ADDRES"), xmlpars.getElement("SERVER_PORTA"));

    public Xml() {
        //INIZIALIZZA LA VARIABILE XMLPARS CON IL FILE IMPOSTAZIONI.XML
        if (!xmlpars.exists()) {
            //SE IL FILE IMPOSTAZIONI.XML NON ESISTE VIENE CREATO CON I VALORI DI DEAFULT
            xmlpars.ImpoDefault();           
        }
    }
    
    
      //METODO PER SCRIVERE FILE FILEXML.SAVE
    public void scriviXmlDati(String email){
        
        Map dati = new HashMap();
        Xmlpars parser2 = new Xmlpars("filexml.save");      
        dati = prendiDatiUtente(email);
        dati.put("Tipologia", "Utente");         
        parser2.ScriviXML("Utente", dati);
        
    }
    
    public void salvaXmlMisure(String email){
        
        //SCRIVE FILE MISURE.SAVE CON I VALORI APPENA INSERITI
        Xmlpars parser3 = new Xmlpars("misure.save");
        Map dati = prelevamisure(email);         
        parser3.ScriviXML("Misure", dati);
        //
    }
    
    public void salvaEmailUtente(String email,String parte_corpo){
        
        //SCRIVE FILE MISURE.SAVE CON I VALORI APPENA INSERITI
        Xmlpars parser3 = new Xmlpars("pesoutente.save");
        Map dati = new HashMap();
        dati.put("email", email);
        dati.put("parte_corpo", parte_corpo);
        parser3.ScriviXML("Utente", dati);
        //
    }
    
      //METODO PER SCRIVERE FILE FILEXML.SAVE
    public void esercizicorso(){
        Xmlpars parser5 = new Xmlpars("eserciziCorso/esercizi.xml");      
        Map dati = prendiEserciziCorso();
        parser5.ScriviXML("Esercizi_Corso", dati);
    }
    
    
    
    
       //METODO PER SCRIVERE FILE FILEXML.SAVE
    public void eserciziScheda(){
        //dati = new HashMap();
        Xmlpars parser2 = new Xmlpars("eserciziScheda/esercizi.xml");      
        Map dati = prendiEserciziScheda();
        parser2.ScriviXML("Esercizi_Scheda", dati);
    }
    
    
    
    //METODO PER PRELEVARE I VALORI DAL DB DELLA TABELLA UTENTE
    public Map prendiDatiUtente(String email){
        //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
        Map dati = new HashMap();
        dati.put("email", email);
        dati.put("Tabella", "utente");
        //
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/utente/prelevadati", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        return dati;
    }
    
    //METODO PER PRELEVARE LE MISURE INIZIALI/INTERMEDIE/FINALI DAL DB
    public Map prelevamisure(String email){
        //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
        Map dati = new HashMap();
        dati.put("email", email);
        dati.put("Tabella", "misure");
        //
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/utente/prelevamisure", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        
        return dati;
    }
    
    //METODO PER PRELEVARE GLI ESERCIZI DAL DB DELLA TABELLA ESERCIZICORSO
    public Map prendiEserciziCorso(){
        //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
        Map dati = new HashMap();
        //
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/scelta/prendiEserciziCorso", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        return dati;
    }
    
    //METODO PER PRELEVARE GLI ESERCIZI DAL DB DELLA TABELLA ESERCIZIscheda
    public Map prendiEserciziScheda(){
        //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
        Map dati = new HashMap();
        //
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/scelta/prendiEserciziScheda", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        return dati;
    }

    public Xmlpars getXmlpars() {
        return xmlpars;
    }

    public Xmlpars getXmlpars2() {
        return xmlpars2;
    }

    public JSON getJson() {
        return json;
    }

    public Richieste getRichieste() {
        return richieste;
    }
    
}
