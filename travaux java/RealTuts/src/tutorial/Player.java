package tutorial;



import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;




public class Player extends GlobalPosition {
	
	private String playerImage = "/images/gardien.png";
	private int velX = 0;
	private int velY = 0;
	
	private ArrayList<Enemy> e1 = Controller.getEnemyBounds();
	
	public Player(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		x +=velX;
		y +=velY;
		
		// Collision, joueur doit pas sortir du JFrame
		if(x < 0){
			
			x = 0;
		}
		if(y < 0){
			
			y = 0;
		}
		if(x > 608){
	
			x = 608;
		}
		if(y > 418){
			
			y = 418;
		}
		
		Collision();
	}
	
	public void Collision(){
		// test collision, si joueur touche enemi alors affiche sur console "collision"
		for(int i = 0;i < e1.size();i++){
			if(getBounds().intersects(e1.get(i).getBounds())){
				
				System.out.println("COLLISION");
				
			}
		}
		
	}
	
	
	public void keyPressed(KeyEvent e) {
		// attribution des touches du clavier
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT){
			velX = 5;
		}
		else if(key == KeyEvent.VK_LEFT){
			velX = -5;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			velY = 5;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			velY = -5;
			
		}
	
		
	}

	
	public void keyReleased(KeyEvent e) {
		// attribution des touches du clavier
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT){
			velX = 0;
		}
		else if(key == KeyEvent.VK_LEFT){
			velX = 0;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			velY = 0;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			velY = 0;
			
		}
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32, 32);
	}
	
	public void draw(Graphics2D g2d){
		
		// dessine le joueur
		g2d.drawImage(getPlayerImage(), x, y, null);
		//g2d.draw(getBounds());
	}
	
	public Image getPlayerImage(){
		
		// retourne l'image instancié
		ImageIcon i = new ImageIcon(getClass().getResource(playerImage));
		return i.getImage();
		
	}

}
