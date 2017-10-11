package skieur;

//importe ce qu'il faut

import java.applet.AudioClip;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.io.*;
import java.net.*;

//la classe

public class Skieur extends JFrame implements MouseListener, KeyListener {
	
//enregistre les lignes
	
ArrayList lignes = new ArrayList();

//enregistre le premier point de la ligne

Point2D.Double point;


//fils d'execution

Mouvement mouvement;
Compteur compt;

//informations gÃ©omÃ©triques sur le skieur

Rectangle skieur = null;

//dessin ou non du skieur

boolean dessineSkieur = false;

//compteur

int compteur;

//le son a-t-il été joué ?

boolean sonJoue = false;

//temps final

int tempsFinal = 0;

//utiliser la valeur retenue

boolean utiliseTemps = false;

//si le skieur arrive en bas, on change son icône

boolean vivant = true;

//constructeur

public Skieur() {
	  
  //titre
	  
  super("Le Skieur");
  setSize(1000, 1000);
  setVisible(true);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  addMouseListener(this);
  addKeyListener(this);
  
  compt = new Compteur();
  compt.parti = false;
  compt.run();
}

public void paint(Graphics g) {
	  
  super.paint(g);
  
  //les lignes sont dessinées en noir
  
  g.setColor(Color.black);
  
  //parcourt l'ArrayList et dessine toutes les lignes
  
  for (int i = 0; i < lignes.size(); i++) {
	  
      //récupère la ligne
	  
      Line2D.Double temp = (Line2D.Double) lignes.get(i);
      
      //récupère les coordonnées
      
      int x1 = Integer.parseInt("" + Math.round(temp.getX1()));
      int y1 = Integer.parseInt("" + Math.round(temp.getY1()));
      int x2 = Integer.parseInt("" + Math.round(temp.getX2()));
      int y2 = Integer.parseInt("" + Math.round(temp.getY2()));
      g.drawLine(x1, y1, x2, y2);
  }
  if(dessineSkieur) {
      try {
    	  
    	//dessine le temps
    	  
          g.setFont(new Font("times new roman", Font.BOLD, 16));
          URL urlTemps = this.getClass().getResource("temps.png");
          Image imgT = Toolkit.getDefaultToolkit(). getImage(urlTemps);
          g.drawImage(imgT, -35, 10, this);
          if(!utiliseTemps){
        	  
            g.drawString("Chrono courant : "+compteur, 50, 50);
            
            }
          else {
        	  
            g.drawString("Chrono courant: "+tempsFinal, 50, 50);
            
            }
    	  

        //dessine le skieur
      	
          if(vivant) {
              URL url = this.getClass().getResource("skieur.png");
              Image img = Toolkit.getDefaultToolkit(). getImage(url);
              g.drawImage(img, skieur.x, skieur.y, this);
            } else {
              URL url = this.getClass().getResource("skieurMort.png");
              Image img = Toolkit.getDefaultToolkit().getImage(url);
              g.drawImage(img, skieur.x, skieur.y, this);
              
              //si le son n'a pas encore été joué, on le joueif the snd hasn't been played, play it!
              
              if(!sonJoue) {
            	  
                //temps final
            	  
                tempsFinal = compteur;
                utiliseTemps = true;
                
                //joue le son
                
                URL son = this.getClass().getResource("hurlement.wav");
                AudioClip hurlement = JApplet.newAudioClip(son);
                hurlement.play();
                sonJoue = true;
                
                //regarde si le joueur a gagné
                
                verifieVictoire();
              }
            }
        
      } catch(Exception e){}
    }
}

//méthode nécessaire à  MouseListener

public void mouseClicked(MouseEvent e) {
}

//méthode nécessaire à  MouseListener

public void mouseEntered(MouseEvent e) {
}

//méthode nécessaire à  MouseListener

public void mouseExited(MouseEvent e) {
}

//méthode nécessaire à  MouseListener

public void mousePressed(MouseEvent e) {
	  
  //exécuté lorsqu'on appuie sur le bouton de la souris
  //récupère le premier point de la ligne
	  
  point = new Point2D.Double(e.getX(), e.getY());
}

//méthode nécessaire à  MouseListener

public void mouseReleased(MouseEvent e) {
	  
  //exécuté lorsqu'on relâche le bouton de la souris
  //termine la ligne et l'ajoute Ã  l'ArrayList
	  
  Point2D.Double fin = new Point2D.Double(e.getX(), e.getY());
  lignes.add(new Line2D.Double(point, fin));
  
  //rafraîchit l'écran pour dessiner la ligne
  
  repaint();
}

//méthode nécessaire à KeyListener

public void keyPressed(KeyEvent e){}

//méthode nécessaire à  KeyListener

public void keyReleased(KeyEvent e){}

//méthode nécessaire à  KeyListener

public void keyTyped(KeyEvent e) {
	

//si l'utilisateur appuie sur "l" ou sur "L", démarre le Thread
	
if(e.getKeyChar()=='l' || e.getKeyChar()=='L') {
  //initialisation du Thread
  mouvement = new Mouvement();
  mouvement.start();
  mouvement.action(true);
  
  compt.parti = true;
  vivant = true;
  compteur = 0;
  utiliseTemps = false;
  sonJoue = false;
}

//si l'utilisateur appuie sur "q" ou sur "Q", arrête le Thread 

if(e.getKeyChar()=='q' || e.getKeyChar()=='Q') {
  mouvement.action(false);
  dessineSkieur = false;
  mouvement = null;
  
  compt.parti = false;
}
}

//fil d'exécution du mouvement du joueur

private class Mouvement extends Thread {
	
	//vitesse et gravité du joueur
	
	  double vitesse;
	  double gravite;
	
	//démarre et arrête le fil d'exécution
	  
	    boolean go = false;
	    public void run() {
	      if(go) {
	        initSkieur();
	        vitesse = 0;
	        gravite = 1;
	      }
	      while(go) {
	        try {
	        	
	          //ligne sur laquelle se trouve le skieur (ou null si aucune ligne)
	        	
	        	Line2D.Double ligneSkieur = null;
	        	
	          //skieur sur la ligne ou non
	        	
	        	boolean surLigne = false;
	        	
	          //il faut réinitialiser la gravité lorsque le skieur atterit sur la ligne
	          //contient cette information et le numéro de la ligne
	        	
	        	int numeroLigne = -1;
	        	
	          //vérifie si le skieur est sur une ligne
	        	
	        	for(int i = lignes.size()-1; i>=0; i--) {
	        		
	            //récupère la ligne
	        		
	            Line2D.Double temp = (Line2D.Double) lignes.get(i);
	            if(temp.intersects(skieur.x,skieur.y,30,30)) {
	              ligneSkieur = temp;
	              surLigne = true;
	              if(numeroLigne!=i) {
	                numeroLigne = i;
	                gravite = 0;
	              }
	              break;
	            }
	          }
	        	
	          //si le skieur est sur une ligne
	        	
	          if(surLigne) {
	        	  
	            //récupère la nouvelle gravité en soustrayant les y et en divisant par 50
	        	  
	            double mGrav = (ligneSkieur.y2-ligneSkieur.y1)/50;
	            
	            //récupère la nouvelle vitesse en soustrayant les x et en divisant par 100
	            
	            double mVit = (ligneSkieur.x2-ligneSkieur.x1)/100;
	            
	            //gestion des valeurs maximales
	            
	            if(vitesse<5){
	            	
	            	vitesse+=mVit;
	            	
	            }
	              
	            if(gravite<2.5){
	            	
	            	gravite+=mGrav;
	            	
	            }
	              
	          } else {
	            gravite+=.2;
	          }
	          
	          //modifie le mouvement du skieur
	          
	          skieur.x += vitesse;
	          skieur.y += gravite;
	          
	        //regarde si le skieur est encore vivant
	          
	          if(skieur.y > 650){
	        	  
	            vivant = false;
	            
	          }
	          
	          //ralentit le taux de rafraîchissement
	          
	          Thread.sleep(75);
	          
	          //rafraîchit
	          
	          repaint();
	        } catch(Exception e){ break; }
	      }
	    }
	    
	    public void action(boolean a) {
	    	
	      //arrête le fil d'exécution
	      go = a;
	    }
	    public void initSkieur() {
	      /*
	       * définit la position de départ du skieur
	       */
	    	
	      //récupère la première ligne
	    	
	      Line2D.Double premiereLigne = (Line2D.Double) lignes.get(0);
	      
	      //récupère le x et le y du premier point de cette ligne
	      
	      int x = Integer.parseInt(""+Math.round(premiereLigne.x1));
	      int y = Integer.parseInt(""+Math.round(premiereLigne.y1));
	      skieur = new Rectangle(x+30,y-20,30,30);
	      dessineSkieur = true;
	    }
}


private class Compteur extends Thread {
    public boolean parti = true;
    public void run() {
      try {
        while(true) {
          if(parti) {
            Thread.sleep(1000);
            compteur++;
          }
        }
      } catch(Exception e){}
    }
  }
  
  //regarde si le but est atteint

  public void verifieVictoire() {
    if(tempsFinal==15) {
      JOptionPane.showMessageDialog(null,
              "FÃ©licitations !\n\n" +
              "MISSION ACCOMPLIE !");
    }
  }


public static void main(String[] args) {
	  
  //lance le programme
	  
  new Skieur();
}
}
