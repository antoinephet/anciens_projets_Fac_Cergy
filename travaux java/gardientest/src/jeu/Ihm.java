package jeu;

import javax.swing.JFrame;

public class Ihm extends JFrame{
	
	public Ihm(){
		
		this.setTitle("Gardien de Parc");
		this.setSize(408, 408);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new IhmPanel());
		this.setVisible(true);
	}

}
