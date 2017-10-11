package plate;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;

public class Oiram extends JFrame implements KeyListener {
	
  //le conteneur
	
  Container cont;
  
  //tableau à  deux dimensions
  
  String arene[][] =
  {{" "," "," "," "," "," "," "," "," "," "},
   {" "," "," "," "," "," "," "," "," "," "},
   {" "," "," "," "," "," ","|","#","#"," "},
   {" ","#","#","#"," "," ","|","#"," "," "},
   {" "," "," "," "," "," ","|","#"," "," "},
   {" ","#","#","#","#","#","#","#","#"," "},
   {" "," "," "," "," "," "," "," "," "," "},
   {"#","#","#","#"," "," ","#","#","#","#"},
   {" "," "," "," "," "," "," "," "," "," "},
   {"#","#","#","#","#","#","#","#","#","#"}};
  
  //contient les étoiles
  
  ArrayList stars = new ArrayList();
  
  //Oiram
  
  JLabel character = new JLabel(new ImageIcon("oiram.png"));
  
  //Oiram est-il en train d'escalader ou de sauter ?
  
  boolean saut = false;
  boolean escalade = false;
  
  //fil d'exécution
  
  Jeu jeu;
  
  //score
  
  int score = 0;
  
  //nombre d'étoiles restantes
  
  int etoilesRestantes;
  
  //contient les ennemis
  
  ArrayList ennemis = new ArrayList();
  
  //images pour la victoire ou la défaite
  
  JLabel victoire = new JLabel(new ImageIcon("victoire.png"));
  JLabel defaite = new JLabel(new ImageIcon("defaite.png"));
  
  //image de titre
  
  JLabel titre = new JLabel(new ImageIcon("titre.png"));
  
  //niveau courant
  
  int niveau = 1;
  
  //nombre d'ennemis
  
  int nbEnnemis = 1;
  
  //affiche le niveau et le score
  
  JLabel lblNiveau = new JLabel("Niveau "+niveau+"/5");
  JLabel lblScore = new JLabel("Score "+score);
  
  // constructeur
  
  public Oiram() {
	  
    super("Oiram");
    setSize(500,500);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cont = getContentPane();
    cont.setLayout(null);
    addKeyListener(this);
    cont.setBackground(Color.BLACK);
    
    //ajoute les images de défaite et de victoire en dehors de l'écran
    
    cont.add(victoire);
    victoire.setBounds(500,500,500,500);
    cont.add(defaite);
    defaite.setBounds(500,500,500,500);
    
    //affiche le niveau
    
    cont.add(lblNiveau);
    lblNiveau.setFont(new Font("arial",Font.BOLD,20));
    lblNiveau.setBounds(375,5,150,50);
    
    //affiche le score
    
    cont.add(lblScore);
    lblScore.setFont(new Font("arial",Font.BOLD,20));
    lblScore.setBounds(20,5,150,50);
    
    //ajoute l'image de titre
    
    cont.add(titre);
    titre.setBounds(0,0,500,50);
    
    //ajoute Oiram
    
    cont.add(character);
    character.setBounds(0,400,50,50);
    
    //crée les étoiles et les ennemis
    
    genereEtoiles();
    genereEnnemis();
    
    //génère le tableau
    
    for(int i = 0; i < arene.length; i++) {
      for(int j = 0; j < arene[0].length; j++) {
    	  
        JLabel lbl = null;
        
        if(arene[j][i].equals("#")) {
          lbl = new JLabel(new ImageIcon("terre.png"));
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
  }
  
  
  public void genereEtoiles() {
	  
    //boucle dans le tableau à  deux dimensions
	  
    for(int i = 1; i < arene.length; i++) {
      for(int j = 0; j < arene[0].length; j++) {
        if(arene[i][j].equals(" ")) {
        	
          //une chance sur 10 de placer une étoile
        	
          int placeEtoile = (int)(Math.random()*10);
          if(placeEtoile==0) {
        	  
            //ajoute l'étoile
        	  
            JLabel star = new JLabel(new ImageIcon("etoile.png"));
            cont.add(star);
            star.setBounds(j*50,i*50,50,50);
            cont.setComponentZOrder(star,0);
            cont.setComponentZOrder(character,0);
            stars.add(star);
            etoilesRestantes++;
          }
        }
      }
    }
  }
  
  
  public void genereEnnemis() {
	  
    //ajoute un nombre aléatoire d'ennemis
	  
    int augmenterDe = (int)(Math.random()*2)+1;
    nbEnnemis = niveau+augmenterDe;
    
    //ajoute les nouveaux ennemis
    
    for(int i = 0; i < nbEnnemis; i++) {
      JLabel ennemi = new JLabel(new ImageIcon("ennemi.png"));
      cont.add(ennemi);
      int emplX = (int)(Math.random()*8);
      ennemi.setBounds(emplX*50,0,50,50);
      cont.setComponentZOrder(ennemi,0);
      ennemis.add(ennemi);
    }
  }
  
  
  public class Jeu extends Thread {
    public void run() {
      while(true) {
        try {
        	
          //score courant
        	
          lblScore.setText("Score "+score);
          
          //vérifie ce qui suit pour tous les ennemis
          
          for(int i = 0; i < ennemis.size(); i++) {
            JLabel enemy = (JLabel) ennemis.get(i);
            
            //n'applique ce qui suit qu'aux ennemis sur l'écran
            
            if(enemy.getY()<=450 && enemy.getX()<=450) {
            	
              //descend l'ennemi si c'est possible
            	
              if(arene[(enemy.getY()/50)+1] [enemy.getX()/50].equals(" ")) {
                enemy.setBounds(enemy.getX(), enemy.getY()+50,50,50);
              }
              
              //déplace l'ennemi vers la gauche ou la droite
              
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
              
              //si Oiram saute sur un ennemi, supprime l'ennemi
              
              if(enemy.getY()-50==character.getY() && enemy.getX()==character.getX()) {
                enemy.setBounds(1000,1000,50,50);
                cont.remove(enemy);
                nbEnnemis--;
                score+=200;
              }
              
              //si un ennemi mange Oiram, affiche l'image de défaite
              
              if(enemy.getY()==character.getY() &&enemy.getX()==character.getX()) {
                defaite.setBounds(0,0,500,500);
                cont.setComponentZOrder(defaite,0);
                for(int j=2; j < cont.getComponentCount(); j++) {
                  cont.remove(j);
                }
                cont.validate();
              }
            }
          }
          
          //allez au niveau 5 pour gagner !
          
          if(niveau>=5) {
            victoire.setBounds(0,0,500,500);
            cont.setComponentZOrder(victoire,0);
            for(int i = 2; i < cont.getComponentCount(); i++) {
              cont.remove(i);
            }
            cont.validate();
          }
          
          //niveau suivant
          
          if(nbEnnemis<=0 && etoilesRestantes<=0) {
            niveau++;
            genereEtoiles();
            genereEnnemis();
            lblNiveau.setText("Niveau "+niveau+"/5");
          }
          
          //vérifie ce qui suit pour toutes les étoiles
          
          for(int i = 0; i < stars.size(); i++) {
            JLabel star = (JLabel) stars.get(i);
            
            //si Oiram capture une étoile, on la supprime
            
            if(star.getBounds().intersects(character.getBounds())) {
              score+=100;
              cont.remove(star);
              stars.remove(star);
              etoilesRestantes--;
            }
          }
          
          //Oiram tombe
          
          if(!saut) {
            if(arene[(character.getY()/50)+1][character.getX()/50].equals(" ")) {
              character.setBounds(character.getX(),character.getY()+50,50,50);
            }
          }
          
          //Oiram saute
          
          else {
            saut = false;
            if(arene[(character.getY()/50)-1][character.getX()/50].equals(" ")) {
              character.setBounds(character.getX(),character.getY()-50,50,50);
            }
          }
          
          //temporisation
          
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
    	
      //si Oiram escalade, termine l'escalade
    	
      if(escalade) {
        escalade = false;
        character.setIcon(new ImageIcon("oiram.png"));
      }
      
      //déplace Oiram vers la gauche si possible
      
      if(character.getX()>=50 &&
              arene[character.getY()/50][(character.getX()/50)-1] .equals(" ")) {
        character.setBounds(character.getX()-50,character.getY(),50,50);
      }
    }
    
    //déplacement vers la droite
    
    if(e.getKeyChar()=='d') {
    	
      //empêche Oiram de sortir de l'écran
    	
      if(character.getX()<=400 &&
              arene[character.getY()/50][(character.getX()/50)+1].equals(" ")) {
        character.setBounds(character.getX()+50,character.getY(),50,50);
      }
      
      //si Oiram touche une échelle, commence à  escalader
      
      if(arene[character.getY()/50][(character.getX()/50)+1].equals("|")) {
        character.setBounds(character.getX()+50,character.getY(),50,50);
        escalade = true;
        character.setIcon(new ImageIcon("surechelle.png"));
      }
    }
    
    //saute/escalade
    
    if(e.getKeyChar()=='z') {
    	
      //if Oiram is not climbing, then jump up!
    	
      if(!escalade) {
        if(arene[(character.getY()/50)-1][character.getX()/50].equals(" ")) {
          if(!saut && !arene[(character.getY()/50)+1][character.getX()/50].equals(" ")) {
            saut = true;
            character.setBounds(character.getX(),character.getY()-50,50,50);
          }
        }
      }
      
      //déplace Oiram sur l'échelle
      
      else {
        character.setBounds(character.getX(),character.getY()-50,50,50);
        
        //Oiram a atteint le haut de l'échelle, change son icône et le déplace
        
        if(arene[character.getY()/50][character.getX()/50].equals(" ")) {
          character.setBounds(character.getX()+50,character.getY(),50,50);
          escalade = false;
          character.setIcon(new ImageIcon("oiram.png"));
        }
      }
    }
  }
  
  // démarre le jeu
  
  public static void main(String[] args) {
    new Oiram();
  }
}

