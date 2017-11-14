package donnees;

//Classe Sport qui constitue ses informations
public class Sport {
	
	private String id;
	private String nom;

	
	public Sport() {
		
	}


	public Sport(String id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public String toString() {
		return "Sport [id=" + id + ", nom=" + nom + "]";
	}
	
	

}
