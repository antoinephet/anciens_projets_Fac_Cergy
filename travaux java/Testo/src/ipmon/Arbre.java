package ipmon;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Arbre {
	
	int x,y;
	Image arbre;
	
	
	public Arbre(int Startx, int Starty) {
		
		x = Startx;
		y = Starty;
		
		ImageIcon iMur = new ImageIcon("images/arbre.png");
		arbre = iMur.getImage();
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
	
	public Image getImage(){
		
		return arbre;
		
	}
	
	

}
