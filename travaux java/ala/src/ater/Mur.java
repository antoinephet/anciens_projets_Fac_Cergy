package ater;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Mur {
	
	private int x;
	private int y;
	private String murImage = "/images/mur.png";
	
	public Mur(int x, int y) {
		
		this.x = x;
		this.y = y;
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
		return "Mur [x=" + x + ", y=" + y + "]";
	}
	
	public void update(){
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32, 32);
	}
	
	public void draw(Graphics2D g2d){
		
		// dessine le mur
		g2d.drawImage(getMurImage(), x, y, null);
		//g2d.draw(getBounds());
	}
	
	public Image getMurImage(){
		
		// retourne l'image instancié
		ImageIcon i = new ImageIcon(getClass().getResource(murImage));
		return i.getImage();
		
	}
	
	

}
