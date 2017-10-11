package test1;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Buisson1 extends ChoseAbstrait{
	
	private Image buisson1;
	private ImageIcon iBuisson1 = new ImageIcon("images/haievertic.jpg");

	public Buisson1(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		buisson1 = iBuisson1.getImage();
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
	
	public Image getBuisson1(){
		
		return buisson1;
		
	}

}
