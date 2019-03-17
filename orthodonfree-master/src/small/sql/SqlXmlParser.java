/*    */ package small.sql;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import javax.xml.parsers.FactoryConfigurationError;
/*    */ import javax.xml.parsers.ParserConfigurationException;
/*    */ import javax.xml.parsers.SAXParser;
/*    */ import javax.xml.parsers.SAXParserFactory;
/*    */ import org.xml.sax.Attributes;
/*    */ import org.xml.sax.SAXException;
/*    */ import org.xml.sax.helpers.DefaultHandler;
/*    */ 
/*    */ public class SqlXmlParser extends DefaultHandler
/*    */ {
/* 13 */   private static HashMap _sqlMap = null;
/* 14 */   private SqlInfo currentInfo = null;
/*    */ 
/*    */   protected static HashMap loadSqlParameters() {
/* 17 */     String uri = null;
/* 18 */     uri = System.getProperty("sql.config");
/*    */     try
/*    */     {
/* 21 */       SAXParserFactory parserFactory = SAXParserFactory.newInstance();
/* 22 */       parserFactory.setValidating(false);
/* 23 */       parserFactory.setNamespaceAware(false);
/* 24 */       SqlXmlParser SqlXmlParserInstance = new SqlXmlParser();
/* 25 */       SAXParser parser = parserFactory.newSAXParser();
/* 26 */       parser.parse(uri, SqlXmlParserInstance);
/*    */     }
/*    */     catch (IOException ex) {
/* 29 */       ex.printStackTrace();
/*    */     }
/*    */     catch (SAXException ex) {
/* 32 */       ex.printStackTrace();
/*    */     }
/*    */     catch (ParserConfigurationException ex) {
/* 35 */       ex.printStackTrace();
/*    */     }
/*    */     catch (FactoryConfigurationError ex) {
/* 38 */       ex.printStackTrace();
/*    */     }
/* 40 */     return _sqlMap;
/*    */   }
/*    */ 
/*    */   public void endDocument()
/*    */     throws SAXException
/*    */   {
/* 47 */     this.currentInfo = null;
/*    */   }
/*    */ 
/*    */   public void endElement(String uri, String localName, String qName)
/*    */     throws SAXException
/*    */   {
/*    */   }
/*    */ 
/*    */   public void startDocument()
/*    */     throws SAXException
/*    */   {
/* 58 */     _sqlMap = new HashMap();
/* 59 */     this.currentInfo = null;
/*    */   }
/*    */ 
/*    */   public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
/* 63 */     if (qName.equals("action")) {
/* 64 */       SqlInfo info = new SqlInfo();
/* 65 */       info.setName(attributes.getValue("name"));
/* 66 */       info.setType(attributes.getValue("type"));
/* 67 */       info.setQuery(attributes.getValue("query"));
/* 68 */       info.setOrderParameters(attributes.getValue("orderParameters"));
/* 69 */       info.setParameterCount(countToken('?', info.getQuery()));
/* 70 */       if (info.getType() == null) {
/* 71 */         info.setType("query");
/*    */       }
/* 73 */       _sqlMap.put(info.getName(), info);
/* 74 */       this.currentInfo = info;
/*    */     }
/* 77 */     else if ((qName.equals("parameter")) && 
/* 78 */       (this.currentInfo != null)) {
/* 79 */       SqlParamInfo pInfo = new SqlParamInfo();
/* 80 */       pInfo.setName(attributes.getValue("name"));
/* 81 */       pInfo.setType(attributes.getValue("type"));
/* 82 */       if (pInfo.getType() == null)
/* 83 */         pInfo.setType("string");
/* 84 */       pInfo.setOrder(attributes.getValue("order"));
/*    */ 
/* 86 */       this.currentInfo.getParameters().put(pInfo.getOrder(), pInfo);
/*    */     }
/*    */   }
/*    */ 
/*    */   private int countToken(char token, String source)
/*    */   {
/* 92 */     int result = 0;
/* 93 */     if (source != null) {
/* 94 */       for (int i = 0; i < source.length(); i++) {
/* 95 */         if (source.charAt(i) == token)
/* 96 */           result++;
/*    */       }
/*    */     }
/* 99 */     return result;
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.sql.SqlXmlParser
 * JD-Core Version:    0.6.0
 */