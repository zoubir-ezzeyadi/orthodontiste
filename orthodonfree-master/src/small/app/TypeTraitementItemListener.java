/*    */ package small.app;
/*    */ 
/*    */ import java.awt.event.ItemEvent;
/*    */ import java.awt.event.ItemListener;
/*    */ import java.io.PrintStream;
/*    */ import javax.swing.DefaultCellEditor;
/*    */ import javax.swing.JComboBox;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.TableColumn;
/*    */ import javax.swing.table.TableColumnModel;
/*    */ import javax.swing.table.TableModel;
/*    */ import small.data.JDateChooserCellEditor;
/*    */ 
/*    */ public class TypeTraitementItemListener
/*    */   implements ItemListener
/*    */ {
/* 14 */   private JTable jTable = null;
/* 15 */   private JComboBox jComboBox = null;
/* 16 */   private String[] listeTraitement = { "AUCUN", "TO90", "TO75", "TO50", "TO05", "STOP" };
/* 17 */   private JComboBox comboBox = null;
/* 18 */   private FicheConsultationListe ficheListe = null;
/*    */ 
/*    */   public TypeTraitementItemListener(JTable jTable, JComboBox jComboBox, FicheConsultationListe ficheConsultationListe) {
/* 21 */     this.jTable = jTable;
/* 22 */     this.jComboBox = jComboBox;
/* 23 */     this.ficheListe = ficheConsultationListe;
/*    */   }
/*    */ 
/*    */   public void itemStateChanged(ItemEvent e) {
/* 27 */     System.out.println("itemStateChanged()");
/* 28 */     int typeTraitement = this.jComboBox.getSelectedIndex();
/* 29 */     System.out.println("vous avez sélectionné : " + typeTraitement);
/* 30 */     if (typeTraitement == 0) {
/* 31 */       JPatientsTableModel model = new JPatientsTableModel();
/* 32 */       this.jTable.setModel(model);
/* 33 */       this.jTable.getModel().addTableModelListener(new ListePatientListener(this.ficheListe));
/* 34 */     } else if (typeTraitement == 1) {
/* 35 */       JPatientsActifsTableModel modelActif = new JPatientsActifsTableModel();
/* 36 */       this.jTable.setModel(modelActif);
/* 37 */       this.jTable.getModel().addTableModelListener(new ListePatientListener(this.ficheListe));
/* 38 */     } else if (typeTraitement == 2) {
/* 39 */       JPatientsContentionTableModel modelContention = new JPatientsContentionTableModel();
/* 40 */       this.jTable.setModel(modelContention);
/* 41 */       this.jTable.getModel().addTableModelListener(new ListePatientListener(this.ficheListe));
/* 42 */     } else if (typeTraitement == 3) {
/* 43 */       JPatientsContention50TableModel modelContention50 = new JPatientsContention50TableModel();
/* 44 */       this.jTable.setModel(modelContention50);
/* 45 */       this.jTable.getModel().addTableModelListener(new ListePatientListener(this.ficheListe));
/* 46 */     } else if (typeTraitement == 4) {
/* 47 */       JPatientsSurveillanceTableModel modelSurveillance = new JPatientsSurveillanceTableModel();
/* 48 */       this.jTable.setModel(modelSurveillance);
/* 49 */       this.jTable.getModel().addTableModelListener(new ListePatientListener(this.ficheListe));
/* 50 */     } else if (typeTraitement == 5) {
/* 51 */       JPatientsStopTableModel modelStop = new JPatientsStopTableModel();
/* 52 */       this.jTable.setModel(modelStop);
/* 53 */       this.jTable.getModel().addTableModelListener(new ListePatientListener(this.ficheListe));
/*    */     }
/* 55 */     this.comboBox = new JComboBox(this.listeTraitement);
/* 56 */     this.jTable.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(this.comboBox));
/* 57 */     this.jTable.getColumnModel().getColumn(5).setCellEditor(new JDateChooserCellEditor());
/* 58 */     this.jTable.getColumnModel().getColumn(7).setCellEditor(new JDateChooserCellEditor());
/* 59 */     this.jTable.getColumnModel().getColumn(8).setCellEditor(new JDateChooserCellEditor());
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.TypeTraitementItemListener
 * JD-Core Version:    0.6.0
 */