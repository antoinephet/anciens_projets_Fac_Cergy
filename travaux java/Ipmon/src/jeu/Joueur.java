package jeu;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Joueur extends ChoseAbstraite{
	
	private Image joueur;
	private ImageIcon iJoueur = new ImageIcon("images/joueur.jpg");

	public Joueur(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		
		joueur = iJoueur.getImage();
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Image getJoueur(){
		
		return joueur;
		
	}
	
	@Override
	public String toString() {
		return "Joueur [x=" + x + ", y=" + y + "]";
	}
	
	

}
