package marioSokobanGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Mario {
	
	int x,y;
	String marioDir = "BAS";
	Image mario;
	ImageIcon iMarioBas = new ImageIcon("images/mario_bas.gif");
	ImageIcon iMarioDroite = new ImageIcon("images/mario_droite.gif");
	ImageIcon iMarioGauche = new ImageIcon("images/mario_gauche.gif");
	ImageIcon iMarioHaut = new ImageIcon("images/mario_haut.gif");
	
	public Mario(int Startx, int Starty) {
		
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

	public String getMarioDir() {
		return marioDir;
	}

	public void setMarioDir(String marioDir) {
		this.marioDir = marioDir;
	}
	
	
	public Image getImage(){
		
		if(marioDir == "BAS"){
			mario = iMarioBas.getImage();
			
		}
		else if(marioDir == "DROITE"){
			mario = iMarioDroite.getImage();
			
		}
		else if(marioDir == "GAUCHE"){
			mario = iMarioGauche.getImage();
			
		}
		else if(marioDir == "HAUT"){
			mario = iMarioHaut.getImage();
			
		}
		return mario;
		
	}
	
	public void move(){
		
		if(marioDir == "BAS"){
			this.y += 34;
			
		}
		else if(marioDir == "DROITE"){
			this.x += 34;
			
		}
		else if(marioDir == "GAUCHE"){
			this.x -= 34;
			
		}
		else if(marioDir == "HAUT"){
			this.y -= 34;
			
		}
		
	}
	
	

}
