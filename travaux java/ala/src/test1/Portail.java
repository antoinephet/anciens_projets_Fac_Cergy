package test1;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Portail extends ChoseAbstrait{

	private Image portail;
	private ImageIcon iPortail = new ImageIcon("images/portailhoriz.jpg");

	public Portail(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		portail = iPortail.getImage();
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
	
	public Image getPortail(){
		
		return portail;
		
	}

}
