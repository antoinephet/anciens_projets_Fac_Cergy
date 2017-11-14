package donnees;

//Classe Poids qui constitue ses informations
public class Poids {
	
	private String id;
	private double poids;
	
	
	public Poids() {
		
	}


	public Poids(String id, double poids) {
		
		this.id = id;
		this.poids = poids;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public double getPoids() {
		return poids;
	}


	public void setPoids(double poids) {
		this.poids = poids;
	}


	@Override
	public String toString() {
		return "Poids [id=" + id + ", poids=" + poids + "]";
	}
	
	


}
