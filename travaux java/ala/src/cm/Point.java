package cm;

public class Point {
	int abscisse;
	int ordonnee;
	
	
	public Point(int abscisse, int ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}
	
	public void deplacer(int dx, int dy){
		
		abscisse += dx;
		ordonnee += dy;
		
		
	}
	
	public void afficher(){
		System.out.println("les points de coordonnees : "+abscisse+" et "+ordonnee);
		
		
	}

	@Override
	public String toString() {
		return "Point [abscisse=" + abscisse + ", ordonnee=" + ordonnee + "]";
	}
	
	

}
