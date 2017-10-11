package test1;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Intrus1 extends ChoseAbstrait{

	private Image intrus1;
	private ImageIcon iIntrus1 = new ImageIcon("images/intrus2.jpg");

	public Intrus1(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		intrus1 = iIntrus1.getImage();
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
	
	public Image getIntrus1(){
		
		return intrus1;
		
	}

}
