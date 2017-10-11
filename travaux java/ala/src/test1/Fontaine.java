package test1;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Fontaine extends ChoseAbstrait{

	private Image fontaine;
	private ImageIcon iFontaine = new ImageIcon("images/fontaine.jpg");

	public Fontaine(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		fontaine = iFontaine.getImage();
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
	
	public Image getFontaine(){
		
		return fontaine;
		
	}

}
