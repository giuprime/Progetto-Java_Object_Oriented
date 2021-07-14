package Allenamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Uno extends javax.swing.JFrame {
    private CreaScheda creaScheda;
    private Diario diario;
    private SchedaPersonalizzata schedaPersonalizzata;
    private SchedaCorso schedaCorso;
    
    private int numeroMoments;
    private List<String> primomomento;
    private List<String> arraySenzaLunedi;
    private List<Integer> arraySenzaMomentoLunedi;
    private List<Object> partiOrdinate;
    private String tipo; 
    private List<Object> esercizi;
    private List<Object> repMin;
    private List<String> giorniSettimana;
    private List<Object> tuttiEsercizi;
    private List<Object> tuttiRepMin;
    private List<Object> listaMomenti;
    private int mod = 0;
    private Map valori;
    private int conferma = 0;
    
    public Uno(int numeroMoments,List<String> primomomento,List<String> arraySenzaLunedi,List<Integer> arraySenzaMomentoLunedi, List<Object> partiOrdinate, String tipo, List<String> giorniSettimana, List<Object> tuttiEsercizi, List<Object> tuttiRepMin, Map valori ) {                                 
        initComponents();
        ImageIcon icon = new ImageIcon("src/main/resources/imageicon.png");
        setIconImage(icon.getImage());
        setTitle("GYM FOR YOU");
        this.numeroMoments = numeroMoments;
        this.primomomento = primomomento;
        this.arraySenzaLunedi = arraySenzaLunedi;
        this.arraySenzaMomentoLunedi = arraySenzaMomentoLunedi;
        this.partiOrdinate = partiOrdinate;
        this.tipo = tipo;
        this.giorniSettimana = giorniSettimana;
        this.tuttiEsercizi = tuttiEsercizi;
        this.tuttiRepMin = tuttiRepMin;
        this.valori = valori;
        giornomom1.setText(primomomento.get(0));
        
        
        diario = new Diario();
        Map risultati = diario.calcoloCalorie(diario.esercizi(numeroMoments, primomomento, partiOrdinate,tipo));
        
        this.esercizi = esercizi = (List<Object>) risultati.get("Esercizi");
        this.repMin = repMin =  (List<Object>) risultati.get("RepMin");
        this.listaMomenti = listaMomenti = (List<Object>) risultati.get("ListaMomenti");
        
        if (Integer.valueOf((String)listaMomenti.get(1)) < 6) {
            jLabel1.setText("Min");
        }
      
        //***************************************************************************************************************************** PRIMO PANNELLO
        //  MOSTRA ESERCIZI NEL FRAME
        JLabel[] jtext = new JLabel[]{ ese1, ese2, ese3, ese4, ese5, ese6, ese7, ese8, ese9, ese10 };
        for (int i = 0; i < 10; i++) {
            jtext[i].setVisible(false);
        }
        for (int i = 0; i < esercizi.size(); i++) {
            jtext[i].setVisible(true);
            jtext[i].setText((String)esercizi.get(i));
        }
        //-----------------------------------------
        //  IMPOSTA A FALSE TUTTI I COMBO BOX
        JComboBox[] jcombo = new JComboBox[]{ combo1, combo2, combo3, combo4, combo5, combo6, combo7, combo8, combo9, combo10 };
        for (int i = 0; i < 10; i++) {
            jcombo[i].setVisible(false);
        }
        //-----------------------------------------
        //  MOSTRA RIPETIZIONI O MINUTI NEL FRAME
        JLabel[] jlabel = new JLabel[]{ rep1, rep2, rep3, rep4, rep5, rep6, rep7, rep8, rep9, rep10 };
        
        for (int i = 0; i < 10; i++) {
            jlabel[i].setVisible(false);
        }
        for (int i = 0; i < repMin.size(); i++) {
            jlabel[i].setVisible(true);
            jlabel[i].setText(String.valueOf(repMin.get(i)));
        }
        //-----------------------------------------
        //*******************************************************************************************************************************************************
        /*
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("LISTA momenti ******* = " + listaMomenti);
        System.out.println("Numero moments = " + numeroMoments);
        System.out.println("Primo momento = " + primomomento);
        System.out.println("array Senza Lunedi = " + arraySenzaLunedi);
        System.out.println("array Senza Momento Lunedi = " + arraySenzaMomentoLunedi);
        System.out.println("array Senza Lunedi = " + arraySenzaLunedi);
        System.out.println("parti Ordinate = " + partiOrdinate);
        System.out.println("Tipo  = " + tipo);
        System.out.println("Esercizi  =  "  + esercizi);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        */
    }

    private Uno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        giornomom1 = new javax.swing.JLabel();
        ese2 = new javax.swing.JLabel();
        rep1 = new javax.swing.JLabel();
        ese1 = new javax.swing.JLabel();
        ese3 = new javax.swing.JLabel();
        ese4 = new javax.swing.JLabel();
        ese5 = new javax.swing.JLabel();
        ese6 = new javax.swing.JLabel();
        ese7 = new javax.swing.JLabel();
        ese8 = new javax.swing.JLabel();
        ese9 = new javax.swing.JLabel();
        ese10 = new javax.swing.JLabel();
        rep2 = new javax.swing.JLabel();
        rep3 = new javax.swing.JLabel();
        rep4 = new javax.swing.JLabel();
        rep6 = new javax.swing.JLabel();
        rep5 = new javax.swing.JLabel();
        rep7 = new javax.swing.JLabel();
        rep9 = new javax.swing.JLabel();
        rep10 = new javax.swing.JLabel();
        rep8 = new javax.swing.JLabel();
        combo1 = new javax.swing.JComboBox<>();
        combo2 = new javax.swing.JComboBox<>();
        combo3 = new javax.swing.JComboBox<>();
        combo10 = new javax.swing.JComboBox<>();
        combo5 = new javax.swing.JComboBox<>();
        combo4 = new javax.swing.JComboBox<>();
        combo6 = new javax.swing.JComboBox<>();
        combo7 = new javax.swing.JComboBox<>();
        combo8 = new javax.swing.JComboBox<>();
        combo9 = new javax.swing.JComboBox<>();
        modificabutton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        confermabutton = new javax.swing.JButton();

        jButton2.setText("Modifica");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(155, 17, 30));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ASSEGNA SCHEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 3, 18), new java.awt.Color(255, 255, 102))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESERCIZI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 3, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        jLabel1.setText("Rep");

        giornomom1.setFont(new java.awt.Font("Yu Gothic UI", 3, 8)); // NOI18N
        giornomom1.setText("Giorno da mostrare + momento");

        ese2.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese2.setBorder(new javax.swing.border.MatteBorder(null));

        rep1.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep1.setBorder(new javax.swing.border.MatteBorder(null));

        ese1.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese1.setBorder(new javax.swing.border.MatteBorder(null));

        ese3.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese3.setBorder(new javax.swing.border.MatteBorder(null));

        ese4.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese4.setBorder(new javax.swing.border.MatteBorder(null));

        ese5.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese5.setBorder(new javax.swing.border.MatteBorder(null));

        ese6.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese6.setBorder(new javax.swing.border.MatteBorder(null));

        ese7.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese7.setBorder(new javax.swing.border.MatteBorder(null));

        ese8.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese8.setBorder(new javax.swing.border.MatteBorder(null));

        ese9.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese9.setBorder(new javax.swing.border.MatteBorder(null));

        ese10.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese10.setBorder(new javax.swing.border.MatteBorder(null));

        rep2.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep2.setBorder(new javax.swing.border.MatteBorder(null));

        rep3.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep3.setBorder(new javax.swing.border.MatteBorder(null));

        rep4.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep4.setBorder(new javax.swing.border.MatteBorder(null));

        rep6.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep6.setBorder(new javax.swing.border.MatteBorder(null));

        rep5.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep5.setBorder(new javax.swing.border.MatteBorder(null));

        rep7.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep7.setBorder(new javax.swing.border.MatteBorder(null));

        rep9.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep9.setBorder(new javax.swing.border.MatteBorder(null));

        rep10.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep10.setBorder(new javax.swing.border.MatteBorder(null));

        rep8.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep8.setBorder(new javax.swing.border.MatteBorder(null));

        combo1.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo1.setMaximumRowCount(20);
        combo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo1MouseClicked(evt);
            }
        });

        combo2.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo2.setMaximumRowCount(20);
        combo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo2MouseClicked(evt);
            }
        });

        combo3.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo3.setMaximumRowCount(20);
        combo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo3MouseClicked(evt);
            }
        });
        combo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo3ActionPerformed(evt);
            }
        });

        combo10.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo10.setMaximumRowCount(20);

        combo5.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo5.setMaximumRowCount(20);

        combo4.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo4.setMaximumRowCount(20);

        combo6.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo6.setMaximumRowCount(20);

        combo7.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo7.setMaximumRowCount(20);

        combo8.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo8.setMaximumRowCount(20);

        combo9.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo9.setMaximumRowCount(20);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(giornomom1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ese1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rep10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo6, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo5, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo4, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo10, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rep7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo8, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giornomom1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rep1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ese1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ese2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ese3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rep4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ese4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ese5, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(rep5, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ese6, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(rep6, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                    .addComponent(combo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ese10, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(rep10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combo10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        modificabutton.setBackground(new java.awt.Color(255, 255, 102));
        modificabutton.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        modificabutton.setText("MODIFICA");
        modificabutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificabutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificabuttonMouseClicked(evt);
            }
        });
        modificabutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificabuttonActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 102));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton3.setText("AVANTI");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indietro1.png"))); // NOI18N
        jLabel2.setText("BACK");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        confermabutton.setBackground(new java.awt.Color(255, 255, 102));
        confermabutton.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        confermabutton.setText("CONFERMA");
        confermabutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confermabutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confermabuttonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(modificabutton, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(confermabutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(confermabutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificabutton)
                            .addComponent(jButton3)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void modificabuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificabuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificabuttonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        diario = new Diario();
        if (conferma != 0) {
            esercizi.forEach((n) -> tuttiEsercizi.add(n));
            repMin.forEach((n) -> tuttiRepMin.add(n));

            int size = arraySenzaLunedi.size();
            int count = 0;
            for (int i = 0; i < arraySenzaLunedi.size(); i++) {
                if (arraySenzaLunedi.get(i).contains("-")) {
                    count += 0;
                }else{
                    count+=1;
                }
            }
            if (count == 0) {
                size = 0;
            }else{
                size = arraySenzaLunedi.size();
            }
            if (size == 0 ) {
                JOptionPane.showMessageDialog(null, "Hai completato l'inserimento della scheda!", "Completato!", JOptionPane.INFORMATION_MESSAGE);
                //RICHIAMARE METODO PER ELIMINARE QUERY NEL DB
                diario.eliminaQuery(valori);

                creaScheda = new CreaScheda();
                creaScheda.setVisible(true);
                dispose();
            }else{
                diario.creascheda(arraySenzaLunedi, partiOrdinate,tipo,giorniSettimana,tuttiEsercizi, tuttiRepMin, valori);
                dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Devi prima confermare la scheda di allenamento!", "Attenzione!", JOptionPane.WARNING_MESSAGE);
        }
        /*
        System.out.println("Repmin "+repMin);
        System.out.println("Tuttiesercizi "+ tuttiEsercizi);
        System.out.println("Tuttirepmin "+ tuttiRepMin);
        */
        
    }//GEN-LAST:event_jButton3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        creaScheda = new CreaScheda();
        creaScheda.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void combo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo3ActionPerformed

    private void modificabuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificabuttonMouseClicked
        // TODO add your handling code here:
        mod+=1;
        
        JComboBox[] jcombo = new JComboBox[]{ combo1, combo2, combo3, combo4, combo5, combo6, combo7, combo8, combo9, combo10 };
        for (int i = 0; i < Integer.valueOf((String)listaMomenti.get(1)); i++) {
            jcombo[i].setVisible(true);
        }
        
        if (tipo.equals("Scheda Personalizzata")) {
            schedaPersonalizzata = new SchedaPersonalizzata();
            Map dati = schedaPersonalizzata.modificaSchedaPersonalizzata(esercizi);
            
            //dal primo all'ultimo esercizio
            for (int i = 0; i < esercizi.size(); i++) {
                List<String> list = (List<String>) dati.get(""+i);
                jcombo[i].addItem("** Seleziona **");
                for (int j = 0; j < list.size(); j++) {
                    //nel combo metti i risultati di quel determinato esercizio
                    jcombo[i].addItem(list.get(j));
                }
            }
            
        }else{
            schedaCorso = new SchedaCorso();
            //Map dati = modifica.modificaSchedaCorso(tipo);
            Map dati = schedaCorso.prendiEserciziCorso(tipo);
            
            for (int i = 0; i < esercizi.size(); i++) {
                jcombo[i].addItem("** Seleziona **");
                for (int j = 0; j < dati.size()/3; j++) {
                    if (!(dati.get(tipo + "_" + (j+1)).equals(esercizi.get(i)))) {
                        jcombo[i].addItem(dati.get(tipo + "_" + (j+1)));
                    }
                }
            }
        }
        
    }//GEN-LAST:event_modificabuttonMouseClicked

    private void confermabuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confermabuttonMouseClicked
        // TODO add your handling code here:
        //per capire se ha cliccato conferma
        conferma +=1;
        modificabutton.setVisible(false);
        confermabutton.setVisible(false);
        diario = new Diario();

        if(mod != 0){
            int modifica = 0;

            JComboBox[] jcombo = new JComboBox[]{ combo1, combo2, combo3, combo4, combo5, combo6, combo7, combo8, combo9, combo10 };
            for (int i = 0; i < esercizi.size(); i++) {
                if ( !(jcombo[i].getSelectedItem() == "** Seleziona **") ) {
                    esercizi.set(i, jcombo[i].getSelectedItem());
                    modifica+=1;
                }
            }
            
            if(modifica != 0){
                List <Double> metRep;
                if (tipo.equals("Scheda Personalizzata")) {
                    schedaPersonalizzata = new SchedaPersonalizzata();
                    metRep = schedaPersonalizzata.getMetRep(esercizi);
                }else{
                    schedaCorso = new SchedaCorso();
                    metRep = new ArrayList<>();
                    Map dati = schedaCorso.prendiEserciziCorso(tipo);
                    for (int i = 0; i < esercizi.size(); i++) {
                        for (int j = 0; j < dati.size()/3; j++) {
                            if (esercizi.get(i).equals(dati.get(tipo+"_"+(j+1)))) {
                                metRep.add(Double.parseDouble((String) dati.get(tipo+"_"+(j+1)+"_met")));
                                metRep.add(Double.parseDouble((String) dati.get(tipo+"_"+(j+1)+"_rep")));
                            }
                        }
                    }
                }
                
                
                Map dati = new HashMap();
                dati.put("ListaMomenti", listaMomenti);
                dati.put("ListaEsercizi", esercizi);
                dati.put("ListaMetRep", metRep);
                Map risModficati = diario.calcoloCalorie(dati);                     
                esercizi =  (List<Object>) risModficati.get("Esercizi");
                repMin =  (List<Object>) risModficati.get("RepMin");
            }
        }
        
        /////********
        diario.insertdb(listaMomenti, primomomento, esercizi, repMin, tipo,(String)valori.get("fabbisogno"));
    }//GEN-LAST:event_confermabuttonMouseClicked

    private void combo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_combo1MouseClicked

    private void combo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_combo2MouseClicked

    private void combo3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_combo3MouseClicked
    
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
            java.util.logging.Logger.getLogger(Uno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Uno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Uno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Uno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Uno().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JComboBox<String> combo10;
    private javax.swing.JComboBox<String> combo2;
    private javax.swing.JComboBox<String> combo3;
    private javax.swing.JComboBox<String> combo4;
    private javax.swing.JComboBox<String> combo5;
    private javax.swing.JComboBox<String> combo6;
    private javax.swing.JComboBox<String> combo7;
    private javax.swing.JComboBox<String> combo8;
    private javax.swing.JComboBox<String> combo9;
    private javax.swing.JButton confermabutton;
    private javax.swing.JLabel ese1;
    private javax.swing.JLabel ese10;
    private javax.swing.JLabel ese2;
    private javax.swing.JLabel ese3;
    private javax.swing.JLabel ese4;
    private javax.swing.JLabel ese5;
    private javax.swing.JLabel ese6;
    private javax.swing.JLabel ese7;
    private javax.swing.JLabel ese8;
    private javax.swing.JLabel ese9;
    private javax.swing.JLabel giornomom1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton modificabutton;
    private javax.swing.JLabel rep1;
    private javax.swing.JLabel rep10;
    private javax.swing.JLabel rep2;
    private javax.swing.JLabel rep3;
    private javax.swing.JLabel rep4;
    private javax.swing.JLabel rep5;
    private javax.swing.JLabel rep6;
    private javax.swing.JLabel rep7;
    private javax.swing.JLabel rep8;
    private javax.swing.JLabel rep9;
    // End of variables declaration//GEN-END:variables
}
