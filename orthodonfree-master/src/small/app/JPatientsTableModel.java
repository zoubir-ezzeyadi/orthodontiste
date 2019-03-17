/*     */ package small.app;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.swing.table.AbstractTableModel;
/*     */ 
/*     */ public class JPatientsTableModel extends AbstractTableModel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Object[][] donnees;
/*  23 */   private String[] entetes = { "ID", "Nom", "Prénom", "Date Nais.", "Date création", "Date modification", "Type Traitement", "Date proposition", "Date début Trait.", "cpt Trait.", "Observations" };
/*     */ 
/*     */   public JPatientsTableModel()
/*     */   {
/*  27 */     ConnexionDB dbconn = new ConnexionDB();
/*  28 */     Connection conn = null;
/*     */     try {
/*  30 */       conn = dbconn.getConnexion();
/*     */     }
/*     */     catch (ClassNotFoundException e) {
/*  33 */       e.printStackTrace();
/*     */     }
/*     */     catch (SQLException e) {
/*  36 */       e.printStackTrace();
/*     */     }
/*  38 */     this.donnees = dbconn.selecListePatients("listepatients", "");
/*     */   }
/*     */ 
/*     */   public JPatientsTableModel(String action, String filtre)
/*     */   {
/*  43 */     ConnexionDB dbconn = new ConnexionDB();
/*  44 */     Connection conn = null;
/*     */     try {
/*  46 */       conn = dbconn.getConnexion();
/*     */     }
/*     */     catch (ClassNotFoundException e) {
/*  49 */       e.printStackTrace();
/*     */     }
/*     */     catch (SQLException e) {
/*  52 */       e.printStackTrace();
/*     */     }
/*  54 */     this.donnees = dbconn.selecListePatients(action, filtre);
/*     */   }
/*     */ 
/*     */   public int getColumnCount()
/*     */   {
/*  60 */     return this.entetes.length;
/*     */   }
/*     */ 
/*     */   public int getRowCount()
/*     */   {
/*  66 */     return this.donnees.length;
/*     */   }
/*     */ 
/*     */   public String getColumnName(int columnIndex) {
/*  70 */     return this.entetes[columnIndex];
/*     */   }
/*     */ 
/*     */   public Object getValueAt(int rowIndex, int columnIndex)
/*     */   {
/*  76 */     return this.donnees[rowIndex][columnIndex];
/*     */   }
/*     */ 
/*     */   public boolean isCellEditable(int row, int column)
/*     */   {
/*  81 */     boolean editable = false;
/*  82 */     switch (column) { case 0:
/*  83 */       editable = false; break;
/*     */     case 1:
/*  84 */       editable = false; break;
/*     */     case 2:
/*  85 */       editable = false; break;
/*     */     case 3:
/*  86 */       editable = false; break;
/*     */     case 4:
/*  87 */       editable = false; break;
/*     */     case 5:
/*  88 */       editable = true; break;
/*     */     case 6:
/*  89 */       editable = true; break;
/*     */     case 7:
/*  90 */       editable = true; break;
/*     */     case 8:
/*  91 */       editable = true; break;
/*     */     case 9:
/*  92 */       editable = true; break;
/*     */     case 10:
/*  93 */       editable = true;
/*     */     }
/*  95 */     return editable;
/*     */   }
/*     */ 
/*     */   public void setValueAt(Object value, int row, int column)
/*     */   {
/* 101 */     System.out.println("valeur précédente : " + this.donnees[row][column]);
/* 102 */     if ((value instanceof Date)) {
/* 103 */       System.out.println("On modifie une Date !!");
/* 104 */       DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
/* 105 */       this.donnees[row][column] = dateFormat.format((Date)value);
/*     */     }
/* 108 */     else if (!value.toString().equals(this.donnees[row][column]))
/*     */     {
/* 110 */       System.out.println("On modifie autre chose qu'une Date !! : " + this.donnees[row][column] + "-" + value.toString());
/* 111 */       this.donnees[row][column] = value;
/*     */     }
/*     */ 
/* 115 */     fireTableCellUpdated(row, column);
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.JPatientsTableModel
 * JD-Core Version:    0.6.0
 */