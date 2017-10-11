package test2;



public class Mairie {
	
	// attributs de la classe Mairie
	private String name;
	private String insee;
	private String postalCode;
	private String phone;
	private String mail;
	private String website;
	
	public Mairie(){
		System.out.println("Mairie creer !");
	}
	
	// méthodes et constructeurs de la classe Mairie
	public Mairie(String name, String insee, String postalCode, String phone,String mail, String website) {
		
		this.name = name;
		this.insee = insee;
		this.postalCode = postalCode;
		this.phone = phone;
		this.mail = mail;
		this.website = website;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInsee() {
		return insee;
	}

	public void setInsee(String insee) {
		this.insee = insee;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String toString() {
		return "Mairie : name=" + name + ", insee=" + insee + ", postalCode="+ postalCode + ", phone=" + phone + ", mail=" + mail+ ", website=" + website;
	}
	
	
		

	
	
}