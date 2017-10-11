package genie;

import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChasseAuxGenies extends JFrame implements ActionListener{
	
    //ce tableau contient les 25 JButton
	
    JButton[][] boutons = new JButton[5][5];
    
  //affiche le score
    
    JLabel lblScore = new JLabel();
    
    //le score
    
    double score = 0;
    
    //icone affich�e lorsque le mauvais g�nie sort de son laboratoire
    
    ImageIcon vivant = new ImageIcon("vivant.gif");
    
  //fil d'ex�cution du jeu
    
    T jeu = null;
    
    //constructeur
    
    public ChasseAuxGenies() {
    	
        //cr�e le JFrame
    	
        super("Chasse aux mauvais g�nies");
        setSize(350, 325);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //contient les boutons et libell�s
        
        Container cont = getContentPane();
        cont.setLayout(new FlowLayout());
        
        //pr�pare l'affichage des boutons
        
        for (int i = 0; i < boutons.length; i++) {
            for (int j = 0; j < boutons[0].length; j++) {
            	
                //cr�e le JButton
            	
                boutons[i][j] = new JButton(vivant);
                
                //ajoute le bouton au JFrame
                
                cont.add(boutons[i][j]);
                
                //d�sactive le bouton
                
                boutons[i][j].setEnabled(false);
                
              //le bouton r�pond aux clics
                
                boutons[i][j].addActionListener(this);
            }
        }
        
        //affichage du score
        
        cont.add(lblScore);
        setContentPane(cont);
        
        //d�marre le fil d'ex�cution
        
        jeu = new T();
        jeu.start();
        setContentPane(cont);
    }
    
  //fil d'ex�cution
    
    private class T extends Thread {
      public void run() {
    	  
        //boucle infinie
    	  
        while(true) {
        	
          //cr�e une dur�e al�atoire entre 0 et 1.5 secondes
        	
          int pause = (int)(Math.random()*1500);
          try {
        	  
            //pause de la dur�e al�atoire
        	  
            Thread.sleep(pause);
          } catch(Exception e) {
          }
          
          //un g�nie al�atoire appara�t
          
          int genie = (int)(Math.random()*5);
          int genie2 = (int)(Math.random()*5);
          
          //fait sortir le g�nie en activant le bouton
          
          boutons[genie][genie2].setEnabled(true);
          try {
        	  
            //pause pour laisser le temps au joueur d'attraper le g�nie
        	  
            Thread.sleep(1000);
          }
          
          catch(Exception e) {
          }
          
          //fait dispara�tre le g�nie
          
          boutons[genie][genie2].setEnabled(false);
          
          //affiche le score
          
          lblScore.setText("SCORE: "+score);
        }
      }
    }
    
    //surveille les clics sur les boutons
    
    public void actionPerformed(ActionEvent e) {
    	
      //augmente le score
    	
      score++ ;
      
      //met le jeu en pause pour une demi-seconde
      
      try {
        jeu.sleep(500);
        Thread.sleep(500);
      } catch(Exception ex) {
      }
    }
    

    public static void main(String[] args) {
    	
        //d�marre le jeu
    	
        new ChasseAuxGenies();
    }
}