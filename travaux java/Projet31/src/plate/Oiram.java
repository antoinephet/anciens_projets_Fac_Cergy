package plate;


import  javax.swing.*;
import  javax.swing.event.*;
import  java.awt.*;
import  java.awt.event.*;
import  java.util.*;
import  java.awt.geom.*;
public class Oiram extends JFrame implements KeyListener {
  Container cont;
  
  //tableau à  deux dimensions
  
  String arene[ ][ ] =
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
  
  ArrayList etoiles = new ArrayList();
  JLabel personnage = new JLabel(new ImageIcon("oiram.png"));
  boolean saut = false;
  boolean escalade = false;
  Jeu jeu;
  
  public Oiram() {
	  
    super("Oiram");
    setSize(500,500);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cont = getContentPane();
    cont.setLayout(null);
    addKeyListener(this);
    cont.setBackground(Color.BLACK);
    cont.add(personnage);
    personnage.setBounds(0,400,50,50);
    genereEtoiles();
    
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
    jeu = new Jeu();
    jeu.start();
    setContentPane(cont);
    
  }
  
//ajoute les étoiles
  
  public void genereEtoiles() {
    for(int i = 1; i < arene.length; i++) {
      for(int j = 0; j < arene[0].length; j++) {
    	  
        //regarde si l'emplacement est de l'air
    	  
        if(arene[i][j].equals(" ")) {
        	
          //une chance sur 10 qu'une étoile apparaisse
        	
          int placeEtoile = (int)(Math.random()*10);
          if(placeEtoile==0) {
        	  
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
  
  public class Jeu extends Thread {
    public void run() {
      while(true) {
        try {
        	
          //si Oiram touche une étoile, on l'enlève
        	
          for(int i = 0; i < etoiles.size(); i++) {
            JLabel star = (JLabel) etoiles.get(i);
            if(star.getBounds().intersects(personnage.getBounds())) {
              cont.remove(star);
              etoiles.remove(star);
            }
          }
          
          //fait tomber Oiram
          
          if(!saut) {
            if(arene[(personnage.getY()/50)+1][personnage.getX()/50].equals(" ")) {
              personnage.setBounds(personnage.getX(),personnage.getY()+50,50,50);
            }
          } else {
        	  
            //termine le saut d'Oiram à  l'itération suivante
        	  
            saut = false;
            
            //fait bouger Oiram vers le haut
            
            if(arene[(personnage.getY()/50)-1][personnage.getX()/50].equals(" ")) {
              personnage.setBounds(personnage.getX(),personnage.getY()-50,50,50);
            }
          }
          Thread.sleep(250);
        } catch(Exception e){ }
      }
    }
  }
  public void keyPressed(KeyEvent e){ }
  public void keyReleased(KeyEvent e){ }
  public void keyTyped(KeyEvent e) {
	  
    //déplacement à  gauche
	  
    if(e.getKeyChar()=='q') {
      if(escalade) {
        escalade = false;
        personnage.setIcon(new ImageIcon("oiram.png"));
      }
      if(personnage.getX()>=50 &&
              arene[personnage.getY()/50][(personnage.getX()/50)-1].equals(" ")) {
        personnage.setBounds(personnage.getX()-50,personnage.getY(),50,50);
      }
    }
    
    //déplacement à  droite
    
    if(e.getKeyChar()=='d') {
      if(personnage.getX()<=400 && arene
              [personnage.getY()/50][(personnage.getX()/50)+1].equals(" ")) {
        personnage.setBounds(personnage.getX()+50,personnage.getY(),50,50);
      }
      if(arene[personnage.getY()/50][(personnage.getX()/50)+1].equals("|")) {
        personnage.setBounds(personnage.getX()+50,personnage.getY(),50,50);
        escalade = true;
        personnage.setIcon(new ImageIcon("surechelle.png"));
      }
    }
    
    //déplacement vers le haut
    
    if(e.getKeyChar()=='z') {
      if(!escalade) {
        if(arene[(personnage.getY()/50)-1][personnage.getX()/50].equals(" ")) {
          if(!saut && !arene[(personnage.getY()/50)+1][personnage.getX()/50].equals(" ")) {
            saut = true;
            personnage.setBounds(personnage.getX(),personnage.getY()-50,50,50);
          }
        }
      } else {
        personnage.setBounds(personnage.getX(), personnage.getY()-50,50,50);
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

