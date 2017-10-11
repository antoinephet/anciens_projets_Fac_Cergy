package jeu;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Eau {
	
	private int x,y;
	private int surface;
	private int profondeur;
	private Image eau;
	private ImageIcon iEau = new ImageIcon("images/eau.png");
	
	
	public Eau(int x, int y) {

		this.x = x;
		this.y = y;
		eau = iEau.getImage();
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

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public int getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}
	
	public Rectangle getBounds(){
		
		Rectangle box = new Rectangle(x,y,34,34);
		return box;
		
	}

	public Image getEau() {
		return eau;
	}

	public void setEau(Image eau) {
		this.eau = eau;
	}
	
	
	
	

}
