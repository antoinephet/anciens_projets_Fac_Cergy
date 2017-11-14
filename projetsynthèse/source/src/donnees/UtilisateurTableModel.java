package donnees;

import java.util.List;

import javax.swing.table.AbstractTableModel;

// Gère le tableau dans lequel sont affichés les informations sur les utilisateurs

public class UtilisateurTableModel extends AbstractTableModel{
	
	public static final int OBJECT_COL = -1;

	

	private String[] columnNames = { "Sexe", "Nom", "Prenom"};
	private List<Utilisateur> users;

	public UtilisateurTableModel(List<Utilisateur> utilisateurs) {
		users = utilisateurs;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return users.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Utilisateur tempUtlisateur = users.get(row);

		switch (col) {
		case 0:
			return tempUtlisateur.getSexe();
		case 1:
			return tempUtlisateur.getNom();
		case 2:
			return tempUtlisateur.getPrenom();
		case OBJECT_COL:
			return tempUtlisateur;
		default:
			return tempUtlisateur.getNom();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}
