package training.karbouali.chrono.classesGardien;

public class Mur implements Obstacle {
	

private int hauteurMur;

public Mur (int hauteurMur){
	this.hauteurMur = hauteurMur;
}


public int getHauteurMur() {
	return hauteurMur;
}

public void setHauteurMur(int hauteurMur) {
	this.hauteurMur = hauteurMur;
}
public String toString(){
	return "[Hauteur= " + hauteurMur + "]";
	
}

public void typeObstacle() {
		System.out.println("Mur empêche de passer");
}
	

@Override
public void empecherPasser() {
	
	System.out.println();
}

@Override
public void empecherVoir() {
	System.out.println();
	
}

@Override
public void emplacement() {
	System.out.println();
	
}
public static void main (String[]args){
Mur mur =new Mur(210);
 
mur.typeObstacle();

System.out.println("la hauteur du mur est "  +mur.getHauteurMur()+"m");
}
	

}