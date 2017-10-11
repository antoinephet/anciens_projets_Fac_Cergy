package test;

public class Arbre {
	
	
	private float arbre;
	
	
	public Arbre(float arbre){
		super();
		this.arbre = arbre;
	}

	/**
	 * @return the arbre
	 */
	public float getArbre() {
		return arbre;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Arbre [arbre=" + arbre + ", getArbre()=" + getArbre()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	/**
	 * @param arbre the arbre to set
	 */
	public void setArbre(float arbre) {
		this.arbre = arbre;
	}
	

	

}
