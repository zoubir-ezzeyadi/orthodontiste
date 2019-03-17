/*    */ package small.sql;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class SqlFactory
/*    */ {
/* 10 */   private static HashMap _sqlMap = null;
/*    */ 
/*    */   private static HashMap getMap() {
/* 13 */     if (_sqlMap == null) {
/* 14 */       _sqlMap = SqlXmlParser.loadSqlParameters();
/*    */     }
/* 16 */     return _sqlMap;
/*    */   }
/*    */ 
/*    */   public static String getQuery(String actionName)
/*    */   {
/* 23 */     return ((SqlInfo)getMap().get(actionName)).getQuery();
/*    */   }
/*    */ 
/*    */   public static SqlInfo getSqlInfo(String actionName) {
/* 27 */     return (SqlInfo)getMap().get(actionName);
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.sql.SqlFactory
 * JD-Core Version:    0.6.0
 */