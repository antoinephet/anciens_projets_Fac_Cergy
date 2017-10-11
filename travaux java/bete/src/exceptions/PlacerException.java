package exceptions;

public class PlacerException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private int limite;

	public PlacerException(int limite){
		
		this.limite=limite;
	}
	
	public String toString(){
		
		return "Entrez le nombre de case et de b�te \n" +
				"le nombre de b�te et de case doit �tre \nsuperieur � 0 le nombre " +
				" de b�te doit �tre inferieur ou �gal � "+limite+
				" \nle nombre de case maximum et de 12";
	}

}
