/*     */ package test;
/*     */ 
/*     */ import com.sun.pdfview.PDFFile;
/*     */ import com.sun.pdfview.PDFObject;
/*     */ import com.sun.pdfview.PDFPage;
/*     */ import com.sun.pdfview.font.OutlineFont;
/*     */ import com.sun.pdfview.font.PDFFont;
/*     */ import com.sun.pdfview.font.PDFGlyph;
/*     */ import com.sun.pdfview.font.Type3Font;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.Shape;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.ItemListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.CubicCurve2D;
/*     */ import java.awt.geom.CubicCurve2D.Float;
/*     */ import java.awt.geom.GeneralPath;
/*     */ import java.awt.geom.Line2D;
/*     */ import java.awt.geom.Line2D.*;
/*     */ import java.awt.geom.PathIterator;
/*     */ import java.awt.geom.QuadCurve2D;
/*     */ import java.awt.geom.QuadCurve2D.*;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.Vector;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.Box;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.SpinnerListModel;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ import javax.swing.filechooser.FileFilter;
/*     */ 
/*     */ public class FontToy extends JPanel
/*     */ {
/*     */   JComboBox comboBox;
/*  64 */   private JMenuItem exitMenuItem = new JMenuItem("Exit");
/*     */ 
/*  67 */   private JFileChooser openFileChooser = null;
/*     */ 
/*  70 */   private JMenu fileMenu = new JMenu("File");
/*     */   private Set fonts;
/*     */   private PDFFont font;
/*  79 */   private JFrame jf = new JFrame("Font Toy");
/*     */   private Font gfont;
/*     */   private PDFGlyph glyph;
/*     */   private JComboBox glyphBox;
/*  91 */   private SpinnerListModel glyphModel = new SpinnerListModel();
/*     */ 
/*  94 */   private JLabel glyphName = new JLabel();
/*     */ 
/*  97 */   private JSpinner glyphSpinner = new JSpinner(this.glyphModel);
/*     */ 
/* 100 */   private File inputFile = null;
/*     */ 
/* 103 */   private JMenuBar menuBar = new JMenuBar();
/*     */ 
/* 106 */   private JMenuItem openMenuItem = new JMenuItem("Open");
/*     */ 
/* 109 */   private PDFFile pdf = null;
/*     */ 
/*     */   public FontToy(String[] args) throws IOException
/*     */   {
/* 113 */     Box controlPanel = Box.createHorizontalBox();
/*     */ 
/* 115 */     this.glyphBox = new JComboBox();
/* 116 */     this.glyphBox.addItemListener(new ItemListener() {
/*     */       public void itemStateChanged(ItemEvent ie) {
/* 118 */         if (ie.getStateChange() == 1) {
/* 119 */           Integer value = (Integer)ie.getItem();
/* 120 */           FontToy.this.glyphSelected(value);
/* 121 */           FontToy.this.glyphSpinner.setValue(value);
/*     */         }
/*     */       }
/*     */     });
/* 127 */     this.comboBox = new JComboBox();
/* 128 */     this.comboBox.addItemListener(new ItemListener() {
/*     */       public void itemStateChanged(ItemEvent ie) {
/* 130 */         if (ie.getStateChange() == 1)
/* 131 */           FontToy.this.fontSelected((PDFFont)ie.getItem());
/*     */       }
/*     */     });
/* 136 */     this.comboBox.setMaximumSize(new Dimension(200, 50));
/*     */ 
/* 138 */     controlPanel.add(new JLabel("Fonts:"));
/* 139 */     controlPanel.add(this.comboBox);
/*     */ 
/* 141 */     controlPanel.add(Box.createHorizontalStrut(15));
/*     */ 
/* 143 */     controlPanel.add(new JLabel("Glyphs:"));
/* 144 */     controlPanel.add(this.glyphBox);
/* 145 */     controlPanel.add(this.glyphName);
/* 146 */     controlPanel.add(this.glyphSpinner);
/*     */ 
/* 148 */     JPanel ftPanel = new JPanel();
/* 149 */     ftPanel.setLayout(new BorderLayout());
/*     */ 
/* 151 */     ftPanel.add(controlPanel, "North");
/* 152 */     ftPanel.add(this, "Center");
/*     */ 
/* 154 */     ftPanel.setFocusable(true);
/* 155 */     ftPanel.requestFocus();
/* 156 */     ftPanel.addKeyListener(new KeyAdapter()
/*     */     {
/*     */       public void keyTyped(KeyEvent k) {
/* 159 */         keyPressed(k);
/*     */       }
/*     */     });
/* 163 */     this.jf.setContentPane(ftPanel);
/*     */ 
/* 165 */     this.jf.addWindowListener(new WindowAdapter()
/*     */     {
/*     */       public void windowClosing(WindowEvent we) {
/* 168 */         System.exit(-1);
/*     */       }
/*     */     });
/* 172 */     this.jf.setSize(640, 480);
/*     */ 
/* 174 */     this.jf.setVisible(true);
/* 175 */     this.jf.setJMenuBar(this.menuBar);
/* 176 */     this.menuBar.add(this.fileMenu);
/* 177 */     this.fileMenu.add(this.openMenuItem);
/* 178 */     this.fileMenu.addSeparator();
/* 179 */     this.fileMenu.add(this.exitMenuItem);
/*     */ 
/* 181 */     this.openMenuItem.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 183 */         FontToy.this.openPDF();
/*     */       }
/*     */     });
/* 186 */     this.glyphSpinner.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent e) {
/* 188 */         Integer value = (Integer)FontToy.this.glyphSpinner.getValue();
/* 189 */         FontToy.this.glyphSelected(value);
/* 190 */         FontToy.this.glyphBox.setSelectedItem(value);
/*     */       }
/*     */     });
/* 195 */     if (args.length > 0)
/* 196 */       initialize(args[0]);
/*     */   }
/*     */ 
/*     */   private void drawShape(Graphics2D g2, GeneralPath gp, int w, int h)
/*     */   {
/* 207 */     float curX = 0.0F;
/* 208 */     float curY = 0.0F;
/* 209 */     float startX = 0.0F;
/* 210 */     float startY = 0.0F;
/*     */ 
/* 212 */     Rectangle2D border = gp.getBounds2D();
/*     */ 
/* 214 */     double scaleX = (w - 20) / border.getWidth();
/* 215 */     double scaleY = (h - 20) / border.getHeight();
/*     */ 
/* 217 */     if (scaleX < scaleY)
/* 218 */       scaleY = scaleX;
/*     */     else {
/* 220 */       scaleX = scaleY;
/*     */     }
/*     */ 
/* 223 */     double transX = 10.0D - border.getX() * scaleX;
/* 224 */     double transY = h - 10 + border.getY() * scaleY;
/*     */ 
/* 226 */     AffineTransform at = new AffineTransform(scaleX, 0.0D, 0.0D, -scaleY, transX, transY);
/*     */ 
/* 229 */     Rectangle2D borderTrans = gp.createTransformedShape(at).getBounds2D();
/*     */ 
/* 231 */     g2.setColor(Color.CYAN);
/* 232 */     g2.fill(gp.createTransformedShape(at));
/* 233 */     g2.setColor(Color.BLACK);
/*     */ 
/* 235 */     int num = 0;
/*     */ 
/* 237 */     PathIterator pi = gp.getPathIterator(at);
/* 238 */     while (!pi.isDone()) {
/* 239 */       float[] coords = new float[6];
/*     */ 
/* 241 */       switch (pi.currentSegment(coords)) {
/*     */       case 0:
/* 243 */         curX = coords[0];
/* 244 */         curY = coords[1];
/* 245 */         drawPoint(g2, num++, curX, curY, false);
/* 246 */         startX = curX;
/* 247 */         startY = curY;
/* 248 */         break;
/*     */       case 1:
/* 251 */         Line2D line = new Line2D.Float(curX, curY, coords[0], coords[1]);
/* 252 */         g2.draw(line);
/* 253 */         drawPoint(g2, num++, coords[0], coords[1], false);
/* 254 */         curX = coords[0];
/* 255 */         curY = coords[1];
/* 256 */         break;
/*     */       case 3:
/* 259 */         CubicCurve2D curve = new CubicCurve2D.Float(curX, curY, coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
/*     */ 
/* 266 */         g2.draw(curve);
/* 267 */         drawPoint(g2, num++, coords[0], coords[1], true);
/* 268 */         drawPoint(g2, num++, coords[2], coords[3], true);
/* 269 */         drawPoint(g2, num++, coords[4], coords[5], false);
/* 270 */         curX = coords[4];
/* 271 */         curY = coords[5];
/* 272 */         break;
/*     */       case 2:
/* 275 */         QuadCurve2D curveQ = new QuadCurve2D.Float(curX, curY, coords[0], coords[1], coords[2], coords[3]);
/*     */ 
/* 280 */         g2.draw(curveQ);
/* 281 */         drawPoint(g2, num++, coords[0], coords[1], true);
/* 282 */         drawPoint(g2, num++, coords[2], coords[3], false);
/* 283 */         curX = coords[2];
/* 284 */         curY = coords[3];
/* 285 */         break;
/*     */       case 4:
/* 288 */         Line2D.Float line2 = new Line2D.Float(curX, curY, startX, startY);
/* 289 */         g2.draw(line2);
/* 290 */         curX = startX;
/* 291 */         curY = startY;
/*     */       }
/*     */ 
/* 294 */       pi.next();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void drawPoint(Graphics2D g, int num, float x, float y, boolean curvectl)
/*     */   {
/* 303 */     GeneralPath gp = new GeneralPath();
/* 304 */     if (curvectl) {
/* 305 */       gp.moveTo(x - 1.0F, y - 1.0F);
/* 306 */       gp.lineTo(x + 1.0F, y + 1.0F);
/* 307 */       gp.moveTo(x - 1.0F, y + 1.0F);
/* 308 */       gp.lineTo(x + 1.0F, y - 1.0F);
/*     */     } else {
/* 310 */       gp.moveTo(x - 1.0F, y - 1.0F);
/* 311 */       gp.lineTo(x - 1.0F, y + 1.0F);
/* 312 */       gp.lineTo(x + 1.0F, y + 1.0F);
/* 313 */       gp.lineTo(x + 1.0F, y - 1.0F);
/* 314 */       gp.closePath();
/*     */     }
/*     */ 
/* 317 */     g.setColor(Color.red);
/* 318 */     g.draw(gp);
/* 319 */     g.setColor(Color.blue);
/* 320 */     g.setFont(this.gfont);
/* 321 */     g.drawString(String.valueOf(num), x + 3.0F, y + 3.0F);
/*     */   }
/*     */ 
/*     */   private void drawPage(Graphics2D g2, PDFPage page, int w, int h)
/*     */   {
/* 330 */     Dimension pageSize = page.getUnstretchedSize(w - 20, h - 20, null);
/* 331 */     Image image = page.getImage(pageSize.width, pageSize.height, null, null, true, true);
/*     */ 
/* 333 */     g2.drawImage(image, 0, 0, null);
/*     */   }
/*     */ 
/*     */   private Set<PDFFont> findFonts(PDFObject pagedict, Map<String, PDFObject> resources)
/*     */     throws IOException
/*     */   {
/* 344 */     Set outSet = new HashSet();
/*     */ 
/* 346 */     PDFObject rsrcObj = pagedict.getDictRef("Resources");
/* 347 */     if (rsrcObj != null)
/*     */     {
/* 350 */       HashMap rsrcMap = new HashMap();
/* 351 */       rsrcMap.putAll(resources);
/*     */ 
/* 353 */       Map rsrc = rsrcObj.getDictionary();
/* 354 */       rsrcMap.putAll(rsrc);
/*     */       PDFObject fontsObj;
/*     */       Iterator i;
/* 356 */       if (rsrc.containsKey("Font")) {
/* 357 */         fontsObj = (PDFObject)rsrc.get("Font");
/*     */ 
/* 359 */         for (i = fontsObj.getDictKeys(); i.hasNext(); ) {
/* 360 */           String key = (String)i.next();
/* 361 */           PDFObject fontObj = fontsObj.getDictRef(key);
/*     */           try
/*     */           {
/* 364 */             PDFFont font = PDFFont.getFont(fontObj, rsrcMap);
/*     */ 
/* 368 */             outSet.add(font);
/*     */           }
/*     */           catch (Exception ex) {
/* 371 */             System.out.println("Error finding font from " + fontObj);
/* 372 */             ex.printStackTrace();
/*     */           }
/*     */         }
/*     */       }
/*     */       PDFObject xobjsObj;
/*     */       Iterator i1;
/* 378 */       if (rsrc.containsKey("XObject")) {
/* 379 */         xobjsObj = (PDFObject)rsrc.get("XObject");
/*     */ 
/* 381 */         for (i1 = xobjsObj.getDictKeys(); i1.hasNext(); ) {
/* 382 */           String key = (String)i1.next();
/* 383 */           PDFObject xobj = xobjsObj.getDictRef(key);
/* 384 */           outSet.addAll(findFonts(xobj, new HashMap()));
/*     */         }
/*     */       }
/* 387 */       resources = rsrcMap;
/*     */     }
/*     */ 
/* 390 */     PDFObject kidsObj = pagedict.getDictRef("Kids");
/*     */     PDFObject[] kids;
/*     */     int i;
/* 391 */     if (kidsObj != null) {
/* 392 */       kids = kidsObj.getArray();
/* 393 */       for (i = 0; i < kids.length; )
/*     */       {
/* 395 */         outSet.addAll(findFonts(kids[i], resources));
/*     */ 
/* 394 */         i++;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 399 */     return outSet;
/*     */   }
/*     */ 
/*     */   private void fontSelected(PDFFont font)
/*     */   {
/* 408 */     setCurrentFont(font);
/*     */ 
/* 410 */     int start = 0;
/* 411 */     int end = 255;
/*     */ 
/* 413 */     if ((font instanceof OutlineFont)) {
/* 414 */       start = ((OutlineFont)font).getFirstChar();
/* 415 */       end = ((OutlineFont)font).getLastChar();
/* 416 */     } else if ((font instanceof Type3Font)) {
/* 417 */       start = ((Type3Font)font).getFirstChar();
/* 418 */       end = ((Type3Font)font).getLastChar();
/*     */     }
/*     */ 
/* 421 */     if (start < 0) {
/* 422 */       start = 0;
/*     */     }
/*     */ 
/* 425 */     if (end < 0) {
/* 426 */       end = 255;
/*     */     }
/*     */ 
/* 429 */     Vector objs = new Vector(end - start + 1);
/* 430 */     for (int i = start; i <= end; i++) {
/* 431 */       objs.add(new Integer(i));
/*     */     }
/*     */ 
/* 434 */     this.glyphBox.setModel(new DefaultComboBoxModel(objs));
/* 435 */     this.glyphModel = new SpinnerListModel(objs);
/* 436 */     this.glyphSpinner.setModel(this.glyphModel);
/* 437 */     Integer select = new Integer(start);
/* 438 */     glyphSelected(select);
/*     */   }
/*     */ 
/*     */   public Set getFonts()
/*     */   {
/* 443 */     return this.fonts;
/*     */   }
/*     */ 
/*     */   public PDFFont getCurrentFont()
/*     */   {
/* 448 */     return this.font;
/*     */   }
/*     */ 
/*     */   private void glyphSelected(Integer glyphID)
/*     */   {
/* 458 */     char glyphChar = (char)glyphID.intValue();
/* 459 */     String s = String.valueOf(glyphChar);
/* 460 */     PDFFont font = getCurrentFont();
/* 461 */     List l = font.getGlyphs(s);
/* 462 */     PDFGlyph glyph = (PDFGlyph)l.get(0);
/* 463 */     setCurrentGlyph(glyph);
/* 464 */     repaint();
/*     */   }
/*     */ 
/*     */   private void initialize(String fileName) throws IOException {
/* 468 */     this.jf.setTitle("PDFRenderer Font Toy - " + fileName);
/*     */     try {
/* 470 */       this.inputFile = new File(fileName);
/* 471 */       FileInputStream istr = new FileInputStream(this.inputFile);
/* 472 */       byte[] buf = new byte[(int)this.inputFile.length()];
/* 473 */       int read = 0;
/* 474 */       int offset = 0;
/* 475 */       while (read >= 0) {
/* 476 */         read = istr.read(buf, offset, buf.length - offset);
/*     */       }
/* 478 */       istr.close();
/* 479 */       ByteBuffer byteBuf = ByteBuffer.allocate(buf.length);
/* 480 */       byteBuf.put(buf);
/* 481 */       this.pdf = new PDFFile(byteBuf);
/*     */     } catch (Exception ex) {
/* 483 */       ex.printStackTrace();
/*     */     }
/* 485 */     PDFObject root = this.pdf.getRoot();
/* 486 */     PDFObject pagesObj = root.getDictRef("Pages");
/* 487 */     this.fonts = findFonts(pagesObj, new HashMap());
/* 488 */     this.gfont = new Font("Sans-serif", 0, 10);
/* 489 */     Object[] fontObjs = getFonts().toArray();
/* 490 */     this.comboBox.setModel(new DefaultComboBoxModel(fontObjs));
/* 491 */     fontSelected((PDFFont)fontObjs[0]);
/* 492 */     validate();
/*     */   }
/*     */ 
/*     */   public PDFGlyph getCurrentGlyph()
/*     */   {
/* 497 */     return this.glyph;
/*     */   }
/*     */ 
/*     */   private void keyPressed(KeyEvent k)
/*     */   {
/* 504 */     int curIndex = this.glyphBox.getSelectedIndex();
/* 505 */     int nextIndex = curIndex;
/*     */ 
/* 507 */     if (k.getKeyCode() == 37) {
/* 508 */       nextIndex--;
/* 509 */       if (nextIndex < 0) {
/* 510 */         nextIndex = this.glyphBox.getItemCount() - 1;
/*     */       }
/*     */     }
/* 513 */     else if (k.getKeyCode() == 39) {
/* 514 */       nextIndex++;
/*     */ 
/* 516 */       if (nextIndex >= this.glyphBox.getItemCount()) {
/* 517 */         nextIndex = 0;
/*     */       }
/*     */     }
/*     */ 
/* 521 */     if (nextIndex != curIndex)
/* 522 */       this.glyphBox.setSelectedIndex(nextIndex);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
				FontToy toy;
/* 532 */       toy = new FontToy(args);
/*     */     }
/*     */     catch (IOException ex)
/*     */     {
/*     */       
/* 534 */       Logger.getLogger(FontToy.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void openPDF()
/*     */   {
/* 542 */     if (this.openFileChooser == null) {
/* 543 */       this.openFileChooser = new JFileChooser(this.inputFile);
/* 544 */       this.openFileChooser.setAcceptAllFileFilterUsed(false);
/* 545 */       this.openFileChooser.addChoosableFileFilter(new FileFilter() {
/*     */         public boolean accept(File file) {
/* 547 */           return (file.isDirectory()) || (file.getName().toLowerCase().endsWith(".pdf"));
/*     */         }
/*     */ 
/*     */         public String getDescription() {
/* 551 */           return "PDF Files (*.pdf)";
/*     */         }
/*     */       });
/*     */     }
/* 556 */     switch (this.openFileChooser.showOpenDialog(this)) {
/*     */     case 0:
/*     */       try {
/* 559 */         initialize(this.openFileChooser.getSelectedFile().getPath());
/*     */       } catch (IOException ex) {
/* 561 */         Logger.getLogger(FontToy.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/* 575 */     Graphics2D g2 = (Graphics2D)g;
/*     */ 
/* 577 */     int width = getWidth();
/* 578 */     int height = getHeight();
/*     */ 
/* 580 */     g2.setColor(Color.WHITE);
/* 581 */     g2.fillRect(0, 0, width, height);
/*     */ 
/* 583 */     g2.setColor(Color.BLACK);
/*     */ 
/* 585 */     if (this.glyph == null) {
/* 586 */       return;
/*     */     }
/*     */ 
/* 589 */     GeneralPath gp = this.glyph.getShape();
/* 590 */     PDFPage page = this.glyph.getPage();
/* 591 */     if (gp != null)
/* 592 */       drawShape(g2, gp, width, height);
/* 593 */     else if (page != null)
/* 594 */       drawPage(g2, page, width, height);
/*     */   }
/*     */ 
/*     */   public void setCurrentFont(PDFFont font)
/*     */   {
/* 601 */     this.font = font;
/*     */   }
/*     */ 
/*     */   public void setCurrentGlyph(PDFGlyph glyph)
/*     */   {
/* 606 */     this.glyph = glyph;
/* 607 */     this.glyphName.setText(glyph.getName());
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     test.FontToy
 * JD-Core Version:    0.6.0
 */