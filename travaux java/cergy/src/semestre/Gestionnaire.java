package semestre;

public class Gestionnaire {
	
	private Etudiant[] etudiants;
	private int nbreEtu;
	private int nbreEtuActuel;
	
	
	public Gestionnaire(int nbreEtu) {
		
		
		this.etudiants = etudiants;
		etudiants = new Etudiant[nbreEtu];
		nbreEtuActuel = 0; 
		
	}
	
	
	/* méthode ajouter*/
	
	
	public void ajouter(Etudiant etudiant) {
		if (nbreEtuActuel < nbreEtu) {
			etudiants[nbreEtuActuel] = etudiant;
			nbreEtuActuel++;
		}
	}
	
	
	/*----------------------- méthodes recherhces -----------------------*/
	
	public String rechercheNumEtu(String nom) {
		for (int i = 0; i <= nbreEtuActuel - 1; i++) {
			Etudiant etudiant = etudiants[i];
			String etudiantNom = etudiant.getNom();
			if (etudiantNom.equals(nom)) {
				return etudiant.getNumEtu();
			}
		}
		return null;
	}

	public String rechercheNom(String numEtu) {
		for (int i = 0; i <= nbreEtuActuel - 1; i++) {
			Etudiant etudiant = etudiants[i];
			String etudiantNumEtu = etudiant.getNumEtu();
			if (etudiantNumEtu.equals(numEtu)) {
				return etudiant.getNom();
			}
		}
		return null;
	}
	
	public String rechercheNotes(float noteCC, float noteExamen) {
		for (int i = 0; i <= nbreEtuActuel - 1; i++) {
			Etudiant etudiant = etudiants[i];
			String etudiantNom = etudiant.getNom();
			if (etudiantNom.equals(noteCC) && etudiantNom.equals(noteExamen)) {
				return etudiant.getNoteCC() + "" + etudiant.getNoteExamen();
			}
		}
		return null;
	}
	
	
	public String rechercheTypeEtu(String typeEtu) {
		for (int i = 0; i <= nbreEtuActuel - 1; i++) {
			Etudiant etudiant = etudiants[i];
			String etudiantNom = etudiant.getNom();
			if (etudiantNom.equals(typeEtu)) {
				return etudiant.getTypeEtu();
			}
		}
		return null;
	}
	
	
	public String rechercheChoixCours(String choixCours) {
		for (int i = 0; i <= nbreEtuActuel - 1; i++) {
			Etudiant etudiant = etudiants[i];
			String etudiantNom = etudiant.getNom();
			if (etudiantNom.equals(choixCours)) {
				return etudiant.getChoixCours();
			}
		}
		return null;
	}
	
	/*----------------------- méthodes modifications-----------------------*/
	
	
	public void modifierNumEtu(String nom, String nouveauNum) {
		for (int i = 0; i <= nbreEtuActuel - 1; i++) {
			Etudiant etudiant = etudiants[i];
			String etuNom = etudiant.getNom();
			if (etuNom.equals(nom)) {
				etudiant.setNumEtu(nouveauNum);
				break;
			}
		}
	}
	
	
	public void modifierNotes(String nom, float nouveauNote) {
		for (int i = 0; i <= nbreEtuActuel - 1; i++) {
			Etudiant etudiant = etudiants[i];
			String etuNom = etudiant.getNom();
			if (etuNom.equals(nom)) {
				etudiant.setNoteCC(nouveauNote);
				etudiant.setNoteExamen(nouveauNote);
				break;
			}
		}
	}
	
	public void modifierTypeEtu(String nom, String nouveauTypeEtu) {
		for (int i = 0; i <= nbreEtuActuel - 1; i++) {
			Etudiant etudiant = etudiants[i];
			String etuNom = etudiant.getNom();
			if (etuNom.equals(nom)) {
				etudiant.setTypeEtu(nouveauTypeEtu);
				break;
			}
		}
	}
	
	
	
	public void modifierChoixCours(String nom, String nouveauChoixCours) {
		for (int i = 0; i <= nbreEtuActuel - 1; i++) {
			Etudiant etudiant = etudiants[i];
			String etuNom = etudiant.getNom();
			if (etuNom.equals(nom)) {
				etudiant.setChoixCours(nouveauChoixCours);
				break;
			}
		}
	}
	
	
	/* méthode supprimer*/
	

	public void supprimer(String nom) {
		int y = -1;
		for (int i = 0; i <= nbreEtuActuel - 1; i++) {
			Etudiant etudiant = etudiants[i];
			String etuNom = etudiant.getNom();
			if (etuNom.equals(nom)) {
				y = i;
				break;
			}
		}

		if (y != -1) {
			for (int i = y; i <= nbreEtuActuel - 2; i++) {
				etudiants[i] = etudiants[i + 1];
			}
			etudiants[nbreEtuActuel - 1] = null;
			nbreEtuActuel--;
		}
	}

	public int getNbreEtuActuel() {
		return nbreEtuActuel;
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i <= nbreEtuActuel - 1; i++) {
			result += etudiants[i].toString() + "\n";
		}
		return result;
	}
	

}
