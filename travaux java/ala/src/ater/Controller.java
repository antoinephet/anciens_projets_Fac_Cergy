package ater;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Controller {
	
	static ArrayList<Gardien> gardiens = new ArrayList<Gardien>() ; 
	static ArrayList<Intrus> intrus = new ArrayList<Intrus>() ;
	private ArrayList<Mur> murs = new ArrayList<Mur>();
	Intrus tempIntrus;
	Gardien tempGardien;
	Mur tempMur;

	public Controller(){
		addIntrus(new Intrus(100,150));
		addIntrus(new Intrus(200,250));
		addIntrus(new Intrus(300,350));
		addIntrus(new Intrus(400,450));
		addGardien(new Gardien(150, 100));
		addGardien(new Gardien(250, 200));
		addGardien(new Gardien(340, 300));
		addGardien(new Gardien(450, 400));
		addMur(new Mur(2,2));
	}
	
	public void update(){
		// mise en place des ennemis
		for(int i = 0;i < intrus.size();i++){
			tempIntrus = intrus.get(i);
			
			
			tempIntrus.update();
			
		}
		for(int b = 0;b < gardiens.size();b++){
			tempGardien = gardiens.get(b);
			
			
			tempGardien.update();
			
		}
		for(int a = 0;a < murs.size();a++){
			tempMur = murs.get(a);
			
			
			tempMur.update();
			
		}
	}
	
	
	public void draw(Graphics2D g2d){
		
		// dessine les intrus
		for(int i = 0;i < intrus.size();i++){
			
			tempIntrus = intrus.get(i);
			tempIntrus.draw(g2d);
		}
		
		// dessine les gardiens
		for(int i = 0;i < gardiens.size();i++){
			
			tempGardien = gardiens.get(i);
			tempGardien.draw(g2d);
		}
		
		// dessine les murs
		for(int i = 0;i < murs.size();i++){
			
			tempMur = murs.get(i);
			tempMur.draw(g2d);
		}
		
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
	
	public void addMur(Mur i){
		murs.add(i);
		
	}
	
	public void removeMur(Mur i){
		
		murs.remove(i);
		
	}
}
