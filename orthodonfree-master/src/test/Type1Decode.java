/*     */ package test;
/*     */ 
/*     */ import com.sun.pdfview.HexDump;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class Type1Decode
/*     */ {
/*     */   private static byte[] decrypt(byte[] d, int start, int end, int key, int skip)
/*     */   {
/*  40 */     if (end - start - skip < 0) {
/*  41 */       skip = 0;
/*     */     }
/*  43 */     byte[] o = new byte[end - start - skip];
/*  44 */     int r = key;
/*     */ 
/*  46 */     int c1 = 52845;
/*  47 */     int c2 = 22719;
/*  48 */     for (int ipos = start; ipos < end; ipos++) {
/*  49 */       int c = d[ipos] & 0xFF;
/*  50 */       int p = (c ^ r >> 8) & 0xFF;
/*     */ 
/*  52 */       if (ipos - start < 16) {
/*  53 */         System.out.println("c = " + Integer.toHexString(c) + ", p = " + Integer.toHexString(p) + ", r = " + Integer.toHexString(r));
/*     */       }
/*     */ 
/*  58 */       r = (c + r) * c1 + c2 & 0xFFFF;
/*  59 */       if (ipos - start - skip >= 0) {
/*  60 */         o[(ipos - start - skip)] = (byte)p;
/*     */       }
/*     */     }
/*  63 */     return o;
/*     */   }
/*     */ 
/*     */   private static byte[] readASCII(byte[] data, int start, int end)
/*     */   {
/*  69 */     byte[] o = new byte[(end - start) / 2];
/*     */ 
/*  71 */     int count = 0;
/*  72 */     int bit = 0;
/*     */ 
/*  74 */     for (int loc = start; loc < end; loc++) {
/*  75 */       char c = (char)(data[loc] & 0xFF);
/*  76 */       byte b = 0;
/*     */ 
/*  78 */       if ((c >= '0') && (c <= '9')) {
/*  79 */         b = (byte)(c - '0');
/*  80 */       } else if ((c >= 'a') && (c <= 'f')) {
/*  81 */         b = (byte)(10 + (c - 'a')); } else {
/*  82 */         if ((c < 'A') || (c > 'F')) continue;
/*  83 */         b = (byte)(10 + (c - 'A'));
/*     */       }
/*     */ 
/*  90 */       if (bit++ % 2 == 0) {
/*  91 */         o[count] = (byte)(b << 4);
/*     */       }
/*     */       else
/*     */       {
/*     */         int tmp143_140 = (count++);
/*     */         byte[] tmp143_137 = o; tmp143_137[tmp143_140] = (byte)(tmp143_137[tmp143_140] | b);
/*     */       }
/*     */     }
/*     */ 
/*  97 */     return o;
/*     */   }
/*     */ 
/*     */   private static boolean isASCII(byte[] data, int start)
/*     */   {
/* 102 */     for (int i = start; i < start + 4; i++)
/*     */     {
/* 104 */       char c = (char)(data[i] & 0xFF);
/*     */ 
/* 106 */       if ((c >= '0') && (c <= '9'))
/*     */         continue;
/* 108 */       if ((c >= 'a') && (c <= 'f'))
/*     */         continue;
/* 110 */       if ((c < 'A') || (c > 'F'))
/*     */       {
/* 114 */         return false;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 119 */     return true;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 127 */     if (args.length < 1) {
/* 128 */       System.out.println("Usage:");
/* 129 */       System.out.println("    Type1Decode <filename> <decode-start>");
/* 130 */       System.exit(-1);
/*     */     }
/*     */     try
/*     */     {
/* 134 */       File file = new File(args[0]);
/*     */ 
/* 136 */       if ((!file.exists()) || (!file.canRead())) {
/* 137 */         System.out.println("Can't read file: " + args[0]);
/* 138 */         System.exit(-1);
/*     */       }
/*     */ 
/* 141 */       FileInputStream fis = new FileInputStream(file);
/*     */ 
/* 143 */       byte[] data = new byte[(int)file.length()];
/* 144 */       int cur = 0;
/* 145 */       while (cur < file.length()) {
/* 146 */         cur += fis.read(data, cur, data.length - cur);
/*     */       }
/*     */ 
/* 149 */       int start = 0;
/*     */ 
/* 151 */       if ((data[0] & 0xFF) == 128) {
/* 152 */         start = data[2] & 0xFF;
/* 153 */         start |= (data[3] & 0xFF) << 8;
/* 154 */         start |= (data[4] & 0xFF) << 16;
/* 155 */         start |= (data[5] & 0xFF) << 24;
/*     */ 
/* 157 */         start += 6;
/* 158 */       } else if (args.length > 1) {
/* 159 */         start = Integer.parseInt(args[1]);
/*     */       } else {
/* 161 */         System.out.println("Unable to read size");
/* 162 */         System.exit(-1);
/*     */       }
/*     */ 
/* 165 */       int size = data.length - start;
/*     */ 
/* 167 */       if (isASCII(data, start)) {
/* 168 */         data = readASCII(data, start, size);
/* 169 */         start = 0;
/* 170 */         size = data.length;
/* 171 */       } else if ((data[start] & 0xFF) == 128) {
/* 172 */         size = data[(start + 2)] & 0xFF;
/* 173 */         size |= (data[(start + 3)] & 0xFF) << 8;
/* 174 */         size |= (data[(start + 4)] & 0xFF) << 16;
/* 175 */         size |= (data[(start + 5)] & 0xFF) << 24;
/*     */ 
/* 177 */         start += 6;
/*     */       }
/*     */ 
/* 180 */       byte[] outData = decrypt(data, start, start + size, 55665, 4);
/*     */ 
/* 182 */       HexDump.printData(outData);
/*     */     }
/*     */     catch (Exception ex) {
/* 185 */       ex.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     test.Type1Decode
 * JD-Core Version:    0.6.0
 */