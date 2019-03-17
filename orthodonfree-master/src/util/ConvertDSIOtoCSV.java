/*     */ package util;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ public class ConvertDSIOtoCSV
/*     */ {
/*     */   public ConvertDSIOtoCSV(String pathDSIO, String pathCSV)
/*     */   {
/*  17 */     long debut = System.currentTimeMillis();
/*  18 */     File theFile = new File(pathDSIO);
/*  19 */     String ligne = "";
/*  20 */     BufferedReader lecteurAvecBuffer = null;
/*     */     try {
/*  22 */       lecteurAvecBuffer = new BufferedReader(new FileReader(theFile));
/*     */     }
/*     */     catch (FileNotFoundException exc) {
/*  25 */       System.out.println("Erreur d'ouverture");
/*     */     }
/*     */     try {
/*  28 */       int cpt = 1;
/*  29 */       StringBuffer stb = new StringBuffer();
/*  30 */       stb.append("Patien N°,Nom,Prenom,Civilité,Date Naissance,N°Sécu,Adresse1,Adresse2,Code Postal,Ville,Téléphone,\n");
/*  31 */       while ((ligne = lecteurAvecBuffer.readLine()) != null)
/*     */       {
/*  34 */         if (ligne.startsWith("#PTN"))
/*     */         {
/*  36 */           stb.append(cpt + "," + ligne.substring(4));
/*  37 */           cpt++;
/*     */         }
/*  39 */         else if (ligne.startsWith("#PTP"))
/*     */         {
/*  41 */           stb.append("," + ligne.substring(4));
/*     */         }
/*  43 */         else if (ligne.startsWith("#PTG"))
/*     */         {
/*  45 */           stb.append("," + ligne.substring(4));
/*     */         }
/*  47 */         else if (ligne.startsWith("#PTD")) {
/*  48 */           String dateNais = "";
/*  49 */           if (ligne.substring(4).length() > 0) dateNais = ligne.substring(4); else
/*  50 */             dateNais = "00000000";
/*  51 */           SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
/*  52 */           Date theDate = null;
/*  53 */           if (dateNais.length() > 0) theDate = sf.parse(dateNais);
/*  54 */           SimpleDateFormat sff = new SimpleDateFormat("dd-MM-yyyy");
/*  55 */           if (dateNais.length() > 0)
/*     */           {
/*  57 */             stb.append("," + sff.format(theDate));
/*     */           }
/*     */           else {
/*  60 */             stb.append(",");
/*     */           }
/*     */         }
/*  63 */         else if (ligne.startsWith("#PTI"))
/*     */         {
/*  65 */           stb.append("," + ligne.substring(4).trim());
/*     */         }
/*  67 */         else if (ligne.startsWith("#AA1"))
/*     */         {
/*  69 */           if (ligne.substring(4).length() > 0) stb.append("," + ligne.substring(4)); else
/*  70 */             stb.append(", ");
/*     */         }
/*  72 */         else if (ligne.startsWith("#AA2"))
/*     */         {
/*  74 */           if (ligne.substring(4).length() > 0) stb.append("," + ligne.substring(4)); else
/*  75 */             stb.append(", ");
/*     */         }
/*  77 */         else if (ligne.startsWith("#ACP"))
/*     */         {
/*  79 */           if (ligne.substring(4).length() > 0) stb.append("," + ligne.substring(4)); else
/*  80 */             stb.append(", ");
/*     */         }
/*  82 */         else if (ligne.startsWith("#AVI"))
/*     */         {
/*  84 */           if (ligne.substring(4).length() > 0) stb.append("," + ligne.substring(4)); else
/*  85 */             stb.append(", ");
/*     */         } else {
/*  87 */           if (!ligne.startsWith("#ATD"))
/*     */             continue;
/*  89 */           if (ligne.substring(4).length() > 0) stb.append("," + ligne.substring(4) + "\n"); else {
/*  90 */             stb.append(", \n");
/*     */           }
/*     */         }
/*     */       }
/*  94 */       File ff = new File(pathCSV);
/*  95 */       FileWriter fw = new FileWriter(ff);
/*  96 */       fw.write(stb.toString());
/*  97 */       fw.close();
/*  98 */       long fin = System.currentTimeMillis();
/*  99 */       System.out.println("Temps de traitement DSIO to CSV = " + (fin - debut) + " millisecondes");
/* 100 */       JOptionPane.showMessageDialog(null, "Importation DSIO to CSV effectuée en " + (fin - debut) + "ms");
/*     */     }
/*     */     catch (Exception e) {
/* 103 */       e.printStackTrace();
/*     */     }
/*     */     try {
/* 106 */       lecteurAvecBuffer.close();
/*     */     }
/*     */     catch (IOException e) {
/* 109 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 116 */     if (args.length != 0)
/*     */     {
/* 118 */       long debut = System.currentTimeMillis();
/* 119 */       File theFile = new File(args[0]);
/* 120 */       String ligne = "";
/* 121 */       BufferedReader lecteurAvecBuffer = null;
/*     */       try {
/* 123 */         lecteurAvecBuffer = new BufferedReader(new FileReader(theFile));
/*     */       }
/*     */       catch (FileNotFoundException exc) {
/* 126 */         System.out.println("Erreur d'ouverture");
/*     */       }
/*     */       try {
/* 129 */         int cpt = 1;
/* 130 */         StringBuffer stb = new StringBuffer();
/* 131 */         stb.append("Patien N°,Nom,Prenom,Civilité,Date Naissance,N°Sécu,Adresse1,Adresse2,Code Postal,Ville,Téléphone,\n");
/* 132 */         while ((ligne = lecteurAvecBuffer.readLine()) != null)
/*     */         {
/* 135 */           if (ligne.startsWith("#PTN"))
/*     */           {
/* 137 */             stb.append(cpt + "," + ligne.substring(4));
/* 138 */             cpt++;
/*     */           }
/* 140 */           else if (ligne.startsWith("#PTP"))
/*     */           {
/* 142 */             stb.append("," + ligne.substring(4));
/*     */           }
/* 144 */           else if (ligne.startsWith("#PTG"))
/*     */           {
/* 146 */             stb.append("," + ligne.substring(4));
/*     */           }
/* 148 */           else if (ligne.startsWith("#PTD")) {
/* 149 */             String dateNais = "";
/* 150 */             if (ligne.substring(4).length() > 0) dateNais = ligne.substring(4); else
/* 151 */               dateNais = "00000000";
/* 152 */             SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
/* 153 */             Date theDate = null;
/* 154 */             if (dateNais.length() > 0) theDate = sf.parse(dateNais);
/* 155 */             SimpleDateFormat sff = new SimpleDateFormat("dd-MM-yyyy");
/* 156 */             if (dateNais.length() > 0)
/*     */             {
/* 158 */               stb.append("," + sff.format(theDate));
/*     */             }
/*     */             else {
/* 161 */               stb.append(", ");
/*     */             }
/*     */           }
/* 164 */           else if (ligne.startsWith("#PTI"))
/*     */           {
/* 166 */             if (ligne.substring(4).length() > 0) stb.append("," + ligne.substring(4)); else
/* 167 */               stb.append(", ");
/*     */           }
/* 169 */           else if (ligne.startsWith("#AA1"))
/*     */           {
/* 171 */             if (ligne.substring(4).length() > 0) stb.append("," + ligne.substring(4)); else
/* 172 */               stb.append(", ");
/*     */           }
/* 174 */           else if (ligne.startsWith("#AA2"))
/*     */           {
/* 176 */             if (ligne.substring(4).length() > 0) stb.append("," + ligne.substring(4)); else
/* 177 */               stb.append(", ");
/*     */           }
/* 179 */           else if (ligne.startsWith("#ACP"))
/*     */           {
/* 181 */             if (ligne.substring(4).length() > 0) stb.append("," + ligne.substring(4)); else
/* 182 */               stb.append(", ");
/*     */           }
/* 184 */           else if (ligne.startsWith("#AVI"))
/*     */           {
/* 186 */             if (ligne.substring(4).length() > 0) stb.append("," + ligne.substring(4)); else
/* 187 */               stb.append(", ");
/*     */           } else {
/* 189 */             if (!ligne.startsWith("#ATD"))
/*     */               continue;
/* 191 */             if (ligne.substring(4).length() > 0) stb.append("," + ligne.substring(4) + "\n"); else {
/* 192 */               stb.append(", \n");
/*     */             }
/*     */           }
/*     */         }
/* 196 */         File ff = new File(args[1]);
/* 197 */         FileWriter fw = new FileWriter(ff);
/* 198 */         fw.write(stb.toString());
/* 199 */         fw.close();
/* 200 */         long fin = System.currentTimeMillis();
/* 201 */         System.out.println("Temps de traitement DSIO to CSV = " + (fin - debut) + " millisecondes");
/*     */       }
/*     */       catch (Exception e) {
/* 204 */         e.printStackTrace();
/*     */       }
/*     */       try {
/* 207 */         lecteurAvecBuffer.close();
/*     */       }
/*     */       catch (IOException e) {
/* 210 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 215 */       System.out.println("Usage de l'import DSIO :\n\n Se positionner dans le dossier qui contient le Fichier de données DSIO :\n\n~$ cd <nom_repertoire_dsio>\n~$ java util.ImportDsio ./DSIO_DELLESTABLE\\ HENRI.txt ./DSIO_DELLESTABLE\\ HENRI.csv");
/*     */     }
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     util.ConvertDSIOtoCSV
 * JD-Core Version:    0.6.0
 */