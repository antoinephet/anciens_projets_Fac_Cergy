package jeu;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Ipmon extends ChoseAbstraite{
	
	private Image ipmon;
	private ImageIcon iIpmon = new ImageIcon("images/ipmon.jpg");

	public Ipmon(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		
		ipmon = iIpmon.getImage();
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
	
	public Image getIpmon(){
		
		return ipmon;
		
	}
	
	@Override
	public String toString() {
		return "Ipmon [x=" + x + ", y=" + y + "]";
	}

}
