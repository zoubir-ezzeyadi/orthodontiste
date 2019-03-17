/*     */ package small.data;
/*     */ 
/*     */ public class Association
/*     */ {
/*   5 */   private int id_patient = 0;
/*   6 */   private int anBasMaxPro = 0;
/*   7 */   private int anBasMaxEndo = 0;
/*   8 */   private int anBasMaxHypo = 0;
/*   9 */   private int anBasMaxRetro = 0;
/*  10 */   private int anBasMaxExo = 0;
/*  11 */   private int anBasManPro = 0;
/*  12 */   private int anBasManEndo = 0;
/*  13 */   private int anBasManHyper = 0;
/*  14 */   private int anBasManRetro = 0;
/*  15 */   private int anBasManExo = 0;
/*  16 */   private int anAlvMaxPro = 0;
/*  17 */   private int anAlvMaxEndo = 0;
/*  18 */   private int anAlvMaxSupra = 0;
/*  19 */   private int anAlvMaxRetro = 0;
/*  20 */   private int anAlvMaxExo = 0;
/*  21 */   private int anAlvManPro = 0;
/*  22 */   private int anAlvManEndo = 0;
/*  23 */   private int anAlvManInfra = 0;
/*  24 */   private int anAlvManRetro = 0;
/*  25 */   private int anAlvManExo = 0;
/*  26 */   private int supraclusion = 0;
/*  27 */   private int infraclusion = 0;
/*  28 */   private int cdmCI_I = 0;
/*  29 */   private int cdmCI_II = 0;
/*  30 */   private int cdmCI_III = 0;
/*  31 */   private String cdmtxt = "";
/*  32 */   private int cdcCI_I = 0;
/*  33 */   private int cdcCI_II = 0;
/*  34 */   private int cdcCI_III = 0;
/*  35 */   private String cdctxt = "";
/*  36 */   private int dysDentMax = 0;
/*  37 */   private int dysDentDent = 0;
/*  38 */   private String agnesietxt = "";
/*  39 */   private String dentInclSurnumtxt = "";
/*  40 */   private String malpositiontxt = "";
/*  41 */   private int occInvDroite = 0;
/*  42 */   private int occInvGauche = 0;
/*  43 */   private int occInvAnt = 0;
/*  44 */   private String facteurFoncttxt = "";
/*  45 */   private String planTraittxt = "";
/*  46 */   private String commentaires = "";
/*  47 */   private String dateEP = "";
/*     */ 
/*     */   public int getId_patient()
/*     */   {
/*  52 */     return this.id_patient;
/*     */   }
/*     */ 
/*     */   public void setId_patient(int id_patient)
/*     */   {
/*  58 */     this.id_patient = id_patient;
/*     */   }
/*     */ 
/*     */   public int getAnBasMaxPro()
/*     */   {
/*  64 */     return this.anBasMaxPro;
/*     */   }
/*     */ 
/*     */   public void setAnBasMaxPro(int anBasMaxPro)
/*     */   {
/*  70 */     this.anBasMaxPro = anBasMaxPro;
/*     */   }
/*     */ 
/*     */   public int getAnBasMaxEndo()
/*     */   {
/*  76 */     return this.anBasMaxEndo;
/*     */   }
/*     */ 
/*     */   public void setAnBasMaxEndo(int anBasMaxEndo)
/*     */   {
/*  82 */     this.anBasMaxEndo = anBasMaxEndo;
/*     */   }
/*     */ 
/*     */   public int getAnBasMaxHypo()
/*     */   {
/*  88 */     return this.anBasMaxHypo;
/*     */   }
/*     */ 
/*     */   public void setAnBasMaxHypo(int anBasMaxHypo)
/*     */   {
/*  94 */     this.anBasMaxHypo = anBasMaxHypo;
/*     */   }
/*     */ 
/*     */   public int getAnBasMaxRetro()
/*     */   {
/* 100 */     return this.anBasMaxRetro;
/*     */   }
/*     */ 
/*     */   public void setAnBasMaxRetro(int anBasMaxRetro)
/*     */   {
/* 106 */     this.anBasMaxRetro = anBasMaxRetro;
/*     */   }
/*     */ 
/*     */   public int getAnBasMaxExo()
/*     */   {
/* 112 */     return this.anBasMaxExo;
/*     */   }
/*     */ 
/*     */   public void setAnBasMaxExo(int anBasMaxExo)
/*     */   {
/* 118 */     this.anBasMaxExo = anBasMaxExo;
/*     */   }
/*     */ 
/*     */   public int getAnBasManPro()
/*     */   {
/* 124 */     return this.anBasManPro;
/*     */   }
/*     */ 
/*     */   public void setAnBasManPro(int anBasManPro)
/*     */   {
/* 130 */     this.anBasManPro = anBasManPro;
/*     */   }
/*     */ 
/*     */   public int getAnBasManEndo()
/*     */   {
/* 136 */     return this.anBasManEndo;
/*     */   }
/*     */ 
/*     */   public void setAnBasManEndo(int anBasManEndo)
/*     */   {
/* 142 */     this.anBasManEndo = anBasManEndo;
/*     */   }
/*     */ 
/*     */   public int getAnBasManHyper()
/*     */   {
/* 148 */     return this.anBasManHyper;
/*     */   }
/*     */ 
/*     */   public void setAnBasManHyper(int anBasManHyper)
/*     */   {
/* 154 */     this.anBasManHyper = anBasManHyper;
/*     */   }
/*     */ 
/*     */   public int getAnBasManRetro()
/*     */   {
/* 160 */     return this.anBasManRetro;
/*     */   }
/*     */ 
/*     */   public void setAnBasManRetro(int anBasManRetro)
/*     */   {
/* 166 */     this.anBasManRetro = anBasManRetro;
/*     */   }
/*     */ 
/*     */   public int getAnBasManExo()
/*     */   {
/* 172 */     return this.anBasManExo;
/*     */   }
/*     */ 
/*     */   public void setAnBasManExo(int anBasManExo)
/*     */   {
/* 178 */     this.anBasManExo = anBasManExo;
/*     */   }
/*     */ 
/*     */   public int getAnAlvMaxPro()
/*     */   {
/* 184 */     return this.anAlvMaxPro;
/*     */   }
/*     */ 
/*     */   public void setAnAlvMaxPro(int anAlvMaxPro)
/*     */   {
/* 190 */     this.anAlvMaxPro = anAlvMaxPro;
/*     */   }
/*     */ 
/*     */   public int getAnAlvMaxEndo()
/*     */   {
/* 196 */     return this.anAlvMaxEndo;
/*     */   }
/*     */ 
/*     */   public void setAnAlvMaxEndo(int anAlvMaxEndo)
/*     */   {
/* 202 */     this.anAlvMaxEndo = anAlvMaxEndo;
/*     */   }
/*     */ 
/*     */   public int getAnAlvMaxSupra()
/*     */   {
/* 208 */     return this.anAlvMaxSupra;
/*     */   }
/*     */ 
/*     */   public void setAnAlvMaxSupra(int anAlvMaxSupra)
/*     */   {
/* 214 */     this.anAlvMaxSupra = anAlvMaxSupra;
/*     */   }
/*     */ 
/*     */   public int getAnAlvMaxRetro()
/*     */   {
/* 220 */     return this.anAlvMaxRetro;
/*     */   }
/*     */ 
/*     */   public void setAnAlvMaxRetro(int anAlvMaxRetro)
/*     */   {
/* 226 */     this.anAlvMaxRetro = anAlvMaxRetro;
/*     */   }
/*     */ 
/*     */   public int getAnAlvMaxExo()
/*     */   {
/* 232 */     return this.anAlvMaxExo;
/*     */   }
/*     */ 
/*     */   public void setAnAlvMaxExo(int anAlvMaxExo)
/*     */   {
/* 238 */     this.anAlvMaxExo = anAlvMaxExo;
/*     */   }
/*     */ 
/*     */   public int getAnAlvManPro()
/*     */   {
/* 244 */     return this.anAlvManPro;
/*     */   }
/*     */ 
/*     */   public void setAnAlvManPro(int anAlvManPro)
/*     */   {
/* 250 */     this.anAlvManPro = anAlvManPro;
/*     */   }
/*     */ 
/*     */   public int getAnAlvManEndo()
/*     */   {
/* 256 */     return this.anAlvManEndo;
/*     */   }
/*     */ 
/*     */   public void setAnAlvManEndo(int anAlvManEndo)
/*     */   {
/* 262 */     this.anAlvManEndo = anAlvManEndo;
/*     */   }
/*     */ 
/*     */   public int getAnAlvManInfra()
/*     */   {
/* 268 */     return this.anAlvManInfra;
/*     */   }
/*     */ 
/*     */   public void setAnAlvManInfra(int anAlvManInfra)
/*     */   {
/* 274 */     this.anAlvManInfra = anAlvManInfra;
/*     */   }
/*     */ 
/*     */   public int getAnAlvManRetro()
/*     */   {
/* 280 */     return this.anAlvManRetro;
/*     */   }
/*     */ 
/*     */   public void setAnAlvManRetro(int anAlvManRetro)
/*     */   {
/* 286 */     this.anAlvManRetro = anAlvManRetro;
/*     */   }
/*     */ 
/*     */   public int getAnAlvManExo()
/*     */   {
/* 292 */     return this.anAlvManExo;
/*     */   }
/*     */ 
/*     */   public void setAnAlvManExo(int anAlvManExo)
/*     */   {
/* 298 */     this.anAlvManExo = anAlvManExo;
/*     */   }
/*     */ 
/*     */   public int getCdmCI_I()
/*     */   {
/* 304 */     return this.cdmCI_I;
/*     */   }
/*     */ 
/*     */   public void setCdmCI_I(int cdmCI_I)
/*     */   {
/* 310 */     this.cdmCI_I = cdmCI_I;
/*     */   }
/*     */ 
/*     */   public int getCdmCI_II()
/*     */   {
/* 316 */     return this.cdmCI_II;
/*     */   }
/*     */ 
/*     */   public void setCdmCI_II(int cdmCI_II)
/*     */   {
/* 322 */     this.cdmCI_II = cdmCI_II;
/*     */   }
/*     */ 
/*     */   public int getCdmCI_III()
/*     */   {
/* 328 */     return this.cdmCI_III;
/*     */   }
/*     */ 
/*     */   public void setCdmCI_III(int cdmCI_III)
/*     */   {
/* 334 */     this.cdmCI_III = cdmCI_III;
/*     */   }
/*     */ 
/*     */   public String getCdmtxt()
/*     */   {
/* 340 */     return this.cdmtxt;
/*     */   }
/*     */ 
/*     */   public void setCdmtxt(String cdmtxt)
/*     */   {
/* 346 */     this.cdmtxt = cdmtxt;
/*     */   }
/*     */ 
/*     */   public int getCdcCI_I()
/*     */   {
/* 352 */     return this.cdcCI_I;
/*     */   }
/*     */ 
/*     */   public void setCdcCI_I(int cdcCI_I)
/*     */   {
/* 358 */     this.cdcCI_I = cdcCI_I;
/*     */   }
/*     */ 
/*     */   public int getCdcCI_II()
/*     */   {
/* 364 */     return this.cdcCI_II;
/*     */   }
/*     */ 
/*     */   public void setCdcCI_II(int cdcCI_II)
/*     */   {
/* 370 */     this.cdcCI_II = cdcCI_II;
/*     */   }
/*     */ 
/*     */   public int getCdcCI_III()
/*     */   {
/* 376 */     return this.cdcCI_III;
/*     */   }
/*     */ 
/*     */   public void setCdcCI_III(int cdcCI_III)
/*     */   {
/* 382 */     this.cdcCI_III = cdcCI_III;
/*     */   }
/*     */ 
/*     */   public String getCdctxt()
/*     */   {
/* 388 */     return this.cdctxt;
/*     */   }
/*     */ 
/*     */   public void setCdctxt(String cdctxt)
/*     */   {
/* 394 */     this.cdctxt = cdctxt;
/*     */   }
/*     */ 
/*     */   public int getDysDentMax()
/*     */   {
/* 400 */     return this.dysDentMax;
/*     */   }
/*     */ 
/*     */   public void setDysDentMax(int dysDentMax)
/*     */   {
/* 406 */     this.dysDentMax = dysDentMax;
/*     */   }
/*     */ 
/*     */   public int getDysDentDent()
/*     */   {
/* 412 */     return this.dysDentDent;
/*     */   }
/*     */ 
/*     */   public void setDysDentDent(int dysDentDent)
/*     */   {
/* 418 */     this.dysDentDent = dysDentDent;
/*     */   }
/*     */ 
/*     */   public String getAgnesietxt()
/*     */   {
/* 424 */     return this.agnesietxt;
/*     */   }
/*     */ 
/*     */   public void setAgnesietxt(String agnesietxt)
/*     */   {
/* 430 */     this.agnesietxt = agnesietxt;
/*     */   }
/*     */ 
/*     */   public String getDentInclSurnumtxt()
/*     */   {
/* 436 */     return this.dentInclSurnumtxt;
/*     */   }
/*     */ 
/*     */   public void setDentInclSurnumtxt(String dentInclSurnumtxt)
/*     */   {
/* 442 */     this.dentInclSurnumtxt = dentInclSurnumtxt;
/*     */   }
/*     */ 
/*     */   public String getMalpositiontxt()
/*     */   {
/* 448 */     return this.malpositiontxt;
/*     */   }
/*     */ 
/*     */   public void setMalpositiontxt(String malpositiontxt)
/*     */   {
/* 454 */     this.malpositiontxt = malpositiontxt;
/*     */   }
/*     */ 
/*     */   public int getOccInvDroite()
/*     */   {
/* 460 */     return this.occInvDroite;
/*     */   }
/*     */ 
/*     */   public void setOccInvDroite(int occInvDroite)
/*     */   {
/* 466 */     this.occInvDroite = occInvDroite;
/*     */   }
/*     */ 
/*     */   public int getOccInvGauche()
/*     */   {
/* 472 */     return this.occInvGauche;
/*     */   }
/*     */ 
/*     */   public void setOccInvGauche(int occInvGauche)
/*     */   {
/* 478 */     this.occInvGauche = occInvGauche;
/*     */   }
/*     */ 
/*     */   public int getOccInvAnt()
/*     */   {
/* 484 */     return this.occInvAnt;
/*     */   }
/*     */ 
/*     */   public void setOccInvAnt(int occInvAnt)
/*     */   {
/* 490 */     this.occInvAnt = occInvAnt;
/*     */   }
/*     */ 
/*     */   public String getFacteurFoncttxt()
/*     */   {
/* 496 */     return this.facteurFoncttxt;
/*     */   }
/*     */ 
/*     */   public void setFacteurFoncttxt(String facteurFoncttxt)
/*     */   {
/* 502 */     this.facteurFoncttxt = facteurFoncttxt;
/*     */   }
/*     */ 
/*     */   public String getPlanTraittxt()
/*     */   {
/* 508 */     return this.planTraittxt;
/*     */   }
/*     */ 
/*     */   public void setPlanTraittxt(String planTraittxt)
/*     */   {
/* 514 */     this.planTraittxt = planTraittxt;
/*     */   }
/*     */ 
/*     */   public String getCommentaires()
/*     */   {
/* 520 */     return this.commentaires;
/*     */   }
/*     */ 
/*     */   public void setCommentaires(String commentaires)
/*     */   {
/* 526 */     this.commentaires = commentaires;
/*     */   }
/*     */ 
/*     */   public String getDateEP()
/*     */   {
/* 532 */     return this.dateEP;
/*     */   }
/*     */ 
/*     */   public void setDateEP(String dateEP)
/*     */   {
/* 538 */     this.dateEP = dateEP;
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.data.Association
 * JD-Core Version:    0.6.0
 */