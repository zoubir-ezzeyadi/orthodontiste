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
/*    */ public class ImportDsio
/*    */ {
/* 15 */   private ConnexionDB conn = null;
/* 16 */   private Connection connec = null;
/*    */ 
/*    */   public ImportDsio() throws ClassNotFoundException, SQLException {
/* 19 */     this.conn = new ConnexionDB();
/* 20 */     this.connec = this.conn.getConnexion();
/*    */   }
/*    */ 
/*    */   public void Import(final JTable jTable) {
/* 24 */     JFileChooser chooser = new JFileChooser();
/*    */ 
/* 26 */     int returnVal = chooser.showOpenDialog(null);
/*    */ 
/* 28 */     if (returnVal == 0) {
/* 29 */      final File file = chooser.getSelectedFile();
/*    */ 
/* 31 */       System.out.println("Opening: " + file.getAbsolutePath() + ".");
/*    */ 
/* 35 */       EventQueue.invokeLater(new Thread()
/*    */       {
/*    */         public void run()
/*    */         {
/* 39 */           JFrame frame = new DsioProgessDialog(file, ImportDsio.this.conn, jTable);
/* 40 */           frame.setDefaultCloseOperation(2);
/* 41 */           frame.setVisible(true);
/*    */         }
/*    */       });
/*    */     }
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     util.ImportDsio
 * JD-Core Version:    0.6.0
 */