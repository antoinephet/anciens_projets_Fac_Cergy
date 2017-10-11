package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Player implements Entity{
	private double x;
	private double y;
	
	private double velX = 0;
	private double velY = 0;
	
	//private BufferedImage player;
	private Textures tex;
	
	public Player(double x, double y, Textures tex) {
		this.x = x;
		this.y = y;
		this.tex = tex;
		//Game game
		//SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		//player = ss.gradImage(1, 1, 32, 32);
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
	
	public void setVelX(double velX) {
		this.velX = velX;
	}
	
	public void setVelY(double velY) {
		this.velY = velY;
	}



	public void tick(){
		//x++;
		
		x +=velX;
		y +=velY;
		
		// Collision, joueur doit pas sortir du JFrame
				if(x <= 0){
					
					x = 0;
				}
				if(y <= 0){
					
					y = 0;
				}
				if(x >= 640 -18){
			
					x = 640 - 18;
				}
				if(y >= 480 -32){
					
					y = 480 - 32;
				}
		
	}
	
	
	public void render(Graphics g){
		g.drawImage(tex.player, (int)x, (int)y, null);
		
		}
	
	

}
