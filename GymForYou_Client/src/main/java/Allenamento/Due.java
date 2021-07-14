package Allenamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Due extends javax.swing.JFrame {

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
    private List<String> giorniSettimana;
    private List<Object> esercizi;
    private List<Object> repMin;
    private List<Object> tuttiEsercizi;
    private List<Object> tuttiRepMin;
    private List<Object> listaMomenti;
    private int mod = 0;
    private Map valori;
    private int conferma = 0;
    

    public Due(int numeroMoments,List<String> primomomento,List<String> arraySenzaLunedi,List<Integer> arraySenzaMomentoLunedi,List<Object> partiOrdinate, String tipo, List<String> giorniSettimana,List<Object> tuttiEsercizi, List<Object> tuttiRepMin, Map valori ) {
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
                
        if (primomomento.get(0).contains("Mattina")) {
            giornomom1.setText(primomomento.get(0));
        }else if (primomomento.get(0).contains("Pomeriggio")) {
            giornomom1.setText(primomomento.get(0));
        }
        
        giornomom2.setText(primomomento.get(1));
        
        diario = new Diario();
        Map risultati = diario.calcoloCalorie(diario.esercizi(numeroMoments, primomomento, partiOrdinate,tipo));
        this.esercizi = esercizi = (List<Object>) risultati.get("Esercizi");
        this.repMin = repMin =  (List<Object>) risultati.get("RepMin");
        this.listaMomenti = listaMomenti = (List<Object>) risultati.get("ListaMomenti");
        
        
        if (Integer.valueOf((String)listaMomenti.get(1)) < 6) {
            jLabel1.setText("Min");
        }
        if (Integer.valueOf((String)listaMomenti.get(4)) < 6) {
            jLabel2.setText("Min");
        }
                
        //***************************************************************************************************************************** PRIMO PANNELLO
        //  MOSTRA ESERCIZI NEL FRAME
        JLabel[] jtext = new JLabel[]{ ese1, ese2, ese3, ese4, ese5, ese6, ese7, ese8, ese9, ese10 };
        for (JLabel jtext1 : jtext) {
            jtext1.setVisible(false);
        }
        for (int i = 0; i < Integer.valueOf((String)listaMomenti.get(1)); i++) {
            jtext[i].setVisible(true);
            jtext[i].setText((String)esercizi.get(i));
        }
        //-----------------------------------------
        //  MOSTRA RIPETIZIONI O MINUTI NEL FRAME
        JLabel[] jlabel = new JLabel[]{ rep1, rep2, rep3, rep4, rep5, rep6, rep7, rep8, rep9, rep10 };
        for (JLabel jlabel1 : jlabel) {
            jlabel1.setVisible(false);
        }
        for (int i = 0; i < Integer.valueOf((String)listaMomenti.get(1)); i++) {
            jlabel[i].setVisible(true);
            jlabel[i].setText(String.valueOf(repMin.get(i)));
        }
        //-----------------------------------------
        //  IMPOSTA A FALSE TUTTI I COMBO BOX
        JComboBox[] jcombo = new JComboBox[]{ combo1, combo2, combo3, combo4, combo5, combo6, combo7, combo8, combo9, combo10 };
        for (JComboBox jcombo1 : jcombo) {
            jcombo1.setVisible(false);
        }
        //-----------------------------------------
        //*******************************************************************************************************************************************************
        //***************************************************************************************************************************** SECONDO PANNELLO
        //  MOSTRA ESERCIZI NEL FRAME
        JLabel[] jtext1 = new JLabel[]{ese11, ese12, ese13, ese14, ese15, ese16, ese17, ese18, ese19, ese20 };        
        for (JLabel jtext11 : jtext1) {
            jtext11.setVisible(false);
        }
        for (int i = 0; i < Integer.valueOf((String)listaMomenti.get(4)); i++) {
            jtext1[i].setVisible(true);
            jtext1[i].setText((String)esercizi.get( i + Integer.valueOf((String)listaMomenti.get(1))));
        }
        //-----------------------------------------
        //  MOSTRA RIPETIZIONI O MINUTI NEL FRAME
        JLabel[] jlabel1 = new JLabel[]{ rep11, rep12, rep13, rep14, rep15, rep16, rep17, rep18, rep19, rep20 };
        for (JLabel jlabel11 : jlabel1) {
            jlabel11.setVisible(false);
        }
        for (int i = 0; i < Integer.valueOf((String)listaMomenti.get(4)); i++) {
            jlabel1[i].setVisible(true);
            jlabel1[i].setText(String.valueOf(repMin.get(i + Integer.valueOf((String)listaMomenti.get(1)))));
        }
        //-----------------------------------------
        //  IMPOSTA A FALSE TUTTI I COMBO BOX
        JComboBox[] jcombo1 = new JComboBox[]{combo11, combo12, combo13, combo14, combo15, combo16, combo17, combo18, combo19, combo20 };
        for (JComboBox jcombo11 : jcombo1) {
            jcombo11.setVisible(false);
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

    private Due() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        modificabutton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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
        combo4 = new javax.swing.JComboBox<>();
        combo5 = new javax.swing.JComboBox<>();
        combo6 = new javax.swing.JComboBox<>();
        combo7 = new javax.swing.JComboBox<>();
        combo8 = new javax.swing.JComboBox<>();
        combo9 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        giornomom2 = new javax.swing.JLabel();
        ese12 = new javax.swing.JLabel();
        rep11 = new javax.swing.JLabel();
        ese11 = new javax.swing.JLabel();
        ese13 = new javax.swing.JLabel();
        ese14 = new javax.swing.JLabel();
        ese15 = new javax.swing.JLabel();
        ese16 = new javax.swing.JLabel();
        ese17 = new javax.swing.JLabel();
        ese18 = new javax.swing.JLabel();
        ese19 = new javax.swing.JLabel();
        ese20 = new javax.swing.JLabel();
        rep12 = new javax.swing.JLabel();
        rep13 = new javax.swing.JLabel();
        rep14 = new javax.swing.JLabel();
        rep16 = new javax.swing.JLabel();
        rep15 = new javax.swing.JLabel();
        rep17 = new javax.swing.JLabel();
        rep19 = new javax.swing.JLabel();
        rep20 = new javax.swing.JLabel();
        rep18 = new javax.swing.JLabel();
        combo11 = new javax.swing.JComboBox<>();
        combo12 = new javax.swing.JComboBox<>();
        combo13 = new javax.swing.JComboBox<>();
        combo20 = new javax.swing.JComboBox<>();
        combo14 = new javax.swing.JComboBox<>();
        combo15 = new javax.swing.JComboBox<>();
        combo16 = new javax.swing.JComboBox<>();
        combo17 = new javax.swing.JComboBox<>();
        combo18 = new javax.swing.JComboBox<>();
        combo19 = new javax.swing.JComboBox<>();
        confermabutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(155, 17, 30));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ASSEGNA SCHEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 2, 18), new java.awt.Color(255, 255, 102))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indietro1.png"))); // NOI18N
        jLabel3.setText("BACK");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        modificabutton.setBackground(new java.awt.Color(255, 255, 102));
        modificabutton.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        modificabutton.setText("MODIFICA");
        modificabutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificabutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificabuttonMouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 102));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jButton2.setText("AVANTI");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESERCIZI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 3, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        jLabel1.setText("Rep");

        giornomom1.setFont(new java.awt.Font("Yu Gothic UI", 3, 8)); // NOI18N
        giornomom1.setText("Giorno da mostrare + momento");

        ese2.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese2.setToolTipText("");
        ese2.setBorder(new javax.swing.border.MatteBorder(null));

        rep1.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep1.setToolTipText("");
        rep1.setBorder(new javax.swing.border.MatteBorder(null));

        ese1.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese1.setToolTipText("");
        ese1.setBorder(new javax.swing.border.MatteBorder(null));

        ese3.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese3.setToolTipText("");
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
        rep2.setToolTipText("");
        rep2.setBorder(new javax.swing.border.MatteBorder(null));

        rep3.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep3.setToolTipText("");
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

        combo2.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo2.setMaximumRowCount(20);

        combo3.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo3.setMaximumRowCount(20);
        combo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo3ActionPerformed(evt);
            }
        });

        combo10.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo10.setMaximumRowCount(20);

        combo4.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo4.setMaximumRowCount(20);

        combo5.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo5.setMaximumRowCount(20);

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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(giornomom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo6, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo5, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo4, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo10, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rep7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(ese3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rep3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(combo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rep4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ese4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(combo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ese5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rep5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(combo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ese6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(combo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ese7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(combo7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESERCIZI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 3, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        jLabel2.setText("Rep");

        giornomom2.setFont(new java.awt.Font("Yu Gothic UI", 3, 8)); // NOI18N
        giornomom2.setText("Giorno da mostrare + momento");

        ese12.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese12.setToolTipText("");
        ese12.setBorder(new javax.swing.border.MatteBorder(null));

        rep11.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep11.setToolTipText("");
        rep11.setBorder(new javax.swing.border.MatteBorder(null));

        ese11.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese11.setToolTipText("");
        ese11.setBorder(new javax.swing.border.MatteBorder(null));

        ese13.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese13.setToolTipText("");
        ese13.setBorder(new javax.swing.border.MatteBorder(null));

        ese14.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese14.setBorder(new javax.swing.border.MatteBorder(null));

        ese15.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese15.setBorder(new javax.swing.border.MatteBorder(null));

        ese16.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese16.setBorder(new javax.swing.border.MatteBorder(null));

        ese17.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese17.setBorder(new javax.swing.border.MatteBorder(null));

        ese18.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese18.setBorder(new javax.swing.border.MatteBorder(null));

        ese19.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese19.setBorder(new javax.swing.border.MatteBorder(null));

        ese20.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese20.setBorder(new javax.swing.border.MatteBorder(null));

        rep12.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep12.setToolTipText("");
        rep12.setBorder(new javax.swing.border.MatteBorder(null));

        rep13.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep13.setToolTipText("");
        rep13.setBorder(new javax.swing.border.MatteBorder(null));

        rep14.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep14.setBorder(new javax.swing.border.MatteBorder(null));

        rep16.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep16.setBorder(new javax.swing.border.MatteBorder(null));

        rep15.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep15.setBorder(new javax.swing.border.MatteBorder(null));

        rep17.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep17.setBorder(new javax.swing.border.MatteBorder(null));

        rep19.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep19.setBorder(new javax.swing.border.MatteBorder(null));

        rep20.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep20.setBorder(new javax.swing.border.MatteBorder(null));

        rep18.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep18.setBorder(new javax.swing.border.MatteBorder(null));

        combo11.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo11.setMaximumRowCount(20);

        combo12.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo12.setMaximumRowCount(20);

        combo13.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo13.setMaximumRowCount(20);
        combo13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo13ActionPerformed(evt);
            }
        });

        combo20.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo20.setMaximumRowCount(20);

        combo14.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo14.setMaximumRowCount(20);

        combo15.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo15.setMaximumRowCount(20);

        combo16.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo16.setMaximumRowCount(20);

        combo17.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo17.setMaximumRowCount(20);

        combo18.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo18.setMaximumRowCount(20);

        combo19.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        combo19.setMaximumRowCount(20);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(giornomom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rep20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(combo12, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(combo11, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(combo14, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(combo13, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(combo16, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(combo15, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(combo20, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rep17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo18, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo17, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo19, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giornomom2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(rep11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ese11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(combo11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(ese12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rep12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(combo12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(ese13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rep13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(combo13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rep14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ese14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(combo14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ese15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rep15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(combo15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ese16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rep16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(combo16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ese17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(combo17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ese20, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(rep20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combo20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        confermabutton.setBackground(new java.awt.Color(255, 255, 102));
        confermabutton.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(modificabutton)
                        .addGap(126, 126, 126)
                        .addComponent(confermabutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(modificabutton)
                        .addComponent(jButton2)
                        .addComponent(confermabutton))))
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

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        if (conferma != 0 ) {
            esercizi.forEach((n) -> tuttiEsercizi.add(n));
            repMin.forEach((n) -> tuttiRepMin.add(n));
            diario = new Diario();
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
                
                diario.eliminaQuery(valori);
                creaScheda = new CreaScheda();
                creaScheda.setVisible(true);
                dispose();

            }else{
                diario.creascheda(arraySenzaLunedi, partiOrdinate,tipo, giorniSettimana,tuttiEsercizi, tuttiRepMin, valori);
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
    }//GEN-LAST:event_jButton2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        creaScheda = new CreaScheda();
        creaScheda.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void combo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo3ActionPerformed

    private void combo13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo13ActionPerformed

    private void modificabuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificabuttonMouseClicked
        // TODO add your handling code here:
        mod+=1;
        
        int sizePrimo = Integer.valueOf((String)listaMomenti.get(1)) ;
        int sizeSecondo = Integer.valueOf((String)listaMomenti.get(4));

//  IMPOSTA A FALSE TUTTI I COMBO BOX
        JComboBox[] jcombo = new JComboBox[]{ combo1, combo2, combo3, combo4, combo5, combo6, combo7, combo8, combo9, combo10 };
        for (int i = 0; i < sizePrimo; i++) {
            jcombo[i].setVisible(true);
        }
        //-----------------------------------------
        //  IMPOSTA A FALSE TUTTI I COMBO BOX
        JComboBox[] jcombo1 = new JComboBox[]{combo11, combo12, combo13, combo14, combo15, combo16, combo17, combo18, combo19, combo20 };
        for (int i = 0; i < sizeSecondo; i++) {
            jcombo1[i].setVisible(true);
        }
        //-----------------------------------------
        
        if (tipo.equals("Scheda Personalizzata")) {
            schedaPersonalizzata = new SchedaPersonalizzata();
            Map dati = schedaPersonalizzata.modificaSchedaPersonalizzata(esercizi);
            System.out.println("DATI = " + dati);
            // DA 0 FINO A 7
            for (int i = 0; i < sizePrimo; i++) {
                List<String> list = (List<String>) dati.get(""+i);
                System.out.println("Lista  =  "+ list);
                jcombo[i].addItem("** Seleziona **");
                for (int j = 0; j < list.size(); j++) {
                    jcombo[i].addItem(list.get(j));
                }
            }
            
            // DA 8 FINO A 17
            for (int i = 0; i < sizeSecondo; i++) {
                List<String> list = (List<String>) dati.get(""+(i+sizePrimo));
                System.out.println("Lista  =  "+ list);
                jcombo1[i].addItem("** Seleziona **");
                for (int j = 0; j < list.size(); j++) {
                    jcombo1[i].addItem(list.get(j));
                }
            }
            
            
        }else{
            schedaCorso = new SchedaCorso();
            Map dati = schedaCorso.prendiEserciziCorso(tipo);
            
            for (int i = 0; i < sizePrimo; i++) {
                jcombo[i].addItem("** Seleziona **");
                for (int j = 0; j < dati.size()/3; j++) {
                    if (!(dati.get(tipo + "_" + (j+1)).equals(esercizi.get(i)))) {
                        jcombo[i].addItem(dati.get(tipo + "_" + (j+1)));
                    }
                }
            }
            
            for (int i = 0; i < sizeSecondo; i++) {
                jcombo1[i].addItem("** Seleziona **");
                for (int j = 0; j < dati.size()/3; j++) {
                    if (!(dati.get(tipo + "_" + (j+1)).equals(esercizi.get(i+sizePrimo)))) {
                        jcombo1[i].addItem(dati.get(tipo + "_" + (j+1)));
                    }
                }
            }
        }
    }//GEN-LAST:event_modificabuttonMouseClicked

    private void confermabuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confermabuttonMouseClicked
        // TODO add your handling code here:
        conferma+=1;
        modificabutton.setVisible(false);
        confermabutton.setVisible(false);
        diario = new Diario();
        int sizePrimo = Integer.valueOf((String)listaMomenti.get(1)) ;
        int sizeSecondo = Integer.valueOf((String)listaMomenti.get(4));
        
        
        
        if (mod != 0) {
            int modifica = 0;
            JComboBox[] jcombo = new JComboBox[]{ combo1, combo2, combo3, combo4, combo5, combo6, combo7, combo8, combo9, combo10 };
            for (int i = 0; i < sizePrimo; i++) {
                if ( !(jcombo[i].getSelectedItem() == "** Seleziona **") ) {
                    esercizi.set(i, jcombo[i].getSelectedItem());
                    modifica+=1;
                }
            }

            JComboBox[] jcombo1 = new JComboBox[]{combo11, combo12, combo13, combo14, combo15, combo16, combo17, combo18, combo19, combo20 };
            for (int i = 0; i < sizeSecondo; i++) {
                if ( !(jcombo1[i].getSelectedItem() == "** Seleziona **") ) {
                    esercizi.set((i+sizePrimo), jcombo1[i].getSelectedItem());
                    modifica+=1;
                }
            }

            if(modifica != 0){
                List <Double> metRep;
                
                if (tipo.equals("Scheda Personalizzata")) {
                    schedaPersonalizzata = new SchedaPersonalizzata();
                    metRep = (List<Double>)schedaPersonalizzata.getMetRep(esercizi);
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
        
        
        diario.insertdb(listaMomenti, primomomento, esercizi, repMin, tipo,(String)valori.get("fabbisogno"));
    }//GEN-LAST:event_confermabuttonMouseClicked

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
            java.util.logging.Logger.getLogger(Due.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Due.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Due.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Due.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Due().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JComboBox<String> combo10;
    private javax.swing.JComboBox<String> combo11;
    private javax.swing.JComboBox<String> combo12;
    private javax.swing.JComboBox<String> combo13;
    private javax.swing.JComboBox<String> combo14;
    private javax.swing.JComboBox<String> combo15;
    private javax.swing.JComboBox<String> combo16;
    private javax.swing.JComboBox<String> combo17;
    private javax.swing.JComboBox<String> combo18;
    private javax.swing.JComboBox<String> combo19;
    private javax.swing.JComboBox<String> combo2;
    private javax.swing.JComboBox<String> combo20;
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
    private javax.swing.JLabel ese11;
    private javax.swing.JLabel ese12;
    private javax.swing.JLabel ese13;
    private javax.swing.JLabel ese14;
    private javax.swing.JLabel ese15;
    private javax.swing.JLabel ese16;
    private javax.swing.JLabel ese17;
    private javax.swing.JLabel ese18;
    private javax.swing.JLabel ese19;
    private javax.swing.JLabel ese2;
    private javax.swing.JLabel ese20;
    private javax.swing.JLabel ese3;
    private javax.swing.JLabel ese4;
    private javax.swing.JLabel ese5;
    private javax.swing.JLabel ese6;
    private javax.swing.JLabel ese7;
    private javax.swing.JLabel ese8;
    private javax.swing.JLabel ese9;
    private javax.swing.JLabel giornomom1;
    private javax.swing.JLabel giornomom2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton modificabutton;
    private javax.swing.JLabel rep1;
    private javax.swing.JLabel rep10;
    private javax.swing.JLabel rep11;
    private javax.swing.JLabel rep12;
    private javax.swing.JLabel rep13;
    private javax.swing.JLabel rep14;
    private javax.swing.JLabel rep15;
    private javax.swing.JLabel rep16;
    private javax.swing.JLabel rep17;
    private javax.swing.JLabel rep18;
    private javax.swing.JLabel rep19;
    private javax.swing.JLabel rep2;
    private javax.swing.JLabel rep20;
    private javax.swing.JLabel rep3;
    private javax.swing.JLabel rep4;
    private javax.swing.JLabel rep5;
    private javax.swing.JLabel rep6;
    private javax.swing.JLabel rep7;
    private javax.swing.JLabel rep8;
    private javax.swing.JLabel rep9;
    // End of variables declaration//GEN-END:variables
}
