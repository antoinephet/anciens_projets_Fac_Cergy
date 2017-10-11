package donnees;


//Classe Exercice qui constitue ses informations
public class Exercice {
	
	private String id;
	private String nom;
	private String type;
	
	public Exercice() {
		
	}

	public Exercice(String id, String nom, String type) {
		
		this.id = id;
		this.nom = nom;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Exercice [id=" + id + ", nom=" + nom + ", type=" + type + "]";
	}
	
	
	

}
