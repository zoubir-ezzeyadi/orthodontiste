/*     */ package util;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
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
/*     */ public class CetoProgressDialog extends JFrame
/*     */ {
/*     */   private JButton startButton;
/*     */   private JButton quitter;
/*     */   private JProgressBar progressBar;
/*     */   private JTextArea textArea;
/*     */   private SimulatedActivity activity;
/*     */   public static final int DEFAULT_WIDTH = 800;
/*     */   public static final int DEFAULT_HEIGHT = 200;
/*     */ 
/*     */   public CetoProgressDialog(File file, ConnexionDB conn, JTable jTable)
/*     */   {
/*  63 */     setTitle("Importation des données CETO");
/*  64 */     setSize(800, 200);
/*  65 */     setLocationRelativeTo(getParent());
/*     */ 
/*  67 */     this.textArea = new JTextArea();
/*     */ 
/*  71 */     int MAX = 1000;
/*  72 */     JPanel panel = new JPanel();
/*  73 */     this.startButton = new JButton("Démarrer l'Importation");
/*  74 */     this.quitter = new JButton("Fermer");
/*  75 */     this.progressBar = new JProgressBar(0, 1000);
/*  76 */     this.progressBar.setStringPainted(true);
/*  77 */     panel.add(this.startButton);
/*  78 */     panel.add(this.progressBar);
/*  79 */     add(new JScrollPane(this.textArea), "Center");
/*  80 */     add(panel, "South");
/*     */ 
//    this.startButton.addActionListener(new ActionListener(file, conn, jTable)
//     {
//       public void actionPerformed(ActionEvent event)
//       {
//         CetoProgressDialog.this.startButton.setEnabled(false);
//         CetoProgressDialog.this.activity = new CetoProgressDialog.SimulatedActivity(CetoProgressDialog.this, 1000, this.val$file, this.val$conn, this.val$jTable);
//         CetoProgressDialog.this.activity.execute();
//      }
//     });
/*  94 */     this.quitter.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent event)
/*     */       {
/*  98 */         CetoProgressDialog.this.startButton.setEnabled(false);
/*  99 */         CetoProgressDialog.this.setVisible(false);
/*     */       } } );
/*     */   }
/*     */ 
/*     */   class SimulatedActivity extends SwingWorker<Void, Integer> {
/* 115 */     private File theFile = null;
/* 116 */     private ConnexionDB connDB = null;
/* 117 */     private String ligne = null;
/* 118 */     private JTable jTable = null;
/*     */     private int current;
/*     */     private int target;
/*     */ 
/*     */     public SimulatedActivity(int t, File file, ConnexionDB conn, JTable jTable) {
/* 126 */       this.jTable = jTable;
/* 127 */       this.current = 0;
/* 128 */       this.target = t;
/* 129 */       this.connDB = conn;
/* 130 */       this.theFile = file;
/*     */     }
/*     */ 
/*     */     protected Void doInBackground() throws Exception
/*     */     {
/*     */       try
/*     */       {
/* 137 */         while (this.current < this.target)
/*     */         {
/* 139 */           Thread.sleep(100L);
/* 140 */           BufferedReader lecteurAvecBuffer = null;
/*     */           try { lecteurAvecBuffer = new BufferedReader(new FileReader(this.theFile));
/*     */           } catch (FileNotFoundException exc)
/*     */           {
/* 144 */             System.out.println("Erreur d'ouverture");
/*     */           }
/*     */           try
/*     */           {
/* 148 */             while ((this.ligne = lecteurAvecBuffer.readLine()) != null)
/*     */             {
/* 151 */               if (this.ligne.startsWith("INSERT INTO PATIENT")) {
/* 152 */                 System.out.println(this.ligne);
/* 153 */                 String dataPatient = this.ligne.substring(27, this.ligne.length() - 1);
/* 154 */                 System.out.println("extraction des données de la requête : " + dataPatient);
/*     */ 
/* 156 */                 StringTokenizer st = new StringTokenizer(dataPatient, ",");
/* 157 */                 Patient thePatient = new Patient();
/* 158 */                 String id = st.nextToken();
/* 159 */                 thePatient.setPrenom(st.nextToken().replaceAll("'", ""));
/* 160 */                 thePatient.setNom(st.nextToken().replaceAll("'", ""));
/* 161 */                 Date d = new Date(Long.valueOf(st.nextToken()).longValue());
/* 162 */                 SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
/* 163 */                 String dateEnForme = "";
/* 164 */                 dateEnForme = df.format(d);
/* 165 */                 thePatient.setDateNaiss(dateEnForme);
/* 166 */                 thePatient.setAdresse1(st.nextToken().replaceAll("'", ""));
/* 167 */                 thePatient.setAdresse2(st.nextToken().replaceAll("'", ""));
/* 168 */                 thePatient.setTelephone(st.nextToken());
/* 169 */                 thePatient.setTelephone2(st.nextToken());
/* 170 */                 thePatient.setCodePostal(st.nextToken());
/* 171 */                 thePatient.setVille(st.nextToken().replaceAll("'", ""));
/*     */ 
/* 173 */                 Date d2 = new Date(Long.valueOf(st.nextToken()).longValue());
/* 174 */                 SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
/* 175 */                 String dateEnForme2 = "";
/* 176 */                 dateEnForme2 = df.format(d2);
/* 177 */                 thePatient.setDateCreation(dateEnForme2);
/* 178 */                 thePatient.setDateModification("");
/* 179 */                 thePatient.setNumSecu("O");
/* 180 */                 this.connDB.insertPatient(thePatient, "InsertNewPatient");
/*     */               }
/* 182 */               this.current += 1;
/* 183 */               publish(new Integer[] { Integer.valueOf(this.current++) });
/*     */             }
/*     */           } catch (IOException e) {
/* 185 */             e.printStackTrace();
/*     */           }try { lecteurAvecBuffer.close(); } catch (IOException e) { e.printStackTrace(); }
/*     */         }
/*     */       }
/*     */       catch (InterruptedException localInterruptedException)
/*     */       {
/*     */       }
/* 192 */       return null;
/*     */     }
/*     */ 
/*     */     protected void process(List<Integer> chunks)
/*     */     {
/* 197 */       for (Integer chunk : chunks)
/*     */       {
/* 199 */         if ((this.ligne != null) && 
/* 200 */           (this.ligne.startsWith("INSERT INTO PATIENT"))) CetoProgressDialog.this.textArea.append(this.ligne + "\n");
/*     */ 
/* 202 */         CetoProgressDialog.this.progressBar.setValue(chunk.intValue());
/*     */       }
/*     */     }
/*     */ 
/*     */     protected void done()
/*     */     {
/* 208 */       CetoProgressDialog.this.startButton.setEnabled(true);
/* 209 */       JPatientsTableModel model = new JPatientsTableModel();
/* 210 */       this.jTable.setModel(model);
/* 211 */       this.jTable.getModel().addTableModelListener(new ListePatientListener());
/*     */ 
/* 213 */       String[] listeTraitement = { "AUCUN", "TO90", "TO75", "TO50", "TO05", "STOP" };
/* 214 */       JComboBox comboBox = new JComboBox(listeTraitement);
/* 215 */       this.jTable.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBox));
/* 216 */       this.jTable.getColumnModel().getColumn(5).setCellEditor(new JDateChooserCellEditor());
/* 217 */       this.jTable.getColumnModel().getColumn(7).setCellEditor(new JDateChooserCellEditor());
/* 218 */       this.jTable.getColumnModel().getColumn(8).setCellEditor(new JDateChooserCellEditor());
/* 219 */       this.jTable.setDefaultRenderer(Date.class, new DateCellRenderer());
/*     */     }
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     util.CetoProgressDialog
 * JD-Core Version:    0.6.0
 */