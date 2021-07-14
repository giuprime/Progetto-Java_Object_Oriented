package Impostazioni_Server;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Database {
    
    private Statement st = null;
    private String username, password, db, indirizzo;
    private Integer porta;
    private MysqlDataSource dataSource = new MysqlDataSource();
    Connection conn;
    
     /**
     *
     * @param dataSource
     */
    public Database(MysqlDataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    /**
     *
     * @param url
     * @param username
     * @param password
     */
    
    public Database(String indirizzo, Integer porta, String username, String password, String db) {
        
        this.indirizzo=indirizzo;
        this.porta= porta;        
        this.username=username;
        this.password=password;
        this.db=db;
           
    }
    //************************************************************************************************************************************************************************************************************************
    //                              LOGIN E REGISTRAZIONE
    //************************************************************************************************************************************************************************************************************************
    
    //METODO CHE RESTITUISCE IL TIPO DI PERSONA CHE STA EFFETTUANDO IL LOGIN  (TAB :CREDENZIALI)
    public String ControlloEmail(Map dati){
        String risultato = "";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT type FROM " + dati.get("tabella") + " WHERE email = ? AND password = MD5(?)");
            prepareStatement.setString(1, (String) dati.get("email"));
            prepareStatement.setString(2, (String) dati.get("password"));
            ResultSet executeQuery = prepareStatement.executeQuery();
            executeQuery.last();
            
            if(executeQuery.getRow() > 0) {
                risultato = executeQuery.getString("type");
            }
 
        } catch(SQLException e) {
            System.out.println("errore query: " + e);
        }
        return risultato ;
    }
    
    //METODO CHE RESTITUISCE TRUE O FALSE NEL CASO IN CUI CI SIANO DUE EMAIL UGUALI NELLA TABELLA  (TAB :CREDENZIALI)
    public Boolean EmailDoppia(Map dati){
        
        boolean risultato = true;
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM " + dati.get("tabella") + " WHERE email = ? ");
            prepareStatement.setString(1, (String) dati.get("email"));
            ResultSet executeQuery = prepareStatement.executeQuery();
            executeQuery.last();
            
            if(executeQuery.getRow() > 0) {
                risultato = true;
            }else{
                risultato = false;
            }
 
        } catch(SQLException e) {
            System.out.println("errore query: " + e);
        }
        return risultato;
    }
    
    //METODO CHE INSERISCE EMAIL E PASSWORD NELLA TABELLA CREDENZIALI E TABELLA UTENTE  (TAB :CREDENZIALI)
    public void Registrazione(Map dati){
        try {
            //INSERT INTO CREDENZIALI
            PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO " + dati.get("tabella") + "(email, password)  VALUES (?,MD5(?)) ");
            prepareStatement.setString(1, (String) dati.get("email"));
            prepareStatement.setString(2, (String) dati.get("password"));
            
            //INSERT INTO UTENTE
            PreparedStatement prep = conn.prepareStatement("INSERT INTO " + dati.get("tabella1") + "(nome, cognome, email, genere, peso, altezza)  VALUES (?,?,?,?,?,?) ");
            prep.setString(1, (String) dati.get("nome"));
            prep.setString(2, (String) dati.get("cognome"));
            prep.setString(3, (String) dati.get("email"));
            prep.setString(4, (String) dati.get("genere"));
            prep.setString(5, (String) dati.get("peso"));
            prep.setString(6, (String) dati.get("altezza"));
            
            prepareStatement.executeUpdate();
            prep.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println("Impossibile effettuare la registrazione: " + e);
        }
    }
    
    //************************************************************************************************************************************************************************************************************************
    //                              MODIFICHE ACCOUNT
    //************************************************************************************************************************************************************************************************************************
    
    //METODO CHE VERIFICA SE LA PASSWORD INSERITA (VECCHIA PASSWORD) DALL'UTENTE CORRISPONDE A QUELLA DELLA TABELLA CREDENZIALI INSERITA ALLA MOMENTO DELLA REGISTRAZIONE
    //SE LE DUE PASSWORD CORRISPONDONO VIENE MODIFICATA LA PASSWORD PRESENTE NELLA TABELLA CREDENZIALI
    public String verificaModificaPassword(Map dati){
        
        String msg = "Password modificata!";
        try {
            //INSERT INTO CREDENZIALI
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT password FROM " + dati.get("tabella") + " WHERE email = ?");
            prepareStatement.setString(1, (String) dati.get("email"));
            ResultSet executeQuery = prepareStatement.executeQuery();
            executeQuery.last();
            //prepareStatement.executeUpdate();
            if(executeQuery.getRow() > 0) {
                if (executeQuery.getString("password").equals(dati.get("vecchiapass"))) {
                    PreparedStatement prep = conn.prepareStatement("UPDATE " + dati.get("tabella") + " SET password = MD5(?) WHERE email = ? ");

                    prep.setString(1, (String) dati.get("nuovapass"));
                    prep.setString(2, (String) dati.get("email"));
                    prep.executeUpdate();
                    
                }else{
                    msg="errore";
                }
            }else{
                msg="Password non coincidono";
            }
        } catch(SQLException e) {
            System.out.println("Impossibile effettuare la registrazione: " + e);
            msg= "Modifica fallita!";
        }
        return msg;
    }
    
    //METODO USATO PER MODIFICARE IL PESO E L'ALTEZZA DI UN UTENTE
    public void modificaPesoAltezza(Map dati){
        try {
            PreparedStatement prep = conn.prepareStatement("UPDATE " + dati.get("tabella") + " SET peso=?, altezza=? WHERE email = ? ");
            prep.setString(1, (String) dati.get("pesonuovo"));
            prep.setString(2, (String) dati.get("altezzanuovo"));
            prep.setString(3, (String) dati.get("email"));
            prep.executeUpdate();
            
        }catch(SQLException e) {
            System.out.println("Impossibile modificare peso e/o altezza: " + e);
        }
    }
    
    //************************************************************************************************************************************************************************************************************************
    //                              ADMIN METHODS
    //************************************************************************************************************************************************************************************************************************
    
    //METODO USATO NELLA DASHBOARD ADMIN PER ELIMINARE GLI ACCOUNT DEI MEIDICI O DEI TRAINER
    public void eliminaAccountAdmin(Map dati){
        try {
            
            PreparedStatement prep1 = conn.prepareStatement("DELETE from `trainer`  WHERE email = ?");
            prep1.setString(1, (String) dati.get("email"));
            prep1.executeUpdate();
            
            PreparedStatement prep2 = conn.prepareStatement("DELETE from `dottore`  WHERE email = ?");
            prep2.setString(1, (String) dati.get("email"));
            prep2.executeUpdate();
            
            PreparedStatement prep3 = conn.prepareStatement("DELETE from `credenziali`  WHERE email = ?");
            prep3.setString(1, (String) dati.get("email"));
            prep3.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println("Impossibile emilinare account: " + e);
        }
    }
    
    //METODO USATO NELLA DASHBOARD ADMIN PER INSERIRE UN NUOVO ACCOUNT  MEIDICO O  TRAINER
    public void inserisciAccount(Map dati){
        try {
            
            PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO " + dati.get("tabella") + "(email, password,type)  VALUES (?,MD5(?),?) ");
            prepareStatement.setString(1, (String) dati.get("email"));
            prepareStatement.setString(2, (String) dati.get("password"));
            prepareStatement.setString(3, (String) dati.get("genere"));
            
            if (dati.get("genere").equals("med")) {
                PreparedStatement prep = conn.prepareStatement("INSERT INTO " + dati.get("tabella2") + "(email, nome, cognome )  VALUES (?,?,?) ");
                prep.setString(1, (String) dati.get("email"));
                prep.setString(2, (String) dati.get("nome"));
                prep.setString(3, (String) dati.get("cognome"));
                prepareStatement.executeUpdate();
                prep.executeUpdate();
                
            }else if (dati.get("genere").equals("trn")) {
                PreparedStatement prep = conn.prepareStatement("INSERT INTO " + dati.get("tabella1") + "(email, nome, cognome )  VALUES (?,?,?)  ");
                prep.setString(1, (String) dati.get("email"));
                prep.setString(2, (String) dati.get("nome"));
                prep.setString(3, (String) dati.get("cognome"));

                prepareStatement.executeUpdate();
                prep.executeUpdate();
            }
            
        } catch(SQLException e) {
            System.out.println("Impossibile effettuare la registrazione: " + e);
        }
    }
    
    //METODO USATO NELLA DASHBOARD ADMIN PER MOSTRARE TUTTI I MEDICI E TRAINER REGISTRATI (TAB:MEDICI E TAB1: TRAINER)
    public ArrayList visualizzaRighe(String tabella,String tabella_uno){
        
        Map result = new HashMap();
        ArrayList<String> lista = new ArrayList<String>();
        
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT email,nome,cognome,voto FROM " + tabella +" ");
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                String email = rs.getString(1);
                String nome = rs.getString(2);
                String cognome = rs.getString(3);
                String voto = rs.getString(4);
                lista.add(email);
                lista.add(nome);
                lista.add(cognome);
                lista.add(voto);
                lista.add("Medico");
            }
            
            PreparedStatement prep = conn.prepareStatement("SELECT email,nome,cognome,voto FROM " + tabella_uno +" ");
            ResultSet rs1 = prep.executeQuery();
            while (rs1.next()) {
                String email = rs1.getString(1);
                String nome = rs1.getString(2);
                String cognome = rs1.getString(3);
                String voto = rs1.getString(4);
                lista.add(email);
                lista.add(nome);
                lista.add(cognome);
                lista.add(voto);
                lista.add("Trainer");
            }
            
        } catch(SQLException e) {
            System.out.println("Dati Questionario errore!");
        }
        return lista;
    }
    
    //************************************************************************************************************************************************************************************************************************
    //                              DOTTORE METHODS
    //************************************************************************************************************************************************************************************************************************
    
    //METODO USATO NELLA DASHBOARD DOTTORE PER PRELEVARE LE RISPOSTE DEL QUESTIONARIO DI UN DETERMINATO UTENTE
    //(TAB: QUESTIONARIO)
    public Map prelevaRisposte(String email, String tabella){
        
        Map result = new HashMap();
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM " + tabella +" WHERE email = ?");
            prepareStatement.setString(1, email);
            ResultSet executeQuery = prepareStatement.executeQuery();
            executeQuery.last();
            
            if(executeQuery.getRow() > 0) {
                result.put("Email", executeQuery.getString("email"));
                result.put("prima", executeQuery.getString("prima"));
                result.put("seconda", executeQuery.getString("seconda"));
                result.put("terza", executeQuery.getString("terza"));
                result.put("quarta", executeQuery.getString("quarta"));
                result.put("quinta", executeQuery.getString("quinta"));
                result.put("sesta", executeQuery.getString("sesta"));
                result.put("settima", executeQuery.getString("settima"));
                result.put("ottava", executeQuery.getString("ottava"));
                result.put("nona", executeQuery.getString("nona"));
                result.put("decima", executeQuery.getString("decima"));
                result.put("undicesima", executeQuery.getString("undicesima"));
                result.put("dodicesima", executeQuery.getString("dodicesima"));
                result.put("tredicesima", executeQuery.getString("tredicesima"));
            }
        } catch(SQLException e) {
            System.out.println("Risposte questionario prelevate sbagliate!");
        }
        return result;
    }
    
    //METODO USATO NELLA DASHBOARD DEL DOTTORE PER MOSTRARE GLI UTENTI CHE HANNO COMPILATO IL QUESTIONARIO 
    public ArrayList visualizzaUtenti(String tabella){
        
        Map result = new HashMap();
        ArrayList<String> lista = new ArrayList<String>();
        
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM " + tabella +" WHERE esito='vuoto'");
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                String email = rs.getString(1);
                lista.add(email);
            }
        } catch(SQLException e) {
            System.out.println("Dati Questionario errore!");
        }
        return lista;
    }
    
    //METODO USATO PER MODIFICARE L'ESITO DEL QUESTIONARIO 
    public void esito(Map dati){
        try {
            
            //MODIFICA DENTRO TABELLA QUESTIONARIO
            PreparedStatement prepareStatement = conn.prepareStatement("UPDATE " + dati.get("Tabella1") + " SET esito=?  WHERE email = ? ");
            prepareStatement.setString(1, (String) dati.get("esito"));
            prepareStatement.setString(2, (String) dati.get("email"));
            prepareStatement.executeUpdate();
  
            //MODIFICA DENTRO TABELLA UTENTE
            PreparedStatement prep = conn.prepareStatement("UPDATE " + dati.get("Tabella") + " SET esito=? WHERE email = ? ");
            prep.setString(1, (String) dati.get("esito"));
            prep.setString(2, (String) dati.get("email"));
            prep.executeUpdate();
          
        } catch(SQLException e) {
            System.out.println("Impossibile modificare il campo esito: " + e);
        }
    }
    
    //************************************************************************************************************************************************************************************************************************
    //                              UTENTE METHODS
    //************************************************************************************************************************************************************************************************************************
    
    //METODO USATO PER ELIMNARE UN ACCOUNT UTENTE
    public void eliminaAccount(Map dati){
        try {
            PreparedStatement prep1 = conn.prepareStatement("DELETE from `questionario`  WHERE email = ?");
            prep1.setString(1, (String) dati.get("email"));
            prep1.executeUpdate();
            
            PreparedStatement prep2 = conn.prepareStatement("DELETE from `misure`  WHERE email = ?");
            prep2.setString(1, (String) dati.get("email"));
            prep2.executeUpdate();
            
            PreparedStatement prep3 = conn.prepareStatement("DELETE from `utente`  WHERE email = ?");
            prep3.setString(1, (String) dati.get("email"));
            prep3.executeUpdate();
            
            PreparedStatement prep4 = conn.prepareStatement("DELETE from `credenziali`  WHERE email = ?");
            prep4.setString(1, (String) dati.get("email"));
            prep4.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println("Impossibile emilinare account: " + e);
        }
    }
    
    //METODO USATO PER INVIARE LE RISPOSTE DEL QUESTIONARIO AL DB
    public void inviaQuestionario(Map dati){
        try {
            //MODIFICA IL CAMPO QUESTIONARIO DELLA TABELLA UTENTE
            PreparedStatement prepare = conn.prepareStatement("UPDATE  utente SET questionario = 'si' WHERE email= ?  ");
            prepare.setString(1, (String) dati.get("email"));
            prepare.executeUpdate();
            
            //INSERISCE LE RISPOSTE DEL QUESTIONARIO NELLA CORRISPONDENTE TABELLA
            PreparedStatement prep = conn.prepareStatement("INSERT INTO " + dati.get("Tabella") + 
                            "(email, prima, seconda, terza, quarta, quinta, sesta, settima, ottava,nona,decima,undicesima,dodicesima,tredicesima)  "
                                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            prep.setString(1, (String) dati.get("email"));
            prep.setString(2, (String) dati.get("d1"));
            prep.setString(3, (String) dati.get("d2"));
            prep.setString(4, (String) dati.get("d3"));
            prep.setString(5, (String) dati.get("d4"));
            prep.setString(6, (String) dati.get("d5"));
            prep.setString(7, (String) dati.get("d6"));
            prep.setString(8, (String) dati.get("d7"));
            prep.setString(9, (String) dati.get("d8"));
            prep.setString(10, (String) dati.get("d9"));
            prep.setString(11, (String) dati.get("d10"));
            prep.setString(12, (String) dati.get("d11"));
            prep.setString(13, (String) dati.get("d12"));
            prep.setString(14, (String) dati.get("d13"));
            
            
            prep.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println("Impossibile inviare dati del questionario: " + e);
        }
    }
    
    //************************************************************************************************************************************************************************************************************************
    //                              INSERIMENTO MISURE
    //************************************************************************************************************************************************************************************************************************
    
    //METODO USATO PER SALVARE I VALORI INIZIALI NELLA TABELLA MISURE
    public Map salvaValoriIniziali(String email,String petto,String bicipite,String avambraccio, String cosce, String polpacci, String tabella){

        Map risultato = new HashMap();
        try {
            //UPDATE TABELLA MISURE CON MISURE INIZIALI DI PETTO, ECC..
            PreparedStatement prep = conn.prepareStatement("UPDATE " + tabella + " SET petto_iniz =" + petto + ", bicipite_iniz= " + bicipite + ", avambraccio_iniz= " + avambraccio + ", cosce_iniz= " + cosce + ",polpacci_iniz=" + polpacci + " WHERE email = '"+email +"' ");
            prep.executeUpdate();
            risultato.put("result", "Valori Inseriti");
        } catch(SQLException e) {
            System.out.println("Impossibile inserire i valori iniziali: " + e);
        }
        return risultato;
    }
    
    //METODO USATO PER SALVARE I VALORI INTERMEDI NELLA TABELLA MISURE
    public Map salvaValoriIntermedi(String email,String petto,String bicipite,String avambraccio, String cosce, String polpacci, String tabella){
        
        Map risultato = new HashMap();
        try {
            //UPDATE TABELLA MISURE CON MISURE INTERMEDIE DI PETTO, ECC..
            PreparedStatement prep = conn.prepareStatement("UPDATE " + tabella + " SET petto_inter =" + petto + ", bicipite_inter= " + bicipite + ", avambraccio_inter= " + avambraccio + ", cosce_inter= " + cosce + ",polpacci_inter=" + polpacci + " WHERE email = '"+email +"' ");
            prep.executeUpdate();
            risultato.put("result", "Valori Intermedi Inseriti");
            
        } catch(SQLException e) {
            System.out.println("Impossibile inserire i valori iniziali: " + e);
        }
        return risultato;
    }
    
    //METODO USATO PER MODIFICARE I VALORI DELLE CIRCONFERENZE
    public void modificaCirconferenze(Map dati){
        
        try {
            PreparedStatement prep = conn.prepareStatement("UPDATE " + dati.get("Tabella") + " SET crf_vita = ?, crf_collo=?, crf_fianchi=?, massa_grassa= ? WHERE email = ? ");
            prep.setString(1, (String) dati.get("vita"));
            prep.setString(2, (String) dati.get("collo"));
            prep.setString(3, (String) dati.get("fianchi"));
            prep.setString(4, (String) dati.get("massa_grassa"));
            prep.setString(5, (String) dati.get("email"));
            prep.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println("Impossibile modificare i valori delle circonferenze: " + e);
        }
    }
    
    //METODO USATO PER MODIFICARE I VALORI DELLE CIRCONFERENZE
    public void modificaCrf_Caviglia_Polso(Map dati){
        try {
           
            PreparedStatement prep = conn.prepareStatement("UPDATE " + dati.get("Tabella") + " SET polso = ?, caviglia=?  WHERE email = ? ");
            prep.setString(1, (String) dati.get("polso"));
            prep.setString(2, (String) dati.get("caviglia"));
            prep.setString(3, (String) dati.get("email"));
            prep.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println("Impossibile modificare i valori delle circonferenze: " + e);
        }
    }
    
    //METODO USATO PER INSERIRE MASSA MAGRA NEL DB
    public void inserisciMassaMagra(Map dati){
        try {
            //INSERT INTO UTENTE
            PreparedStatement prep = conn.prepareStatement("UPDATE " + dati.get("Tabella") + " SET massa_magra=? WHERE email = ? ");
            prep.setString(1, (String) dati.get("massaMagra"));
            prep.setString(2, (String) dati.get("email"));
            prep.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println("Impossibile modificare i valori delle circonferenze: " + e);
        }
    }
    
    //METODO USATO PER INSERIRE LE MISURAZIONI FINALI 
    public void inseriscimisure(Map dati){
        try {
            //INSERISCI MISURE PETTO,BICIPITI, .....
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM " + dati.get("Tabella") +" WHERE email = ?");
            prepareStatement.setString(1, (String) dati.get("email"));
            ResultSet executeQuery = prepareStatement.executeQuery();
            executeQuery.last();
            
            if(executeQuery.getRow() == 0) {
                PreparedStatement prep = conn.prepareStatement("INSERT INTO " + dati.get("Tabella") + "(email,petto_final,bicipite_final,avambraccio_final,cosce_final,polpacci_final) VALUES (?,?,?,?,?,?)  ");
                prep.setString(1, (String) dati.get("email"));
                prep.setString(2, (String) dati.get("petto"));
                prep.setString(3, (String) dati.get("bicipite"));
                prep.setString(4, (String) dati.get("avambraccio"));
                prep.setString(5, (String) dati.get("cosce"));
                prep.setString(6, (String) dati.get("polpacci"));
                prep.executeUpdate();
            
            //CASO IN CUI VENGONO MODIFICATI I VALORI DI POLSO E CAVIGLIA
            }else if (executeQuery.getRow() > 0) {
                
                PreparedStatement prep = conn.prepareStatement("UPDATE  " + dati.get("Tabella") + " SET petto_final = ?,bicipite_final=?, avambraccio_final=?, cosce_final=?, polpacci_final=? WHERE email=?  ");
                prep.setString(1, (String) dati.get("petto"));
                prep.setString(2, (String) dati.get("bicipite"));
                prep.setString(3, (String) dati.get("avambraccio"));
                prep.setString(4, (String) dati.get("cosce"));
                prep.setString(5, (String) dati.get("polpacci"));
                prep.setString(6, (String) dati.get("email"));
                prep.executeUpdate();
            }
        } catch(SQLException e) {
            System.out.println("Impossibile inserire le misure finali: " + e);
        }
    }
    
    //************************************************************************************************************************************************************************************************************************
    //                              PRELEVAMENTO DATI PER XML
    //************************************************************************************************************************************************************************************************************************
    
    //METODO USATO PRELEVARE I DATI DAL DB PER POI SCRIVERE IL FILEXML.SAVE  (TAB: UTENTE)
    public Map PrendiDati(String email, String tabella){
        
        Map result = new HashMap();
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM " + tabella +" WHERE email = ?");
            prepareStatement.setString(1, email);
            ResultSet executeQuery = prepareStatement.executeQuery();
            executeQuery.last();
            if(executeQuery.getRow() > 0) {
                result.put("Nome", executeQuery.getString("nome"));
                result.put("Cognome", executeQuery.getString("cognome"));
                result.put("Email", executeQuery.getString("email"));
                result.put("Genere", executeQuery.getString("genere"));
                result.put("Peso", executeQuery.getString("peso"));
                result.put("Altezza", executeQuery.getString("altezza"));
                result.put("Polso", executeQuery.getString("polso"));
                result.put("Caviglia", executeQuery.getString("caviglia"));
                result.put("Circonferenza_Vita", executeQuery.getString("crf_vita"));
                result.put("Circonferenza_Collo", executeQuery.getString("crf_collo"));
                result.put("Circonferenza_Fianchi", executeQuery.getString("crf_fianchi"));
                result.put("Questionario", executeQuery.getString("questionario"));
                result.put("Massa_Grassa", executeQuery.getString("massa_grassa"));
                result.put("Massa_Magra", executeQuery.getString("massa_magra"));
                result.put("Esito_Dottore", executeQuery.getString("esito"));
            }
        } catch(SQLException e) {
            System.out.println("Dati Scritti sul file .save in modo sbagliato!");
        }
        return result;
    }
    
    //METODO USATO PER PRELEVARE MISURE PRESENTI NEL DB E SCRIVERLE NEL FILE MISURE.SAVE
    public Map prelevamisure(String email, String tabella){
        
        Map result = new HashMap();
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM " + tabella +" WHERE email = ?");
            prepareStatement.setString(1, email);
            ResultSet executeQuery = prepareStatement.executeQuery();
            executeQuery.last();
            
            if(executeQuery.getRow() > 0) {
                result.put("Email", executeQuery.getString("email"));
                result.put("Petto_Iniziale", executeQuery.getString("petto_iniz"));
                result.put("Bicipite_Iniziale", executeQuery.getString("bicipite_iniz"));
                result.put("Avambraccio_Iniziale", executeQuery.getString("avambraccio_iniz"));
                result.put("Cosce_Iniziale", executeQuery.getString("cosce_iniz"));
                result.put("Polpacci_Iniziale", executeQuery.getString("polpacci_iniz"));
                result.put("Petto_Intermedio", executeQuery.getString("petto_inter"));
                result.put("Bicipite_Intermedio", executeQuery.getString("bicipite_inter"));
                result.put("Avambraccio_Intermedio", executeQuery.getString("avambraccio_inter"));
                result.put("Cosce_Intermedio", executeQuery.getString("cosce_inter"));
                result.put("Polpacci_Intermedio", executeQuery.getString("polpacci_inter"));
                result.put("Petto_Finale", executeQuery.getString("petto_final"));
                result.put("Bicipite_Finale", executeQuery.getString("bicipite_final"));
                result.put("Avambraccio_Finale", executeQuery.getString("avambraccio_final"));
                result.put("Cosce_Finale", executeQuery.getString("cosce_final"));
                result.put("Polpacci_Finale", executeQuery.getString("polpacci_final"));
            }
        } catch(SQLException e) {
            System.out.println("Dati Scritti sul file misure.save in modo sbagliato!");
        }
        return result;
    }
    
//************************************************************************************************************************************************************************************************************************
//                              CONSULTAZIONE
//************************************************************************************************************************************************************************************************************************
    
    //METODO USATO NELLA DASHBOARD ADMIN PER MOSTRARE TUTTI I MEDICI E TRAINER REGISTRATI (TAB:MEDICI E TAB1: TRAINER)
    public ArrayList visualizzaMediciTrainer(String tabella){
        
        ArrayList<String> lista = new ArrayList<String>();
        
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT email,nome,cognome FROM " + tabella +" ");
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                String email = rs.getString(1);
                String nome = rs.getString(2);
                String cognome = rs.getString(3);
                lista.add(email);
                lista.add(nome);
                lista.add(cognome);
            }
          
            
        } catch(SQLException e) {
            System.out.println("Impossibile prelevare i medici!");
        }
        return lista;
    }
    
    
    public boolean utenteInvia(Map dati){
        
        boolean risultato=true;
        
        try {                                                         
            
            String coach = (String) dati.get("coach");
            PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO consultazione(utente,"+coach+",categoria,domanda) VALUES (?,?,?,?)");
            prepareStatement.setString(1, (String) dati.get("utente"));
            prepareStatement.setString(2, (String) dati.get("emailMedicoTrainer"));
            prepareStatement.setString(3, (String) dati.get("categoria"));
            prepareStatement.setString(4, (String) dati.get("domanda"));
            prepareStatement.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println("Impossibile una domanda " + e);
            risultato=false;
        }
        return risultato;
    }
    
    //METODO USATO NELLA DASHBOARD ADMIN PER MOSTRARE TUTTE LE RISPOSTE
    public ArrayList visualizzaRisposte(String coach, String tabella, String utente){
        
        ArrayList<String> lista = new ArrayList<String>();
        
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT id,"+coach+",categoria,domanda,risposta,voto FROM " + tabella +" WHERE utente = '"+ utente +"' AND "+ coach+" is not null ");
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String dottore = rs.getString(2);
                String categoria = rs.getString(3);
                String domanda = rs.getString(4);
                String risposta = rs.getString(5);
                String voto = rs.getString(6);
                
                lista.add(id);
                lista.add(dottore);
                lista.add(categoria);
                lista.add(domanda);
                lista.add(risposta);
                lista.add(voto);
            }
          
            
        } catch(SQLException e) {
            System.out.println("Impossibile prelevare le risposte!");
        }
        return lista;
    }
    
    public boolean inviaValutazione(Map dati){
        
        boolean risultato=true;
        
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("UPDATE consultazione SET voto= ? WHERE id=?");
            prepareStatement.setString(1, (String) dati.get("valutazione"));
            prepareStatement.setString(2, (String) dati.get("id"));
           
            prepareStatement.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println("Impossibile una domanda " + e);
            risultato=false;
        }
        return risultato;
    }
    
    //METODO USATO PER IL MEDICO E IL TRAINER PER VISUALIZZARE LE DOMANDE PROPOSTE
    public ArrayList visualizzaDomande(String tabella, String persona, String coach){
        
        ArrayList<String> lista = new ArrayList<String>();
        
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT id,utente,categoria,domanda,risposta,voto FROM " + tabella +" WHERE " + coach + "= '"+ persona+"' ");
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String utente = rs.getString(2);
                String categoria = rs.getString(3);
                String domanda = rs.getString(4);
                String risposta =rs.getString(5);
                String voto = rs.getString(6);
                lista.add(id );
                lista.add(utente);
                lista.add(categoria);
                lista.add(domanda );
                lista.add(risposta);
                lista.add(voto);
            }
          
            
        } catch(SQLException e) {
            System.out.println("Impossibile prelevare le domande!");
        }
        return lista;
    }
    
    public boolean inviaRisposta(Map dati){
        
        boolean risultato=true;
        
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("UPDATE consultazione SET risposta= ? WHERE id=?");
            prepareStatement.setString(1, (String) dati.get("risposta"));
            prepareStatement.setString(2, (String) dati.get("id"));
           
            prepareStatement.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println("Impossibile rispondere a questa domanda!" + e);
            risultato=false;
        }
        return risultato;
    }
  
    
    public float mediaVoti(String email, String tabella, String coach) {
        float i = 0;
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT AVG(voto) FROM " + tabella + " WHERE "+ coach +" = '"+ email+"' ");
            
            ResultSet executeQuery = prepareStatement.executeQuery();
            
            if(executeQuery.next()) {
                i = executeQuery.getFloat(1);
            }
           
        } catch(SQLException e) {
            System.out.println("Non è stato possibile fare la media. " + e);
        }
        return i;
    }
    
    
    
//************************************************************************************************************************************************************************************************************************
//                            RECENSIONI
//************************************************************************************************************************************************************************************************************************
  
          
    public boolean inviaRecensione(String email, String voto, String tabella){

        boolean risultato=true;
        float votoAttuale = 0;
        String votofinale ="";

        try {
            PreparedStatement prep = conn.prepareStatement("SELECT voto FROM " + tabella + " WHERE email = '"+ email+"' ");
            
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                votoAttuale = rs.getFloat(1);
            }
            
            Float votoinserito = Float.parseFloat(voto);
            if (votoAttuale >= 0 ) {
                if (votoAttuale == 0) {
                    votofinale = Float.toString(votoinserito);
                }else{
                    votofinale = Float.toString(((votoAttuale + votoinserito)/2));
                }
            }
            
            PreparedStatement prepareStatement = conn.prepareStatement("UPDATE "+ tabella+ " SET voto= " + votofinale + " WHERE email='" + email + "'");

            prepareStatement.executeUpdate();

        } catch(SQLException e) {
            System.out.println("Impossibile recensire questo medico!" + e);
            risultato=false;
        }
        return risultato;
    }    
          
    public float prelevaMediaVoto(String email, String tabella) {
        float i = 0;
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT voto FROM " + tabella + " WHERE email = '"+ email+"' ");
            
            ResultSet executeQuery = prepareStatement.executeQuery();
            
            if(executeQuery.next()) {
                i = executeQuery.getFloat(1);
            }
           
        } catch(SQLException e) {
            System.out.println("Non è stato possibile prelevare la media del medico e/o trainer. " + e);
        }
        return i;
    }
         
    
   
          
//************************************************************************************************************************************************************************************************************************
//                            FINE  RECENSIONI
//************************************************************************************************************************************************************************************************************************
    
//************************************************************************************************************************************************************************************************************************
//                            DIARIO
//************************************************************************************************************************************************************************************************************************
     
    public boolean inputUtenteTrainer(String tabella, String email, String tipo,String parte_corpo, String giorni, String mattina, String pomeriggio, String sera, String kcal, String emailtrainer, String fabbisogno){
        
        boolean risultato=true;
        try {                                                         
            //INSERISCI MISURE PETTO,BICIPITI, .....  
            PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO "+tabella +"(utente, tipo, parte_corpo, giorni, mattina, pomeriggio, sera, calorie,trainer, fabbisogno) VALUES (?,?,?,?,?,?,?,?,?,?)");
            prepareStatement.setString(1, email);
            prepareStatement.setString(2, tipo);
            prepareStatement.setString(3, parte_corpo);
            prepareStatement.setString(4, giorni);
            prepareStatement.setString(5, mattina);            
            prepareStatement.setString(6, pomeriggio);
            prepareStatement.setString(7, sera);
            prepareStatement.setString(8, kcal);
            prepareStatement.setString(9, emailtrainer);
            prepareStatement.setString(10, fabbisogno);
            prepareStatement.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println("Impossibile inviare input Utente to Trainer " + e);
            risultato=false;
        }
        return risultato;
    }
    
    
    //METODO USATO PER IL MEDICO PER VISUALIZZARE LE DOMANDE PROPOSTE
    public Map prelevaCorsi(){
                        
        int i = 1;
        Map dati = new HashMap();
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT nome FROM esercizicorso");
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                dati.put(""+i, rs.getString(1));
                i++;
            }
            
        } catch(SQLException e) {
            System.out.println("Impossibile prelevare i nomi dei corsi!");
        }
        return dati;
    }
    
     //METODO USATO PER IL MEDICO PER VISUALIZZARE LE DOMANDE PROPOSTE
    public Map prelevaTrainer(){
                        
        int i = 1;
        Map dati = new HashMap();
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT email,nome,cognome FROM trainer");
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                dati.put("email_"+i, rs.getString(1));
                dati.put("nome_"+i, rs.getString(2));
                dati.put("cognome_"+i, rs.getString(3));
                i++;
            }
            
        } catch(SQLException e) {
            System.out.println("Impossibile prelevare le email dei triner    "+ e);
        }
        return dati;
    }
    
    //METODO USATO NELLA DASHBOARD ADMIN PER MOSTRARE TUTTI I MEDICI E TRAINER REGISTRATI (TAB:MEDICI E TAB1: TRAINER)
    public Map visualizzaRigheTrainer(String tabella,String email){
        
        Map result = new HashMap();
        int i=1;
        try {                                                                                       
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT utente,tipo,parte_corpo,giorni,mattina,pomeriggio,sera,calorie,fabbisogno FROM " + tabella +" WHERE trainer='" + email +"'");
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                String utente = rs.getString(1);
                String tipo = rs.getString(2);
                String parte_corpo = rs.getString(3);
                String giorni = rs.getString(4);
                String mattina = rs.getString(5);
                String pomeriggio = rs.getString(6);
                String sera = rs.getString(7);
                String calorie = rs.getString(8);
                String fabbisogno = rs.getString(9);
                
                result.put("utente"+i,utente );
                result.put("tipo"+i,tipo );
                result.put("parte_corpo"+i, parte_corpo);
                result.put("giorni"+i, giorni);
                result.put("mattina"+i, mattina);
                result.put("pomeriggio"+i,pomeriggio );
                result.put("sera"+i,sera );
                result.put("calorie"+i,calorie );
                result.put("fabbisogno"+i, fabbisogno);
                i++;
             
            }
                      
        } catch(SQLException e) {
            System.out.println("Dati diario per trainer non pervenuti   " + e);
        }
        return result;
    }
    
    public Map prelevaPeso(String email){
        
        Map dati = new HashMap();
    
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT peso FROM utente WHERE email='" + email + "'");       
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                String peso = rs.getString(1);
                dati.put("peso", peso);
            }
            
        } catch(SQLException e) {
            System.out.println("Impossibile prelevare il peso dell'utente    "+ e);
        }
        return dati;
    }
    
    public Map ottieniEmail(String nomecorso){
        
        Map dati = new HashMap();
    
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT trainer FROM esercizicorso WHERE nome='" + nomecorso + "'");       
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                String email = rs.getString(1);
                
                dati.put("email", email);
            }
            
            
        } catch(SQLException e) {
            System.out.println("Impossibile prelevare il peso dell'utente    "+ e);
        }
        return dati;
    }
    
    
    //METODO USATO PRELEVARE GLI ESERCIZI DAL DB PER POI SCRIVERE IL FILE ESERCIZICORSO/ESERCIZI.XML  (TAB: ESERCIZICORSO)
    public Map prendiEserciziCorso(){
        
        Map dati = new HashMap();
        int i = 1;
        String[] undici;
        String[] dodici;
        String[] tredici;
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM esercizicorso");
            ResultSet rs = prepareStatement.executeQuery();
            
            while (rs.next()) {
                
                String nome = rs.getString(2);
                String[] uno =  rs.getString(4).split(",");
                String[] due =  rs.getString(5).split(",");
                String[] tre =  rs.getString(6).split(",");
                String[] quattro =  rs.getString(7).split(",");
                String[] cinque =  rs.getString(8).split(",");
                String[] sei =  rs.getString(9).split(",");
                String[] sette =  rs.getString(10).split(",");
                String[] otto =  rs.getString(11).split(",");
                String[] nove =  rs.getString(12).split(",");
                String[] dieci =  rs.getString(13).split(",");
                
                
                if ( ((String)rs.getString(14)) == null) {
                    
                }else{
                    undici = rs.getString(14).split(",");
                    dati.put(nome+"_"+ 11, undici[0]);
                    dati.put(nome+"_"+ 11 + "_met", undici[1]);
                    dati.put(nome+"_"+ 11 + "_rep", undici[2]);
                }
                if (((String)rs.getString(15)) == null) {
                    
                }else{
                    dodici = rs.getString(15).split(",");
                    dati.put(nome+"_"+ 12, dodici[0]);
                    dati.put(nome+"_"+ 12 + "_met", dodici[1]);
                    dati.put(nome+"_"+ 12 + "_rep", dodici[2]);
                }
                if (((String)rs.getString(16)) == null) {
                    
                }else{
                    tredici = rs.getString(16).split(",");
                    dati.put(nome+"_"+ 13, tredici[0]);
                    dati.put(nome+"_"+ 13 + "_met", tredici[1]);
                    dati.put(nome+"_"+ 13 + "_rep", tredici[2]);
                }

                dati.put(nome+"_"+ 1, uno[0]);
                dati.put(nome+"_"+ 1 + "_met", uno[1]);
                dati.put(nome+"_"+ 1 + "_rep", uno[2]);
                dati.put(nome+"_"+ 2, due[0]);
                dati.put(nome+"_"+ 2 + "_met", due[1]);
                dati.put(nome+"_"+ 2 + "_rep", due[2]);
                dati.put(nome+"_"+ 3, tre[0]);
                dati.put(nome+"_"+ 3 + "_met", tre[1]);
                dati.put(nome+"_"+ 3 + "_rep", tre[2]);
                dati.put(nome+"_"+ 4, quattro[0]);
                dati.put(nome+"_"+ 4 + "_met", quattro[1]);
                dati.put(nome+"_"+ 4 + "_rep", quattro[2]);
                dati.put(nome+"_"+ 5, cinque[0]);
                dati.put(nome+"_"+ 5 + "_met", cinque[1]);
                dati.put(nome+"_"+ 5 + "_rep", cinque[2]);
                dati.put(nome+"_"+ 6, sei[0]);
                dati.put(nome+"_"+ 6 + "_met", sei[1]);
                dati.put(nome+"_"+ 6 + "_rep", sei[2]);
                dati.put(nome+"_"+ 7, sette[0]);
                dati.put(nome+"_"+ 7 + "_met", sette[1]);
                dati.put(nome+"_"+ 7 + "_rep", sette[2]);
                dati.put(nome+"_"+ 8, otto[0]);
                dati.put(nome+"_"+ 8 + "_met", otto[1]);
                dati.put(nome+"_"+ 8 + "_rep", otto[2]);
                dati.put(nome+"_"+ 9, nove[0]);
                dati.put(nome+"_"+ 9 + "_met", nove[1]);
                dati.put(nome+"_"+ 9 + "_rep", nove[2]);
                dati.put(nome+"_"+ 10, dieci[0]);
                dati.put(nome+"_"+ 10 + "_met", dieci[1]);
                dati.put(nome+"_"+ 10 + "_rep", dieci[2]);
            }
            
            
        } catch(SQLException e) {
            System.out.println("Dati eserciziCorso prelevati in modo sbagliato  " + e);
        }
        return dati;
    }
    
    //METODO USATO PRELEVARE GLI ESERCIZI DAL DB PER POI SCRIVERE IL FILE ESERCIZISCHEDA/ESERCIZI.XML  (TAB: ESERCIZISCHEDA)
    public Map prendiEserciziScheda(){
        
        Map dati = new HashMap();
        int i=1;
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM esercizischeda");
            ResultSet rs = prepareStatement.executeQuery();
            
            while (rs.next()) {
               
                String parte = rs.getString(2);
                String nome = rs.getString(3);
                String met = rs.getString(4);
                String rep = rs.getString(5);
                
                
                
                if (i<6) {
                    dati.put(parte+"_"+i, nome);
                    dati.put(parte+"_"+i+"_met", met);
                    dati.put(parte+"_"+i+"_rep", rep);
                }else{
                    i=1;
                    dati.put(parte+"_"+i, nome);
                    dati.put(parte+"_"+i+"_met", met);
                    dati.put(parte+"_"+i+"_rep", rep);
                }
                
                
                i++;
            }
            
        } catch(SQLException e) {
            System.out.println("Dati Scritti sul file .save in modo sbagliato!");
        }
        return dati;
    }
    
    public boolean insertdb(String email,String tipo, String giornoSettimana,String tutto, String fabbisogno){
        
        int i = 0;
        boolean risultato = false;
        try {
            PreparedStatement prep = conn.prepareStatement("SELECT data FROM esercizi WHERE data > DATE_SUB(NOW(), INTERVAL '1' HOUR) and email = '"+ email+"' and tipo='" + tipo + "'");
            
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                i +=1;
            }
            if (i>0){
                PreparedStatement prepareStatement = conn.prepareStatement("UPDATE esercizi SET " +  giornoSettimana + " = '" + tutto + "' WHERE email='" + email + "' and tipo='" + tipo + "' and data = (select data from esercizi WHERE data > DATE_SUB(NOW(), INTERVAL '1' HOUR) and tipo='" + tipo + "') ");
                prepareStatement.executeUpdate();
            }else if(i ==0){
                PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO esercizi (email,tipo, "+ giornoSettimana +", fabbisogno) VALUES ('"+ email +"' ,'"+ tipo +"' , '" + tutto +"', '" + fabbisogno +"')");
                prepareStatement.executeUpdate();
            }
            risultato = true;
        } catch(SQLException e) {
            System.out.println("Impossibile inserire esercizi    " + e);
            risultato = false;
        }
        return risultato;
    }
    
    
    
            
    public Map trovaEsercizi(String nomeEsercizio){
        
        Map dati = new HashMap();
        int i = 0;
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT nome from esercizischeda where parte = (SELECT parte FROM `esercizischeda` WHERE nome = '"+nomeEsercizio+"') and NOT nome= '"+nomeEsercizio+"'");
            ResultSet rs = prepareStatement.executeQuery();
            
            while (rs.next()) {
                String nome = rs.getString(1);
                dati.put(""+i, nome);
                i++;
            }
            
        } catch(SQLException e) {
            System.out.println("Dati Scritti sul file .save in modo sbagliato!");
        }
        
        
        return dati;
    }
    
    public Map trovaRepMin(String nomeEsercizio){
        
        Map dati = new HashMap();
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT met,rep from esercizischeda WHERE nome = '"+nomeEsercizio+"'");
            ResultSet rs = prepareStatement.executeQuery();
            
            while (rs.next()) {
                String met = rs.getString(1);
                String rep = rs.getString(2);
                dati.put("Met", met);
                dati.put("Rep", rep);
            }
            
        } catch(SQLException e) {
            System.out.println("Dati Scritti sul file .save in modo sbagliato!");
        }
        
        return dati;
    }
    
    public void eliminaQuery(String utente, String tipo, String partiCorpo, String trainer, String calorie){
        try {
            
            PreparedStatement prep1 = conn.prepareStatement("DELETE from `diario`  WHERE utente = '"+utente+"' and tipo = '"+tipo+"' and parte_corpo = '"+partiCorpo+"' and calorie = '"+calorie+"'");
            prep1.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println("Impossibile emilinare account: " + e);
        }
    }
    
        
//************************************************************************************************************************************************************************************************************************
//                            FINE DIARIO
//************************************************************************************************************************************************************************************************************************

//************************************************************************************************************************************************************************************************************************
//                            VISUALIZZA SCHEDA UTENTE
//************************************************************************************************************************************************************************************************************************
       
    //METODO USATO NELLA DASHBOARD ADMIN PER MOSTRARE TUTTI I MEDICI E TRAINER REGISTRATI (TAB:MEDICI E TAB1: TRAINER)
    public Map visualizzaRigheScheda(String email){
        
        Map result = new HashMap();
        int i=1;
        try {                                                                                       
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT id,email,tipo,Lunedi,Martedi,Mercoledi,Giovedi,Venerdi,Sabato,Domenica, data,fabbisogno FROM esercizi WHERE email='" + email +"'");
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String nome = rs.getString(2);
                String tipo = rs.getString(3);
                String lunedi = rs.getString(4);
                String martedi = rs.getString(5);
                String mercoledi = rs.getString(6);
                String giovedi = rs.getString(7);
                String venerdi = rs.getString(8);
                String sabato = rs.getString(9);
                String domenica = rs.getString(10);
                String data = rs.getString(11);
                String fabbisogno = rs.getString(12);
                
                result.put("id"+i, id);
                result.put("nome"+i,nome );
                result.put("tipo"+i, tipo);
                result.put("lunedi"+i, lunedi);
                result.put("martedi"+i, martedi);
                result.put("mercoledi"+i,mercoledi );
                result.put("giovedi"+i,giovedi );
                result.put("venerdi"+i,venerdi );
                result.put("sabato"+i, sabato);
                result.put("domenica"+i,domenica );
                result.put("data"+i,data );
                result.put("fabbisogno"+i, fabbisogno);
                
                
                i++;
            }
            
        } catch(SQLException e) {
            System.out.println("Dati da mostrare in ScegliVisualizza non prelevati correttamente   " + e);
        }
        return result;
    }
    
    public Map dammiScheda(String id){

        Map result = new HashMap();
        try {
            PreparedStatement prepareStatement = conn.prepareStatement("SELECT email,tipo,Lunedi,Martedi,Mercoledi,Giovedi,Venerdi,Sabato,Domenica,data,fabbisogno FROM esercizi WHERE id='" + id + "'");
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                //String id = rs.getString(1);
                String nome = rs.getString(1);
                String tipo = rs.getString(2);
                String lunedi = rs.getString(3);
                String martedi = rs.getString(4);
                String mercoledi = rs.getString(5);
                String giovedi = rs.getString(6);
                String venerdi = rs.getString(7);
                String sabato = rs.getString(8);
                String domenica = rs.getString(9);
                String data = rs.getString(10);
                String fabbisogno = rs.getString(11);

                //result.put("id", id);
                result.put("nome",nome );
                result.put("tipo", tipo);
                result.put("lunedi", lunedi);
                result.put("martedi", martedi);
                result.put("mercoledi",mercoledi );
                result.put("giovedi",giovedi );
                result.put("venerdi",venerdi );
                result.put("sabato", sabato);
                result.put("domenica",domenica );
                result.put("data",data );
                result.put("fabbisogno", fabbisogno);

            }

        } catch(SQLException e) {
            System.out.println("Dati da mostrare in dammiScheda non prelevati correttamente   " + e);
        }
        return result;
    }
    
    
    public void eliminaScheda(String id){
        try {
            
            PreparedStatement prep = conn.prepareStatement("DELETE from `esercizi`  WHERE id ='"+ id + "'");
            prep.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println("Impossibile emilinare scheda di allenamento: " + e);
        }
        
    }
    
    
//************************************************************************************************************************************************************************************************************************
//                            FINE VISUALIZZA SCHEDA UTENTE
//************************************************************************************************************************************************************************************************************************
      
//************************************************************************************************************************************************************************************************************************
//                            GESTIONE CORSI
//************************************************************************************************************************************************************************************************************************
    public Map visualizzaCorsi (){
        Map result = new HashMap();
        int i = 0;
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(" SELECT nome, trainer FROM esercizicorso ");
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {

                result.put("Nome" +i, rs.getString(1));
                result.put("Trainer" +i, rs.getString(2));

                i++;
            }
        } catch(SQLException e) {
            System.out.println("Impossibile prelevare il nome dei corsi !   "  + e);
        }
        return result;
    }
    public Map prelevaEsercizi (String nomecorso){
        Map result = new HashMap();
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(" SELECT `1`,`2`,`3`,`4`,`5`,`6`,`7`,`8`,`9`,`10`,`11`,`12`,`13` FROM esercizicorso WHERE nome = '"+nomecorso+"' ");
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {

                result.put("1", rs.getString(1));
                result.put("2", rs.getString(2));
                result.put("3", rs.getString(3));
                result.put("4", rs.getString(4));
                result.put("5", rs.getString(5));
                result.put("6", rs.getString(6));
                result.put("7", rs.getString(7));
                result.put("8", rs.getString(8));
                result.put("9", rs.getString(9));
                result.put("10", rs.getString(10));
                result.put("11", rs.getString(11));
                result.put("12", rs.getString(12));
                result.put("13", rs.getString(13));
            }
            
        } catch(SQLException e) {
            System.out.println("Impossibile prelevare il nome dei corsi !   "  + e);
        }
        return result;
    }
    
    // METODO PER L'INSERIMENTO DI UN NUOVO CORSO CON TUTTI E 10 GLI ESERCIZI
    public void inseriscicorso(Map dati){
        try {
            //INSERISCI I VALORI DEL CORSO NELLA  TABELLA esercizicorso
            PreparedStatement prep = conn.prepareStatement("INSERT INTO esercizicorso (nome,trainer,`1`,`2`,`3`,`4`,`5`,`6`,`7`,`8`,`9`,`10`)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            prep.setString(1, (String) dati.get("nomecorso"));
            prep.setString(2, (String) dati.get("nometrainer"));
            prep.setString(3, (String) dati.get("ese1"));
            prep.setString(4, (String) dati.get("ese2"));
            prep.setString(5, (String) dati.get("ese3"));
            prep.setString(6, (String) dati.get("ese4"));
            prep.setString(7, (String) dati.get("ese5"));
            prep.setString(8, (String) dati.get("ese6"));
            prep.setString(9, (String) dati.get("ese7"));
            prep.setString(10, (String) dati.get("ese8"));
            prep.setString(11, (String) dati.get("ese9"));
            prep.setString(12, (String) dati.get("ese10"));
            prep.executeUpdate();
            
        } catch(SQLException e) {
            System.out.println("Impossibile inserire valori corso: " + e);
        }
    }
    
    
    public boolean aggiornaEsercizi(String nomecorso, String ese1, String ese2, String ese3, String ese4, String ese5, String ese6, String ese7, String ese8, String ese9, String ese10, String ese11, String ese12, String ese13){
        
        boolean risultato = false;
        try {
            if (ese11.equals("") && ese12.equals("") && ese13.equals("")  ) {
                PreparedStatement prepareStatement = conn.prepareStatement("UPDATE esercizicorso SET `1`='"+ese1+"',`2`='"+ese2+"',`3`='"+ese3+"',`4`='"+ese4+"',`5`='"+ese5+"',`6`='"+ese6+"',`7`='"+ese7+"',`8`='"+ese8+"',`9`='"+ese9+"',`10`='"+ese10+"'  WHERE nome='"+nomecorso+"'");
                prepareStatement.executeUpdate();
                risultato = true;
            }else if (!ese11.equals("") && ese12.equals("") && ese13.equals("")) {
                PreparedStatement prepareStatement = conn.prepareStatement("UPDATE esercizicorso SET `1`='"+ese1+"',`2`='"+ese2+"',`3`='"+ese3+"',`4`='"+ese4+"',`5`='"+ese5+"',`6`='"+ese6+"',`7`='"+ese7+"',`8`='"+ese8+"',`9`='"+ese9+"',`10`='"+ese10+"',`11`='"+ese11+"'  WHERE nome='"+nomecorso+"'");
                prepareStatement.executeUpdate();
                risultato = true;
            }else if(!ese11.equals("") && !ese12.equals("") && ese13.equals("") ) {
                PreparedStatement prepareStatement = conn.prepareStatement("UPDATE esercizicorso SET `1`='"+ese1+"',`2`='"+ese2+"',`3`='"+ese3+"',`4`='"+ese4+"',`5`='"+ese5+"',`6`='"+ese6+"',`7`='"+ese7+"',`8`='"+ese8+"',`9`='"+ese9+"',`10`='"+ese10+"',`11`='"+ese11+"',`12`='"+ese12+"'  WHERE nome='"+nomecorso+"'");
                prepareStatement.executeUpdate();
                risultato = true;
            }else{
                PreparedStatement prepareStatement = conn.prepareStatement("UPDATE esercizicorso SET `1`='"+ese1+"',`2`='"+ese2+"',`3`='"+ese3+"',`4`='"+ese4+"',`5`='"+ese5+"',`6`='"+ese6+"',`7`='"+ese7+"',`8`='"+ese8+"',`9`='"+ese9+"',`10`='"+ese10+"',`11`='"+ese11+"',`12`='"+ese12+"',`13`='"+ese13+"'  WHERE nome='"+nomecorso+"'");
                prepareStatement.executeUpdate();
                risultato = true;
            }
            
        } catch(SQLException e) {
            System.out.println("Impossibile aggiornare esercizi    " + e);
            risultato = false;
        }
        return risultato;
    }
    
    public boolean eliminaCorso(String nomecorso){
        int i=0;
        boolean risultato = false;
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(" SELECT id FROM esercizicorso WHERE nome='"+nomecorso+"'  ");
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                i+=1;
            }
            if (i != 0) {
                PreparedStatement prep1 = conn.prepareStatement("DELETE from `esercizicorso`  WHERE nome = '"+nomecorso+"' ");
                prep1.executeUpdate();
                risultato = true;
            }else{
                risultato = false;
            }
            
        } catch(SQLException e) {
            System.out.println("Impossibile eliminare il corso    " + e);
            risultato = false;
        }
        return risultato;
    }
    
    
//************************************************************************************************************************************************************************************************************************
//                            FINE GESTIONE CORSI
//************************************************************************************************************************************************************************************************************************
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Connection getConnection()  {
         
        dataSource.setServerName(this.indirizzo);
        dataSource.setUser(this.username);
        dataSource.setPassword(this.password);
        dataSource.setDatabaseName(this.db);
        dataSource.setPortNumber(this.porta);
        
        try {
            conn = dataSource.getConnection();
            return conn;
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        return null;
    }
    
        /**
     * @return the dataSource
     */
    public MysqlDataSource getDatasource() {
        return dataSource;
    }

    /**
     * @param dataSource the dataSource to set
     */
    public void setDatasource(MysqlDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @return the st
     */
    public Statement getSt() {
        return st;
    }

    /**
     * @param st the st to set
     */
    public void setSt(Statement st) {
        this.st = st;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
