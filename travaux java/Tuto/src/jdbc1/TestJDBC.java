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
			
			// connexion � la base de donn�es
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root" , "");
			
			// Cr�ation d'un statement
			Statement stm = connect.createStatement();
			
			
			/*
			 * 
			 *
			 * String sql = "insert into sport "
					   + " (id_sport, nom_sport)"
					   + " values ('06', 'Fitness')";
		
			stm.executeUpdate(sql);

			System.out.println("insertion compl�te."); //INSERER*/
			
			/*
			String sql = "update sport set nom_sport='Kung fu' where id_sport='06'";//MAJ
			String sql = "delete from employees where last_name='Brown'"; // supprimer
					
			int ligneAffect = stm.executeUpdate(sql);

			System.out.println("Lignes affect�es : " + ligneAffect);
			System.out.println("Mis � jour"); */
			
			// Executer la requ�te
			ResultSet res = stm.executeQuery("select * from sport");
			
			// afficher les donn�es
			while(res.next()){
				
				System.out.println(res.getString("id_sport") + " " + res.getString("nom_sport"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
