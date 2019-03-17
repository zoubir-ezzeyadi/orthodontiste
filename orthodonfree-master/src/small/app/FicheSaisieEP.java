/*      */ package small.app;
/*      */ 
/*      */ import java.awt.BorderLayout;
/*      */ import java.awt.Container;
/*      */ import java.awt.FlowLayout;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridBagLayout;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Insets;
/*      */ import java.awt.SystemColor;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.io.PrintStream;
/*      */ import java.text.DateFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Date;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JCheckBox;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.UIManager;
/*      */ import small.data.Association;
/*      */ 
/*      */ public class FicheSaisieEP extends JFrame
/*      */ {
/*      */   private JPanel panel;
/*      */   private JPanel panel_1;
/*      */   private JTextField nomPrenom;
/*      */   private JTextField numSecu;
/*      */   private JTextField dateNaiss;
/*      */   private JTextField clesecu;
/*      */   private JPanel panel_2;
/*      */   private JLabel lblMettreUne;
/*      */   private JLabel lblNewLabel;
/*      */   private JLabel lblMettreUne_1;
/*      */   private JPanel panel_3;
/*      */   private JCheckBox chckbxDbutDeTraitement;
/*      */   private JCheckBox chckbxSurveillance;
/*      */   private JCheckBox chckbxSuiteSemectre;
/*      */   private JCheckBox chckbxContentionAnne;
/*      */   private JCheckBox chckbxAutres;
/*      */   private JLabel lblLesquels;
/*      */   private JTextField textField_4;
/*      */   private JTextField textField_5;
/*      */   private JTextField textField_6;
/*   50 */   private final JPanel panel_4 = new JPanel();
/*      */   private JLabel lblDiagnostic;
/*      */   private JLabel lbluniquementLorsDune;
/*      */   private JLabel lblAnomaliesBasales;
/*      */   private JLabel lblAnomaliesAlvolaires;
/*      */   private JPanel panel_5;
/*      */   private JLabel lblSensSagital;
/*      */   private JLabel lblSensTransversal;
/*      */   private JLabel lblSensVertical;
/*      */   private JLabel lblMaxilaire;
/*      */   private JLabel label_3;
/*      */   private JLabel label_4;
/*      */   private JLabel label_5;
/*      */   private JCheckBox chckbxPro;
/*      */   private JCheckBox chckbxEndo;
/*      */   private JCheckBox chckbxRetro;
/*      */   private JCheckBox chckbxExo;
/*      */   private JCheckBox chckbxHypodivergence;
/*      */   private JCheckBox checkBox;
/*      */   private JCheckBox checkBox_1;
/*      */   private JCheckBox checkBox_2;
/*      */   private JCheckBox checkBox_3;
/*      */   private JCheckBox chckbxHyperdivergence;
/*      */   private JCheckBox chckbxPro_1;
/*      */   private JCheckBox chckbxRetro_1;
/*      */   private JCheckBox chckbxSupraclusion;
/*      */   private JCheckBox chckbxRetro_2;
/*      */   private JCheckBox chckbxExo_1;
/*      */   private JCheckBox chckbxPro_2;
/*      */   private JCheckBox chckbxEndo_1;
/*      */   private JCheckBox chckbxRetro_3;
/*      */   private JCheckBox chckbxExo_2;
/*      */   private JCheckBox chckbxInfraclusion;
/*      */   private JPanel panel_6;
/*      */   private JLabel lblClasseDentaireMolaire;
/*      */   private JCheckBox chckbxDysharmonieDentomaxilaire;
/*      */   private JCheckBox chckbxDysharmonieDentodentaire;
/*      */   private JCheckBox chckbxCIi;
/*      */   private JCheckBox chckbxCIii;
/*      */   private JCheckBox chckbxCIiii;
/*      */   private JLabel lblClasseDentaireCanine;
/*      */   private JCheckBox chckbxCIii_1;
/*      */   private JCheckBox chckbxCIii_2;
/*      */   private JCheckBox chckbxCIiii_1;
/*      */   private JTextField textField_7;
/*      */   private JTextField textField_8;
/*      */   private JTextField textField_9;
/*      */   private JTextField textField_10;
/*      */   private JLabel lblA;
/*      */   private JTextField textField_11;
/*      */   private JLabel lblMalpositions;
/*      */   private JPanel panel_7;
/*      */   private JLabel lblOcclusionInverse;
/*      */   private JCheckBox chckbxDroite;
/*      */   private JCheckBox chckbxGauche;
/*      */   private JCheckBox chckbxAntrieure;
/*      */   private JLabel lblFacteursFonctionels;
/*      */   private JTextField textField_12;
/*      */   private JLabel lblPlanDeTraitement;
/*      */   private JTextArea textArea;
/*      */   private JLabel lblNewLabel_1;
/*      */   private JTextArea textArea_1;
/*      */   private JLabel lblDate;
/*      */   private JTextField textField_13;
/*      */   private JPanel panel_8;
/*      */   private JButton btnEnregistrer;
/*      */   private JButton btnAnnulerfermer;
/*  118 */   private int idPatient = 0;
/*  119 */   private ConnexionDB condb = null;
/*      */ 
/*      */   public FicheSaisieEP(int id_patient)
/*      */   {
/*  123 */     this.idPatient = id_patient;
/*  124 */     this.condb = new ConnexionDB();
/*      */ 
/*  126 */     Object[][] dataEP = this.condb.selectEPData("epdatabyidpatient", this.idPatient);
/*  127 */     if (dataEP[0][0] != null) {
/*  128 */       System.out.println("patient : " + dataEP[0][0].toString() + " " + dataEP[0][1].toString() + " - " + dataEP[0][2].toString());
/*      */     }
/*  130 */     getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  131 */     setBackground(UIManager.getColor("Button.background"));
/*  132 */     setTitle("OrthodonFree - Saisie Entente Préalable (Médecin)");
/*  133 */     getContentPane().setLayout(new BorderLayout(0, 0));
/*      */ 
/*  135 */     this.panel = new JPanel();
/*  136 */     this.panel.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  137 */     getContentPane().add(this.panel, "North");
/*  138 */     GridBagLayout gbl_panel = new GridBagLayout();
/*  139 */     gbl_panel.columnWidths = new int[] { 195, 114, 91, 127, 25, 36, 61, 61, 98 };
/*  140 */     gbl_panel.rowHeights = new int[] { 19, 19 };
/*  141 */     gbl_panel.columnWeights = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 4.9E-324D };
/*  142 */     gbl_panel.rowWeights = new double[] { 0.0D, 0.0D, 4.9E-324D };
/*  143 */     this.panel.setLayout(gbl_panel);
/*      */ 
/*  145 */     JLabel lblNomEtPrnom = new JLabel(" Nom et Prénom du Patient :");
/*  146 */     GridBagConstraints gbc_lblNomEtPrnom = new GridBagConstraints();
/*  147 */     gbc_lblNomEtPrnom.fill = 2;
/*  148 */     gbc_lblNomEtPrnom.insets = new Insets(0, 0, 5, 5);
/*  149 */     gbc_lblNomEtPrnom.gridx = 0;
/*  150 */     gbc_lblNomEtPrnom.gridy = 0;
/*  151 */     this.panel.add(lblNomEtPrnom, gbc_lblNomEtPrnom);
/*      */ 
/*  154 */     if (dataEP[0][0] != null)
/*  155 */       this.nomPrenom = new JTextField(dataEP[0][0].toString() + " " + dataEP[0][1].toString());
/*  156 */     else this.nomPrenom = new JTextField();
/*  157 */     this.nomPrenom.setForeground(SystemColor.activeCaption);
/*  158 */     this.nomPrenom.setEditable(false);
/*  159 */     this.nomPrenom.setColumns(10);
/*  160 */     GridBagConstraints gbc_textField = new GridBagConstraints();
/*  161 */     gbc_textField.gridwidth = 3;
/*  162 */     gbc_textField.fill = 2;
/*  163 */     gbc_textField.anchor = 11;
/*  164 */     gbc_textField.insets = new Insets(0, 0, 5, 5);
/*  165 */     gbc_textField.gridx = 2;
/*  166 */     gbc_textField.gridy = 0;
/*  167 */     this.panel.add(this.nomPrenom, gbc_textField);
/*      */ 
/*  169 */     JLabel lblDateDeNaissance = new JLabel(" Date de naissance :");
/*  170 */     GridBagConstraints gbc_lblDateDeNaissance = new GridBagConstraints();
/*  171 */     gbc_lblDateDeNaissance.fill = 2;
/*  172 */     gbc_lblDateDeNaissance.insets = new Insets(0, 0, 0, 5);
/*  173 */     gbc_lblDateDeNaissance.gridx = 0;
/*  174 */     gbc_lblDateDeNaissance.gridy = 1;
/*  175 */     this.panel.add(lblDateDeNaissance, gbc_lblDateDeNaissance);
/*  176 */     String valDateNaiss = "";
/*  177 */     if (dataEP[0][0] != null) {
/*  178 */       long monLong = Long.parseLong(dataEP[0][3].toString());
/*  179 */       Date datenais = new Date(monLong);
/*  180 */       DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
/*  181 */       valDateNaiss = df.format(datenais);
/*      */     }
/*  183 */     this.dateNaiss = new JTextField(valDateNaiss);
/*  184 */     this.dateNaiss.setForeground(SystemColor.activeCaption);
/*  185 */     this.dateNaiss.setEditable(false);
/*  186 */     this.dateNaiss.setColumns(10);
/*  187 */     GridBagConstraints gbc_textField_2 = new GridBagConstraints();
/*  188 */     gbc_textField_2.fill = 2;
/*  189 */     gbc_textField_2.anchor = 11;
/*  190 */     gbc_textField_2.insets = new Insets(0, 0, 0, 5);
/*  191 */     gbc_textField_2.gridx = 1;
/*  192 */     gbc_textField_2.gridy = 1;
/*  193 */     this.panel.add(this.dateNaiss, gbc_textField_2);
/*      */ 
/*  195 */     JLabel label_2 = new JLabel("N° immatriculation de l'assuré(e) :");
/*  196 */     GridBagConstraints gbc_label_2 = new GridBagConstraints();
/*  197 */     gbc_label_2.fill = 2;
/*  198 */     gbc_label_2.insets = new Insets(0, 0, 0, 5);
/*  199 */     gbc_label_2.gridx = 2;
/*  200 */     gbc_label_2.gridy = 1;
/*  201 */     this.panel.add(label_2, gbc_label_2);
/*      */ 
/*  203 */     if (dataEP[0][0] != null)
/*  204 */       this.numSecu = new JTextField(dataEP[0][2].toString());
/*  205 */     else this.numSecu = new JTextField();
/*  206 */     this.numSecu.setForeground(SystemColor.activeCaption);
/*  207 */     this.numSecu.setEditable(false);
/*  208 */     this.numSecu.setColumns(10);
/*  209 */     GridBagConstraints gbc_numSecu = new GridBagConstraints();
/*  210 */     gbc_numSecu.fill = 2;
/*  211 */     gbc_numSecu.anchor = 11;
/*  212 */     gbc_numSecu.insets = new Insets(0, 0, 0, 5);
/*  213 */     gbc_numSecu.gridx = 3;
/*  214 */     gbc_numSecu.gridy = 1;
/*  215 */     this.panel.add(this.numSecu, gbc_numSecu);
/*      */ 
/*  217 */     this.clesecu = new JTextField();
/*  218 */     this.clesecu.setForeground(SystemColor.activeCaption);
/*  219 */     this.clesecu.setEditable(false);
/*  220 */     this.clesecu.setColumns(10);
/*  221 */     GridBagConstraints gbc_clesecu = new GridBagConstraints();
/*  222 */     gbc_clesecu.insets = new Insets(0, 0, 0, 5);
/*  223 */     gbc_clesecu.fill = 2;
/*  224 */     gbc_clesecu.anchor = 11;
/*  225 */     gbc_clesecu.gridx = 5;
/*  226 */     gbc_clesecu.gridy = 1;
/*  227 */     this.panel.add(this.clesecu, gbc_clesecu);
/*      */ 
/*  229 */     this.panel_1 = new JPanel();
/*  230 */     this.panel_1.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  231 */     getContentPane().add(this.panel_1, "West");
/*  232 */     GridBagLayout gbl_panel_1 = new GridBagLayout();
/*  233 */     gbl_panel_1.columnWidths = new int[] { 855 };
/*  234 */     gbl_panel_1.rowHeights = new int[] { 64, 64, 64, 0, 0, 64 };
/*  235 */     gbl_panel_1.columnWeights = new double[] { 0.0D, 4.9E-324D };
/*  236 */     gbl_panel_1.rowWeights = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 4.9E-324D };
/*  237 */     this.panel_1.setLayout(gbl_panel_1);
/*      */ 
/*  239 */     this.panel_2 = new JPanel();
/*  240 */     this.panel_2.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  241 */     GridBagConstraints gbc_panel_2 = new GridBagConstraints();
/*  242 */     gbc_panel_2.fill = 1;
/*  243 */     gbc_panel_2.insets = new Insets(0, 0, 5, 0);
/*  244 */     gbc_panel_2.gridx = 0;
/*  245 */     gbc_panel_2.gridy = 0;
/*  246 */     this.panel_1.add(this.panel_2, gbc_panel_2);
/*  247 */     this.panel_2.setLayout(new GridLayout(1, 3, 0, 0));
/*      */ 
/*  249 */     this.lblMettreUne_1 = new JLabel(" (1) Mettre une croix dans la case concernée");
/*  250 */     this.lblMettreUne_1.setFont(new Font("Dialog", 1, 10));
/*  251 */     this.panel_2.add(this.lblMettreUne_1);
/*      */ 
/*  253 */     this.lblNewLabel = new JLabel("<html><center>RENSEIGNEMENTS MEDICAUX (1) <br>TRAITEMENT D'ORTHOPEDIE DENTO-FACIALE</center></html>");
/*  254 */     this.lblNewLabel.setEnabled(true);
/*  255 */     this.lblNewLabel.setHorizontalAlignment(0);
/*  256 */     this.panel_2.add(this.lblNewLabel);
/*      */ 
/*  258 */     this.lblMettreUne = new JLabel("");
/*  259 */     this.panel_2.add(this.lblMettreUne);
/*      */ 
/*  261 */     this.panel_3 = new JPanel();
/*  262 */     this.panel_3.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  263 */     GridBagConstraints gbc_panel_3 = new GridBagConstraints();
/*  264 */     gbc_panel_3.fill = 1;
/*  265 */     gbc_panel_3.insets = new Insets(0, 0, 5, 0);
/*  266 */     gbc_panel_3.gridx = 0;
/*  267 */     gbc_panel_3.gridy = 1;
/*  268 */     this.panel_1.add(this.panel_3, gbc_panel_3);
/*  269 */     GridBagLayout gbl_panel_3 = new GridBagLayout();
/*  270 */     gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 85, 64, 0, 0, 0, 121 };
/*  271 */     gbl_panel_3.rowHeights = new int[3];
/*  272 */     gbl_panel_3.columnWeights = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 4.9E-324D };
/*  273 */     gbl_panel_3.rowWeights = new double[] { 0.0D, 0.0D, 4.9E-324D };
/*  274 */     this.panel_3.setLayout(gbl_panel_3);
/*      */ 
/*  276 */     this.chckbxDbutDeTraitement = new JCheckBox("Début de traitement");
/*  277 */     this.chckbxDbutDeTraitement.setEnabled(false);
/*  278 */     this.chckbxDbutDeTraitement.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  279 */     GridBagConstraints gbc_chckbxDbutDeTraitement = new GridBagConstraints();
/*  280 */     gbc_chckbxDbutDeTraitement.insets = new Insets(0, 0, 5, 5);
/*  281 */     gbc_chckbxDbutDeTraitement.gridx = 0;
/*  282 */     gbc_chckbxDbutDeTraitement.gridy = 0;
/*  283 */     this.panel_3.add(this.chckbxDbutDeTraitement, gbc_chckbxDbutDeTraitement);
/*      */ 
/*  285 */     this.chckbxSuiteSemectre = new JCheckBox("Suite - semestre n°");
/*  286 */     this.chckbxSuiteSemectre.setEnabled(false);
/*  287 */     this.chckbxSuiteSemectre.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  288 */     GridBagConstraints gbc_chckbxSuiteSemectre = new GridBagConstraints();
/*  289 */     gbc_chckbxSuiteSemectre.anchor = 17;
/*  290 */     gbc_chckbxSuiteSemectre.insets = new Insets(0, 0, 5, 5);
/*  291 */     gbc_chckbxSuiteSemectre.gridx = 2;
/*  292 */     gbc_chckbxSuiteSemectre.gridy = 0;
/*  293 */     this.panel_3.add(this.chckbxSuiteSemectre, gbc_chckbxSuiteSemectre);
/*      */ 
/*  295 */     this.textField_5 = new JTextField();
/*  296 */     this.textField_5.setEditable(false);
/*  297 */     this.textField_5.setHorizontalAlignment(2);
/*  298 */     GridBagConstraints gbc_textField_5 = new GridBagConstraints();
/*  299 */     gbc_textField_5.fill = 2;
/*  300 */     gbc_textField_5.insets = new Insets(0, 0, 5, 5);
/*  301 */     gbc_textField_5.gridx = 3;
/*  302 */     gbc_textField_5.gridy = 0;
/*  303 */     this.panel_3.add(this.textField_5, gbc_textField_5);
/*  304 */     this.textField_5.setColumns(10);
/*      */ 
/*  306 */     this.chckbxAutres = new JCheckBox("Autres");
/*  307 */     this.chckbxAutres.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  308 */     GridBagConstraints gbc_chckbxAutres = new GridBagConstraints();
/*  309 */     gbc_chckbxAutres.insets = new Insets(0, 0, 5, 5);
/*  310 */     gbc_chckbxAutres.gridx = 7;
/*  311 */     gbc_chckbxAutres.gridy = 0;
/*  312 */     this.panel_3.add(this.chckbxAutres, gbc_chckbxAutres);
/*      */ 
/*  314 */     this.chckbxSurveillance = new JCheckBox("Surveillance");
/*  315 */     this.chckbxSurveillance.setEnabled(false);
/*  316 */     this.chckbxSurveillance.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  317 */     GridBagConstraints gbc_chckbxSurveillance = new GridBagConstraints();
/*  318 */     gbc_chckbxSurveillance.insets = new Insets(0, 0, 0, 5);
/*  319 */     gbc_chckbxSurveillance.anchor = 17;
/*  320 */     gbc_chckbxSurveillance.gridx = 0;
/*  321 */     gbc_chckbxSurveillance.gridy = 1;
/*  322 */     this.panel_3.add(this.chckbxSurveillance, gbc_chckbxSurveillance);
/*      */ 
/*  324 */     this.chckbxContentionAnne = new JCheckBox("Contention - année n°");
/*  325 */     this.chckbxContentionAnne.setEnabled(false);
/*  326 */     this.chckbxContentionAnne.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  327 */     GridBagConstraints gbc_chckbxContentionAnne = new GridBagConstraints();
/*  328 */     gbc_chckbxContentionAnne.insets = new Insets(0, 0, 0, 5);
/*  329 */     gbc_chckbxContentionAnne.anchor = 17;
/*  330 */     gbc_chckbxContentionAnne.gridx = 2;
/*  331 */     gbc_chckbxContentionAnne.gridy = 1;
/*  332 */     this.panel_3.add(this.chckbxContentionAnne, gbc_chckbxContentionAnne);
/*      */ 
/*  334 */     this.textField_6 = new JTextField();
/*  335 */     this.textField_6.setEditable(false);
/*  336 */     GridBagConstraints gbc_textField_6 = new GridBagConstraints();
/*  337 */     gbc_textField_6.anchor = 17;
/*  338 */     gbc_textField_6.insets = new Insets(0, 0, 0, 5);
/*  339 */     gbc_textField_6.gridx = 3;
/*  340 */     gbc_textField_6.gridy = 1;
/*  341 */     this.panel_3.add(this.textField_6, gbc_textField_6);
/*  342 */     this.textField_6.setColumns(10);
/*      */ 
/*  344 */     this.lblLesquels = new JLabel("lesquels");
/*  345 */     GridBagConstraints gbc_lblLesquels = new GridBagConstraints();
/*  346 */     gbc_lblLesquels.insets = new Insets(0, 0, 0, 5);
/*  347 */     gbc_lblLesquels.gridx = 7;
/*  348 */     gbc_lblLesquels.gridy = 1;
/*  349 */     this.panel_3.add(this.lblLesquels, gbc_lblLesquels);
/*      */ 
/*  351 */     this.textField_4 = new JTextField();
/*  352 */     GridBagConstraints gbc_textField_4 = new GridBagConstraints();
/*  353 */     gbc_textField_4.insets = new Insets(0, 0, 0, 5);
/*  354 */     gbc_textField_4.fill = 2;
/*  355 */     gbc_textField_4.gridx = 8;
/*  356 */     gbc_textField_4.gridy = 1;
/*  357 */     this.panel_3.add(this.textField_4, gbc_textField_4);
/*  358 */     this.textField_4.setColumns(10);
/*  359 */     this.panel_4.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  360 */     GridBagConstraints gbc_panel_4 = new GridBagConstraints();
/*  361 */     gbc_panel_4.fill = 1;
/*  362 */     gbc_panel_4.insets = new Insets(0, 0, 5, 0);
/*  363 */     gbc_panel_4.gridx = 0;
/*  364 */     gbc_panel_4.gridy = 2;
/*  365 */     this.panel_1.add(this.panel_4, gbc_panel_4);
/*  366 */     GridBagLayout gbl_panel_4 = new GridBagLayout();
/*  367 */     gbl_panel_4.columnWidths = new int[] { 0, 0, 0, 121, 183, 40, 40, 40, 0, 0, 158 };
/*  368 */     gbl_panel_4.rowHeights = new int[4];
/*  369 */     gbl_panel_4.columnWeights = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 4.9E-324D };
/*  370 */     gbl_panel_4.rowWeights = new double[] { 0.0D, 0.0D, 0.0D, 4.9E-324D };
/*  371 */     this.panel_4.setLayout(gbl_panel_4);
/*      */ 
/*  373 */     this.lblDiagnostic = new JLabel(" DIAGNOSTIC");
/*  374 */     GridBagConstraints gbc_lblDiagnostic = new GridBagConstraints();
/*  375 */     gbc_lblDiagnostic.insets = new Insets(0, 0, 5, 5);
/*  376 */     gbc_lblDiagnostic.gridx = 0;
/*  377 */     gbc_lblDiagnostic.gridy = 0;
/*  378 */     this.panel_4.add(this.lblDiagnostic, gbc_lblDiagnostic);
/*      */ 
/*  380 */     this.lbluniquementLorsDune = new JLabel("(uniquement lors d'une 1ère demande ou une réévaluation)");
/*  381 */     this.lbluniquementLorsDune.setFont(new Font("Dialog", 0, 10));
/*  382 */     GridBagConstraints gbc_lbluniquementLorsDune = new GridBagConstraints();
/*  383 */     gbc_lbluniquementLorsDune.gridwidth = 3;
/*  384 */     gbc_lbluniquementLorsDune.insets = new Insets(0, 0, 5, 5);
/*  385 */     gbc_lbluniquementLorsDune.gridx = 2;
/*  386 */     gbc_lbluniquementLorsDune.gridy = 0;
/*  387 */     this.panel_4.add(this.lbluniquementLorsDune, gbc_lbluniquementLorsDune);
/*      */ 
/*  389 */     this.lblAnomaliesBasales = new JLabel("Anomalie(s) basale(s) :");
/*  390 */     GridBagConstraints gbc_lblAnomaliesBasales = new GridBagConstraints();
/*  391 */     gbc_lblAnomaliesBasales.gridwidth = 2;
/*  392 */     gbc_lblAnomaliesBasales.insets = new Insets(0, 0, 5, 5);
/*  393 */     gbc_lblAnomaliesBasales.gridx = 3;
/*  394 */     gbc_lblAnomaliesBasales.gridy = 1;
/*  395 */     this.panel_4.add(this.lblAnomaliesBasales, gbc_lblAnomaliesBasales);
/*      */ 
/*  397 */     this.lblAnomaliesAlvolaires = new JLabel("Anomalie(s) alvéolaire(s) :");
/*  398 */     GridBagConstraints gbc_lblAnomaliesAlvolaires = new GridBagConstraints();
/*  399 */     gbc_lblAnomaliesAlvolaires.gridwidth = 2;
/*  400 */     gbc_lblAnomaliesAlvolaires.insets = new Insets(0, 0, 5, 5);
/*  401 */     gbc_lblAnomaliesAlvolaires.gridx = 9;
/*  402 */     gbc_lblAnomaliesAlvolaires.gridy = 1;
/*  403 */     this.panel_4.add(this.lblAnomaliesAlvolaires, gbc_lblAnomaliesAlvolaires);
/*      */ 
/*  405 */     this.label_3 = new JLabel("Maxilaire");
/*  406 */     GridBagConstraints gbc_label_3 = new GridBagConstraints();
/*  407 */     gbc_label_3.anchor = 13;
/*  408 */     gbc_label_3.insets = new Insets(0, 0, 0, 5);
/*  409 */     gbc_label_3.gridx = 3;
/*  410 */     gbc_label_3.gridy = 2;
/*  411 */     this.panel_4.add(this.label_3, gbc_label_3);
/*      */ 
/*  413 */     this.lblMaxilaire = new JLabel("Mandibulaire");
/*  414 */     GridBagConstraints gbc_lblMaxilaire = new GridBagConstraints();
/*  415 */     gbc_lblMaxilaire.anchor = 13;
/*  416 */     gbc_lblMaxilaire.insets = new Insets(0, 0, 0, 5);
/*  417 */     gbc_lblMaxilaire.gridx = 4;
/*  418 */     gbc_lblMaxilaire.gridy = 2;
/*  419 */     this.panel_4.add(this.lblMaxilaire, gbc_lblMaxilaire);
/*      */ 
/*  421 */     this.label_4 = new JLabel("Maxilaire");
/*  422 */     GridBagConstraints gbc_label_4 = new GridBagConstraints();
/*  423 */     gbc_label_4.insets = new Insets(0, 0, 0, 5);
/*  424 */     gbc_label_4.gridx = 9;
/*  425 */     gbc_label_4.gridy = 2;
/*  426 */     this.panel_4.add(this.label_4, gbc_label_4);
/*      */ 
/*  428 */     this.label_5 = new JLabel("Mandibulaire");
/*  429 */     GridBagConstraints gbc_label_5 = new GridBagConstraints();
/*  430 */     gbc_label_5.anchor = 13;
/*  431 */     gbc_label_5.insets = new Insets(0, 0, 0, 5);
/*  432 */     gbc_label_5.gridx = 10;
/*  433 */     gbc_label_5.gridy = 2;
/*  434 */     this.panel_4.add(this.label_5, gbc_label_5);
/*      */ 
/*  436 */     this.panel_5 = new JPanel();
/*  437 */     this.panel_5.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  438 */     GridBagConstraints gbc_panel_5 = new GridBagConstraints();
/*  439 */     gbc_panel_5.insets = new Insets(0, 0, 5, 0);
/*  440 */     gbc_panel_5.fill = 1;
/*  441 */     gbc_panel_5.gridx = 0;
/*  442 */     gbc_panel_5.gridy = 3;
/*  443 */     this.panel_1.add(this.panel_5, gbc_panel_5);
/*  444 */     GridBagLayout gbl_panel_5 = new GridBagLayout();
/*  445 */     gbl_panel_5.columnWidths = new int[] { 0, 0, 91, 0, 0, 0, 0, 50, 50 };
/*  446 */     gbl_panel_5.rowHeights = new int[4];
/*  447 */     gbl_panel_5.columnWeights = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 4.9E-324D };
/*  448 */     gbl_panel_5.rowWeights = new double[] { 0.0D, 0.0D, 0.0D, 4.9E-324D };
/*  449 */     this.panel_5.setLayout(gbl_panel_5);
/*      */ 
/*  451 */     this.lblSensSagital = new JLabel("Sens sagital");
/*  452 */     GridBagConstraints gbc_lblSensSagital = new GridBagConstraints();
/*  453 */     gbc_lblSensSagital.anchor = 17;
/*  454 */     gbc_lblSensSagital.insets = new Insets(0, 0, 5, 5);
/*  455 */     gbc_lblSensSagital.gridx = 1;
/*  456 */     gbc_lblSensSagital.gridy = 0;
/*  457 */     this.panel_5.add(this.lblSensSagital, gbc_lblSensSagital);
/*  458 */     int anBasMaxPro = 0;
/*  459 */     if (dataEP[0][12] != null) anBasMaxPro = Integer.parseInt(dataEP[0][12].toString());
/*  460 */     this.chckbxPro = new JCheckBox("Pro");
/*  461 */     if (anBasMaxPro == 1) this.chckbxPro.setSelected(true);
/*  462 */     this.chckbxPro.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  463 */     GridBagConstraints gbc_chckbxPro = new GridBagConstraints();
/*  464 */     gbc_chckbxPro.anchor = 17;
/*  465 */     gbc_chckbxPro.insets = new Insets(0, 0, 5, 5);
/*  466 */     gbc_chckbxPro.gridx = 2;
/*  467 */     gbc_chckbxPro.gridy = 0;
/*  468 */     this.panel_5.add(this.chckbxPro, gbc_chckbxPro);
/*      */ 
/*  470 */     int anBasMaxRetro = Integer.parseInt(dataEP[0][15].toString());
/*  471 */     this.chckbxRetro = new JCheckBox("Retro");
/*  472 */     if (anBasMaxRetro == 1) this.chckbxRetro.setSelected(true);
/*  473 */     this.chckbxRetro.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  474 */     GridBagConstraints gbc_chckbxRetro = new GridBagConstraints();
/*  475 */     gbc_chckbxRetro.anchor = 17;
/*  476 */     gbc_chckbxRetro.insets = new Insets(0, 0, 5, 5);
/*  477 */     gbc_chckbxRetro.gridx = 3;
/*  478 */     gbc_chckbxRetro.gridy = 0;
/*  479 */     this.panel_5.add(this.chckbxRetro, gbc_chckbxRetro);
/*      */ 
/*  481 */     int anBasManPro = Integer.parseInt(dataEP[0][17].toString());
/*  482 */     this.checkBox = new JCheckBox("Pro");
/*  483 */     if (anBasManPro == 1) this.checkBox.setSelected(true);
/*  484 */     this.checkBox.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  485 */     GridBagConstraints gbc_checkBox = new GridBagConstraints();
/*  486 */     gbc_checkBox.anchor = 17;
/*  487 */     gbc_checkBox.insets = new Insets(0, 0, 5, 5);
/*  488 */     gbc_checkBox.gridx = 5;
/*  489 */     gbc_checkBox.gridy = 0;
/*  490 */     this.panel_5.add(this.checkBox, gbc_checkBox);
/*      */ 
/*  492 */     int anBasManRetro = Integer.parseInt(dataEP[0][20].toString());
/*  493 */     this.checkBox_2 = new JCheckBox("Retro");
/*  494 */     if (anBasManRetro == 1) this.checkBox_2.setSelected(true);
/*  495 */     this.checkBox_2.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  496 */     GridBagConstraints gbc_checkBox_2 = new GridBagConstraints();
/*  497 */     gbc_checkBox_2.anchor = 17;
/*  498 */     gbc_checkBox_2.insets = new Insets(0, 0, 5, 5);
/*  499 */     gbc_checkBox_2.gridx = 6;
/*  500 */     gbc_checkBox_2.gridy = 0;
/*  501 */     this.panel_5.add(this.checkBox_2, gbc_checkBox_2);
/*      */ 
/*  503 */     int anAlvMaxPro = Integer.parseInt(dataEP[0][22].toString());
/*  504 */     this.chckbxPro_1 = new JCheckBox("Pro");
/*  505 */     if (anAlvMaxPro == 1) this.chckbxPro_1.setSelected(true);
/*  506 */     this.chckbxPro_1.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  507 */     GridBagConstraints gbc_chckbxPro_1 = new GridBagConstraints();
/*  508 */     gbc_chckbxPro_1.anchor = 17;
/*  509 */     gbc_chckbxPro_1.insets = new Insets(0, 0, 5, 5);
/*  510 */     gbc_chckbxPro_1.gridx = 9;
/*  511 */     gbc_chckbxPro_1.gridy = 0;
/*  512 */     this.panel_5.add(this.chckbxPro_1, gbc_chckbxPro_1);
/*      */ 
/*  514 */     int anAlvMaxRetro = Integer.parseInt(dataEP[0][25].toString());
/*  515 */     this.chckbxRetro_2 = new JCheckBox("Retro");
/*  516 */     if (anAlvMaxRetro == 1) this.chckbxRetro_2.setSelected(true);
/*  517 */     this.chckbxRetro_2.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  518 */     GridBagConstraints gbc_chckbxRetro_2 = new GridBagConstraints();
/*  519 */     gbc_chckbxRetro_2.anchor = 17;
/*  520 */     gbc_chckbxRetro_2.insets = new Insets(0, 0, 5, 5);
/*  521 */     gbc_chckbxRetro_2.gridx = 10;
/*  522 */     gbc_chckbxRetro_2.gridy = 0;
/*  523 */     this.panel_5.add(this.chckbxRetro_2, gbc_chckbxRetro_2);
/*      */ 
/*  525 */     int anAlvManPro = Integer.parseInt(dataEP[0][27].toString());
/*  526 */     this.chckbxPro_2 = new JCheckBox("Pro");
/*  527 */     if (anAlvManPro == 1) this.chckbxPro_2.setSelected(true);
/*  528 */     this.chckbxPro_2.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  529 */     GridBagConstraints gbc_chckbxPro_2 = new GridBagConstraints();
/*  530 */     gbc_chckbxPro_2.anchor = 17;
/*  531 */     gbc_chckbxPro_2.insets = new Insets(0, 0, 5, 5);
/*  532 */     gbc_chckbxPro_2.gridx = 12;
/*  533 */     gbc_chckbxPro_2.gridy = 0;
/*  534 */     this.panel_5.add(this.chckbxPro_2, gbc_chckbxPro_2);
/*      */ 
/*  536 */     int anAlvManRetro = Integer.parseInt(dataEP[0][30].toString());
/*  537 */     this.chckbxRetro_3 = new JCheckBox("Retro");
/*  538 */     if (anAlvManRetro == 1) this.chckbxRetro_3.setSelected(true);
/*  539 */     this.chckbxRetro_3.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  540 */     GridBagConstraints gbc_chckbxRetro_3 = new GridBagConstraints();
/*  541 */     gbc_chckbxRetro_3.anchor = 17;
/*  542 */     gbc_chckbxRetro_3.insets = new Insets(0, 0, 5, 5);
/*  543 */     gbc_chckbxRetro_3.gridx = 13;
/*  544 */     gbc_chckbxRetro_3.gridy = 0;
/*  545 */     this.panel_5.add(this.chckbxRetro_3, gbc_chckbxRetro_3);
/*      */ 
/*  547 */     this.lblSensTransversal = new JLabel("Sens transversal");
/*  548 */     GridBagConstraints gbc_lblSensTransversal = new GridBagConstraints();
/*  549 */     gbc_lblSensTransversal.insets = new Insets(0, 0, 5, 5);
/*  550 */     gbc_lblSensTransversal.anchor = 17;
/*  551 */     gbc_lblSensTransversal.gridx = 1;
/*  552 */     gbc_lblSensTransversal.gridy = 1;
/*  553 */     this.panel_5.add(this.lblSensTransversal, gbc_lblSensTransversal);
/*      */ 
/*  555 */     int anBasMaxEndo = Integer.parseInt(dataEP[0][13].toString());
/*  556 */     this.chckbxEndo = new JCheckBox("Endo");
/*  557 */     if (anBasMaxEndo == 1) this.chckbxEndo.setSelected(true);
/*  558 */     this.chckbxEndo.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  559 */     GridBagConstraints gbc_chckbxEndo = new GridBagConstraints();
/*  560 */     gbc_chckbxEndo.anchor = 17;
/*  561 */     gbc_chckbxEndo.insets = new Insets(0, 0, 5, 5);
/*  562 */     gbc_chckbxEndo.gridx = 2;
/*  563 */     gbc_chckbxEndo.gridy = 1;
/*  564 */     this.panel_5.add(this.chckbxEndo, gbc_chckbxEndo);
/*      */ 
/*  566 */     int anBasMaxExo = Integer.parseInt(dataEP[0][16].toString());
/*  567 */     this.chckbxExo = new JCheckBox("Exo");
/*  568 */     if (anBasMaxExo == 1) this.chckbxExo.setSelected(true);
/*  569 */     this.chckbxExo.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  570 */     GridBagConstraints gbc_chckbxExo = new GridBagConstraints();
/*  571 */     gbc_chckbxExo.anchor = 17;
/*  572 */     gbc_chckbxExo.insets = new Insets(0, 0, 5, 5);
/*  573 */     gbc_chckbxExo.gridx = 3;
/*  574 */     gbc_chckbxExo.gridy = 1;
/*  575 */     this.panel_5.add(this.chckbxExo, gbc_chckbxExo);
/*      */ 
/*  577 */     int anBasManEndo = Integer.parseInt(dataEP[0][18].toString());
/*  578 */     this.checkBox_1 = new JCheckBox("Endo");
/*  579 */     if (anBasManEndo == 1) this.checkBox_1.setSelected(true);
/*  580 */     this.checkBox_1.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  581 */     GridBagConstraints gbc_checkBox_1 = new GridBagConstraints();
/*  582 */     gbc_checkBox_1.anchor = 17;
/*  583 */     gbc_checkBox_1.insets = new Insets(0, 0, 5, 5);
/*  584 */     gbc_checkBox_1.gridx = 5;
/*  585 */     gbc_checkBox_1.gridy = 1;
/*  586 */     this.panel_5.add(this.checkBox_1, gbc_checkBox_1);
/*      */ 
/*  588 */     int anBasManExo = Integer.parseInt(dataEP[0][21].toString());
/*  589 */     this.checkBox_3 = new JCheckBox("Exo");
/*  590 */     if (anBasManExo == 1) this.checkBox_3.setSelected(true);
/*  591 */     this.checkBox_3.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  592 */     GridBagConstraints gbc_checkBox_3 = new GridBagConstraints();
/*  593 */     gbc_checkBox_3.anchor = 17;
/*  594 */     gbc_checkBox_3.insets = new Insets(0, 0, 5, 5);
/*  595 */     gbc_checkBox_3.gridx = 6;
/*  596 */     gbc_checkBox_3.gridy = 1;
/*  597 */     this.panel_5.add(this.checkBox_3, gbc_checkBox_3);
/*      */ 
/*  599 */     int anAlvMaxEndo = Integer.parseInt(dataEP[0][23].toString());
/*  600 */     this.chckbxRetro_1 = new JCheckBox("Endo");
/*  601 */     if (anAlvMaxEndo == 1) this.chckbxRetro_1.setSelected(true);
/*  602 */     this.chckbxRetro_1.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  603 */     GridBagConstraints gbc_chckbxRetro_1 = new GridBagConstraints();
/*  604 */     gbc_chckbxRetro_1.anchor = 17;
/*  605 */     gbc_chckbxRetro_1.insets = new Insets(0, 0, 5, 5);
/*  606 */     gbc_chckbxRetro_1.gridx = 9;
/*  607 */     gbc_chckbxRetro_1.gridy = 1;
/*  608 */     this.panel_5.add(this.chckbxRetro_1, gbc_chckbxRetro_1);
/*      */ 
/*  610 */     int anAlVMaxExo = Integer.parseInt(dataEP[0][26].toString());
/*  611 */     this.chckbxExo_1 = new JCheckBox("Exo");
/*  612 */     if (anAlVMaxExo == 1) this.chckbxExo_1.setSelected(true);
/*  613 */     this.chckbxExo_1.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  614 */     GridBagConstraints gbc_chckbxExo_1 = new GridBagConstraints();
/*  615 */     gbc_chckbxExo_1.anchor = 17;
/*  616 */     gbc_chckbxExo_1.insets = new Insets(0, 0, 5, 5);
/*  617 */     gbc_chckbxExo_1.gridx = 10;
/*  618 */     gbc_chckbxExo_1.gridy = 1;
/*  619 */     this.panel_5.add(this.chckbxExo_1, gbc_chckbxExo_1);
/*      */ 
/*  621 */     int anAlvManEndo = Integer.parseInt(dataEP[0][28].toString());
/*  622 */     this.chckbxEndo_1 = new JCheckBox("Endo");
/*  623 */     if (anAlvManEndo == 1) this.chckbxEndo_1.setSelected(true);
/*  624 */     this.chckbxEndo_1.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  625 */     GridBagConstraints gbc_chckbxEndo_1 = new GridBagConstraints();
/*  626 */     gbc_chckbxEndo_1.anchor = 17;
/*  627 */     gbc_chckbxEndo_1.insets = new Insets(0, 0, 5, 5);
/*  628 */     gbc_chckbxEndo_1.gridx = 12;
/*  629 */     gbc_chckbxEndo_1.gridy = 1;
/*  630 */     this.panel_5.add(this.chckbxEndo_1, gbc_chckbxEndo_1);
/*      */ 
/*  632 */     int anAlvManExo = Integer.parseInt(dataEP[0][31].toString());
/*  633 */     this.chckbxExo_2 = new JCheckBox("Exo");
/*  634 */     if (anAlvManExo == 1) this.chckbxExo_2.setSelected(true);
/*  635 */     this.chckbxExo_2.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  636 */     GridBagConstraints gbc_chckbxExo_2 = new GridBagConstraints();
/*  637 */     gbc_chckbxExo_2.anchor = 17;
/*  638 */     gbc_chckbxExo_2.insets = new Insets(0, 0, 5, 5);
/*  639 */     gbc_chckbxExo_2.gridx = 13;
/*  640 */     gbc_chckbxExo_2.gridy = 1;
/*  641 */     this.panel_5.add(this.chckbxExo_2, gbc_chckbxExo_2);
/*      */ 
/*  643 */     this.lblSensVertical = new JLabel("Sens vertical");
/*  644 */     GridBagConstraints gbc_lblSensVertical = new GridBagConstraints();
/*  645 */     gbc_lblSensVertical.insets = new Insets(0, 0, 0, 5);
/*  646 */     gbc_lblSensVertical.anchor = 17;
/*  647 */     gbc_lblSensVertical.gridx = 1;
/*  648 */     gbc_lblSensVertical.gridy = 2;
/*  649 */     this.panel_5.add(this.lblSensVertical, gbc_lblSensVertical);
/*      */ 
/*  651 */     int anBasMaxHypo = Integer.parseInt(dataEP[0][14].toString());
/*  652 */     this.chckbxHypodivergence = new JCheckBox("Hypodivergence");
/*  653 */     if (anBasMaxHypo == 1) this.chckbxHypodivergence.setSelected(true);
/*  654 */     this.chckbxHypodivergence.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  655 */     GridBagConstraints gbc_chckbxHypodivergence = new GridBagConstraints();
/*  656 */     gbc_chckbxHypodivergence.anchor = 17;
/*  657 */     gbc_chckbxHypodivergence.gridwidth = 2;
/*  658 */     gbc_chckbxHypodivergence.insets = new Insets(0, 0, 0, 5);
/*  659 */     gbc_chckbxHypodivergence.gridx = 2;
/*  660 */     gbc_chckbxHypodivergence.gridy = 2;
/*  661 */     this.panel_5.add(this.chckbxHypodivergence, gbc_chckbxHypodivergence);
/*      */ 
/*  663 */     int anBasManHyper = Integer.parseInt(dataEP[0][19].toString());
/*  664 */     this.chckbxHyperdivergence = new JCheckBox("Hyperdivergence");
/*  665 */     if (anBasManHyper == 1) this.chckbxHyperdivergence.setSelected(true);
/*  666 */     this.chckbxHyperdivergence.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  667 */     GridBagConstraints gbc_chckbxHyperdivergence = new GridBagConstraints();
/*  668 */     gbc_chckbxHyperdivergence.anchor = 17;
/*  669 */     gbc_chckbxHyperdivergence.gridwidth = 2;
/*  670 */     gbc_chckbxHyperdivergence.insets = new Insets(0, 0, 0, 5);
/*  671 */     gbc_chckbxHyperdivergence.gridx = 5;
/*  672 */     gbc_chckbxHyperdivergence.gridy = 2;
/*  673 */     this.panel_5.add(this.chckbxHyperdivergence, gbc_chckbxHyperdivergence);
/*      */ 
/*  675 */     int anAlvMaxSupra = Integer.parseInt(dataEP[0][24].toString());
/*  676 */     this.chckbxSupraclusion = new JCheckBox("Supraclusion");
/*  677 */     if (anAlvMaxSupra == 1) this.chckbxSupraclusion.setSelected(true);
/*  678 */     this.chckbxSupraclusion.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  679 */     GridBagConstraints gbc_chckbxSupraclusion = new GridBagConstraints();
/*  680 */     gbc_chckbxSupraclusion.anchor = 17;
/*  681 */     gbc_chckbxSupraclusion.gridwidth = 2;
/*  682 */     gbc_chckbxSupraclusion.insets = new Insets(0, 0, 0, 5);
/*  683 */     gbc_chckbxSupraclusion.gridx = 9;
/*  684 */     gbc_chckbxSupraclusion.gridy = 2;
/*  685 */     this.panel_5.add(this.chckbxSupraclusion, gbc_chckbxSupraclusion);
/*      */ 
/*  687 */     int anAlvManInfra = Integer.parseInt(dataEP[0][29].toString());
/*  688 */     this.chckbxInfraclusion = new JCheckBox("Infraclusion");
/*  689 */     if (anAlvManInfra == 1) this.chckbxInfraclusion.setSelected(true);
/*  690 */     this.chckbxInfraclusion.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  691 */     GridBagConstraints gbc_chckbxInfraclusion = new GridBagConstraints();
/*  692 */     gbc_chckbxInfraclusion.gridwidth = 2;
/*  693 */     gbc_chckbxInfraclusion.anchor = 17;
/*  694 */     gbc_chckbxInfraclusion.insets = new Insets(0, 0, 0, 5);
/*  695 */     gbc_chckbxInfraclusion.gridx = 12;
/*  696 */     gbc_chckbxInfraclusion.gridy = 2;
/*  697 */     this.panel_5.add(this.chckbxInfraclusion, gbc_chckbxInfraclusion);
/*      */ 
/*  699 */     this.panel_6 = new JPanel();
/*  700 */     this.panel_6.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  701 */     GridBagConstraints gbc_panel_6 = new GridBagConstraints();
/*  702 */     gbc_panel_6.insets = new Insets(0, 0, 5, 0);
/*  703 */     gbc_panel_6.fill = 1;
/*  704 */     gbc_panel_6.gridx = 0;
/*  705 */     gbc_panel_6.gridy = 4;
/*  706 */     this.panel_1.add(this.panel_6, gbc_panel_6);
/*  707 */     GridBagLayout gbl_panel_6 = new GridBagLayout();
/*  708 */     gbl_panel_6.columnWidths = new int[] { 0, 110, 48, 0, 0, 104, 0, 46, 52, 0, 102 };
/*  709 */     gbl_panel_6.rowHeights = new int[4];
/*  710 */     gbl_panel_6.columnWeights = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 4.9E-324D };
/*  711 */     gbl_panel_6.rowWeights = new double[] { 0.0D, 0.0D, 0.0D, 4.9E-324D };
/*  712 */     this.panel_6.setLayout(gbl_panel_6);
/*      */ 
/*  714 */     this.lblClasseDentaireMolaire = new JLabel(" Classe dentaire molaire");
/*  715 */     GridBagConstraints gbc_lblClasseDentaireMolaire = new GridBagConstraints();
/*  716 */     gbc_lblClasseDentaireMolaire.gridwidth = 2;
/*  717 */     gbc_lblClasseDentaireMolaire.insets = new Insets(0, 0, 5, 5);
/*  718 */     gbc_lblClasseDentaireMolaire.gridx = 0;
/*  719 */     gbc_lblClasseDentaireMolaire.gridy = 0;
/*  720 */     this.panel_6.add(this.lblClasseDentaireMolaire, gbc_lblClasseDentaireMolaire);
/*      */ 
/*  723 */     int cdmCI_I = Integer.parseInt(dataEP[0][32].toString());
/*  724 */     this.chckbxCIi = new JCheckBox("CI.I");
/*  725 */     if (cdmCI_I == 1) this.chckbxCIi.setSelected(true);
/*  726 */     this.chckbxCIi.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  727 */     GridBagConstraints gbc_chckbxCIi = new GridBagConstraints();
/*  728 */     gbc_chckbxCIi.insets = new Insets(0, 0, 5, 5);
/*  729 */     gbc_chckbxCIi.gridx = 2;
/*  730 */     gbc_chckbxCIi.gridy = 0;
/*  731 */     this.panel_6.add(this.chckbxCIi, gbc_chckbxCIi);
/*      */ 
/*  733 */     int cdmCI_II = Integer.parseInt(dataEP[0][33].toString());
/*  734 */     this.chckbxCIii = new JCheckBox("CI.II");
/*  735 */     if (cdmCI_II == 1) this.chckbxCIii.setSelected(true);
/*  736 */     this.chckbxCIii.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  737 */     GridBagConstraints gbc_chckbxCIii = new GridBagConstraints();
/*  738 */     gbc_chckbxCIii.insets = new Insets(0, 0, 5, 5);
/*  739 */     gbc_chckbxCIii.gridx = 3;
/*  740 */     gbc_chckbxCIii.gridy = 0;
/*  741 */     this.panel_6.add(this.chckbxCIii, gbc_chckbxCIii);
/*      */ 
/*  743 */     int cdmCI_III = Integer.parseInt(dataEP[0][34].toString());
/*  744 */     this.chckbxCIiii = new JCheckBox("CI.III");
/*  745 */     if (cdmCI_III == 1) this.chckbxCIiii.setSelected(true);
/*  746 */     this.chckbxCIiii.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  747 */     GridBagConstraints gbc_chckbxCIiii = new GridBagConstraints();
/*  748 */     gbc_chckbxCIiii.insets = new Insets(0, 0, 5, 5);
/*  749 */     gbc_chckbxCIiii.gridx = 4;
/*  750 */     gbc_chckbxCIiii.gridy = 0;
/*  751 */     this.panel_6.add(this.chckbxCIiii, gbc_chckbxCIiii);
/*      */ 
/*  754 */     String cdmtxt = "";
/*  755 */     if (dataEP[0][35] != null) cdmtxt = dataEP[0][35].toString();
/*  756 */     this.textField_8 = new JTextField(cdmtxt);
/*  757 */     GridBagConstraints gbc_textField_8 = new GridBagConstraints();
/*  758 */     gbc_textField_8.fill = 2;
/*  759 */     gbc_textField_8.insets = new Insets(0, 0, 5, 5);
/*  760 */     gbc_textField_8.gridx = 5;
/*  761 */     gbc_textField_8.gridy = 0;
/*  762 */     this.panel_6.add(this.textField_8, gbc_textField_8);
/*  763 */     this.textField_8.setColumns(8);
/*      */ 
/*  765 */     this.lblClasseDentaireCanine = new JLabel("Classe dentaire canine");
/*  766 */     GridBagConstraints gbc_lblClasseDentaireCanine = new GridBagConstraints();
/*  767 */     gbc_lblClasseDentaireCanine.insets = new Insets(0, 0, 5, 5);
/*  768 */     gbc_lblClasseDentaireCanine.gridx = 6;
/*  769 */     gbc_lblClasseDentaireCanine.gridy = 0;
/*  770 */     this.panel_6.add(this.lblClasseDentaireCanine, gbc_lblClasseDentaireCanine);
/*      */ 
/*  772 */     int cdcCI_I = Integer.parseInt(dataEP[0][36].toString());
/*  773 */     this.chckbxCIii_1 = new JCheckBox("CI.I");
/*  774 */     if (cdcCI_I == 1) this.chckbxCIii_1.setSelected(true);
/*  775 */     this.chckbxCIii_1.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  776 */     GridBagConstraints gbc_chckbxCIii_1 = new GridBagConstraints();
/*  777 */     gbc_chckbxCIii_1.insets = new Insets(0, 0, 5, 5);
/*  778 */     gbc_chckbxCIii_1.gridx = 7;
/*  779 */     gbc_chckbxCIii_1.gridy = 0;
/*  780 */     this.panel_6.add(this.chckbxCIii_1, gbc_chckbxCIii_1);
/*      */ 
/*  782 */     int cdcCI_II = Integer.parseInt(dataEP[0][37].toString());
/*  783 */     this.chckbxCIii_2 = new JCheckBox("CI.II");
/*  784 */     if (cdcCI_II == 1) this.chckbxCIii_2.setSelected(true);
/*  785 */     this.chckbxCIii_2.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  786 */     GridBagConstraints gbc_chckbxCIii_2 = new GridBagConstraints();
/*  787 */     gbc_chckbxCIii_2.insets = new Insets(0, 0, 5, 5);
/*  788 */     gbc_chckbxCIii_2.gridx = 8;
/*  789 */     gbc_chckbxCIii_2.gridy = 0;
/*  790 */     this.panel_6.add(this.chckbxCIii_2, gbc_chckbxCIii_2);
/*      */ 
/*  792 */     int cdcCI_III = Integer.parseInt(dataEP[0][38].toString());
/*  793 */     this.chckbxCIiii_1 = new JCheckBox("CI.III");
/*  794 */     if (cdcCI_III == 1) this.chckbxCIiii_1.setSelected(true);
/*  795 */     this.chckbxCIiii_1.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  796 */     GridBagConstraints gbc_chckbxCIiii_1 = new GridBagConstraints();
/*  797 */     gbc_chckbxCIiii_1.insets = new Insets(0, 0, 5, 5);
/*  798 */     gbc_chckbxCIiii_1.gridx = 9;
/*  799 */     gbc_chckbxCIiii_1.gridy = 0;
/*  800 */     this.panel_6.add(this.chckbxCIiii_1, gbc_chckbxCIiii_1);
/*      */ 
/*  803 */     String cdctxt = "";
/*  804 */     if (dataEP[0][39] != null) cdctxt = dataEP[0][39].toString();
/*  805 */     this.textField_7 = new JTextField(cdctxt);
/*  806 */     GridBagConstraints gbc_textField_7 = new GridBagConstraints();
/*  807 */     gbc_textField_7.anchor = 17;
/*  808 */     gbc_textField_7.insets = new Insets(0, 0, 5, 0);
/*  809 */     gbc_textField_7.gridx = 10;
/*  810 */     gbc_textField_7.gridy = 0;
/*  811 */     this.panel_6.add(this.textField_7, gbc_textField_7);
/*  812 */     this.textField_7.setColumns(10);
/*      */ 
/*  814 */     int dysDentMax = Integer.parseInt(dataEP[0][40].toString());
/*  815 */     this.chckbxDysharmonieDentomaxilaire = new JCheckBox("Dysharmonie dento-maxilaire");
/*  816 */     if (dysDentMax == 1) this.chckbxDysharmonieDentomaxilaire.setSelected(true);
/*  817 */     this.chckbxDysharmonieDentomaxilaire.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  818 */     GridBagConstraints gbc_chckbxDysharmonieDentomaxilaire = new GridBagConstraints();
/*  819 */     gbc_chckbxDysharmonieDentomaxilaire.insets = new Insets(0, 0, 5, 5);
/*  820 */     gbc_chckbxDysharmonieDentomaxilaire.gridwidth = 3;
/*  821 */     gbc_chckbxDysharmonieDentomaxilaire.gridx = 0;
/*  822 */     gbc_chckbxDysharmonieDentomaxilaire.gridy = 1;
/*  823 */     this.panel_6.add(this.chckbxDysharmonieDentomaxilaire, gbc_chckbxDysharmonieDentomaxilaire);
/*      */ 
/*  825 */     int dysDentDent = Integer.parseInt(dataEP[0][41].toString());
/*  826 */     this.chckbxDysharmonieDentodentaire = new JCheckBox("Dysharmonie dento-dentaire");
/*  827 */     if (dysDentDent == 1) this.chckbxDysharmonieDentodentaire.setSelected(true);
/*  828 */     this.chckbxDysharmonieDentodentaire.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  829 */     GridBagConstraints gbc_chckbxDysharmonieDentodentaire = new GridBagConstraints();
/*  830 */     gbc_chckbxDysharmonieDentodentaire.gridwidth = 3;
/*  831 */     gbc_chckbxDysharmonieDentodentaire.insets = new Insets(0, 0, 5, 5);
/*  832 */     gbc_chckbxDysharmonieDentodentaire.gridx = 6;
/*  833 */     gbc_chckbxDysharmonieDentodentaire.gridy = 1;
/*  834 */     this.panel_6.add(this.chckbxDysharmonieDentodentaire, gbc_chckbxDysharmonieDentodentaire);
/*      */ 
/*  837 */     JLabel lblAgnsies = new JLabel("Agénésie(s)");
/*  838 */     GridBagConstraints gbc_lblAgnsies = new GridBagConstraints();
/*  839 */     gbc_lblAgnsies.anchor = 17;
/*  840 */     gbc_lblAgnsies.insets = new Insets(0, 0, 0, 5);
/*  841 */     gbc_lblAgnsies.gridx = 0;
/*  842 */     gbc_lblAgnsies.gridy = 2;
/*  843 */     this.panel_6.add(lblAgnsies, gbc_lblAgnsies);
/*      */ 
/*  845 */     String agnesie = "";
/*  846 */     if (dataEP[0][42] != null) agnesie = dataEP[0][42].toString();
/*  847 */     this.textField_9 = new JTextField(agnesie);
/*  848 */     GridBagConstraints gbc_textField_9 = new GridBagConstraints();
/*  849 */     gbc_textField_9.anchor = 17;
/*  850 */     gbc_textField_9.insets = new Insets(0, 0, 0, 5);
/*  851 */     gbc_textField_9.gridx = 1;
/*  852 */     gbc_textField_9.gridy = 2;
/*  853 */     this.panel_6.add(this.textField_9, gbc_textField_9);
/*  854 */     this.textField_9.setColumns(10);
/*      */ 
/*  856 */     this.lblA = new JLabel("Dent(s) incl. ou Surnum.");
/*  857 */     GridBagConstraints gbc_lblA = new GridBagConstraints();
/*  858 */     gbc_lblA.anchor = 13;
/*  859 */     gbc_lblA.gridwidth = 3;
/*  860 */     gbc_lblA.insets = new Insets(0, 0, 0, 5);
/*  861 */     gbc_lblA.gridx = 2;
/*  862 */     gbc_lblA.gridy = 2;
/*  863 */     this.panel_6.add(this.lblA, gbc_lblA);
/*      */ 
/*  865 */     String DentInclSurnum = "";
/*  866 */     if (dataEP[0][43] != null) DentInclSurnum = dataEP[0][43].toString();
/*  867 */     this.textField_10 = new JTextField(DentInclSurnum);
/*  868 */     GridBagConstraints gbc_textField_10 = new GridBagConstraints();
/*  869 */     gbc_textField_10.insets = new Insets(0, 0, 0, 5);
/*  870 */     gbc_textField_10.fill = 2;
/*  871 */     gbc_textField_10.gridx = 5;
/*  872 */     gbc_textField_10.gridy = 2;
/*  873 */     this.panel_6.add(this.textField_10, gbc_textField_10);
/*  874 */     this.textField_10.setColumns(10);
/*      */ 
/*  876 */     this.lblMalpositions = new JLabel("Malposition(s)");
/*  877 */     GridBagConstraints gbc_lblMalpositions = new GridBagConstraints();
/*  878 */     gbc_lblMalpositions.anchor = 13;
/*  879 */     gbc_lblMalpositions.insets = new Insets(0, 0, 0, 5);
/*  880 */     gbc_lblMalpositions.gridx = 6;
/*  881 */     gbc_lblMalpositions.gridy = 2;
/*  882 */     this.panel_6.add(this.lblMalpositions, gbc_lblMalpositions);
/*      */ 
/*  884 */     String malPosition = "";
/*  885 */     if (dataEP[0][44] != null) malPosition = dataEP[0][44].toString();
/*  886 */     this.textField_11 = new JTextField(malPosition);
/*  887 */     GridBagConstraints gbc_textField_11 = new GridBagConstraints();
/*  888 */     gbc_textField_11.insets = new Insets(0, 0, 0, 5);
/*  889 */     gbc_textField_11.gridwidth = 2;
/*  890 */     gbc_textField_11.fill = 2;
/*  891 */     gbc_textField_11.gridx = 7;
/*  892 */     gbc_textField_11.gridy = 2;
/*  893 */     this.panel_6.add(this.textField_11, gbc_textField_11);
/*  894 */     this.textField_11.setColumns(10);
/*      */ 
/*  896 */     this.panel_7 = new JPanel();
/*  897 */     this.panel_7.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  898 */     GridBagConstraints gbc_panel_7 = new GridBagConstraints();
/*  899 */     gbc_panel_7.insets = new Insets(0, 0, 5, 0);
/*  900 */     gbc_panel_7.fill = 1;
/*  901 */     gbc_panel_7.gridx = 0;
/*  902 */     gbc_panel_7.gridy = 5;
/*  903 */     this.panel_1.add(this.panel_7, gbc_panel_7);
/*  904 */     GridBagLayout gbl_panel_7 = new GridBagLayout();
/*  905 */     gbl_panel_7.columnWidths = new int[] { 0, 0, 87, 109, 0, 111, 0, 132, 116, 172 };
/*  906 */     gbl_panel_7.rowHeights = new int[] { 0, 0, 0, 0, 37, 0, 33 };
/*  907 */     gbl_panel_7.columnWeights = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
/*  908 */     gbl_panel_7.rowWeights = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 4.9E-324D };
/*  909 */     this.panel_7.setLayout(gbl_panel_7);
/*      */ 
/*  911 */     this.lblOcclusionInverse = new JLabel("Occlusion inversée");
/*  912 */     GridBagConstraints gbc_lblOcclusionInverse = new GridBagConstraints();
/*  913 */     gbc_lblOcclusionInverse.insets = new Insets(0, 0, 5, 5);
/*  914 */     gbc_lblOcclusionInverse.gridx = 1;
/*  915 */     gbc_lblOcclusionInverse.gridy = 0;
/*  916 */     this.panel_7.add(this.lblOcclusionInverse, gbc_lblOcclusionInverse);
/*      */ 
/*  918 */     int droite = 0;
/*  919 */     if (dataEP[0][45] != null) droite = Integer.parseInt(dataEP[0][45].toString());
/*  920 */     this.chckbxDroite = new JCheckBox("Droite");
/*  921 */     if (droite == 1) this.chckbxDroite.setSelected(true);
/*  922 */     this.chckbxDroite.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  923 */     GridBagConstraints gbc_chckbxDroite = new GridBagConstraints();
/*  924 */     gbc_chckbxDroite.insets = new Insets(0, 0, 5, 5);
/*  925 */     gbc_chckbxDroite.gridx = 3;
/*  926 */     gbc_chckbxDroite.gridy = 0;
/*  927 */     this.panel_7.add(this.chckbxDroite, gbc_chckbxDroite);
/*      */ 
/*  929 */     int gauche = 0;
/*  930 */     if (dataEP[0][46] != null) gauche = Integer.parseInt(dataEP[0][46].toString());
/*  931 */     this.chckbxGauche = new JCheckBox("Gauche");
/*  932 */     if (gauche == 1) this.chckbxGauche.setSelected(true);
/*  933 */     this.chckbxGauche.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  934 */     GridBagConstraints gbc_chckbxGauche = new GridBagConstraints();
/*  935 */     gbc_chckbxGauche.insets = new Insets(0, 0, 5, 5);
/*  936 */     gbc_chckbxGauche.gridx = 5;
/*  937 */     gbc_chckbxGauche.gridy = 0;
/*  938 */     this.panel_7.add(this.chckbxGauche, gbc_chckbxGauche);
/*      */ 
/*  940 */     int anterieur = 0;
/*  941 */     if (dataEP[0][47] != null) anterieur = Integer.parseInt(dataEP[0][47].toString());
/*  942 */     this.chckbxAntrieure = new JCheckBox("Antérieure");
/*  943 */     if (anterieur == 1) this.chckbxAntrieure.setSelected(true);
/*  944 */     this.chckbxAntrieure.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
/*  945 */     GridBagConstraints gbc_chckbxAntrieure = new GridBagConstraints();
/*  946 */     gbc_chckbxAntrieure.insets = new Insets(0, 0, 5, 5);
/*  947 */     gbc_chckbxAntrieure.gridx = 7;
/*  948 */     gbc_chckbxAntrieure.gridy = 0;
/*  949 */     this.panel_7.add(this.chckbxAntrieure, gbc_chckbxAntrieure);
/*      */ 
/*  951 */     this.lblFacteursFonctionels = new JLabel("Facteur(s) fonctionel(s)");
/*  952 */     GridBagConstraints gbc_lblFacteursFonctionels = new GridBagConstraints();
/*  953 */     gbc_lblFacteursFonctionels.insets = new Insets(0, 0, 5, 5);
/*  954 */     gbc_lblFacteursFonctionels.gridx = 1;
/*  955 */     gbc_lblFacteursFonctionels.gridy = 1;
/*  956 */     this.panel_7.add(this.lblFacteursFonctionels, gbc_lblFacteursFonctionels);
/*      */ 
/*  958 */     String facteurFonctionel = "";
/*  959 */     if (dataEP[0][48] != null) facteurFonctionel = dataEP[0][48].toString();
/*  960 */     this.textField_12 = new JTextField(facteurFonctionel);
/*  961 */     GridBagConstraints gbc_textField_12 = new GridBagConstraints();
/*  962 */     gbc_textField_12.insets = new Insets(0, 0, 5, 0);
/*  963 */     gbc_textField_12.gridwidth = 7;
/*  964 */     gbc_textField_12.fill = 2;
/*  965 */     gbc_textField_12.gridx = 3;
/*  966 */     gbc_textField_12.gridy = 1;
/*  967 */     this.panel_7.add(this.textField_12, gbc_textField_12);
/*  968 */     this.textField_12.setColumns(10);
/*      */ 
/*  970 */     this.lblPlanDeTraitement = new JLabel("PLAN DE TRAITEMENT (Y COMPRIS LES MOYENS THERAPEUTIQUES PREVUS) (uniquement lors d'une première demande ou d'une réévaluation)");
/*  971 */     this.lblPlanDeTraitement.setFont(new Font("Dialog", 1, 12));
/*  972 */     GridBagConstraints gbc_lblPlanDeTraitement = new GridBagConstraints();
/*  973 */     gbc_lblPlanDeTraitement.insets = new Insets(0, 0, 5, 0);
/*  974 */     gbc_lblPlanDeTraitement.anchor = 17;
/*  975 */     gbc_lblPlanDeTraitement.gridwidth = 10;
/*  976 */     gbc_lblPlanDeTraitement.gridx = 0;
/*  977 */     gbc_lblPlanDeTraitement.gridy = 2;
/*  978 */     this.panel_7.add(this.lblPlanDeTraitement, gbc_lblPlanDeTraitement);
/*      */ 
/*  980 */     String planTraitement = "";
/*  981 */     if (dataEP[0][49] != null) planTraitement = dataEP[0][49].toString();
/*  982 */     this.textArea = new JTextArea(planTraitement);
/*  983 */     this.textArea.setEditable(false);
/*  984 */     this.textArea.setRows(3);
/*  985 */     GridBagConstraints gbc_textArea = new GridBagConstraints();
/*  986 */     gbc_textArea.insets = new Insets(0, 0, 5, 0);
/*  987 */     gbc_textArea.gridheight = 2;
/*  988 */     gbc_textArea.gridwidth = 9;
/*  989 */     gbc_textArea.fill = 1;
/*  990 */     gbc_textArea.gridx = 1;
/*  991 */     gbc_textArea.gridy = 3;
/*  992 */     this.panel_7.add(this.textArea, gbc_textArea);
/*      */ 
/*  994 */     this.lblNewLabel_1 = new JLabel("COMMENTAIRES");
/*  995 */     GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
/*  996 */     gbc_lblNewLabel_1.anchor = 17;
/*  997 */     gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
/*  998 */     gbc_lblNewLabel_1.gridx = 1;
/*  999 */     gbc_lblNewLabel_1.gridy = 5;
/* 1000 */     this.panel_7.add(this.lblNewLabel_1, gbc_lblNewLabel_1);
/*      */ 
/* 1002 */     String commentaire = "";
/* 1003 */     if (dataEP[0][50] != null) commentaire = dataEP[0][50].toString();
/* 1004 */     this.textArea_1 = new JTextArea(commentaire);
/* 1005 */     GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
/* 1006 */     gbc_textArea_1.gridwidth = 9;
/* 1007 */     gbc_textArea_1.gridheight = 2;
/* 1008 */     gbc_textArea_1.insets = new Insets(0, 0, 5, 0);
/* 1009 */     gbc_textArea_1.fill = 1;
/* 1010 */     gbc_textArea_1.gridx = 1;
/* 1011 */     gbc_textArea_1.gridy = 6;
/* 1012 */     this.panel_7.add(this.textArea_1, gbc_textArea_1);
/*      */ 
/* 1014 */     this.lblDate = new JLabel("DATE :");
/* 1015 */     GridBagConstraints gbc_lblDate = new GridBagConstraints();
/* 1016 */     gbc_lblDate.anchor = 13;
/* 1017 */     gbc_lblDate.insets = new Insets(0, 0, 0, 5);
/* 1018 */     gbc_lblDate.gridx = 7;
/* 1019 */     gbc_lblDate.gridy = 8;
/* 1020 */     this.panel_7.add(this.lblDate, gbc_lblDate);
/*      */ 
/* 1022 */     String dateEP = "";
/* 1023 */     if (dataEP[0][51] != null) dateEP = dataEP[0][51].toString();
/* 1024 */     this.textField_13 = new JTextField(dateEP);
/* 1025 */     GridBagConstraints gbc_textField_13 = new GridBagConstraints();
/* 1026 */     gbc_textField_13.insets = new Insets(0, 0, 0, 5);
/* 1027 */     gbc_textField_13.fill = 2;
/* 1028 */     gbc_textField_13.gridx = 8;
/* 1029 */     gbc_textField_13.gridy = 8;
/* 1030 */     this.panel_7.add(this.textField_13, gbc_textField_13);
/* 1031 */     this.textField_13.setColumns(10);
/*      */ 
/* 1033 */     this.panel_8 = new JPanel();
/* 1034 */     GridBagConstraints gbc_panel_8 = new GridBagConstraints();
/* 1035 */     gbc_panel_8.fill = 1;
/* 1036 */     gbc_panel_8.gridx = 0;
/* 1037 */     gbc_panel_8.gridy = 6;
/* 1038 */     this.panel_1.add(this.panel_8, gbc_panel_8);
/* 1039 */     this.panel_8.setLayout(new FlowLayout(1, 5, 5));
/*      */ 
/* 1041 */     this.btnEnregistrer = new JButton("Enregistrer");
/* 1042 */     this.btnEnregistrer.addActionListener(new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent arg0)
/*      */       {
/* 1046 */         System.out.println("Préparer un Update avec idPatient = " + FicheSaisieEP.this.idPatient);
/* 1047 */         Association asso = new Association();
/* 1048 */         asso.setId_patient(FicheSaisieEP.this.idPatient);
/*      */ 
/* 1050 */         if (FicheSaisieEP.this.chckbxPro.isSelected()) asso.setAnBasMaxPro(1);
/* 1051 */         if (FicheSaisieEP.this.chckbxRetro.isSelected()) asso.setAnBasMaxRetro(1);
/* 1052 */         if (FicheSaisieEP.this.chckbxEndo.isSelected()) asso.setAnBasMaxEndo(1);
/* 1053 */         if (FicheSaisieEP.this.chckbxExo.isSelected()) asso.setAnBasMaxExo(1);
/* 1054 */         if (FicheSaisieEP.this.checkBox.isSelected()) asso.setAnBasManPro(1);
/* 1055 */         if (FicheSaisieEP.this.checkBox_1.isSelected()) asso.setAnBasManEndo(1);
/* 1056 */         if (FicheSaisieEP.this.checkBox_2.isSelected()) asso.setAnBasManRetro(1);
/* 1057 */         if (FicheSaisieEP.this.checkBox_3.isSelected()) asso.setAnBasManExo(1);
/* 1058 */         if (FicheSaisieEP.this.chckbxHypodivergence.isSelected()) asso.setAnBasMaxHypo(1);
/* 1059 */         if (FicheSaisieEP.this.chckbxHyperdivergence.isSelected()) asso.setAnBasManHyper(1);
/* 1060 */         if (FicheSaisieEP.this.chckbxPro_1.isSelected()) asso.setAnAlvMaxPro(1);
/* 1061 */         if (FicheSaisieEP.this.chckbxRetro_1.isSelected()) asso.setAnAlvMaxEndo(1);
/* 1062 */         if (FicheSaisieEP.this.chckbxRetro_2.isSelected()) asso.setAnAlvMaxRetro(1);
/* 1063 */         if (FicheSaisieEP.this.chckbxExo_1.isSelected()) asso.setAnAlvMaxExo(1);
/* 1064 */         if (FicheSaisieEP.this.chckbxPro_2.isSelected()) asso.setAnAlvManPro(1);
/* 1065 */         if (FicheSaisieEP.this.chckbxRetro_3.isSelected()) asso.setAnAlvManRetro(1);
/* 1066 */         if (FicheSaisieEP.this.chckbxEndo_1.isSelected()) asso.setAnAlvManEndo(1);
/* 1067 */         if (FicheSaisieEP.this.chckbxExo_2.isSelected()) asso.setAnAlvManExo(1);
/* 1068 */         if (FicheSaisieEP.this.chckbxSupraclusion.isSelected()) asso.setAnAlvMaxSupra(1);
/* 1069 */         if (FicheSaisieEP.this.chckbxInfraclusion.isSelected()) asso.setAnAlvManInfra(1);
/*      */ 
/* 1071 */         if (FicheSaisieEP.this.chckbxCIi.isSelected()) asso.setCdmCI_I(1);
/* 1072 */         if (FicheSaisieEP.this.chckbxCIii.isSelected()) asso.setCdmCI_II(1);
/* 1073 */         if (FicheSaisieEP.this.chckbxCIiii.isSelected()) asso.setCdmCI_III(1);
/* 1074 */         asso.setCdmtxt(FicheSaisieEP.this.textField_8.getText());
/* 1075 */         if (FicheSaisieEP.this.chckbxCIii_1.isSelected()) asso.setCdcCI_I(1);
/* 1076 */         if (FicheSaisieEP.this.chckbxCIii_2.isSelected()) asso.setCdcCI_II(1);
/* 1077 */         if (FicheSaisieEP.this.chckbxCIiii_1.isSelected()) asso.setCdcCI_III(1);
/* 1078 */         asso.setCdctxt(FicheSaisieEP.this.textField_7.getText());
/*      */ 
/* 1080 */         if (FicheSaisieEP.this.chckbxDysharmonieDentomaxilaire.isSelected()) asso.setDysDentMax(1);
/* 1081 */         if (FicheSaisieEP.this.chckbxDysharmonieDentodentaire.isSelected()) asso.setDysDentDent(1);
/*      */ 
/* 1083 */         asso.setAgnesietxt(FicheSaisieEP.this.textField_9.getText());
/* 1084 */         asso.setDentInclSurnumtxt(FicheSaisieEP.this.textField_10.getText());
/* 1085 */         asso.setMalpositiontxt(FicheSaisieEP.this.textField_11.getText());
/*      */ 
/* 1087 */         if (FicheSaisieEP.this.chckbxDroite.isSelected()) asso.setOccInvDroite(1);
/* 1088 */         if (FicheSaisieEP.this.chckbxGauche.isSelected()) asso.setOccInvGauche(1);
/* 1089 */         if (FicheSaisieEP.this.chckbxAntrieure.isSelected()) asso.setOccInvAnt(1);
/*      */ 
/* 1091 */         asso.setFacteurFoncttxt(FicheSaisieEP.this.textField_12.getText());
/* 1092 */         asso.setPlanTraittxt(FicheSaisieEP.this.textArea.getText());
/* 1093 */         asso.setCommentaires(FicheSaisieEP.this.textArea_1.getText());
/* 1094 */         asso.setDateEP(FicheSaisieEP.this.textField_13.getText());
/*      */ 
/* 1096 */         FicheSaisieEP.this.condb.updateEpPojoByidPatient("UpdateEpPojobyidpatient", asso);
/*      */       }
/*      */     });
/* 1099 */     this.panel_8.add(this.btnEnregistrer);
/*      */ 
/* 1101 */     this.btnAnnulerfermer = new JButton("Annuler/Fermer");
/* 1102 */     this.btnAnnulerfermer.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent arg0) {
/* 1104 */         System.out.println("Fermeture Fiche Saisie EP");
/* 1105 */         FicheSaisieEP.this.setVisible(false);
/* 1106 */         FicheSaisieEP.this.dispose();
/*      */       }
/*      */     });
/* 1109 */     this.panel_8.add(this.btnAnnulerfermer);
/*      */ 
/* 1111 */     setSize(991, 701);
/*      */   }
/*      */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.FicheSaisieEP
 * JD-Core Version:    0.6.0
 */