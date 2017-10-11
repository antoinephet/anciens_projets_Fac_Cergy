package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			// connexion à la base de données
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root" , "");
			
			// Création d'un statement
			Statement stm = connect.createStatement();
			
			
			/*
			 * 
			 *
			 * String sql = "insert into sport "
					   + " (id_sport, nom_sport)"
					   + " values ('06', 'Fitness')";
		
			stm.executeUpdate(sql);

			System.out.println("insertion complète."); //INSERER*/
			
			/*
			String sql = "update sport set nom_sport='Kung fu' where id_sport='06'";//MAJ
			String sql = "delete from employees where last_name='Brown'"; // supprimer
					
			int ligneAffect = stm.executeUpdate(sql);

			System.out.println("Lignes affectées : " + ligneAffect);
			System.out.println("Mis à jour"); */
			
			// Executer la requête
			ResultSet res = stm.executeQuery("select * from sport");
			
			// afficher les données
			while(res.next()){
				
				System.out.println(res.getString("id_sport") + " " + res.getString("nom_sport"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
