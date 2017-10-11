package test1;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Statue extends ChoseAbstrait {

	private Image statue;
	private ImageIcon iStatue = new ImageIcon("images/statue.jpg");

	public Statue(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		statue = iStatue.getImage();
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
	
	public Image getStatue(){
		
		return statue;
		
	}

}
