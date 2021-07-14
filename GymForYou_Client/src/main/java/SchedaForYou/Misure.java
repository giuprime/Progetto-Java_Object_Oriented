package SchedaForYou;

import Impostazioni.Xmlpars;

public class Misure {
    
    private float petto,petto_inter, petto_f;
    private float bicipite,bicipite_inter,bicipite_f;
    private float avambracci, avambracci_inter, avambracci_f;
    private float cosce,cosce_inter,cosce_f;
    private float polpacci,polpacci_inter,polpacci_f;
    private Xmlpars parser3 = new Xmlpars("misure.save");

    public Misure() {
        
        this.petto = Float.parseFloat(parser3.getElement("Petto_Iniziale"));
        this.petto_inter = Float.parseFloat(parser3.getElement("Petto_Intermedio"));
        this.petto_f = Float.parseFloat(parser3.getElement("Petto_Finale"));
        this.bicipite = Float.parseFloat(parser3.getElement("Bicipite_Iniziale"));
        this.bicipite_inter = Float.parseFloat(parser3.getElement("Bicipite_Intermedio"));
        this.bicipite_f = Float.parseFloat(parser3.getElement("Bicipite_Finale"));
        this.avambracci = Float.parseFloat(parser3.getElement("Avambraccio_Iniziale"));
        this.avambracci_inter = Float.parseFloat(parser3.getElement("Avambraccio_Intermedio"));
        this.avambracci_f = Float.parseFloat(parser3.getElement("Avambraccio_Finale"));
        this.cosce = Float.parseFloat(parser3.getElement("Cosce_Iniziale"));
        this.cosce_inter = Float.parseFloat(parser3.getElement("Cosce_Intermedio"));
        this.cosce_f = Float.parseFloat(parser3.getElement("Cosce_Finale"));
        this.polpacci = Float.parseFloat(parser3.getElement("Polpacci_Iniziale"));
        this.polpacci_inter = Float.parseFloat(parser3.getElement("Polpacci_Intermedio"));
        this.polpacci_f = Float.parseFloat(parser3.getElement("Polpacci_Finale"));
        
    }
    
    public float getPetto() {
        return petto;
    }
    
    public float getPetto_inter() {
        return petto_inter;
    }
    
    public float getPetto_f() {
        return petto_f;
    }
    
    public float getBicipite() {
        return bicipite;
    }
    
    public float getBicipite_inter() {
        return bicipite_inter;
    }
    
    public float getBicipite_f() {
        return bicipite_f;
    }
    
    public float getAvambracci() {
        return avambracci;
    }
    
    public float getAvambracci_inter() {
        return avambracci_inter;
    }
    
    public float getAvambracci_f() {
        return avambracci_f;
    }
    
    public float getCosce() {
        return cosce;
    }
    
    public float getCosce_inter() {
        return cosce_inter;
    }
    
    public void setPetto(float petto) {
        this.petto = petto;
    }

    public void setPetto_inter(float petto_inter) {
        this.petto_inter = petto_inter;
    }

    public void setPetto_f(float petto_f) {
        this.petto_f = petto_f;
    }

    public void setBicipite(float bicipite) {
        this.bicipite = bicipite;
    }

    public void setBicipite_inter(float bicipite_inter) {
        this.bicipite_inter = bicipite_inter;
    }

    public void setBicipite_f(float bicipite_f) {
        this.bicipite_f = bicipite_f;
    }

    public void setAvambracci(float avambracci) {
        this.avambracci = avambracci;
    }

    public void setAvambracci_inter(float avambracci_inter) {
        this.avambracci_inter = avambracci_inter;
    }

    public void setAvambracci_f(float avambracci_f) {
        this.avambracci_f = avambracci_f;
    }

    public void setCosce(float cosce) {
        this.cosce = cosce;
    }

    public void setCosce_inter(float cosce_inter) {
        this.cosce_inter = cosce_inter;
    }

    public float getCosce_f() {
        return cosce_f;
    }

    public void setCosce_f(float cosce_f) {
        this.cosce_f = cosce_f;
    }

    public float getPolpacci() {
        return polpacci;
    }

    public void setPolpacci(float polpacci) {
        this.polpacci = polpacci;
    }

    public float getPolpacci_inter() {
        return polpacci_inter;
    }

    public void setPolpacci_inter(float polpacci_inter) {
        this.polpacci_inter = polpacci_inter;
    }

    public float getPolpacci_f() {
        return polpacci_f;
    }

    public void setPolpacci_f(float polpacci_f) {
        this.polpacci_f = polpacci_f;
    }
    
    public double getPercentuale_petto() {
        
         double petto2= (double) (getPetto() *100);
         double petto_inter2 = (double)  (getPetto_inter() *100);
         double petto_f2 = (double) (getPetto_f() *100);
         double percentuale_petto;
    
         
        
        if(petto_inter2 == petto_f2) { //CONFRONTO TRA IL PETTO INIZIALE E QUELLO FINALE
            percentuale_petto =  1 ; //PETTO AL MASSIMO
        }else if(petto2 == petto_inter2){ //PETTO INSERITO UGUALE A PETTO INIZIALE SI ENTRA SOLAMENTE QUANDO è STATA FATTA LA REGISTRAZIONE ELSE IF AGGIUNTO PERCHé SENNò DAVA ERRORE
            percentuale_petto = (petto_inter2)/petto_f2;  //CALCOLIAMO LA PERCENTUALE INIZIALE 
        }else{
            //CALCOLO PER OTTENRE LA PERCENTUALE ALL'INTERNO DELLA PROGRESS BAR
            double n1 = (petto_f2 - petto_inter2);
            double d1 = (petto_f2 - petto2);
            percentuale_petto = (1 - (n1/d1));
        }
        return percentuale_petto;
    }

   

    public double getPercentuale_bicipite() {
        
        double bici = (double) (getBicipite() *100 );
        double bici_inter = (double) (getBicipite_inter() *100);
        double bici_f = (double) (getBicipite_f() *100);
        double percentuale_bicipite;
    
        
        if (bici_inter == bici_f) {
            percentuale_bicipite =  1 ;
        }else if(bici == bici_inter){
            percentuale_bicipite = (bici_inter)/bici_f;
        }else{
             double n2 = (bici_f - bici_inter);
             double d2 = (bici_f - bici);
             percentuale_bicipite = (1 - (n2/d2));
        }
        return percentuale_bicipite;
    }

   

    public double getPercentuale_avambraccio() {
        double ava = (double) (getAvambracci() *100 );
        double ava_inter = (double) (getAvambracci_inter()*100);
        double ava_f = (double) (getAvambracci_f()*100);
        double percentuale_avambraccio;
    
        
        if (ava_inter == ava_f) {
            percentuale_avambraccio =  1 ;
        }else if(ava == ava_inter){
            percentuale_avambraccio = (ava_inter)/ava_f;
        }else{
            double n3 = (ava_f - ava_inter);
            double d3 = (ava_f - ava);
            percentuale_avambraccio = (1 - (n3/d3));
        }
        
        return percentuale_avambraccio;
    }


    public double getPercentuale_cosce() {
         double cosce2 = (double) (getCosce()*100) ;
         double cosce_inter2 = (double) (getCosce_inter()*100);
         double cosce_f2 = (double) (getCosce_f()*100);
         double percentuale_cosce ;
         
         if (cosce_inter2 == cosce_f2) {
            percentuale_cosce =  1 ;
        }else if(cosce2 == cosce_inter2){
            percentuale_cosce = (cosce_inter2)/cosce_f2;
        }else{
            double n4 = (cosce_f2 - cosce_inter2);
            double d4 = (cosce_f2 - cosce2);
            percentuale_cosce = (1 - (n4/d4)); 
        }
         
        return percentuale_cosce;
    }


    public double getPercentuale_polpacci() {
        double polpa = (double) (getPolpacci()*100) ;
        double polpa_inter = (double) (getPolpacci_inter()*100);
        double polpa_f = (double) (getPolpacci_f()*100);
        double percentuale_polpacci ;
         
        if (polpa_inter == polpa_f) {
            percentuale_polpacci =  1 ;
        }else if(polpa == polpa_inter){
            percentuale_polpacci = (polpa_inter)/polpa_f;
        }else{
            double n5 = (polpa_f - polpa_inter);
            double d5 = (polpa_f - polpa);
            percentuale_polpacci = (1 - (n5/d5));
        }
        

        return percentuale_polpacci;
    }

}
