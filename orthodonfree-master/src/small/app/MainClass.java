/*     */ package small.app;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class MainClass extends JFrame
/*     */   implements ActionListener
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  20 */   private JPanel jContentPane = null;
/*  21 */   private JButton jButton = null;
/*  22 */   private JButton jButton1 = null;
/*  23 */   private JButton jButton2 = null;
/*  24 */   ConnexionDB dbcon = null;
/*  25 */   Connection conn = null;
/*     */ 
/*     */   public MainClass()
/*     */   {
/*  32 */     this.dbcon = new ConnexionDB();
/*  33 */     this.conn = null;
/*     */     try {
/*  35 */       this.conn = this.dbcon.getConnexion();
/*     */     }
/*     */     catch (ClassNotFoundException e) {
/*  38 */       e.printStackTrace();
/*     */     }
/*     */     catch (SQLException e) {
/*  41 */       e.printStackTrace();
/*     */     }
/*  43 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*  51 */     setSize(new Dimension(438, 238));
/*  52 */     setTitle("OrthodonFREE");
/*  53 */     setContentPane(getJContentPane());
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/*  63 */     if (this.jContentPane == null) {
/*  64 */       GridLayout gridLayout = new GridLayout();
/*  65 */       gridLayout.setRows(3);
/*  66 */       gridLayout.setColumns(1);
/*  67 */       this.jContentPane = new JPanel();
/*  68 */       this.jContentPane.setLayout(gridLayout);
/*  69 */       this.jContentPane.add(getJButton(), null);
/*  70 */       this.jContentPane.add(getJButton1(), null);
/*  71 */       this.jContentPane.add(getJButton2(), null);
/*     */     }
/*  73 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JButton getJButton()
/*     */   {
/*  82 */     if (this.jButton == null) {
/*  83 */       this.jButton = new JButton();
/*  84 */       this.jButton.setText("SAISIE PATIENT");
/*  85 */       this.jButton.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent e) {
/*  87 */           System.out.println("actionPerformed()");
/*  88 */           FicheSaisie ficheSaisie = new FicheSaisie(MainClass.this.dbcon);
/*     */ 
/*  90 */           ficheSaisie.setResizable(false);
/*     */ 
/*  92 */           ficheSaisie.setLocationRelativeTo(ficheSaisie.getParent());
/*     */ 
/*  94 */           ficheSaisie.setVisible(true);
/*     */         } } );
/*     */     }
/*  98 */     return this.jButton;
/*     */   }
/*     */ 
/*     */   private JButton getJButton1()
/*     */   {
/* 107 */     if (this.jButton1 == null) {
/* 108 */       this.jButton1 = new JButton();
/* 109 */       this.jButton1.setText("CONSULTATIONS / MODIFICATIONS");
/* 110 */       this.jButton1.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent e) {
/* 112 */           System.out.println("fiche Consultation");
/* 113 */           FicheConsultationListe ficheConsult = new FicheConsultationListe(MainClass.this.dbcon);
/*     */ 
/* 115 */           ficheConsult.setLocationRelativeTo(ficheConsult.getParent());
/*     */ 
/* 117 */           ficheConsult.setVisible(true);
/*     */         } } );
/*     */     }
/* 121 */     return this.jButton1;
/*     */   }
/*     */ 
/*     */   private JButton getJButton2()
/*     */   {
/* 130 */     if (this.jButton2 == null) {
/* 131 */       this.jButton2 = new JButton();
/* 132 */       this.jButton2.setText("ENTENTE PREALABLE / IMPRESSION (PDF)");
/* 133 */       this.jButton2.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent e) {
/* 135 */           System.out.println("Lancement impression rappel entente");
/* 136 */           ImpressionEntentes impEnt = new ImpressionEntentes();
/*     */         }
/*     */       });
/*     */     }
/* 141 */     return this.jButton2;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 150 */     MainClass mainClass = new MainClass();
/*     */ 
/* 152 */     mainClass.setLocationRelativeTo(mainClass.getParent());
/*     */ 
/* 154 */     mainClass.setVisible(true);
/* 155 */     mainClass.setDefaultCloseOperation(3);
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.MainClass
 * JD-Core Version:    0.6.0
 */