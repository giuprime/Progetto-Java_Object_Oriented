package Dashboard_Utente;

import Autenticazione.Utente;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class VediTreMomenti extends javax.swing.JFrame {

    private List<Integer> array_momenti;//array_momenti [2, 0, 0, 0, 0, 0, 0]--> CONTIENE I MOMENTI SCELTI PER OGNI GIORNO DELLA WEEK
    private List<Object> contaEsercizi; //contaEsercizi [5-0-2, 0-0-0, 0-0-0, 0-0-0, 0-0-0, 0-0-0, 0-0-0]--> CONTIENE IL NUMERO DI ESERCIZI DA ASSEGNARE PER OGNI MOMENTO
    private List<String> esercizi;      //esercizi [Piegamenti in ginocchio, Push up and rotate, Piegamenti in ginocchio, Hammer curl, Wrist curl, Piegamenti in ginocchio, Wrist curl]-->CONTIENE IL NOME DEGLI ESERCIZI DA FARE 
    private List<String> ripetizioni;   //ripetizioni [2.0, 2.0, 2.0, 2.0, 2.0, 5.0, 5.0] -->CONTIENE IL NUMERO DI RIPETIZIONI PER OGNI ESERCIZIO
    private List<String> listaMomenti;  //listaMomenti [Lunedi Mattina, -, Lunedi Sera, -, -, -, -, -, -, -, -, -, -, -, -, -, -, -, -, -, -]-->CONTIENE I GIORNI E I MOMENTI INSIEME
    private int fabbisogno;
    private int numeroEsercizi1;
    private int numeroEsercizi2;
    private int numeroEsercizi3;
    
    public VediTreMomenti(List<Integer> array_momenti, List<Object> contaEsercizi, List<String> esercizi, List<String> ripetizioni,List<String> listaMomenti, int fabbisogno) {
        
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
        System.out.println("//---------------------------------------------------------");
        */
        
        kcal.setText(""+fabbisogno);
        giornomom1.setText(listaMomenti.get(0));
        giornomom2.setText(listaMomenti.get(1));
        giornomom3.setText(listaMomenti.get(2));
        
        String[] str = ((String)contaEsercizi.get(0)).split("-");
        
        this.numeroEsercizi1 = Integer.parseInt(str[0]);
        this.numeroEsercizi2 = Integer.parseInt(str[1]);
        this.numeroEsercizi3 = Integer.parseInt(str[2]);
        
        //***************************************************************************************************************************** PRIMO PANNELLO
        //  MOSTRA ESERCIZI NEL FRAME
        JLabel[] jtext = new JLabel[]{ ese1, ese2, ese3, ese4, ese5, ese6, ese7, ese8, ese9, ese10 };
        for (JLabel jtext1 : jtext) {
            jtext1.setVisible(false);
        }
        for (int i = 0; i < numeroEsercizi1; i++) {
            jtext[i].setVisible(true);
            jtext[i].setText((String)esercizi.get(i));
        }
        //-----------------------------------------
        //  MOSTRA RIPETIZIONI O MINUTI NEL FRAME
        JLabel[] jlabel = new JLabel[]{ rep1, rep2, rep3, rep4, rep5, rep6, rep7, rep8, rep9, rep10 };
        for (JLabel jlabel1 : jlabel) {
            jlabel1.setVisible(false);
        }
        for (int i = 0; i < numeroEsercizi1; i++) {
            jlabel[i].setVisible(true);
            jlabel[i].setText(String.valueOf(ripetizioni.get(i)));
        }
        //*******************************************************************************************************************************************************
        //***************************************************************************************************************************** SECONDO PANNELLO
        //  MOSTRA ESERCIZI NEL FRAME
        JLabel[] jtext1 = new JLabel[]{ese11, ese12, ese13, ese14, ese15, ese16, ese17, ese18, ese19, ese20 };        
        for (JLabel jtext11 : jtext1) {
            jtext11.setVisible(false);
        }
        for (int i = 0; i < numeroEsercizi2; i++) {
            jtext1[i].setVisible(true);
            jtext1[i].setText((String)esercizi.get( i + numeroEsercizi1));
        }
        //-----------------------------------------
        //  MOSTRA RIPETIZIONI O MINUTI NEL FRAME
        JLabel[] jlabel1 = new JLabel[]{ rep11, rep12, rep13, rep14, rep15, rep16, rep17, rep18, rep19, rep20 };
        for (JLabel jlabel11 : jlabel1) {
            jlabel11.setVisible(false);
        }
        for (int i = 0; i < numeroEsercizi2; i++) {
            jlabel1[i].setVisible(true);
            jlabel1[i].setText(String.valueOf(ripetizioni.get(i + numeroEsercizi1)));
        }
        //-----------------------------------------
        //*******************************************************************************************************************************************************
        //***************************************************************************************************************************** TERZO PANNELLO        
        //  MOSTRA ESERCIZI NEL FRAME
        JLabel[] jtext2 = new JLabel[]{ ese21, ese22, ese23, ese24, ese25, ese26, ese27, ese28, ese29, ese30 };
        for (JLabel jtext21 : jtext2) {
            jtext21.setVisible(false);
        }
        for (int i = 0; i < numeroEsercizi3; i++) {
            jtext2[i].setVisible(true);
            jtext2[i].setText((String)esercizi.get( i + numeroEsercizi1 + numeroEsercizi2));
        }
        //-----------------------------------------
        //  MOSTRA RIPETIZIONI O MINUTI NEL FRAME
        JLabel[] rep33 = new JLabel[]{ rep21, rep22, rep23, rep24, rep25, rep26, rep27, rep28, rep29, rep30 }; 
        for (JLabel rep331 : rep33) {
            rep331.setVisible(false);
        }
        for (int i = 0; i < numeroEsercizi3; i++) {
            rep33[i].setVisible(true);
            rep33[i].setText(String.valueOf(ripetizioni.get(i + numeroEsercizi1 + numeroEsercizi2 )));
        }
        //-----------------------------------------
        //*******************************************************************************************************************************************************
    }

    private VediTreMomenti() {
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
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
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
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        giornomom3 = new javax.swing.JLabel();
        ese22 = new javax.swing.JLabel();
        rep21 = new javax.swing.JLabel();
        ese21 = new javax.swing.JLabel();
        ese23 = new javax.swing.JLabel();
        ese24 = new javax.swing.JLabel();
        ese25 = new javax.swing.JLabel();
        ese26 = new javax.swing.JLabel();
        ese27 = new javax.swing.JLabel();
        ese28 = new javax.swing.JLabel();
        ese29 = new javax.swing.JLabel();
        ese30 = new javax.swing.JLabel();
        rep22 = new javax.swing.JLabel();
        rep23 = new javax.swing.JLabel();
        rep24 = new javax.swing.JLabel();
        rep26 = new javax.swing.JLabel();
        rep25 = new javax.swing.JLabel();
        rep27 = new javax.swing.JLabel();
        rep29 = new javax.swing.JLabel();
        rep30 = new javax.swing.JLabel();
        rep28 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        nascondimi = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        kcal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(155, 17, 30));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VISUALIZZA SCHEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 3, 18), new java.awt.Color(255, 255, 102))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(788, 641));

        jPanel4.setBackground(new java.awt.Color(255, 255, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESERCIZI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 3, 18))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(241, 439));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jLabel1.setText("Rep");

        giornomom1.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(giornomom1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
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
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giornomom1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rep1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ese1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ese2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ese3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rep4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ese4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ese10, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(rep10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESERCIZI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 3, 18))); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(241, 439));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jLabel4.setText("Rep");

        giornomom2.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        giornomom2.setText("Giorno da mostrare + momento");

        ese12.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese12.setBorder(new javax.swing.border.MatteBorder(null));

        rep11.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep11.setBorder(new javax.swing.border.MatteBorder(null));

        ese11.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese11.setBorder(new javax.swing.border.MatteBorder(null));

        ese13.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
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
        rep12.setBorder(new javax.swing.border.MatteBorder(null));

        rep13.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(giornomom2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
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
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giornomom2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rep11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ese11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ese12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ese13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rep14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ese14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ese20, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(rep20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 102));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESERCIZI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 3, 18))); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(241, 439));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jLabel6.setText("Rep");

        giornomom3.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        giornomom3.setText("Giorno da mostrare + momento");

        ese22.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese22.setBorder(new javax.swing.border.MatteBorder(null));

        rep21.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep21.setBorder(new javax.swing.border.MatteBorder(null));

        ese21.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese21.setBorder(new javax.swing.border.MatteBorder(null));

        ese23.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese23.setBorder(new javax.swing.border.MatteBorder(null));

        ese24.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese24.setBorder(new javax.swing.border.MatteBorder(null));

        ese25.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese25.setBorder(new javax.swing.border.MatteBorder(null));

        ese26.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese26.setBorder(new javax.swing.border.MatteBorder(null));

        ese27.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese27.setBorder(new javax.swing.border.MatteBorder(null));

        ese28.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese28.setBorder(new javax.swing.border.MatteBorder(null));

        ese29.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese29.setBorder(new javax.swing.border.MatteBorder(null));

        ese30.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        ese30.setBorder(new javax.swing.border.MatteBorder(null));

        rep22.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep22.setBorder(new javax.swing.border.MatteBorder(null));

        rep23.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep23.setBorder(new javax.swing.border.MatteBorder(null));

        rep24.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep24.setBorder(new javax.swing.border.MatteBorder(null));

        rep26.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep26.setBorder(new javax.swing.border.MatteBorder(null));

        rep25.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep25.setBorder(new javax.swing.border.MatteBorder(null));

        rep27.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep27.setBorder(new javax.swing.border.MatteBorder(null));

        rep29.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep29.setBorder(new javax.swing.border.MatteBorder(null));

        rep30.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep30.setBorder(new javax.swing.border.MatteBorder(null));

        rep28.setFont(new java.awt.Font("Yu Gothic UI", 3, 10)); // NOI18N
        rep28.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(giornomom3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(ese30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ese21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rep30, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep26, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep25, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep24, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep27, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep28, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep29, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(26, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(giornomom3)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rep21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ese21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ese22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ese23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rep24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ese24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ese26, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(rep26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ese29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rep29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ese30, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(rep30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indietro1.png"))); // NOI18N
        jLabel2.setText("BACK");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
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

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 102));
        jLabel3.setText("Devi assumere giornalmente:");

        kcal.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        kcal.setForeground(new java.awt.Color(255, 255, 102));
        kcal.setText("Calorie");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 102));
        jLabel5.setText("Kcal");

        javax.swing.GroupLayout nascondimiLayout = new javax.swing.GroupLayout(nascondimi);
        nascondimi.setLayout(nascondimiLayout);
        nascondimiLayout.setHorizontalGroup(
            nascondimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nascondimiLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kcal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 179, Short.MAX_VALUE))
        );
        nascondimiLayout.setVerticalGroup(
            nascondimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nascondimiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(nascondimiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(kcal)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nascondimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(264, 264, 264))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGap(12, 12, 12))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nascondimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        for (int i = 0; i < numeroEsercizi1 + numeroEsercizi2 + numeroEsercizi3; i++) {
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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        ScegliVisualizza scegli = new ScegliVisualizza();
        scegli.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(VediTreMomenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VediTreMomenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VediTreMomenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VediTreMomenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VediTreMomenti().setVisible(true);
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
    private javax.swing.JLabel ese21;
    private javax.swing.JLabel ese22;
    private javax.swing.JLabel ese23;
    private javax.swing.JLabel ese24;
    private javax.swing.JLabel ese25;
    private javax.swing.JLabel ese26;
    private javax.swing.JLabel ese27;
    private javax.swing.JLabel ese28;
    private javax.swing.JLabel ese29;
    private javax.swing.JLabel ese3;
    private javax.swing.JLabel ese30;
    private javax.swing.JLabel ese4;
    private javax.swing.JLabel ese5;
    private javax.swing.JLabel ese6;
    private javax.swing.JLabel ese7;
    private javax.swing.JLabel ese8;
    private javax.swing.JLabel ese9;
    private javax.swing.JLabel giornomom1;
    private javax.swing.JLabel giornomom2;
    private javax.swing.JLabel giornomom3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
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
    private javax.swing.JLabel rep21;
    private javax.swing.JLabel rep22;
    private javax.swing.JLabel rep23;
    private javax.swing.JLabel rep24;
    private javax.swing.JLabel rep25;
    private javax.swing.JLabel rep26;
    private javax.swing.JLabel rep27;
    private javax.swing.JLabel rep28;
    private javax.swing.JLabel rep29;
    private javax.swing.JLabel rep3;
    private javax.swing.JLabel rep30;
    private javax.swing.JLabel rep4;
    private javax.swing.JLabel rep5;
    private javax.swing.JLabel rep6;
    private javax.swing.JLabel rep7;
    private javax.swing.JLabel rep8;
    private javax.swing.JLabel rep9;
    // End of variables declaration//GEN-END:variables
}
