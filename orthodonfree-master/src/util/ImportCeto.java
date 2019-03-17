/*    */ package util;
/*    */ 
/*    */ import java.awt.EventQueue;
/*    */ import java.io.File;
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import javax.swing.JFileChooser;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JTable;
/*    */ import small.app.ConnexionDB;
/*    */ 
/*    */ public class ImportCeto
/*    */ {
/* 35 */   private ConnexionDB conn = null;
/* 36 */   private Connection connec = null;
/*    */ 
/*    */   public ImportCeto() throws ClassNotFoundException, SQLException {
/* 39 */     this.conn = new ConnexionDB();
/* 40 */     this.connec = this.conn.getConnexion();
/*    */   }
/*    */ 
/*    */   public void Import(final JTable jTable) {
/* 44 */     JFileChooser chooser = new JFileChooser();
/*    */ 
/* 46 */     int returnVal = chooser.showOpenDialog(null);
/*    */ 
/* 48 */     if (returnVal == 0) {
/* 49 */     final File file = chooser.getSelectedFile();
/*    */ 
/* 51 */       System.out.println("Opening: " + file.getAbsolutePath() + ".");
/*    */ 
/* 55 */       EventQueue.invokeLater(new Thread()
/*    */       {
/*    */         public void run()
/*    */         {
/* 59 */           JFrame frame = new CetoProgressDialog(file, ImportCeto.this.conn, jTable);
/* 60 */           frame.setDefaultCloseOperation(2);
/* 61 */           frame.setVisible(true);
/*    */         }
/*    */       });
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */     throws ClassNotFoundException, SQLException
/*    */   {
/* 74 */     ImportCeto impceto = new ImportCeto();
/* 75 */     impceto.Import(null);
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     util.ImportCeto
 * JD-Core Version:    0.6.0
 */