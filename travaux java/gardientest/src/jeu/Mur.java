package jeu;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Mur {
	
	private int x,y;
	private int hauteurMur;
	private Image mur;
	private ImageIcon iMur = new ImageIcon("images/mur.png");
	
	public Mur(int x, int y) {

		this.x = x;
		this.y = y;
		mur = iMur.getImage();
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
	
	public Rectangle getBounds(){
		
		Rectangle box = new Rectangle(x,y,34,34);
		return box;
		
	}

	public Image getMur() {
		return mur;
	}

	public void setMur(Image mur) {
		this.mur = mur;
	}
	
	
	
	
	
	

}
