package plate;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;

public class Oiram extends JFrame implements KeyListener {
	
  //conteneur
	
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
  
  ArrayList etoiles = new ArrayList();
  
  //Oiram
  
  JLabel personnage = new JLabel(new ImageIcon("oiram.png"));
  
  //Oiram est-il en train de sauter ou d'escalader ?
  
  boolean saut = false;
  boolean escalade = false;
  
  //fil d'exécution
  
  Jeu jeu;
  
  //contient les ennemis
  
  ArrayList ennemis = new ArrayList();
  
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
    
    //ajoute Oiram
    
    cont.add(personnage);
    personnage.setBounds(0,400,50,50);
    
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
        	
          //probabilité de placer une étoile : 1/10
        	
          int placeEtoile = (int)(Math.random()*10);
          if(placeEtoile==0) {
        	  
            //ajoute l'étoile
        	  
            JLabel etoile = new JLabel(new ImageIcon("etoile.png"));
            cont.add(etoile);
            etoile.setBounds(j*50,i*50,50,50);
            cont.setComponentZOrder(etoile,0);
            cont.setComponentZOrder(personnage,0);
            etoiles.add(etoile);
            
          }
        }
      }
    }
  }
  
  
  public void genereEnnemis() {
	  
    //ajoute les ennemis
	  
    for(int i = 0; i < 2; i++) {
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
        	
          //vérifie ce qui suit sur tous les ennemis
        	
          for(int i = 0; i < ennemis.size(); i++) {
            JLabel ennemi = (JLabel) ennemis.get(i);
            
            //n'applique ce qui suit qu'aux ennemis sur l'écran
            
            if(ennemi.getY()<=450 && ennemi.getX()<=450) {
            	
              //descent l'ennemi, si possible
            	
              if(arene[(ennemi.getY()/50)+1][ennemi.getX()/50].equals(" ")) {
                ennemi.setBounds(ennemi.getX(),ennemi.getY()+50,50,50);
              }
              
              //déplace l'ennemi vers la droite ou la gauche
              
              int direction = (int)(Math.random()*2);
              if(direction==0) {
                if(arene[ennemi.getY()/50][(ennemi.getX()/50)+1].equals(" ")) {
                  ennemi.setBounds(ennemi.getX()+50,ennemi.getY(),50,50);
                }
              } else {
                if(arene[ennemi.getY()/50][(ennemi.getX()/50)-1].equals(" ")) {
                  ennemi.setBounds(ennemi.getX()-50,ennemi.getY(),50,50);
                }
              }
              
              //si Oiram saute sur un ennemi, supprime l'ennemi
              
              if(ennemi.getY()-50==personnage.getY() && ennemi.getX()==personnage.getX()) {
                ennemi.setBounds(1000,1000,50,50);
                cont.remove(ennemi);
              }
              
              //si un ennemi mange Oiram, affiche l'image de défaite
              
              if(ennemi.getY()==personnage.getY() && ennemi.getX()==personnage.getX()) {
                cont.remove(personnage);
              }
            }
          }
          
          //vérifie ce qui suit sur toutes les étoiles
          
          for(int i = 0; i < etoiles.size(); i++) {
            JLabel star = (JLabel) etoiles.get(i);
            
            //si Oiram capture une étoile, on la supprime
            
            if(star.getBounds().intersects(personnage.getBounds())) {
              cont.remove(star);
              etoiles.remove(star);
            }
          }
          
          //Oiram tombe
          
          if(!saut) {
            if(arene[(personnage.getY()/50)+1][personnage.getX()/50].equals(" ")) {
              personnage.setBounds(personnage.getX(),personnage.getY()+50,50,50);
            }
          }
          
          //Oiram saute
          
          else {
            saut = false;
            if(arene[(personnage.getY()/50)-1][personnage.getX()/50] .equals(" ")) {
              personnage.setBounds(personnage.getX(),personnage.getY()-50,50,50);
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
	  
    //déplacement vers la gaucuhe
	  
    if(e.getKeyChar()=='q') {
    	
      //si Oiram escalade, on arrête l'escalade
    	
      if(escalade) {
        escalade = false;
        personnage.setIcon(new ImageIcon("oiram.png"));
      }
      
      //déplacement vers la gauche s'il est possible
      
      if(personnage.getX()>=50 && arene[personnage.getY()/50][(personnage.getX()/50)-
              1].equals(" ")) {
        personnage.setBounds(personnage.getX()-50,personnage.getY(),50,50);
      }
    }
    
    //déplacement vers la droite
    
    if(e.getKeyChar()=='d') {
    	
      //ne pas permettre Ã  Oiram de sortir de l'écran
    	
      if(personnage.getX()<=400 &&
              arene[personnage.getY()/50][(personnage.getX()/50)+1].equals(" ")) {
        personnage.setBounds(personnage.getX()+50,personnage.getY(),50,50);
      }
      
      //si Oiram touche une échelle, commencer à  escalader
      
      if(arene[personnage.getY()/50][(personnage.getX()/50)+1].equals("|")) {
        personnage.setBounds(personnage.getX()+50,personnage.getY(),50,50);
        escalade = true;
        personnage.setIcon(new ImageIcon("surechelle.png"));
      }
    }
    
    //saute/escalade
    
    if(e.getKeyChar()=='z') {
    	
      //si Oiram n'est pas sur une échelle, saute
    	
      if(!escalade) {
        if(arene[(personnage.getY()/50)-1][personnage.getX()/50].equals(" ")) {
          if(!saut && !arene[(personnage.getY()/50)+1][personnage.getX()/50].equals(" ")) {
            saut = true;
            personnage.setBounds(personnage.getX(),personnage.getY()-50,50,50);
          }
        }
      }
      
      //déplace Oiram sur l'échelle
      
      else {
        personnage.setBounds(personnage.getX(), personnage.getY()-50,50,50);
        
        //Oiram arrive en haut de l'échelle. Modifie son icône et le déplace
        
        if(arene[personnage.getY()/50][personnage.getX()/50].equals(" ")) {
          personnage.setBounds(personnage.getX()+50,personnage.getY(),50,50);
          escalade = false;
          personnage.setIcon(new ImageIcon("oiram.png"));
        }
      }
    }
  }
  
  // démarre le jeu
  
  public static void main(String[ ] args) {
    new Oiram();
  }
}

