/*    */ package small.sql;
/*    */ 
/*    */ public class SqlParamInfo
/*    */ {
/*    */   private String order;
/*    */   private String name;
/*    */   private String type;
/*    */ 
/*    */   public String getOrder()
/*    */   {
/* 10 */     return this.order;
/*    */   }
/*    */   public void setOrder(String order) {
/* 13 */     this.order = order;
/*    */   }
/*    */   public String getName() {
/* 16 */     return this.name;
/*    */   }
/*    */   public void setName(String name) {
/* 19 */     this.name = name;
/*    */   }
/*    */   public String getType() {
/* 22 */     return this.type;
/*    */   }
/*    */   public void setType(String type) {
/* 25 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 29 */     return this.order + " " + this.name + "(" + this.type + ")";
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.sql.SqlParamInfo
 * JD-Core Version:    0.6.0
 */