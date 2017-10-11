package univ;


import  javax.swing.*;
import  javax.swing.event.*;
import  java.awt.*;
import  java.awt.event.*;
import  java.util.*;
import  java.awt.geom.*;


public class Javaman extends JFrame implements KeyListener
{
	
Container cont;
int HAUT = 0, BAS = 1, DROITE = 2, GAUCHE = 3;
int direction = DROITE;
int positionX = 1, positionY = 1;

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
  
  JLabel javaMan = new JLabel(new ImageIcon("javaman.png"));
  
  // le constructeur
  
  public Javaman()
  {
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
    for(int i = 0; i < arene.length; i++)
    {
      for(int j = 0; j < arene[0].length; j++)
      {
        JLabel lbl = null;
        if(arene[i][j].equals("#"))
        {
          lbl = new JLabel(new ImageIcon("mur.png"));
        }
        else
        {
          lbl = new JLabel(new ImageIcon("pastille.png"));
        }
        cont.add(lbl);
        lbl.setBounds(i*50,j*50,50,50);
        System.out.println("X : "+i*50+" -- Y : "+j*50);
      }
    }
    
    repaint();
    cont.validate();
  Jeu jeu = new Jeu();
  jeu.start();
  setContentPane(cont);
}
  
public class Jeu extends Thread
{
  public void run()
  {
    while(true)
    {
      try
      {
        if(direction == DROITE)
        {
          javaMan.setBounds(javaMan.getX()+50,javaMan.getY(),50,50);
          positionX++;
          if(arene[positionX][positionY].equals("#"))
          {
            javaMan.setBounds(javaMan.getX()-50,javaMan.getY(),50,50);
            positionX--;
          }
          cont.setComponentZOrder(javaMan,1);
        }
        if(direction == GAUCHE)
        {
          javaMan.setBounds(javaMan.getX()-50,javaMan.getY(),50,50);
          positionX--;
          if(arene[positionX][positionY].equals("#"))
          {
            javaMan.setBounds(javaMan.getX()+50,javaMan.getY(),50,50);
            positionX++;
          }
          cont.setComponentZOrder(javaMan,1);
        }
        if(direction == HAUT)
        {
        javaMan.setBounds(javaMan.getX(),javaMan.getY()-50,50,50);
          positionY--;
          if(arene[positionX][positionY].equals("#"))
          {
            javaMan.setBounds(javaMan.getX(),javaMan.getY()+50,50,50);
            positionY++;
          }
          cont.setComponentZOrder(javaMan,1);
        }
        if(direction == BAS)
        {
          javaMan.setBounds(javaMan.getX(),javaMan.getY()+50,50,50);
          positionY++;
          if(arene[positionX][positionY].equals("#"))
          {
            javaMan.setBounds(javaMan.getX(),javaMan.getY()-50,50,50);
            positionY--;
          }
          cont.setComponentZOrder(javaMan,1);
        }
        cont.validate();
        Thread.sleep(500);
      }
      catch(Exception e){ }
      }
    }
  }


  public void keyTyped(KeyEvent e)
  {
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
  
  public static void main (String[] args)
  {
    new Javaman();
  }
}
