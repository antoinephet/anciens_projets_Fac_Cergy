package test;

public class TestContact {

	public static void main(String[] args) {
		Contact jean = new Contact("Jean", "0612121212", "jean@gmail.com");
		Contact paul = new Contact("Paul", "0618181818", "paul@yahoo.com");
		System.out.println("Before changes :");
		System.out.println(jean.toString());
		System.out.println(paul.toString());
		
		jean.setEmail("jean@hotmail.com");
		paul.setNumber("0620202020");
		System.out.println("After changes :");
		System.out.println(jean.toString());
		System.out.println(paul.toString());
		
		Mur mur = new Mur(1);
		Arbre arbre = new Arbre(2);
		System.out.println(mur.toString());
		System.out.println(arbre.toString());
		
	}

}
