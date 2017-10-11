package antoine;

import  javax.swing.*;
import  javax.swing.event.*;
import  java.awt.*;
import  java.awt.event.*;
import  java.util.*;
import  java.awt.geom.*;


public class LesSouris extends JFrame implements KeyListener {
	  Container cont;
	  
	  //tableau à  deux dimensions
	  
	  String arene[ ][ ] =
	  {{"#","#","#","#","#","#","#","#","#","#"},
	   {"#"," "," "," "," "," "," "," "," ","#"},
	   {"#"," "," "," "," ","|","#","#"," ","#"},
	   {"#"," ","#"," "," ","|","#"," "," ","#"},
	   {"#"," "," "," "," ","|","#"," "," ","#"},
	   {"#"," ","#","#","#","#","#","#"," ","#"},
	   {"#"," "," "," "," "," "," "," "," ","#"},
	   {"#","#","#","#"," "," ","#","#","#","#"},
	   {"#"," "," "," "," "," "," "," "," ","#"},
	   {"#","#","#","#","#","#","#","#","#","#"}};
	  
	  
	  /*for(i= 0;i<grille.length;i++){
			for(j =0;j<grille.length;j++){
				grille [i][j] = (int)(Math.round(Math.random()*1));
				
			}
		}
		
		for(int i = 0; i < grille.length; i++) {
	      for(int j = 0; j < grille[0].length; j++) {
	        JLabel lbl = null;
	        if(grille[j][i] == 0) {
	          lbl = new JLabel(new ImageIcon("brique.png"));
	        } else if(grille[j][i] == 1) {
	          lbl = new JLabel(new ImageIcon("air.png"));
	        } else if(grille[j][i] == 2) {
	          lbl = new JLabel(new ImageIcon("echelle.png"));*/

	  
	  //---------------------------------------------------------------
      // Les Variables
      //---------------------------------------------------------------
	  
	  
	  //score
	  int score = 0;
	  
	  //nombre d'étoiles restantes
	  int NourritureRestantes;
	  
	  //nombre de souris
	  int nbSouris = 1;
	  
	   //nombre de souriceau
	  int nbSouriceau = 1;
	  
	  // temps restant avant la partie terminée
	  int tempsRestant = 30;
	  
	  //Joueur est-il en train d'escalader ou de sauter ?
	  boolean saut = false;
	  boolean escalade = false;
	  
	  //fil d'exécution
	  Jeu jeu;
	  
	  Compteur compteur;
	  
	  //---------------------------------------------------------------
      // Les Arraylist
      //---------------------------------------------------------------
	  
	  
	  //contient les étoiles
	  ArrayList nourritures = new ArrayList();
	  
	  // contient les souris
	  ArrayList souris = new ArrayList();
	  ArrayList mice = new ArrayList();
	  
	   
	  //---------------------------------------------------------------
      // Les JLabels
      //---------------------------------------------------------------
	   
	  // créé Joueur
	  JLabel joueur = new JLabel(new ImageIcon("main.png"));
	  
	  //crée images pour la victoire ou la défaite
	  JLabel defaite = new JLabel(new ImageIcon("defaite.png"));
	  
	  // créé le fond à droite de l'écran
	  JLabel fond = new JLabel(new ImageIcon("fond2.png"));
	  
	  //affiche le score
	  JLabel lblScore = new JLabel("Score : "+score);
	  
	   // JLabel affichant le temps restant
	  JLabel temps = new JLabel(tempsRestant+"");
	  
	  
	  
	  //-----------------------------------------------------------------------------
	  
	  // le constructeur
	  
	  public LesSouris() {
		  
		super("Les Souris"); // ajoute le titre de la fenêtre
	    setSize(700,535); // taille de la fenêtre
	    setVisible(true); // rendre visible
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    cont = getContentPane();
	    cont.setLayout(null);
	    addKeyListener(this); // indique au clavier de se "réveiller" et de commencer à écouter les commandes
	    cont.setBackground(Color.black); // couleur de l'arrière plan de la fenêtre
	    
	    // affiche les messages
	    JOptionPane.showMessageDialog(null,"Bienvenue chez Les Souris!!");
	    JOptionPane.showMessageDialog(null,"But du jeu :\n\nAttraper plus de nourriture pour la survie de la souris.\nLa partie sera terminée lorsque le temps imparti est écoulé.");
	    JOptionPane.showMessageDialog(null,"Conseil : Parlez aux Souris! Ils vous aideront peut-être à trouver de la nourriture");
	    JOptionPane.showMessageDialog(null,"Commandes du jeu :\n\nQ - Se déplacer à gauche\nD - Se déplacer à droite\nZ - Sauter vers le haut");
	    JOptionPane.showMessageDialog(null,"Bonne partie!!");
	    
	    
	    //ajoute l'image de fin de partie en dehors de l'écran
	    cont.add(defaite);
	    defaite.setBounds(500,500,500,500);
	    
	    // ajoute image fond gris
	    cont.add(fond);
	    fond.setBounds(500,0,274,535);
	    
	    // ajoute le JLabel temps
	    cont.add(temps);
	    temps.setBounds(655,35,250,20);
	    cont.setComponentZOrder(temps,0);
	    
	    
	    //affiche le score
	    cont.add(lblScore);
	    lblScore.setFont(new Font("arial",Font.BOLD,20));
	    lblScore.setBounds(515,70,250,20);
	    cont.setComponentZOrder(lblScore,0);
	    

	    // ajoute Joueur
	    cont.add(joueur);
	    joueur.setBounds(50,400,50,50);
	    
	    // crée la nourriture et les souris
	    genereSouris();
	    genereNourriture();
	    
	    
	    // génère le tableau,le plateau du jeu
	    
	    for(int i = 0; i < arene.length; i++) {
	      for(int j = 0; j < arene[0].length; j++) {
	    	  
	        JLabel lbl = null;
	        
	        if(arene[j][i].equals("#")) {
	          lbl = new JLabel(new ImageIcon("brique.png"));
	        } else if(arene[j][i].equals(" ")) {
	          lbl = new JLabel(new ImageIcon("air.png"));
	        } else if(arene[j][i].equals("|")) {
	          lbl = new JLabel(new ImageIcon("echelle.png"));
	        }
	        cont.add(lbl);
	        lbl.setBounds(i*50,j*50,50,50);
	      }
	    }
	    repaint();
	    cont.validate();
	    
	    //démarre le fil d'exécution
	    
	    jeu = new Jeu();
	    jeu.start();
	    setContentPane(cont);
	    compteur = new Compteur();
	    compteur.start();
	  }
	  
	  
	  
	  
	  //---------------------------------------------------------------
      // Génération de Nourriture
      //---------------------------------------------------------------
	  
	  
	  public void genereNourriture() {
		  
	    //boucle dans le tableau à deux dimensions
		  
	    for(int i = 1; i < arene.length; i++) {
	      for(int j = 0; j < arene[0].length; j++) {
	        if(arene[i][j].equals(" ")) {
	        	
	          //une chance sur 10 de placer un fromage
	        	
	          int placeFromage = (int)(Math.random()*10);
	          if(placeFromage==0) {
	        	  
	            //ajoute le fromage
	        	  
	            JLabel fromage = new JLabel(new ImageIcon("fromage.png"));
	            cont.add(fromage);
	            fromage.setBounds(j*50,i*50,50,50);
	            cont.setComponentZOrder(fromage,0);
	            cont.setComponentZOrder(joueur,0);
	            nourritures.add(fromage);
	            NourritureRestantes++;
	          }
	        }
	      }
	    }
	  }
	  
	  
	  
	  
	  //---------------------------------------------------------------
      // Génération de Souris
      //---------------------------------------------------------------
	  
	  public void genereSouris() {
		  
		int choix;
		// demande à l'utilisateur le choix pour les paramètres
		choix = Integer.parseInt(JOptionPane.showInputDialog("Quel type de mode pour l'emplacement des souris ?\nSaisissez :\n1 - Aléatoire\n2 - Manuel"));
	    
		if(choix == 1){
			
			//ajoute un nombre aléatoire de souris
			int augmenterDe = (int)(Math.random()*2)+1;
			nbSouris = augmenterDe;
		}
		
		if(choix == 2){
			int nbSourisBis=0;
			while(nbSourisBis == 0 || nbSourisBis>4){
				//saisir manuellement le nombre de souris
				nbSourisBis = Integer.parseInt(JOptionPane.showInputDialog("Saisissez un chiffre entre 1 et 4"));
			}
			nbSouris = nbSourisBis;
		}
		
	    
	    // ajoute les nouveaux souris
	    
	    for(int i = 0; i < nbSouris; i++) {
	      JLabel souris1 = new JLabel(new ImageIcon("souris1.png"));
	      JLabel souris2 = new JLabel(new ImageIcon("souris2.png"));
	      cont.add(souris1);
	      cont.add(souris2);
	      
	      int emplX = (int)(Math.random()*8);
	      souris1.setBounds(emplX*50,50,50,50);
	      cont.setComponentZOrder(souris1,0);
	      
	      
	      souris2.setBounds(emplX*50,50,50,50);
	      cont.setComponentZOrder(souris2,0);
	      
	      mice.add(souris1);
	      souris.add(souris2);
	      
	      
	    }
	  }
	  
	  
	  
	  //---------------------------------------------------------------
      // Génération de Souriceau
      //---------------------------------------------------------------
	  
	  public void genereSouriceau() {
		  
		  for(int i = 0; i < nbSouriceau; i++) {
			  
			  // Souriceau
			  
			  if(score == 2000){
				  // créé le JLabel souriceau
			  JLabel souriceau = new JLabel(new ImageIcon("souriceau.png"));
			  cont.add(souriceau);
		      
		      
		      int emplX = (int)(Math.random()*8);
		      souriceau.setBounds(emplX*50,50,50,50);
		      cont.setComponentZOrder(souriceau,0);
		      
		      JOptionPane.showMessageDialog(null,"Bravo! Vous vous êtes assez nourri!!\nVous avez donné naissance à un bébé souris");
		      score = 0 ;

		      
		    }
		  }
		  
	  }
	  
	  
	  
	  //---------------------------------------------------------------
      // Classe Compteur, fil d'exécution du Décompte
      //--------------------------------------------------------------- 
	  
	  public class Compteur extends Thread{
		  public void run(){
			  while(true){
				  try {
					  if(tempsRestant>0){
						  tempsRestant--;
						  temps.setText(tempsRestant+"");
					  } else {
						  break;
					  }
					  
					  Thread.sleep(1000);
					  if(tempsRestant == 0){
						  defaite.setBounds(0,0,500,500);
			              cont.setComponentZOrder(defaite,0);
					  }
				  }catch(Exception e){}
				 
			  }
		  }
	  }
	  
	  
	  
	  //---------------------------------------------------------------
      // Classe Jeu
      //--------------------------------------------------------------- 
	  
	  
	  public class Jeu extends Thread {
	    public void run() {
	      while(true) {
	        try {
	        	
	          //score courant
	        	
	          lblScore.setText("Score : "+score);
	          
	          //génère le souriceau au cas où score = 2000
	          genereSouriceau();
	          
	          
	          //---------------------------------------------------------------
	          // Le cas pour les Souris Rouges,égoïstes
	          //---------------------------------------------------------------
	          
	          for(int i = 0; i < souris.size(); i++) {
	            JLabel enemy = (JLabel) souris.get(i);
	            
	            //n'applique ce qui suit qu'aux souris sur l'écran
	            
	            if(enemy.getY()<=450 && enemy.getX()<=450) {
	            	
	              //descend la souris si c'est possible
	            	
	              if(arene[(enemy.getY()/50)+1] [enemy.getX()/50].equals(" ")) {
	                enemy.setBounds(enemy.getX(), enemy.getY()+50,50,50);
	              }
	              
	              //déplace la souris vers la gauche ou la droite
	              
	              int direction = (int)(Math.random()*2);
	              if(direction==0) {
	                if(arene[enemy.getY()/50][(enemy.getX()/50)+1].equals(" ")) {
	                  enemy.setBounds(enemy.getX()+50,enemy.getY(),50,50);
	                }
	              } else {
	                if(arene[enemy.getY()/50][(enemy.getX()/50)-1].equals(" ")) {
	                  enemy.setBounds(enemy.getX()-50,enemy.getY(),50,50);
	                }
	              }
	              
	              //si Joueur saute sur une souris, supprime la souris
	              
	              if(enemy.getY()-50==joueur.getY() && enemy.getX()==joueur.getX()) {
	                enemy.setBounds(1000,1000,50,50);
	                JOptionPane.showMessageDialog(null,"Hey mon ami! Je te donne d'autres fromages à grignoter!! Voilà leurs emplacements!!");
	                genereNourriture();
	                cont.remove(enemy);
	                nbSouris--;
	                
	              }
	              
	            }
	          }
	          
	          
	          //---------------------------------------------------------------
	          // Le cas pour les Souris verts, coopératives
	          //---------------------------------------------------------------
	          
	          // vérifie ce qui suit pour tous les souris
	          
	          for(int i = 0; i < mice.size(); i++) {
	            JLabel enemy = (JLabel) mice.get(i);
	            
	            //n'applique ce qui suit qu'aux souris sur l'écran
	            
	            if(enemy.getY()<=450 && enemy.getX()<=450) {
	            	
	              // descend la souris si c'est possible
	            	
	              if(arene[(enemy.getY()/50)+1] [enemy.getX()/50].equals(" ")) {
	                enemy.setBounds(enemy.getX(), enemy.getY()+50,50,50);
	              }
	              
	              //déplace la souris vers la gauche ou la droite
	              
	              int direction = (int)(Math.random()*2);
	              if(direction==0) {
	                if(arene[enemy.getY()/50][(enemy.getX()/50)+1].equals(" ")) {
	                  enemy.setBounds(enemy.getX()+50,enemy.getY(),50,50);
	                }
	              } else {
	                if(arene[enemy.getY()/50][(enemy.getX()/50)-1].equals(" ")) {
	                  enemy.setBounds(enemy.getX()-50,enemy.getY(),50,50);
	                }
	              }
	              
	              //si Joueur saute sur une souris, supprime la souris
	              
	              if(enemy.getY()-50==joueur.getY() && enemy.getX()==joueur.getX()) {
	                enemy.setBounds(1000,1000,50,50);
	                JOptionPane.showMessageDialog(null,"Je te dirai que dalle sur la nourriture!! Naaah!!");
	                cont.remove(enemy);
	                nbSouris--;
	                
	              }
	              
	            }
	          }
	          
	          
	          //-----------------------------------------------------------------
	          
	          //On relance la génération des éléments lorsque c'est vide
	          
	          if(nbSouris<=0 && NourritureRestantes<=0) {
	            
	            genereNourriture();
	            genereSouris();
	            
	          }
	          
	          //vérifie ce qui suit pour toutes les nourritures
	          
	          for(int i = 0; i < nourritures.size(); i++) {
	            JLabel fromage = (JLabel) nourritures.get(i);
	            
	            //si Joueur capture une nourriture, on la supprime
	            
	            if(fromage.getBounds().intersects(joueur.getBounds())) {
	              score+=100;
	              cont.remove(fromage);
	              nourritures.remove(fromage);
	              tempsRestant+=10;
	              NourritureRestantes--;
	            }
	          }
	          
	          //Joueur tombe
	          
	          if(!saut) {
	            if(arene[(joueur.getY()/50)+1][joueur.getX()/50].equals(" ")) {
	            	joueur.setBounds(joueur.getX(),joueur.getY()+50,50,50);
	            }
	          }
	          
	          //Joueur saute
	          
	          else {
	            saut = false;
	            if(arene[(joueur.getY()/50)-1][joueur.getX()/50].equals(" ")) {
	            	joueur.setBounds(joueur.getX(),joueur.getY()-50,50,50);
	            }
	          }
	          
	          // Temporisation
	          
	          Thread.sleep(250);
	        } catch(Exception e){ }
	      }
	    }
	  }
	  
	  public void keyPressed(KeyEvent e){ }
	  
	  public void keyReleased(KeyEvent e){ }
	  
	  public void keyTyped(KeyEvent e) {
		  
	    //déplacement vers la gauche
		  
	    if(e.getKeyChar()=='q') {
	    	
	      //si Joueur escalade, termine l'escalade
	    	
	      if(escalade) {
	        escalade = false;
	        joueur.setIcon(new ImageIcon("main.png"));
	      }
	      
	      //déplace Joueur vers la gauche si possible
	      
	      if(joueur.getX()>=50 &&
	              arene[joueur.getY()/50][(joueur.getX()/50)-1] .equals(" ")) {
	    	  joueur.setBounds(joueur.getX()-50,joueur.getY(),50,50);
	      }
	    }
	    
	    // déplacement vers la droite
	    
	    if(e.getKeyChar()=='d') {
	    	
	      //empêche joueur de sortir de l'écran
	    	
	      if(joueur.getX()<=400 &&
	              arene[joueur.getY()/50][(joueur.getX()/50)+1].equals(" ")) {
	    	  joueur.setBounds(joueur.getX()+50,joueur.getY(),50,50);
	      }
	      
	      //si joueur touche une échelle, commence à  escalader
	      
	      if(arene[joueur.getY()/50][(joueur.getX()/50)+1].equals("|")) {
	    	  joueur.setBounds(joueur.getX()+50,joueur.getY(),50,50);
	        escalade = true;
	        joueur.setIcon(new ImageIcon("main.png"));
	      }
	    }
	    
	    //saute/escalade
	    
	    if(e.getKeyChar()=='z') {
	    	
	      //si joueur ne grimpe pas, alors il saute
	    	
	      if(!escalade) {
	        if(arene[(joueur.getY()/50)-1][joueur.getX()/50].equals(" ")) {
	          if(!saut && !arene[(joueur.getY()/50)+1][joueur.getX()/50].equals(" ")) {
	            saut = true;
	            joueur.setBounds(joueur.getX(),joueur.getY()-50,50,50);
	          }
	        }
	      }
	      
	      //déplace Joueur sur l'échelle
	      
	      else {
	    	  joueur.setBounds(joueur.getX(),joueur.getY()-50,50,50);
	        
	        //joueur a atteint le haut de l'échelle, change son icône et le déplace
	        
	        if(arene[joueur.getY()/50][joueur.getX()/50].equals(" ")) {
	        	joueur.setBounds(joueur.getX()+50,joueur.getY(),50,50);
	          escalade = false;
	          joueur.setIcon(new ImageIcon("main.png"));
	        }
	      }
	    }
	  }
	  
	  
	  
	  
	}