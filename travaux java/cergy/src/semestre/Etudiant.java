package semestre;

public class Etudiant {
	
	
	private String nom;
	private String numEtu;
	private String email;
	private String typeEtu;
	private String choixCours;
	private float noteCC;
	private float noteExamen;
	
	
	public Etudiant(String nom, String numEtu, String email, String typeEtu,
			String choixCours, float noteCC, float noteExamen) {
		
		this.nom = nom;
		this.numEtu = numEtu;
		this.email = email;
		this.typeEtu = typeEtu;
		this.choixCours = choixCours;
		this.noteCC = noteCC;
		this.noteExamen = noteExamen;
	}


	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", numEtu=" + numEtu + ", email=" + email
				+ ", typeEtu=" + typeEtu + ", choixCours=" + choixCours
				+ ", noteCC=" + noteCC + ", noteExamen=" + noteExamen + "]";
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getNumEtu() {
		return numEtu;
	}


	public void setNumEtu(String numEtu) {
		this.numEtu = numEtu;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTypeEtu() {
		return typeEtu;
	}


	public void setTypeEtu(String typeEtu) {
		this.typeEtu = typeEtu;
	}


	public String getChoixCours() {
		return choixCours;
	}


	public void setChoixCours(String choixCours) {
		this.choixCours = choixCours;
	}


	public float getNoteCC() {
		return noteCC;
	}


	public void setNoteCC(float noteCC) {
		this.noteCC = noteCC;
	}


	public float getNoteExamen() {
		return noteExamen;
	}


	public void setNoteExamen(float noteExamen) {
		this.noteExamen = noteExamen;
	}
	
	
	
	
	

}
