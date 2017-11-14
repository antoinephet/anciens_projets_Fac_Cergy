package donnees;

// Classe Utilisateur qui constitue ses informations
public class Utilisateur {
	
	private String id;
	private String sexe;
	private String nom;
	private String prenom;
	private String id_sport;
	private String mdp;
	
	public Utilisateur() {
		
	}
	
	
	public Utilisateur(String id, String sexe, String nom, String prenom, String id_sport, String mdp) {
		super();
		this.id = id;
		this.sexe = sexe;
		this.nom = nom;
		this.prenom = prenom;
		this.id_sport = id_sport;
		this.mdp = mdp;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getId_sport() {
		return id_sport;
	}


	public void setId_sport(String id_sport) {
		this.id_sport = id_sport;
	}
	
	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", sexe=" + sexe + ", nom=" + nom
				+ ", prenom=" + prenom + ", id_sport = " + id_sport + ", mdp = " + mdp +"]";
	}
	
	
	
	
	

}
