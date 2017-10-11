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
  
  //tableau � deux dimensions
  
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
  
  //contient les �toiles
  
  ArrayList etoiles = new ArrayList();
  
  //Oiram
  
  JLabel personnage = new JLabel(new ImageIcon("oiram.png"));
  
  //Oiram est-il en train de sauter ou d'escalader ?
  
  boolean saut = false;
  boolean escalade = false;
  
  //fil d'ex�cution
  
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
    
    //cr�e les �toiles et les ennemis
    
    genereEtoiles();
    genereEnnemis();
    
    //g�n�re le tableau
    
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
    
    //d�marre le fil d'ex�cution
    
    jeu = new Jeu();
    jeu.start();
    setContentPane(cont);
  }
  public void genereEtoiles() {
	  
    //boucle dans le tableau � deux dimensions
	  
    for(int i = 1; i < arene.length; i++) {
      for(int j = 0; j < arene[0].length; j++) {
        if(arene[i][j].equals(" ")) {
        	
          //probabilit� de placer une �toile : 1/10
        	
          int placeEtoile = (int)(Math.random()*10);
          if(placeEtoile==0) {
        	  
            //ajoute l'�toile
        	  
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
        	
          //v�rifie ce qui suit sur tous les ennemis
        	
          for(int i = 0; i < ennemis.size(); i++) {
            JLabel ennemi = (JLabel) ennemis.get(i);
            
            //n'applique ce qui suit qu'aux ennemis sur l'�cran
            
            if(ennemi.getY()<=450 && ennemi.getX()<=450) {
            	
              //descent l'ennemi, si possible
            	
              if(arene[(ennemi.getY()/50)+1][ennemi.getX()/50].equals(" ")) {
                ennemi.setBounds(ennemi.getX(),ennemi.getY()+50,50,50);
              }
              
              //d�place l'ennemi vers la droite ou la gauche
              
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
              
              //si un ennemi mange Oiram, affiche l'image de d�faite
              
              if(ennemi.getY()==personnage.getY() && ennemi.getX()==personnage.getX()) {
                cont.remove(personnage);
              }
            }
          }
          
          //v�rifie ce qui suit sur toutes les �toiles
          
          for(int i = 0; i < etoiles.size(); i++) {
            JLabel star = (JLabel) etoiles.get(i);
            
            //si Oiram capture une �toile, on la supprime
            
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
	  
    //d�placement vers la gaucuhe
	  
    if(e.getKeyChar()=='q') {
    	
      //si Oiram escalade, on arr�te l'escalade
    	
      if(escalade) {
        escalade = false;
        personnage.setIcon(new ImageIcon("oiram.png"));
      }
      
      //d�placement vers la gauche s'il est possible
      
      if(personnage.getX()>=50 && arene[personnage.getY()/50][(personnage.getX()/50)-
              1].equals(" ")) {
        personnage.setBounds(personnage.getX()-50,personnage.getY(),50,50);
      }
    }
    
    //d�placement vers la droite
    
    if(e.getKeyChar()=='d') {
    	
      //ne pas permettre à Oiram de sortir de l'�cran
    	
      if(personnage.getX()<=400 &&
              arene[personnage.getY()/50][(personnage.getX()/50)+1].equals(" ")) {
        personnage.setBounds(personnage.getX()+50,personnage.getY(),50,50);
      }
      
      //si Oiram touche une �chelle, commencer � escalader
      
      if(arene[personnage.getY()/50][(personnage.getX()/50)+1].equals("|")) {
        personnage.setBounds(personnage.getX()+50,personnage.getY(),50,50);
        escalade = true;
        personnage.setIcon(new ImageIcon("surechelle.png"));
      }
    }
    
    //saute/escalade
    
    if(e.getKeyChar()=='z') {
    	
      //si Oiram n'est pas sur une �chelle, saute
    	
      if(!escalade) {
        if(arene[(personnage.getY()/50)-1][personnage.getX()/50].equals(" ")) {
          if(!saut && !arene[(personnage.getY()/50)+1][personnage.getX()/50].equals(" ")) {
            saut = true;
            personnage.setBounds(personnage.getX(),personnage.getY()-50,50,50);
          }
        }
      }
      
      //d�place Oiram sur l'�chelle
      
      else {
        personnage.setBounds(personnage.getX(), personnage.getY()-50,50,50);
        
        //Oiram arrive en haut de l'�chelle. Modifie son ic�ne et le d�place
        
        if(arene[personnage.getY()/50][personnage.getX()/50].equals(" ")) {
          personnage.setBounds(personnage.getX()+50,personnage.getY(),50,50);
          escalade = false;
          personnage.setIcon(new ImageIcon("oiram.png"));
        }
      }
    }
  }
  
  // d�marre le jeu
  
  public static void main(String[ ] args) {
    new Oiram();
  }
}

