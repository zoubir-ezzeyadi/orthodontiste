/*    */ package test;
/*    */ 
/*    */ import javax.swing.table.AbstractTableModel;
/*    */ 
/*    */ class EditableTableModel extends AbstractTableModel
/*    */ {
/*    */   String[] columnTitles;
/*    */   Object[][] dataEntries;
/*    */   int rowCount;
/*    */ 
/*    */   public EditableTableModel(String[] columnTitles, Object[][] dataEntries)
/*    */   {
/* 46 */     this.columnTitles = columnTitles;
/* 47 */     this.dataEntries = dataEntries;
/*    */   }
/*    */ 
/*    */   public int getRowCount() {
/* 51 */     return this.dataEntries.length;
/*    */   }
/*    */ 
/*    */   public int getColumnCount() {
/* 55 */     return this.columnTitles.length;
/*    */   }
/*    */ 
/*    */   public Object getValueAt(int row, int column) {
/* 59 */     return this.dataEntries[row][column];
/*    */   }
/*    */ 
/*    */   public String getColumnName(int column) {
/* 63 */     return this.columnTitles[column];
/*    */   }
/*    */ 
/*    */   public Class getColumnClass(int column) {
/* 67 */     return getValueAt(0, column).getClass();
/*    */   }
/*    */ 
/*    */   public boolean isCellEditable(int row, int column) {
/* 71 */     return true;
/*    */   }
/*    */ 
/*    */   public void setValueAt(Object value, int row, int column) {
/* 75 */     this.dataEntries[row][column] = value;
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     test.EditableTableModel
 * JD-Core Version:    0.6.0
 */