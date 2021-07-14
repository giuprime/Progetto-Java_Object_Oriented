package Allenamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Interfaccia {
     
    public Map assegnaEsercizi(Esercizio product); //Assegna gli esercizi NON il numero di esercizi in base alle parti del corpo da allenare
    
    public List<Object> assegnaNumEsercizi (Momenti momenti); //Assegna il numero di esercizi in base all'intensità
    
    public List<ArrayList> calcoloCalorie(Intensita intensita); //Calcolo calorie di esercizi senza modifica
    
    public Map assegnaCalorie(AssegnaCalorie assegna); // Suddivisione delle calorie in base ai momenti
    
}




