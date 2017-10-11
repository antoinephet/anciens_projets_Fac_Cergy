package console;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Arbre extends ChoseAbstrait{
	
	private Image arbre;
	private ImageIcon iArbre = new ImageIcon("images/arbre.png");

	public Arbre(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		arbre = iArbre.getImage();
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
	
	public Image getArbre(){
		
		return arbre;
		
	}

	@Override
	public String toString() {
		return "Arbre [x=" + x + ", y=" + y + "]";
	}
	
	

}
