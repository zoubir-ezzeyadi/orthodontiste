/*     */ package small.app;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.ItemListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.print.PrinterException;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.SQLException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.swing.DefaultCellEditor;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.RowFilter;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ import javax.swing.table.TableModel;
/*     */ import javax.swing.table.TableRowSorter;
/*     */ import small.data.DateCellRenderer;
/*     */ import small.data.JDateChooserCellEditor;
/*     */ import util.ImportCeto;
/*     */ import util.ImportDsio;
/*     */ 
/*     */ public class FicheConsultationListe extends JFrame
/*     */ {
/*  44 */   private JPanel jContentPane = null;
/*  45 */   private JPanel jPanel = null;
/*  46 */   private JLabel jLabel = null;
/*  47 */   private JComboBox jComboBox = null;
/*  48 */   private JScrollPane jScrollPane = null;
/*  49 */   private JTable jTable = null;
/*  50 */   private JPanel jPanel1 = null;
/*  51 */   private JPanel jPanel2 = null;
/*  52 */   private JPanel jPanel3 = null;
/*  53 */   private JButton jButton1 = null;
/*  54 */   private ConnexionDB dbconn = null;
/*     */ 
/*  56 */   TableRowSorter<TableModel> sorter = null;
/*     */ 
/*  58 */   String[] listeTraitement = { "AUCUN", "TO90", "TO75", "TO50", "TO5", "TO10", "STOP" };
/*  59 */   JComboBox comboBox = null;
/*     */   private JButton btnNouveauPatient;
/*     */   private JButton btnModifierPatient;
/*     */   private JButton btnImprimer;
/*     */   private JButton btnAperuEp;
/*     */   private JButton btnImportCeto;
/*     */   private JTextField txtSearch;
/*     */   private JLabel lblFiltreSurLe;
/*     */   private JButton btnSupprimer;
/*     */   private JButton btnImportDsio;
/*     */   private JButton btnStatsActes;
/*     */ 
/*     */   public FicheConsultationListe(ConnexionDB dbcon)
/*     */   {
/*  77 */     this.dbconn = dbcon;
/*  78 */     initialize();
/*     */   }
/*     */ 
/*     */   public FicheConsultationListe()
/*     */   {
/*  84 */     setSize(new Dimension(1366, 768));
/*  85 */     this.dbconn = new ConnexionDB();
/*  86 */     initialize();
/*     */   }
/*     */ 
/*     */   private void initialize()
/*     */   {
/*  94 */     setTitle("OrthodonFREE - Liste des patients");
/*  95 */     setContentPane(getJContentPane());
/*     */   }
/*     */ 
/*     */   private JPanel getJContentPane()
/*     */   {
/* 104 */     if (this.jContentPane == null) {
/* 105 */       this.jContentPane = new JPanel();
/* 106 */       this.jContentPane.setLayout(new BorderLayout());
/* 107 */       this.jContentPane.add(getJPanel(), "North");
/* 108 */       this.jContentPane.add(getJScrollPane(), "Center");
/* 109 */       this.jContentPane.add(getJPanel3(), "South");
/* 110 */       this.jContentPane.add(getJPanel2(), "West");
/* 111 */       this.jContentPane.add(getJPanel1(), "East");
/*     */     }
/* 113 */     return this.jContentPane;
/*     */   }
/*     */ 
/*     */   private JPanel getJPanel()
/*     */   {
/* 122 */     if (this.jPanel == null) {
/* 123 */       this.jLabel = new JLabel();
/* 124 */       this.jLabel.setText("Sél. un type :");
/* 125 */       this.jPanel = new JPanel();
/* 126 */       this.jPanel.setLayout(new FlowLayout());
/* 127 */       this.jPanel.add(getBtnImportDsio());
/* 128 */       this.jPanel.add(getBtnImportCeto());
/* 129 */       this.jPanel.add(getBtnSupprimer());
/* 130 */       this.jPanel.add(getBtnStatsActes());
/* 131 */       this.jPanel.add(getLblFiltreSurLe());
/* 132 */       this.jPanel.add(getTxtSearch());
/* 133 */       this.jPanel.add(getBtnNouveauPatient());
/* 134 */       this.jPanel.add(getBtnModifierPatient());
/* 135 */       this.jPanel.add(getBtnAperuEp());
/* 136 */       this.jPanel.add(getBtnImprimer());
/* 137 */       this.jPanel.add(this.jLabel, null);
/* 138 */       this.jPanel.add(getJComboBox(), null);
/*     */     }
/* 140 */     return this.jPanel;
/*     */   }
/*     */ 
/*     */   private JScrollPane getJScrollPane()
/*     */   {
/* 149 */     if (this.jScrollPane == null) {
/* 150 */       this.jScrollPane = new JScrollPane();
/* 151 */       this.jScrollPane.setViewportView(getJTable());
/*     */     }
/* 153 */     return this.jScrollPane;
/*     */   }
/*     */ 
/*     */   private JTable getJTable()
/*     */   {
/* 162 */     if (this.jTable == null) {
/* 163 */       this.jTable = new JTable();
/* 164 */       this.jTable.addMouseListener(new MouseAdapter() {
/*     */         public void mousePressed(MouseEvent e) {
/* 166 */           if (e.getClickCount() == 2) {
/* 167 */             int row = FicheConsultationListe.this.jTable.getSelectedRow();
/* 168 */             int column = FicheConsultationListe.this.jTable.getSelectedColumn();
/* 169 */             if ((row >= 0) && (column >= 0) && (column <= 3)) {
/* 170 */               System.out.println("DoubleClick at ligne N°" + row + "-Colonne N°" + column);
/* 171 */               int id_patient = Integer.parseInt(FicheConsultationListe.this.jTable.getModel().getValueAt(row, 0).toString());
/* 172 */               System.out.println("ID patient = " + id_patient);
/*     */ 
/* 174 */               if ("AUCUN".equals(FicheConsultationListe.this.jTable.getModel().getValueAt(row, 6).toString())) {
/* 175 */                 JOptionPane.showMessageDialog(null, "Pas de traitement en cours pour ce patient");
/*     */               } else {
/* 177 */                 FicheSaisieEP epFrame = new FicheSaisieEP(id_patient);
/* 178 */                 epFrame.setLocationRelativeTo(epFrame.getParent());
/* 179 */                 epFrame.setVisible(true);
/* 180 */                 epFrame.setDefaultCloseOperation(2);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       });
/* 186 */       populateJtable();
/* 187 */       this.jTable.setShowGrid(true);
/* 188 */       this.jTable.setAutoCreateRowSorter(true);
/*     */     }
/*     */ 
/* 192 */     return this.jTable;
/*     */   }
/*     */ 
/*     */   public void populateJtable() {
/* 196 */     Runnable code = new Runnable() {
/*     */       public void run() {
/* 198 */         JPatientsTableModel model = new JPatientsTableModel();
/* 199 */         FicheConsultationListe.this.jTable.setModel(model);
/* 200 */         FicheConsultationListe.this.sorter = new TableRowSorter(model);
/* 201 */         FicheConsultationListe.this.jTable.setRowSorter(FicheConsultationListe.this.sorter);
/* 202 */         FicheConsultationListe.this.jTable.getModel().addTableModelListener(new ListePatientListener());
/* 203 */         JComboBox comboBox = new JComboBox(FicheConsultationListe.this.listeTraitement);
/* 204 */         FicheConsultationListe.this.jTable.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBox));
/* 205 */         FicheConsultationListe.this.jTable.getColumnModel().getColumn(5).setCellEditor(new JDateChooserCellEditor());
/* 206 */         FicheConsultationListe.this.jTable.getColumnModel().getColumn(7).setCellEditor(new JDateChooserCellEditor());
/* 207 */         FicheConsultationListe.this.jTable.getColumnModel().getColumn(8).setCellEditor(new JDateChooserCellEditor());
/* 208 */         FicheConsultationListe.this.jTable.setDefaultRenderer(Date.class, new DateCellRenderer());
/*     */       }
/*     */     };
/* 212 */     if (SwingUtilities.isEventDispatchThread())
/* 213 */       code.run();
/*     */     else
/* 215 */       SwingUtilities.invokeLater(code);
/*     */   }
/*     */ 
/*     */   private JComboBox getJComboBox()
/*     */   {
/* 225 */     if (this.jComboBox == null) {
/* 226 */       String[] choixTraitement = { "TOUS", "RENOUV", "TO90", "TO75", "TO50", "TO5", "TO10", "STOP" };
/* 227 */       this.jComboBox = new JComboBox(choixTraitement);
/* 228 */       this.jComboBox.addItemListener(new ItemListener() {
/*     */         public void itemStateChanged(ItemEvent e) {
/* 230 */           System.out.println("itemStateChanged()");
/* 231 */           int typeTraitement = FicheConsultationListe.this.jComboBox.getSelectedIndex();
/* 232 */           System.out.println("vous avez sélectionné : " + typeTraitement);
/* 233 */           if (typeTraitement == 0) {
/* 234 */             JPatientsTableModel model = new JPatientsTableModel();
/* 235 */             FicheConsultationListe.this.jTable.setModel(model);
/* 236 */             FicheConsultationListe.this.sorter = new TableRowSorter(model);
/* 237 */             FicheConsultationListe.this.jTable.getModel().addTableModelListener(new ListePatientListener());
/* 238 */           } else if (typeTraitement == 1) {
/* 239 */             JPatientsRenouvTableModel modelActif = new JPatientsRenouvTableModel();
/* 240 */             FicheConsultationListe.this.jTable.setModel(modelActif);
/* 241 */             FicheConsultationListe.this.sorter = new TableRowSorter(modelActif);
/* 242 */             FicheConsultationListe.this.jTable.getModel().addTableModelListener(new ListePatientListener());
/* 243 */           } else if (typeTraitement == 2) {
/* 244 */             JPatientsActifsTableModel modelActif = new JPatientsActifsTableModel();
/* 245 */             FicheConsultationListe.this.jTable.setModel(modelActif);
/* 246 */             FicheConsultationListe.this.sorter = new TableRowSorter(modelActif);
/* 247 */             FicheConsultationListe.this.jTable.getModel().addTableModelListener(new ListePatientListener());
/* 248 */           } else if (typeTraitement == 3) {
/* 249 */             JPatientsContentionTableModel modelContention = new JPatientsContentionTableModel();
/* 250 */             FicheConsultationListe.this.jTable.setModel(modelContention);
/* 251 */             FicheConsultationListe.this.sorter = new TableRowSorter(modelContention);
/* 252 */             FicheConsultationListe.this.jTable.getModel().addTableModelListener(new ListePatientListener());
/* 253 */           } else if (typeTraitement == 4) {
/* 254 */             JPatientsContention50TableModel modelContention50 = new JPatientsContention50TableModel();
/* 255 */             FicheConsultationListe.this.jTable.setModel(modelContention50);
/* 256 */             FicheConsultationListe.this.sorter = new TableRowSorter(modelContention50);
/* 257 */             FicheConsultationListe.this.jTable.getModel().addTableModelListener(new ListePatientListener());
/* 258 */           } else if (typeTraitement == 5) {
/* 259 */             JPatientsSurveillanceTableModel modelSurveillance = new JPatientsSurveillanceTableModel();
/* 260 */             FicheConsultationListe.this.jTable.setModel(modelSurveillance);
/* 261 */             FicheConsultationListe.this.sorter = new TableRowSorter(modelSurveillance);
/* 262 */             FicheConsultationListe.this.jTable.getModel().addTableModelListener(new ListePatientListener());
/* 263 */           } else if (typeTraitement == 6) {
/* 264 */             JPatientsSurveillanceTO10TableModel modelSurveillance = new JPatientsSurveillanceTO10TableModel();
/* 265 */             FicheConsultationListe.this.jTable.setModel(modelSurveillance);
/* 266 */             FicheConsultationListe.this.sorter = new TableRowSorter(modelSurveillance);
/* 267 */             FicheConsultationListe.this.jTable.getModel().addTableModelListener(new ListePatientListener());
/* 268 */           } else if (typeTraitement == 7) {
/* 269 */             JPatientsStopTableModel modelStop = new JPatientsStopTableModel();
/* 270 */             FicheConsultationListe.this.jTable.setModel(modelStop);
/* 271 */             FicheConsultationListe.this.sorter = new TableRowSorter(modelStop);
/* 272 */             FicheConsultationListe.this.jTable.getModel().addTableModelListener(new ListePatientListener());
/*     */           }
/* 274 */           FicheConsultationListe.this.jTable.setRowSorter(FicheConsultationListe.this.sorter);
/* 275 */           FicheConsultationListe.this.comboBox = new JComboBox(FicheConsultationListe.this.listeTraitement);
/* 276 */           FicheConsultationListe.this.jTable.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(FicheConsultationListe.this.comboBox));
/* 277 */           FicheConsultationListe.this.jTable.getColumnModel().getColumn(5).setCellEditor(new JDateChooserCellEditor());
/* 278 */           FicheConsultationListe.this.jTable.getColumnModel().getColumn(7).setCellEditor(new JDateChooserCellEditor());
/* 279 */           FicheConsultationListe.this.jTable.getColumnModel().getColumn(8).setCellEditor(new JDateChooserCellEditor());
/*     */         } } );
/*     */     }
/* 282 */     return this.jComboBox;
/*     */   }
/*     */ 
/*     */   private JPanel getJPanel1()
/*     */   {
/* 291 */     if (this.jPanel1 == null) {
/* 292 */       this.jPanel1 = new JPanel();
/* 293 */       this.jPanel1.setLayout(new GridBagLayout());
/*     */     }
/* 295 */     return this.jPanel1;
/*     */   }
/*     */ 
/*     */   private JPanel getJPanel2()
/*     */   {
/* 304 */     if (this.jPanel2 == null) {
/* 305 */       this.jPanel2 = new JPanel();
/* 306 */       this.jPanel2.setLayout(new GridBagLayout());
/*     */     }
/* 308 */     return this.jPanel2;
/*     */   }
/*     */ 
/*     */   private JPanel getJPanel3()
/*     */   {
/* 317 */     if (this.jPanel3 == null) {
/* 318 */       GridBagConstraints gridBagConstraints = new GridBagConstraints();
/* 319 */       gridBagConstraints.gridx = -1;
/* 320 */       gridBagConstraints.gridy = -1;
/* 321 */       this.jPanel3 = new JPanel();
/* 322 */       this.jPanel3.setLayout(new FlowLayout());
/* 323 */       this.jPanel3.add(getJButton1(), null);
/*     */     }
/* 325 */     return this.jPanel3;
/*     */   }
/*     */ 
/*     */   private JButton getJButton1()
/*     */   {
/* 334 */     if (this.jButton1 == null) {
/* 335 */       this.jButton1 = new JButton();
/* 336 */       this.jButton1.setText("Fermer");
/* 337 */       this.jButton1.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent e) {
/* 339 */           System.out.println("Quitter ..., Bye");
/* 340 */           System.exit(0);
/*     */         } } );
/*     */     }
/* 344 */     return this.jButton1;
/*     */   }
/*     */   private JButton getBtnNouveauPatient() {
/* 347 */     if (this.btnNouveauPatient == null) {
/* 348 */       this.btnNouveauPatient = new JButton("Nouv. Patient");
/* 349 */       this.btnNouveauPatient.addActionListener(new NouveauPatientActionListener(this));
/*     */     }
/*     */ 
/* 361 */     return this.btnNouveauPatient;
/*     */   }
/*     */ 
/*     */   private JButton getBtnModifierPatient() {
/* 365 */     if (this.btnModifierPatient == null) {
/* 366 */       this.btnModifierPatient = new JButton("Modif Patient");
/* 367 */       this.btnModifierPatient.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent arg0) {
/* 370 */           if (FicheConsultationListe.this.jTable.getSelectedRow() >= 0) {
/* 371 */             System.out.println("*****> jTable.getSelectedRow() : " + FicheConsultationListe.this.jTable.getSelectedRow());
/* 372 */             int modelIndex = FicheConsultationListe.this.jTable.convertRowIndexToModel(FicheConsultationListe.this.jTable.getSelectedRow());
/* 373 */             System.out.println("*****> modelIndex : " + modelIndex);
/* 374 */             int id_patient = Integer.parseInt((String)FicheConsultationListe.this.jTable.getModel().getValueAt(modelIndex, 0));
/* 375 */             System.out.println("Id_patient à charger : " + id_patient);
/* 376 */             FicheModification ficheModif = new FicheModification(id_patient);
/* 377 */             ficheModif.setVisible(true);
/* 378 */             ficheModif.setLocationRelativeTo(ficheModif.getParent());
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       });
/*     */     }
/*     */ 
/* 390 */     return this.btnModifierPatient;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 394 */     FicheConsultationListe mainClass = new FicheConsultationListe();
/*     */ 
/* 396 */     mainClass.setLocationRelativeTo(mainClass.getParent());
/*     */ 
/* 398 */     mainClass.setVisible(true);
/* 399 */     mainClass.setDefaultCloseOperation(3);
/*     */   }

/*     */   private JButton getBtnImprimer() {
/* 402 */     if (this.btnImprimer == null) {
/* 403 */       this.btnImprimer = new JButton("Imprimer");
/* 404 */       this.btnImprimer.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent arg0) {
/* 407 */           int modelIndex = FicheConsultationListe.this.jTable.convertRowIndexToModel(FicheConsultationListe.this.jTable.getSelectedRow());
/* 408 */           String typeTraitement = (String)FicheConsultationListe.this.jTable.getModel().getValueAt(modelIndex, 6);
/* 409 */           if (!"AUCUN".equals(typeTraitement)) {
/* 410 */             System.out.println("*****> modelIndex : " + modelIndex);
/* 411 */             int id_patient = Integer.parseInt((String)FicheConsultationListe.this.jTable.getModel().getValueAt(modelIndex, 0));
/* 412 */             String nom = (String)FicheConsultationListe.this.jTable.getModel().getValueAt(modelIndex, 1);
/* 413 */             String prenom = (String)FicheConsultationListe.this.jTable.getModel().getValueAt(modelIndex, 2);
/* 414 */             String DateCreation = (String)FicheConsultationListe.this.jTable.getModel().getValueAt(modelIndex, 4);
/* 415 */             ImpressionEntentes impEntente = new ImpressionEntentes();
/*     */             try {
/* 417 */               impEntente.getPDF(nom + "-" + prenom + "-" + DateCreation, id_patient, "orthodonfree_blanc.jrxml");
/* 418 */               impEntente.printPDF(nom + "-" + prenom + "-" + DateCreation, id_patient);
/*     */             }
/*     */             catch (IOException e) {
/* 421 */               e.printStackTrace();
/*     */             }
/*     */             catch (PrinterException e) {
/* 424 */               e.printStackTrace();
/*     */             }
/*     */           } else {
/* 427 */             JOptionPane.showMessageDialog(null, "Le patient n'a pas de traitement en cours (AUCUN)");
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       });
/*     */     }
/*     */ 
/* 441 */     return this.btnImprimer;
/*     */   }
/*     */   private JButton getBtnAperuEp() {
/* 444 */     if (this.btnAperuEp == null) {
/* 445 */       this.btnAperuEp = new JButton("Aperçu EP");
/* 446 */       this.btnAperuEp.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent arg0) {
/* 448 */           int modelIndex = FicheConsultationListe.this.jTable.convertRowIndexToModel(FicheConsultationListe.this.jTable.getSelectedRow());
/* 449 */           String typeTraitement = (String)FicheConsultationListe.this.jTable.getModel().getValueAt(modelIndex, 6);
/* 450 */           if (!"AUCUN".equals(typeTraitement)) {
/* 451 */             System.out.println("*****> modelIndex : " + modelIndex);
/* 452 */             int id_patient = Integer.parseInt((String)FicheConsultationListe.this.jTable.getModel().getValueAt(modelIndex, 0));
/* 453 */             String nom = (String)FicheConsultationListe.this.jTable.getModel().getValueAt(modelIndex, 1);
/* 454 */             String prenom = (String)FicheConsultationListe.this.jTable.getModel().getValueAt(modelIndex, 2);
/* 455 */             String DateCreation = (String)FicheConsultationListe.this.jTable.getModel().getValueAt(modelIndex, 4);
/* 456 */             ImpressionEntentes impEntente = new ImpressionEntentes();
/*     */             try {
/* 458 */               impEntente.getPDF(nom.trim().replace(" ", "-") + "-" + prenom.trim().replace(" ", "-") + "-" + DateCreation, id_patient, "orthodonfreeV1.jrxml");
/*     */             }
/*     */             catch (IOException e) {
/* 461 */               e.printStackTrace();
/*     */             }
/*     */             catch (PrinterException e) {
/* 464 */               e.printStackTrace();
/*     */             }
/*     */             try
/*     */             {
	 					Process p;
/* 468 */               String pdfReader = System.getProperty("pdf.reader");
/* 469 */               p = Runtime.getRuntime().exec(pdfReader + " ./report/" + nom.trim().replace(" ", "-") + "-" + prenom.trim().replace(" ", "-") + "-" + DateCreation + ".pdf");
/*     */             }
/*     */             catch (IOException e1)
/*     */             {
/*     */              
/* 472 */               e1.printStackTrace();
/*     */             }
/*     */           } else {
/* 475 */             JOptionPane.showMessageDialog(null, "Le patient n'a pas de traitement en cours (AUCUN)");
/*     */           }
/*     */         } } );
/*     */     }
/* 480 */     return this.btnAperuEp;
/*     */   }
/*     */   private JButton getBtnImportCeto() {
/* 483 */     if (this.btnImportCeto == null) {
/* 484 */       this.btnImportCeto = new JButton("Imp. CETO");
/* 485 */       this.btnImportCeto.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent arg0) {
/* 487 */           ImportCeto impceto = null;
/*     */           try {
/* 489 */             impceto = new ImportCeto();
/*     */           }
/*     */           catch (ClassNotFoundException e) {
/* 492 */             e.printStackTrace();
/*     */           }
/*     */           catch (SQLException e) {
/* 495 */             e.printStackTrace();
/*     */           }
/* 497 */           impceto.Import(FicheConsultationListe.this.jTable);
/*     */         } } );
/*     */     }
/* 501 */     return this.btnImportCeto;
/*     */   }
/*     */   private JTextField getTxtSearch() {
/* 504 */     if (this.txtSearch == null) {
/* 505 */       this.txtSearch = new JTextField();
/* 506 */       this.txtSearch.addKeyListener(new KeyAdapter()
/*     */       {
/*     */         public void keyPressed(KeyEvent arg0) {
/* 509 */           if (arg0.getKeyCode() == 10) {
/* 510 */             String text = FicheConsultationListe.this.txtSearch.getText();
/* 511 */             System.out.println("Filtre sur : " + text);
/*     */ 
/* 513 */             if (text.length() == 0)
/* 514 */               FicheConsultationListe.this.sorter.setRowFilter(null);
/*     */             else
/* 516 */               FicheConsultationListe.this.sorter.setRowFilter(RowFilter.regexFilter("\\A" + text.toUpperCase(), new int[0]));
/*     */           }
/*     */         }
/*     */       });
/* 521 */       this.txtSearch.setColumns(10);
/*     */     }
/* 523 */     return this.txtSearch;
/*     */   }
/*     */   private JLabel getLblFiltreSurLe() {
/* 526 */     if (this.lblFiltreSurLe == null) {
/* 527 */       this.lblFiltreSurLe = new JLabel("Filtre (Nom) : ");
/*     */     }
/* 529 */     return this.lblFiltreSurLe;
/*     */   }
/*     */   private JButton getBtnSupprimer() {
/* 532 */     if (this.btnSupprimer == null) {
/* 533 */       this.btnSupprimer = new JButton("Supprimer");
/* 534 */       this.btnSupprimer.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent arg0) {
/* 537 */           System.out.println("Demande de suppression du patient sélectionné");
/* 538 */           int modelIndex = FicheConsultationListe.this.jTable.convertRowIndexToModel(FicheConsultationListe.this.jTable.getSelectedRow());
/* 539 */           String idpatient = FicheConsultationListe.this.jTable.getModel().getValueAt(modelIndex, 0).toString();
/* 540 */           int reponse = JOptionPane.showConfirmDialog(null, "Attention vous allez supprimer le patient N° " + idpatient, "Suppression Patient", 2);
/* 541 */           if (reponse == 0) {
/* 542 */             FicheConsultationListe.this.dbconn.deletePatient(idpatient, "DeletePatient");
/*     */           }
/* 544 */           FicheConsultationListe.this.populateJtable();
/*     */         }
/*     */       });
/* 547 */       this.btnSupprimer.setForeground(Color.RED);
/*     */     }
/* 549 */     return this.btnSupprimer;
/*     */   }
/*     */   private JButton getBtnImportDsio() {
/* 552 */     if (this.btnImportDsio == null) {
/* 553 */       this.btnImportDsio = new JButton("Imp. DSIO");
/* 554 */       this.btnImportDsio.addActionListener(new ActionListener() {
/*     */         public void actionPerformed(ActionEvent arg0) {
/* 556 */           ImportDsio impdsio = null;
/*     */           try {
/* 558 */             impdsio = new ImportDsio();
/*     */           }
/*     */           catch (ClassNotFoundException e) {
/* 561 */             e.printStackTrace();
/*     */           }
/*     */           catch (SQLException e) {
/* 564 */             e.printStackTrace();
/*     */           }
/* 566 */           impdsio.Import(FicheConsultationListe.this.jTable);
/*     */         } } );
/*     */     }
/* 570 */     return this.btnImportDsio;
/*     */   }
/*     */   private JButton getBtnStatsActes() {
/* 573 */     if (this.btnStatsActes == null) {
/* 574 */       this.btnStatsActes = new JButton("Stats Actes");
/* 575 */       this.btnStatsActes.addActionListener(new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent arg0) {
/* 578 */           ImpressionEntentes impEntente = new ImpressionEntentes();
/* 579 */           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
/*     */ 
/* 581 */           String nom_report = "";
/* 582 */           nom_report = "stats_actes-" + sdf.format(new Date());
/*     */           try {
/* 584 */             impEntente.getPDF(nom_report, 0, "stats_code_acte.jrxml");
/*     */           }
/*     */           catch (IOException e) {
/* 587 */             e.printStackTrace();
/*     */           }
/*     */           catch (PrinterException e) {
/* 590 */             e.printStackTrace();
/*     */           }
/*     */           try
/*     */           {
/*     */             Process p;
/* 594 */             String pdfReader = System.getProperty("pdf.reader");
/* 595 */             System.out.println("cmd :$ " + pdfReader + " ./report/" + nom_report + ".pdf");
/* 596 */             p = Runtime.getRuntime().exec(pdfReader + " ./report/" + nom_report + ".pdf");
/*     */           }
/*     */           catch (IOException e1)
/*     */           {
/* 599 */             e1.printStackTrace();
/*     */           }
/*     */         } } );
/*     */     }
/* 604 */     return this.btnStatsActes;
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.FicheConsultationListe
 * JD-Core Version:    0.6.0
 */