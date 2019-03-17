/*     */ package small.app;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.swing.table.AbstractTableModel;
/*     */ 
/*     */ public class JPatientsActifsTableModel extends AbstractTableModel
/*     */ {
/*     */   private Object[][] donnees;
/*  14 */   private String precedenteValTypeTraitement = null;
/*     */   private int row;
/*  15 */   private int col = 0;
/*  16 */   private String[] entetes = { "ID", "Prénom", "Nom", "Date Nais.", "Date création", "Date modification", "Type Traitement", "Date proposition", "Date début Trait.", "cpt Trait.", "Observations" };
/*     */ 
/*     */   public JPatientsActifsTableModel()
/*     */   {
/*  20 */     ConnexionDB dbconn = new ConnexionDB();
/*  21 */     this.donnees = dbconn.selecListePatients("listepatientsactif", "");
/*     */   }
/*     */ 
/*     */   public int getColumnCount()
/*     */   {
/*  27 */     return this.entetes.length;
/*     */   }
/*     */ 
/*     */   public int getRowCount()
/*     */   {
/*  33 */     return this.donnees.length;
/*     */   }
/*     */ 
/*     */   public boolean isCellEditable(int row, int column)
/*     */   {
/*  38 */     boolean editable = false;
/*  39 */     switch (column) { case 0:
/*  40 */       editable = false; break;
/*     */     case 1:
/*  41 */       editable = false; break;
/*     */     case 2:
/*  42 */       editable = false; break;
/*     */     case 3:
/*  43 */       editable = false; break;
/*     */     case 4:
/*  44 */       editable = false; break;
/*     */     case 5:
/*  45 */       editable = true; break;
/*     */     case 6:
/*  46 */       editable = true; break;
/*     */     case 7:
/*  47 */       editable = true; break;
/*     */     case 8:
/*  48 */       editable = true; break;
/*     */     case 9:
/*  49 */       editable = true; break;
/*     */     case 10:
/*  50 */       editable = true;
/*     */     }
/*  52 */     return editable;
/*     */   }
/*     */ 
/*     */   public void setValueAt(Object value, int row, int column)
/*     */   {
/*  59 */     if (this.donnees[row][column] == null) setPrecedenteValTypeTraitement("null"); else
/*  60 */       setPrecedenteValTypeTraitement(this.donnees[row][column].toString());
/*  61 */     setRow(row);
/*  62 */     setCol(column);
/*  63 */     System.out.println("valeur précédente : " + this.donnees[row][column]);
/*  64 */     if ((value instanceof Date)) {
/*  65 */       DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
/*  66 */       this.donnees[row][column] = dateFormat.format((Date)value);
/*  67 */       fireTableCellUpdated(row, column);
/*     */     }
/*  69 */     else if (!value.toString().equals(this.donnees[row][column])) {
/*  70 */       this.donnees[row][column] = value;
/*  71 */       fireTableCellUpdated(row, column);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getColumnName(int columnIndex)
/*     */   {
/*  78 */     return this.entetes[columnIndex];
/*     */   }
/*     */ 
/*     */   public Object getValueAt(int rowIndex, int columnIndex)
/*     */   {
/*  84 */     return this.donnees[rowIndex][columnIndex];
/*     */   }
/*     */ 
/*     */   public String getPrecedenteValTypeTraitement()
/*     */   {
/*  91 */     return this.precedenteValTypeTraitement;
/*     */   }
/*     */ 
/*     */   public void setPrecedenteValTypeTraitement(String precedenteValTypeTraitement)
/*     */   {
/*  98 */     this.precedenteValTypeTraitement = precedenteValTypeTraitement;
/*     */   }
/*     */ 
/*     */   public int getRow()
/*     */   {
/* 105 */     return this.row;
/*     */   }
/*     */ 
/*     */   public void setRow(int row)
/*     */   {
/* 112 */     this.row = row;
/*     */   }
/*     */ 
/*     */   public int getCol()
/*     */   {
/* 119 */     return this.col;
/*     */   }
/*     */ 
/*     */   public void setCol(int col)
/*     */   {
/* 126 */     this.col = col;
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.JPatientsActifsTableModel
 * JD-Core Version:    0.6.0
 */