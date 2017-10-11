package projets2;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.itextpdf.text.pdf.PdfReader;

/**Contient une ArrayList de PDFDocument dans lesquels sont stockées les informations sur les PDF recensés.</br>
 * 
 * Dispose d'une méthode d'ajout et d'une méthode de clear de l'ArrayList de PDFDocument.
 * 
 */
public class EnsemblePDFDocument implements Serializable{
	private static final long serialVersionUID = 4143287201178181945L;
	private ArrayList<PDFDocument> pdfs;

	public EnsemblePDFDocument() {
		pdfs = new ArrayList<PDFDocument>();
	}

	/**Créé un nouvel objet de type PDFDocument pour stocker les informations sur le fichier PDF reçu, puis l'ajoute à l'ArrayList de PDFDocument.
	 * 
	 * @param f : un fichier PDF dont il faut stocker les informations
	 */
	public void ajoutDocPDF(File f){
		String chemin = f.getAbsolutePath();
		PdfReader reader = null;
		try {
			reader = new PdfReader(chemin);
			
			int cryptage = reader.getCryptoMode();

			int version = reader.getPdfVersion();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");	
			String dateDerniereModif = sdf.format(new Date(f.lastModified()));

			double taille = (double)f.length();

			String nom = f.getName();

			String emplacement = chemin.substring(0, chemin.length() - nom.length() -1);

			int nombreDePages = reader.getNumberOfPages();

			pdfs.add(new PDFDocument(taille, dateDerniereModif, emplacement, nombreDePages, nom, version, cryptage));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<PDFDocument> getPdfs() {
		return pdfs;
	}

	public void setPdfs(ArrayList<PDFDocument> pdfs) {
		this.pdfs = pdfs;
	}

	public void clearPdfs() {
		pdfs.clear();
	}
}
