/*    */ package small.app;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.text.DateFormat;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import javax.swing.JOptionPane;
/*    */ import javax.swing.event.TableModelEvent;
/*    */ import javax.swing.event.TableModelListener;
/*    */ import javax.swing.table.AbstractTableModel;
/*    */ 
/*    */ public class ListePatientListener
/*    */   implements TableModelListener
/*    */ {
/* 14 */   private String[] listeTraitement = { "AUCUN", "TO90", "TO75", "TO50", "TO5", "TO10", "STOP" };
/* 15 */   private ConnexionDB dbconn = null;
/* 16 */   private FicheConsultationListe ficheListe = null;
/*    */ 
/*    */   public ListePatientListener()
/*    */   {
/* 20 */     this.dbconn = new ConnexionDB();
/*    */   }
/*    */ 
/*    */   public ListePatientListener(FicheConsultationListe ficheListe)
/*    */   {
/* 25 */     this.dbconn = new ConnexionDB();
/* 26 */     this.ficheListe = ficheListe;
/*    */   }
/*    */ 
/*    */   public void tableChanged(TableModelEvent e) {
/* 30 */     int row = e.getFirstRow();
/* 31 */     int column = e.getColumn();
/*    */ 
/* 33 */     AbstractTableModel model = null;
/* 34 */     System.out.println("TableChanged : e.getSource() : " + e.getSource().toString());
/* 35 */     if (e.getSource().toString().startsWith("small.app.JPatientsTableModel")) {
/* 36 */       model = (JPatientsTableModel)e.getSource();
/*    */     }
/* 38 */     else if (e.getSource().toString().startsWith("small.app.JPatientsActifsTableModel")) {
/* 39 */       model = (JPatientsActifsTableModel)e.getSource();
/*    */     }
/* 41 */     else if (e.getSource().toString().startsWith("small.app.JPatientsContention50TableModel")) {
/* 42 */       model = (JPatientsContention50TableModel)e.getSource();
/*    */     }
/* 44 */     else if (e.getSource().toString().startsWith("small.app.JPatientsContentionTableModel")) {
/* 45 */       model = (JPatientsContentionTableModel)e.getSource();
/*    */     }
/* 47 */     else if (e.getSource().toString().startsWith("small.app.JPatientsSurveillanceTableModel")) {
/* 48 */       model = (JPatientsSurveillanceTableModel)e.getSource();
/*    */     }
/* 50 */     else if (e.getSource().toString().startsWith("small.app.JPatientsSurveillanceTO10TableModel")) {
/* 51 */       model = (JPatientsSurveillanceTO10TableModel)e.getSource();
/*    */     }
/* 53 */     else if (e.getSource().toString().startsWith("small.app.JPatientsStopTableModel")) {
/* 54 */       model = (JPatientsStopTableModel)e.getSource();
/*    */     }
/* 56 */     else if (e.getSource().toString().startsWith("small.app.JPatientsRenouvTableModel")) {
/* 57 */       model = (JPatientsRenouvTableModel)e.getSource();
/*    */     }
/* 59 */     String columnName = model.getColumnName(column);
/* 60 */     Object data = model.getValueAt(row, column);
/* 61 */     System.out.println("Colone '" + columnName + "', ligne " + row + " : newValue -> \"" + data + "\"");
/*    */ 
/* 64 */     if ("Date modification".equals(columnName)) {
/* 65 */       String[] valeurs = new String[2];
/*    */ 
/* 67 */       valeurs[0] = ((String)model.getValueAt(row, 0));
/* 68 */       valeurs[1] = data.toString();
/* 69 */       this.dbconn.updatePatients("UpdatePatientDateModif", valeurs);
/* 70 */       System.out.println("Maj DateModification sur table patients effectuée");
/*    */     }
/* 72 */     else if ("Type Traitement".equals(columnName))
/*    */     {
/* 82 */       String oldValue = (String)model.getValueAt(row, 6);
/* 83 */       String message = "Voulez créer un nouveau traitement pour ce patient ?";
/* 84 */       String title = "Nouvau Traitement ?";
/*    */ 
/* 86 */       int reply = JOptionPane.showConfirmDialog(this.ficheListe, message, title, 0);
/* 87 */       if (reply == 0)
/*    */       {
/* 89 */         DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
/* 90 */         Date maDate = new Date();
/* 91 */         String date = format.format(maDate);
/* 92 */         String[] valeurs = new String[4];
/*    */ 
/* 94 */         valeurs[0] = ((String)model.getValueAt(row, 0));
/*    */ 
/* 96 */         for (int i = 0; i < 7; i++) {
/* 97 */           if (this.listeTraitement[i].equals(data)) {
/* 98 */             valeurs[1] = String.valueOf(i);
/*    */           }
/*    */         }
/* 101 */         valeurs[2] = date;
/* 102 */         valeurs[3] = date;
/*    */ 
/* 106 */         String[] donnees = new String[2];
/*    */ 
/* 108 */         donnees[0] = ((String)model.getValueAt(row, 0));
/* 109 */         donnees[1] = date;
/* 110 */         this.dbconn.updatePatients("UpdatePatientDateModif", donnees);
/* 111 */         System.out.println("Maj DateModification sur table patients effectuée");
/*    */ 
/* 115 */         this.dbconn.updateAssociationsEncours("UpdateEncoursAssociation", valeurs);
/*    */ 
/* 118 */         this.dbconn.insertAssociations("InsertPatientTypeTraitement", valeurs);
/*    */       }
/*    */ 
/*    */     }
/* 128 */     else if ("Date proposition".equals(columnName))
/*    */     {
/* 131 */       String[] valeurs = new String[2];
/*    */ 
/* 133 */       valeurs[0] = ((String)model.getValueAt(row, 0));
/* 134 */       valeurs[1] = data.toString();
/* 135 */       this.dbconn.updateDateProposition("UpdateDateProposition", valeurs);
/* 136 */       System.out.println("update de la table associations pour mettre à jour la date proposition");
/*    */     }
/* 138 */     else if ("Date début Trait.".equals(columnName))
/*    */     {
/* 141 */       String[] valeurs = new String[2];
/*    */ 
/* 143 */       valeurs[0] = ((String)model.getValueAt(row, 0));
/* 144 */       valeurs[1] = data.toString();
/* 145 */       this.dbconn.updateDateDebutTraitement("UpdateDateDebutTrait", valeurs);
/* 146 */       System.out.println("update de la table associations pour mettre à jour la date début de traitement");
/*    */     }
/* 148 */     else if ("cpt Trait.".equals(columnName))
/*    */     {
/* 151 */       String[] valeurs = new String[2];
/*    */ 
/* 153 */       valeurs[0] = ((String)model.getValueAt(row, 0));
/* 154 */       valeurs[1] = data.toString();
/* 155 */       this.dbconn.updatePatients("UpdatePatientCptTrait", valeurs);
/* 156 */       System.out.println("update de la table patient pour mettre à jour le cpt_traitement");
/*    */     }
/* 158 */     else if ("Observations".equals(columnName))
/*    */     {
/* 160 */       String[] valeurs = new String[2];
/*    */ 
/* 162 */       valeurs[0] = ((String)model.getValueAt(row, 0));
/* 163 */       valeurs[1] = data.toString();
/* 164 */       this.dbconn.updatePatients("UpdatePatientObervations", valeurs);
/* 165 */       System.out.println("update de la table patient pour mettre à jour l'observation");
/*    */     }
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.ListePatientListener
 * JD-Core Version:    0.6.0
 */