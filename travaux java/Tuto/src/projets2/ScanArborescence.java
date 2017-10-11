package projets2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.itextpdf.text.pdf.PdfReader;

/**Contient la m�thode rechercheConsole, utilis�e lors de la recherche en mode console, ainsi que les m�thodes permettant le parcours d'une arborescence,
 *  et la lecture et la sauvegarde des chemins.
 */
public class ScanArborescence {
	String strCheminArbo;
	EnsemblePDFDocument EPDFD;
	Scanner sc;


	public ScanArborescence() {	
		EPDFD = new EnsemblePDFDocument();
		sc = new Scanner(System.in);
	}


	/**M�thode s'occupant de la recherche en mode console </br>
	 * Essaye de lire le fichier texte contenant le chemin de l'arborescence � scanner</br>
	 * - s'il existe, demande si l'utilisateur veut le changer
	 * 		<pre>- si non, lecture du fichier contenant l'ArrayList de PDFDocument, et affichage de ces fichiers</pre>
	 * 		<pre>- si oui, ou si le fichier texte est vide, demande � l'utilisateur le chemin � scanner puis affiche les fichiers PDF trouv�s</pre>
	 */
	public void rechercheConsole() {
		boolean rechercheComplete = false;
		strCheminArbo = readChemin(strCheminArbo, "CheminArbo.txt");

		if(strCheminArbo.length()==0) {
			rechercheComplete = true;
		}

		else {
			char choix;
			do {
				System.out.println("Changer l'arborescence a scanner ? (o : oui, n : non)\n(Arborescence actuelle : " + strCheminArbo + ")");
				choix = sc.nextLine().charAt(0);
				if(choix == 'o') 
					rechercheComplete = true;					
				else if (choix == 'n') 
					rechercheComplete = false;
			} while(choix != 'n' && choix != 'o');
		}

		if(rechercheComplete) {
			cheminArbo();
			File rep = new File(strCheminArbo);
			System.out.println("Recherche en cours ...");
			long startTime = System.currentTimeMillis();
			parcoursArbo(rep);
			affichagePDF();
			System.out.println("Recherche effectu�e en : " + (System.currentTimeMillis() - startTime) +"ms");
			if(EPDFD.getPdfs().size() !=0)
				saveListePDF();
		}
		else {
			readListePDF();
			affichagePDF();
		}

		sc.close();
	}

	/**Parcours l'arborescence re�ue et fait appel � la la classe EnsemblePDFDocument pour stocker les informations du fichier si c'est un PDF.
	 * @param f : Chemin de l'arborescence � scanner
	 */
	public void parcoursArbo(File f) {
		if(f.isDirectory() && f.exists()) {
			File [] list = f.listFiles();										
			if(list != null) {													
				for (int i = 0; i < list.length; i++) {
					parcoursArbo(list[i]);											
					if(isPDF(list[i])) {										
						EPDFD.ajoutDocPDF(list[i]);
					}
				} 
			} 
			else {															
				System.err.println(f + " : Erreur de lecture.");				
			}
		}
		if(!(f.exists())) {															
			System.err.println(f + " : Erreur de lecture.");				
		}
	}



	/**D�termine si l'objet de type File pass� en argument est un fichier de type PDF.
	 * @param f Un objet File � tester
	 * @return true si le fichier est un PDF </br>
	 * 		   false sinon
	 */
	public boolean isPDF(File f) { 
		PdfReader reader;
		try {
			reader = new PdfReader(f.getAbsolutePath());
		} catch (IOException e) {
			reader = null;
		}
		return reader != null;	
	}


	/**Affiche l'ensemble des fichiers PDF trouv�s ainsi que certaines de leurs caract�ristiques
	 * 
	 */
	public void affichagePDF() {
		List<PDFDocument> pdfs = EPDFD.getPdfs();
		for(int j=0; j<pdfs.size(); j++) {
			System.out.println(pdfs.get(j) + "\n");
		}
	}


	/**Sauvegarde les PDF et leurs caract�ristiques en s�rialisant l'objet EnsemblePDFDocument (compos� d'objets PDFDocument, contenant les caract�ristiques
	 * des fichiers PDF) dans un fichier "fichierObjetEPDFD"
	 * 
	 */
	public void saveListePDF() {
		ObjectOutputStream oos;
		try{
			oos = new ObjectOutputStream(new FileOutputStream("fichierObjetEPDFD"));
			try{		
				oos.writeObject(EPDFD.getPdfs());
			}
			finally{
				oos.close();
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}


	/**Lit et initialise l'objet EnsemblePDFDocument � partir du fichier "fichierObjetEPDFD"
	 */
	@SuppressWarnings("unchecked")
	public void readListePDF(){
		ObjectInputStream ois;
		try {
			ArrayList<PDFDocument> alTemp;
			ois = new ObjectInputStream(new FileInputStream("fichierObjetEPDFD"));
			try{
				alTemp=(ArrayList<PDFDocument>)ois.readObject();
				EPDFD.setPdfs(alTemp);
			}
			finally{
				ois.close();
			}
		}
		catch(Exception e){

		}
	}


	/**Demande � l'utilisateur de saisir le chemin de l'arborescence � scanner, 
	 * sauvegard� gr�ce � la m�thode saveChemin, puis le renvoie.<br/>
	 * @return Une String contenant l'emplacement du chemin a scanner
	 */
	public String cheminArbo()  {
		System.out.println("Veuillez saisir le chemin de l'arborescence a scanner :\n");
		strCheminArbo = sc.nextLine();
		saveChemin(strCheminArbo, "CheminArbo.txt");							
		return strCheminArbo;
	}



	/**Lit le chemin de l'arborescence, sauvegard�e dans le fichier : </br>
	 * - cheminExe.txt pour le chemin de l'executable.</br>
	 * - cheminArbo.txt pour le chemin de l'arborescence � scanner.</br>
	 * 
	 * 
	 * @param strChemin la String dans laquelle �crire le chemin 
	 * @param strNomFichierTexte contient le nom du fichier texte dans lequel lire le chemin de l'arborescence ("cheminExe" ou "cheminArbo")
	 * @see FileReader
	 * @return	Une String contenant le chemin de l'arborescence � scanner/de l'ex�cutable
	 */
	public String readChemin(String strChemin, String strNomFichierTexte) {
		String stemp;
		char ctemp;
		int i;
		try{
			FileReader fr = new FileReader(strNomFichierTexte);
			try {
				while((i=fr.read())!=-1){
					ctemp = (char)i;
					stemp = String.valueOf(ctemp);
					if(strChemin == null)
						strChemin = stemp;
					else
						strChemin += stemp;
				}
			}
			finally {
				fr.close();
			}
		}
		catch(IOException e){
			//System.out.println(e);																
			//java.io.FileNotFoundException: cheminExe.txt (Le fichier sp�cifi� est introuvable)
			strChemin = "";
		}

		return strChemin;
	}

	/**Sauvegarde le chemin de l'arborescence dans le fichier : </br>
	 * - cheminExe.txt pour le chemin de l'executable.</br>
	 * - cheminArbo.txt pour le chemin de l'arborescence � scanner.</br>
	 * 
	 * @param strChemin contient le chemin � sauvegarder
	 * @param strNomFichierTexte contient le nom du fichier texte dans lequel sauvegarder le chemin
	 * 
	 * @see FileWriter
	 * 
	 * @throws IOException
	 */
	public void saveChemin(String strChemin, String strNomFichierTexte){
		FileWriter out;
		try {
			out = new FileWriter(strNomFichierTexte);
			out.write(strChemin);
			out.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public String getStrCheminArbo() {
		return strCheminArbo;
	}

	public void setStrCheminArbo(String strCheminArbo) {
		this.strCheminArbo = strCheminArbo;
	}

	public EnsemblePDFDocument getEPDFD() {
		return EPDFD;
	}

	public void setEPDFD(EnsemblePDFDocument EPDFD) {
		this.EPDFD = EPDFD;
	}
}
