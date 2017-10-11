package exceptions;

public class EnvironnementException extends Exception{
	
    private int limite;
	
	public EnvironnementException( int limite){
		
		this.limite=limite;
	}
	
	public String toString(){
		
		return "Precisez le debut et la fin de l'environnement" +
				" Le nombre de case est comprise entre 0 et "+limite;
	}
}
