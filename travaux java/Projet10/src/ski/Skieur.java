package ski;

//importe ce qu'il faut

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

//la classe

public class Skieur extends JFrame implements MouseListener {
	
  //enregistre les lignes
	
  ArrayList lignes = new ArrayList();
  
  //enregistre le premier point de la ligne
  
  Point2D.Double point;
  
  //constructeur
  
  public Skieur() {
	  
      //titre
	  
      super("Le Skieur");
      setSize(1000, 1000);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      addMouseListener(this);
  }

  public void paint(Graphics g) {
	  
      super.paint(g);
      
      //les lignes sont dessin�es en noir
      
      g.setColor(Color.black);
      
      //parcourt l'ArrayList et dessine toutes les lignes
      
      for (int i = 0; i < lignes.size(); i++) {
    	  
          //r�cup�re la ligne
    	  
          Line2D.Double temp = (Line2D.Double) lignes.get(i);
          
          //r�cup�re les coordonn�es
          
          int x1 = Integer.parseInt("" + Math.round(temp.getX1()));
          int y1 = Integer.parseInt("" + Math.round(temp.getY1()));
          int x2 = Integer.parseInt("" + Math.round(temp.getX2()));
          int y2 = Integer.parseInt("" + Math.round(temp.getY2()));
          g.drawLine(x1, y1, x2, y2);
      }
  }
  
  //m�thode n�cessaire � MouseListener
  
  public void mouseClicked(MouseEvent e) {
  }
  
  //m�thode n�cessaire � MouseListener
  
  public void mouseEntered(MouseEvent e) {
  }
  
  //m�thode n�cessaire � MouseListener
  
  public void mouseExited(MouseEvent e) {
  }
  
  //m�thode n�cessaire � MouseListener
  
  public void mousePressed(MouseEvent e) {
	  
      //ex�cut� lorsqu'on appuie sur le bouton de la souris
      //r�cup�re le premier point de la ligne
	  
      point = new Point2D.Double(e.getX(), e.getY());
  }
  
  //m�thode n�cessaire � MouseListener
  
  public void mouseReleased(MouseEvent e) {
	  
      //ex�cut� lorsqu'on rel�che le bouton de la souris
      //termine la ligne et l'ajoute à l'ArrayList
	  
      Point2D.Double fin = new Point2D.Double(e.getX(), e.getY());
      lignes.add(new Line2D.Double(point, fin));
      
      //rafra�chit l'�cran pour dessiner la ligne
      
      repaint();
  }

  public static void main(String[] args) {
	  
      //lance le programme
	  
      new Skieur();
  }
}
