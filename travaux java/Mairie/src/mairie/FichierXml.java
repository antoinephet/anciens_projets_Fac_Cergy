package mairie;


public class FichierXml {
	
	private String organismeId;
	private String codeInsee;
	private String nomMairie;
	private String editeurSource;
	private String adresseLigne;
	private String codePostal;
	private String nomCommune;
	private String telephone;
	private String telecopie;
	private String email;
	private String url;
	private String ouvertureJ;
	private String ouvertureF;
	private String horaireO;
	private String horaireF;
	
	
	
	public FichierXml(String organismeId, String codeInsee, String nomMairie,
			String editeurSource, String adresseLigne, String codePostal,
			String nomCommune, String telephone, String telecopie,
			String email, String url, String ouvertureJ, String ouvertureF,
			String horaireO, String horaireF) {
		
		
		this.organismeId = organismeId;
		this.codeInsee = codeInsee;
		this.nomMairie = nomMairie;
		this.editeurSource = editeurSource;
		this.adresseLigne = adresseLigne;
		this.codePostal = codePostal;
		this.nomCommune = nomCommune;
		this.telephone = telephone;
		this.telecopie = telecopie;
		this.email = email;
		this.url = url;
		this.ouvertureJ = ouvertureJ;
		this.ouvertureF = ouvertureF;
		this.horaireO = horaireO;
		this.horaireF = horaireF;
		
	}



	public String getOrganismeId() {
		return organismeId;
	}



	public void setOrganismeId(String organismeId) {
		this.organismeId = organismeId;
	}



	public String getCodeInsee() {
		return codeInsee;
	}



	public void setCodeInsee(String codeInsee) {
		this.codeInsee = codeInsee;
	}



	public String getNomMairie() {
		return nomMairie;
	}



	public void setNomMairie(String nomMairie) {
		this.nomMairie = nomMairie;
	}



	public String getEditeurSource() {
		return editeurSource;
	}



	public void setEditeurSource(String editeurSource) {
		this.editeurSource = editeurSource;
	}



	public String getAdresseLigne() {
		return adresseLigne;
	}



	public void setAdresseLigne(String adresseLigne) {
		this.adresseLigne = adresseLigne;
	}



	public String getCodePostal() {
		return codePostal;
	}



	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}



	public String getNomCommune() {
		return nomCommune;
	}



	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getTelecopie() {
		return telecopie;
	}



	public void setTelecopie(String telecopie) {
		this.telecopie = telecopie;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getOuvertureJ() {
		return ouvertureJ;
	}



	public void setOuvertureJ(String ouvertureJ) {
		this.ouvertureJ = ouvertureJ;
	}



	public String getOuvertureF() {
		return ouvertureF;
	}



	public void setOuvertureF(String ouvertureF) {
		this.ouvertureF = ouvertureF;
	}



	public String getHoraireO() {
		return horaireO;
	}



	public void setHoraireO(String horaireO) {
		this.horaireO = horaireO;
	}



	public String getHoraireF() {
		return horaireF;
	}



	public void setHoraireF(String horaireF) {
		this.horaireF = horaireF;
	}



	@Override
	public String toString() {
		return "FichierXml [organismeId=" + organismeId + ", codeInsee="
				+ codeInsee + ", nomMairie=" + nomMairie + ", editeurSource="
				+ editeurSource + ", adresseLigne=" + adresseLigne
				+ ", codePostal=" + codePostal + ", nomCommune=" + nomCommune
				+ ", telephone=" + telephone + ", telecopie=" + telecopie
				+ ", email=" + email + ", url=" + url + ", ouvertureJ="
				+ ouvertureJ + ", ouvertureF=" + ouvertureF + ", horaireO="
				+ horaireO + ", horaireF=" + horaireF + "]";
	}
	
	public boolean equals(Object obj) {
		if (obj != null) {
			if (obj instanceof FichierXml) {
				FichierXml other = (FichierXml) obj;
				if (nomMairie.equals(other.getNomMairie()) && organismeId.equals(other.getOrganismeId())) {
					return true;
				}
			}
		}
		return false;
	}

	
	public int hashCode() {
		return organismeId.hashCode();
	}
	
	
	
	
	
	
	
	



}
