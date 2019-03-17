/*    */ package small.data;
/*    */ 
/*    */ import com.toedter.calendar.JDateChooser;
/*    */ import java.awt.Component;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.io.PrintStream;
/*    */ import java.text.DateFormat;
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import javax.swing.AbstractCellEditor;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.TableCellEditor;
/*    */ 
/*    */ public class JDateChooserCellEditor extends AbstractCellEditor
/*    */   implements TableCellEditor, ActionListener
/*    */ {
/*    */   private static final long serialVersionUID = 917881575221755609L;
/* 24 */   private JDateChooser dateChooser = new JDateChooser();
/*    */ 
/*    */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
/*    */   {
/* 28 */     Date date = null;
/*    */ 
/* 30 */     System.out.println("Value dans DateChooserCellEditor : " + value);
/* 31 */     DateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
/* 32 */     if (value != null) {
/*    */       try { date = inputFormat.parse(value.toString());
/*    */       } catch (ParseException e) {
/* 35 */         e.printStackTrace();
/*    */       }
/* 37 */       this.dateChooser.setDate(date); } else {
/* 38 */       this.dateChooser.setDate(new Date());
/* 39 */     }return this.dateChooser;
/*    */   }
/*    */ 
/*    */   public Object getCellEditorValue() {
/* 43 */     return this.dateChooser.getDate();
/*    */   }
/*    */ 
/*    */   public void actionPerformed(ActionEvent evt)
/*    */   {
/* 49 */     System.out.print("Action sur une cellule : " + evt.getSource().toString());
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.data.JDateChooserCellEditor
 * JD-Core Version:    0.6.0
 */