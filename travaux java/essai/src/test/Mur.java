package test;


public class Mur {
	
	private int hauteurMur;

	public Mur(int hauteurMur) {
		
		this.hauteurMur = hauteurMur;
	}

	public int getHauteurMur() {
		return hauteurMur;
	}

	public void setHauteurMur(int hauteurMur) {
		this.hauteurMur = hauteurMur;
	}

	@Override
	public String toString() {
		return "Mur [hauteurMur=" + hauteurMur + "]";
	}
	
	
	

}

