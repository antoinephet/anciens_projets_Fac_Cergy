package jeu;


import java.awt.Image;
import javax.swing.ImageIcon;

public class Arbre extends ChoseAbstraite {
	
	private Image arbre;
	private ImageIcon iArbre = new ImageIcon("images/arbre.png");

	public Arbre(int x, int y) {
		super(x, y);
		arbre = iArbre.getImage();
	}

	public Image getArbre(){ return arbre;}
	
	@Override
	public String toString() {
		return "Arbre [" + x + ", " + y + "]";
	}
}
