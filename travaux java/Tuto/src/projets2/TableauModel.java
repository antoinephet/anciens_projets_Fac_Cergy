package projets2;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**Gère le tableau dans lequel sont affichés les fichiers PDF trouvés.
 * 
 *
 */
public class TableauModel extends AbstractTableModel {
	private static final long serialVersionUID = 8664485939023909772L;
	private ArrayList<PDFDocument> alTableau;
	private final String[] entetes = {"Emplacement", "Nom" , "Nombre de pages", "Taille", "Dernière modification", "Cryptage", "Version"};

	public TableauModel(ArrayList<PDFDocument> alRecue) {
		this.alTableau = alRecue; 
	}

	@Override
	public int getRowCount() {
		return alTableau.size();
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		switch (columnIndex) {
		case 0:
			return alTableau.get(rowIndex).getEmplacement();
		case 1:
			return alTableau.get(rowIndex).getNom();
		case 2:
			return alTableau.get(rowIndex).getNombreDePages();
		case 3:
			return alTableau.get(rowIndex).tailleToString();
		case 4:
			return alTableau.get(rowIndex).getDateDerniereModif();
		case 5:
			return alTableau.get(rowIndex).cryptageToString();
		case 6:
			return alTableau.get(rowIndex).versionToString();
		default:
			throw new IllegalArgumentException();
		}
	}
	
/**Permet la ré-actualisation du tableau.
 * 
 * @param newData : données à utiliser pour ré-actualiser le tableau.
 */
	public void setData(ArrayList<PDFDocument> newData){
		alTableau = newData;
		super.fireTableDataChanged();
	}
}