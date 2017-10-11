package jeu;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Intrus {
	
	private int x,y;
	private Image intrus;
	private ImageIcon iIntrus = new ImageIcon("images/intrus.png");
	
	public Intrus(int x, int y) {
		
		this.x = x;
		this.y = y;
		intrus = iIntrus.getImage();
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
	public Image getIntrus() {
		return intrus;
	}
	public void setIntrus(Image intrus) {
		this.intrus = intrus;
	}
	
	
	
	

}
