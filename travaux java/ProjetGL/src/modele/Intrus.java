package modele;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import visiteurs.Visiteur;

public class Intrus extends Entite {
	private int x; 
	private int y;

	public Intrus(int x, int y) {
		super(x, y);
		this.x= x;
		 this.y = y;
	}

	public Intrus() {
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
	
	void accepteVisiteur(Visiteur v) {
		v.visite(this);
	}

}
