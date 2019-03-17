/*     */ package small.data;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Patients
/*     */ {
/*     */   private int ID;
/*     */   private String nom;
/*     */   private String prenom;
/*     */   private Date dateNaissance;
/*     */   private String adresse;
/*     */   private String adresseSuite;
/*     */   private String codePostal;
/*     */   private String ville;
/*     */   private Date dateProposition;
/*     */   private Date dateModification;
/*     */   private StringBuffer observations;
/*     */   private int numSecu;
/*     */ 
/*     */   public Patients(int iD, String nom, String prenom, Date dateNaissance, String adresse, String adresseSuite)
/*     */   {
/*  24 */     this.ID = iD;
/*  25 */     this.nom = nom;
/*  26 */     this.prenom = prenom;
/*  27 */     this.dateNaissance = dateNaissance;
/*  28 */     this.adresse = adresse;
/*  29 */     this.adresseSuite = adresseSuite;
/*     */   }
/*     */ 
/*     */   public Patients(int iD, String nom, String prenom, Date dateNaissance, Date dateProposition, Date dateModification)
/*     */   {
/*  36 */     this.ID = iD;
/*  37 */     this.nom = nom;
/*  38 */     this.prenom = prenom;
/*  39 */     this.dateNaissance = dateNaissance;
/*  40 */     this.dateProposition = dateProposition;
/*  41 */     this.dateModification = dateModification;
/*     */   }
/*     */ 
/*     */   public int getID()
/*     */   {
/*  48 */     return this.ID;
/*     */   }
/*     */ 
/*     */   public void setID(int iD) {
/*  52 */     this.ID = iD;
/*     */   }
/*     */ 
/*     */   public String getNom() {
/*  56 */     return this.nom;
/*     */   }
/*     */ 
/*     */   public void setNom(String nom) {
/*  60 */     this.nom = nom;
/*     */   }
/*     */ 
/*     */   public String getPrenom() {
/*  64 */     return this.prenom;
/*     */   }
/*     */ 
/*     */   public void setPrenom(String prenom) {
/*  68 */     this.prenom = prenom;
/*     */   }
/*     */ 
/*     */   public Date getDateNaissance() {
/*  72 */     return this.dateNaissance;
/*     */   }
/*     */ 
/*     */   public void setDateNaissance(Date dateNaissance) {
/*  76 */     this.dateNaissance = dateNaissance;
/*     */   }
/*     */ 
/*     */   public String getAdresse() {
/*  80 */     return this.adresse;
/*     */   }
/*     */ 
/*     */   public void setAdresse(String adresse) {
/*  84 */     this.adresse = adresse;
/*     */   }
/*     */ 
/*     */   public String getAdresseSuite() {
/*  88 */     return this.adresseSuite;
/*     */   }
/*     */ 
/*     */   public void setAdresseSuite(String adresseSuite) {
/*  92 */     this.adresseSuite = adresseSuite;
/*     */   }
/*     */ 
/*     */   public String getCodePostal() {
/*  96 */     return this.codePostal;
/*     */   }
/*     */ 
/*     */   public void setCodePostal(String codePostal) {
/* 100 */     this.codePostal = codePostal;
/*     */   }
/*     */ 
/*     */   public String getVille() {
/* 104 */     return this.ville;
/*     */   }
/*     */ 
/*     */   public void setVille(String ville) {
/* 108 */     this.ville = ville;
/*     */   }
/*     */ 
/*     */   public Date getDateProposition() {
/* 112 */     return this.dateProposition;
/*     */   }
/*     */ 
/*     */   public void setDateProposition(Date dateProposition) {
/* 116 */     this.dateProposition = dateProposition;
/*     */   }
/*     */ 
/*     */   public Date getDateModification() {
/* 120 */     return this.dateModification;
/*     */   }
/*     */ 
/*     */   public void setDateModification(Date dateModification) {
/* 124 */     this.dateModification = dateModification;
/*     */   }
/*     */ 
/*     */   public StringBuffer getObservations() {
/* 128 */     return this.observations;
/*     */   }
/*     */ 
/*     */   public void setObservations(StringBuffer observations) {
/* 132 */     this.observations = observations;
/*     */   }
/*     */ 
/*     */   public int getNumSecu() {
/* 136 */     return this.numSecu;
/*     */   }
/*     */ 
/*     */   public void setNumSecu(int numSecu) {
/* 140 */     this.numSecu = numSecu;
/*     */   }
/*     */ }

/* Location:           /home/steph/developpement/orthodonfree/source/OrthodonFree/
 * Qualified Name:     small.data.Patients
 * JD-Core Version:    0.6.0
 */