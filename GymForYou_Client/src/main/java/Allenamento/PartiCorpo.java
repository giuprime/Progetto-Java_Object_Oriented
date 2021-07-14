package Allenamento;

import Impostazioni.Xmlpars;
import java.util.List;

public class PartiCorpo {
    
    public void schedaCorso(int i, String tipo, List<Integer> shuffle1, List<Object> listaEsercizi,List<Double> listaMetRep ){
        
        Xmlpars parser5 = new Xmlpars("eserciziCorso/esercizi.xml");
        
        listaEsercizi.add(parser5.getElement(tipo + "_" + shuffle1.get(i-1) ));
        listaMetRep.add(Double.parseDouble(parser5.getElement(tipo + "_"+ shuffle1.get(i-1) + "_met")));
        listaMetRep.add(Double.parseDouble(parser5.getElement(tipo + "_"+ shuffle1.get(i-1) + "_rep")));
        
    }
    
    public void schedaPersonalizzata(int i, int number,int number1, String tipo, List<Integer> shuffle, List<Object> listaEsercizi,List<Object> listaPartiCorpo,List<Double> listaMetRep ){
        /*IN QUESTO METODO AGGIUNGIAMO GLI ESERCIZI CHE VERRANNO MOSTRATI
        LISTAPARTICORPO è UNA STRINGA CON SCRITTA LA PARTE DEL CORPO. Lista parti corpo [0.09950248756218905, Petto, 0.8130081300813008, Cosce]
        NUMBER IDENTIFICA ELEMENTO DA PRENDERE DALLA LISTAPARTI CORPO PER OTTENERE IL NOME DELLA PARTE DEL CORPO.
        NUMBER1 VIENE USATO PER FARE UNO SHUFFLE DEGLI ESERCIZI PER NON PRENDERE SEMPRE GLI STESSI.
        SHUFFLE è UN ARRAY DI NUMERI CASUALI CHE SERVIRà PER PRENDERE IL NUMERO DELL'ESERCIZIO shuffle.get(i-number1) ANDRà A PRENDERE L'ELEMENTO CHE SI TROVA NELLA POSIZIONE DATA DALLA SOTTRAZIONE
        */ 
        Xmlpars parser2 = new Xmlpars("eserciziScheda/esercizi.xml");
        
        listaEsercizi.add(parser2.getElement( (String)listaPartiCorpo.get(number) + "_"+ shuffle.get(i-number1)));
        listaMetRep.add(Double.parseDouble(parser2.getElement(listaPartiCorpo.get(number) + "_"+ shuffle.get(i-number1) + "_met")));
        listaMetRep.add(Double.parseDouble(parser2.getElement(listaPartiCorpo.get(number) + "_"+ shuffle.get(i-number1) + "_rep")));
        /*
        System.out.println("listaEsercizi"+listaEsercizi);
        System.out.println("listaMetRep"+listaMetRep);
        System.out.println("listaMetRep"+listaMetRep);
        */
        
    }
    
}
