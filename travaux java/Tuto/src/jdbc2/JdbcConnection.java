package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class creates a singleton of JDBC connection configuration.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 * 
 */
public class JdbcConnection {
	private static String host = "localhost:3306";
	private static String base = "test1";
	private static String user = "root";
	private static String password = "";

	private static String url = "jdbc:mysql://" + host + "/" + base;
	
	/*
	 * jdbc:postgresql://*/

	/**
	 * Singleton instance.
	 */
	private static Connection connection;

	public static Connection getConnection() {		
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				System.err.println("Connection failed : " + e.getMessage());			
			}
		}
		return connection;
	}
}
