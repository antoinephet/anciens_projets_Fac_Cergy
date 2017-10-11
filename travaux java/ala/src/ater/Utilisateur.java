package ater;

import java.awt.event.KeyEvent;

public class Utilisateur extends Gardien {
	
	private int velX = 0;
	private int velY = 0;
	private boolean activeUser;
	
	public Utilisateur(int x, int y) {
		
		super(x, y);
		
		
	}

	@Override
	public String toString() {
		return "Utilisateur [x=" + x + ", y=" + y + "]";
	}
	
	public void update(){
		
	}
	
	
	
	
	

}
