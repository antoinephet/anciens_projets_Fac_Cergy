package projets2;

import java.io.Serializable;
import java.text.DecimalFormat;

/**Représentation virtuelle d'un fichier PDF concret.</br>
 * Contient des informations sur le fichier PDF associé : </br></br>
 * Date de dernière modification</br>
 * Emplacement</br>
 * Nom</br>
 * Taille</br>
 * Nombre de pages</br>
 * Version</br>
 * Type de Cryptage

 */
public class PDFDocument implements Serializable{
	private static final long serialVersionUID = 448166289803882447L;
	private String dateDerniereModif;
	private String emplacement;
	private String nom;
	private double taille;
	private int nombreDePages;
	private int version;
	private int cryptage;

	public PDFDocument(double taille, String dateDerniereModif, String emplacement, int nombreDePages, String nom, int version, int cryptage) {
		this.taille = taille;
		this.dateDerniereModif = dateDerniereModif;
		this.emplacement = emplacement;
		this.nombreDePages = nombreDePages;
		this.nom = nom;
		this.version = version;
		this.cryptage = cryptage;
	}

	public int getCryptage() {
		return cryptage;
	}

	public int getVersion() {
		return version;
	}

	public double getTaille() {
		return taille;
	}

	public String getDateDerniereModif() {
		return dateDerniereModif;
	}


	public String getEmplacement() {
		return emplacement;
	}

	public int getNombreDePages() {
		return nombreDePages;
	}

	public String getNom() {
		return nom;
	}
	
	/**Transforme le poids du fichier de type int (en octets) en type String (en Mo)
	 * 
	 * @return une String contenant la taille en Mo du fichier
	 */
	public String tailleToString() {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		double i = (double)(taille)/(1024*1024);
		return df.format(i) + "MB";
	}
	
	public String cryptageToString() {
		if(cryptage == -1) 
			return "Aucun";
		else 
			return "" + cryptage;
	}
	
	public String versionToString() {
		return "1." + version;
	}
	
	
	/**Renvoie une String de la forme : </br></br>
	 * Emplacement : C:\Users\Guillaume\Documents\Programmation\Archi\TP </br>
	 * Nom : tp2_dw_2011.pdf</br>
	 * Taille : 0,11MB</br>
	 * Nombre de pages : 10</br>
	 * Dernière modification : 23/10/2012 21:52:52</br>
	 * Cryptage : Aucun</br>
	 * Version : 1.51</br>
	 */
	@Override
	public String toString() {
		return "Emplacement : " + emplacement + "\nNom : " + nom
				+ "\nTaille : " + tailleToString() + "\nNombre de pages : " + nombreDePages
				+ "\nDernière modification : " + dateDerniereModif + "\nCryptage : "+ cryptageToString()
				+ "\nVersion : " + versionToString();
	}
}
