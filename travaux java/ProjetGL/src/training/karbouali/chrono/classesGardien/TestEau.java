package training.karbouali.chrono.classesGardien;

public class TestEau {

public static void main(String[] args) {
	Eau fleuve = new Eau("Fleuve",45,10);
	Eau riviere = new Eau("Riviere",60,12);
	Eau marigot = new Eau("Marigot",20.56f,7.0f);
	
	System.out.println(fleuve.toString());
	fleuve.setprofondeur(1000);

	System.out.println("Apres Modification de la profondeur");

	System.out.println(fleuve.toString());
	System.out.println(riviere.toString());
	System.out.println(marigot.toString());
	fleuve.typeObstacle();
	riviere.typeObstacle();
	marigot.typeObstacle();
	
	
	
	
}
}

