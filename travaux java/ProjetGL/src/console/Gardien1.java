package console;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Gardien1 extends ChoseAbstrait{
	
	private Image gardien1;
	private ImageIcon iGardien1 = new ImageIcon("images/gardien1.png");
	
	public Gardien1(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		//ImageIcon iGardien = new ImageIcon(getClass().getResource("images/gardien.png")); // (getClass().getResource("images/gardien.png"))
		gardien1 = iGardien1.getImage();
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
	
	public Image getGardien1(){
		
		return gardien1;
		
	}

	@Override
	public String toString() {
		return "Gardien1 [x=" + x + ", y=" + y + "]";
	}
	

}
