package jdbc3;

import java.sql.*;

public class Driver {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "";

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// Connexion à la base de données
			myConn = DriverManager.getConnection(url, user , password);
			
			// Crée un statement
			myStmt = myConn.createStatement();
			
			// Exécute la requête
			
			// INSERTION
			/*String sql = "insert into utilisateur "
					   + " (id_user, sexe, nom_user, prenom_user, id_sport)"
					   + " values ('06', 'M', 'Bovin', 'James', '03')";
			
			myStmt.executeUpdate(sql);

			System.out.println("Insert complete.");*/
			
			// UPDATE
			/*String sql = "update utilisateur set prenom_user='Jerome' where id_user='06'";
			
			int rowsAffected = myStmt.executeUpdate(sql);

			System.out.println("Rows affected: " + rowsAffected);
			System.out.println("Update complete.");*/
			
			
			// DELETE
			// String sql = "delete from employees where id_user='01'";
			
			myRs = myStmt.executeQuery("select * from utilisateur");
			// `id_user sexe nom_user prenom_user id_sport
			
			
			
			// Affiche les données
			while (myRs.next()) {
				System.out.println(myRs.getString("id_user") + ", " + myRs.getString("sexe") + ", " + myRs.getString("nom_user")
						 + ", " + myRs.getString("prenom_user") + ", " + myRs.getString("id_sport"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
	}

}
