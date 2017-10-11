package tps.multi.ws;

public class IdealWeightWS {
	
	public IdealWeight devineFormula(double height_in_cm){
		IdealWeight iw = new IdealWeight();
		iw.men_weight_in_kg = 50 + 2.3*(ConverterWS.cm_to_inch(height_in_cm)-60);
		iw.women_weight_in_kg = 45.5 + 2.3*(ConverterWS.cm_to_inch(height_in_cm)-60);
		return iw;
	}
 
	public IdealWeight millerFormula(double height_in_cm){
		IdealWeight iw = new IdealWeight();
		iw.men_weight_in_kg = 56.2 + 1.41*(ConverterWS.cm_to_inch(height_in_cm)-60);
		iw.women_weight_in_kg = 53.1 + 1.36*(ConverterWS.cm_to_inch(height_in_cm)-60);
		return iw;
	}


}
