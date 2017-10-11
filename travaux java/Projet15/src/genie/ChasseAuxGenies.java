package genie;

import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChasseAuxGenies extends JFrame implements ActionListener{
	
    //ce tableau contient les 25 JButton
	
    JButton[][] boutons = new JButton[5][5];
    
  //affiche l'état du jeu
    
    JLabel score = new JLabel();
    
    //variables pour garder trace du score
    
    int maxPause = 1000;
    double coups = 0;
    double tours = 0;
    double toursMax = 0;
    
    //icone affichée lorsque le mauvais génie sort de son laboratoire
    
    ImageIcon vivant = new ImageIcon("vivant.gif");
    
  //fil d'exécution du jeu
    
    T jeu = null;
    
    //constructeur
    
    public ChasseAuxGenies() {
    	
        //crée le JFrame
    	
        super("Chasse aux mauvais génies");
        setSize(350, 325);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      //contient le nombre de tours que l'utilisateur joue
        
        toursMax = Double.parseDouble(JOptionPane.showInputDialog("Combien de chances voulez-vous avoir d'attraper un mauvais génie ?"));
        
        //contient les boutons et libellés
        
        Container cont = getContentPane();
        cont.setLayout(new FlowLayout());
        
        //prépare l'affichage des boutons
        
        for (int i = 0; i < boutons.length; i++) {
            for (int j = 0; j < boutons[0].length; j++) {
            	
                //crée le JButton
            	
                boutons[i][j] = new JButton(vivant);
                
                //ajoute le bouton au JFrame
                
                cont.add(boutons[i][j]);
                
                //désactive le bouton
                
                boutons[i][j].setEnabled(false);
                
              //le bouton répond aux clics
                
                boutons[i][j].addActionListener(this);
            }
        }
        
        //affichage du score
        
        score.setText("Tour " + tours + "/" + toursMax + ". Score actuel :" + ((int) ((coups / toursMax) * 100)));
        cont.add(score);
        setContentPane(cont);
        
        //démarre le fil d'exécution
        
        jeu = new T();
        jeu.start();
        
    }
    
  //fil d'exécution
    
    private class T extends Thread {
      public void run() {
    	  
        //boucle infinie
    	  
        while(true) {
        	
        	//regarde si le jeu est terminé
        	
            if (tours >= toursMax) {
            	
                //si le jeu est terminé, affiche le score
            	
                JOptionPane.showMessageDialog(null,
                        "Le jeu est terminé.\n\n" + "Vous avez attrapé " +
                        coups + " mauvais génies en " + tours + " tours.\n" + "Votre score est " +
                        ((int) (((coups * 10000) / tours))),
                        "Fin du jeu",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            }
            
            //compte le nombre de tours
            
            tours++;
        	
          //crée une durée aléatoire entre 0 et 1.5 secondes
        	
          int pause = (int)(Math.random()*1500);
          try {
        	  
            //pause de la durée aléatoire
        	  
            Thread.sleep(pause);
          } catch(Exception e) {
          }
          
          //un génie aléatoire apparaît
          
          int genie = (int)(Math.random()*5);
          int genie2 = (int)(Math.random()*5);
          
          //fait sortir le génie en activant le bouton
          
          boutons[genie][genie2].setEnabled(true);
          int apparition = (int) (Math.random() * maxPause);
          try {
        	  
            //pause pour laisser le temps au joueur d'attraper le génie
        	  
            Thread.sleep(apparition);
          }
          
          catch(Exception e) {
          }
          
          //fait disparaître le génie
          
          boutons[genie][genie2].setEnabled(false);
          
          //affiche le score
          
        //affiche les statistiques
          score.setText("Tour " + tours + "/" + toursMax +
                  ". Score actuel : " +
                  ((int) (((coups * 10000) / toursMax))));
        }
      }
    }
    
    //surveille les clics sur les boutons
    
    public void actionPerformed(ActionEvent e) {
    	
    	//si un génie a été attrapé
        //diminue le temps d'affichage des génies
        //pour rendre le jeu plus difficile
    	
        maxPause -= 100;
        
    	//augmente le score
    	
        coups++ ;
        
        //met le jeu en pause pour une demi-seconde
      
      try {
        jeu.sleep(500);
        Thread.sleep(500);
      } catch(Exception ex) {
      }
    }
    

    public static void main(String[] args) {
    	
        //démarre le jeu
    	
        new ChasseAuxGenies();
    }
}