package momo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;



public class TestJDBC {


	public static void main(String[] args){
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/momo", "root" , "");
			PreparedStatement ps = conn.prepareStatement("select * from produits");
			ResultSet rs = ps.executeQuery();
			// pour lire les noms des tables
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			// moyen de faire sans savoir les noms tables mais de les afficher tout de même
			for(int i=1;i<=rsmd.getColumnCount();i++){
				
				System.out.print(rsmd.getColumnName(i)+"\t");
				
				
			}
			System.out.println("");
			
			while(rs.next()){
				for(int i=1;i<=rsmd.getColumnCount();i++){
					
					System.out.print(rs.getString(i)+"\t\t");
					
					
				}
				System.out.println("");
				
			}
			
			/*while(rs.next()){
				System.out.println(rs.getInt("id_produit")+"\t"+rs.getString("nom_produit")+"\t"+rs.getDouble(3)+"\t"
						+rs.getInt("quantite"));
			}*/
		} catch (Exception e) { //ClassNotFoundException
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
