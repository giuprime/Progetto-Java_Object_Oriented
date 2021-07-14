/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Allenamento;

import Autenticazione.Trainer;
import Dashboard_Trainer.Pannello_Trainer;
import Impostazioni.Xml;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author giuse
 */
public class CreaScheda extends javax.swing.JFrame {
    
    private List<String> arrayGiorni;
    private List<String> giorniSettimana;
    private List<Object> partiOrdinate;
    private String email,tipo,parte_corpo,giorni,mattina,pomeriggio,sera,calorie,fabbisogno;
    private String[] inizialigiorni = new String[]{"L","M","W","G","V","S","D"};

    public CreaScheda() {
        initComponents();
        jTable1.setRowHeight(40);
        visualizzaRighe();
        ImageIcon icon = new ImageIcon("src/main/resources/imageicon.png");
        setIconImage(icon.getImage());
        setTitle("GYM FOR YOU");
    }
    
    private void visualizzaRighe(){
        
        Diario diario = new Diario();
        //METODO PER GESTIRE LA TABELLA
        DefaultTableModel Df = (DefaultTableModel)jTable1.getModel();
        Df.setRowCount(0);
        //INIZIALIZZO L'HASHMAP CONTENTE L'EMAIL, NOME E COGNOME DI OGNI TRAINER E MEDICO
        Map dati = diario.visualizzaRighe();
        //CICLA I TRAINER E I MEDICI CONTENTUTI NELL'HASHMAP
        for (int j=1; j<(dati.size()/9)+1; j++) {                   
           Vector v2 = new Vector();
           //CREA UNA VETTORE PER CIASCUN TRAINER E MEDICO
           for (int i = 1; i <= dati.size(); i++) {
                //AGGIUNGE L'EMAIL AL VETTORE
                v2.add(dati.get("utente"+(j)));
                //AGGIUNGE TIPO AL VETTORE
                v2.add(dati.get("tipo"+(j)));
                //AGGIUNGE PARTE DEL CORPO AL VETTORE
                String parte= (String) dati.get("parte_corpo"+(j));
                String pe="";
                String[] inizialiPartiCorpo = new String[]{"P", "B", "A", "C", "O"};
                String[] partiCorpo = new String[]{"Petto ", "Bicipiti ", "Avambracci ", "Cosce ", "Polpacci "};

                for(int k=0; k<inizialiPartiCorpo.length; k++){
                    if(parte.contains(inizialiPartiCorpo[k])){
                        pe+=partiCorpo[k];
                    }
                }
                v2.add(pe);
                //AGGIUNGE GIORNI AL VETTORE
                String giorni = (String)dati.get("giorni"+(j));
                String giorniOre = "";
                String[] day = new String[]{"Lunedi","Martedi","Mercoledi","Giovedi","Venerdi","Sabato","Domenica"};

                for(int h=0; h<inizialigiorni.length; h++){
                    if(giorni.contains(inizialigiorni[h])){
                        giorniOre+=day[h];
                        giorniOre+=" ";
                    }
                }
                v2.add(giorniOre);
                //AGGIUNGE MATTINA AL VETTORE               
                v2.add(algoritmo((String) dati.get("mattina"+(j))));
                //AGGIUNGE POMERIGGIO AL VETTORE
                v2.add(algoritmo((String)dati.get("pomeriggio"+(j))));
                //AGGIUNGE SERA AL VETTORE
                v2.add(algoritmo((String)dati.get("sera"+(j))));
                //AGGIUNGE KCAL AL VETTORE
                v2.add(dati.get("calorie"+(j)));
                //AGGIUNGE KCAL AL VETTORE
                v2.add(dati.get("fabbisogno"+(j)));
           }     
           //AGGIUNGE LA RIGA ALLA TABELLA CONENTE IL VETTORE SOPRA
           Df.addRow(v2);
        } 
    }
    
    
    private String algoritmo(String stringa){
        
        String valore="";
        String[] weekday = new String[]{"Lunedi (","Martedi (","Mercoledi (","Giovedi (","Venerdi (","Sabato (","Domenica ("};
        String[] inizialiIntensita = new String[]{"L", "M", "P"};
        String[] intensita = new String[]{"Leggero) ", "Medio) ", "Pesante) "};

        for(int k=0; k<stringa.length(); k=k+2){        //2
            String primoChar = Character.toString(stringa.charAt(k));
            for (int i = 0; i < inizialigiorni.length; i++) {   //7
                if(primoChar.equals(inizialigiorni[i])){
                    valore+= weekday[i];
                    for(int x=0; x<inizialiIntensita.length; x++){      //3
                        String secondoChar = Character.toString(stringa.charAt(k+1));
                        if(secondoChar.equals(inizialiIntensita[x])){
                            valore+= intensita[x];
                        }
                    }
                }
            }
        }
        
        return valore;
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(155, 17, 30));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CREA SCHEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 3, 18), new java.awt.Color(255, 255, 102))); // NOI18N

        jTable1.setBackground(new java.awt.Color(255, 255, 102));
        jTable1.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Email", "Tipo allenamento", "Parte del corpo", "Giorni", "Mattina", "Pomeriggio", "Sera", "Kcal da consumare", "Fabbisogno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setMinWidth(90);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(7).setMinWidth(80);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(8).setMinWidth(70);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(70);
        }

        jButton1.setBackground(new java.awt.Color(255, 255, 102));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton1.setText("CREA");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indietro1.png"))); // NOI18N
        jLabel1.setText("BACK");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(400, 400, 400))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        Pannello_Trainer trainer = new Pannello_Trainer();
        trainer.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // EVENTO CLICK JTABLE
        DefaultTableModel Df = (DefaultTableModel)jTable1.getModel();
        //INDICE DELLA RIGA DELLA TABELLA
        int selectIndex = jTable1.getSelectedRow();
        email = Df.getValueAt(selectIndex,0).toString();
        tipo = Df.getValueAt(selectIndex,1).toString();
        parte_corpo = Df.getValueAt(selectIndex,2).toString();
        giorni = Df.getValueAt(selectIndex,3).toString();
        mattina = Df.getValueAt(selectIndex,4).toString();
        pomeriggio = Df.getValueAt(selectIndex,5).toString();
        sera = Df.getValueAt(selectIndex,6).toString();
        calorie = Df.getValueAt(selectIndex,7).toString();
        fabbisogno = Df.getValueAt(selectIndex,8).toString();
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        // SERVE PER ELIMINARE LA QUERY NEL DB
        Trainer trn = new Trainer();
        //ciao = new Ciao();
        Map valori = new HashMap();
        valori.put("utente", email);
        valori.put("tipo", tipo);
        valori.put("parte_corpo", parte_corpo);
        valori.put("calorie", calorie);
        valori.put("trainer", trn.getEmail());
        valori.put("fabbisogno", fabbisogno);
        //---------------------------------------
        
        List<Object> tuttiGiorni = new ArrayList<>();
        List<Object> tuttiRepMin = new ArrayList<>();
        Xml xml = new Xml();
        if (null == tipo) {
            JOptionPane.showMessageDialog(null, "Selezionare una riga della tabella!", "Attenzione", JOptionPane.WARNING_MESSAGE);
        }else switch (tipo) {
            case "Scheda Personalizzata":
                xml.salvaEmailUtente(email,parte_corpo);
                SchedaPersonalizzata schedaPersonalizzata = new SchedaPersonalizzata();
                arrayGiorni = schedaPersonalizzata.calcoloOre(mattina, pomeriggio, sera, giorni, calorie);
                giorniSettimana = new ArrayList<>();
                arrayGiorni.forEach((n) -> giorniSettimana.add(n));
                partiOrdinate = schedaPersonalizzata.ordinaParti(parte_corpo);
                schedaPersonalizzata.creascheda(arrayGiorni,partiOrdinate,tipo,giorniSettimana,tuttiGiorni,tuttiRepMin,valori);
                dispose();
                break;
            default:
                xml.salvaEmailUtente(email,tipo);
                SchedaCorso schedaCorso = new SchedaCorso();
                arrayGiorni = schedaCorso.calcoloOre(mattina, pomeriggio, sera, giorni, calorie);
                giorniSettimana  = new ArrayList<>();
                arrayGiorni.forEach((n) -> giorniSettimana.add(n));
                partiOrdinate = schedaCorso.ordinaParti(parte_corpo);
                schedaCorso.creascheda(arrayGiorni,partiOrdinate,tipo,giorniSettimana,tuttiGiorni,tuttiRepMin,valori);
                dispose();
                break;
        }
    }//GEN-LAST:event_jButton1MouseClicked

    
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
            java.util.logging.Logger.getLogger(CreaScheda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreaScheda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreaScheda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreaScheda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CreaScheda().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
