package jeu;

import java.util.Observable;

public abstract class ChoseAbstraite extends Observable{
	
	protected int x;
	protected int y;
	
	public ChoseAbstraite(){}
	
	public ChoseAbstraite(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {	return x;}
	
	public void setX(int x) { this.x = x;}
	
	public int getY() { return y;}
	
	public void setY(int y) { this.y = y;}
}
