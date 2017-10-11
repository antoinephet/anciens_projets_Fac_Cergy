package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet implements Entity{
	
	private double x;
	private double y;
	
	//private BufferedImage image;
	
	private Textures tex;
	
	public Bullet(double x, double y,Textures tex) {
		this.x = x;
		this.y = y;
		this.tex = tex;
		
		//Game game
		//SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		// int col, int row, int width, int h
		//image = ss.gradImage(1, 1, 32, 32);
		
	}


	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}



	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	public void tick(){
		// monte progressivement vers le haut de l'écran
		y -= 10;
				
	}
	
	
	public void render(Graphics g){
		// dessine le bullet //parm image
		g.drawImage(tex.missile,(int)x, (int)y, null);
		
		}

}
