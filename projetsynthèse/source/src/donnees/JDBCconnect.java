package donnees;

import java.sql.*;
import javax.swing.*;

// Classe JDBCConnect qui permet de se connecter � la base de donn�es
public class JDBCconnect {
	
	Connection conn = null;
	

	public static Connection connectbd(){
		
		try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/synthese", "root", "");
           // JOptionPane.showMessageDialog(null,"Connexion Etabli");
            return conn;
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null,e);
        	return null;
        }
		
		
	}
	
	
	/*public void createDatabaseConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dbName", "root", "");
            JOptionPane.showMessageDialog(null,"Connexion Etabli");
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null,e);
        }
    }*/

}
