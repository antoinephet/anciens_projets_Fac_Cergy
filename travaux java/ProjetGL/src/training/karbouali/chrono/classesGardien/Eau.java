package training.karbouali.chrono.classesGardien;

public class Eau implements Obstacle{

	private String typeEau;
	private float surface;
	private float profondeur;
	

	public Eau( String typeEau ,float surface, float profondeur) {
		this.typeEau =typeEau;
		this.surface = surface;
		this.profondeur = profondeur;
		
	}

	public String getTypeEau (){
		return typeEau;
	}
	
	public void setTypeEau(String typeEau){
		this.typeEau = typeEau;
	}
	
	
	public float getSurface() {
		return surface;
	}

	
	public void setSurface(float surface) {
		this.surface = surface;
	}

	public float getProfondeur() {
		return profondeur;
	}
	public void setprofondeur(float profondeur){
		this.profondeur = profondeur;
		
	}

	@Override
	public String toString() {
		return "Eau [Type d'eau= " +typeEau + " ,surface=" + surface + ", profondeur=" + profondeur + "]";
	}
	@Override
	public void empecherPasser() {
}
	
	
	public void empecherVoir() {
		
		
	}

	@Override
	public void emplacement() {
		
	}

	@Override
	public void typeObstacle() {
		 
	}

	

}
