package mem;


import  javax.swing.*;
import  javax.swing.event.*;
import  java.awt.*;
import  java.awt.event.*;

public class Memoire extends JFrame implements ActionListener {
	
  //image vide
	
  ImageIcon vide = new ImageIcon("vide.png");
  
  //tableau de boutons
  
  JButton boutons[ ][ ] = {{new JButton(vide),new JButton(vide),
          new JButton(vide),new JButton(vide)},
          {new JButton(vide),new JButton(vide),
                   new JButton(vide),new JButton(vide)},
                   {new JButton(vide),new JButton(vide),
                            new JButton(vide),new JButton(vide)},
                            {new JButton(vide),new JButton(vide),
                                     new JButton(vide),new JButton(vide)}};
  
  //l'image de tous les boutons
  
  int emplacements[ ][ ] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
  Container cont;
  
  //le joueur a-t-il déjà  cliqué
  
  boolean dejaClique = false;
  boolean aVerifier = false;
  
  //première carte retournée
  
  int premiereCarte;
  
  //position 1 de la première carte
  
  int premiereCartePos1;
  
  //position 2 de la première carte
  
  int premiereCartePos2;
  
  //deuxième carte retournée
  
  int deuxiemeCarte;
  
  //position 1 de la deuxième carte
  
  int deuxiemeCartePos1;
  
  //position 2 de la deuxième carte
  
  int deuxiemeCartePos2;
  
  // le constructeur
  
  public Memoire() {
	  
    super("Jeu de Mémoire");
    setSize(415,500);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cont = getContentPane();
    cont.setLayout(null);
    
    //images du jeu
    
    for(int i = 0; i <boutons[0].length; i++) {
      for(int j = 0; j < boutons.length; j ++) {
        cont.add(boutons[i][j]);
        boutons[i][j].setBounds(i*100,j*100,100,100);
        boutons[i][j].addActionListener(this);
      }
    }
    melange();
    Verificateur verif = new Verificateur();
    verif.start();
  }
  
  
  public class Verificateur extends Thread {
    public void run() {
      while(true) {
        if(aVerifier) {
          try {
            sleep(500);
          } catch(Exception ex){ }
          if(premiereCarte!=deuxiemeCarte) {
        	  
            //si les images ne correspondent pas, on re-retourne les images
        	  
            boutons[premiereCartePos1][premiereCartePos2].setIcon(vide);
            boutons[deuxiemeCartePos1][deuxiemeCartePos2].setIcon(vide);
          }
          aVerifier = false;
        }
      }
    }
  }
  
  public void melange() {
    try {
    	
      //pause
    	
      Thread.sleep(500);
      
      //évite qu'une image soit utilisée plus de deux fois
      
      int compteUsage[ ] = {0,0,0,0,0,0,0,0};
      for(int i = 0; i < boutons[0].length; i++) {
        for(int j = 0; j < boutons.length; j++) {
        	
          //nombre aléatoire
        	
          int rand = (int)(Math.random()*8)+1;
          while(compteUsage[rand -1]>1) {
        	  
            //trouve un meilleur nombre aléatoire
        	  
            rand = (int)(Math.random()*8)+1;
          }
          
          //ne pas utiliser une image plus de deux fois
          
          compteUsage[rand-1]++;
          
          //dÃ©finit l'image
          
          boutons[i][j].setIcon(new ImageIcon("img"+rand+".png"));
          
          //keep track of the images
          
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
  
  public void actionPerformed(ActionEvent e) {
	  
    //s'il s'agit de la première carte retournée
	  
    if(!dejaClique) {
      for(int i = 0; i < boutons[0].length; i++) {
        for(int j = 0; j < boutons.length; j++) {
          if(e.getSource()==boutons[i][j]) {
        	  
            //affiche l'image
        	  
            int numImage = emplacements[i][j];
            boutons[i][j].setIcon(new ImageIcon("img"+numImage+".png"));
            premiereCarte = numImage;
            premiereCartePos1 = i;
            premiereCartePos2 = j;
          }
        }
      }
      dejaClique = true;
    }
    
    //s'il s'agit de la deuxième carte retournée
    
    else {
      for(int i = 0; i < boutons[0].length; i++) {
        for(int j = 0; j < boutons.length; j++) {
          if(e.getSource()==boutons[i][j]) {
        	  
            //affiche l'image
        	  
            int numImage = emplacements[i][j];
            boutons[i][j].setIcon(new ImageIcon("img"+numImage+".png"));
            deuxiemeCarte = numImage;
            deuxiemeCartePos1 = i;
            deuxiemeCartePos2 = j;
            cont.validate();
          }
        }
        
        //le fil d'exécution cherche une victoire
        
        dejaClique = false;
        aVerifier = true;
      }
    }
  }
  
  // démarre le jeu
  
  public static void main(String[ ] args) {
    new Memoire();
  }
}

