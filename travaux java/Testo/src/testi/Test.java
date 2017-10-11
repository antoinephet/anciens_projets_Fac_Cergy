package testi;


import  javax.swing.*;
import  javax.swing.event.*;
import  java.awt.*;
import  java.awt.event.*;
import  java.util.*;
import  java.awt.geom.*;

public class Test extends JFrame {
	
	Container cont;
	
	int i = 10,j = 10;
	int grille [][] = new int[i][j];
	
	//temps restant avant la détonation
	
	/*int tempsRestant = 12;
	  
	//JLabel affichant le temps restant
	  
	JLabel temps = new JLabel("tempsRestant : "+tempsRestant);*/
	
	
	
	
	public Test() {
		  
	    super("Oiram");
	    
		
	    for(i= 0;i<grille.length;i++){
			for(j =0;j<grille.length;j++){
				grille [i][j] = (int)(Math.round(Math.random()*1));
				
			}
		}

	    setSize(500,500);
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    cont = getContentPane();
	    cont.setLayout(null);
	    cont.setBackground(Color.BLACK);
	    
	    //génère le tableau
	    
	   for(int i = 0; i < grille.length; i++) {
	      for(int j = 0; j < grille[0].length; j++) {
	        JLabel lbl = null;
	        if(grille[j][i] == 0) {
	          lbl = new JLabel(new ImageIcon("brique.png"));
	        } else if(grille[j][i] == 1) {
	          lbl = new JLabel(new ImageIcon("air.png"));
	        /*} else if(grille[j][i] == 2) {
	          lbl = new JLabel(new ImageIcon("echelle.png"));*/
	        }
	        
	        cont.add(lbl);
	        lbl.setBounds(i*50,j*50,50,50);
	      }
	    }
	    repaint();
	    cont.validate();
	    setContentPane(cont);
	    
	    
	    /*temps.setFont(new Font("Courier", Font.BOLD, 20));*/
	    
	    //ajoute le JLabel de temps restant
	    
	    /*cont.add(temps);*/
	    
	    //définit la position
	    
	    /*temps.setBounds(250,371,150,18);*/
	    
	    //place le JLabel au-dessus du fond
	    
	    /*cont.setComponentZOrder(temps,0);
	    
	    Compteur compteur = new Compteur();
	    compteur.start();*/
	  }
	
	/*public class Compteur extends Thread {
	    public void run() {
	      while(true) {
	        try {
	          tempsRestant--;
	          temps.setText(tempsRestant+"");
	          Thread.sleep(1000);
	        } catch(Exception e){ }
	      }
	    }
	  }*/

	

	public static void main(String[] args) {
		
		
		new Test();
		
		/*System.out.println();
		for(i = 0;i<grille.length;i++){
			for(j = 0;j<grille.length;j++){
				
				System.out.print(grille [i][j]);
				
			}
			System.out.println()

		}
		

	};*/
	}
}
