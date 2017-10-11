package marioSokobanGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Caisse {
	
	int x,y;
	String etat = "NORMALE";
	Image caisse;
	ImageIcon iCaisseNormale = new ImageIcon("images/caisse.jpg");
	ImageIcon iCaisseObjectif = new ImageIcon("images/caisse_ok.jpg");
	boolean caissejuste = false;
	
	
	public Caisse(int Startx, int Starty) {
		
		x = Startx;
		y = Starty;
	}
	
	
	public Rectangle getBounds(){
		
		Rectangle box = new Rectangle(x,y,34,34);
		return box;
		
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


	public boolean isCaissejuste() {
		return caissejuste;
	}


	public void setCaissejuste(boolean caissejuste) {
		this.caissejuste = caissejuste;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public Image getImage(){
		
		if(etat == "NORMALE"){
			caisse = iCaisseNormale.getImage();
			
		}
		else if(etat == "OBJECTIF"){
			caisse = iCaisseObjectif.getImage();
			
		}
		
		return caisse;
		
	}
	

}
