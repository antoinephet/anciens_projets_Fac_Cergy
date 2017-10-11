package ipmon;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Joueur {
	
	int x,y;
	String joueurDir = "BAS";
	Image joueur;
	ImageIcon iJoueur = new ImageIcon("images/joueur.jpg");
	
	
	public Joueur(int Startx, int Starty) {
		
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
		return joueurDir;
	}

	public void setMarioDir(String marioDir) {
		this.joueurDir = marioDir;
	}
	
	
	public Image getImage(){
		
		if(joueurDir == "BAS"){
			joueur = iJoueur.getImage();
			
		}
		return joueur;
		
	}
	
	public void deplacer(){
		
		if(joueurDir == "BAS"){
			this.y += 34;
			
		}
		else if(joueurDir == "DROITE"){
			this.x += 34;
			
		}
		else if(joueurDir == "GAUCHE"){
			this.x -= 34;
			
		}
		else if(joueurDir == "HAUT"){
			this.y -= 34;
			
		}
		
	}
	
	

}
