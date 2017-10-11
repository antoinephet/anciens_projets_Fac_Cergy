package console;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Gardien extends ChoseAbstrait{
	
	private Image gardien;
	private ImageIcon iGardien = new ImageIcon("images/gardien.png");
	
	public Gardien(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		//ImageIcon iGardien = new ImageIcon(getClass().getResource("images/gardien.png")); // (getClass().getResource("images/gardien.png"))
		gardien = iGardien.getImage();
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
	
	public Image getGardien(){
		
		return gardien;
		
	}

	@Override
	public String toString() {
		return "Gardien [x=" + x + ", y=" + y + "]";
	}

	
	
	

}
