/*    */ package util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class TestString
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 10 */     StringBuffer chaineS = new StringBuffer("TOTO");
/* 11 */     long debut = System.currentTimeMillis();
/* 12 */     for (int i = 0; i < 100000; i++) {
/* 13 */       chaineS.append("AZERTYUIOPQSDFGHJKLMWXCVBN");
/*    */     }
/* 15 */     long fin = System.currentTimeMillis();
/* 16 */     System.out.println(chaineS.toString());
/* 17 */     System.out.println("temps : " + (fin - debut));
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     util.TestString
 * JD-Core Version:    0.6.0
 */