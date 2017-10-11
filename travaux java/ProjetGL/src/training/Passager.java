package training;

public class Passager {
	private String nom;
	private String prenom;
	private String typePeaceId;
	private String numPeaceID;
	public Passager(String nom, String prenom, String typePeaceId,
			String numPeaceID) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.typePeaceId = typePeaceId;
		this.numPeaceID = numPeaceID;
	}
	/* (non-JavaDoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Passager [nom=" + nom + ", prenom=" + prenom + ", typePeaceId="
				+ typePeaceId + ", numPeaceID=" + numPeaceID + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
	
	
}
