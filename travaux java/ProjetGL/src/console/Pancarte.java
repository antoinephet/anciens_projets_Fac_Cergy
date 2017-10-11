package console;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Pancarte extends ChoseAbstrait{

	private Image pancarte;
	private ImageIcon iPancarte = new ImageIcon("images/pancarte.jpg");

	public Pancarte(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		pancarte = iPancarte.getImage();
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
	
	public Image getPancarte(){
		
		return pancarte;
		
	}

	@Override
	public String toString() {
		return "Pancarte [x=" + x + ", y=" + y + "]";
	}
	
	

}
