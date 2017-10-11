package ater;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Arbre extends Entite {
	
	//private int x;
	//private int y;
	private String arbreImage = "/images/arbre.png";
	
	public Arbre(int x, int y) {
		super(x,y);
		//this.x = x;
		//this.y = y;
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
		return "Arbre [x=" + x + ", y=" + y + "]";
	}
	
public void update(){
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32, 32);
	}
	
	public void draw(Graphics2D g2d){
		
		// dessine le mur
		g2d.drawImage(getArbreImage(), x, y, null);
		//g2d.draw(getBounds());
	}
	
	public Image getArbreImage(){
		
		// retourne l'image instanciť
		ImageIcon i = new ImageIcon(getClass().getResource(arbreImage));
		return i.getImage();
		
	}
	
	
	

}
