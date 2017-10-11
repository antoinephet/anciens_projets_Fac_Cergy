package cm;

public class TestPoint {


	public static void main(String[] args) {
		
		Point p1 = new Point(2, 5);
		Point p2 = new Point(3, 7);
		
		p1.afficher();
		p2.afficher();
		
		
		p2.deplacer(5, 5);
		
		p1.afficher();
		p2.afficher();
		
		System.out.println(p1);
		System.out.println(p2.toString());

	}

}
