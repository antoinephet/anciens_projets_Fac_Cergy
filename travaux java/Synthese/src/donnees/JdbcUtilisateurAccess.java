package donnees;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.*;


public class JdbcUtilisateurAccess {

	private Connection myConn;
	
	public JdbcUtilisateurAccess() throws Exception {
		
		// lire les variables du fichier démo.properties
		/*Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		
		String utilisateur = props.getProperty("utilisateur");
		String motDePasse = props.getProperty("motDePasse");
		String url = props.getProperty("url");*/
		
		String utilisateur = "root";
		String motDePasse = "";
		String url = "jdbc:mysql://localhost:3306/synthese";
		
		// connexion à la base de données
		myConn = DriverManager.getConnection(url, utilisateur, motDePasse);
		
		System.out.println("Connexion réussie: " + url);
	}
	
	
	// supprime un utilisateur
	public void supprimeUtilisateur(String Id) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			
			myStmt = myConn.prepareStatement("delete from utilisateur where id_utilisateur=?");
			
		
			myStmt.setString(1, Id);
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
	}
	
	// modifie les données d'un utilisateur
	public void modifUtilisateur(Utilisateur u) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			
			myStmt = myConn.prepareStatement("update utilisateur"
					+ " set id_utilisateur=?, sexe=?, nom_utilisateur=?, prenom_utilisateur=?"
					+ " where id_utilisateur=?");
			
			
			myStmt.setString(1, u.getId());
			myStmt.setString(2, u.getSexe());
			myStmt.setString(3, u.getNom());
			myStmt.setString(4, u.getPrenom());
			myStmt.setString(5, u.getId());
			
			
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
	
	// ajoute un utilisateur
	public void addUtilisateur(Utilisateur u) throws Exception {
		PreparedStatement myStmt = null;

		try {
			
			myStmt = myConn.prepareStatement("insert into utilisateur"
					+ " (id_utilisateur,sexe, nom_utilisateur, prenom_utilisateur,id_sport, mdp)"
					+ " values (?, ?, ?, ?,? ,?)");
			
			
			myStmt.setString(1, u.getId());
			myStmt.setString(2, u.getSexe());
			myStmt.setString(3, u.getNom());
			myStmt.setString(4, u.getPrenom());
			myStmt.setString(5, u.getId_sport());
			myStmt.setString(6, u.getMdp());
			
			
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
	
	// lit et retourne toutes les données de la table Utilisateur
	public List<Utilisateur> getUtlisateurs() throws Exception {
		List<Utilisateur> list = new ArrayList<Utilisateur>();
		
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			stm = myConn.createStatement();
			rs = stm.executeQuery("select * from utilisateur order by nom_utilisateur");
			
			while (rs.next()) {
				Utilisateur tempEmployee = convertLignesUtlisateur(rs);
				list.add(tempEmployee);
			}

			return list;		
		}
		finally {
			close(stm, rs);
		}
	}
	
	// recherche d'un utlisateur à partir de son nom
	public List<Utilisateur> rechercheUtilisateur(String nom) throws Exception {
		List<Utilisateur> list = new ArrayList<Utilisateur>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			nom += "%";
			myStmt = myConn.prepareStatement("select * from utilisateur where nom_utilisateur like ?  order by nom_utilisateur");
			
			myStmt.setString(1, nom);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Utilisateur tempUser = convertLignesUtlisateur(myRs);
				list.add(tempUser);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	private Utilisateur convertLignesUtlisateur(ResultSet rs) throws SQLException {
		
		String id = rs.getString("id_utilisateur");
		String sexe = rs.getString("sexe");
		String nom = rs.getString("nom_utilisateur");
		String prenom = rs.getString("prenom_utilisateur");
		String idSport = rs.getString("id_sport");
		String mdp = rs.getString("mdp");
		
		Utilisateur tempUtilisateur = new Utilisateur(id, sexe, nom, prenom, idSport, mdp);
		
		return tempUtilisateur;
	}

	
	private static void close(Connection conn, Statement stm, ResultSet rs)
			throws SQLException {

		if (rs != null) {
			rs.close();
		}

		if (stm != null) {
			
		}
		
		if (conn != null) {
			conn.close();
		}
	}

	private void close(Statement stm, ResultSet rs) throws SQLException {
		close(null, stm, rs);		
	}

	private void close(Statement stm) throws SQLException {
		close(null, stm, null);		
	}
	
	
	// pour tester la classe en mode Console
	public static void main(String[] args) throws Exception {
		
		JdbcUtilisateurAccess utilisateur = new JdbcUtilisateurAccess();
		System.out.println(utilisateur.rechercheUtilisateur("Dumas"));

		System.out.println(utilisateur.getUtlisateurs());
	}

}
