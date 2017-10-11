package exceptions;

public class PlacerException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private int limite;

	public PlacerException(int limite){
		
		this.limite=limite;
	}
	
	public String toString(){
		
		return "Entrez le nombre de case et de bête \n" +
				"le nombre de bête et de case doit être \nsuperieur à 0 le nombre " +
				" de bête doit être inferieur ou égal à "+limite+
				" \nle nombre de case maximum et de 12";
	}

}
