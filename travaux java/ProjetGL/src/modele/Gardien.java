package modele;

import visiteurs.Visiteur;

public class Gardien extends Entite {
	private int x; // protected
	private int y;

	public Gardien() {
	}

	public Gardien(int x, int y) {
		super(x, y);
	}

	@Override
	public String toString() {
		return "Gardien [x=" + x + ", y=" + y + "]";
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