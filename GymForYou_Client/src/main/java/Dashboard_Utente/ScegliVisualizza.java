
package Dashboard_Utente;

import Autenticazione.Utente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ScegliVisualizza extends javax.swing.JFrame {

    private String id;
    //private Map dati;
    private Utente utente;
            
    public ScegliVisualizza() {
        initComponents();
        ImageIcon icon = new ImageIcon("src/main/resources/imageicon.png");
        setIconImage(icon.getImage());
        setTitle("GYM FOR YOU");
        //utente = new Utente();
        //this.dati = dati = utente.visualizzaRighe();
        visualizzaRighe();

    }
    
    private void visualizzaRighe(){
        Map dati = new HashMap();
        utente = new Utente();
        dati = utente.visualizzaRighe();
        //METODO PER GESTIRE LA TABELLA
        DefaultTableModel Df = (DefaultTableModel)jTable1.getModel();
        Df.setRowCount(0);
        //INIZIALIZZO L'HASHMAP CONTENTE L'ID, IL TIPO DI SCHED E LA DATA DI CREAZIONE DELLA SCHEDA
        //CICLA I DATI CONTENTUTI NELL'HASHMAP
        for (int j=1; j<(dati.size()/12)+1; j++) {                   
           Vector v2 = new Vector();
           //CREA UNA VETTORE PER CIASCUN TRAINER E MEDICO
           for (int i = 1; i <= dati.size(); i++) {
                //AGGIUNGE L'EMAIL AL VETTORE
                v2.add(dati.get("id"+(j)));
                //AGGIUNGE TIPO AL VETTORE
                v2.add(dati.get("tipo"+(j)));
                //AGGIUNGE PARTE DEL CORPO AL VETTORE
                v2.add(dati.get("data"+(j)));
           }     
           //AGGIUNGE LA RIGA ALLA TABELLA CONENTE IL VETTORE SOPRA
           Df.addRow(v2);
        } 
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        eliminabutton = new javax.swing.JButton();
        visualizzabutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(155, 17, 30));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SCEGLI SCHEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 3, 18), new java.awt.Color(255, 255, 102))); // NOI18N

        jTable1.setBackground(new java.awt.Color(255, 255, 102));
        jTable1.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tipo allenamento", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(40);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indietro1.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        eliminabutton.setBackground(new java.awt.Color(255, 255, 102));
        eliminabutton.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        eliminabutton.setText("ELIMINA");
        eliminabutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminabutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminabuttonMouseClicked(evt);
            }
        });

        visualizzabutton.setBackground(new java.awt.Color(255, 255, 102));
        visualizzabutton.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        visualizzabutton.setText("VISUALIZZA");
        visualizzabutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        visualizzabutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visualizzabuttonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(eliminabutton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(visualizzabutton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eliminabutton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(visualizzabutton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        // EVENTO CLICK JTABLE
        DefaultTableModel Df = (DefaultTableModel)jTable1.getModel();
        //INDICE DELLA RIGA DELLA TABELLA
        int selectIndex = jTable1.getSelectedRow();
        id = Df.getValueAt(selectIndex,0).toString();
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void visualizzabuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visualizzabuttonMouseClicked
        // TODO add your handling code here:
        Map dati = new HashMap();
        utente = new Utente();
        dati = utente.dammiScheda(id);
        String[] giorni = {"Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi","Sabato", "Domenica"};  
        List<String> giorniSettimana = new ArrayList<>(); //giorni settimana [M(Piegamenti in ginocchio,2.0,Push up and rotate,2.0,Piegamenti in ginocchio,2.0,Hammer curl,2.0,Wrist curl,2.0)-S(Piegamenti in ginocchio,5.0,Wrist curl,5.0)-, null, null, null, null, null, null]
        
        for (String string : giorni) {
            giorniSettimana.add((String) dati.get(string.toLowerCase()));
        }
        
        int fabbisogno = (int) Double.parseDouble(((String) dati.get("fabbisogno")));
        
        List<String> esercizi = new ArrayList<>();
        List<String> ripetizioni = new ArrayList<>();
        
        List<Integer> array_momenti = new ArrayList<>();
        List<Object> contaEsercizi = new ArrayList<>();
        List<String> listaMomenti = new ArrayList<>();
        
        int conta = 0;
        String[] giorno;
        
        int numero = 0;
        String str="";
        
        for (int i = 0; i < giorniSettimana.size(); i++) {
            
            List<String> esercizio  = new ArrayList<>();
            List<String> ripetizone = new ArrayList<>();
            //CONTROLLO TUTTI GLI INDICI DELL'ARRAYLIST GIORNI SETTIMANA DOVE OGNI ELEMENTO E' UN GIORNO SE C'E' IL GIORNO VADO AVANTI NELL'IF
            if (!(giorniSettimana.get(i) == null)) {
                if (giorniSettimana.get(i).contains("M(")) {
                    for (int j = 0; j < 7; j++) {
                        if (i == j) {
                            listaMomenti.add(giorni[j] + " Mattina");//SE C'E' M SIGNIFICA MATTINA E LA METTIAMO NELLA LISTA MOMENTI
                        }
                    }
                    giorno = giorniSettimana.get(i).split("-");                     // [P(Press pulse al Petto,5.0,Hammer curl,5.0,Piegamenti in ginocchio,5.0)]
                    for (int j = 0; j < giorno.length; j++) {
                        if (giorno[j].contains("M(")) {
                            //PRENDIAMO IL CONTENUTO DELLE PARENTESI (GRAZIE A SUBSTRING) 
                            String[] eserRep = giorno[j].substring(giorno[j].indexOf("M(") + 2, giorno[j].indexOf(")")).split(","); //eserRep ={Press pulse al Petto,5.0,Hammer curl,5.0,Piegamenti in ginocchio,5.0}
                            for (int k = 0; k <eserRep.length; k=k+2) {
                                    //DIVIDIAMO GLI ESERCIZI DALLE RIPETIZIONI
                                    numero+=1;
                                    esercizio.add(eserRep[k]); //INSERIAMO GLI ESERCIZI DELLA MATTINA
                                    ripetizone.add(eserRep[k+1]);//INSERIAMO LE RIPETIZIONI DELLA MATTINA
                            }
                        }
                    }
                    conta+=1;
                }else{
                    listaMomenti.add("-");
                }
                str += numero+"-";
                numero=0;
                //**********FACCIAMO LE STESSE COSE DI SOPRA
                if (giorniSettimana.get(i).contains("P(")) {
                    for (int j = 0; j < 7; j++) {
                        if (i == j) {
                            listaMomenti.add(giorni[j] + " Pomeriggio");
                        }
                    }
                    giorno = giorniSettimana.get(i).split("-");                     // [P(Press pulse al Petto,5.0,Hammer curl,5.0,Piegamenti in ginocchio,5.0), S(eserciziiiiii)]
                    for (int j = 0; j < giorno.length; j++) {
                        if (giorno[j].contains("P(")) {
                            String[] eserRep = giorno[j].substring(giorno[j].indexOf("P(") + 2, giorno[j].indexOf(")")).split(",");
                            for (int k = 0; k <eserRep.length; k=k+2) {
                                numero+=1;
                                esercizio.add(eserRep[k]);
                                ripetizone.add(eserRep[k+1]);
                            }
                        }
                    }
                    conta+=1;
                }else{
                    listaMomenti.add("-");
                }
                str += numero+"-";
                numero=0;
                
                if (giorniSettimana.get(i).contains("S(")) {
                    for (int j = 0; j < 7; j++) {
                        if (i == j) {
                            listaMomenti.add(giorni[j] + " Sera");
                        }
                    }
                    giorno = giorniSettimana.get(i).split("-");                     // [P(Press pulse al Petto,5.0,Hammer curl,5.0,Piegamenti in ginocchio,5.0)]
                    for (int j = 0; j < giorno.length; j++) {
                        if (giorno[j].contains("S(")) {
                            String[] eserRep = giorno[j].substring(giorno[j].indexOf("S(") + 2, giorno[j].indexOf(")")).split(",");
                            for (int k = 0; k <eserRep.length; k=k+2) {
                                    numero+=1;
                                    esercizio.add(eserRep[k]);
                                    ripetizone.add(eserRep[k+1]);
                            }
                        }
                    }
                    conta+=1;
                }else{
                    listaMomenti.add("-");
                }
                str += numero;
                numero=0;
            }else{
                listaMomenti.add("-");
                listaMomenti.add("-");
                listaMomenti.add("-");

                str="0-0-0";
            }

            contaEsercizi.add(str);
            str="";
            array_momenti.add(conta);
            esercizi.addAll(esercizio); 
            ripetizioni.addAll(ripetizone);
            conta = 0;
            /*
            System.out.println("esercizi "+esercizi); esercizi [Spider man, V Up] esrcizi [Spider man, V Up, Salto alla corda, Pugni] IL PRIMO è SOLO LUNEDì IL SECONDO è LUNEDI + MARTEDI
            System.out.println("eserciziO " + esercizio);
            System.out.println("ripetizioni "+ripetizioni); [6.0, 6.0] [6.0, 6.0, 6.0, 6.0] IL PRIMO SONO LE RIPETIZIONI DI LUNEDI IL SECONDO DI LUNEDI + MARTEDI
            System.out.println("ripetizonE "+ ripetizone);
            */
        }
        //System.out.println("Giorni settimana "+ giorniSettimana);
        utente.creascheda(array_momenti,contaEsercizi,esercizi,ripetizioni,listaMomenti,fabbisogno);
        dispose();
    }//GEN-LAST:event_visualizzabuttonMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Pannello_Utente pannello = new Pannello_Utente();
        pannello.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void eliminabuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminabuttonMouseClicked
        // TODO add your handling code here:
        utente = new Utente();
        int dialogResult = JOptionPane.showConfirmDialog(null, "Desideri confermare?", "", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            utente.eliminaScheda(id);
            JOptionPane.showMessageDialog(null, "Eliminazione effettuata!", null, JOptionPane.INFORMATION_MESSAGE);
            dispose();
            ScegliVisualizza scegli = new ScegliVisualizza();
            scegli.setVisible(true);
        }
        
    }//GEN-LAST:event_eliminabuttonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ScegliVisualizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScegliVisualizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScegliVisualizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScegliVisualizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScegliVisualizza().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminabutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton visualizzabutton;
    // End of variables declaration//GEN-END:variables
}
