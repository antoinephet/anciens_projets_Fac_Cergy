package tutorial;

import java.awt.Graphics2D;
import java.util.ArrayList;




public class Controller {
	
	static ArrayList<Enemy> e = new ArrayList<Enemy>();
	private Enemy tempEnemy;
	
	public Controller(){
		addEnemy(new Enemy(100,150));
		addEnemy(new Enemy(200,200));
		addEnemy(new Enemy(300,100));
		addEnemy(new Enemy(100,200));
		addEnemy(new Enemy(100,300));
		addEnemy(new Enemy(100,400));
		addEnemy(new Enemy(50,100));
		addEnemy(new Enemy(20,70));
	}

	
	public void update(){
		// mise en place des ennemis
		for(int i = 0;i < e.size();i++){
			tempEnemy = e.get(i);
			
			// si les ennemis atteignent le point x = 20, ils disparaissent
			if(tempEnemy.x < 20){
				removeEnemy(tempEnemy);
				
			}
			tempEnemy.update();
			
		}
	}
	
	
	public void draw(Graphics2D g2d){
		
		// dessine les ennemis
		for(int i = 0;i < e.size();i++){
			
			tempEnemy = e.get(i);
			tempEnemy.draw(g2d);
		}
		
	}
	
	public void addEnemy(Enemy enemy){
		e.add(enemy);
		
	}
	
	public void removeEnemy(Enemy enemy){
		
		e.remove(enemy);
		
	}
	
	public static ArrayList<Enemy> getEnemyBounds(){
		return e;
	}
}
