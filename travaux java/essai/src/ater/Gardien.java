package ater;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;




public class Gardien {
	protected int x ; 
	private int y ;
	private String playerImage = "/images/gardien.png";
	private int velX = 0;
	private int velY = 0;
	private int speed = 5;
	
	
	
	public Gardien(int x, int y) {

		this.x= x;
		this.y = y;
	}


	
	public void update(){
		// vitesse deplacement rectiligne et horizontal de l'ennemi 
				x+=speed;
				if(x > Main.WIDTH - 32){
					speed = -5;
				}
				if(x < 0){
					speed = 5;
				}
				
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32, 32);
	}
	
	public void draw(Graphics2D g2d){
		
		// dessine le joueur
		g2d.drawImage(getGardienImage(), x, y, null);
		//g2d.draw(getBounds());
	}
	
	public Image getGardienImage(){
		
		// retourne l'image instancié
		ImageIcon i = new ImageIcon(getClass().getResource(playerImage));
		return i.getImage();
		
	}



	@Override
	public String toString() {
		return "Gardien [x=" + x + ", y=" + y + "]";
	}
	
	

	
}
