package Allenamento;

import java.util.ArrayList;
import java.util.List;

public class Intensita {
    
    private final List<ArrayList> weeklist;
    private final double calorie;
    private final int i;
    private final String calorieL;
    
    //QUESTA CLASSE è USATA PER OTTENERE I SUOI ATTRIBUTI PER VEDERE IL SUO UTILIZZO ANDARE IN DIARIO
    public Intensita(List<ArrayList> weeklist, double calorie, int i, String calorieL) {
        this.weeklist = weeklist;
        this.calorie = calorie;
        this.i = i;
        this.calorieL = calorieL;
    }
    
    public int getI() {
        return i;
    }

    public List<ArrayList> getWeeklist() {
        //Weeklist [[Lunedi Mattina (Leggero) 56, -, Lunedi Sera (Leggero) 56], [-, -, -], [-, -, -], [-, -, -], [-, -, -], [-, -, -], [-, -, -]]
        return weeklist;
    }

    public double getCalorie() {
        //LE CALORIE TOTALI DA BRUCIARE
        return calorie;
    }

    public String getCalorieL() {
        //L'INTENSITà SCELTA CalorieL= L L 
        return calorieL;
    }
    
    
    

    
}
