import java.sql.*;

public class TestJDBC {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.driver");
			Connection conn=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/z_base","root","");
			PreparedStatement ps=conn.prepareStatement
					("select * from client");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id")+"/t"+rs.getString("prenom")
				+"/t"+rs.getString("nom"));
			}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

