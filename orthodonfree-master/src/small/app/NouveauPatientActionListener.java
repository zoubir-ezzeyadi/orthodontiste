/*    */ package small.app;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ 
/*    */ public class NouveauPatientActionListener
/*    */   implements ActionListener
/*    */ {
/* 10 */   private FicheConsultationListe appelant = null;
/*    */ 
/*    */   public NouveauPatientActionListener(FicheConsultationListe appelant) {
/* 13 */     this.appelant = appelant;
/*    */   }
/*    */ 
/*    */   public void actionPerformed(ActionEvent arg0) {
/* 17 */     FicheSaisie ficheSaisiePatient = new FicheSaisie(this.appelant);
/*    */ 
/* 19 */     ficheSaisiePatient.setResizable(false);
/*    */ 
/* 21 */     ficheSaisiePatient.setLocationRelativeTo(ficheSaisiePatient.getParent());
/* 22 */     ficheSaisiePatient.setVisible(true);
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.NouveauPatientActionListener
 * JD-Core Version:    0.6.0
 */