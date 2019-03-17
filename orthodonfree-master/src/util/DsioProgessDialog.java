/*     */ package util;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.StringTokenizer;
/*     */ import javax.swing.DefaultCellEditor;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JProgressBar;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.SwingWorker;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ import javax.swing.table.TableModel;
/*     */ import small.app.ConnexionDB;
/*     */ import small.app.JPatientsTableModel;
/*     */ import small.app.ListePatientListener;
/*     */ import small.data.DateCellRenderer;
/*     */ import small.data.JDateChooserCellEditor;
/*     */ import small.data.Patient;
/*     */ 
/*     */ public class DsioProgessDialog extends JFrame
/*     */ {
/*     */   private JButton startButton;
/*     */   private JButton quitter;
/*     */   private JProgressBar progressBar;
/*     */   private JTextArea textArea;
/*     */   private SimulatedActivity activity;
/*     */   public static final int DEFAULT_WIDTH = 800;
/*     */   public static final int DEFAULT_HEIGHT = 200;
/*     */ 
/*     */   public DsioProgessDialog(File file, ConnexionDB conn, JTable jTable)
/*     */   {
/*  42 */     setTitle("Importation des données DSIO");
/*  43 */     setSize(800, 200);
/*  44 */     setLocationRelativeTo(getParent());
/*     */ 
/*  46 */     this.textArea = new JTextArea();
/*     */ 
/*  50 */     int MAX = 4650;
/*  51 */     JPanel panel = new JPanel();
/*  52 */     this.startButton = new JButton("Démarrer l'Importation");
/*  53 */     this.quitter = new JButton("Fermer");
/*  54 */     this.progressBar = new JProgressBar(0, 4650);
/*  55 */     this.progressBar.setStringPainted(true);
/*  56 */     panel.add(this.startButton);
/*  57 */     panel.add(this.progressBar);
/*  58 */     add(new JScrollPane(this.textArea), "Center");
/*  59 */     add(panel, "South");
/*     */ 
/*  63 */    // this.startButton.addActionListener(new ActionListener(file, conn, jTable)
/*     */    // {
/*     */    //   public void actionPerformed(ActionEvent event)
/*     */    //   {
/*  67 */     //    DsioProgessDialog.this.startButton.setEnabled(false);
/*  68 */     //    DsioProgessDialog.this.activity = new DsioProgessDialog.SimulatedActivity(DsioProgessDialog.this, 4650, this.val$file, this.val$conn, this.val$jTable);
/*  69 */    //     DsioProgessDialog.this.activity.execute();
/*     */     //  }
/*     */    // });
/*  73 */     this.quitter.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent event)
/*     */       {
/*  77 */         DsioProgessDialog.this.startButton.setEnabled(false);
/*  78 */         DsioProgessDialog.this.setVisible(false);
/*     */       } } );
/*     */   }
/*     */   class SimulatedActivity extends SwingWorker<Void, Integer> {
/*  94 */     private File theFile = null;
/*  95 */     private ConnexionDB connDB = null;
/*  96 */     private String ligne = null;
/*  97 */     private StringBuffer stb = null;
/*  98 */     private StringBuffer stbTxt = null;
/*  99 */     private JTable jTable = null;
/*     */     private int current;
/*     */     private int target;
/*     */ 
/* 107 */     public SimulatedActivity(int t, File file, ConnexionDB conn, JTable jTable) { this.jTable = jTable;
/* 108 */       this.current = 0;
/* 109 */       this.target = t;
/* 110 */       this.connDB = conn;
/* 111 */       this.theFile = file; }
/*     */ 
/*     */     protected Void doInBackground()
/*     */       throws Exception
/*     */     {
/*     */       try
/*     */       {
/* 118 */         while (this.current < this.target)
/*     */         {
/* 120 */           Thread.sleep(100L);
/* 121 */           long debut = System.currentTimeMillis();
/* 122 */           BufferedReader lecteurAvecBuffer = null;
/*     */           try { lecteurAvecBuffer = new BufferedReader(new FileReader(this.theFile));
/*     */           } catch (FileNotFoundException exc)
/*     */           {
/* 126 */             System.out.println("Erreur d'ouverture");
/*     */           }
/*     */           try {
/* 129 */             int cpt = 1;
/* 130 */             this.stb = new StringBuffer();
/* 131 */             this.stbTxt = new StringBuffer();
/* 132 */             this.stb.append("Patien N°,Nom,Prenom,Civilité,Date Naissance,N°Sécu,Adresse1,Adresse2,Code Postal,Ville,Téléphone,\n");
/* 133 */             while ((this.ligne = lecteurAvecBuffer.readLine()) != null)
/*     */             {
/* 136 */               if (this.ligne.startsWith("#PTN"))
/*     */               {
/* 138 */                 this.stb.append(cpt + "," + this.ligne.substring(4));
/* 139 */                 cpt++;
/*     */               }
/* 141 */               else if (this.ligne.startsWith("#PTP"))
/*     */               {
/* 143 */                 this.stb.append("," + this.ligne.substring(4));
/*     */               }
/* 145 */               else if (this.ligne.startsWith("#PTG"))
/*     */               {
/* 147 */                 this.stb.append("," + this.ligne.substring(4));
/*     */               }
/* 149 */               else if (this.ligne.startsWith("#PTD")) {
/* 150 */                 String dateNais = "";
/* 151 */                 if (this.ligne.substring(4).length() > 0) dateNais = this.ligne.substring(4); else
/* 152 */                   dateNais = "00000000";
/* 153 */                 SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
/* 154 */                 Date theDate = null;
/* 155 */                 if (dateNais.length() > 0) theDate = sf.parse(dateNais);
/* 156 */                 SimpleDateFormat sff = new SimpleDateFormat("dd-MM-yyyy");
/* 157 */                 if (dateNais.length() > 0)
/*     */                 {
/* 159 */                   this.stb.append("," + sff.format(theDate));
/*     */                 }
/*     */                 else {
/* 162 */                   this.stb.append(",");
/*     */                 }
/*     */               }
/* 165 */               else if (this.ligne.startsWith("#PTI"))
/*     */               {
/* 167 */                 this.stb.append("," + this.ligne.substring(4).trim());
/*     */               }
/* 169 */               else if (this.ligne.startsWith("#AA1"))
/*     */               {
/* 171 */                 if (this.ligne.substring(4).length() > 0) this.stb.append("," + this.ligne.substring(4)); else
/* 172 */                   this.stb.append(", ");
/*     */               }
/* 174 */               else if (this.ligne.startsWith("#AA2"))
/*     */               {
/* 176 */                 if (this.ligne.substring(4).length() > 0) this.stb.append("," + this.ligne.substring(4)); else
/* 177 */                   this.stb.append(", ");
/*     */               }
/* 179 */               else if (this.ligne.startsWith("#ACP"))
/*     */               {
/* 181 */                 if (this.ligne.substring(4).length() > 0) this.stb.append("," + this.ligne.substring(4)); else
/* 182 */                   this.stb.append(", ");
/*     */               }
/* 184 */               else if (this.ligne.startsWith("#AVI"))
/*     */               {
/* 186 */                 if (this.ligne.substring(4).length() > 0) this.stb.append("," + this.ligne.substring(4)); else
/* 187 */                   this.stb.append(", ");
/*     */               } else {
/* 189 */                 if (!this.ligne.startsWith("#ATD"))
/*     */                   continue;
/* 191 */                 if (this.ligne.substring(4).length() > 0) this.stb.append("," + this.ligne.substring(4) + "\n"); else {
/* 192 */                   this.stb.append(", \n");
/*     */                 }
/*     */               }
/*     */             }
/* 196 */             File ff = new File(System.getProperty("dsio.dir") + "/importdsio.csv");
/* 197 */             FileWriter fw = new FileWriter(ff);
/* 198 */             fw.write(this.stb.toString());
/* 199 */             fw.close();
/* 200 */             long fin = System.currentTimeMillis();
/* 201 */             System.out.println("Temps de traitement DSIO to CSV = " + (fin - debut) + " millisecondes");
/*     */           }
/*     */           catch (Exception e) {
/* 204 */             e.printStackTrace();
/*     */           }
/*     */           try {
/* 207 */             lecteurAvecBuffer.close();
/*     */           }
/*     */           catch (IOException e) {
/* 210 */             e.printStackTrace();
/*     */           }
/*     */ 
/* 213 */           Patient patient = new Patient();
/* 214 */           this.ligne = "";
/* 215 */           int nbCorrespondances = 0;
/* 216 */           this.stb = new StringBuffer();
/* 217 */           lecteurAvecBuffer = null;
/*     */           try {
/* 219 */             lecteurAvecBuffer = new BufferedReader(new FileReader(System.getProperty("dsio.dir") + "/importdsio.csv")); } catch (FileNotFoundException exc) {
/* 220 */             System.out.println("Erreur d'ouverture"); exc.printStackTrace();
/*     */           }try {
/* 222 */             int cpt = 0;
/* 223 */             while ((this.ligne = lecteurAvecBuffer.readLine()) != null) {
/* 224 */               if (cpt > 0) {
/* 225 */                 StringTokenizer st = new StringTokenizer(this.ligne, ",");
/*     */ 
/* 231 */                 int num = Integer.parseInt(st.nextToken());
/* 232 */                 patient.setNom(st.nextToken());
/* 233 */                 patient.setPrenom(st.nextToken());
/* 234 */                 patient.setCivilite(st.nextToken());
/* 235 */                 patient.setDateNaiss(st.nextToken());
/* 236 */                 patient.setNumSecu(st.nextToken());
/* 237 */                 patient.setAdresse1(st.nextToken());
/* 238 */                 patient.setAdresse2(st.nextToken());
/* 239 */                 patient.setCodePostal(st.nextToken());
/* 240 */                 patient.setVille(st.nextToken());
/* 241 */                 patient.setTelephone(st.nextToken());
/*     */ 
/* 244 */                 String[] params = new String[3];
/* 245 */                 params[0] = patient.getNom().toUpperCase();
/* 246 */                 params[1] = patient.getPrenom().toUpperCase();
/* 247 */                 Date datenaiss = null;
/* 248 */                 SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
/*     */                 try {
/* 250 */                   datenaiss = df.parse(patient.getDateNaiss());
/*     */                 }
/*     */                 catch (ParseException e) {
/* 253 */                   e.printStackTrace();
/*     */                 }
/* 255 */                 params[2] = String.valueOf(datenaiss.getTime());
/*     */ 
/* 257 */                 this.stb.append("Recherche pour : " + params[0] + "-" + params[1] + "-" + params[2] + "\n");
/* 258 */                 String[][] data = this.connDB.selectPatientByNomPrenomDateNaiss(params, "SelectPatientByNomPrenomDateNaiss");
/*     */ 
/* 260 */                 if (data[0][0] != null) {
/* 261 */                   System.out.print(" ===> Patient correspondant : " + data[0][1] + " - " + data[0][2] + "\n");
/* 262 */                   this.stb.append(" ===> Patient correspondant : " + data[0][1] + " - " + data[0][2] + "\n");
/* 263 */                   this.stbTxt.append(" ===> Patient correspondant : " + data[0][1] + " - " + data[0][2] + "\n");
/*     */ 
/* 267 */                   String[] valeurs = new String[10];
/* 268 */                   valeurs[0] = data[0][0];
/* 269 */                   valeurs[1] = patient.getAdresse1();
/* 270 */                   valeurs[2] = patient.getAdresse2();
/* 271 */                   valeurs[3] = patient.getTelephone();
/* 272 */                   valeurs[4] = patient.getCodePostal();
/* 273 */                   valeurs[5] = patient.getVille();
/* 274 */                   valeurs[6] = patient.getNumSecu();
/*     */ 
/* 276 */                   this.connDB.updatePatientByIdForNumSecuAdresseCPVilleTel("UpdatePatientByIdForNumSecuAdresseCPVilleTel", valeurs);
/* 277 */                   nbCorrespondances++;
/*     */                 }
/*     */               }
/* 280 */               cpt++;
/* 281 */               this.current += 1;
/* 282 */               publish(new Integer[] { Integer.valueOf(this.current++) });
/*     */             }
/* 284 */             System.out.println("==> Nombre total de patients parcourus : " + cpt);
/* 285 */             System.out.println("==> Nombre de patients correspondants : " + nbCorrespondances);
/* 286 */             this.stb.append("==> Nombre total de patients parcourus : " + cpt);
/* 287 */             this.stb.append("==> Nombre de patients correspondants : " + nbCorrespondances);
/*     */           } catch (Exception e) {
/* 289 */             e.printStackTrace();
/*     */           }
/*     */         }
/* 291 */         File ff = new File(System.getProperty("dsio.dir") + "/Log_importcsvdsio.txt");
/* 292 */         FileWriter fw = new FileWriter(ff);
/* 293 */         fw.write(this.stb.toString());
/* 294 */         fw.close();
/*     */       }
/*     */       catch (InterruptedException localInterruptedException)
/*     */       {
/*     */       }
/* 299 */       return null;
/*     */     }
/*     */ 
/*     */     protected void process(List<Integer> chunks)
/*     */     {
/* 304 */       for (Integer chunk : chunks)
/*     */       {
/* 306 */         if (this.ligne != null) {
/* 307 */           DsioProgessDialog.this.textArea.append(this.stbTxt.toString() + "\n");
/*     */         }
/* 309 */         DsioProgessDialog.this.progressBar.setValue(chunk.intValue());
/*     */       }
/*     */     }
/*     */ 
/*     */     protected void done()
/*     */     {
/* 315 */       DsioProgessDialog.this.startButton.setEnabled(true);
/* 316 */       JPatientsTableModel model = new JPatientsTableModel();
/* 317 */       this.jTable.setModel(model);
/* 318 */       this.jTable.getModel().addTableModelListener(new ListePatientListener());
/*     */ 
/* 320 */       String[] listeTraitement = { "AUCUN", "TO90", "TO75", "TO50", "TO05", "STOP" };
/* 321 */       JComboBox comboBox = new JComboBox(listeTraitement);
/* 322 */       this.jTable.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBox));
/* 323 */       this.jTable.getColumnModel().getColumn(5).setCellEditor(new JDateChooserCellEditor());
/* 324 */       this.jTable.getColumnModel().getColumn(7).setCellEditor(new JDateChooserCellEditor());
/* 325 */       this.jTable.getColumnModel().getColumn(8).setCellEditor(new JDateChooserCellEditor());
/* 326 */       this.jTable.setDefaultRenderer(Date.class, new DateCellRenderer());
/*     */     }
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     util.DsioProgessDialog
 * JD-Core Version:    0.6.0
 */