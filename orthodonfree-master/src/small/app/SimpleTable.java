/*    */ package small.app;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java.io.PrintStream;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.ResultSetMetaData;
/*    */ import java.sql.Statement;
/*    */ import java.util.Vector;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTable;
/*    */ 
/*    */ public class SimpleTable extends JFrame
/*    */ {
/*    */   public SimpleTable()
/*    */   {
/* 18 */     super("Simple JTable Test");
/* 19 */     setSize(350, 200);
/* 20 */     setLocation(250, 300);
/*    */     try
/*    */     {
/* 28 */       Class.forName("org.sqlite.JDBC").newInstance();
/* 29 */       Connection conDB = DriverManager.getConnection("jdbc:sqlite:/home/steph/developpement/HdC/dellestable/orthodonfree.sqlite");
/* 30 */       ResultSet rset1 = null;
/* 31 */       Statement stmt1 = null;
/* 32 */       Statement stmt2 = null;
/* 33 */       String ItemCode = null;
/* 34 */       String prenom = null;
/* 35 */       String nom = null;
/* 36 */       stmt1 = conDB.createStatement();
/*    */ 
/* 38 */       rset1 = stmt1.executeQuery("select ID, PRENOM, NOM from patient");
/*    */ 
/* 41 */       Vector cache = new Vector();
/* 42 */       ResultSetMetaData meta = rset1.getMetaData();
/* 43 */       int ColCount = meta.getColumnCount();
/*    */ 
/* 45 */       while (rset1.next())
/*    */       {
/* 47 */         String[] record = new String[ColCount];
/* 48 */         for (int i = 0; i < ColCount; i++)
/*    */         {
/* 51 */           record[i] = rset1.getString(i + 1);
/*    */         }
/*    */ 
/* 54 */         ItemCode = rset1.getString("ID");
/* 55 */         prenom = rset1.getString("PRENOM");
/* 56 */         nom = rset1.getString("NOM");
/*    */       }
/*    */ 
/* 59 */       JTable jt = new JTable(new String[][] { { ItemCode, prenom, nom } }, new String[] { "ID", "PRENOM", "PRENOM" });
/*    */ 
/* 61 */       JScrollPane jsp = new JScrollPane(jt);
/* 62 */       getContentPane().add(jsp, "Center");
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 66 */       System.out.println("failure to connect " + e);
/* 67 */       return;
/*    */     }int ColCount;
/*    */   }
/* 71 */   public static void main(String[] args) { SimpleTable st = new SimpleTable();
/* 72 */     st.setVisible(true);
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.SimpleTable
 * JD-Core Version:    0.6.0
 */