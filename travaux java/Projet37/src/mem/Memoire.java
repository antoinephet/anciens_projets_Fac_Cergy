package mem;



import  javax.swing.*;
import  javax.swing.event.*;
import  java.awt.*;
import  java.awt.event.*;

public class Memoire extends JFrame {
	
  //l'image vide
	
  ImageIcon vide = new ImageIcon("vide.png");
  
  //les boutons
  
  JButton boutons[][] = {{new JButton(vide),new JButton(vide),
          new JButton(vide),new JButton(vide)},
          {new JButton(vide),new JButton(vide),
                   new JButton(vide),new JButton(vide)},
                   {new JButton(vide),new JButton(vide),
                            new JButton(vide),new JButton(vide)},
                            {new JButton(vide),new JButton(vide),
                                     new JButton(vide),new JButton(vide)}};
  
  //emplacement des boutons
  
  int emplacements[][] = {{0,0,0,0},{0,0,0,0},{0,0,0,0}, {0,0,0,0}};
  Container cont;
   
  // le constructeur
  
  public Memoire() {
    super("Jeu de Mémoire");
    setSize(415,500);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cont = getContentPane();
    cont.setLayout(null);
    for(int i = 0; i <boutons[0].length; i++) {
      for(int j = 0; j <boutons.length; j++) {
    	  
        //ajoute les boutons au plateau
    	  
        cont.add(boutons[i][j]);
        boutons[i][j].setBounds(i*100,j*100,100,100);
      }
    }
    melange();
  }
  
  
  public void melange() {
    try {
    	
      //pause
    	
      Thread.sleep(500);
      
      //évite qu'une image soit utilisée plus de deux fois
      
      int compteUsage[] = {0,0,0,0,0,0,0,0};
      for(int i = 0; i < boutons[0].length; i++) {
        for(int j = 0; j < boutons.length; j++) {
        	
          //nombre aléatoire
        	
          int rand = (int)(Math.random()*8)+1;
          while(compteUsage[rand - 1]>1) {
        	  
            //cherche un meilleur nombre aléatoire
        	  
            rand = (int)(Math.random()*8)+1;
          }
          
          //ne pas utiliser une image plus de deux fois
          
          compteUsage[rand-1]++;
          
          //définit l'image
          
          boutons[i][j].setIcon(new ImageIcon("img"+rand+".png"));
          
          //garde trace des images
          
          emplacements[i][j] = rand;
          cont.validate();
        }
      }
      
      //pause
      
      Thread.sleep(3000);
      
      //deux boucles for
      
      for(int i = 0; i < boutons[0].length; i++) {
        for(int j = 0; j < boutons.length; j++) {
        	
          //retourne les cartes
        	
          boutons[i][j].setIcon(vide);
          cont.validate();
        }
      }
    } catch(Exception e){}
  }
  
  // démarre le jeu
  
  public static void main(String[ ] args) {
    new Memoire();
  }
}
