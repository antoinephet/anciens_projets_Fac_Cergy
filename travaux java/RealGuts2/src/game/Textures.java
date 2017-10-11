package game;

import java.awt.image.BufferedImage;

public class Textures {
	
	public BufferedImage player, missile, enemy;
	
	private SpriteSheet ss;
	
	public Textures(Game game){
		
		ss = new SpriteSheet(game.getSpriteSheet());
		
		getTextures();
	}

	private void getTextures() {
		// TODO Auto-generated method stub
		
		player = ss.gradImage(1, 1, 32, 32);
		missile = ss.gradImage(1, 1, 32, 32);
		enemy = ss.gradImage(1, 1, 32, 32);
		
	}
	
	

}
