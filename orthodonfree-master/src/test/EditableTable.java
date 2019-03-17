/*    */ package test;
/*    */ 
/*    */ import javax.swing.DefaultCellEditor;
/*    */ import javax.swing.JComboBox;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.TableColumn;
/*    */ import javax.swing.table.TableColumnModel;
/*    */ import javax.swing.table.TableModel;
/*    */ 
/*    */ public class EditableTable
/*    */ {
/*    */   public static void main(String[] a)
/*    */   {
/* 14 */     JFrame frame = new JFrame();
/* 15 */     frame.setDefaultCloseOperation(3);
/*    */ 
/* 17 */     String[] columnTitles = { "First Name", "Last Name", "Weight (lb)", "Blood Group", "Age>20yrs" };
/* 18 */     Object[][] dataEntries = { { "Saravan", "Pantham", new Integer(50), "B", new Boolean(false) }, 
/* 19 */       { "Eric", "", new Integer(180), "O", new Boolean(true) }, 
/* 20 */       { "John", "", new Integer(120), "AB", new Boolean(false) }, 
/* 21 */       { "Mathew", "", new Integer(140), "A", new Boolean(true) } };
/* 22 */     TableModel model = new EditableTableModel(columnTitles, dataEntries);
/* 23 */     JTable table = new JTable(model);
/* 24 */     table.createDefaultColumnsFromModel();
/*    */ 
/* 26 */     String[] bloodGroups = { "A", "B", "AB", "O" };
/* 27 */     JComboBox comboBox = new JComboBox(bloodGroups);
/* 28 */     table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBox));
/*    */ 
/* 30 */     frame.add(new JScrollPane(table));
/*    */ 
/* 32 */     frame.setSize(300, 200);
/* 33 */     frame.setVisible(true);
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     test.EditableTable
 * JD-Core Version:    0.6.0
 */