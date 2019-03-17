/*     */ package small.app;
/*     */ 
/*     */ import com.toedter.calendar.JDateChooser;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import small.data.Patient;
/*     */ 
/*     */ public class FicheModification extends JFrame
/*     */   implements ActionListener
/*     */ {
/*     */   ConnexionDB connect;
/*  31 */   private JPanel jContentPane = null;
/*  32 */   private JLabel jLabel = null;
/*  33 */   private JTextField nom = null;
/*  34 */   private JLabel jLabel1 = null;
/*  35 */   private JTextField prenom = null;
/*  36 */   private JTextField numSecu = null;
/*  37 */   private JLabel jLabel11 = null;
/*  38 */   private JLabel jLabel111 = null;
/*  39 */   private JLabel jLabel1111 = null;
/*  40 */   private JPanel jPanel = null;
/*  41 */   private JButton btnEnreg = null;
/*  42 */   private JButton btnAnnuler = null;
/*  43 */   private Connection conn = null;
/*  44 */   private JLabel jLabel112 = null;
/*  45 */   private JDateChooser dateNaiss = null;
/*  46 */   private JLabel jLabel2 = null;
/*  47 */   private JTextField adresse1 = null;
/*  48 */   private JTextField adresse2 = null;
/*  49 */   private JLabel jLabel21 = null;
/*  50 */   private JLabel jLabel211 = null;
/*  51 */   private JTextField codePostal = null;
/*  52 */   private JLabel jLabel2111 = null;
/*  53 */   private JTextField ville = null;
/*  54 */   private JLabel jLabel1112 = null;
/*  55 */   private JLabel jLabel1121 = null;
/*  56 */   private JTextField telephone = null;
/*  57 */   private JTextField telephone2 = null;
/*  58 */   private JLabel jLabel11211 = null;
/*  59 */   private String[][] patient = null;
/*  60 */   private int id_patient = 0;
/*     */ 
/*     */   public FicheModification(int id_patient)
/*     */   {
/*  69 */     this.id_patient = id_patient;
/*  70 */     this.connect = new ConnexionDB();
/*     */     try {
/*  72 */       this.conn = this.connect.getConnexion();
/*     */     }
/*     */     catch (ClassNotFoundException e) {
/*  75 */       e.printStackTrace();
/*     */     }
/*     */     catch (SQLException e) {
/*  78 */       e.printStackTrace();
/*     */     }
/*  80 */     initialize();
/*     */   }
/*     */ 
/*     */   public FicheModification(ConnexionDB conn)
/*     */   {
/*  85 */     this.connect = conn;
/*  86 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*  94 */     String[] params = new String[1];
/*  95 */     params[0] = String.valueOf(this.id_patient);
/*  96 */     this.patient = this.connect.select(params, "SelectPtientById");
/*  97 */     setSize(new Dimension(701, 302));
/*  98 */     setContentPane(getJContentPane());
/*  99 */     setTitle("OrthodonFree - Fiche de Modification du Patient");
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/* 109 */     if (this.jContentPane == null) {
/* 110 */       this.jLabel11211 = new JLabel();
/* 111 */       this.jLabel11211.setBounds(new Rectangle(362, 200, 179, 22));
/* 112 */       this.jLabel11211.setText("Téléphone secondaire :");
/* 113 */       this.jLabel1121 = new JLabel();
/* 114 */       this.jLabel1121.setBounds(new Rectangle(14, 199, 183, 20));
/* 115 */       this.jLabel1121.setText("Téléphone principal :");
/* 116 */       this.jLabel2111 = new JLabel();
/* 117 */       this.jLabel2111.setBounds(new Rectangle(361, 164, 94, 22));
/* 118 */       this.jLabel2111.setText("Ville :");
/* 119 */       this.jLabel211 = new JLabel();
/* 120 */       this.jLabel211.setBounds(new Rectangle(359, 120, 92, 22));
/* 121 */       this.jLabel211.setText("Code Postal :");
/* 122 */       this.jLabel21 = new JLabel();
/* 123 */       this.jLabel21.setBounds(new Rectangle(360, 75, 92, 22));
/* 124 */       this.jLabel21.setText("Adresse 2 :");
/* 125 */       this.jLabel2 = new JLabel();
/* 126 */       this.jLabel2.setBounds(new Rectangle(359, 30, 92, 22));
/* 127 */       this.jLabel2.setText("Adresse :");
/* 128 */       this.jLabel112 = new JLabel();
/* 129 */       this.jLabel112.setBounds(new Rectangle(14, 164, 182, 20));
/* 130 */       this.jLabel112.setText("Date de Naiss.ance :");
/* 131 */       this.jLabel11 = new JLabel();
/* 132 */       this.jLabel11.setBounds(new Rectangle(14, 120, 94, 22));
/* 133 */       this.jLabel11.setText("N° Sécu. :");
/* 134 */       this.jLabel1 = new JLabel();
/* 135 */       this.jLabel1.setBounds(new Rectangle(14, 73, 94, 21));
/* 136 */       this.jLabel1.setText("Prénom :");
/* 137 */       this.jLabel = new JLabel(this.patient[0][1]);
/* 138 */       this.jLabel.setText("Nom :");
/* 139 */       this.jLabel.setBounds(new Rectangle(14, 30, 95, 22));
/* 140 */       this.jContentPane = new JPanel();
/* 141 */       this.jContentPane.setLayout(null);
/* 142 */       this.jContentPane.add(getNom(), null);
/* 143 */       this.jContentPane.add(this.jLabel, null);
/* 144 */       this.jContentPane.add(this.jLabel1, null);
/* 145 */       this.jContentPane.add(getPrenom(), null);
/* 146 */       this.jContentPane.add(getNumSecu(), null);
/* 147 */       this.jContentPane.add(this.jLabel11, null);
/* 148 */       this.jContentPane.add(getJPanel(), null);
/* 149 */       this.jContentPane.add(this.jLabel112, null);
/* 150 */       this.jContentPane.add(getDateNaiss(), null);
/* 151 */       this.jContentPane.add(this.jLabel2, null);
/* 152 */       this.jContentPane.add(getAdresse1(), null);
/* 153 */       this.jContentPane.add(getAdresse2(), null);
/* 154 */       this.jContentPane.add(this.jLabel21, null);
/* 155 */       this.jContentPane.add(this.jLabel211, null);
/* 156 */       this.jContentPane.add(getCodePostal(), null);
/* 157 */       this.jContentPane.add(this.jLabel2111, null);
/* 158 */       this.jContentPane.add(getVille(), null);
/* 159 */       this.jContentPane.add(this.jLabel1121, null);
/* 160 */       this.jContentPane.add(getTelephone(), null);
/* 161 */       this.jContentPane.add(getTelephone2(), null);
/* 162 */       this.jContentPane.add(this.jLabel11211, null);
/*     */     }
/* 164 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JTextField getNom()
/*     */   {
/* 173 */     if (this.nom == null) {
/* 174 */       this.nom = new JTextField(this.patient[0][2]);
/* 175 */       this.nom.setBounds(new Rectangle(109, 30, 220, 22));
/* 176 */       this.nom.setName("");
/*     */     }
/* 178 */     return this.nom;
/*     */   }
/*     */ 
/*     */   private JTextField getPrenom()
/*     */   {
/* 187 */     if (this.prenom == null) {
/* 188 */       this.prenom = new JTextField(this.patient[0][1]);
/* 189 */       this.prenom.setBounds(new Rectangle(109, 73, 220, 21));
/*     */     }
/* 191 */     return this.prenom;
/*     */   }
/*     */ 
/*     */   private JTextField getNumSecu()
/*     */   {
/* 200 */     if (this.numSecu == null) {
/* 201 */       this.numSecu = new JTextField(this.patient[0][13]);
/* 202 */       this.numSecu.setBounds(new Rectangle(106, 120, 223, 22));
/*     */     }
/* 204 */     return this.numSecu;
/*     */   }
/*     */ 
/*     */   private JPanel getJPanel()
/*     */   {
/* 213 */     if (this.jPanel == null) {
/* 214 */       this.jPanel = new JPanel();
/* 215 */       this.jPanel.setLayout(new FlowLayout());
/* 216 */       this.jPanel.setBounds(new Rectangle(14, 231, 666, 40));
/* 217 */       this.jPanel.add(getBtnEnreg(), null);
/* 218 */       this.jPanel.add(getBtnAnnuler(), null);
/*     */     }
/* 220 */     return this.jPanel;
/*     */   }
/*     */ 
/*     */   private JButton getBtnEnreg()
/*     */   {
/* 229 */     if (this.btnEnreg == null) {
/* 230 */       this.btnEnreg = new JButton();
/* 231 */       this.btnEnreg.setText("Enregistrer");
/* 232 */       this.btnEnreg.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent e) {
/* 234 */           System.out.println("Enregistrement de l'adhérent dans la base");
/*     */ 
/* 245 */           Patient pat = new Patient();
/* 246 */           pat.setPrenom(FicheModification.this.prenom.getText().trim());
/* 247 */           pat.setNom(FicheModification.this.nom.getText().trim());
/* 248 */           pat.setDateNaiss(new SimpleDateFormat("dd-MM-yyyy").format(FicheModification.this.dateNaiss.getDate()));
/* 249 */           pat.setAdresse1(FicheModification.this.adresse1.getText());
/* 250 */           pat.setAdresse2(FicheModification.this.adresse2.getText());
/* 251 */           pat.setTelephone(FicheModification.this.telephone.getText());
/* 252 */           pat.setTelephone2(FicheModification.this.telephone2.getText());
/* 253 */           pat.setCodePostal(FicheModification.this.codePostal.getText());
/* 254 */           pat.setVille(FicheModification.this.ville.getText());
/* 255 */           pat.setNumSecu(FicheModification.this.numSecu.getText());
/*     */ 
/* 257 */           FicheModification.this.connect.updatePatient(pat, "UpdatePatient", FicheModification.this.id_patient);
/* 258 */           System.out.println("Update du patient : " + FicheModification.this.id_patient + "-" + pat.getNom() + " dans la base de données !");
/*     */ 
/* 260 */           DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
/* 261 */           Date maDate = new Date();
/* 262 */           String date = format.format(maDate);
/* 263 */           String[] donnees = new String[2];
/*     */ 
/* 265 */           donnees[0] = String.valueOf(FicheModification.this);
/* 266 */           donnees[1] = date;
/* 267 */           FicheModification.this.connect.updatePatients("UpdatePatientDateModif", donnees);
/* 268 */           System.out.println("Maj DateModification sur table patients effectuée");
/*     */         }
/*     */ 
/*     */       });
/*     */     }
/*     */ 
/* 285 */     return this.btnEnreg;
/*     */   }
/*     */ 
/*     */   private JButton getBtnAnnuler()
/*     */   {
/* 294 */     if (this.btnAnnuler == null) {
/* 295 */       this.btnAnnuler = new JButton();
/* 296 */       this.btnAnnuler.setText("Annuler / Fermer");
/* 297 */       this.btnAnnuler.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent e) {
/* 299 */           System.out.println("Fermeture Fiche Modification");
/* 300 */           FicheModification.this.setVisible(false);
/* 301 */           FicheModification.this.dispose();
/*     */         }
/*     */       });
/*     */     }
/* 306 */     return this.btnAnnuler;
/*     */   }
/*     */ 
/*     */   private JDateChooser getDateNaiss()
/*     */   {
/* 315 */     if (this.dateNaiss == null) {
/* 316 */       this.dateNaiss = new JDateChooser("dd-MM-yyyy", "##/##/####", '_');
/* 317 */       long datenaiss = Long.parseLong(this.patient[0][3]);
/* 318 */       this.dateNaiss.setDate(new Date(datenaiss));
/* 319 */       this.dateNaiss.setBounds(new Rectangle(199, 164, 130, 20));
/*     */     }
/* 321 */     return this.dateNaiss;
/*     */   }
/*     */ 
/*     */   private JTextField getAdresse1()
/*     */   {
/* 330 */     if (this.adresse1 == null) {
/* 331 */       this.adresse1 = new JTextField(this.patient[0][4]);
/* 332 */       this.adresse1.setBounds(new Rectangle(452, 30, 222, 22));
/*     */     }
/* 334 */     return this.adresse1;
/*     */   }
/*     */ 
/*     */   private JTextField getAdresse2()
/*     */   {
/* 343 */     if (this.adresse2 == null) {
/* 344 */       this.adresse2 = new JTextField(this.patient[0][5]);
/* 345 */       this.adresse2.setBounds(new Rectangle(452, 75, 222, 22));
/*     */     }
/* 347 */     return this.adresse2;
/*     */   }
/*     */ 
/*     */   private JTextField getCodePostal()
/*     */   {
/* 356 */     if (this.codePostal == null) {
/* 357 */       this.codePostal = new JTextField(this.patient[0][8]);
/* 358 */       this.codePostal.setBounds(new Rectangle(452, 120, 103, 22));
/*     */     }
/* 360 */     return this.codePostal;
/*     */   }
/*     */ 
/*     */   private JTextField getVille()
/*     */   {
/* 369 */     if (this.ville == null) {
/* 370 */       this.ville = new JTextField(this.patient[0][9]);
/* 371 */       this.ville.setBounds(new Rectangle(456, 164, 222, 22));
/*     */     }
/* 373 */     return this.ville;
/*     */   }
/*     */ 
/*     */   private JTextField getTelephone()
/*     */   {
/* 382 */     if (this.telephone == null) {
/* 383 */       this.telephone = new JTextField(this.patient[0][6]);
/* 384 */       this.telephone.setBounds(new Rectangle(199, 200, 130, 20));
/*     */     }
/* 386 */     return this.telephone;
/*     */   }
/*     */ 
/*     */   private JTextField getTelephone2()
/*     */   {
/* 395 */     if (this.telephone2 == null) {
/* 396 */       this.telephone2 = new JTextField(this.patient[0][7]);
/* 397 */       this.telephone2.setBounds(new Rectangle(541, 202, 132, 20));
/*     */     }
/* 399 */     return this.telephone2;
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent arg0)
/*     */   {
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.FicheModification
 * JD-Core Version:    0.6.0
 */