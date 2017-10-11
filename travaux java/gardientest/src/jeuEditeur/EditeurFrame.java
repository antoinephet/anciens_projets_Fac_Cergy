package jeuEditeur;

import javax.swing.JFrame;

public class EditeurFrame extends JFrame {
	
	public EditeurFrame(){
		
		// Creation de la fenetre
		
		this.setTitle("Editeur de map");
		this.setSize(408, 408);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new EditeurPanel());
		this.setVisible(true);
		
		
		
	}
	

}
