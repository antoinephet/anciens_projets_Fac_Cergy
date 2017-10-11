package jeu;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Arbre {
	
	private int x,y;
	private float hauteurArbre;
	private Image arbre;
	private ImageIcon iArbre = new ImageIcon("images/arbre.png");
	
	
	public Arbre(int x, int y) {
		
		this.x = x;
		this.y = y;
		arbre = iArbre.getImage();
		
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
	public float getHauteurArbre() {
		return hauteurArbre;
	}
	public void setHauteurArbre(float hauteurArbre) {
		this.hauteurArbre = hauteurArbre;
	}
	
	public Rectangle getBounds(){
		
		Rectangle box = new Rectangle(x,y,34,34);
		return box;
		
	}
	public Image getArbre() {
		return arbre;
	}
	public void setArbre(Image arbre) {
		this.arbre = arbre;
	}
	
	

}
