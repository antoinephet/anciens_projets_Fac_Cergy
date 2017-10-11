package pk_jdcb;

import java.sql.*;
import javax.swing.*;

public class Javaconnect {
	
	Connection conn = null;
	

	public static Connection connecdb(){
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project123", "root", "");
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
