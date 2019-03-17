/*     */ package small.app;
/*     */ 
/*     */ import com.sun.pdfview.PDFFile;
/*     */ import java.awt.print.Book;
/*     */ import java.awt.print.PageFormat;
/*     */ import java.awt.print.Paper;
/*     */ import java.awt.print.PrinterException;
/*     */ import java.awt.print.PrinterJob;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.FileChannel.MapMode;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.SQLException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.sf.jasperreports.engine.JRException;
/*     */ import net.sf.jasperreports.engine.JasperCompileManager;
/*     */ import net.sf.jasperreports.engine.JasperExportManager;
/*     */ import net.sf.jasperreports.engine.JasperFillManager;
/*     */ import net.sf.jasperreports.engine.JasperPrint;
/*     */ import net.sf.jasperreports.engine.JasperReport;
/*     */ import net.sf.jasperreports.engine.design.JasperDesign;
/*     */ import net.sf.jasperreports.engine.xml.JRXmlLoader;
/*     */ 
/*     */ public class ImpressionEntentes
/*     */ {
/*     */   public void getPDF(String fileName, int idPatient, String reportName)
/*     */     throws IOException, PrinterException
/*     */   {
/*  47 */     Connection connection = null;
/*     */     try
/*     */     {
/*     */       try
/*     */       {
/*  52 */         Class.forName("com.mysql.jdbc.Driver");
/*     */       }
/*     */       catch (ClassNotFoundException e) {
/*  55 */         e.printStackTrace();
/*     */       }
/*  57 */       String databaseFile = System.getProperty("database.file");
/*  58 */       connection = DriverManager.getConnection("DB_URL,USER,PASS" + databaseFile);
/*     */ 
/*  61 */       JasperDesign jasperDesign = JRXmlLoader.load("./report/" + reportName);
/*  62 */       JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
/*  63 */       Map parameters = null;
/*  64 */       if (idPatient != 0)
/*     */       {
/*  66 */         parameters = new HashMap();
/*  67 */         parameters.put("idpatient", idPatient);
/*     */       }
/*     */ 
/*  70 */       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
/*     */ 
/*  73 */       JasperExportManager.exportReportToPdfFile(jasperPrint, "./report/" + fileName + ".pdf");
/*     */     }
/*     */     catch (JRException e) {
/*  76 */       e.printStackTrace();
/*     */       try
/*     */       {
/*  82 */         connection.close();
/*     */       }
/*     */       catch (SQLException e1) {
/*  85 */         e1.printStackTrace();
/*     */       }
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/*  79 */       e.printStackTrace();
/*     */       try
/*     */       {
/*  82 */         connection.close();
/*     */       }
/*     */       catch (SQLException e1) {
/*  85 */         e1.printStackTrace();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/*  82 */         connection.close();
/*     */       }
/*     */       catch (SQLException e) {
/*  85 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void printPDF(String fileName, int idPatient) throws IOException, PrinterException
/*     */   {
/*  92 */     File f = new File("./report/" + fileName + ".pdf");
/*  93 */     FileInputStream fis = new FileInputStream(f);
/*  94 */     FileChannel fc = fis.getChannel();
/*  95 */     ByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0L, fc.size());
/*  96 */     PDFFile pdfFile = new PDFFile(bb);
/*  97 */     PDFPrintPage pages = new PDFPrintPage(pdfFile);
/*     */ 
/* 100 */     PrinterJob pjob = PrinterJob.getPrinterJob();
/* 101 */     PageFormat page = new PageFormat();
/* 102 */     PageFormat pf = PrinterJob.getPrinterJob().defaultPage();
/* 103 */     pjob.setJobName(f.getName());
/* 104 */     Book book = new Book();
/* 105 */     book.append(pages, pf, pdfFile.getNumPages());
/* 106 */     pjob.setPageable(book);
/*     */ 
/* 109 */     Paper paper = new Paper();
/* 110 */     paper.setSize(595.27559099999996D, 841.88976400000001D);
/* 111 */     paper.setImageableArea(0.0D, 0.0D, paper.getWidth() * 2.0D, paper.getHeight());
/* 112 */     pf.setPaper(paper);
/*     */ 
/* 114 */     pjob.print();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.ImpressionEntentes
 * JD-Core Version:    0.6.0
 */