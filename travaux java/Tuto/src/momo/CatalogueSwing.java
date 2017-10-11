package momo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CatalogueSwing extends JFrame{
	
	private JLabel jLabelMC = new JLabel("Mot clé : ");
	private JTextField jtTextFieldMC = new JTextField(12);
	private JButton jButtonChercher = new JButton("Chercher");
	private JTable jTableProduits = new JTable();
	
	private ProduitModel jtableModel;
	
	public CatalogueSwing(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel JPanelN = new JPanel();
		JPanelN.setLayout(new FlowLayout());
		JPanelN.add(jLabelMC);JPanelN.add(jtTextFieldMC);
		JPanelN.add(jButtonChercher);
		this.add(JPanelN,BorderLayout.NORTH);
		
		JPanel jPanelC= new JPanel();
		jtableModel = new ProduitModel();
		jTableProduits = new JTable(jtableModel);
		JScrollPane jScrollPane = new JScrollPane(jTableProduits);
		jPanelC.setLayout(new GridLayout());
		jPanelC.add(jScrollPane);
		this.add(jPanelC,BorderLayout.CENTER);
		
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setVisible(true);
		
		jButtonChercher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String mc = jtTextFieldMC.getText();
				CatalogueMetierImpl metier = new CatalogueMetierImpl();
				List<Produit> prods = metier.produitsParMC(mc);
				jtableModel.setData(prods);
				
			}
		});
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CatalogueSwing();

	}

}
