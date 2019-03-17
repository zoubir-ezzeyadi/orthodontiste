/*    */ package small.data;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.DefaultTableCellRenderer;
/*    */ 
/*    */ public class DateCellRenderer extends DefaultTableCellRenderer
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
/*    */   {
/* 17 */     super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
/* 18 */     if ((value instanceof Date))
/*    */     {
/* 20 */       String strDate = new SimpleDateFormat("dd-MM-yyyy").format((Date)value);
/*    */ 
/* 23 */       setText(strDate);
/*    */     }
/*    */ 
/* 26 */     return this;
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.data.DateCellRenderer
 * JD-Core Version:    0.6.0
 */