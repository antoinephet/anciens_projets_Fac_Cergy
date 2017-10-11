package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;


public class Controller {
	
	private ArrayList<Entity> b = new ArrayList<Entity>();
	Entity ent;
	Textures tex;
	Random r = new Random();
	
	public Controller(Textures tex){
		this.tex = tex;
		// ajoute le nombre d'ennemis
		for(int i = 0;i < 5;i++){
			
			// place au hasard en abscisse
			addEntity(new Enemy(r.nextInt(640), 10, tex));
			
		}
		
		
	}
	
	/*private ArrayList<Bullet> b = new ArrayList<Bullet>();
	private ArrayList<Enemy> e = new ArrayList<Enemy>();
	
	Bullet tempBullet;
	Enemy tempEnemy;
	Game game;
	Textures tex;
	
	Random r = new Random();*/
	
	/*public Controller(Game game,Textures tex){
		
		this.game = game;
		this.tex = tex;
		//addBullet(new Bullet(100,300,game)); ajoute la position de la balle
		
		// met aléatoirement la position de l'ennemi en haut de l'écran
		//addEnemy(new Enemy(r.nextInt(Game.WIDTH * Game.SCALE), 0, tex));
		
		for(int x = 0;x < (Game.WIDTH * Game.HEIGHT);x += 64){
			addEnemy(new Enemy(x, 0, tex));
			
		}
		
	}*/
	
	public void tick(){
		
		for(int i = 0;i < b.size();i++){
			ent = b.get(i);
			
			ent.tick();
			
		}
		
	}
	
	public void render(Graphics g){
		
		for(int i = 0;i < b.size();i++){
			ent = b.get(i);
			
			ent.render(g);
			
		}
		
	}
	
	public void addEntity(Entity block){
		b.add(block);
		
	}
	
	public void removeEntity(Entity block){
		
		b.remove(block);
		
	}
	
	/*public void tick(){
		// mise en place des bullets
		for(int i = 0;i < b.size();i++){
			tempBullet = b.get(i);
			
			// si les bullets atteignent en haut de l'écran, ils disparaissent
			if(tempBullet.getY() < 0){
				removeBullet(tempBullet);
				
			}
			tempBullet.tick();
			
		}
		
		// mise en place des ennemis
		for(int i = 0;i < e.size();i++){
			tempEnemy = e.get(i);
			
		
			 // remet l'ennemi en haut de l'écran
			if(tempEnemy.getY() > (Game.HEIGHT * Game.SCALE)){
				tempEnemy.setY(0);
				
			}
			
			tempEnemy.tick();
			
		}
	}*/
	
	/*public void render(Graphics g){
		
		// dessine les bullets
		for(int i = 0;i < b.size();i++){
			
			tempBullet = b.get(i);
			tempBullet.render(g);
		}
		
		for(int i = 0;i < e.size();i++){
			tempEnemy = e.get(i);
			
			tempEnemy.render(g);
			
		}
		
	}
	
	public void addBullet(Bullet block){
		b.add(block);
		
	}
	
	public void removeBullet(Bullet block){
		
		b.remove(block);
		
	}
	
	public void addEnemy(Enemy block){
		e.add(block);
		
	}
	
	public void removeEnemy(Enemy block){
		
		e.remove(block);
		
	}*/
	
	

}
