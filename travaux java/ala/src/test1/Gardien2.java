package test1;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Gardien2 extends ChoseAbstrait{
	
	Image gardien2;
	private ImageIcon iGardien2 = new ImageIcon("images/gardien2.png");
	
	public Gardien2(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		//ImageIcon iGardien = new ImageIcon(getClass().getResource("images/gardien.png")); // (getClass().getResource("images/gardien.png"))
		gardien2 = iGardien2.getImage();
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
	
	public Image getGardien2(){
		
		return gardien2;
		
	}

}
