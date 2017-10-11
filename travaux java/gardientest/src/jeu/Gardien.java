package jeu;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Gardien {
	
	private int x,y;
	private Image gardien;
	private ImageIcon iGardien = new ImageIcon("images/gardien.png");
	
	public Gardien(int x, int y) {
		
		this.x = x;
		this.y = y;
		gardien = iGardien.getImage();
		
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

	public Image getGardien() {
		return gardien;
	}

	public void setGardien(Image gardien) {
		this.gardien = gardien;
	}
	
	
	
	
	

}
