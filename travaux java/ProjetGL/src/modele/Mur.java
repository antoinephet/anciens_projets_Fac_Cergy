package modele;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import visiteurs.Visiteur;

public class Mur extends Obstacle {

	private int x;
	private int y;

	public Mur(int x, int y) {

		this.x = x;
		this.y = y;
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

	public Mur() {
		super();
	}

	@Override
	public String toString() {
		return "Mur [x=" + x + ", y=" + y + "]";
	}
	void accepteVisiteur(Visiteur v) {
		v.visite(this);
	}

}
