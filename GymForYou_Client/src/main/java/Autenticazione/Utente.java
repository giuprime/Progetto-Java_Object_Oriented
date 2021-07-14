package Autenticazione;

import Dashboard_Utente.Pannello_Utente;
import Dashboard_Utente.ScegliVisualizza;
import Dashboard_Utente.VediDueMomenti;
import Dashboard_Utente.VediTreMomenti;
import Dashboard_Utente.VediUnMomento;
import Impostazioni.Xml;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utente extends Persona implements LoginInterface{
    
    private String questionario;
    private String esito;
    private double risultato = 0;
    
    public Utente(){
        this.questionario = getXmlpars2().getElement("Questionario");
        this.esito = getXmlpars2().getElement("Esito_Dottore");
    }
    
    @Override
    public void accedi(String email, String password) {
         
        Xml xml = new Xml();
        //CREA IL FILE ESERCIZICORSO/ESERCIZI.XML OGNI VOLTA CHE VIENE FATTO IL LOGIN DI QUALSIAI ATTORE VIENE SOVRASCRITTO IL FILE XML CON LE SUE MISURE E I SUOI DATI ANAGRAFICI
        xml.scriviXmlDati(email);
        xml.salvaXmlMisure(email);
        //MOSTRA FINESTRA DASHBOARD UTENTE
        Pannello_Utente dash = new Pannello_Utente();
        dash.setVisible(true);
    }

    // METODO PER REGISTRARE UN NUOVO UTENTE
     String registrazione(String email, String password, String nome, String cognome, String genere, float peso, float altezza) {
        //float altezza = (float)altezza;
        String msg = "Registrazione Effettuata";
        if (!email.isEmpty() && !password.isEmpty() && !nome.isEmpty() && !cognome.isEmpty() 
                && !genere.isEmpty() && altezza!=0 && peso!=0) {
            //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
            Map dati = new HashMap();
            dati.put("email", email);
            dati.put("password", password);
            dati.put("nome", nome);
            dati.put("cognome", cognome);
            dati.put("genere", genere);
            dati.put("peso", Float.toString(peso));
            dati.put("altezza", Float.toString(altezza));
            dati.put("tabella", "credenziali");
            dati.put("tabella1", "utente");
            //
            //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
            InputStream richiesta = getRichieste().GetRichiesta("/registrazione/utente", dati, null);
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
            /*else{
                super.setEmail(email);
                super.setNome(nome);
                super.setCognome(cognome);
                this.genere = genere;
                this.altezza = altezza;
                this.peso = peso;
            }
            */
        }else{
            msg = "Registrazione Fallita";
        }
        return msg;
    }
 
    //METODO USATO PER MODIFICARE L'ALTEZZA E IL PESO
    public String modificaPesoAltezza(float pesonuovo, float altezzanuovo){

        String msg = "Informazioni Aggiornate";
        if(pesonuovo!= 0 && altezzanuovo!=0){
            //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
            Map dati = new HashMap();
            dati.put("email", getEmail());
            dati.put("pesonuovo", Float.toString(pesonuovo));
            dati.put("altezzanuovo", Float.toString(altezzanuovo));
            dati.put("tabella", "utente");
            //
            //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
            InputStream richiesta = getRichieste().GetRichiesta("/impostazioni/modificaPesoAltezza", dati, null);
            //PUSLISCE L'HASHMAP
            dati.clear();
            //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
            dati = getJson().LeggiJson(richiesta);
            //INSERISCO NELLA VARIABILE RESULT IL VALORE DELLA CHIAVE RESULT DELL'HASHMAP DATI
            String result = (String) dati.get("result");
            msg = result;

            if(!result.equals("Informazioni Aggiornate")) {
                msg = "Modifica password fallita!";
            }
            }else{
                msg = "Campi vuoti";
            }
        return msg;
    }
    
    //METODO PER ELIMINARE UN ACCOUNT UTENTE
    public String eliminaAccount(){

        String msg = "Account eliminato";
        //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHIAVI-VALORI
        Map dati = new HashMap();
        dati.put("email", getEmail());
        //
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/impostazioni/eliminaAccount", dati, null);
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
    
    // METODO PER INSERIRE RISPOSTE DEL QUESTIONARIO NEL DB
    public String invia(String email, String d1, String d2,String d3, String d4,String d5, String d6,
                        String d7, String d8, String d9, String d10, String d11, String d12, String d13){
        
        
        String msg = "Dati inviati";
        if (!email.isEmpty() && !d1.isEmpty() && !d2.isEmpty() && !d3.isEmpty() 
            && !d4.isEmpty() && !d5.isEmpty() && !d6.isEmpty() && !d7.isEmpty() && !d8.isEmpty() 
            && !d9.isEmpty() && !d10.isEmpty() && !d11.isEmpty() && !d12.isEmpty() && !d13.isEmpty()) {
            
            //CREA UN HASHMAP CONTENENTE I VALORI
            Map dati = new HashMap();
            dati.put("email", email);
            dati.put("d1", d1);
            dati.put("d2", d2);
            dati.put("d3", d3);
            dati.put("d4", d4);
            dati.put("d5", d5);
            dati.put("d6", d6);
            dati.put("d7", d7);
            dati.put("d8", d8);
            dati.put("d9", d9);
            dati.put("d10", d10);
            dati.put("d11", d11);
            dati.put("d12", d12);
            dati.put("d13", d13);
            dati.put("Tabella", "questionario");
            //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
            InputStream richiesta = getRichieste().GetRichiesta("/utente/inviaQuestionario", dati, null);
            //PUSLISCE L'HASHMAP
            dati.clear();
            //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
            dati = getJson().LeggiJson(richiesta);
            //INSERISCO NELLA VARIABILE RESULT IL VALORE DELLA CHIAVE RESULT DELL'HASHMAP DATI
            String result = (String) dati.get("result");
            msg = result;

            if(!result.equals("Dati inviati")) {
                msg = "Dati non inviati";
            }
        }else{
            msg = "Campi vuoti";
        }
        return msg;

    }
   
    
    //METODO PER SALVARE NEL DB LE VARIE CIRCONFERENZE E LA MASSA GRASSA
    public String salvaCirconferenze(String vita, String fianchi, String collo, String massa_grassa){
        
        String msg = "Circonferenze Modificate";
        if (!vita.isEmpty() && !fianchi.isEmpty() && !collo.isEmpty()) {
            
            //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
            Map dati = new HashMap();
            dati.put("email", getEmail());
            dati.put("vita", vita);
            dati.put("fianchi", fianchi);
            dati.put("collo", collo);
            dati.put("massa_grassa", massa_grassa);
            dati.put("Tabella", "utente");
            //
            //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
            InputStream richiesta = getRichieste().GetRichiesta("/utente/calcoloMassaGrassa", dati, null);
            //PUSLISCE L'HASHMAP
            dati.clear();
            //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
            dati = getJson().LeggiJson(richiesta);
            //INSERISCO NELLA VARIABILE RESULT IL VALORE DELLA CHIAVE RESULT DELL'HASHMAP DATI
            String result = (String) dati.get("result");
            msg = result;
            
            if(!result.equals("Circonferenze Modificate")) {
                msg = "Modifiche Fallite";
            }
        }else{
            msg = "Modifiche Fallite";
        }
        return msg;
    }
    
    //METODO PER SALVARE NEL DB LE CIRCONFERENZE DELLA CAVIGLIA E DEL POLSO
    public String salvaCrf_caviglia_polso(String caviglia, String polso){
        
        String msg = "Circonferenze Inserite";
        if (!caviglia.isEmpty() && !polso.isEmpty()) {
            
            Map dati = new HashMap();
            dati.put("email", getEmail());
            dati.put("caviglia", caviglia);
            dati.put("polso", polso);
            dati.put("Tabella", "utente");
            //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
            InputStream richiesta = getRichieste().GetRichiesta("/utente/crfCavigliaPolso", dati, null);
            //PUSLISCE L'HASHMAP
            dati.clear();
            //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
            dati = getJson().LeggiJson(richiesta);
            //INSERISCO NELLA VARIABILE RESULT IL VALORE DELLA CHIAVE RESULT DELL'HASHMAP DATI
            String result = (String) dati.get("result");
            msg = result;
            
            if(!result.equals("Circonferenze Inserite")) {
                msg = "Circonferenze Non Inserite";
            }
        }else{
            msg = "Campi Caviglia e Polsi Vuoti!";
        }
        return msg;
    }
    
    //METODO PER SALVARE NEL DB LA MASSA MAGRA
    public String inserisciMassaMagra(String massaMagra){
        String msg = "Massa Magra Inserita";
        if (!massaMagra.isEmpty()) {
            //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
            Map dati = new HashMap();
            dati.put("email", getEmail());
            dati.put("massaMagra", massaMagra);
            dati.put("Tabella", "utente");
            //
            //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
            InputStream richiesta = getRichieste().GetRichiesta("/utente/massaMagra", dati, null);
            //PUSLISCE L'HASHMAP
            dati.clear();
            //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
            dati = getJson().LeggiJson(richiesta);
            //INSERISCO NELLA VARIABILE RESULT IL VALORE DELLA CHIAVE RESULT DELL'HASHMAP DATI
            String result = (String) dati.get("result");
            msg = result;
            if(!result.equals("Massa Magra Inserita")) {
                msg = "Massa Magra Non Inserita";
            }
        }else{
            msg = "Campo Massa Magra Vuoto!";
        }
        return msg;
    }
    
    //METODO PER SALVARE LE MISURE DELLE VARIE PARTI DEL CORPO
    public String salvamisure(String petto, String bicipite, String avambraccio, String cosce, String polpacci){
        
        String msg = "Misure inserite";
        if (!petto.isEmpty() && !bicipite.isEmpty() && !avambraccio.isEmpty() && !cosce.isEmpty() && !polpacci.isEmpty()) {
           
            //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
            Map dati = new HashMap();
            dati.put("email", getEmail());
            dati.put("petto", petto);        
            dati.put("bicipite", bicipite);
            dati.put("avambraccio", avambraccio); 
            dati.put("cosce", cosce);
            dati.put("polpacci", polpacci);
            dati.put("Tabella", "misure");
            //
            //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
            InputStream richiesta = getRichieste().GetRichiesta("/utente/salvamisure", dati, null);
            //PUSLISCE L'HASHMAP
            dati.clear();
            //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
            dati = getJson().LeggiJson(richiesta);    
            //INSERISCO NELLA VARIABILE RESULT IL VALORE DELLA CHIAVE RESULT DELL'HASHMAP DATI
            String result = (String) dati.get("result");
            msg = result;
            if(!result.equals("Misure inserite")) {
                msg = "Massa Magra Non Inserita";
            }
        }else{
            msg = "Campi Misure Vuoti!";
        }
        return msg;
    }
    
    //METODO PER SALVARE I LE MISURE INIZIALE DELLE VARIE PARTI DEL CORPO
    public String salvaValoriIniziali(String email, String petto, String bicipite, String avambraccio, String cosce, String polpacci ){
        
        String msg = "Valori Inseriti";
        if (!email.isEmpty() && !petto.isEmpty() && !bicipite.isEmpty() && !avambraccio.isEmpty() 
                && !cosce.isEmpty() && !polpacci.isEmpty()) {
            //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
            Map dati = new HashMap();
            dati.put("email", email);
            dati.put("petto", petto);
            dati.put("bicipite", bicipite);
            dati.put("avambraccio", avambraccio);
            dati.put("cosce", cosce);
            dati.put("polpacci", polpacci);
            dati.put("Tabella", "misure");
            //
            //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
            InputStream richiesta = getRichieste().GetRichiesta("/utente/salvaValoriIniziali", dati, null);
            //PUSLISCE L'HASHMAP
            dati.clear();
            //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
            dati = getJson().LeggiJson(richiesta);
            //INSERISCO NELLA VARIABILE RESULT IL VALORE DELLA CHIAVE RESULT DELL'HASHMAP DATI
            String result = (String) dati.get("result");
            msg = result;
            if(!result.equals("Valori Inseriti")) {
                msg = "Valori non Inseriti";
            }
        }else{
            msg = "Campi vuoti";
        }
        return msg;
    }
    
    //METODO PER SALVARE LE MISURE DEI VALORI INTERMEDI DELLE VARIE PARTI DEL CORPO
    public String salvaValoriIntermedi(String email, String petto, String bicipite, String avambraccio, String cosce, String polpacci ){
        
        String msg = "Valori Intermedi Inseriti";
        if (!email.isEmpty() && !petto.isEmpty() && !bicipite.isEmpty() && !avambraccio.isEmpty() 
                && !cosce.isEmpty() && !polpacci.isEmpty()) {
            
            //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
            Map dati = new HashMap();
            dati.put("email", email);
            dati.put("petto", petto);
            dati.put("bicipite", bicipite);
            dati.put("avambraccio", avambraccio);
            dati.put("cosce", cosce);
            dati.put("polpacci", polpacci);
            dati.put("Tabella", "misure");
            //
            //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
            InputStream richiesta = getRichieste().GetRichiesta("/utente/salvaValoriIntermedi", dati, null);
            //PUSLISCE L'HASHMAP
            dati.clear();
            //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
            dati = getJson().LeggiJson(richiesta);
            //INSERISCO NELLA VARIABILE RESULT IL VALORE DELLA CHIAVE RESULT DELL'HASHMAP DATI
            String result = (String) dati.get("result");
            msg = result;

            if(!result.equals("Valori Intermedi Inseriti")) {
                msg = "Valori Intermedi non Inseriti";
            }
        }else{
            msg = "Campi vuoti";
        }
        return msg;
        
    }
    
    public double formulaMassaGrassa(float vita, float fianchi, float collo ){
        final float VALORIUOMO[]  = {495.0f, 1.0324f, 0.19077f, 0.15456f, 450f };
        final float VALORIDONNA[]  = {495.0f, 1.29579f, 0.35004f, 0.22100f, 450f };
        double log1 = Math.log10((vita - collo));
        double log2 = Math.log10(getAltezza());
        double log3 = Math.log10((vita + fianchi - collo));
        //CONTROLLO IL GENERE DELL'UTENTE, POICHé IL CALCOLO DIFFERISCE
        if (getGenere().equals("U") || getGenere().equals("A") ){
            risultato = VALORIUOMO[0]/(VALORIUOMO[1] - VALORIUOMO[2] * log1 + VALORIUOMO[3] * log2  ) - VALORIUOMO[4];
        }else if(getGenere().equals("D")){
            risultato = VALORIDONNA[0]/(VALORIDONNA[1] - VALORIDONNA[2] * log3 + VALORIDONNA[3] * log2  ) - VALORIDONNA[4];
        }
        return risultato;
    }
    
    //METODO USATO PER CALCOLARE LA MASSA MAGRA DI UN UTENTE
    public double formulaMassaMagra(){
        final float VALORIUOMO[] = {1.10f, 128.0f};
        final float VALORIDONNA[] = {1.07f, 148.0f};
        //CONTROLLO IL GENERE DELL'UTENTE, POICHé IL CALCOLO DIFFERISCE
        if (getGenere().equals("U") || getGenere().equals("A") ){
            risultato = (VALORIUOMO[0] * getPeso() ) - VALORIUOMO[1] * ((Math.pow(getPeso(), 2)/ (Math.pow(getAltezza(), 2))));
        }else if(getGenere().equals("D")){
            risultato = (VALORIDONNA[0] * getPeso() ) - VALORIDONNA[1] * ((Math.pow(getPeso(), 2)/ (Math.pow(getAltezza(), 2))));
        }
        return risultato;
    }
    
    public String CalcolaPesoMax (String campopeso, String camporm, String camporm2){
               
        final double COEFF[] = {1.000, 1.029, 1.059, 1.091, 1.125, 1.161, 1.200, 1.242, 1.286, 1.330};        
        int indice = Integer.parseInt(camporm);
        int indice2 = Integer.parseInt(camporm2);
        String msg = "";
        
        if (indice > 10 || indice2 > 10 || indice == 0 || indice2 == 0 ){
            msg = "Impossibile calcolare";
        }else{
            risultato = Float.parseFloat(campopeso) * COEFF[indice-1]/ COEFF[indice2-1];
            msg = String.valueOf(String.format("%.0f", risultato));
        }
        return msg;
    }
     
    public String CalcoloRepMax(String campopeso, String camporm, String campopeso2){
       
        String msg = "";
        int peso  = Integer.parseInt(campopeso);
        int peso2  = Integer.parseInt(campopeso2);
        float risultato1 = (peso * 100) / peso2;

        if (risultato1 >= 60.0 && risultato1 < 65.0)  return msg = "20";
        if (risultato1 >= 65.0 && risultato1 < 67.0)  return msg = "15";
        if (risultato1 >= 67.0 && risultato1 < 70.0)  return msg = "12";
        if (risultato1 >= 70.0 && risultato1 < 75.0)  return msg = "11";
        if (risultato1 >= 75.0 && risultato1 < 77.0)  return msg = "10";
        if (risultato1 >= 77.0 && risultato1 < 80.0)  return msg = "9";
        if (risultato1 >= 80.0 && risultato1 < 83.0)  return msg = "8";
        if (risultato1 >= 83.0 && risultato1 < 85.0)  return msg = "7";
        if (risultato1 >= 85.0 && risultato1 < 87.0)  return msg = "6";
        if (risultato1 >= 87.0 && risultato1 < 90.0)  return msg = "5";
        if (risultato1 >= 90.0 && risultato1 < 93.0)  return msg = "4";
        if (risultato1 >= 93.0 && risultato1 < 95.0)  return msg = "3";
        if (risultato1 >= 95.0 && risultato1 < 100.0) return msg = "2";
        if (risultato1 == 100.0)                      return msg = "1";
        
        return "Impossibile calcolare";
    }
    
    public boolean controlloDati(String value) {
        for(int i = 0; i < value.length(); i++) {
            if(Character.isDigit(value.charAt(i))) {
                return false;
            }
        }        
        return true;
    }
    
    
    // SCHEDA DI ALLENAMENTO
    //************************************************************************************************************************************************

    public Map visualizzaRighe(){
        
        //CREA UN HASHMAP CONTENENTE I VALORI
        Map dati = new HashMap();
        dati.put("email", getEmail());
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/visualizza/visualizzaRighe", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        
        return dati; 
    }
    
    public void creascheda(List<Integer> array_momenti, List<Object> contaEsercizi, List<String> esercizi, List<String> ripetizioni,List<String> listaMomenti, int fabbisogno){
        if (!array_momenti.isEmpty() || array_momenti == null) {
            if (array_momenti.get(0) != 0) {
                //if (null != array_momenti.get(0)) 
                        
                switch (array_momenti.get(0)) {
                    case 1:
                        VediUnMomento unmomento = new VediUnMomento(array_momenti, contaEsercizi, esercizi,ripetizioni, listaMomenti, fabbisogno);
                        unmomento.setVisible(true);
                        break;
                    case 2:
                        VediDueMomenti duemomento = new VediDueMomenti(array_momenti, contaEsercizi, esercizi,ripetizioni, listaMomenti, fabbisogno);
                        duemomento.setVisible(true);
                        break;
                    case 3:
                        VediTreMomenti tremomento = new VediTreMomenti(array_momenti, contaEsercizi, esercizi,ripetizioni, listaMomenti, fabbisogno);
                        tremomento.setVisible(true);
                        break;
                    default:
                        break;
                }
                
            }else{
                array_momenti.remove(0);
                contaEsercizi.remove(0);
                listaMomenti.remove(0);
                listaMomenti.remove(0);
                listaMomenti.remove(0);
                creascheda(array_momenti, contaEsercizi, esercizi, ripetizioni, listaMomenti, fabbisogno);
            }   
        }else{
            ScegliVisualizza scegli = new ScegliVisualizza();
            scegli.setVisible(true);
        }
    }
    
    public Map dammiScheda(String id){
        //CREA UN HASHMAP CONTENENTE I VALORI
        Map dati = new HashMap();
        dati.put("id", id);
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/visualizza/dammiScheda", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        
        return dati; 
    }
    
    
    public void eliminaScheda(String id){
        //CREA UN HASHMAP CONTENENTE I VALORI
        Map dati = new HashMap();
        dati.put("id", id);
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/visualizza/eliminaScheda", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
                
    }
    
    //************************************************************************************************************************************************

    //------------------------------------------------------------------------------------METODO USATO PER CALCOLARE IL PESO CORPOREO
    //METODO USATO PER CALCOLARE IL PESO MUSCOLARE MASSIMO
    public double pesoMuscolareMax( ){
        
        //ARRAY CONENENTE I VALORI COSTANTI DA USARE NEL CALCOLO
        final float VALORE[] = {1.5f, 22.6670f, 17.0104f, 224f, 1f};
        
        double altezzapollice = getAltezza()/2.54;
        double polsopollice = getPolso()/2.54;
        double cavigliapollice = getCaviglia()/2.54;
        
        risultato = (Math.pow(altezzapollice, VALORE[0])) * ((Math.sqrt(polsopollice)/ VALORE[1] + Math.sqrt(cavigliapollice)/VALORE[2])) * ((getMassagrassa()/VALORE[3]) + VALORE[4]); 
        
        return risultato/2.2046;
    }
    
    public double calcolo_PesoCorporeo(){
        final double VALORE = 100.0;
        double pesoMuscolareMax = pesoMuscolareMax();
        
        risultato = (pesoMuscolareMax / (VALORE - getMassagrassa())) * VALORE ;
        
        return risultato;
    }
    
    public double calcolo_petto(){
        
        final double VALORE[] ={1.6817f, 1.3759f, 0.3314f};
        
        risultato = (VALORE[0] * getPolso()) + (VALORE[1] * getCaviglia()) + (VALORE[2] * getAltezza()) ;
                
               
        return risultato;
    }
       
    public double calcolo_bicipite(){
        
        final double VALORE[] ={1.2033f, 0.1236f};
        
        risultato = (VALORE[0] * getPolso()) + (VALORE[1] * getAltezza()) ;
                
        return risultato;
    }
    
    public double calcolo_avambraccio(){
        
        final double VALORE[] ={0.9626f, 0.0989f};
        
        risultato = (VALORE[0] * getPolso()) + (VALORE[1] * getAltezza()) ;
                
        return risultato;
    }
    
    public double calcolo_cosce(){
        
        final double VALORE[] ={1.3868f, 0.1805f};
        
        risultato = (VALORE[0] * getCaviglia()) + (VALORE[1] * getAltezza()) ;
                
        return risultato;
    }
    
    public double calcolo_polpacci(){
        
        final double VALORE[] ={0.9298f, 0.1210f};
        
        risultato = (VALORE[0] * getCaviglia()) + (VALORE[1] * getAltezza()) ;
                
        return risultato;
    }
    //------------------------------------------------------------------------------------ fineeeeee METODO USATO PER CALCOLARE IL PESO CORPOREO
    
   

    public String getQuestionario() {
        return questionario;
    }

    public String getEsito() {
        return esito;
    }


   

    
    
}
