package test1;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Gardien3 extends ChoseAbstrait{
	
	Image gardien3;
	private ImageIcon iGardien3 = new ImageIcon("images/gardien3.png");
	
	public Gardien3(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		//ImageIcon iGardien = new ImageIcon(getClass().getResource("images/gardien.png")); // (getClass().getResource("images/gardien.png"))
		gardien3 = iGardien3.getImage();
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
	
	public Image getGardien3(){
		
		return gardien3;
		
	}

}

