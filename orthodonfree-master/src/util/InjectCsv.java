/*     */ package util;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.StringTokenizer;
/*     */ import small.app.ConnexionDB;
/*     */ import small.data.Patient;
/*     */ 
/*     */ public class InjectCsv
/*     */ {
/*  20 */   private static ConnexionDB dbconn = null;
/*  21 */   private Connection connec = null;
/*  22 */   private String csvPath = "";
/*     */ 
/*     */   public InjectCsv(String pathCSV) throws ClassNotFoundException, SQLException {
/*  25 */     dbconn = new ConnexionDB();
/*  26 */     this.connec = dbconn.getConnexion();
/*  27 */     this.csvPath = pathCSV;
/*     */   }
/*     */ 
/*     */   public int execute() {
/*  31 */     Patient patient = new Patient();
/*  32 */     File fcsv = new File(this.csvPath);
/*  33 */     String ligne = "";
/*  34 */     int nbCorrespondances = 0;
/*  35 */     StringBuffer stb = new StringBuffer();
/*  36 */     BufferedReader lecteurAvecBuffer = null;
/*     */     try {
/*  38 */       lecteurAvecBuffer = new BufferedReader(new FileReader(fcsv)); } catch (FileNotFoundException exc) {
/*  39 */       System.out.println("Erreur d'ouverture"); exc.printStackTrace();
/*     */     }try {
/*  41 */       int cpt = 0;
/*  42 */       while ((ligne = lecteurAvecBuffer.readLine()) != null) {
/*  43 */         if (cpt > 0) {
/*  44 */           StringTokenizer st = new StringTokenizer(ligne, ",");
/*     */ 
/*  50 */           int num = Integer.parseInt(st.nextToken());
/*  51 */           patient.setNom(st.nextToken());
/*  52 */           patient.setPrenom(st.nextToken());
/*  53 */           patient.setCivilite(st.nextToken());
/*  54 */           patient.setDateNaiss(st.nextToken());
/*  55 */           patient.setNumSecu(st.nextToken());
/*  56 */           patient.setAdresse1(st.nextToken());
/*  57 */           patient.setAdresse2(st.nextToken());
/*  58 */           patient.setCodePostal(st.nextToken());
/*  59 */           patient.setVille(st.nextToken());
/*  60 */           patient.setTelephone(st.nextToken());
/*     */ 
/*  63 */           String[] params = new String[3];
/*  64 */           params[0] = patient.getNom().toUpperCase();
/*  65 */           params[1] = patient.getPrenom().toUpperCase();
/*  66 */           Date datenaiss = null;
/*  67 */           SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
/*     */           try {
/*  69 */             datenaiss = df.parse(patient.getDateNaiss());
/*     */           }
/*     */           catch (ParseException e) {
/*  72 */             e.printStackTrace();
/*     */           }
/*  74 */           params[2] = String.valueOf(datenaiss.getTime());
/*  75 */           System.out.print("Recherche pour : " + params[0] + "-" + params[1] + "-" + params[2] + "==> ");
/*  76 */           stb.append("Recherche pour : " + params[0] + "-" + params[1] + "-" + params[2] + "\n");
/*  77 */           String[][] data = dbconn.selectPatientByNomPrenomDateNaiss(params, "SelectPatientByNomPrenomDateNaiss");
/*     */ 
/*  79 */           if (data[0][0] != null) {
/*  80 */             System.out.print(" ===> Patient correspondant : " + data[0][1] + " - " + data[0][2] + "\n");
/*  81 */             stb.append(" ===> Patient correspondant : " + data[0][1] + " - " + data[0][2] + "\n");
/*     */ 
/*  85 */             String[] valeurs = new String[10];
/*  86 */             valeurs[0] = data[0][0];
/*  87 */             valeurs[1] = patient.getAdresse1();
/*  88 */             valeurs[2] = patient.getAdresse2();
/*  89 */             valeurs[3] = patient.getTelephone();
/*  90 */             valeurs[4] = patient.getCodePostal();
/*  91 */             valeurs[5] = patient.getVille();
/*  92 */             valeurs[6] = patient.getNumSecu();
/*     */ 
/*  94 */             dbconn.updatePatientByIdForNumSecuAdresseCPVilleTel("UpdatePatientByIdForNumSecuAdresseCPVilleTel", valeurs);
/*  95 */             nbCorrespondances++;
/*     */           }
/*     */         }
/*  98 */         cpt++;
/*     */       }
/* 100 */       System.out.println("==> Nombre total de patients parcourus : " + cpt);
/* 101 */       System.out.println("==> Nombre de patients correspondants : " + nbCorrespondances);
/* 102 */       stb.append("==> Nombre total de patients parcourus : " + cpt);
/* 103 */       stb.append("==> Nombre de patients correspondants : " + nbCorrespondances);
/* 104 */       File ff = new File("/home/steph/Applications/OrthodonFree/importDSIO/Log_importcsvdsio.txt");
/* 105 */       FileWriter fw = new FileWriter(ff);
/* 106 */       fw.write(stb.toString());
/* 107 */       fw.close(); } catch (Exception e) {
/* 108 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 112 */     return 0;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws ClassNotFoundException, SQLException
/*     */   {
/* 121 */     ConnexionDB conn = new ConnexionDB();
/*     */     try {
/* 123 */       conn.getConnexion();
/*     */     }
/*     */     catch (ClassNotFoundException e) {
/* 126 */       e.printStackTrace();
/*     */     }
/*     */     catch (SQLException e) {
/* 129 */       e.printStackTrace();
/*     */     }
/* 131 */     InjectCsv impcsv = new InjectCsv("/home/steph/Applications/OrthodonFree/importDSIO/DSIO_DELLESTABLE_HENRI_2.csv");
/* 132 */     impcsv.execute();
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     util.InjectCsv
 * JD-Core Version:    0.6.0
 */