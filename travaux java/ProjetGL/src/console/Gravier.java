package console;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Gravier extends ChoseAbstrait {

	private Image gravier;
	private ImageIcon iGravier = new ImageIcon("images/gravier.jpg");

	public Gravier(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		gravier = iGravier.getImage();
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
	
	public Image getGravier(){
		
		return gravier;
		
	}

	@Override
	public String toString() {
		return "Gravier [x=" + x + ", y=" + y + "]";
	}
	
	

}
