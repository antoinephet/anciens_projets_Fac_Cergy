package game;

import java.awt.Graphics;
import java.util.Random;

public class Enemy implements Entity{
	
	private double x;
	private double y;
	
	Random r = new Random();
	
	
	//private BufferedImage image;
	
	private Textures tex;
	
	public Enemy(double x, double y,Textures tex) {
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
		y += 5 ;
		
		// remet l'ennemi en haut de l'écran et place aléatoirement en abscisse l'ennemi
		if(y > (Game.HEIGHT * Game.SCALE)){
			y = 0;
			x = r.nextInt(Game.WIDTH * Game.SCALE);
			
		}
	}
	
	
	public void render(Graphics g){
		// dessine le bullet
		g.drawImage(tex.enemy,(int)x, (int)y, null);
		
		}

}
