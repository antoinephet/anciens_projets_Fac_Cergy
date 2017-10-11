package marioSokobanGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Objectif {
	
	int x,y;
	Image objectif;
	boolean caisseDessus = false;
	
	public Objectif(int Startx, int Starty) {
		
		x = Startx;
		y = Starty;
		
		ImageIcon iObjectif = new ImageIcon("images/objectif.png");
		objectif = iObjectif.getImage();
	}
	
	
	public Rectangle getBounds(){
		
		Rectangle box = new Rectangle(x,y,34,34);
		return box;
		
	}
	
	public Image getImage(){
		
		return objectif;
		
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


	public boolean isCaisseDessus() {
		return caisseDessus;
	}


	public void setCaisseDessus(boolean caisseDessus) {
		this.caisseDessus = caisseDessus;
	}
	
	
	
	

}
