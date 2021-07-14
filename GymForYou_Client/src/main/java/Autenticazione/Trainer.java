package Autenticazione;

import Dashboard_Trainer.Pannello_Trainer;
import Impostazioni.Xml;
import java.util.HashMap;
import java.util.Map;

public class Trainer extends Persona implements LoginInterface{

    public Trainer() {
    }

    
    @Override
    public void accedi(String email, String password) { 
        Map dati = new HashMap();
        dati.put("Email", email);
        //SCRIVE IL FILE XML DELL'ATTORE IN QUESTIONE CON LA SUA EMAIL
        getXmlpars2().ScriviXML("Trainer", dati);
        

        //CREA IL FILE ESERCIZICORSO/ESERCIZI.XML OGNI VOLTA CHE VIENE FATTO IL LOGIN DI QUALSIAI ATTORE VIENE SOVRASCRITTO IL FILE XML CON GLI ESERCIZI PRESENTI NEL DB
        Xml xml = new Xml();
        xml.esercizicorso();
        xml.eserciziScheda();
        //REINDIRIZZA L'ATTORE ALLA SUA DASHBOARD
        Pannello_Trainer pannello_trainer = new Pannello_Trainer();
        pannello_trainer.setVisible(true);
        
    }
    
    
}
