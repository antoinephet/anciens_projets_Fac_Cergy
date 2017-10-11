package marioSokobanGame;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Mur {
	
	int x,y;
	Image mur;
	
	
	public Mur(int Startx, int Starty) {
		
		x = Startx;
		y = Starty;
		
		ImageIcon iMur = new ImageIcon("images/mur.jpg");
		mur = iMur.getImage();
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
		
		return mur;
		
	}
	
	

}
