package ater;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Eau extends Entite{
	
	
	private String eauImage = "/images/eau.png";
	
	public Eau(int x, int y) {
		super(x,y);
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
	@Override
	public String toString() {
		return "Eau [x=" + x + ", y=" + y + "]";
	}
	
	public void update(){
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32, 32);
	}
	
	public void draw(Graphics2D g2d){
		
		// dessine le mur
		g2d.drawImage(getEauImage(), x, y, null);
		//g2d.draw(getBounds());
	}
	
	public Image getEauImage(){
		
		// retourne l'image instancié
		ImageIcon i = new ImageIcon(getClass().getResource(eauImage));
		return i.getImage();
		
	}
	
	
	


}
