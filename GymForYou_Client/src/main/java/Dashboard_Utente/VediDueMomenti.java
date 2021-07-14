/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dashboard_Utente;

import Autenticazione.Utente;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author giuse
 */
public class VediDueMomenti extends javax.swing.JFrame {

    private List<Integer> array_momenti; //array_momenti [2, 0, 0, 0, 0, 0, 0]--> CONTIENE I MOMENTI SCELTI PER OGNI GIORNO DELLA WEEK
    private List<Object> contaEsercizi; //contaEsercizi [5-0-2, 0-0-0, 0-0-0, 0-0-0, 0-0-0, 0-0-0, 0-0-0]--> CONTIENE IL NUMERO DI ESERCIZI DA ASSEGNARE PER OGNI MOMENTO
    private List<String> esercizi;     //esercizi [Piegamenti in ginocchio, Push up and rotate, Piegamenti in ginocchio, Hammer curl, Wrist curl, Piegamenti in ginocchio, Wrist curl]-->CONTIENE IL NOME DEGLI ESERCIZI DA FARE
    private List<String> ripetizioni; //ripetizioni [2.0, 2.0, 2.0, 2.0, 2.0, 5.0, 5.0] -->CONTIENE IL NUMERO DI RIPETIZIONI PER OGNI ESERCIZIO
    private List<String> listaMomenti;//listaMomenti [Lunedi Mattina, -, Lunedi Sera, -, -, -, -, -, -, -, -, -, -, -, -, -, -, -, -, -, -]-->CONTIENE I GIORNI E I MOMENTI INSIEME
    private int fabbisogno;
    private int numeroEsercizi1;
    private int numeroEsercizi2;
    
    public VediDueMomenti(List<Integer> array_momenti, List<Object> contaEsercizi, List<String> esercizi, List<String> ripetizioni,List<String> listaMomenti, int fabbisogno) {
        
        initComponents();
        ImageIcon icon = new ImageIcon("src/main/resources/imageicon.png");
        setIconImage(icon.getImage());
        setTitle("GYM FOR YOU");
        this.array_momenti = array_momenti;
        this.contaEsercizi = contaEsercizi;
        this.esercizi = esercizi;
        this.ripetizioni = ripetizioni;
        this.listaMomenti = listaMomenti;
        this.fabbisogno = fabbisogno;
        /*
        System.out.println("//---------------------------------------------------------");
        System.out.println("array_momenti " + array_momenti);
        System.out.println("esercizi " + esercizi);
        System.out.println("ripetizioni " + ripetizioni);
        System.out.println("contaEsercizi " + contaEsercizi);
        System.out.println("listaMomenti "+listaMomenti);
        System.out.println("//---------------------------------------------------------");
        */
        
        kcal.setText(""+fabbisogno);
        
        String[] str = ((String)contaEsercizi.get(0)).split("-");
        
        if (Integer.parseInt(str[0]) != 0 && Integer.parseInt(str[1]) !=0 ) {
            this.numeroEsercizi1 = Integer.parseInt(str[0]);
            this.numeroEsercizi2 = Integer.parseInt(str[1]);
            giornomom1.setText(listaMomenti.get(0));
            giornomom2.setText(listaMomenti.get(1));
        }else if(Integer.parseInt(str[0]) != 0 && Integer.parseInt(str[2]) !=0 ) {
            this.numeroEsercizi1 = Integer.parseInt(str[0]);
            this.numeroEsercizi2 = Integer.parseInt(str[2]);
            giornomom1.setText(listaMomenti.get(0));
            giornomom2.setText(listaMomenti.get(2));
        }else if(Integer.parseInt(str[1]) != 0 && Integer.parseInt(str[2]) !=0) {
            this.numeroEsercizi1 = Integer.parseInt(str[1]);
            this.numeroEsercizi2 = Integer.parseInt(str[2]);
            giornomom1.setText(listaMomenti.get(1));
            giornomom2.setText(listaMomenti.get(2));
        }
        //***************************************************************************************************************************** PRIMO PANNELLO
        //  MOSTRA ESERCIZI NEL FRAME
        JLabel[] jtext = new JLabel[]{ ese1, ese2, ese3, ese4, ese5, ese6, ese7, ese8, ese9, ese10 };
        for (int i = 0; i < numeroEsercizi1; i++) {
            jtext[i].setVisible(true);
            jtext[i].setText((String)esercizi.get(i));
        }
        //-----------------------------------------
        //  MOSTRA RIPETIZIONI O MINUTI NEL FRAME
        JLabel[] jlabel = new JLabel[]{ rep1, rep2, rep3, rep4, rep5, rep6, rep7, rep8, rep9, rep10 };
        for (int i = 0; i < numeroEsercizi1; i++) {
            jlabel[i].setVisible(true);
            jlabel[i].setText(String.valueOf(ripetizioni.get(i)));
        }
        //*******************************************************************************************************************************************************
        //***************************************************************************************************************************** SECONDO PANNELLO
        //  MOSTRA ESERCIZI NEL FRAME
        JLabel[] jtext1 = new JLabel[]{ese11, ese12, ese13, ese14, ese15, ese16, ese17, ese18, ese19, ese20 };        
        for (int i = 0; i < numeroEsercizi2; i++) {
            jtext1[i].setVisible(true);
            jtext1[i].setText((String)esercizi.get( i + numeroEsercizi1));
        }
        //-----------------------------------------
        //  MOSTRA RIPETIZIONI O MINUTI NEL FRAME
        JLabel[] jlabel1 = new JLabel[]{ rep11, rep12, rep13, rep14, rep15, rep16, rep17, rep18, rep19, rep20 };
        for (int i = 0; i < numeroEsercizi2; i++) {
            jlabel1[i].setVisible(true);
            jlabel1[i].setText(String.valueOf(ripetizioni.get(i + numeroEsercizi1)));
        }
        //-----------------------------------------
        //*******************************************************************************************************************************************************
        
    }

    private VediDueMomenti() {
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
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        nascondimi = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        kcal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(507, 593));

        jPanel1.setBackground(new java.awt.Color(155, 17, 30));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VISUALIZZA SCHEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 3, 14), new java.awt.Color(255, 255, 102))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(507, 587));

        jPanel4.setBackground(new java.awt.Color(255, 255, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESERCIZI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 3, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jLabel1.setText("Rep");

        giornomom1.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(giornomom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rep10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(29, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giornomom1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rep1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ese1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ese2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ese3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rep4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ese4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ese10, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(rep10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESERCIZI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 3, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jLabel2.setText("Rep");

        giornomom2.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(giornomom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rep20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(27, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giornomom2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rep11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ese11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ese12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ese13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rep14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ese14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ese20, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(rep20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indietro1.png"))); // NOI18N
        jLabel3.setText("BACK");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 102));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton1.setText("AVANTI");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        nascondimi.setBackground(new java.awt.Color(155, 17, 30));
        nascondimi.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 102));
        jLabel4.setText("Devi assumere giornalmente:");

        kcal.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        kcal.setForeground(new java.awt.Color(255, 255, 102));
        kcal.setText("Calorie");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 102));
        jLabel6.setText("Kcal");

        javax.swing.GroupLayout nascondimiLayout = new javax.swing.GroupLayout(nascondimi);
        nascondimi.setLayout(nascondimiLayout);
        nascondimiLayout.setHorizontalGroup(
            nascondimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nascondimiLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kcal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        nascondimiLayout.setVerticalGroup(
            nascondimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nascondimiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nascondimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(kcal)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(nascondimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(nascondimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
        for (int i = 0; i < numeroEsercizi1+numeroEsercizi2; i++) {
            esercizi.remove(0);
            ripetizioni.remove(0);
        }
        if (!array_momenti.isEmpty()) {
            array_momenti.remove(0);
            contaEsercizi.remove(0);
            listaMomenti.remove(0);
            listaMomenti.remove(0);
            listaMomenti.remove(0);
            Utente utente = new Utente();
            utente.creascheda(array_momenti, contaEsercizi, esercizi, ripetizioni, listaMomenti, fabbisogno);
            dispose();
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        ScegliVisualizza scegli = new ScegliVisualizza();
        scegli.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(VediDueMomenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VediDueMomenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VediDueMomenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VediDueMomenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VediDueMomenti().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel kcal;
    private javax.swing.JPanel nascondimi;
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
