package projets2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**Permet le tri d'une ArrayList de type PDFDocument(selon le nom, la date de dernière modification, l'emplacement, la taille, le nombre de pages, le type de cryptage et la version, de façon croissante ou décroissante)
 *  grâce à des Comparator personnalisés.
 */
public class Tri {
	public ArrayList<PDFDocument> triParNom(ArrayList<PDFDocument> alEntrante, boolean toggle) {
		ArrayList<PDFDocument> alSortante = new ArrayList<PDFDocument>(alEntrante);
		if(toggle)
			Collections.sort(alSortante, new TriNom());
		else
			Collections.sort(alSortante, Collections.reverseOrder(new TriNom()));
		return alSortante;
	}

	public ArrayList<PDFDocument> triParDate(ArrayList<PDFDocument> alEntrante, boolean toggle) {
		ArrayList<PDFDocument> alSortante = new ArrayList<PDFDocument>(alEntrante);
		if(toggle)
			Collections.sort(alSortante, new TriDate());
		else
			Collections.sort(alSortante, Collections.reverseOrder(new TriDate()));
		return alSortante;
	}

	public ArrayList<PDFDocument> triParEmplacement(ArrayList<PDFDocument> alEntrante, boolean toggle) {
		ArrayList<PDFDocument> alSortante = new ArrayList<PDFDocument>(alEntrante);
		if(toggle)
			Collections.sort(alSortante, new TriEmplacement());
		else
			Collections.sort(alSortante, Collections.reverseOrder(new TriEmplacement()));
		return alSortante;
	}

	public ArrayList<PDFDocument> triParTaille(ArrayList<PDFDocument> alEntrante, boolean toggle) {
		ArrayList<PDFDocument> alSortante = new ArrayList<PDFDocument>(alEntrante);
		if(toggle)
			Collections.sort(alSortante, new TriTaille());
		else
			Collections.sort(alSortante, Collections.reverseOrder(new TriTaille()));
		return alSortante;
	}


	public ArrayList<PDFDocument> triParNbPages(ArrayList<PDFDocument> alEntrante, boolean toggle) {
		ArrayList<PDFDocument> alSortante = new ArrayList<PDFDocument>(alEntrante);
		if(toggle)
			Collections.sort(alSortante, new TriNbPages());
		else
			Collections.sort(alSortante, Collections.reverseOrder(new TriNbPages()));
		return alSortante;
	}


	public ArrayList<PDFDocument> triParCryptage(ArrayList<PDFDocument> alEntrante, boolean toggle) {
		ArrayList<PDFDocument> alSortante = new ArrayList<PDFDocument>(alEntrante);
		if(toggle)
			Collections.sort(alSortante, new TriCryptage());
		else
			Collections.sort(alSortante, Collections.reverseOrder(new TriCryptage()));
		return alSortante;
	}
	
	public ArrayList<PDFDocument> triParVersion(ArrayList<PDFDocument> alEntrante, boolean toggle) {
		ArrayList<PDFDocument> alSortante = new ArrayList<PDFDocument>(alEntrante);
		if(toggle)
			Collections.sort(alSortante, new TriVersion());
		else
			Collections.sort(alSortante, Collections.reverseOrder(new TriVersion()));
		return alSortante;
	}
	

	class TriNom implements Comparator<PDFDocument> {
		@Override
		public int compare(PDFDocument o1, PDFDocument o2) {
			return o1.getNom().compareTo(o2.getNom());
		}
	}
	class TriDate implements Comparator<PDFDocument> {
		@Override
		public int compare(PDFDocument o1, PDFDocument o2) {
			return o1.getDateDerniereModif().compareTo(o2.getDateDerniereModif());
		}
	}
	class TriEmplacement implements Comparator<PDFDocument> {
		@Override
		public int compare(PDFDocument o1, PDFDocument o2) {
			return o1.getEmplacement().compareTo(o2.getEmplacement());
		}
	}
	class TriTaille implements Comparator<PDFDocument> {
		@Override
		public int compare(PDFDocument o1, PDFDocument o2) {
			return (int)(o1.getTaille() - o2.getTaille());
		}
	}
	class TriNbPages implements Comparator<PDFDocument> {
		@Override
		public int compare(PDFDocument o1, PDFDocument o2) {
			return o1.getNombreDePages() - o2.getNombreDePages();
		}
	}
	class TriCryptage implements Comparator<PDFDocument> {
		@Override
		public int compare(PDFDocument o1, PDFDocument o2) {
			return o1.getCryptage() - o2.getCryptage();
		}
	}
	class TriVersion implements Comparator<PDFDocument> {
		@Override
		public int compare(PDFDocument o1, PDFDocument o2) {
			return o1.getVersion() - o2.getVersion();
		}
	}
}