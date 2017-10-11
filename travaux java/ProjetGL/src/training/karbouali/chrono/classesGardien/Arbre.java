package training.karbouali.chrono.classesGardien;


public class Arbre implements Obstacle {
	

	private float hauteur;
	

	public Arbre (int hauteurArbre){
		this.hauteur = hauteurArbre;
	}

	
	
	public float getHauteur() {
		return hauteur;
	}
	  
	
	public String toString() {
		return "Arbre [Hauteur=" + hauteur + "]";
	}
	
	public void typeObstacle() {
			System.out.println("Arbre empêche de voir au delà");
	}

	@Override
	public void empecherPasser() {
		System.out.println();
		
	}

	@Override
	public void empecherVoir() {
		System.out.println();
		 
	}

	@Override
	public void emplacement() {
		System.out.println ();
		
	}
	
	
}






