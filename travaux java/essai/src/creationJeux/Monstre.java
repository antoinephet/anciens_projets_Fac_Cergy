package creationJeux;

import java.util.Random;

public class Monstre {
	
	private int vie;
	private int force;
	
	public Monstre() {
		
		vie = 30;
		force = 10;
		
		
	}
	
	public Monstre(int vie, int force) {
		
		this.vie = vie;
		this.force = force;
	}
	public int getVie() {
		return vie;
	}
	
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	public int getForce() {
		return force;
	}
	
	public void setForce(int force) {
		this.force = force;
	}
	
	public int attaquer(){
		
		Random rand = new Random();
		int d = rand.nextInt(force) + 1;
		return d;
	}
	
	@Override
	public String toString() {
		return "Monstre [vie=" + vie + ", force=" + force + "]";
	}
	
	

}
