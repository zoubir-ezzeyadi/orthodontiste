/*    */ package small.app;
/*    */ 
/*    */ import com.sun.pdfview.PDFFile;
/*    */ import com.sun.pdfview.PDFPage;
/*    */ import com.sun.pdfview.PDFRenderer;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Rectangle;
/*    */ import java.awt.print.PageFormat;
/*    */ import java.awt.print.Printable;
/*    */ import java.awt.print.PrinterException;
/*    */ 
/*    */ public class PDFPrintPage
/*    */   implements Printable
/*    */ {
/*    */   private PDFFile file;
/*    */ 
/*    */   PDFPrintPage(PDFFile file)
/*    */   {
/* 22 */     this.file = file;
/*    */   }
/*    */ 
/*    */   public int print(Graphics g, PageFormat format, int index) throws PrinterException {
/* 26 */     int pagenum = index + 1;
/*    */ 
/* 29 */     if ((pagenum >= 1) && (pagenum <= this.file.getNumPages()))
/*    */     {
/* 31 */       Graphics2D g2 = (Graphics2D)g;
/* 32 */       PDFPage page = this.file.getPage(pagenum);
/* 33 */       double pwidth = 595.27559099999996D;
/* 34 */       double pheight = 841.88976400000001D;
/*    */ 
/* 36 */       double aspect = page.getAspectRatio();
/* 37 */       double paperaspect = pwidth / pheight;
/*    */       Rectangle imgbounds;
/*    */       //Rectangle imgbounds;
/* 41 */       if (aspect > paperaspect)
/*    */       {
/* 43 */         int height = (int)(pwidth / aspect);
/* 44 */         imgbounds = new Rectangle(
/* 45 */           (int)format.getImageableX(), 
/* 46 */           (int)(format.getImageableY() + (pheight - height) / 2.0D), 
/* 47 */           (int)pwidth, 
/* 48 */           height);
/*    */       }
/*    */       else
/*    */       {
/* 52 */         int width = (int)(pheight * aspect);
/* 53 */         imgbounds = new Rectangle(
/* 54 */           (int)(format.getImageableX() + (pwidth - width) / 2.0D), 
/* 55 */           (int)format.getImageableY(), 
/* 56 */           width, 
/* 57 */           (int)pheight);
/*    */       }
/*    */ 
/* 62 */       PDFRenderer pgs = new PDFRenderer(page, g2, imgbounds, null, null);
/*    */       try {
/* 64 */         page.waitForFinish();
/* 65 */         pgs.run();
/*    */       } catch (InterruptedException localInterruptedException) {
/*    */       }
/* 68 */       return 0;
/*    */     }
/* 70 */     return 1;
/*    */   }
/*    */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.app.PDFPrintPage
 * JD-Core Version:    0.6.0
 */