package momo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProduitModel extends AbstractTableModel{
	private String[] nomColonnes = new String[]{"ID","NOM","PRIX","QTE"};
	private List<String[]> tableValues=new ArrayList<String[]>();

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return tableValues.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return nomColonnes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return tableValues.get(rowIndex)[columnIndex];
	}
	
	// nom de la colonne
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return nomColonnes[column];
	}

	// methode qui permet de changer les données
	
	public void setData(List<Produit> produits){
		tableValues= new ArrayList<String[]>(); // enlever String
		for(Produit p:produits){
			tableValues.add(new String[]{
				""+p.getIdProduit(),
				p.getNomProduit(),
				""+p.getPrix(),
				String.valueOf(p.getQuantite())    // String.valueOf(p.getQuantite()
			});
			}
		//la vue va se recharger ou rafraichir
		fireTableChanged(null);
		}
	
	}


