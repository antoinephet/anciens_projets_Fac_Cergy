package boxe;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


//classe avec un JFrame et un ActionListener

public class MorpionBoxeur extends JFrame implements ActionListener {
	
  //tableau de boutons. Nous utilisons un tableau et non un ArrayList
  //car le nombre de boutons est constant.
	
  JButton boutons[] = new JButton[9];
  
  //garde le décompte des tours. le joueur 1 est pair, le joueur 2 impair
  //on utilise le modulo (%) pour différencier les valeurs
  
  int tour = 1;
  
  //représentent les adversaires
  
  ImageIcon rouge = new ImageIcon("rouge.png");
  ImageIcon bleu = new ImageIcon("bleu.png");
  ImageIcon blanc = new ImageIcon("blanc.png");
  
  //constructeur
  
  public MorpionBoxeur() {
    super("Morpion Boxeur");
    setSize(330,350);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //contient les boutons
    
    Container cont = getContentPane();
    
    //disposition des boutons
    
    cont.setLayout(null);
    int nouvelleLigne = 0;
    int compteurLigne = 0;
    for(int i = 0; i < boutons.length; i++) {
    	
      //initialise le bouton avec une image vide
    	
      boutons[i] = new JButton(blanc);
      
      //faut-il utiliser une nouvelle ligne ?
      
      if(i==3 || i ==6) {
        nouvelleLigne++;
        compteurLigne = 0;
      }
      //position du bouton
      
      boutons[i].setBounds(compteurLigne*100,nouvelleLigne*100,100,100);
      
      //ajoute le bouton au conteneur
      
      cont.add(boutons[i]);
      
      //ajoute l'ActionListener
      
      boutons[i].addActionListener(this);
      compteurLigne++;
    }
    cont.repaint();
  }
  
//méthode obligatoire
  
  public void actionPerformed(ActionEvent e) {
	  
    //regarde quel bouton a été cliqué
	  
    for(int i = 0; i < boutons.length; i++) {
      if(e.getSource()==boutons[i]) {
    	  
        //vérifie le tour
    	  
        if(tour%2==0) {
        	
          //si pair, tour du joueur 1 (X)
        	
          boutons[i].setIcon(rouge);
        } else {
        	
          //si impair, tour du joueur 2 (0)
        	
          boutons[i].setIcon(bleu);
        }
        
        //désactive le bouton pour qu'il ne puisse pas être modifié une fois cliqué
        
        boutons[i].removeActionListener(this);
      }
    }
    tour++;
  }
  
  //méthode de démarrage (main)
  
  public static void main(String[ ] args) {
    MorpionBoxeur mp = new MorpionBoxeur();
  }
}
