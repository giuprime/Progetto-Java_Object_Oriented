package Allenamento;

import Autenticazione.Trainer;
import Impostazioni.JSON;
import Impostazioni.Richieste;
import Impostazioni.Xmlpars;
import SchedaForYou.Misure;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diario {
    
    private final Xmlpars xmlpars = new Xmlpars("Impostazioni.xml");
    private final JSON json = new JSON();
    private final Richieste richieste = new Richieste(xmlpars.getElement("PROTOCOL"), xmlpars.getElement("SERVER_ADDRES"), xmlpars.getElement("SERVER_PORTA"));
    private final Xmlpars parser3 = new Xmlpars("pesoutente.save");
    private final String[] partiDelCorpo = new String[] {"Petto", "Bicipiti", "Avambracci", "Cosce", "Polpacci"};
    private final String[] inizialiPartiCorpo = new String[] {"P","A","B","C","O"};
    private final String[] day = {"Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica"};
    //I DATI LI PRENDIAMO DALLA TABELLA. E LI LAVORIAMO


    public Diario() {
        if (!xmlpars.exists()) {
            //SE IL FILE IMPOSTAZIONI.XML NON ESISTE VIENE CREATO CON I VALORI DI DEAFULT
            xmlpars.ImpoDefault();           
        }
    }
    
    public String inputUtenteTrainer(String email, String tipo, String parte_corpo, String giorni, String mattina, String pomeriggio, String sera, String kcal,String emailtrainer, double fabbisogno){

        String msg = "Input salvati!";
        Map dati = new HashMap();
        dati.put("tabella", "diario");
        dati.put("email", email);
        dati.put("tipo", tipo);
        dati.put("parte_corpo", parte_corpo);
        dati.put("giorni", giorni);
        dati.put("mattina", mattina);
        dati.put("pomeriggio", pomeriggio);
        dati.put("sera", sera);
        dati.put("kcal", kcal);
        dati.put("emailtrainer", emailtrainer);
        dati.put("fabbisogno", String.valueOf(fabbisogno));
        InputStream richiesta = getRichieste().GetRichiesta("/scelta/inputUtenteTrainer", dati, null);
        dati.clear(); 
        dati = getJson().LeggiJson(richiesta);
        String result = (String) dati.get("result");
        if(!result.equals("Input salvati!")) {
            msg = "Input non salvati!";
        }

        return msg;
    }
      //METODO USATO NELL'ADMIN DASHBOARD PER PRELEVARE L'EMAIL, NOME E COGOME DI OGNI TRAINER E MEDICO
    public Map visualizzaRighe(){
        
        Trainer trainer = new Trainer();
        //CREA UN HASHMAP CONTENENTE I VALORI
        Map dati = new HashMap();
        dati.put("tabella","diario");
        dati.put("email", trainer.getEmail());
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/scelta/visualizzaRighe", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        
        return dati; 
    } 
    
    //------------------------------------------------------------------------------------------------------------------------
    
    public List<String> calcoloOre(String matt, String pomer, String ser, String ore, String kcal){ //METODO CHE PRELEVA I DATI DAL DB E LI CONVERTE
        
        String mattina = matt;
        String pomeriggio = pomer;
        String sera = ser;
        double calorie = Double.parseDouble(kcal);
          
        String[] intensitaMattina = mattina.split(" ");
        String[] intensitaPomeriggio = pomeriggio.split(" ");
        String[] intensitaSera = sera.split(" ");
        
        List<ArrayList> weeklist = new ArrayList<>(); 
        for(int i=0; i<getDay().length; i++){
            weeklist.add(new ArrayList<>());
        }
        
        for(int i=0; i<getDay().length; i++){
            if(ore.contains(getDay()[i])){
                if (mattina.contains(getDay()[i])) {
                    for (int k = 0; k < intensitaMattina.length; k++) {
                        if (intensitaMattina[k].equals(getDay()[i]) ) {
                            weeklist.get(i).add(getDay()[i] + " Mattina " + intensitaMattina[k+1]);
                        }
                    }
                }else{
                    weeklist.get(i).add("-");
                }
                if(pomeriggio.contains(getDay()[i])){
                    for (int k = 0; k < intensitaPomeriggio.length; k++) {
                        if (intensitaPomeriggio[k].equals(getDay()[i]) ) {
                            weeklist.get(i).add(getDay()[i] + " Pomeriggio " + intensitaPomeriggio[k+1]);
                        }
                    }
                }else{
                    weeklist.get(i).add("-");
                }
                if(sera.contains(getDay()[i])) {
                    for (int k = 0; k < intensitaSera.length; k++) {
                        if (intensitaSera[k].equals(getDay()[i]) ) {
                            weeklist.get(i).add(getDay()[i] + " Sera " + intensitaSera[k+1]);
                        }
                    }
                }else{
                    weeklist.get(i).add("-");
                }
            }else{
                weeklist.get(i).add("-");
                weeklist.get(i).add("-");
                weeklist.get(i).add("-");
            }
        }
        
        String calorieL = "";
        //CICLA DA 0 A 6
        for (int i = 0; i < weeklist.size(); i++) {
            for (int j = 0; j < 3; j++) {
                if (((String) weeklist.get(i).get(j)).contains("Leggero")) {
                    calorieL += "L ";
                }else if(((String) weeklist.get(i).get(j)).contains("Medio")) {
                    calorieL += "M ";
                }else if(((String) weeklist.get(i).get(j)).contains("Pesante")) {
                    calorieL += "P ";
                }
            }
            
            int numeroIntensita = calorieL.length()/2; // calorieL ="L M P "; / 2 = RESTITUISCE IL NUMERO DI MOMENTI E IN BASE AD ESSO RICHIAMIAMO LA CLASSE CON I METODI 
            if (numeroIntensita != 0) {
                Intensita intensita = new Intensita(weeklist, calorie, i, calorieL);
                weeklist = assegnaKcal(numeroIntensita, intensita);
            }
            
            calorieL = "";
        }
        
        List<String> tuttigiorni = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                tuttigiorni.add((String)weeklist.get(i).get(j));
            }
        }
        /*
        System.out.println("Weeklist " +weeklist); Weeklist [[Lunedi Mattina (Pesante) 133, -, Lunedi Sera (Medio) 89], [-, -, -], [Mercoledi Mattina (Leggero) 73, Mercoledi Pomeriggio (Leggero) 73, Mercoledi Sera (Leggero) 75], [-, -, -], [-, Venerdi Pomeriggio (Pesante) 133, Venerdi Sera (Medio) 89], [-, -, -], [-, -, -]]
        System.out.println("CalorieL " + calorieL); CalorieL = {L L}
        */ 
        
        return tuttigiorni;
    }
    
    public void creascheda(List<String> arrayGiorni,List<Object> partiOrdinate, String tipo, List<String> giorniSettimana, List<Object> tuttiEsercizi, List<Object> tuttiRepMin, Map valori){
        /*
        System.out.println("-----------------------------------------");
        System.out.println("Array giorni  " + arrayGiorni); Array giorni  [Lunedi Mattina (Pesante) 133, -, Lunedi Sera (Medio) 89, -, -, -, Mercoledi Mattina (Leggero) 73, Mercoledi Pomeriggio (Leggero) 73, Mercoledi Sera (Leggero) 75, -, -, -, -, Venerdi Pomeriggio (Pesante) 133, Venerdi Sera (Medio) 89, -, -, -, -, -, -]
        System.out.println("Parti oridnate  "+ partiOrdinate); Parti oridnate  [0.09950248756218905, Petto, 0.8130081300813008, Cosce, 0.8650519031141868, Avambracci, 0.958861665914913, Polpacci]
        System.out.println("Tipo  "+ tipo); Tipo  Calisthenics
        System.out.println("Giorni settimana  "+ giorniSettimana); Giorni settimana  [Lunedi Mattina (Pesante) 133, -, Lunedi Sera (Medio) 89, -, -, -, Mercoledi Mattina (Leggero) 73, Mercoledi Pomeriggio (Leggero) 73, Mercoledi Sera (Leggero) 75, -, -, -, -, Venerdi Pomeriggio (Pesante) 133, Venerdi Sera (Medio) 89, -, -, -, -, -, -]
        System.out.println("Tutti esercizi  "+ tuttiEsercizi);
        System.out.println("Tutte ripetizioni e minuti "+ tuttiRepMin);
        System.out.println("Hashmap  "+ valori);  Hashmap  {utente=giuprime, tipo=Calisthenics, fabbisogno=2070.0, parte_corpo=Petto Avambracci Cosce Polpacci , trainer=trainer@trainer.it, calorie=222.0}       
        System.out.println("-----------------------------------------");
        */
        //*********************CONTA MOMENTI
        int conta = 0;
        List<Integer> array_momenti = new ArrayList<>();

        for (int i = 0; i < arrayGiorni.size(); i=i+3) {
            if (!arrayGiorni.get(i).equals("-")) {
                conta+=1;
            }
            if (!arrayGiorni.get(i+1).equals("-")) {
                conta+=1;
            }
            if (!arrayGiorni.get(i+2).equals("-")) {
                conta+=1;
            }
            array_momenti.add(conta);
            conta = 0;
        }
        //*********************FINE CONTA MOMENTI
        
        //NUMERO DI MOMENTI NELL' ELEMENTO IN POSIZIONE 0
        for (int i = 0; i < array_momenti.size(); i++) {
            int numeroMoments = array_momenti.get(i);
            //se il primo valore di numeroMoments è diverso da zero fai qualcosa
            if (numeroMoments != 0) {


               //CREO ARRAY LIST LUNEDI
               List<String> primomomento = new ArrayList<>();
               if (!arrayGiorni.get(0).equals("-")) {
                   primomomento.add(arrayGiorni.get(0));
               }
               if (!arrayGiorni.get(1).equals("-")) {
                   primomomento.add(arrayGiorni.get(1));
               }
               if (!arrayGiorni.get(2).equals("-")) {
                   primomomento.add(arrayGiorni.get(2));
               }
               //-----------------------------------------------
               //CREO ARRAY LIST arraySenzaLunedi
               List<String> arraySenzaLunedi = arrayGiorni;
               
               arraySenzaLunedi.remove(0);
               arraySenzaLunedi.remove(0);
               arraySenzaLunedi.remove(0);
               //-----------------------------------------------
               
               //CREO ARRAY LIST arraySenzaMomentoLunedi
               List<Integer> arraySenzaMomentoLunedi = array_momenti;
               arraySenzaMomentoLunedi.remove(0);
                //-----------------------------------------------
                switch (numeroMoments) {
                    case 1:
                        Uno unmomento = new Uno(numeroMoments, primomomento, arraySenzaLunedi,arraySenzaMomentoLunedi, partiOrdinate, tipo, giorniSettimana, tuttiEsercizi, tuttiRepMin, valori);
                        unmomento.setVisible(true);
                        break;
                    case 2:
                        Due duemomento = new Due(numeroMoments, primomomento, arraySenzaLunedi,arraySenzaMomentoLunedi, partiOrdinate,tipo, giorniSettimana, tuttiEsercizi, tuttiRepMin, valori);
                        duemomento.setVisible(true);
                        break;
                    case 3:
                        Tre tremomento = new Tre(numeroMoments, primomomento, arraySenzaLunedi,arraySenzaMomentoLunedi,partiOrdinate,tipo, giorniSettimana, tuttiEsercizi, tuttiRepMin, valori);
                        tremomento.setVisible(true);
                        break;
                    default:
                        break;
                }
               break;
           }else{
               arrayGiorni.remove(0);
               arrayGiorni.remove(0);
               arrayGiorni.remove(0);
           }      
        }
    }
    
    public List<Object> ordinaParti(String partidelcorpo){
        
        Misure misure = new Misure();
        List<Object> percentualinome = new ArrayList<>();
        List<Double> percentuali = new ArrayList<>();
        
        //String[] partiCorpo = new String[] {"Petto", "Bicipiti", "Avambracci", "Cosce", "Polpacci"};
        double[] misureParti = new double[] {misure.getPercentuale_petto(),misure.getPercentuale_bicipite(),misure.getPercentuale_avambraccio(),misure.getPercentuale_cosce(),misure.getPercentuale_polpacci() };

        for(int i=0; i<getPartiDelCorpo().length; i++){
            if(partidelcorpo.contains(getPartiDelCorpo()[i])){
                percentuali.add(misureParti[i]);
                percentualinome.add(getPartiDelCorpo()[i]);
                percentualinome.add(misureParti[i]);
            }
        }
        
        Collections.sort(percentuali); //-ORDINA LE PERCENTUALI DAL PIù PICCOLA AL PIù GRANDE

        List<Object> partiOrdinate = new ArrayList<>();
        for (int j = 0; j < percentuali.size(); j++){
            for (int k = 1; k < percentualinome.size(); k=k+2) {
                if (percentuali.get(j) ==  (double)percentualinome.get(k)) {
                    partiOrdinate.add(percentuali.get(j));
                    partiOrdinate.add(percentualinome.get(k-1));
                }
            }
       }
        
       return partiOrdinate;
    }
    
    public Map esercizi (int numeroMomento, List<String> primomomento, List<Object> partiOrdinate, String tipo){
        
        
        List<Object> esercizi = new ArrayList<>();
        List<Object> esercizi1mom = new ArrayList<>();
        List<Object> esercizi2mom = new ArrayList<>();
        List<Object> esercizi3mom = new ArrayList<>();
        int sizePartiOrdinate = partiOrdinate.size()/2; // SERVE PER CONOSCERE LE PARTI DEL CORPO E RICHIAMRE LA CLASSE CON I METODI
        
        Momenti momenti = new Momenti(primomomento, esercizi, esercizi1mom, esercizi2mom, esercizi3mom, numeroMomento, sizePartiOrdinate);
        esercizi = numeroEse(numeroMomento, momenti);
        esercizi.addAll(partiOrdinate);
        
        ////*****************************************************************************   numeroEserciziDB è un valore che deve essere prelevato dal db
        List<Integer> shuffle = new ArrayList<>();
        int numeroEserciziDB= 5; // 5 ESERCIZI PER PARTI DEL CORPO
        for (int i = 1; i <= numeroEserciziDB; i++) {
            shuffle.add(i);
        }
        
        List<Integer> shuffle1 = new ArrayList<>();
        int numeroEserciziDB1= 10;
        for (int i = 1; i <= numeroEserciziDB1; i++) {
            shuffle1.add(i);
        }
        ////*****************************************************************************   numeroEserciziDB1 è un valore che deve essere prelevato dal db
        
        List<Object> listaEsercizi = new ArrayList<>();
        List<Object> listaMomenti = new ArrayList<>();
        List<Object> listaPartiCorpo = new ArrayList<>();
        List<Double> listaMetRep = new ArrayList<>();
        /*
        System.out.println("Esercizi "+ esercizi); Esercizi [4, 9, 133, 4, 7, 89, 0.09950248756218905, Petto, 0.8130081300813008, Cosce, 0.8650519031141868, Avambracci, 0.958861665914913, Polpacci]
        System.out.println("Esercizi1mom " +esercizi1mom); Esercizi1mom [4, 9, 133]
        System.out.println("Esercizi2mom "+ esercizi2mom); Esercizi2mom [4, 7, 89]
        System.out.println("Esercizi3mom" + esercizi3mom);
        System.out.println("listaEsercizi " +listaEsercizi); 
        System.out.println("listaMomenti " + listaMomenti);
        System.out.println("listaPartiCorpo "+listaPartiCorpo);
        System.out.println("listaMetRep" + listaMetRep);
        */
        int numeroParti =(int) esercizi.get(0);
        int size = esercizi.size();

        Esercizio product = new Esercizio(listaEsercizi, listaMomenti, listaPartiCorpo, listaMetRep, shuffle, shuffle1,size, numeroEserciziDB, numeroEserciziDB1, tipo, esercizi);
        
        Map dati = shippingFee(numeroParti, product);
        return dati;
        
       
    }
    
    private HashMap <Integer, Interfaccia> shippers = new HashMap(){{
        put(1, new UnaParte());
        put(2, new DueParti());
        put(3, new TreParti());
        put(4, new QuattroParti());
        put(5, new CinqueParti());
    }};
    
    public Map shippingFee(int shippername, Esercizio product){
        return shippers.get(shippername).assegnaEsercizi(product);
    }
    
    private HashMap <Integer, Interfaccia> nMomemnti = new HashMap(){{
        put(1, new UnMomento());
        put(2, new DueMomenti());
        put(3, new TreMomenti());
    }};
    public List<Object> numeroEse(int numeroMomento, Momenti momenti ){
        return nMomemnti.get(numeroMomento).assegnaNumEsercizi(momenti);
    }
    
    public List<ArrayList> assegnaKcal(int numeroIntensita, Intensita intensita ){
        return nMomemnti.get(numeroIntensita).calcoloCalorie(intensita);
    }
    
    public Map assegnaCalorie(int numeroMomenti, AssegnaCalorie assegna){
        return nMomemnti.get(numeroMomenti).assegnaCalorie(assegna);
    }
    
   
    
    //************************************************************************************************************************************************************************************************
    public Map calcoloCalorie(Map dati){ 
                
        // = new Xmlpars("eserciziScheda/esercizi.xml");
        List<ArrayList<Object>> tutto = new ArrayList<>(dati.values());
        
        List<Object> listaMomenti = new ArrayList<>();
        for (int i = 0; i < tutto.get(0).size(); i++) {
            listaMomenti.add(String.valueOf(tutto.get(0).get(i)));
        }
        
        List<Object> listaEsercizi = new ArrayList<>();
        for (int i = 0; i < tutto.get(1).size(); i++) {
            listaEsercizi.add(String.valueOf(tutto.get(1).get(i)));
        }
                
        List<Double> listaMetRep = new ArrayList<>();
        for (int i = 0; i < tutto.get(2).size(); i++) {
            listaMetRep.add((double)tutto.get(2).get(i));
        }

        List<Double> listaKcalRipetizione = new ArrayList<>();
        
        int numeroMomenti = listaMomenti.size()/3;
        
        AssegnaCalorie assegna = new AssegnaCalorie(listaMomenti, this, listaMetRep, listaKcalRipetizione);
        
        Map risultato = assegnaCalorie(numeroMomenti, assegna);
        risultato.put("Esercizi", listaEsercizi);
        /*
        System.out.println("tutto "+ tutto); tutto [[2, 3, 22], [Push up and rotate, Piegamenti Hindu, Triceps bow], [8.0, 17.0, 8.0, 12.0, 7.0, 15.0]]
        System.out.println("listaMomenti "+listaMomenti); listaMomenti [2, 3, 22] 2 PARTI DEL CORPO 
        System.out.println("listaEsercizi "+listaEsercizi); listaEsercizi [Push up and rotate, Piegamenti Hindu, Triceps bow]
        System.out.println("listaMetRep "+listaMetRep); listaMetRep [8.0, 17.0, 8.0, 12.0, 7.0, 15.0]
        System.out.println("listaKcalRipetizione "+listaKcalRipetizione); listaKcalRipetizione [2.0, 2.0, 2.0]
        */
        return risultato;
    }
    
    public  List<Double> calcoloCalorie(int numEse, List<Object> momento, List<Double> metRep){
        //QUESTO è IL METODO USATO PER CALCOLARE IL NUMERO DI ESERCIZI O I MINUTI DA FARE PER OGNI ESERCIZIO
        List<Double> listaMinutiKcal = new ArrayList<>();
        //------PRELEVARE PESO
        Map dati = new HashMap();
        dati.put("email", getParser3().getElement("email"));
        InputStream richiesta = getRichieste().GetRichiesta("/scelta/prelevaPeso", dati, null);
        dati.clear();
        dati = getJson().LeggiJson(richiesta);
        //------PRELEVARE PESO
        double peso = Double.parseDouble((String) dati.get("peso")); 
        
        if (numEse < 6) {
            double kcalEsercizio =  Double.parseDouble((String)momento.get(2)) / Double.parseDouble((String)momento.get(1));
            for (int i = 0; i < metRep.size(); i=i+2) {
                double kcalRipetizione =  (0.0175 * peso * metRep.get(i)) / metRep.get(i+1); 
                listaMinutiKcal.add( (double) Math.round((kcalEsercizio/kcalRipetizione)/ (metRep.get(i+1))+1) );
                /*
                System.out.println("kcalEsercizio "+kcalEsercizio); kcalEsercizio 7.333333333333333
                System.out.println("kcalRipetizione "+kcalRipetizione); kcalRipetizione 0.6341176470588236
                */
            }
        }else{
            double kcalEsercizio =  Double.parseDouble((String)momento.get(2)) / Double.parseDouble((String)momento.get(1));
            for (int i = 0; i < metRep.size(); i=i+2) {
                double kcalRipetizione =  (0.0175 * peso * metRep.get(i)) / metRep.get(i+1); 
                if((double) Math.round(kcalEsercizio/kcalRipetizione) > 40){
                    listaMinutiKcal.add( (double) Math.floor(Math.random()*(40-30+1)+30) );
                }else{
                    listaMinutiKcal.add( (double) Math.round(kcalEsercizio/kcalRipetizione) );
                }
                /*
                System.out.println("kcalEsercizio "+kcalEsercizio);
                System.out.println("kcalRipetizione "+kcalRipetizione);
                */
            }
        }
        /*
        System.out.println("listaMinutiKcal "+listaMinutiKcal); listaMinutiKcal [6.0, 6.0, 5.0]
        */
        return listaMinutiKcal;
    }
    
    public void insertdb(List<Object> listaMomenti, List<String> primomomento, List<Object>esercizi,List<Object>repMin,String tipo, String fabbisogno){
        
        String giornoSettimana="";
        String tutto;
        String mattina ="",pomeriggio="",sera = "";
        
        int numeroMomenti = listaMomenti.size() / 3;
        
        for (String day1 : getDay()) {
            if (primomomento.get(0).contains(day1)) {
                giornoSettimana = day1;
                if(!(listaMomenti.get(1)== null) && primomomento.get(0).contains("Mattina")){
                    int firstMoment = Integer.parseInt((String)listaMomenti.get(1));
                    mattina+="M(";
                    for (int i = 0; i < firstMoment; i++) {
                        if (i == firstMoment-1) {
                            mattina+= esercizi.get(i);
                            mattina+= "," + repMin.get(i);
                        }else{
                            mattina+= esercizi.get(i);
                            mattina+= "," + repMin.get(i)+",";
                        }
                    }
                    mattina+=")-";
                }else if(!(listaMomenti.get(1)== null) && primomomento.get(0).contains("Pomeriggio")){
                    int firstMoment = Integer.parseInt((String)listaMomenti.get(1));
                    pomeriggio+="P(";
                    for (int i = 0; i < firstMoment; i++) {
                        if (i == firstMoment-1) {
                            pomeriggio+= esercizi.get(i);
                            pomeriggio+= "," + repMin.get(i);
                        }else{
                            pomeriggio+= esercizi.get(i);
                            pomeriggio+= "," + repMin.get(i)+",";
                        }
                    }
                    pomeriggio+=")-";
                }else if(!(listaMomenti.get(1)== null) && primomomento.get(0).contains("Sera")){
                    int firstMoment = Integer.parseInt((String)listaMomenti.get(1));
                    sera+="S(";
                    for (int i = 0; i < firstMoment; i++) {
                        if (i == firstMoment-1) {
                            sera+= esercizi.get(i);
                            sera+= "," + repMin.get(i);
                        }else{
                            sera+= esercizi.get(i);
                            sera+= "," + repMin.get(i)+",";
                        }
                    }
                    sera+=")-";
                }
                if ( !(numeroMomenti==1) && !(listaMomenti.get(4) == null) && primomomento.get(1).contains("Pomeriggio")) {
                    int firstMoment = Integer.parseInt((String)listaMomenti.get(1));
                    int secondMoment = Integer.parseInt((String)listaMomenti.get(4));
                    pomeriggio+="P(";
                    for (int i = firstMoment; i < firstMoment+ secondMoment; i++) {
                        if (i == (firstMoment+secondMoment) -1) {
                            pomeriggio+= esercizi.get(i);
                            pomeriggio+= "," + repMin.get(i);
                        }else{
                            pomeriggio+= esercizi.get(i);
                            pomeriggio+= "," + repMin.get(i)+",";
                        }
                    }
                    pomeriggio+=")-";
                }else if (numeroMomenti== 2 && !(listaMomenti.get(4) == null) && primomomento.get(1).contains("Sera")) {
                    int firstMoment = Integer.parseInt((String)listaMomenti.get(1));
                    int secondMoment = Integer.parseInt((String)listaMomenti.get(4));
                    sera+="S(";
                    for (int i = firstMoment; i < firstMoment+ secondMoment; i++) {
                        if (i == (firstMoment+secondMoment) -1) {
                            sera+= esercizi.get(i);
                            sera+= "," + repMin.get(i);
                        }else{
                            sera+= esercizi.get(i);
                            sera+= "," + repMin.get(i)+",";
                        }
                    }
                    sera+=")-";
                }
                if(numeroMomenti == 3 && !(listaMomenti.get(7)== null)){
                    int firstMoment = Integer.parseInt((String)listaMomenti.get(1));
                    int secondMoment = Integer.parseInt((String)listaMomenti.get(4));
                    sera+="S(";
                    for (int i = firstMoment+secondMoment; i < esercizi.size(); i++) {
                        if (i == esercizi.size()-1) {
                            sera+= esercizi.get(i);
                            sera+= "," + repMin.get(i);
                        }else{
                            sera+= esercizi.get(i);
                            sera+= "," + repMin.get(i)+",";
                        }
                    }
                    sera+=")";
                }
            }
        }
        
        tutto = mattina+pomeriggio+sera;
        
        //CREA UN HASHMAP CONTENENTE I VALORI
        Map dati = new HashMap();
        dati.put("email",getParser3().getElement("email"));
        dati.put("tipo", tipo);
        dati.put("giornoSettimana", giornoSettimana);
        dati.put("tutto", tutto);
        dati.put("fabbisogno", fabbisogno);
        
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/scelta/insertdb", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        
    }
    
    public void eliminaQuery(Map valori){
        String parte = (String) valori.get("parte_corpo");
        String partiCorpo = "";
        
        for (int i = 0; i < getPartiDelCorpo().length; i++) {
            if (parte.contains(getPartiDelCorpo()[i])) {
                partiCorpo+= getInizialiPartiCorpo()[i];
            }
        }
        
         //CREA UN HASHMAP CONTENENTE LE SEGUENTI CHAVI-VALORI
        Map dati = new HashMap();
        dati.put("utente", (String) valori.get("utente"));
        dati.put("tipo", (String) valori.get("tipo"));
        dati.put("partiCorpo", partiCorpo);
        dati.put("trainer", (String) valori.get("trainer"));
        dati.put("calorie", (String) valori.get("calorie"));
        //
        //EFFETTUA LA RICHIESTA AL SERVER UTILIZZANDO IL PATH SOTTOSTANTE
        InputStream richiesta = getRichieste().GetRichiesta("/scelta/eliminaQuery", dati, null);
        //PUSLISCE L'HASHMAP
        dati.clear();
        //INSERISCE LA RISPOSTA DEL SERVER ALL'INTERNO DELL'HASHMAP
        dati = getJson().LeggiJson(richiesta);
        
    }
    
    public String[] getPartiDelCorpo() {
        return partiDelCorpo;
    }

    public String[] getInizialiPartiCorpo() {
        return inizialiPartiCorpo;
    }

    public String[] getDay() {
        return day;
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

    public Xmlpars getParser3() {
        return parser3;
    }
    
}
