package ater;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Controller {
	
	static ArrayList<Gardien> gardiens = new ArrayList<Gardien>() ; 
	static ArrayList<Intrus> intrus = new ArrayList<Intrus>() ;
	Intrus tempIntrus;
	Gardien tempGardien;

	public Controller(){
		addIntrus(new Intrus(100,150));
		addIntrus(new Intrus(200,250));
		//addGardien(new Gardien(450, 400));
	}
	
	public void update(){
		// mise en place des ennemis
		for(int i = 0;i < intrus.size();i++){
			tempIntrus = intrus.get(i);
			
			// si les ennemis atteignent le point x = 20, ils disparaissent
			if(tempIntrus.x < 20){
				removeIntrus(tempIntrus);
				
			}
			tempIntrus.update();
			
		}
		/*for(int b = 0;b < gardiens.size();b++){
			tempGardien = gardiens.get(b);
			
			// si les ennemis atteignent le point x = 20, ils disparaissent
			if(tempGardien.x < 20){
				removeGardien(tempGardien);
				
			}
			tempGardien.update();
			
		}*/
	}
	
	
	public void draw(Graphics2D g2d){
		
		// dessine les intrus
		for(int i = 0;i < intrus.size();i++){
			
			tempIntrus = intrus.get(i);
			tempIntrus.draw(g2d);
		}
		
		// dessine les gardiens
		/*for(int i = 0;i < gardiens.size();i++){
			
			tempGardien = gardiens.get(i);
			tempGardien.draw(g2d);
		}*/
		
	}
	
	public void addIntrus(Intrus intrus1){
		intrus.add(intrus1);
		
	}
	
	public void removeIntrus(Intrus intrus1){
		
		intrus.remove(intrus1);
		
	}
	
	public void addGardien(Gardien gardien){
		gardiens.add(gardien);
		
	}
	
	public void removeGardien(Gardien gardien){
		
		gardiens.remove(gardien);
		
	}
	
	public static ArrayList<Intrus> getIntrusBounds(){
		return intrus;
	}
}
