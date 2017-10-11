package momo;

import java.util.List;
import java.util.Scanner;

public class Presentation {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner clavier = new Scanner(System.in);
		CatalogueMetierImpl metier = new CatalogueMetierImpl();
		
		System.out.print("ID Produit : "); int id = clavier.nextInt();
		System.out.print("Nom Produit : "); String nom = clavier.next();
		System.out.print("Prix : "); double prix = clavier.nextDouble();
		System.out.print("Quantité : "); int quantite = clavier.nextInt();
		Produit pr = new Produit(id,nom,prix,quantite);
		metier.addProduit(pr);
		
		System.out.println("Mot clé : ");
		String mc=clavier.next();
		List<Produit> prods= metier.produitsParMC(mc);
		for(Produit p:prods){
			
			System.out.println(p.getIdProduit()+"\t"+ p.getNomProduit()
					+"\t"+ p.getPrix()
					+"\t"+ p.getQuantite()); // +"\t"+p.getIdProduit()
			
		}

	}

}
