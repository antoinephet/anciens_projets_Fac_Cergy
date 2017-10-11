package marioSokobanEditor;

import javax.swing.JFrame;

public class EditorFrame extends JFrame{
	
	public EditorFrame(){
		
		// Creation de la fenetre
		
		this.setTitle("Editeur de map");
		this.setSize(408, 408);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new EditorBoard(this));
		this.setVisible(true);
	}

}
