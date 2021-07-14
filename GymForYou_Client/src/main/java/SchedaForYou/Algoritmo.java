package SchedaForYou;

import Impostazioni.Xmlpars;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Algoritmo {
    
    private Xmlpars parser4;
    private Xmlpars parser5;
    private Xmlpars parser6;
    private final Misure misura = new Misure();
    
    public double[] ordinaArray(){
        //ARRAY CONTENETE TUTTE LE PERCENTUALI DELLE VARIE PARTI DEL CORPO--> [0.3,0.4,1,1,1]
        double[] nums={misura.getPercentuale_petto(), misura.getPercentuale_bicipite(), misura.getPercentuale_avambraccio(), misura.getPercentuale_cosce(), misura.getPercentuale_polpacci()};
        //METODO PER ORDINARE L'ARRAY IN ORDINE CRESCENTE
        Arrays.sort(nums);
        return nums;
    }
    
    public List<String> schedaUno(){
        
        double[] nums = ordinaArray();
        
        //CICLO TUTTO L'ARRAY NUMS
        for (int i = 0; i < nums.length; i++) {
            //*************************************************************************************************************************************************************************************************************************************************

            //1° GRUPPO ESERCIZI 
            
            if (nums[0] == nums[i]) {   
                //CONTROLLO A QUALE VARIABILE DELL'ARRAY COINCIDE IL NUMERO PIù PICCOLO DELL'ARRAY ORDINATO    
                //IN BASE A QUALE PARTE DEL CORPO RISULTA MENO ALLENATA VERRANNO SOMMINISTRATI GLI ESERCIZI CORRISPONDENTI 
                if (nums[i] == misura.getPercentuale_petto()) {
                    parser4 = new Xmlpars("esercizi/petto.save");           
                }else if (nums[i] == misura.getPercentuale_bicipite()) {
                     parser4 = new Xmlpars("esercizi/bicipiti.save");
                }else if (nums[i] == misura.getPercentuale_avambraccio()) {
                     parser4 = new Xmlpars("esercizi/avambracci.save");
                }else if (nums[i] == misura.getPercentuale_cosce()) {
                     parser4 = new Xmlpars("esercizi/cosce.save");
                }else if (nums[i] == misura.getPercentuale_polpacci()) {
                     parser4 = new Xmlpars("esercizi/polpacci.save");
                }
            }
            
            
            //*************************************************************************************************************************************************************************************************************************************************
            //2° GRUPPO ESERCIZI 
            
            //1°CASO - IN CUI IL SECONDO NUMERO PIù PICCOLO DELL'ARRAY E' GIA' AL 100%, AUTOMATICAMENTE BISOGNA ALLENARE SOLTANTO LA PARTE DEL CORPO CORRISPONDENTE AL NUMERO PIU' PICCOLO DELL ARRAY
            
            //CONTROLLO SE IL SECONDO NUMERO PIU' PICCOLO E' GIA' AL 100%
            //NEL CASO IN CUI LO FOSSE, VERRANNO SCELTI ALTRI ESERCIZI DELLA PARTE DEL CORPO PIU'PICCOLA OVVERO IL PRIMO ELEMENTO DELL'ARRAY
            if (nums[1] == 1){ 
                nums[1] = nums[0];
                if (nums[1] == nums[i]) {   
                    if (nums[i] == misura.getPercentuale_petto()) {
                        parser5 = new Xmlpars("esercizi/petto.save");
                    }else if (nums[i] == misura.getPercentuale_bicipite()) {
                         parser5 = new Xmlpars("esercizi/bicipiti.save");
                    }else if (nums[i] == misura.getPercentuale_avambraccio()) {
                         parser5 = new Xmlpars("esercizi/avambracci.save");
                    }else if (nums[i] == misura.getPercentuale_cosce()) {
                         parser5 = new Xmlpars("esercizi/cosce.save");
                    }else if (nums[i] == misura.getPercentuale_polpacci()) {
                         parser5 = new Xmlpars("esercizi/polpacci.save");
                    }
                }
                
            }else{
                //2°CASO
                //NEL CASO IN CUI IL SECONDO NUMERO PIU' PICCOLO DELL ARRAY NON E' AL 100%, VERRANNO SCELTI ESERCIZI RELATIVI A QUELLA PARTE DEL CORPO
                if(nums[1] == nums[i]){
                
                    // CONTROLLO QUAL'E' LA PARTE DEL CORPO CHE VA ALLENATA
                    if (nums[i] == misura.getPercentuale_petto()) {
                         parser5 = new Xmlpars("esercizi/petto.save");
                    }else if (nums[i] == misura.getPercentuale_bicipite()) {
                         parser5 = new Xmlpars("esercizi/bicipiti.save");
                    }else if (nums[i] == misura.getPercentuale_avambraccio()) {
                         parser5 = new Xmlpars("esercizi/avambracci.save");
                    }else if (nums[i] == misura.getPercentuale_cosce()) {
                         parser5 = new Xmlpars("esercizi/cosce.save");
                    }else if (nums[i] == misura.getPercentuale_polpacci()) {
                         parser5 = new Xmlpars("esercizi/polpacci.save");
                    }
                }
            }   
            //*************************************************************************************************************************************************************************************************************************************************
            //3° GRUPPO ESERCIZI
            //1°CASO - IN CUI IL TERZO NUMERO PIù PICCOLO DELL'ARRAY E' GIA' AL 100%, AUTOMATICAMENTE BISOGNA ALLENARE SOLTANTO LA PARTE DEL CORPO CORRISPONDENTE AL NUMERO PIU' PICCOLO DELL ARRAY
            
            //CONTROLLO SE IL TERZO NUMERO PIU' PICCOLO E' GIA' AL 100%
            //NEL CASO IN CUI LO FOSSE, VERRANNO SCELTI ALTRI ESERCIZI DELLA PARTE DEL CORPO PIU'PICCOLA OVVERO IL PRIMO ELEMENTO DELL'ARRAY
            if (nums[2] == 1){
                nums[2] = nums[0];
                if (nums[2] == nums[i]) {   
                                
                    if (nums[i] == misura.getPercentuale_petto()) {
                        parser6 = new Xmlpars("esercizi/petto.save");
                    }else if (nums[i] == misura.getPercentuale_bicipite()) {
                         parser6 = new Xmlpars("esercizi/bicipiti.save");
                    }else if (nums[i] == misura.getPercentuale_avambraccio()) {
                         parser6 = new Xmlpars("esercizi/avambracci.save");
                    }else if (nums[i] == misura.getPercentuale_cosce()) {
                         parser6 = new Xmlpars("esercizi/cosce.save");
                    }else if (nums[i] == misura.getPercentuale_polpacci()) {
                         parser6 = new Xmlpars("esercizi/polpacci.save");
                    }
                }
            }else{
                //2°CASO
                //NEL CASO IN CUI IL TERZO NUMERO PIU' PICCOLO DELL ARRAY NON E' AL 100%, VERRANNO SCELTI ESERCIZI RELATIVI A QUELLA PARTE DEL CORPO
                if(nums[2] == nums[i]){
                    // CONTROLLO QUAL'E' LA PARTE DEL CORPO CHE VA ALLENATA
                    if (nums[i] == misura.getPercentuale_petto()) {
                        parser6 = new Xmlpars("esercizi/petto.save");
                    }else if (nums[i] == misura.getPercentuale_bicipite()) {
                         parser6 = new Xmlpars("esercizi/bicipiti.save");
                    }else if (nums[i] == misura.getPercentuale_avambraccio()) {
                         parser6 = new Xmlpars("esercizi/avambracci.save");
                    }else if (nums[i] == misura.getPercentuale_cosce()) {
                         parser6 = new Xmlpars("esercizi/cosce.save");
                    }else if (nums[i] == misura.getPercentuale_polpacci()) {
                         parser6 = new Xmlpars("esercizi/polpacci.save");
                    }
                }
            }   
        }
        //*************************************************************************************************************************************************************************************************************************************************

        //CREO UN HASHMAP CONTENETE GLI ESERCIZI DEL 1°GRUPPO, OVVERO LA PARTE DEL CORPO PIU' PICCOLA
        Map ese1 = new HashMap();
        ese1.put("1", parser4.getElement("primo"));
        ese1.put("1_path", parser4.getElement("path_primo"));
        ese1.put("2", parser4.getElement("secondo"));
        ese1.put("2_path", parser4.getElement("path_secondo"));
        ese1.put("3", parser4.getElement("terzo"));
        ese1.put("3_path", parser4.getElement("path_terzo"));
        ese1.put("4", parser4.getElement("quarto"));
        ese1.put("4_path", parser4.getElement("path_quarto"));
        ese1.put("5", parser4.getElement("quinto"));
        ese1.put("5_path", parser4.getElement("path_quinto"));
        ese1.put("5.1", parser4.getElement("sesto"));
        ese1.put("5.1_path", parser4.getElement("path_sesto"));
        ese1.put("5.2", parser4.getElement("settimo"));
        ese1.put("5.2_path", parser4.getElement("path_settimo"));
        
        //CREO UN HASHMAP CONTENETE GLI ESERCIZI DEL 2°GRUPPO, OVVERO LA SECONDA PARTE DEL CORPO PIU' PICCOLA
        //NEL CASO IN CUI LA PARTE DEL CORPO DEL 2°GRUPPO E' GIA' ALLENATA, VERRANO SCELTI GLI ESERCIZI DELLA PARTE DEL CORPO PIU' PICCOLA
        Map ese2 = new HashMap();
        ese2.put("6", parser5.getElement("primo"));
        ese2.put("6_path", parser5.getElement("path_primo"));
        ese2.put("7", parser5.getElement("secondo"));
        ese2.put("7_path", parser5.getElement("path_secondo"));
        ese2.put("8", parser5.getElement("terzo"));
        ese2.put("8_path", parser5.getElement("path_terzo"));
        ese2.put("9", parser5.getElement("quarto"));
        ese2.put("9_path", parser5.getElement("path_quarto"));
        ese2.put("10", parser5.getElement("quinto"));
        ese2.put("10_path", parser5.getElement("path_quinto"));
        ese2.put("10.1", parser5.getElement("sesto"));
        ese2.put("10.1_path", parser5.getElement("path_sesto"));
        ese2.put("10.2", parser5.getElement("settimo"));
        ese2.put("10.2_path", parser5.getElement("path_settimo"));
        
        //CREO UN HASHMAP CONTENETE GLI ESERCIZI DEL 3°GRUPPO, OVVERO LA TERZA PARTE DEL CORPO PIU' PICCOLA
        //NEL CASO IN CUI LA PARTE DEL CORPO DEL 3°GRUPPO E' GIA' ALLENATA, VERRANO SCELTI GLI ESERCIZI DELLA PARTE DEL CORPO PIU' PICCOLA
        Map ese3 = new HashMap();
        ese3.put("11", parser6.getElement("primo"));
        ese3.put("11_path", parser6.getElement("path_primo"));
        ese3.put("12", parser6.getElement("secondo"));
        ese3.put("12_path", parser6.getElement("path_secondo"));
        ese3.put("13", parser6.getElement("terzo"));
        ese3.put("13_path", parser6.getElement("path_terzo"));
        ese3.put("14", parser6.getElement("quarto"));
        ese3.put("14_path", parser6.getElement("path_quarto"));
        ese3.put("15", parser6.getElement("quinto"));
        ese3.put("15_path", parser6.getElement("path_quinto"));
        ese3.put("15.1", parser6.getElement("sesto"));
        ese3.put("15.1_path", parser6.getElement("path_sesto"));
        ese3.put("15.2", parser6.getElement("settimo"));
        ese3.put("15.2_path", parser6.getElement("path_settimo"));
        
        /// CREO UN HASHAMP CHE CONTERRA' TUTTI E 3 GLI HASHMAP SOPRA CREATI, COMPOSTI DAGLI ESERCIZI RITENUTI NECESSARI
        Map<String, String> dati = new HashMap();
        
        //AGGIUNGO IL PRIMO HASHMAP
        dati.putAll(ese1);
        //AGGIUNGO IL SECONDO HASHMAP
        dati.putAll(ese2);
        //AGGIUNGO IL TERZO HASHMAP
        dati.putAll(ese3);
        ///
        
        //MAP CHE CONTIENE (NOME ESERCIZI, PATH) NON RANDOM
        Map esercizi = new HashMap();
        //CREO ARRAYLIST CHE CONTERRA' TUTTI E 15 GLI ESERCIZI
        List<String> eser = new ArrayList<>();
        ////CREO ARRAY CHE CONTERRA' TUTTI E 15 PATH CORRISPONDENTI G
        //List<String> eser_path = new ArrayList<>();
        
        //PRELEVA LE CHIAVI CHE VANNO DA ("0") A ("15") DAL MAP DATI
        for (String key : dati.keySet()) {
            for (int i = 1; i <= 15; i++) {
                //SE LA CHIAVE E' UGUALE AL VALORE DELL'INT I.              KEY =    "1"== 1     = INT I
                if (key.equals(String.valueOf(i))) {             
                    //AGGIUNGIAMO ALL ARRAYLIST ESER GLI ESERCIZI DAL 1 AL 15
                    eser.add(dati.get(key));
                    //AGGIUNGIAMO ALL ARRAYLIST ESER_PATH I PATH DELLE IMMAG. DI OGNI ESERCIZIO
                    //eser_path.add(dati.get(key+"_path"));  
                    
                    //HASHMAP CONTENENTE GLI ESERCIZI E I PATH ("NOME_ESERCIZIO","PATH")  NON ANCORA RANDOM
                    esercizi.put(dati.get(key), dati.get(key+"_path"));   //[BURPEEE, C:// ]
                }
            }
        }    
        
        //MAP CHE CONTIENE (NOME STRETCHING, PATH) NON RANDOM
        Map strex = new HashMap();
        //ARRAY CHE CONTIENE TUTTI E 6 GLI STRETCHING
        List<String> stretching = new ArrayList<>();
        Random random0 = new Random();
        List<String> numeri = new ArrayList<>();          //[1,2]
        numeri.add("1");
        numeri.add("2");
        //PRELEVA LE CHIAVI CHE VANNO DA ("5.1,5.2,10.1,10.2,15.1,15.2") DAL MAP DATI
        for (int i = 5; i <= 16 ; i=i+5) {
            //STRING CONTENENTE NUMERO 1 O 2
            String rand0 = numeri.get(random0.nextInt(numeri.size()));      //"1" O "2"
            stretching.add(dati.get(i+"."+rand0));                          //5.1 O 5.2    //10.1 O 10.2    //15.1 O 15.2 
            //HASHMAP CONTENENTE GLI STRETCHING E I PATH ("NOME_STRECTCHING","PATH")  NON ANCORA RANDOM
            strex.put(dati.get(i+"."+rand0), dati.get(i+"."+rand0+"_path"));
        }
        
        
        
        //ARRAY CHE CONTIENE I 9 ESERCIZI RANDOM
        List<String> esercizi_random = new ArrayList<>();
        Random random = new Random();
        //PRELEVA 9 ESERCIZI DIVERSI DALL'ARRAY CHE CONTIENE 15 ESERCIZI
        for(int i=0; i < 50; i++){
            if (esercizi_random.size() < 9) {
                //SINGOLO ESERCIZI
                String ran = eser.get( random.nextInt(eser.size()) );
                //SE IL SINGOLO ESERCIZI ESISTE GIA'.      EVITA LA RIPETIIZIONE DI ESERCIZI UGUALI
                if (!esercizi_random.contains(ran))   { 
                    //SE NON ESISTE AGGIUNGILO
                    esercizi_random.add(ran);  
                }
            }
        }
        
        //ARRAY CHE CONTIENE I 3 STRETCHING RANDOM
        List<String> stretching_random = new ArrayList<>();
        Random random1 = new Random();
        //PRELEVA 3 STRETCHING DIVERSI DALL'ARRAY CHE CONTIENE 3 STRETCHING
        for(int i=0; i < 50; i++){
            if (stretching_random.size() < 3) {
                //STRING CONTENENTE IL VALORE DELLA CHIAVE RANDOM DELL'ARRAY STRETCHING
                String rand = stretching.get( random1.nextInt(stretching.size()) );
                //SE IL SINGTOLO STRETCHING ESISTE GIA'.      EVITA LA RIPETIIZIONE DI STRETCHING UGUALI
                if (!stretching_random.contains(rand))   { 
                    //SE NON ESISTE AGGIUNGILO
                    stretching_random.add(rand); 
                    
                }
            }
        }
   
        //PER OTTENERE I PATH DA INSERIRE NELL'ARRAY LIST SCHEDA ALLENAMENTO UTILIZZO GLI HASHMAP ESERCIZI E STREX
        //CHE VENGONO ELABORATI NELLE ISTRUZIONI SOPRA.
        
        List<String> schedaAllenamento = new ArrayList<>();

        for (String nome_esercizio : esercizi_random) {
            //INSERISCO NOME DELL'ESERCIZIO ALL'INTERNO DELL'ARRAYLIST SCHEDA ALLENAMENTO
            schedaAllenamento.add(nome_esercizio);
            //INSERISCO IL PATH CORRISPONDENTE AL NOME DELL'ESERCIZIO ALL'INTERNO DELL'ARRAYLIST SCHEDA ALLENAMENTO
            schedaAllenamento.add((String)esercizi.get(nome_esercizio));                        // [BUPREEE, c://]
        }
         
        for (String nome_stretching : stretching_random) {
            //INSERISCO NOME DELLO STRETCHING ALL'INTERNO DELL'ARRAYLIST SCHEDA ALLENAMENTO
            schedaAllenamento.add(nome_stretching);
            //INSERISCO IL PATH CORRISPONDENTE AL NOME DELLO STRETCHING ALL'INTERNO DELL'ARRAYLIST SCHEDA ALLENAMENTO
            schedaAllenamento.add((String)strex.get(nome_stretching));                  //[ALLUNGAMENTO BICIPITI, C://]
        }
         
        return schedaAllenamento;
    }
      
}


