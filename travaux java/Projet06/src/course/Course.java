package course;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;




public class Course extends JFrame {
	
	// constantes contenant la taille de l'écran
	final int LARGEUR  = 900, HAUTEUR = 650;
	
	/* 
	 * Le code suivant (créant les rectangles) peut sembler compliquer
	 * à première vue, mais cela n'est dû qu'à l'utilisation de LARGEUR
	 * et HAUTEUR pour créer les morceaux. Vous pouvez aussi utiliser des valeurs codées
	 * en dur
	 */
	
	/* Définition de tous les rectangles à dessiner */
	
	/* 
	 * Le code suivant (créant les rectangles) peut sembler compliquer
	 * à première vue, mais cela n'est dû qu'à l'utilisation de LARGEUR
	 * et HAUTEUR pour créer les morceaux. Vous pouvez aussi utiliser des valeurs codées
	 * en dur
	 */
	
	// crée les rectangles à gauche, à droite, en haut, en bas et au centre
	
	Rectangle gauche = new Rectangle(0,0,LARGEUR/9,HAUTEUR);
	Rectangle droite = new Rectangle((LARGEUR/9)*8,0,LARGEUR/9,HAUTEUR);
	Rectangle haut = new Rectangle(0,0,LARGEUR,HAUTEUR/9);
	Rectangle bas = new Rectangle(0,(HAUTEUR/9)*8,LARGEUR,HAUTEUR/9);
	Rectangle centre = new Rectangle((int)((LARGEUR/9)*2.5),(int)((HAUTEUR/9)*2.5),(int)((LARGEUR/9)*5),(int)((HAUTEUR/9)*4));
	
	// obstacles sur la route rendant la navigation plus difficile
	
	Rectangle obstacle = new Rectangle(LARGEUR/2,(int)((HAUTEUR/9)*7),LARGEUR/10,HAUTEUR/9);
	Rectangle obstacle2 = new Rectangle(LARGEUR/3,(int)((HAUTEUR/9)*5),LARGEUR/10,HAUTEUR/4);
	Rectangle obstacle3 = new Rectangle(2*(LARGEUR/3),(int)((HAUTEUR/9)*5),LARGEUR/10,HAUTEUR/4);
	Rectangle obstacle4 = new Rectangle(LARGEUR/3,HAUTEUR/9,LARGEUR/30,HAUTEUR/9);
	Rectangle obstacle5 = new Rectangle(LARGEUR/2,(int)((HAUTEUR/9)*1.5),LARGEUR/30,HAUTEUR/4);
	
	//ligne d'arrivée pour les deux joueurs
	
	Rectangle arrivee = new Rectangle(LARGEUR/9,(HAUTEUR/2)-HAUTEUR/9,(int)((LARGEUR/9)*1.5),HAUTEUR/70);
	
	// ligne de départ pour le joueur extérieur
	
	Rectangle ligne0 = new Rectangle(LARGEUR/9,HAUTEUR/2,(int)((LARGEUR/9)*1.5)/2,HAUTEUR/140);
	
	// ligne de départ pour le joueur intérieur
	
	Rectangle ligne1 = new Rectangle(((LARGEUR/9)+((int)((LARGEUR/9)*1.5)/2)),(HAUTEUR/2)+(HAUTEUR/10),(int)((LARGEUR/9)*1.5)/2,HAUTEUR/140);
	
	// constructeur
	public Course(){
		// crée le JFrame
		super("La Course du courage");
		setSize(LARGEUR/9,HAUTEUR);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	// dessine les voitures et la piste
	public void paint(Graphics g){
		
		super.paint(g);
		//dessine le fond pour la piste
		
	g.setColor(Color.DARK_GRAY);
	g.fillRect(0, 0,LARGEUR,HAUTEUR);
	
	// la bordure des dessins est verte
	
	g.setColor(Color.GREEN);
	
	// on dessine grâce aux rectangles
	g.fillRect(gauche.x,gauche.y,gauche.width,gauche.height);
	g.fillRect(droite.x,droite.y,droite.width,droite.height);
	g.fillRect(haut.x,haut.y,haut.width,haut.height);
	g.fillRect(bas.x,bas.y,bas.width,bas.height);
	g.fillRect(centre.x,centre.y,centre.width,centre.height);
	g.fillRect(obstacle.x,obstacle.y,obstacle.width,obstacle.height);
	g.fillRect(obstacle2.x,obstacle2.y,obstacle2.width,obstacle2.height);
	g.fillRect(obstacle3.x,obstacle3.y,obstacle3.width,obstacle3.height);
	g.fillRect(obstacle4.x,obstacle4.y,obstacle4.width,obstacle4.height);
	g.fillRect(obstacle5.x,obstacle5.y,obstacle5.width,obstacle5.height);
	
	// pour les lignes de départ on dessine en blanc
	g.setColor(Color.WHITE);
	
	// on dessine les lignes de départ
	
	g.fillRect(ligne0.x,ligne0.y,ligne0.width,ligne0.height);
	g.fillRect(ligne1.x,ligne1.y,ligne1.width,ligne1.height);
	
	// la ligne d'arrivée est en jaune
	g.setColor(Color.YELLOW);
	
	// on dessine la ligne d'arrivée
	
	g.fillRect(arrivee.x,arrivee.y,arrivee.width,arrivee.height);
	
	}
	
	//ceci démarre le programme en appelant le constructeur


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Course();
		

	}

}
