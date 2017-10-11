package test1;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Buisson extends ChoseAbstrait{

	private Image buisson;
	private ImageIcon iBuisson = new ImageIcon("images/haiehoriz.jpg");

	public Buisson(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		buisson = iBuisson.getImage();
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
	
	public Image getBuisson(){
		
		return buisson;
		
	}

}
