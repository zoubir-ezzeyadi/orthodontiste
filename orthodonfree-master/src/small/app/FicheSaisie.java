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
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import small.data.Patient;
/*     */ 
/*     */ public class FicheSaisie extends JFrame
/*     */   implements ActionListener
/*     */ {
/*     */   ConnexionDB connect;
/*  28 */   private JPanel jContentPane = null;
/*  29 */   private JLabel jLabel = null;
/*  30 */   private JTextField nom = null;
/*  31 */   private JLabel jLabel1 = null;
/*  32 */   private JTextField prenom = null;
/*  33 */   private JTextField numSecu = null;
/*  34 */   private JLabel jLabel11 = null;
/*  35 */   private JLabel jLabel111 = null;
/*  36 */   private JLabel jLabel1111 = null;
/*  37 */   private JPanel jPanel = null;
/*  38 */   private JButton btnEnreg = null;
/*  39 */   private JButton btnAnnuler = null;
/*  40 */   private Connection conn = null;
/*  41 */   private JLabel jLabel112 = null;
/*  42 */   private JDateChooser dateNaiss = null;
/*  43 */   private JLabel jLabel2 = null;
/*  44 */   private JTextField adresse1 = null;
/*  45 */   private JTextField adresse2 = null;
/*  46 */   private JLabel jLabel21 = null;
/*  47 */   private JLabel jLabel211 = null;
/*  48 */   private JTextField codePostal = null;
/*  49 */   private JLabel jLabel2111 = null;
/*  50 */   private JTextField ville = null;
/*  51 */   private JLabel jLabel1112 = null;
/*  52 */   private JLabel jLabel1121 = null;
/*  53 */   private JTextField telephone = null;
/*  54 */   private JTextField telephone2 = null;
/*  55 */   private JLabel jLabel11211 = null;
/*  56 */   private FicheConsultationListe appelant = null;
/*     */ 
/*     */   public FicheSaisie()
/*     */   {
/*  64 */     this.connect = new ConnexionDB();
/*     */     try {
/*  66 */       this.conn = this.connect.getConnexion();
/*     */     }
/*     */     catch (ClassNotFoundException e) {
/*  69 */       e.printStackTrace();
/*     */     }
/*     */     catch (SQLException e) {
/*  72 */       e.printStackTrace();
/*     */     }
/*  74 */     initialize();
/*     */   }
/*     */ 
/*     */   public FicheSaisie(FicheConsultationListe appelant)
/*     */   {
/*  84 */     this.connect = new ConnexionDB();
/*     */     try {
/*  86 */       this.conn = this.connect.getConnexion();
/*     */     }
/*     */     catch (ClassNotFoundException e) {
/*  89 */       e.printStackTrace();
/*     */     }
/*     */     catch (SQLException e) {
/*  92 */       e.printStackTrace();
/*     */     }
/*  94 */     this.appelant = appelant;
/*  95 */     initialize();
/*     */   }
/*     */ 
/*     */   public FicheSaisie(ConnexionDB conn)
/*     */   {
/* 100 */     this.connect = conn;
/* 101 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/* 109 */     setSize(new Dimension(699, 313));
/* 110 */     setContentPane(getJContentPane());
/* 111 */     setTitle("OrthodonFree - Fiche de Saisie Patient");
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/* 121 */     if (this.jContentPane == null) {
/* 122 */       this.jLabel11211 = new JLabel();
/* 123 */       this.jLabel11211.setBounds(new Rectangle(362, 200, 179, 22));
/* 124 */       this.jLabel11211.setText("Téléphone secondaire :");
/* 125 */       this.jLabel1121 = new JLabel();
/* 126 */       this.jLabel1121.setBounds(new Rectangle(14, 199, 183, 20));
/* 127 */       this.jLabel1121.setText("Téléphone principal :");
/* 128 */       this.jLabel2111 = new JLabel();
/* 129 */       this.jLabel2111.setBounds(new Rectangle(361, 164, 94, 22));
/* 130 */       this.jLabel2111.setText("Ville :");
/* 131 */       this.jLabel211 = new JLabel();
/* 132 */       this.jLabel211.setBounds(new Rectangle(359, 120, 103, 22));
/* 133 */       this.jLabel211.setText("Code Postal :");
/* 134 */       this.jLabel21 = new JLabel();
/* 135 */       this.jLabel21.setBounds(new Rectangle(360, 75, 92, 22));
/* 136 */       this.jLabel21.setText("Adresse 2 :");
/* 137 */       this.jLabel2 = new JLabel();
/* 138 */       this.jLabel2.setBounds(new Rectangle(359, 30, 92, 22));
/* 139 */       this.jLabel2.setText("Adresse :");
/* 140 */       this.jLabel112 = new JLabel();
/* 141 */       this.jLabel112.setBounds(new Rectangle(14, 164, 182, 20));
/* 142 */       this.jLabel112.setText("Date de Naiss.ance :");
/* 143 */       this.jLabel11 = new JLabel();
/* 144 */       this.jLabel11.setBounds(new Rectangle(14, 120, 94, 22));
/* 145 */       this.jLabel11.setText("N° Sécu. :");
/* 146 */       this.jLabel1 = new JLabel();
/* 147 */       this.jLabel1.setBounds(new Rectangle(14, 73, 94, 21));
/* 148 */       this.jLabel1.setText("Prénom :");
/* 149 */       this.jLabel = new JLabel();
/* 150 */       this.jLabel.setText("Nom :");
/* 151 */       this.jLabel.setBounds(new Rectangle(14, 30, 95, 22));
/* 152 */       this.jContentPane = new JPanel();
/* 153 */       this.jContentPane.setLayout(null);
/* 154 */       this.jContentPane.add(getNom(), null);
/* 155 */       this.jContentPane.add(this.jLabel, null);
/* 156 */       this.jContentPane.add(this.jLabel1, null);
/* 157 */       this.jContentPane.add(getPrenom(), null);
/* 158 */       this.jContentPane.add(getNumSecu(), null);
/* 159 */       this.jContentPane.add(this.jLabel11, null);
/* 160 */       this.jContentPane.add(getJPanel(), null);
/* 161 */       this.jContentPane.add(this.jLabel112, null);
/* 162 */       this.jContentPane.add(getDateNaiss(), null);
/* 163 */       this.jContentPane.add(this.jLabel2, null);
/* 164 */       this.jContentPane.add(getAdresse1(), null);
/* 165 */       this.jContentPane.add(getAdresse2(), null);
/* 166 */       this.jContentPane.add(this.jLabel21, null);
/* 167 */       this.jContentPane.add(this.jLabel211, null);
/* 168 */       this.jContentPane.add(getCodePostal(), null);
/* 169 */       this.jContentPane.add(this.jLabel2111, null);
/* 170 */       this.jContentPane.add(getVille(), null);
/* 171 */       this.jContentPane.add(this.jLabel1121, null);
/* 172 */       this.jContentPane.add(getTelephone(), null);
/* 173 */       this.jContentPane.add(getTelephone2(), null);
/* 174 */       this.jContentPane.add(this.jLabel11211, null);
/*     */     }
/* 176 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JTextField getNom()
/*     */   {
/* 185 */     if (this.nom == null) {
/* 186 */       this.nom = new JTextField();
/* 187 */       this.nom.setBounds(new Rectangle(106, 30, 223, 22));
/* 188 */       this.nom.setName("");
/*     */     }
/* 190 */     return this.nom;
/*     */   }
/*     */ 
/*     */   private JTextField getPrenom()
/*     */   {
/* 199 */     if (this.prenom == null) {
/* 200 */       this.prenom = new JTextField();
/* 201 */       this.prenom.setBounds(new Rectangle(106, 73, 223, 21));
/*     */     }
/* 203 */     return this.prenom;
/*     */   }
/*     */ 
/*     */   private JTextField getNumSecu()
/*     */   {
/* 212 */     if (this.numSecu == null) {
/* 213 */       this.numSecu = new JTextField();
/* 214 */       this.numSecu.setBounds(new Rectangle(106, 120, 223, 22));
/*     */     }
/* 216 */     return this.numSecu;
/*     */   }
/*     */ 
/*     */   private JPanel getJPanel()
/*     */   {
/* 225 */     if (this.jPanel == null) {
/* 226 */       this.jPanel = new JPanel();
/* 227 */       this.jPanel.setLayout(new FlowLayout());
/* 228 */       this.jPanel.setBounds(new Rectangle(9, 245, 683, 40));
/* 229 */       this.jPanel.add(getBtnEnreg(), null);
/* 230 */       this.jPanel.add(getBtnAnnuler(), null);
/*     */     }
/* 232 */     return this.jPanel;
/*     */   }
/*     */ 
/*     */   private JButton getBtnEnreg()
/*     */   {
/* 241 */     if (this.btnEnreg == null) {
/* 242 */       this.btnEnreg = new JButton();
/* 243 */       this.btnEnreg.setText("Enregistrer");
/* 244 */       this.btnEnreg.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent e) {
/* 246 */           System.out.println("Enregistrement de l'adhérent dans la base");
/*     */ 
/* 257 */           Patient pat = new Patient();
/* 258 */           pat.setPrenom(FicheSaisie.this.prenom.getText().trim());
/* 259 */           pat.setNom(FicheSaisie.this.nom.getText().trim());
/* 260 */           pat.setDateNaiss(new SimpleDateFormat("dd-MM-yyyy").format(FicheSaisie.this.dateNaiss.getDate()));
/* 261 */           pat.setAdresse1(FicheSaisie.this.adresse1.getText());
/* 262 */           pat.setAdresse2(FicheSaisie.this.adresse2.getText());
/* 263 */           pat.setTelephone(FicheSaisie.this.telephone.getText());
/* 264 */           pat.setTelephone2(FicheSaisie.this.telephone2.getText());
/* 265 */           pat.setCodePostal(FicheSaisie.this.codePostal.getText());
/* 266 */           pat.setVille(FicheSaisie.this.ville.getText().trim());
/* 267 */           pat.setDateModification(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
/* 268 */           pat.setDateCreation(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
/*     */ 
/* 270 */           pat.setNumSecu(FicheSaisie.this.numSecu.getText());
/*     */ 
/* 272 */           FicheSaisie.this.connect.insertPatient(pat, "InsertNewPatient");
/* 273 */           System.out.println("Insertion du patient " + pat.getNom() + " dans la base de données !");
/*     */ 
/* 275 */           JOptionPane.showMessageDialog(null, "Insertion du patient " + pat.getNom(), "Accès base de données", 1);
/*     */ 
/* 287 */           FicheSaisie.this.appelant.populateJtable();
/*     */         } } );
/*     */     }
/* 291 */     return this.btnEnreg;
/*     */   }
/*     */ 
/*     */   private JButton getBtnAnnuler()
/*     */   {
/* 300 */     if (this.btnAnnuler == null) {
/* 301 */       this.btnAnnuler = new JButton();
/* 302 */       this.btnAnnuler.setText("Annuler / Fermer");
/* 303 */       this.btnAnnuler.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent e) {
/* 305 */           System.out.println("actionPerformed()");
/* 306 */           FicheSaisie.this.setVisible(false);
/*     */         }
/*     */       });
/*     */     }
/* 311 */     return this.btnAnnuler;
/*     */   }
/*     */ 
/*     */   private JDateChooser getDateNaiss()
/*     */   {
/* 320 */     if (this.dateNaiss == null) {
/* 321 */       this.dateNaiss = new JDateChooser("dd-MM-yyyy", "##/##/####", '_');
/* 322 */       this.dateNaiss.setBounds(new Rectangle(199, 164, 130, 20));
/*     */     }
/* 324 */     return this.dateNaiss;
/*     */   }
/*     */ 
/*     */   private JTextField getAdresse1()
/*     */   {
/* 333 */     if (this.adresse1 == null) {
/* 334 */       this.adresse1 = new JTextField();
/* 335 */       this.adresse1.setBounds(new Rectangle(452, 30, 222, 22));
/*     */     }
/* 337 */     return this.adresse1;
/*     */   }
/*     */ 
/*     */   private JTextField getAdresse2()
/*     */   {
/* 346 */     if (this.adresse2 == null) {
/* 347 */       this.adresse2 = new JTextField();
/* 348 */       this.adresse2.setBounds(new Rectangle(452, 75, 222, 22));
/*     */     }
/* 350 */     return this.adresse2;
/*     */   }
/*     */ 
/*     */   private JTextField getCodePostal()
/*     */   {
/* 359 */     if (this.codePostal == null) {
/* 360 */       this.codePostal = new JTextField();
/* 361 */       this.codePostal.setBounds(new Rectangle(470, 120, 103, 22));
/*     */     }
/* 363 */     return this.codePostal;
/*     */   }
/*     */ 
/*     */   private JTextField getVille()
/*     */   {
/* 372 */     if (this.ville == null) {
/* 373 */       this.ville = new JTextField();
/* 374 */       this.ville.setBounds(new Rectangle(414, 164, 264, 22));
/*     */     }
/* 376 */     return this.ville;
/*     */   }
/*     */ 
/*     */   private JTextField getTelephone()
/*     */   {
/* 385 */     if (this.telephone == null) {
/* 386 */       this.telephone = new JTextField();
/* 387 */       this.telephone.setBounds(new Rectangle(199, 200, 130, 20));
/*     */     }
/* 389 */     return this.telephone;
/*     */   }
/*     */ 
/*     */   private JTextField getTelephone2()
/*     */   {
/* 398 */     if (this.telephone2 == null) {
/* 399 */       this.telephone2 = new JTextField();
/* 400 */       this.telephone2.setBounds(new Rectangle(541, 202, 132, 20));
/*     */     }
/* 402 */     return this.telephone2;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 410 */     FicheSaisie ficheSaisie = new FicheSaisie();
/* 411 */     ficheSaisie.setVisible(true);
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent arg0)
/*     */   {
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.FicheSaisie
 * JD-Core Version:    0.6.0
 */