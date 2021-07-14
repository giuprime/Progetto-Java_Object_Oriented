package Consultazioni;

import Impostazioni.JSON;
import Impostazioni.Richieste;
import Impostazioni.Xmlpars;
import java.util.Map;

public abstract class Messaggi {
    private final Xmlpars xmlpars = new Xmlpars("Impostazioni.xml");
    private final Richieste richieste = new Richieste(xmlpars.getElement("PROTOCOL"), xmlpars.getElement("SERVER_ADDRES"), xmlpars.getElement("SERVER_PORTA"));
    private final JSON json = new JSON();
    
    public Messaggi() {
        //INIZIALIZZA LA VARIABILE XMLPARS CON IL FILE IMPOSTAZIONI.XML
        if (!xmlpars.exists()) xmlpars.ImpoDefault(); 
    }    
    
    public abstract Map visualizzaDomande(String tabella, String email,String coach);
    
    public abstract String inviaRisposta(String id, String risposta);
    
    public abstract String mediaVoti(String coach);
    
    public abstract float prelevaMediaVoto(String tabella);

    public Xmlpars getXmlpars() {
        return xmlpars;
    }

    public Richieste getRichieste() {
        return richieste;
    }

    public JSON getJson() {
        return json;
    }
}
