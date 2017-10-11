package course;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.applet.AudioClip;;




public class Course extends JFrame {
	
	//variables pour les images
	  URL url1 = null, url2 = null, url3 = null, url4 = null,
	          url5 = null, url6 = null, url7 = null, url8 = null, urlT = null;
	  Image img1,img2,img3,img4,
	          img5,img6,img7,img8, titre;
	  
	//nombre de tous des joueurs
	  int toursJ1 = 0, toursJ2 = 0;
	  
	//a la valeur true si quelqu'un a gagnÃ©
	  boolean gagnantOK = false;
	
	// constantes contenant la taille de l'écran
	final int LARGEUR  = 900, HAUTEUR = 650;
	
	// vitesse des deux joueurs
	
	double vitesseJ1 = 0.5, vitesseJ2 = 0.5;
	
	// constantes représentant les directions
	
	final int HAUT = 0, DROITE  = 1, BAS = 2, GAUCHE = 3;
	
	// garde trace de la direction du joueur (par défaut vers le haut)
	
	int directionJ1 = HAUT;
	int directionJ2 = HAUT;
	
	// rectangles représentant la gauche, la droite, le haut, le bas et le centre
	
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
	
	// rectangle pour la voiture du joueur 1
	
	Rectangle j1 = new Rectangle(LARGEUR/9,HAUTEUR/2,LARGEUR/30,LARGEUR/30);
	
	// rectangle pour la voiture du joueur 2
	
	Rectangle j2 = new Rectangle(((LARGEUR/9)+((int)((LARGEUR/9)*1.5)/2)),(HAUTEUR/2)+(HAUTEUR/10),LARGEUR/30,LARGEUR/30);
	
	
	
	// constructeur
	public Course(){
		// crée le JFrame
		super("La Course du courage");
		setSize(LARGEUR/9,HAUTEUR);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//on charge les adresses
		
	    try {
	      url1 = this.getClass().getResource("course1.jpg");
	      url2 = this.getClass().getResource("course2.jpg");
	      url3 = this.getClass().getResource("course3.jpg");
	      url4 = this.getClass().getResource("course4.jpg");
	      url5 = this.getClass().getResource("course5.jpg");
	      url6 = this.getClass().getResource("course6.jpg");
	      url7 = this.getClass().getResource("course7.jpg");
	      url8 = this.getClass().getResource("course8.jpg");
	      urlT = this.getClass().getResource("titre.png");
	    } catch(Exception e){}
	    //on récupère les images pointées par les URL
	    
	    img1 = Toolkit.getDefaultToolkit().getImage(url1);
	    img2 = Toolkit.getDefaultToolkit().getImage(url2);
	    img3 = Toolkit.getDefaultToolkit().getImage(url3);
	    img4 = Toolkit.getDefaultToolkit().getImage(url4);
	    img5 = Toolkit.getDefaultToolkit().getImage(url5);
	    img6 = Toolkit.getDefaultToolkit().getImage(url6);
	    img7 = Toolkit.getDefaultToolkit().getImage(url7);
	    img8 = Toolkit.getDefaultToolkit().getImage(url8);
	    titre = Toolkit.getDefaultToolkit().getImage(urlT);
	    
	    //affichage d'un écran de bienvenue avec les règles
	    
	    JOptionPane.showMessageDialog(null, "Bienvenue à  la Course du Courage !\n\n"+
	            "Le jeu : deux joueurs font la course.\n"+
	            "Le but : terminer trois tours avant votre adversaire !\n"+
	            "Contrôles :\n"+
	            "Joueur 1 (voiture bleue) :\n"+
	            "directions ZQSD, la vitesse est gérée automatiquement.\n"+
	            "Joueur 2 (voiture rouge) :\n"+
	            "directions IJKL, la vitesse est gérée automatiquement.\n"+
	            "Attention à  l'herbe verte, elle peut vous faire déraper !\n"+
	            "Cliquez sur OK pour démarrer");
		
		
		// démarrage de la classe interne qui a un fonctionnement indépendant
		// puisqu'il s'agit d'un Thread
		
		Mouvement1 m1 = new Mouvement1();
		Mouvement2 m2 = new Mouvement2();
		m1.start();
		m2.start();
		
		
	}
	
	// dessine les voitures et la piste
	
	public void paint(Graphics g){
		
		
		super.paint(g);
		//dessine le fond pour la piste
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0,LARGEUR,HAUTEUR);
		
		// la bordure des dessins est verte
		
		g.setColor(Color.GREEN);
		
		// ligne de départ pour le joueur extérieur
		
		Rectangle ligne0 = new Rectangle(LARGEUR/9,HAUTEUR/2,(int)((LARGEUR/9)*1.5)/2,HAUTEUR/140);
		
		// ligne de départ pour le joueur intérieur
		
		Rectangle ligne1 = new Rectangle(((LARGEUR/9)+((int)((LARGEUR/9)*1.5)/2)),(HAUTEUR/2)+(HAUTEUR/10),(int)((LARGEUR/9)*1.5)/2,HAUTEUR/140);
		
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
		
		
		//dessine le joueur 1
		
	    if(directionJ1==HAUT){
	    	
	    	g.drawImage(img5,j1.x,j1.y,this);
	    	
	    	}
	      
	    if(directionJ1==GAUCHE){
	    	
	    	g.drawImage(img8,j1.x,j1.y,this);
	    }
	      
	    if(directionJ1==BAS){
	    	
	    	g.drawImage(img7,j1.x,j1.y,this);
	    }
	      
	    if(directionJ1==DROITE){
	    	
	    	g.drawImage(img6,j1.x,j1.y,this);
	    }
	      
	    
	    //dessine le joueur 2
	    
	    if(directionJ2==HAUT){
	    	
	    	g.drawImage(img1,j2.x,j2.y,this);
	    }
	      
	    if(directionJ2==GAUCHE){
	    	
	    	g.drawImage(img4,j2.x,j2.y,this);
	    }
	      
	    if(directionJ2==BAS){
	    	
	    	g.drawImage(img3,j2.x,j2.y,this);
	    }
	      
	    if(directionJ2==DROITE){
	    	
	    	g.drawImage(img2,j2.x,j2.y,this);
	    }
	      
		
	
	
	}
	
	
	private class Mouvement1 extends Thread implements KeyListener {
		public void run(){
			// active le KeyListener
			
			addKeyListener(this);
			
			// tout est dans une boucle infinie pour que le processus soit répété
			while(true){
				// le code est dans un bloc try pour pouvoir sortir s'il y a une erreur
				try{
					// rafraichit l'écran
					repaint();
					
					// si la voiture tape dans un mur extérieur, sa vitesse passe à -4
					if(j1.intersects(gauche) || j1.intersects(droite) || j1.intersects(haut) 
							||  j1.intersects(bas) || j1.intersects(obstacle) || 
							j1.intersects(obstacle2) || j1.intersects(j2) ||  
							j1.intersects(obstacle3) || j1.intersects(obstacle4) || 
							j1.intersects(obstacle5)){
						vitesseJ1 = -4;
						
					}
					
					// si la voiture tape dans le centre, vitesse passe à -2.5
					
					if(j1.intersects(centre)){
						vitesseJ1 = -2.5;
						
					}
					
					//nombre de tours :
					
			          if(j1.intersects(arrivee)&&directionJ1==HAUT) {
			            toursJ1++;
			          }
			          
			          //3 tours complets correspondent à  un compte de tours d'environ 24.
			          //on utiliser un bloc if pour compter et l'indiquer à  l'utilisateur
			          //si gagnantOK est false, le joueur a gagné, sinon il a perdu
			          
			          if(toursJ1>=24) {
			            if(!gagnantOK) {
			              gagnantOK = true;
			              JOptionPane.showMessageDialog(null, "Le joueur 1 (bleu) a gagné !!!");
			              break;
			            } else {
			              JOptionPane.showMessageDialog(null, "Joueur 1 : (bleu) : PERDU ! \n Joueur 2 (rouge) : GAGNé !");
			              break;
			            }
			          }
					
					// augmente un peu la vitesse
					
					if(vitesseJ1<=5){
						vitesseJ1+=0.2;
						
					}
					
					// déplacement du joueur en fonction de sa direction
					
					if(directionJ1 == HAUT){
						
						j1.y-=(int)vitesseJ1;
					}
					
					if(directionJ1 == BAS){
						
						j1.y+=(int)vitesseJ1;
					}
					
					if(directionJ1 == GAUCHE){
						
						j1.x-=(int)vitesseJ1;
					}
					
					if(directionJ1 == DROITE){
						
						j1.x+=(int)vitesseJ1;
						
					}
					//diminue le taux de rafraichissement
					
					Thread.sleep(75);
					
				} catch(Exception e){
					// s'il y a une exception, sort de la boucle
					break;
				}
			}
		}
		
		// nécessraire pour le Keylistener
		
		public void keyPressed(KeyEvent event){
			
		}
		
		// nécessraire pour le Keylistener
		
				public void keyRealeased(KeyEvent event){
					
				}
				
				// nécessraire pour le Keylistener
				
				public void keyTyped(KeyEvent event){
					
					if(event.getKeyChar()=='q'){
						directionJ1 = GAUCHE;
					}
					
					if(event.getKeyChar()=='s'){
						directionJ1 = BAS;
					}
					
					if(event.getKeyChar()=='d'){
						directionJ1 = DROITE;
					}
					
					if(event.getKeyChar()=='z'){
						directionJ1 = HAUT;
					}
					
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
	}
	
	private class Mouvement2 extends Thread implements KeyListener {
		public void run(){
			// active le KeyListener
			
			addKeyListener(this);
			
			// tout est dans une boucle infinie pour que le processus soit répété
			while(true){
				// le code est dans un bloc try pour pouvoir sortir s'il y a une erreur
				try{
					// rafraichit l'écran
					repaint();
					
					// si la voiture tape dans un mur extérieur, sa vitesse passe à -4
					
					if(j2.intersects(gauche) || j2.intersects(droite) || j2.intersects(haut) 
							||  j2.intersects(bas) || j2.intersects(obstacle) || 
							j2.intersects(obstacle2) || j1.intersects(j2)){
						
						vitesseJ1 = -4;
						
					}
					
					// si la voiture tape dans le centre, vitesse passe à -2.5
					
					if(j2.intersects(centre)){
						vitesseJ1 = -2.5;
						
					}
					
					//nombre de tours :
					
			          if(j2.intersects(arrivee)&&directionJ2==HAUT) {
			            toursJ2++;
			          }
			          
			          //3 tours complets correspondent à  un compte de tours d'environ 24.
			          //on utiliser un bloc if pour compter et l'indiquer à  l'utilisateur
			          //si gagnantOK est false, le joueur a gagné, sinon il a perdu
			          
			          if(toursJ2>=24) {
			            if(!gagnantOK) {
			              gagnantOK = true;
			              JOptionPane.showMessageDialog(null, "Le joueur 2 (rouge) a gagné !!!");
			              break;
			            } else {
			              JOptionPane.showMessageDialog(null, "Joueur 1 : (bleu) : GAGNé ! \n Joueur 2 (rouge) : PERDU !");
			              break;
			            }
			          }
					
					// augmente un peu la vitesse
					
					if(vitesseJ2<=5){
						vitesseJ2+=0.2;
					}
					
					// déplacement du joueur en fonction de sa direction
					
					if(directionJ2 == HAUT){
						
						j2.y-=(int)vitesseJ2;
						
						}
					
					if(directionJ2 == BAS){
						
						j2.y+=(int)vitesseJ2;
						
					}
					
					if(directionJ2 == GAUCHE){
						
						j2.x-=(int)vitesseJ2;
						
					}
					
					
					if(directionJ2 == DROITE){
						
						j2.x+=(int)vitesseJ2;
						
					}
					
					//diminue le taux de rafraichissement
					Thread.sleep(75);
					
				} catch(Exception e){
					// s'il y a une exception, sort de la boucle
					break;
				}
			}
		}
		
		// nécessraire pour le Keylistener
		public void keyPressed(KeyEvent event){
			
		}
		
		// nécessraire pour le Keylistener
		
		public void keyRealeased(KeyEvent event){
			
		}
		
		// nécessraire pour le Keylistener
		
		public void keyTyped(KeyEvent event){
			
			if(event.getKeyChar()=='j'){
				
				directionJ2 = GAUCHE;
				
			}
			
			if(event.getKeyChar()=='k'){
				
				directionJ2 = BAS;
				
			}
			
			if(event.getKeyChar()=='l'){
				
				directionJ2 = DROITE;
				
			}
			
			if(event.getKeyChar()=='i'){
				
				directionJ2 = HAUT;
				
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
	
	
	//ceci démarre le programme en appelant le constructeur
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Course();
		

	}

}
