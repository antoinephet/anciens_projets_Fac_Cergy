package console;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Intrus extends ChoseAbstrait{

	private Image intrus;
	private ImageIcon iIntrus = new ImageIcon("images/intrus1.jpg");

	public Intrus(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		intrus = iIntrus.getImage();
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
	
	public Image getIntrus(){
		
		return intrus;
		
	}

	@Override
	public String toString() {
		return "Intrus [x=" + x + ", y=" + y + "]";
	}
	
	

}
