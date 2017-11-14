package donnees;

//Classe Utilisateur qui constitue ses informations
public class Vitesse {
	
	private String id;
	private double VitesseMax;
	private double VitesseMin;
	
	public Vitesse() {
		
	}

	public Vitesse(String id, double vitesseMax, double vitesseMin) {
		super();
		this.id = id;
		VitesseMax = vitesseMax;
		VitesseMin = vitesseMin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getVitesseMax() {
		return VitesseMax;
	}

	public void setVitesseMax(double vitesseMax) {
		VitesseMax = vitesseMax;
	}

	public double getVitesseMin() {
		return VitesseMin;
	}

	public void setVitesseMin(double vitesseMin) {
		VitesseMin = vitesseMin;
	}

	@Override
	public String toString() {
		return "Vitesse [id=" + id + ", VitesseMax=" + VitesseMax
				+ ", VitesseMin=" + VitesseMin + "]";
	}
	
	

}
