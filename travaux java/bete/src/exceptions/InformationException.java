package exceptions;

public class InformationException extends Exception {
    
	private int ligne;
	private int colonne;
	
	
	public InformationException(int ligne,int colonne){
		
		this.ligne=ligne;
		this.colonne=colonne;
	}
	
	public String toString(){
		
		return "Cette case n'existe pas"+
		" le nombre de case est comprise entre "+ligne+" et "+colonne;
	}

}
