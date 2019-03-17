/*    */ package util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ public class ClasseInspecteur
/*    */ {
/*    */   private Class classe;
/*    */   private String nomClasse;
/*    */ 
/*    */   public ClasseInspecteur(String nomClasse)
/*    */   {
/* 12 */     this.nomClasse = nomClasse;
/*    */     try {
/* 14 */       this.classe = Class.forName(nomClasse);
/* 15 */       Method[] methode = this.classe.getMethods();
/* 16 */       for (int i = 0; i < methode.length; i++)
/* 17 */         System.out.println("methode [" + i + "] : " + methode[i]);
/*    */     }
/*    */     catch (Exception e) {
/* 20 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 25 */     ClasseInspecteur inspect = new ClasseInspecteur("java.lang.String");
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     util.ClasseInspecteur
 * JD-Core Version:    0.6.0
 */