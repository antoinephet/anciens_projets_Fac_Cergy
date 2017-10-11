package semestre;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Gestionnaire etudiant = new Gestionnaire(100);

		Etudiant martin = new Etudiant("Martin", "95250378M", "martin@hotmail.com", "L1", "Informatique", 12, 15);
		Etudiant alice = new Etudiant("Alice", "78420831F", "alice@hotmail.com", "L2", "LEA", 9, 12);
		Etudiant joseph = new Etudiant("Luc", "75941205H", "joseph@hotmail.com", "L3", "Biologie", 5, 17);

		etudiant.ajouter(martin);
		etudiant.ajouter(alice);
		etudiant.ajouter(joseph);
		
		System.out.println("--------------- Ajouter ----------------");
		System.out.println("");
		System.out.println("Il y a " + etudiant.getNbreEtuActuel() + " etudiants dans le registre");
		System.out.println(etudiant.toString());
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("--------------- Recherche ---------------");
		System.out.println("");
		System.out.println("Le numéro de Alice est " + etudiant.rechercheNumEtu("Alice"));
		System.out.println("Le numero de l'etudiant 75941205H est " + etudiant.rechercheNom("75941205H") +"\n");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("--------------- Modification ---------------");
		System.out.println("");
		etudiant.modifierNumEtu("Alice", "0678787878");
		System.out.println("Le nouvel numero de l'etudiant alice est " + etudiant.rechercheNumEtu("Alice")+"\n");
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		System.out.println("--------------- Suppression ---------------");
		System.out.println("");
		etudiant.supprimer("Alice");
		System.out.println("Il y a " + etudiant.getNbreEtuActuel() + " etudiants dans le registre");
		System.out.println(etudiant.toString());

	}

}
