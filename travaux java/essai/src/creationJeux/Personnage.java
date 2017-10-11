package creationJeux;

import java.util.Random;

public class Personnage {
	
	private int vie;
	private int xp;
	private int force;
	
	
	public Personnage() {
		
		
		vie = 100;
		xp = 0;
		force = 10;
	}
	
	
	public Personnage(int vie, int xp, int force) {
		
		
		this.vie = vie;
		this.xp = xp;
		this.force = force;
	}
	
	
	
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	
	
	public void setReposer(int i){
		
		if(i < 1){
			
			i = 1;
			
		}
		
		if(i >3){
			
			i = 3;
		}
		
		if(i == 1){
			
			vie += 5;
			if(vie > 100){
				
				vie = 100;
			}
		}
		
		if(i == 2){
			
			vie += 10;
			if(vie > 100){
				
				vie = 100;
			}
		}
		
		
	}
	
	public int attaquer(){
		
		Random rand = new Random();
		int d = rand.nextInt(force) + 5;
		return d;
	}

	
	// Surcharge
	
	@Override
	public String toString() {
		
		return "Personnage [vie=" + vie + ", xp = " + xp + ", force = "+ force + "]";
		
	}

}
