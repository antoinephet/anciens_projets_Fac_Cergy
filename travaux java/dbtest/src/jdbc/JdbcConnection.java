package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class creates a singleton of JDBC connection configuration.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 * 
 */
public class JdbcConnection {
	private static String host = "localhost";
	private static String base = "postgres";
	private static String user = "postgres";
	private static String password = "postgres";

	private static String url = "jdbc:postgresql://" + host + "/" + base;

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
