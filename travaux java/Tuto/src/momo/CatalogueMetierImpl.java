package momo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogueMetierImpl implements ICatalogueMetier {
	List<Produit> produits = new ArrayList<Produit>();

	@Override
	public List<Produit> produitsParMC(String mc) {
		// Charger le pilote
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/momo", "root" , "");
			PreparedStatement ps = conn.prepareStatement("select * from produits where nom_produit like ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				//System.out.println(rs.getInt("id_produit")+"\t"+rs.getString("nom_produit")+"\t"+rs.getDouble(3)+"\t""quantite"
				Produit p = new Produit();
				p.setIdProduit(rs.getInt("id_produit"));
				p.setNomProduit(rs.getString("nom_produit"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				
				produits.add(p);
				
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}

	@Override
	public void addProduit(Produit p) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/momo", "root" , "");
			PreparedStatement ps = conn.prepareStatement("insert into produits(nom_produit,prix,quantite) values(?,?,?)");
			
			ps.setString(1,p.getNomProduit());
			ps.setDouble(2,p.getPrix());
			ps.setInt(3,p.getQuantite());
			int nb= ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
