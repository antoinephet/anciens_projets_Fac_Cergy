package univ;


import  javax.swing.*;
import  javax.swing.event.*;
import  java.awt.*;
import  java.awt.event.*;
import  java.util.*;
import  java.awt.geom.*;

public class Javaman extends JFrame implements KeyListener {
	
  Container cont;
  
  //direction
  
  int HAUT = 0, BAS = 1, DROITE = 2, GAUCHE = 3;
  int direction = DROITE;
  int score = 0;
  int positionX = 1, positionY = 1;
  
  //tableau à  deux dimensions
  
  String arene[][] =
  {{"#","#","#","#","#","#","#","#","#","#"},
   {"#"," "," "," ","#"," "," "," "," ","#"},
   {"#"," ","#"," ","#"," "," ","#"," ","#"},
   {"#"," ","#"," ","#"," ","#","#"," ","#"},
   {"#"," ","#"," "," "," "," ","#"," ","#"},
   {"#"," ","#","#"," "," "," ","#"," ","#"},
   {"#"," ","#"," "," ","#"," ","#"," ","#"},
   {"#"," ","#"," "," ","#"," ","#"," ","#"},
   {"#"," "," "," "," ","#"," "," "," ","#"},
   {"#","#","#","#","#","#","#","#","#","#"}};
  
  //icônes
  
  JLabel javaMan = new JLabel(new ImageIcon("javaman.png"));
  JLabel ennemis[ ] = {new JLabel(new ImageIcon("monstre.png")),new JLabel(new ImageIcon
          ("monstre.png")),new JLabel(new ImageIcon("monstre.png"))};
  
  int pastillesrestantes = 44;
  
  // le constructeur
  
  public Javaman() {
    super("JavaMan");
    setSize(500,500);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cont = getContentPane();
    cont.setLayout(null);
    addKeyListener(this);
    cont.setBackground(Color.BLACK);
    
    //ajoute Javaman
    
    cont.add(javaMan);
    javaMan.setBounds(50,50,50,50);
    
    //ajoute le plateau
    
    for(int i = 0; i < arene.length; i++) {
      for(int j = 0; j < arene[0].length; j++) {
        JLabel lbl = null;
        if(arene[i][j].equals("#")) {
          lbl = new JLabel(new ImageIcon("mur.png"));
        } else {
          
          lbl = new JLabel(new ImageIcon("pastille.png"));
        }
        
        cont.add(lbl);
        lbl.setBounds(i*50,j*50,50,50);
        System.out.println("X: "+i*50+" â€” Y: "+j*50);
      }
    }
    
    //position des ennemis
    
    cont.add(ennemis[0]);
    ennemis[0].setBounds(400,50,50,50);
    cont.setComponentZOrder(ennemis[0],1);
    cont.add(ennemis[1]);
    ennemis[1].setBounds(50,400,50,50);
    cont.setComponentZOrder(ennemis[1],1);
    cont.add(ennemis[2]);
    ennemis[2].setBounds(400,400,50,50);
    cont.setComponentZOrder(ennemis[2],1);
    repaint();
    cont.validate();
    Jeu jeu = new Jeu();
    jeu.start();
    setContentPane(cont);
  }
  
  
  public class Jeu extends Thread {
    public void run() {
      while(true) {
        try {
        	
          //cherche une victoire de Javaman
        	
          if(pastillesrestantes<=0) {
        	  
            JOptionPane.showMessageDialog(null,"Gagné !");
          }
          
          //boucle de mouvement des ennemis
          
          int dir[] = new int[3];
          for(int i = 0; i < dir.length; i++) {
            dir[i] = (int)(Math.random()*4);
            if(dir[i]==HAUT) {
              ennemis[i].setBounds(ennemis[i].getX(),ennemis[i].getY()-50,50,50);
              if(arene[ennemis[i].getX()/50]
                      [ennemis[i].getY()/50].equals("#")) {
                ennemis[i].setBounds(ennemis[i].getX(),ennemis[i].getY()+50,50,50);
              }
            }
            if(dir[i]==BAS) {
              ennemis[i].setBounds(ennemis[i].getX(),ennemis[i].getY()+50,50,50);
              if(arene[ennemis[i].getX()/50]
                      [ennemis[i].getY()/50].equals("#")) {
                ennemis[i].setBounds(ennemis[i].getX(),ennemis[i].getY()-50,50,50);
              }
            }
            if(dir[i]==GAUCHE) {
              ennemis[i].setBounds(ennemis[i].getX()-50,ennemis[i].getY(),50,50);
              if(arene[ennemis[i].getX()/50]
                      [ennemis[i].getY()/50].equals("#")) {
                ennemis[i].setBounds(ennemis[i].getX()+50,ennemis[i].getY(),50,50);
              }
            }
            if(dir[i]==DROITE) {
              ennemis[i].setBounds(ennemis[i].getX()+50,ennemis[i].getY(),50,50);
              if(arene[ennemis[i].getX()/50][ennemis[i].getY()/50].equals("#")) {
                ennemis[i].setBounds(ennemis[i].getX()-50,ennemis[i].getY(),50,50);
              }
            }
            
            //perdu !
            
            if(ennemis[i].getX()/50==positionX && ennemis[i].getY()/50==positionY) {
              JOptionPane.showMessageDialog(null,"Perdu !");
            }
            cont.setComponentZOrder(ennemis[i],1);
          }
          
          //supprime le cercle
          
          if(arene[positionX][positionY].equals(" ")) {
            arene[positionX][positionY] = ".";
            pastillesrestantes--;
            JLabel lbl = new JLabel(new ImageIcon("chemin.png"));
            cont.add(lbl);
            lbl.setBounds(positionX*50,positionY*50,50,50);
            cont.setComponentZOrder(lbl,1);
            score++;
          }
          
          //déplace Javaman
          
          if(direction == DROITE) {
            javaMan.setBounds(javaMan.getX()+50,javaMan.getY(),50,50);
            positionX++;
            if(arene[positionX][positionY].equals("#")) {
              javaMan.setBounds(javaMan.getX()-50,javaMan.getY(),50,50);
              positionX--;
            }
            cont.setComponentZOrder(javaMan,1);
          }
          if(direction == GAUCHE) {
            javaMan.setBounds(javaMan.getX()-50,javaMan.getY(),50,50);
            positionX--;
            if(arene[positionX][positionY].equals("#")) {
              javaMan.setBounds(javaMan.getX()+50,javaMan.getY(),50,50);
              positionX++;
            }
            cont.setComponentZOrder(javaMan,1);
          }
          if(direction == HAUT) {
            javaMan.setBounds(javaMan.getX(),javaMan.getY()-50,50,50);
            positionY--;
            if(arene[positionX][positionY].equals("#")) {
              javaMan.setBounds(javaMan.getX(),javaMan.getY()+50,50,50);
              positionY++;
            }
            cont.setComponentZOrder(javaMan,1);
          }
          if(direction == BAS) {
            javaMan.setBounds(javaMan.getX(),javaMan.getY()+50,50,50);
            positionY++;
            if(arene[positionX][positionY].equals("#")) {
              javaMan.setBounds(javaMan.getX(),javaMan.getY()-50,50,50);
              positionY--;
            }
            cont.setComponentZOrder(javaMan,1);
          }
          cont.validate();
          Thread.sleep(500);
        } catch(Exception e){ }
      }
    }
  }
  
  public void keyTyped(KeyEvent e) {
    if(e.getKeyChar()=='z')
      direction = HAUT;
    if(e.getKeyChar()=='q')
      direction = GAUCHE;
    if(e.getKeyChar()=='s')
      direction = BAS;
    if(e.getKeyChar()=='d')
      direction = DROITE;
  }
  
  public void keyPressed(KeyEvent e){ }
  
  public void keyReleased(KeyEvent e){ }
  
  // démarre le jeu
  
  public static void main(String[] args) {
    new Javaman();
  }
}

