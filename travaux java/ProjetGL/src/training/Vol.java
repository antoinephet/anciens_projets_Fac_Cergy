package training;

public class Vol {
	private String identifiant ; 
	private String aeroportDepart;
	private String aeroportArrivee;
	private String heureDepart ;
	private String heureArrivee;
	private String dateDepart ; 
	private String dateArrivee; 
	private int capacite ;
	
	
	public Vol(String identifiant, String aeroportDepart,
			String aeroportArrivee, String heureDepart, String heureArrivee,
			String dateDepart, String dateArrivee, int capacite) {
		
		this.identifiant = identifiant;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.capacite = capacite;
	}
	
	
	public Vol(String aeroportDepart, String aeroportArrivee,
			String heureDepart, String dateDepart) {
		super();
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
		this.heureDepart = heureDepart;
		this.dateDepart = dateDepart;
	}


	public String rechercherVol (String aeroportDepart ,String aeroportArrivve , String heureDepart , String dateDepart){
		String resultat; 
		resultat= null ; 
		return resultat ;
		
	}
	void verifierPlace(String identifiant){}


	public String getIdentifiant() {
		return identifiant;
	}


	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}


	public String getAeroportDepart() {
		return aeroportDepart;
	}


	public void setAeroportDepart(String aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}


	public String getAeroportArrivee() {
		return aeroportArrivee;
	}


	public void setAeroportArrivee(String aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}


	public String getHeureDepart() {
		return heureDepart;
	}


	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}


	public String getHeureArrivee() {
		return heureArrivee;
	}


	public void setHeureArrivee(String heureArrivee) {
		this.heureArrivee = heureArrivee;
	}


	public String getDateDepart() {
		return dateDepart;
	}


	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}


	public String getDateArrivee() {
		return dateArrivee;
	}


	public void setDateArrivee(String dateArrivee) {
		this.dateArrivee = dateArrivee;
	}


	public int getCapacite() {
		return capacite;
	}


	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}


	@Override
	public String toString() {
		return "Vol [aeroportDepart=" + aeroportDepart + ", aeroportArrivee="
				+ aeroportArrivee + ", heureDepart=" + heureDepart
				+ ", dateDepart=" + dateDepart + "]";
	}
	
	
}
