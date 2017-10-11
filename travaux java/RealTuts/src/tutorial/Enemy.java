package tutorial;



import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;



public class Enemy extends GlobalPosition{
	
	private int speed = 5;
	
	private String image = "/images/intrus.png";

	public Enemy(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		// vitesse deplacement rectiligne et horizontal de l'ennemi 
		x+=speed;
		if(x > MainClass.WIDTH - 32){
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
		// dessine l'ennemi
		g2d.drawImage(getEnemyImage(), x, y, null);
		
		
	}
	
	public Image getEnemyImage(){
		
		// retourne l'image instancié
		ImageIcon i = new ImageIcon(getClass().getResource(image));
		return i.getImage();
		
	}

}
