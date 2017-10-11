package univ;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;

public class Javaman extends JFrame
{
  Container cont;
  
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
  
  // le constructeur
  
  public Javaman()
  {
    super("Javaman");
    setSize(500,500);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cont = getContentPane();
    cont.setLayout(null);
    cont.setBackground(Color.BLACK);
    
    //crée le plateau
    
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
      }
    }
    repaint();
    cont.validate();
    setContentPane(cont);
  }
  
  // démarre le jeu
  
  public static void main (String[] args)
  {
    new Javaman();
  }
}
