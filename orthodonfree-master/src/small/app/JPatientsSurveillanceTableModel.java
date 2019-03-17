/*    */ package small.app;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import java.text.DateFormat;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import javax.swing.table.AbstractTableModel;
/*    */ 
/*    */ public class JPatientsSurveillanceTableModel extends AbstractTableModel
/*    */ {
/*    */   private Object[][] donnees;
/* 15 */   private String[] entetes = { "ID", "Prénom", "Nom", "Date Nais.", "Date création", "Date modification", "Type Traitement", "Date proposition", "Date début Trait.", "cpt Trait.", "Observations" };
/*    */ 
/*    */   public JPatientsSurveillanceTableModel()
/*    */   {
/* 19 */     ConnexionDB dbconn = new ConnexionDB();
/*    */ 
/* 21 */     Connection conn = null;
/*    */     try {
/* 23 */       conn = dbconn.getConnexion();
/*    */     }
/*    */     catch (ClassNotFoundException e) {
/* 26 */       e.printStackTrace();
/*    */     }
/*    */     catch (SQLException e) {
/* 29 */       e.printStackTrace();
/*    */     }
/* 31 */     this.donnees = dbconn.selecListePatients("listepatientssurveillance", "");
/*    */   }
/*    */ 
/*    */   public int getColumnCount()
/*    */   {
/* 37 */     return this.entetes.length;
/*    */   }
/*    */ 
/*    */   public int getRowCount()
/*    */   {
/* 43 */     return this.donnees.length;
/*    */   }
/*    */ 
/*    */   public String getColumnName(int columnIndex) {
/* 47 */     return this.entetes[columnIndex];
/*    */   }
/*    */ 
/*    */   public Object getValueAt(int rowIndex, int columnIndex)
/*    */   {
/* 53 */     return this.donnees[rowIndex][columnIndex];
/*    */   }
/*    */ 
/*    */   public boolean isCellEditable(int row, int column)
/*    */   {
/* 58 */     boolean editable = false;
/* 59 */     switch (column) { case 0:
/* 60 */       editable = false; break;
/*    */     case 1:
/* 61 */       editable = false; break;
/*    */     case 2:
/* 62 */       editable = false; break;
/*    */     case 3:
/* 63 */       editable = false; break;
/*    */     case 4:
/* 64 */       editable = false; break;
/*    */     case 5:
/* 65 */       editable = true; break;
/*    */     case 6:
/* 66 */       editable = true; break;
/*    */     case 7:
/* 67 */       editable = true; break;
/*    */     case 8:
/* 68 */       editable = true; break;
/*    */     case 9:
/* 69 */       editable = true; break;
/*    */     case 10:
/* 70 */       editable = true;
/*    */     }
/* 72 */     return editable;
/*    */   }
/*    */ 
/*    */   public void setValueAt(Object value, int row, int column)
/*    */   {
/* 77 */     System.out.println("valeur précédente : " + this.donnees[row][column]);
/* 78 */     if ((value instanceof Date)) {
/* 79 */       DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
/* 80 */       this.donnees[row][column] = dateFormat.format((Date)value);
/* 81 */       fireTableCellUpdated(row, column);
/*    */     }
/* 83 */     else if (!value.toString().equals(this.donnees[row][column])) {
/* 84 */       this.donnees[row][column] = value;
/* 85 */       fireTableCellUpdated(row, column);
/*    */     }
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.JPatientsSurveillanceTableModel
 * JD-Core Version:    0.6.0
 */