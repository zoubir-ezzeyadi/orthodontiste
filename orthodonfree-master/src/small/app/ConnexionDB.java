package small.app;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import small.data.Association;
import small.data.Patient;
import small.sql.SqlFactory;

public class ConnexionDB {
	Connection conn = null;
	public Connection getConnexion() throws ClassNotFoundException,
			SQLException {
		 String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		 String DB_URL = "jdbc:mysql://localhost/z_base";
		 String USER = "root";
		 String PASS = "";
		Class.forName("com.mysql.jdbc.Driver");
		String databaseFile = System.getProperty("database.file");

		conn = DriverManager.getConnection(DB_URL,USER,PASS);

		return conn;
	}

	public String[][] select(String[] params, String action) {
		String[][] data = (String[][]) null;

		ResultSet rs = null;
		PreparedStatement prep1 = null;
		String sql = SqlFactory.getQuery("SQL" + action);
		try {
			prep1 = conn.prepareStatement(sql);
			prep1.setString(1, params[0]);
			rs = prep1.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();
			data = new String[1][rsm.getColumnCount()];
			int iligne = 0;
			while (rs.next()) {
				for (int icol = 1; icol <= rsm.getColumnCount(); icol++) {
					data[iligne][(icol - 1)] = rs.getString(icol);
				}
				iligne++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("data select pour : " + data[0][1] + "-"
				+ data[0][2]);
		return data;
	}

	public String[][] selectPatientByNomPrenomDateNaiss(String[] params,
			String action) {
		String[][] data = (String[][]) null;
		ResultSet rs = null;
		PreparedStatement prep1 = null;
		String sql = SqlFactory.getQuery("SQL" + action);
		try {
			conn = getConnexion();
			prep1 = conn.prepareStatement(sql);
			prep1.setString(1, params[0]);
			prep1.setString(2, params[1]);
			prep1.setString(3, params[2]);
			rs = prep1.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();
			data = new String[10][rsm.getColumnCount()];
			int ligne = 0;
			while (rs.next()) {
				for (int icol = 1; icol <= rsm.getColumnCount(); icol++) {
					data[ligne][(icol - 1)] = rs.getString(icol);
				}
				ligne++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				prep1.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} finally {
			try {
				prep1.close();
			} catch (SQLException ex3) {
				ex3.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException ex4) {
				ex4.printStackTrace();
			}
		}
		System.out.println("data select pour : " + data[0][1] + "-"
				+ data[0][2]);
		return data;
	}

	public Object[][] selecListePatients(String action, String filtre) {
		String[][] data = (String[][]) null;
		Statement stat = null;
		PreparedStatement prep1 = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = SqlFactory.getQuery("SQL" + action);
		try {
			conn = getConnexion();
			if (action.equals("listePatientLikeNom")) {
				prep1 = conn.prepareStatement(sql);
				prep1.setString(1, filtre + "%");
			} else {
				stat = conn.createStatement();
			}
			if (action.equals("listePatientLikeNom"))
				rs = prep1.executeQuery(sql);
			else
				rs = stat.executeQuery(sql);
			ResultSetMetaData rsm = rs.getMetaData();

			int nombreLignes = getNbLignes();

			data = new String[nombreLignes][rsm.getColumnCount()];
			int iligne = 0;
			while (rs.next()) {
				for (int icol = 1; icol <= rsm.getColumnCount(); icol++) {
					if (icol == 4) {
						DateFormat dateFormat = new SimpleDateFormat(
								"dd-MM-yyyy");
						long monLong = Long.parseLong(rs.getString(icol));
						Date maDate = new Date(monLong);

						String dat = dateFormat.format(maDate);
						data[iligne][(icol - 1)] = dat;
					} else if (icol == 5) {
						DateFormat dateFormat = new SimpleDateFormat(
								"dd-MM-yyyy");
						long monLong = Long.parseLong(rs.getString(icol));
						Date maDate = new Date(monLong);

						String dat = dateFormat.format(maDate);
						data[iligne][(icol - 1)] = dat;

					} else if (icol == 7) {
						if (action.equals("listepatientcontention50"))
							data[iligne][(icol - 1)] = rs.getString(icol);
						if (rs.getString(icol) == null)
							data[iligne][(icol - 1)] = "AUCUN";
						else
							data[iligne][(icol - 1)] = rs.getString(icol);
					} else {
						data[iligne][(icol - 1)] = rs.getString(icol);
					}
					System.out.println("*******> Valeur en cours : "
							+ data[iligne][(icol - 1)]);
				}
				iligne++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				stat.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} finally {
			try {
				stat.close();
			} catch (SQLException ex3) {
				ex3.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException ex4) {
				ex4.printStackTrace();
			}
		}
		System.out.println("Fin select liste patients \n data [0][0] = "
				+ data[0][0]);
		return data;
	}

	public Object[][] selectEPData(String action, int idPatient) {
		String[][] data = (String[][]) null;
		PreparedStatement prep1 = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = SqlFactory.getQuery("SQL" + action);
		try {
			conn = getConnexion();
			prep1 = conn.prepareStatement(sql);
			prep1.setInt(1, idPatient);
			rs = prep1.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();

			int nombreLignes = getNbLignes();

			data = new String[nombreLignes][rsm.getColumnCount()];
			int iligne = 0;
			while (rs.next()) {
				for (int icol = 1; icol <= rsm.getColumnCount(); icol++) {
					data[iligne][(icol - 1)] = rs.getString(icol);
				}
				iligne++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				prep1.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} finally {
			try {
				prep1.close();
			} catch (SQLException ex3) {
				ex3.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException ex4) {
				ex4.printStackTrace();
			}
		}
		return data;
	}

	public void updatePatients(String action, String[] valeurs) {
		String sql = null;
		Connection connect = null;
		PreparedStatement prep1 = null;
		try {
			connect = getConnexion();
			sql = SqlFactory.getQuery("SQL" + action);

			prep1 = connect.prepareStatement(sql);

			prep1.setString(1, valeurs[1]);
			prep1.setInt(2, Integer.parseInt(valeurs[0]));

			prep1.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex3) {
				ex3.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex4) {
				ex4.printStackTrace();
			}
		} finally {
			try {
				prep1.close();
			} catch (SQLException ex5) {
				ex5.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex6) {
				ex6.printStackTrace();
			}
		}
	}

	public void updatePatientByIdForNumSecuAdresseCPVilleTel(String action,
			String[] valeurs) {
		String sql = null;
		Connection connect = null;
		PreparedStatement prep1 = null;
		try {
			connect = getConnexion();
			sql = SqlFactory.getQuery("SQL" + action);
			prep1 = connect.prepareStatement(sql);

			prep1.setString(1, valeurs[1]);
			prep1.setString(2, valeurs[2]);
			prep1.setString(3, valeurs[3]);
			prep1.setString(4, valeurs[4]);
			prep1.setString(5, valeurs[5]);
			prep1.setString(6, valeurs[6]);

			prep1.setInt(7, Integer.parseInt(valeurs[0]));

			prep1.executeUpdate();
			System.out
					.println("Mis à jour des donnée importée DSIO via CSV sur le patient ID : "
							+ valeurs[0]);
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex3) {
				ex3.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex4) {
				ex4.printStackTrace();
			}
		} finally {
			try {
				prep1.close();
			} catch (SQLException ex5) {
				ex5.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex6) {
				ex6.printStackTrace();
			}
		}
	}

	public void updatePatientDateModif(String action, String[] valeurs) {
		String sql = null;
		Connection connect = null;
		PreparedStatement prep1 = null;
		try {
			connect = getConnexion();
			sql = SqlFactory.getQuery("SQL" + action);

			prep1 = connect.prepareStatement(sql);

			prep1.setString(1, valeurs[2]);
			prep1.setInt(2, Integer.parseInt(valeurs[0]));

			prep1.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex3) {
				ex3.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex4) {
				ex4.printStackTrace();
			}
		} finally {
			try {
				prep1.close();
			} catch (SQLException ex5) {
				ex5.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex6) {
				ex6.printStackTrace();
			}
		}
		System.out
				.println("Mise à jour Date Modification dans table patient effectuée");
	}

	public void insertAssociations(String action, String[] valeurs) {
		String sql = null;
		Connection connect = null;
		PreparedStatement prep1 = null;

		try {
			connect = getConnexion();
			sql = SqlFactory.getQuery("SQL" + action);

			prep1 = connect.prepareStatement(sql);

			prep1.setInt(1, Integer.parseInt(valeurs[0]));
			prep1.setInt(2, Integer.parseInt(valeurs[1]));
			prep1.setString(3, "");
			prep1.setString(4, valeurs[3]);

			prep1.execute();
			System.out
					.println("Insertion dans la table associations effectuée");
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex3) {
				ex3.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex4) {
				ex4.printStackTrace();
			}
		} finally {
			try {
				prep1.close();
			} catch (SQLException ex5) {
				ex5.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex6) {
				ex6.printStackTrace();
			}
		}
	}

	public void updateAsso(String action, String[] valeurs, int id_asso) {
		String sql = null;
		Connection connect = null;
		PreparedStatement prep1 = null;
		try {
			connect = getConnexion();
			sql = SqlFactory.getQuery("SQL" + action);

			prep1 = connect.prepareStatement(sql);
			prep1.setInt(1, Integer.parseInt(valeurs[1]));
			prep1.setInt(2, id_asso);

			prep1.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex3) {
				ex3.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex4) {
				ex4.printStackTrace();
			}
		} finally {
			try {
				prep1.close();
			} catch (SQLException ex5) {
				ex5.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex6) {
				ex6.printStackTrace();
			}
		}
		System.out.println("Update sur table associations id = " + id_asso
				+ " effectuée");
	}

	public void updateDateProposition(String action, String[] valeurs) {
		String sql = null;
		Connection connect = null;
		PreparedStatement prep1 = null;
		try {
			connect = getConnexion();
			sql = SqlFactory.getQuery("SQL" + action);

			prep1 = connect.prepareStatement(sql);

			prep1.setString(1, valeurs[1]);
			prep1.setInt(2, Integer.parseInt(valeurs[0]));

			prep1.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex3) {
				ex3.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex4) {
				ex4.printStackTrace();
			}
		} finally {
			try {
				prep1.close();
			} catch (SQLException ex5) {
				ex5.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex6) {
				ex6.printStackTrace();
			}
		}
		System.out
				.println("Mise à jour Date Proposition dans table associations effectuée");
	}

	public void updateDateDebutTraitement(String action, String[] valeurs) {
		String sql = null;
		Connection connect = null;
		PreparedStatement prep1 = null;
		try {
			connect = getConnexion();
			sql = SqlFactory.getQuery("SQL" + action);

			prep1 = connect.prepareStatement(sql);

			prep1.setString(1, valeurs[1]);
			prep1.setInt(2, Integer.parseInt(valeurs[0]));

			prep1.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex3) {
				ex3.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex4) {
				ex4.printStackTrace();
			}
		} finally {
			try {
				prep1.close();
			} catch (SQLException ex5) {
				ex5.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex6) {
				ex6.printStackTrace();
			}
		}
		System.out
				.println("Mise à jour Date Déut Traitement dans table associations effectuée");
	}

	private int verifExistenceAsso(String action, String[] valeurs) {
		PreparedStatement prep1 = null;

		String[][] data = (String[][]) null;

		ResultSet rsverif = null;
		String sql = SqlFactory.getQuery("SQL" + action);
		try {
			conn = getConnexion();
			prep1 = conn.prepareStatement(sql);
			prep1.setInt(1, Integer.parseInt(valeurs[0]));
			System.out.println("id_patient : " + Integer.parseInt(valeurs[0]));
			prep1.setString(2, valeurs[2]);
			System.out.println("date debut trait. : " + valeurs[2]);
			rsverif = prep1.executeQuery();

			if (rsverif.next()) {
				System.out.println(rsverif.getString(1));
				return Integer.parseInt(rsverif.getString(1));
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				prep1.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
		}
	}

	public void insertPatient(Patient pat, String action) {
		String sql = null;
		Connection connect = null;
		PreparedStatement prep1 = null;
		try {
			connect = getConnexion();
			sql = SqlFactory.getQuery("SQL" + action);

			prep1 = connect.prepareStatement(sql);

			Date datenaiss = null;
			DateFormat df = null;
			String ladate = pat.getDateNaiss();
			System.out.println("*******>ladate = " + ladate);
			if (ladate.contains("/")) {
				df = new SimpleDateFormat("dd/MM/yyyy");
			} else if (ladate.contains("-")) {
				df = new SimpleDateFormat("dd-MM-yyyy");
			}
			try {
				datenaiss = df.parse(ladate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			prep1.setString(1, pat.getPrenom());
			prep1.setString(2, pat.getNom());
			prep1.setLong(3, datenaiss.getTime());
			prep1.setString(4, pat.getAdresse1());
			prep1.setString(5, pat.getAdresse2());
			prep1.setString(6, pat.getTelephone());
			prep1.setString(7, pat.getTelephone2());
			prep1.setString(8, pat.getCodePostal());
			prep1.setString(9, pat.getVille());
			prep1.setString(10, pat.getDateModification());
			Date datecreation = null;
			try {
				df = new SimpleDateFormat("dd-MM-yyyy");
				datecreation = df.parse(pat.getDateModification());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			prep1.setLong(11, datecreation.getTime());
			prep1.setString(12, pat.getNumSecu());

			prep1.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				prep1.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void updatePatient(Patient pat, String action, int id) {
		String sql = null;
		Connection connect = null;
		PreparedStatement prep1 = null;
		try {
			connect = getConnexion();
			sql = SqlFactory.getQuery("SQL" + action);

			prep1 = connect.prepareStatement(sql);

			Date datenaiss = null;
			DateFormat df = null;
			String ladate = pat.getDateNaiss();
			System.out.println("*******>ladate = " + ladate);
			if (ladate.contains("/")) {
				df = new SimpleDateFormat("dd/MM/yyyy");
			} else if (ladate.contains("-")) {
				df = new SimpleDateFormat("dd-MM-yyyy");
			}
			try {
				datenaiss = df.parse(ladate);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			prep1.setString(1, pat.getPrenom());
			prep1.setString(2, pat.getNom());
			prep1.setLong(3, datenaiss.getTime());
			prep1.setString(4, pat.getAdresse1());
			prep1.setString(5, pat.getAdresse2());
			prep1.setString(6, pat.getTelephone());
			prep1.setString(7, pat.getTelephone2());
			prep1.setString(8, pat.getCodePostal());
			prep1.setString(9, pat.getVille());
			prep1.setString(10, pat.getNumSecu());
			prep1.setInt(11, id);

			prep1.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				prep1.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void deletePatient(String idpatient, String action) {
		String sql = null;
		Connection connect = null;
		PreparedStatement prep1 = null;
		try {
			connect = getConnexion();
			sql = SqlFactory.getQuery("SQL" + action);
			prep1 = connect.prepareStatement(sql);
			prep1.setString(1, idpatient);
			prep1.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				prep1.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public int getNbLignes() {
		int nbLignes = 0;
		ResultSet rs = null;
		String sql = SqlFactory.getQuery("SQLnblignespatient");
		try {
			Statement stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			nbLignes = rs.getInt(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return nbLignes;
	}

	public Object[][] selecListePatientsType(String typeTraitement) {
		return null;
	}

	public void updateAssociationsEncours(String action, String[] valeurs) {
		String sql = null;
		Connection connect = null;
		PreparedStatement prep1 = null;
		try {
			connect = getConnexion();
			sql = SqlFactory.getQuery("SQL" + action);

			prep1 = connect.prepareStatement(sql);

			prep1.setInt(1, Integer.parseInt(valeurs[0]));

			prep1.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			try {
				prep1.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				prep1.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		System.out
				.println("Mise à jour EnCours dans table associations effectuée");
	}

	public Object[][] selectListeRenouvPatients(String action) {
		String[][] data = (String[][]) null;
		Statement stat = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = SqlFactory.getQuery("SQL" + action);
		try {
			conn = getConnexion();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			ResultSetMetaData rsm = rs.getMetaData();

			int nombreLignes = getNbLignes();

			data = new String[nombreLignes + 2][rsm.getColumnCount()];
			int iligne = 0;
			int nbJours = 0;
			String code_acte = "";
			while (rs.next()) {
				if ((rs.getString(9) != null) && (rs.getString(9).length() > 0)) {

					int id_patient = rs.getInt(1);
					String date_proposition = rs.getString(8);
					code_acte = rs.getString(7);
					int compteurNBTraitement = rs.getInt(10);
					int duree = rs.getInt(11);
					String date_debut_traitement = rs.getString(9);
					SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					Date date_debut = df.parse(date_debut_traitement);
					Date date_propo = df.parse(date_proposition);

					GregorianCalendar calendarDuJour = new GregorianCalendar();
					GregorianCalendar calendarDebut = new GregorianCalendar();
					GregorianCalendar calendarFin = new GregorianCalendar();

					Date date_du_jour = new Date();

					if ((compteurNBTraitement == 1)
							&& ("TO90".equals(code_acte)))
						calendarDebut.setTime(date_debut);
					else {
						calendarDebut.setTime(date_propo);
					}

					calendarDebut.add(2, duree);

					Date date_de_fin = calendarDebut.getTime();

					calendarFin.setTime(date_de_fin);
					calendarDuJour.setTime(date_du_jour);

					long MILISECOND_PER_DAY = 86400000L;
					nbJours = Math.round((float) ((calendarFin
							.getTimeInMillis() - calendarDuJour
							.getTimeInMillis()) / 86400000L));

					System.out.println("patient Num : " + id_patient
							+ " - Le nombre de jour est : " + nbJours);
				}
				int nbJoursRenouv = Integer.parseInt(System
						.getProperty("nbjours.renouv"));
				int nbJoursDepRenouv = Integer.parseInt(System
						.getProperty("nbjours.deprenouv"));
				System.out.println("nbjours.deprenouv = " + nbJoursDepRenouv);

				if ((nbJours >= nbJoursDepRenouv) && (nbJours <= nbJoursRenouv)
						&& (rs.getString(7) != null)) {
					for (int icol = 1; icol <= rsm.getColumnCount(); icol++) {
						if (icol == 4) {
							DateFormat dateFormat = new SimpleDateFormat(
									"dd-MM-yyyy");
							long monLong = Long.parseLong(rs.getString(icol));
							Date maDate = new Date(monLong);

							String dat = dateFormat.format(maDate);
							data[iligne][(icol - 1)] = dat;
						} else if (icol == 5) {
							DateFormat dateFormat = new SimpleDateFormat(
									"dd-MM-yyyy");
							long monLong = Long.parseLong(rs.getString(icol));
							Date maDate = new Date(monLong);

							String dat = dateFormat.format(maDate);
							data[iligne][(icol - 1)] = dat;

						} else if (icol == 7) {
							if (action.equals("listepatientcontention50")) {
								data[iligne][(icol - 1)] = rs.getString(icol);
							} else {
								data[iligne][(icol - 1)] = rs.getString(icol);
							}
						} else if ((icol != 11) && (icol != 12)) {
							data[iligne][(icol - 1)] = rs.getString(icol);
						}
					}
					iligne++;
					nbJours = 0;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				stat.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} finally {
			try {
				stat.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Fin select liste patients à renouveller \n data [0][0] = " + data[0][0]);
		return data;
	}

	public static void main(String[] args) {
		ConnexionDB conn = new ConnexionDB();
		conn.selectListeRenouvPatients("listepatientsrenouv");
	}

	public void updateEpPojoByidPatient(String action, Association asso) {
		String sql = null;
		Connection connect = null;
		PreparedStatement prep1 = null;
		try {
			connect = getConnexion();
			sql = SqlFactory.getQuery("SQL" + action);

			System.out.println("SQL avant requête : " + sql);
			prep1 = connect.prepareStatement(sql);

			prep1.setInt(1, asso.getAnBasMaxPro());
			prep1.setInt(2, asso.getAnBasMaxEndo());
			prep1.setInt(3, asso.getAnBasMaxHypo());
			prep1.setInt(4, asso.getAnBasMaxRetro());
			prep1.setInt(5, asso.getAnBasMaxExo());
			prep1.setInt(6, asso.getAnBasManPro());
			prep1.setInt(7, asso.getAnBasManEndo());
			prep1.setInt(8, asso.getAnBasManHyper());
			prep1.setInt(9, asso.getAnBasManRetro());
			prep1.setInt(10, asso.getAnBasManExo());
			prep1.setInt(11, asso.getAnAlvMaxPro());
			prep1.setInt(12, asso.getAnAlvMaxEndo());
			prep1.setInt(13, asso.getAnAlvMaxSupra());
			prep1.setInt(14, asso.getAnAlvMaxRetro());
			prep1.setInt(15, asso.getAnAlvMaxExo());
			prep1.setInt(16, asso.getAnAlvManPro());
			prep1.setInt(17, asso.getAnAlvManEndo());
			prep1.setInt(18, asso.getAnAlvManInfra());
			prep1.setInt(19, asso.getAnAlvManRetro());
			prep1.setInt(20, asso.getAnAlvManExo());
			prep1.setInt(21, asso.getCdmCI_I());
			prep1.setInt(22, asso.getCdmCI_II());
			prep1.setInt(23, asso.getCdmCI_III());
			prep1.setString(24, asso.getCdmtxt());
			prep1.setInt(25, asso.getCdcCI_I());
			prep1.setInt(26, asso.getCdcCI_II());
			prep1.setInt(27, asso.getCdcCI_III());
			prep1.setString(28, asso.getCdctxt());
			prep1.setInt(29, asso.getDysDentMax());
			prep1.setInt(30, asso.getDysDentDent());
			prep1.setString(31, asso.getAgnesietxt());
			prep1.setString(32, asso.getDentInclSurnumtxt());
			prep1.setString(33, asso.getMalpositiontxt());
			prep1.setInt(34, asso.getOccInvDroite());
			prep1.setInt(35, asso.getOccInvGauche());
			prep1.setInt(36, asso.getOccInvAnt());
			prep1.setString(37, asso.getFacteurFoncttxt());
			prep1.setString(38, asso.getPlanTraittxt());
			prep1.setString(39, asso.getCommentaires());
			prep1.setString(40, asso.getDateEP());
			prep1.setInt(41, asso.getId_patient());

			prep1.executeUpdate();
			System.out.println("Après UdpateEpPojoByIdpatient");
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				prep1.close();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex2) {
				ex2.printStackTrace();
			}
		} finally {
			try {
				prep1.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			try {
				connect.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}