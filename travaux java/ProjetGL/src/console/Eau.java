package console;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Eau extends ChoseAbstrait{

	private Image eau;
	private ImageIcon iEau = new ImageIcon("images/eau.png");

	public Eau(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		eau = iEau.getImage();
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
	
	public Image getEau(){
		
		return eau;
		
	}

	@Override
	public String toString() {
		return "Eau [x=" + x + ", y=" + y + "]";
	}
	
	
	
	

}
