/*    */ package small.app;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.io.PrintStream;
/*    */ import javax.swing.JOptionPane;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.TableModel;
/*    */ 
/*    */ public class SupprimePatientActionListener
/*    */   implements ActionListener
/*    */ {
/* 11 */   private FicheConsultationListe appelant = null;
/* 12 */   private JTable jTable = null;
/* 13 */   private ConnexionDB dbconn = null;
/*    */ 
/*    */   public SupprimePatientActionListener(FicheConsultationListe appelant, JTable table, ConnexionDB conn) {
/* 16 */     this.appelant = appelant;
/* 17 */     this.jTable = table;
/* 18 */     this.dbconn = conn;
/*    */   }
/*    */ 
/*    */   public void actionPerformed(ActionEvent arg0)
/*    */   {
/* 23 */     System.out.println("Demande de suppression du patient sélectionné");
/* 24 */     int modelIndex = this.jTable.convertRowIndexToModel(this.jTable.getSelectedRow());
/* 25 */     String idpatient = this.jTable.getModel().getValueAt(modelIndex, 0).toString();
/* 26 */     int reponse = JOptionPane.showConfirmDialog(null, "Attention vous allez supprimer le patient N° " + idpatient, "Suppression Patient", 2);
/* 27 */     if (reponse == 0) {
/* 28 */       this.dbconn.deletePatient(idpatient, "DeletePatient");
/*    */     }
/* 30 */     this.appelant.populateJtable();
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.SupprimePatientActionListener
 * JD-Core Version:    0.6.0
 */