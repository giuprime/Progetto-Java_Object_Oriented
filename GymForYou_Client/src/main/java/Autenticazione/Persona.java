package Autenticazione;

import Impostazioni.JSON;
import Impostazioni.Richieste;
import Impostazioni.Xmlpars;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Persona {
    
    private String email;
    private String password;
    private float peso, altezza, polso, caviglia;
    private float crf_vita, crf_collo, crf_fianchi;
    private double massagrassa, massamagra;
    private final String nome, cognome;
    private final String genere;
    private final Xmlpars xmlpars = new Xmlpars("Impostazioni.xml");
    private final JSON json = new JSON();
    private final Xmlpars xmlpars2 = new Xmlpars("filexml.save");
    private final Richieste richieste = new Richieste(xmlpars.getElement("PROTOCOL"), xmlpars.getElement("SERVER_ADDRES"), xmlpars.getElement("SERVER_PORTA"));

    
    public Persona(String email, String password){
        settings();
        this.email = email;
        this.password = password;
        this.nome = xmlpars2.getElement("Nome");
        this.cognome = xmlpars2.getElement("Cognome");
        this.genere = xmlpars2.getElement("Genere");
    }

    public Persona(){
        settings();
        this.email = xmlpars2.getElement("Email");
        this.nome = xmlpars2.getElement("Nome");
        this.cognome = xmlpars2.getElement("Cognome");
        this.genere = xmlpars2.getElement("Genere");
        if (xmlpars2.nameRoot().equals("Utente") ) {
            this.peso = Float.parseFloat(xmlpars2.getElement("Peso"));
            this.altezza = Float.parseFloat(xmlpars2.getElement("Altezza"));
            this.polso = Float.parseFloat(xmlpars2.getElement("Polso"));
            this.caviglia = Float.parseFloat(xmlpars2.getElement("Caviglia"));
            this.crf_vita = Float.parseFloat(xmlpars2.getElement("Circonferenza_Vita"));
            this.crf_collo = Float.parseFloat(xmlpars2.getElement("Circonferenza_Collo"));
            this.crf_fianchi = Float.parseFloat(xmlpars2.getElement("Circonferenza_Fianchi"));
            this.massagrassa = Double.parseDouble(xmlpars2.getElement("Massa_Grassa"));
            this.massamagra = Double.parseDouble(xmlpars2.getElement("Massa_Magra"));
        }
    }
    
    private void settings(){
        //INIZIALIZZA LA VARIABILE XMLPARS CON IL FILE IMPOSTAZIONI.XML
        if (!xmlpars.exists()) xmlpars.ImpoDefault();    
    }
    
     public void accedi(LoginInterface accesso){
        accesso.accedi(this.email, this.password);
    }
    
    
    //METODO UTILIZZATO NEL LOGIN PER OTTENERE IL TYPE DI UTENTE CHE SI STA LOGGANDO
    public String controllo(String email, String password) {
        
        String msg;
        if(!email.isEmpty()) {
            if(!password.isEmpty()) {
                //CREA UN HASHMAP CONTENENTE I VALORI
                Map dati = new HashMap();
                dati.put("email", email);                       //("email","mario@rossi.it")
                dati.put("password", password);                 //("password","mariorossi")
                dati.put("tabella", "credenziali");             //("tabella","credenziali")
                //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
                InputStream richiesta = getRichieste().GetRichiesta("/controllo/email", dati, null);
                //PUSLISCE L'HASHMAP
                dati.clear();
                //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
                dati = getJson().LeggiJson(richiesta);                                   //("RESULT" ,"UTENTE")
                //INSERISCO NELLA VARIABILE RESULT IL VALORE DELLA CHIAVE RESULT DELL'HASHMAP DATI
                String result = (String) dati.get("result");                        //RESULT = "UTENTE";
                //STRING MSG E' UGALE AL VALORE DELLA STRINGA RESULT
                msg = result;                       
                if(!result.equals("Utente") && !result.equals("Medico") && !result.equals("Trainer") && !result.equals("Admin")) {
                    msg = "Credenziali errate.";
                }
            } else {
                msg = "Inserire la password";
               
            }
        } else {
            msg = "Inserire il nome utente";
        }
        return msg;   
    }
    
    public String verificaModificaPassword(String email, String vecchiapass, String nuovapass){
                                
        String msg = "Password modificata con successo!";
        
        if (!email.isEmpty() && !vecchiapass.isEmpty() && !nuovapass.isEmpty()) {
            //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
            Map dati = new HashMap();
            dati.put("email", email);
            dati.put("vecchiapass", vecchiapass);
            dati.put("nuovapass", nuovapass);
            dati.put("tabella", "credenziali");
            //
            
            //INSERISCO NELLA VARIABILE RESULT IL VALORE DELLA CHIAVE RESULT DELL'HASHMAP DATI
            InputStream richiesta = getRichieste().GetRichiesta("/impostazioni/verificaModificaPassword", dati, null);
            //PUSLISCE L'HASHMAP
            dati.clear();
            //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
            dati = getJson().LeggiJson(richiesta);
            //INSERISCO NELLA VARIABILE RESULT IL VALORE DELLA CHIAVE RESULT DELL'HASHMAP DATI
            String result = (String) dati.get("result");
            msg = result;

            if(result.equals("Password non coincidono")) {
                msg = "Password non coincidono";
            }else if(!result.equals("Password modificata con successo!")){
                msg = "Modifica password fallita!";
            }
        }else{
            msg = "Campi password vuoti!";
        }
        return msg;
    }
    
    public  boolean verificaEmail(String email){
        
        String msg;
        //CREA UN HASHMAP CONTENENTE I VALORI
        Map dati = new HashMap();
        dati.put("email", email);
        dati.put("tabella", "credenziali");
        //
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/controllo/emaildoppia", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        //INSERISCO NELLA VARIABILE RESULT IL VALORE DELLA CHIAVE RESULT DELL'HASHMAP DATI
        String result = (String) dati.get("result");
        //STRING MSG E' UGALE AL VALORE DELLA STRINGA RESULT
        msg = result;
        
        Boolean risultato;
        
        //RITORNA TRUE NEL CASO IN CUI L'EMAIL E' GIA' UTILIZZATA DA UN ALTRO UTENTE
        if (result.equals("Email Presente")) {
           risultato=   true;
        }else{
           risultato =  false; 
        }
        
        return risultato;
    }    
    
    public String inserisciAccount(String email, String nome, String cognome, String genere, String password ){
        //float altezza = (float)altezza;
        String msg = "Registrazione Effettuata";
        if (!email.isEmpty() &&  !nome.isEmpty() && !cognome.isEmpty() 
                && !genere.isEmpty() &&!password.isEmpty()) {
            //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
            Map dati = new HashMap();
            dati.put("email", email);
            dati.put("nome", nome);
            dati.put("cognome", cognome);
            dati.put("genere", genere);
            dati.put("password", password);
            dati.put("tabella", "credenziali");
            dati.put("tabella1", "trainer");
            dati.put("tabella2", "dottore");
            //
            //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
            InputStream richiesta = getRichieste().GetRichiesta("/admin/inserisciAccount", dati, null);
            //PUSLISCE L'HASHMAP
            dati.clear();
            //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
            dati = getJson().LeggiJson(richiesta);
            //INSERISCO NELLA VARIABILE RESULT IL VALORE DELLA CHIAVE RESULT DELL'HASHMAP DATI
            String result = (String) dati.get("result");
            msg = result;

            if(!result.equals("Registrazione Effettuata")) {
                msg = "Registrazione Fallita";
            }
        }else{
            msg = "Registrazione Fallita";
        }
        return msg;
    }
    
    public String eliminaAccount(String email){
        
        String msg = "Account eliminato";
        //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
        Map dati = new HashMap();
        dati.put("email",email);
        //
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/admin/eliminaAccount", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        //INSERISCO NELLA VARIABILE RESULT IL VALORE DELLA CHIAVE RESULT DELL'HASHMAP DATI
        String result = (String) dati.get("result");
        msg = result;
        if(!result.equals("Account eliminato")) {
            msg = "Impossbile eliminare account";
        }
        return msg;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getGenere() {
        return genere;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltezza() {
        return altezza;
    }

    public float getPolso() {
        return polso;
    }

    public float getCaviglia() {
        return caviglia;
    }

    public float getCrf_vita() {
        return crf_vita;
    }


    public float getCrf_collo() {
        return crf_collo;
    }


    public float getCrf_fianchi() {
        return crf_fianchi;
    }


    public double getMassagrassa() {
        return massagrassa;
    }


    public double getMassamagra() {
        return massamagra;
    }

    
    public Xmlpars getXmlpars() {
        return xmlpars;
    }

    public JSON getJson() {
        return json;
    }

    public Xmlpars getXmlpars2() {
        return xmlpars2;
    }

    public Richieste getRichieste() {
        return richieste;
    }
 
    
}
