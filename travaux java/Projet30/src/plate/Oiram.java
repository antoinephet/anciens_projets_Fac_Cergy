package plate;


import  javax.swing.*;
import  javax.swing.event.*;
import  java.awt.*;
import  java.awt.event.*;
import  java.util.*;
import  java.awt.geom.*;
public class Oiram extends JFrame {
	
  Container cont;
  
  //le tableau à  deux dimensions
  
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
  
  
  public Oiram() {
	  
    super("Oiram");
    setSize(500,500);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cont = getContentPane();
    cont.setLayout(null);
    cont.setBackground(Color.BLACK);
    
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
    setContentPane(cont);
  }
  
  public static void main(String[ ] args) {
    new Oiram();
  }
}

