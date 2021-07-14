package Allenamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DueMomenti implements Interfaccia{
    
    private final double[] int1 = new double[]{ 0.5,0.5 };
    private final double[] int2 = new double[]{ 0.4,0.6 };
    private final double[] int3 = new double[]{ 0.6,0.4 };
    private final double[] int4 = new double[]{ 0.3,0.7 };
    private final double[] int5 = new double[]{ 0.7,0.3 };

    @Override
    public Map assegnaEsercizi(Esercizio product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> assegnaNumEsercizi(Momenti momenti) {
        
        int numEse1= 0;
        int numEse2= 0;
         
        for(int k=0; k<2; k++){ //DA 0 A 2 PERCHé ABBIAMO SOLO DUE MOMENTI
            for(int i = 0; i<momenti.getIntensita().length; i++){ 
                if(momenti.getPrimomomento().get(k).contains(momenti.getIntensita()[i])){ //Verifica l'intensita in base al giorno 
                    int[] a = (int[]) momenti.getDati().get(momenti.getSizePartiOrdinate()); // a = AD UNO DEGLI ARRAY PRESENTI IN MOMENTI (CLASSE) CHE CONTEBGONO IL NUMERO DEGLI 
                                                                                             //ESERCIZI IN BASE ALL'INTENSITà
                   
                    if(k==0){ //SIAMO NEL CASO DEL PRIMO MOMENTO
                        numEse1= a[i]; //PRELEVA IL NUMERO DI ESERCIZI DA ASSEGNARE AL PRIMO MOMENTO
                    }else if(k==1){
                        numEse2= a[i]; //PRELEVA IL NUMERO DI ESERCIZI DA ASSEGNARE AL SECONDO MOMENTO
                    }
                }
            }
        }       
        //CREIAMO UN ARRAY DI TIPO STRINGA E INSERIAMO IL PRIMO MOMENTO SEPARATO DAGLI SPAZI
        String[] str = momenti.getPrimomomento().get(0).split(" "); //--> str = {Lunedi Mattina (Leggero) 56}
        //CREIAMO UN ARRAY E DI TIPO STRINGA E INSERIAMO IL SECONDO MOMENTO SEPARATO DAGLI SPAZI
        String[] str1 = momenti.getPrimomomento().get(1).split(" "); //--> str1 = {Lunedi Sera (Leggero) 56}
        //AGGIUNGIAMO IL NUMERO DI PARTI DEL CORPO DA ALENARE A ESERCIZI1MOM
        momenti.getEsercizi1mom().add(momenti.getSizePartiOrdinate());
        //AGGIUNGIAMO IL NUMERO DI ESERCIZI DA SVOLGERE PER IL PRIMO MOMENTO A ESERCIZI1MOM
        momenti.getEsercizi1mom().add(numEse1);
        //PRELEVIAMO L'ELEMENTO IN POSIZIONE TRE DELL'ARRAY STR CHE EQUIVALE ALLE KCAL DA BRUCIARE
        momenti.getEsercizi1mom().add(str[3]); //--> str[3] == 56
        //AGGIUNGIAMO IL NUMERO DI PARTI DEL CORPO DA ALENARE A ESERCIZI1MOM
        momenti.getEsercizi2mom().add(momenti.getSizePartiOrdinate());
        //AGGIUNGIAMO IL NUMERO DI ESERCIZI DA SVOLGERE PER IL PRIMO MOMENTO A ESERCIZI1MOM
        momenti.getEsercizi2mom().add(numEse2);
        //PRELEVIAMO L'ELEMENTO IN POSIZIONE TRE DELL'ARRAY STR CHE EQUIVALE ALLE KCAL DA BRUCIARE
        momenti.getEsercizi2mom().add(str1[3]);
        //AGGIUNGIAMO ALLA LISTA ESERCIZI TUTTO CIò CHE ABBIAMO OTTENUTO SOPRA RELATIVO AL PRIMO MOMENTO
        momenti.getEsercizi().addAll(momenti.getEsercizi1mom());
        //AGGIUNGIAMO ALLA LISTA ESERCIZI TUTTO CIò CHE ABBIAMO OTTENUTO SOPRA RELATIVO AL PRIMO MOMENTO
        momenti.getEsercizi().addAll(momenti.getEsercizi2mom());
        /*ALLA FINE ESERCIZI SARà COMPOSTA DALLE PARTI DEL CORPO DA ALLENARE, DAL NUM DI ESE DA FARE IL PRIMO MOMENTO E DALLE KCAL DA BRUCIARE PER IL PRIMO MOMENTO, 
        DOPO CI SARANNO GLI STESSI ELEMENTI CHE INDICANO PERò I VALORI RELATIVI AL SECONDO MOMENTO
        
        System.out.println("getPrimomomento()"+momenti.getPrimomomento()); getPrimomomento()[Lunedi Mattina (Leggero) 56, Lunedi Sera (Leggero) 56]
        System.out.println("Esercizi1mom "+ momenti.getEsercizi1mom()); Esercizi1mom [1, 2, 56]
        System.out.println("size parti ordinate "+ momenti.getSizePartiOrdinate()); size parti ordinate 1
        System.out.println("Esercizi "+ momenti.getEsercizi()); Esercizi [1, 2, 56, 1, 2, 56]
        */
        return momenti.getEsercizi();
        
    }

    @Override
    public List<ArrayList> calcoloCalorie(Intensita intensita) {//IN BASE ALL'INTENSITà INDICATA ANDREMO A SUDDIVIDERE IL MODO IN CUI DOVRANNO ESSERE BRUCIATE LE CALORIE
                                                                //TENENDO IN CONSIDERAZIONE GLI ARRAY DICHIARATI SOPRA
        //OTTIENIAMO L'INTENSITà SOTTO FORMA DI SGTRINGHE [L L, M M, ECC]
        String valueIntensita = intensita.getCalorieL();
        
        
        Map dati = new HashMap();
        //IN BASE ALL'INTENSITà OTTENUTA CREIAMO UNA COPPIA KEY-VALUE TRA L'INTENISTà E L'ARRAY CHE CONTIENE I NUMERI PER I CALCOLI
        dati.put("L L ", getInt1());
        dati.put("M M ", getInt1());
        dati.put("P P ", getInt1());
        dati.put("L M ", getInt2());
        dati.put("M P ", getInt2());
        dati.put("M L ", getInt3());
        dati.put("P M ", getInt3());
        dati.put("L P ", getInt4());
        dati.put("P L ", getInt4());
        
        double[] a = (double[]) dati.get(valueIntensita);
        //CASO IN CUI NON C'è LA MATTINA     
        if (((String) intensita.getWeeklist().get(intensita.getI()).get(0)).equals("-") ) {
            //CALCOLIAMO LE CALORIE DA BRUCIARE PER IL POMERIGGIO 
            intensita.getWeeklist().get(intensita.getI()).set(1, ((String) intensita.getWeeklist().get(intensita.getI()).get(1)+ " " + Math.round(intensita.getCalorie()*a[0])) );
            //CALCOLIAMO LE CALORIE DA BRUCIARE PER LA SERA
            intensita.getWeeklist().get(intensita.getI()).set(2, ((String) intensita.getWeeklist().get(intensita.getI()).get(2)+ " " + Math.round(intensita.getCalorie()*a[1])) );
            
        }
        //CASO IN CUI NON C'è IL POMERIGGIO
        else if(((String) intensita.getWeeklist().get(intensita.getI()).get(1)).equals("-") ) {
            //CALCOLIAMO LE CALORIE DA BRUCIARE LA MATTINA
            intensita.getWeeklist().get(intensita.getI()).set(0, ((String) intensita.getWeeklist().get(intensita.getI()).get(0)+ " " + Math.round(intensita.getCalorie()*a[0])) );
            //CALCOLIAMO LE CALORIRE DA BRUCIARE LA SERA
            intensita.getWeeklist().get(intensita.getI()).set(2, ((String) intensita.getWeeklist().get(intensita.getI()).get(2)+ " " + Math.round(intensita.getCalorie()*a[1])) );
            
        }
        //CASO IN CUI NON C'è LA SERA
        else if(((String) intensita.getWeeklist().get(intensita.getI()).get(2)).equals("-") ) {
            //CALCOLIAMO LE CALORIE DA BRUCIARE LA MATTINA
            intensita.getWeeklist().get(intensita.getI()).set(0, ((String) intensita.getWeeklist().get(intensita.getI()).get(0)+ " " + Math.round(intensita.getCalorie()*a[0])) );
            //CALCOLIAMO LE CALORIE DA BRUCIARE IL POMERIGGIO
            intensita.getWeeklist().get(intensita.getI()).set(1, ((String) intensita.getWeeklist().get(intensita.getI()).get(1)+ " " + Math.round(intensita.getCalorie()*a[1])) );
            
        }
           
        return intensita.getWeeklist();
    }
    
    
    @Override
    public Map assegnaCalorie(AssegnaCalorie assegna) {
        
        List<Object> primoMomento = new ArrayList<>(); 
        List<Object> secondoMomento = new ArrayList<>(); 
        List<Double> primoMomentoMet = new ArrayList<>(); 
        List<Double> secondoMomentoMet = new ArrayList<>(); 
        //ListaMomenti [4, 9, 133, 4, 7, 89] 4=parti del corpo 9=gli esercizi da fare 133= calorie da perdere
        //FACCIAMO LA CONVERSIONE PERCHé LISTA MOMENTI C'è IN DIARIO è DI TIPO OBJECT
        int numeroEsePrimo = Integer.parseInt((String)assegna.getListaMomenti().get(1));
        int numeroEseSecondo = Integer.parseInt((String)assegna.getListaMomenti().get(4));
        /*
          [2, 3, 28, 2, 3, 28, 2, 5, 56]   GETLISTAMOMENTO
          [2,3,28] PRIMO MOMENTO
          [2,3,8] SECONDO MOMNETO
          [2,5,56] TERZO MOMENTO
          NELLE SEGUENTI RIGHE SEPARIAMO I MOMENTI DELLA GIORNATA
        */
        for (int i = 0; i <3; i++) {
            primoMomento.add(assegna.getListaMomenti().get(i)); //SOLO I REP DELLA MATTINA
        }       
        for (int j = 0; j < numeroEsePrimo*2; j++) {
            primoMomentoMet.add(assegna.getListaMetRep().get(j)); //SOLO I MET DELLA MATTINA
        }       
        for (int i = 3; i < 6; i++) {
            secondoMomento.add(assegna.getListaMomenti().get(i)); //SOLO I REP DELLA POMERIGGIO 
        }       
        for (int j = numeroEsePrimo*2; j < assegna.getListaMetRep().size(); j++) {
            secondoMomentoMet.add(assegna.getListaMetRep().get(j)); //SOLO I MET DELLA POMERIGGIO
        }
        //PASSIAMO CIò CHE ABBIAMO CREATO SOPRA
        assegna.getDiario().calcoloCalorie(numeroEsePrimo, primoMomento, primoMomentoMet).forEach((n) -> assegna.getListaKcalRipetizione().add(n));
        assegna.getDiario().calcoloCalorie(numeroEseSecondo, secondoMomento, secondoMomentoMet).forEach((n) -> assegna.getListaKcalRipetizione().add(n));
        
        Map risultati = new HashMap();
        
        risultati.put("RepMin", assegna.getListaKcalRipetizione());
        risultati.put("ListaMomenti", assegna.getListaMomenti());
        /*
        System.out.println("primoMomento "+primoMomento); primoMomento [1, 2, 56]
        System.out.println("secondoMomento "+secondoMomento); secondoMomento [1, 2, 56]
        System.out.println("terzoMomento "+terzoMomento);
        System.out.println("primoMomentoMet "+primoMomentoMet); primoMomentoMet [8.0, 10.0, 8.0, 17.0]
        System.out.println("secondoMomentoMet " +secondoMomentoMet); secondoMomentoMet [7.0, 15.0, 8.0, 11.0]
        System.out.println("terzoMomentoMet "+terzoMomentoMet);
        */
        return risultati;
    }
    
    

    public double[] getInt1() {
        return int1;
    }

    public double[] getInt2() {
        return int2;
    }

    public double[] getInt3() {
        return int3;
    }

    public double[] getInt4() {
        return int4;
    }

    public double[] getInt5() {
        return int5;
    }

}
                       