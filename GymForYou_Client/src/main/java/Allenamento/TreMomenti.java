package Allenamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreMomenti implements Interfaccia {
    
    private final double[] int1 = new double[]{ 0.33,0.33,0.34 };
    private final double[] int2 = new double[]{ 0.20,0.20,0.60 };
    private final double[] int3 = new double[]{ 0.15,0.15,0.70 };
    private final double[] int4 = new double[]{ 0.20,0.60,0.20 };
    private final double[] int5 = new double[]{ 0.20,0.40,0.40 };
    private final double[] int6 = new double[]{ 0.15,0.35,0.50 };
    private final double[] int7 = new double[]{ 0.15,0.70,0.15 };
    private final double[] int8 = new double[]{ 0.15,0.50,0.35 };
    private final double[] int9 = new double[]{ 0.15,0.45,0.45 };
    private final double[] int10 = new double[]{0.60,0.20,0.20 };
    private final double[] int11 = new double[]{0.40,0.20,0.40 };
    private final double[] int12 = new double[]{0.35,0.15,0.50 };
    private final double[] int13 = new double[]{0.40,0.40,0.20 };
    private final double[] int14 = new double[]{0.25,0.25,0.50 };
    private final double[] int15 = new double[]{0.35,0.5,0.15  };
    private final double[] int16 = new double[]{0.25,0.20,0.20 };
    private final double[] int17 = new double[]{0.20,0.40,0.40 };
    private final double[] int18 = new double[]{0.40,0.15,0.15 };
    private final double[] int19 = new double[]{0.50,0.15,0.35 };
    private final double[] int20 = new double[]{0.45,0.10,0.45 };
    private final double[] int21 = new double[]{0.50,0.35,0.15 };
    private final double[] int22 = new double[]{0.50,0.25,0.25 };
    private final double[] int23 = new double[]{0.40,0.20,0.40 };
    private final double[] int24 = new double[]{0.45,0.45,0.10 };
    private final double[] int25 = new double[]{0.40,0.40,0.20 };
    
    
    @Override
    public Map assegnaEsercizi(Esercizio product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> assegnaNumEsercizi(Momenti momenti) { // LA DESCRIZIONE DETTAGLIATA è NELLA CLASSE DUE MOMENTI
        
        int numEse1 = 0;
        int numEse2 = 0;
        int numEse3 = 0;
        
        for(int k=0; k<3; k++){ //DA 0 A 3 PERCHé ABBIAMO SOLO TRE MOMENTI
            for(int i = 0; i<momenti.getIntensita().length; i++){
                if(momenti.getPrimomomento().get(k).contains(momenti.getIntensita()[i])){ //Verifica l'intensita in base al giorno 
                    int[] a = (int[]) momenti.getDati().get(momenti.getSizePartiOrdinate()); // a = AD UNO DEGLI ARRAY PRESENTI IN MOMENTI (CLASSE) CHE CONTEBGONO IL NUMERO DEGLI 
                                                                                             //ESERCIZI IN BASE ALL'INTENSITà
                    switch (k) {
                        case 0: //SIAMO NEL CASO DEL PRIMO MOMENTO
                            numEse1= a[i]; //PRELEVA IL NUMERO DI ESERCIZI DA ASSEGNARE AL PRIMO MOMENTO
                            break;
                        case 1: //SIAMO NEL CASO DEL SECONDO MOMENTO
                            numEse2= a[i]; //PRELEVA IL NUMERO DI ESERCIZI DA ASSEGNARE AL SECONDO MOMENTO
                            break;
                        case 2: //SIAMO NEL CASO DEL TERZO MOMENTO
                            numEse3= a[i]; //PRELEVA IL NUMERO DI ESERCIZI DA ASSEGNARE AL SECONDO MOMENTO
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        //CREIAMO UN ARRAY DI TIPO STRINGA E INSERIAMO IL PRIMO MOMENTO SEPARATO DAGLI SPAZI
        String[] str = momenti.getPrimomomento().get(0).split(" ");
        //CREIAMO UN ARRAY DI TIPO STRINGA E INSERIAMO IL SECONDO MOMENTO SEPARATO DAGLI SPAZI
        String[] str1 = momenti.getPrimomomento().get(1).split(" ");
        //CREIAMO UN ARRAY DI TIPO STRINGA E INSERIAMO IL TERZO MOMENTO SEPARATO DAGLI SPAZI
        String[] str2 = momenti.getPrimomomento().get(2).split(" ");
        //AGGIUNGIAMO IL NUMERO DI PARTI DEL CORPO DA ALENARE A ESERCIZI1MOM
        momenti.getEsercizi1mom().add(momenti.getSizePartiOrdinate());
        //AGGIUNGIAMO IL NUMERO DI ESERCIZI DA SVOLGERE PER IL PRIMO MOMENTO A ESERCIZI1MOM
        momenti.getEsercizi1mom().add(numEse1);
        //PRELEVIAMO L'ELEMENTO IN POSIZIONE TRE DELL'ARRAY STR CHE EQUIVALE ALLE KCAL DA BRUCIARE
        momenti.getEsercizi1mom().add(str[3]);
        //AGGIUNGIAMO IL NUMERO DI PARTI DEL CORPO DA ALENARE A ESERCIZI2MOM
        momenti.getEsercizi2mom().add(momenti.getSizePartiOrdinate());
        //AGGIUNGIAMO IL NUMERO DI ESERCIZI DA SVOLGERE PER IL PRIMO MOMENTO A ESERCIZI2MOM
        momenti.getEsercizi2mom().add(numEse2);
        //PRELEVIAMO L'ELEMENTO IN POSIZIONE TRE DELL'ARRAY STR CHE EQUIVALE ALLE KCAL DA BRUCIARE
        momenti.getEsercizi2mom().add(str1[3]);
        //AGGIUNGIAMO IL NUMERO DI PARTI DEL CORPO DA ALENARE A ESERCIZI3MOM
        momenti.getEsercizi3mom().add(momenti.getSizePartiOrdinate());
        //AGGIUNGIAMO IL NUMERO DI ESERCIZI DA SVOLGERE PER IL PRIMO MOMENTO A ESERCIZI3MOM
        momenti.getEsercizi3mom().add(numEse3);
        //PRELEVIAMO L'ELEMENTO IN POSIZIONE TRE DELL'ARRAY STR CHE EQUIVALE ALLE KCAL DA BRUCIARE
        momenti.getEsercizi3mom().add(str2[3]);
        //AGGIUNGIAMO ALLA LISTA ESERCIZI TUTTO CIò CHE ABBIAMO OTTENUTO SOPRA RELATIVO AL PRIMO MOMENTO
        momenti.getEsercizi().addAll(momenti.getEsercizi1mom());
        //AGGIUNGIAMO ALLA LISTA ESERCIZI TUTTO CIò CHE ABBIAMO OTTENUTO SOPRA RELATIVO AL SECONDO MOMENTO
        momenti.getEsercizi().addAll(momenti.getEsercizi2mom());
        //AGGIUNGIAMO ALLA LISTA ESERCIZI TUTTO CIò CHE ABBIAMO OTTENUTO SOPRA RELATIVO AL TERZO MOMENTO
        momenti.getEsercizi().addAll(momenti.getEsercizi3mom());
         /*ALLA FINE ESERCIZI SARà COMPOSTA DALLE PARTI DEL CORPO DA ALLENARE, DAL NUM DI ESE DA FARE IL PRIMO MOMENTO E DALLE KCAL DA BRUCIARE PER IL PRIMO MOMENTO, 
        DOPO CI SARANNO GLI STESSI ELEMENTI CHE INDICANO PERò I VALORI RELATIVI AL SECONDO MOMENTO E INFINE DEL TERZO*/
        return momenti.getEsercizi();
    }

    @Override
    public List<ArrayList> calcoloCalorie(Intensita intensita) {//IN BASE ALL'INTENSITà INDICATA ANDREMO A SUDDIVIDERE IL MODO IN CUI DOVRANNO ESSERE BRUCIATE LE CALORIE
                                                                //TENENDO IN CONSIDERAZIONE GLI ARRAY DICHIARATI SOPRA
        //OTTIENIAMO L'INTENSITà SOTTO FORMA DI SGTRINGHE [L L P, M M L, ECC]
        
        String valueIntensita = intensita.getCalorieL();
        //IN BASE ALL'INTENSITà OTTENUTA CREIAMO UNA COPPIA KEY-VALUE TRA L'INTENISTà E L'ARRAY CHE CONTIENE I NUMERI PER I CALCOLI
        Map dati = new HashMap();
        dati.put("L L L ",getInt1());
        dati.put("M M M ",getInt1());
        dati.put("P P P ",getInt1());
        dati.put("L L M ",getInt2());
        dati.put("L L P ",getInt3());
        dati.put("L M L ",getInt4());
        dati.put("L M M ",getInt5());
        dati.put("L M P ",getInt6());
        dati.put("L P L ",getInt7());
        dati.put("L P M ",getInt8());
        dati.put("L P P ",getInt9());
        dati.put("M L L ",getInt10());
        dati.put("M L M ",getInt11());
        dati.put("M L P ",getInt12());
        dati.put("M M L ",getInt13());
        dati.put("M M P ",getInt14());
        dati.put("M P L ",getInt15());
        dati.put("M P M ",getInt16());
        dati.put("M P P ",getInt17());
        dati.put("P L L ",getInt18());
        dati.put("P L M ",getInt19());
        dati.put("P L P ",getInt20());
        dati.put("P M L ",getInt21());
        dati.put("P M M ",getInt22());
        dati.put("P M P ",getInt23());
        dati.put("P P L ",getInt24());
        dati.put("P P M ",getInt25());
        
        double[] a = (double[]) dati.get(valueIntensita);
        //CALCOLIAMO LE CALORIE DA BRUCIARE PER OGMI ESERCIZIO 
        intensita.getWeeklist().get(intensita.getI()).set(0, ((String) intensita.getWeeklist().get(intensita.getI()).get(0)+ " " + Math.round(intensita.getCalorie()*a[0])) );
        intensita.getWeeklist().get(intensita.getI()).set(1, ((String) intensita.getWeeklist().get(intensita.getI()).get(1)+ " " + Math.round(intensita.getCalorie()*a[1])) );
        intensita.getWeeklist().get(intensita.getI()).set(2, ((String) intensita.getWeeklist().get(intensita.getI()).get(2)+ " " + Math.round(intensita.getCalorie()*a[2])) );
        //System.out.println("intensità "+intensita.getWeeklist());
        return intensita.getWeeklist();
    }
    
    @Override
    public Map assegnaCalorie(AssegnaCalorie assegna) {
        
        List<Object> primoMomento = new ArrayList<>();   
        List<Object> secondoMomento = new ArrayList<>();  
        List<Object> terzoMomento = new ArrayList<>();   
        List<Double> primoMomentoMet = new ArrayList<>();  
        List<Double> secondoMomentoMet = new ArrayList<>();
        List<Double> terzoMomentoMet = new ArrayList<>();  
        //ListaMomenti [4, 9, 133, 4, 7, 89] 4=parti del corpo 9=gli esercizi da fare 133= calorie da perdere
        //FACCIAMO LA CONVERSIONE PERCHé LISTA MOMENTI C'è IN DIARIO è DI TIPO OBJECT
        int numeroEsePrimo = Integer.parseInt((String)assegna.getListaMomenti().get(1)); //IL NUMERO DI ESERCIZI DELLA MATTINA
        int numeroEseSecondo = Integer.parseInt((String)assegna.getListaMomenti().get(4)); //IL NUMERO DI ESERCIZI DELLA POMERIGGIO 
        int numeroEseTerzo = Integer.parseInt((String)assegna.getListaMomenti().get(7)); //IL NUMERO DI ESERCIZI DELLA SERA
        /*
          [2, 3, 28, 2, 3, 28, 2, 5, 56]   GETLISTAMOMENTO
          [2,3,28] PRIMO MOMENTO
          [2,3,8] SECONDO MOMNETO
          [2,5,56] TERZO MOMENTO
          NELLE SEGUENTI RIGHE SEPARIAMO I MOMENTI DELLA GIORNATA
        */
        for (int i = 0; i < 3; i++) {
            //AGGIUNGIAMO LE RIPETIZIONI PER IL PRIMO MOMENTO
            primoMomento.add(assegna.getListaMomenti().get(i));//SOLO I REP DELLA MATTINA 
        }       
        for (int j = 0; j < numeroEsePrimo*2; j++) {
            //AGGIUNGIAMO I MET PER IL PRIMO MOMENTO
            primoMomentoMet.add(assegna.getListaMetRep().get(j));//SOLO I MET DELLA MATTINA
        }       
        for (int i = 3; i < 6; i++) {
            //AGGIUNGIAMO I REP PER IL SECONDO MOMENTO
            secondoMomento.add(assegna.getListaMomenti().get(i));//SOLO I REP DELLA POMERIGGIO 
        }       
        for (int j = numeroEsePrimo*2; j < numeroEsePrimo*2 + numeroEseSecondo*2; j++) {
            //AGGIUNGIAMO I MET AL SECONDO MOMENTO
            secondoMomentoMet.add(assegna.getListaMetRep().get(j));//SOLO I MET DELLA POMERIGGIO
        }       
        for (int i = 6; i < 9; i++) {
            //AGGIUNGIAMO I REP AL TERZO MOMENTO
            terzoMomento.add(assegna.getListaMomenti().get(i));//SOLO I REP DELLA SERA
        }       
        for (int j = numeroEsePrimo*2 + numeroEseSecondo*2; j < numeroEsePrimo*2 + numeroEseSecondo *2+ numeroEseTerzo*2; j++) {
            //AGGIUNGIAMO I MET AL TERZO MOMENTO
            terzoMomentoMet.add(assegna.getListaMetRep().get(j));//SOLO I MET DELLA SERA
        } 
        //PASSIAMO CIò CHE ABBIAMO CREATO SOPRA
        assegna.getDiario().calcoloCalorie(numeroEsePrimo, primoMomento, primoMomentoMet).forEach((n) -> assegna.getListaKcalRipetizione().add(n));
        assegna.getDiario().calcoloCalorie(numeroEseSecondo, secondoMomento, secondoMomentoMet).forEach((n) -> assegna.getListaKcalRipetizione().add(n));
        assegna.getDiario().calcoloCalorie(numeroEseTerzo, terzoMomento, terzoMomentoMet).forEach((n) -> assegna.getListaKcalRipetizione().add(n));
        
        Map risultati = new HashMap();
        
        risultati.put("RepMin", assegna.getListaKcalRipetizione());
        risultati.put("ListaMomenti", assegna.getListaMomenti());
        /*
        System.out.println("primoMomento "+primoMomento);
        System.out.println("secondoMomento "+secondoMomento);
        System.out.println("terzoMomento "+terzoMomento);
        System.out.println("primoMomentoMet "+primoMomentoMet);
        System.out.println("secondoMomentoMet " +secondoMomentoMet);
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

    public double[] getInt6() {
        return int6;
    }

    public double[] getInt7() {
        return int7;
    }

    public double[] getInt8() {
        return int8;
    }

    public double[] getInt9() {
        return int9;
    }

    public double[] getInt10() {
        return int10;
    }

    public double[] getInt11() {
        return int11;
    }

    public double[] getInt12() {
        return int12;
    }

    public double[] getInt13() {
        return int13;
    }

    public double[] getInt14() {
        return int14;
    }

    public double[] getInt15() {
        return int15;
    }

    public double[] getInt16() {
        return int16;
    }

    public double[] getInt17() {
        return int17;
    }

    public double[] getInt18() {
        return int18;
    }

    public double[] getInt19() {
        return int19;
    }

    public double[] getInt20() {
        return int20;
    }

    public double[] getInt21() {
        return int21;
    }

    public double[] getInt22() {
        return int22;
    }

    public double[] getInt23() {
        return int23;
    }

    public double[] getInt24() {
        return int24;
    }

    public double[] getInt25() {
        return int25;
    }
   
}
