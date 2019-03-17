/*    */ package small.sql;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class SqlInfo
/*    */ {
/*    */   private String name;
/*    */   private String type;
/*    */   private String query;
/*    */   private String orderParameters;
/*    */   private HashMap parameters;
/*    */   private int parameterCount;
/*    */ 
/*    */   public SqlInfo()
/*    */   {
/* 13 */     this.parameters = new HashMap();
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
/*    */   public String getQuery() {
/* 28 */     return this.query;
/*    */   }
/*    */   public void setQuery(String query) {
/* 31 */     this.query = query;
/*    */   }
/*    */   public HashMap getParameters() {
/* 34 */     return this.parameters;
/*    */   }
/*    */   public void setParameters(HashMap parameters) {
/* 37 */     this.parameters = parameters;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 41 */     return this.name + " " + this.parameters;
/*    */   }
/*    */   public String getOrderParameters() {
/* 44 */     return this.orderParameters;
/*    */   }
/*    */   public void setOrderParameters(String orderParameters) {
/* 47 */     this.orderParameters = orderParameters;
/*    */   }
/*    */ 
/*    */   public int getParameterCount() {
/* 51 */     return this.parameterCount;
/*    */   }
/*    */   public void setParameterCount(int parameterCount) {
/* 54 */     this.parameterCount = parameterCount;
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.sql.SqlInfo
 * JD-Core Version:    0.6.0
 */