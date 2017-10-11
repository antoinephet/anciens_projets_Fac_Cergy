package genie;



import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChasseAuxGenies extends JFrame {
	
    //ce tableau contient les 25 JButton
	
    JButton[][] boutons = new JButton[5][5];
    
    //icone affichée lorsque le mauvais génie sort de son laboratoire
    
    ImageIcon vivant = new ImageIcon("vivant.gif");
    
    //JLabel du score
    
    JLabel score = new JLabel("SCORE : ");
    
    //constructeur
    
    public ChasseAuxGenies() {
    	
        //crée le JFrame
    	
        super("Chasse aux mauvais génies");
        setSize(350, 325);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //contient les boutons et libellés
        
        Container cont = getContentPane();
        cont.setLayout(new FlowLayout());
        
        //prépare l'affichage des boutons
        
        for (int i = 0; i < boutons.length; i++) {
            for (int j = 0; j < boutons[0].length; j++) {
            	
                //crée le JButton
            	
                System.out.println(vivant);
                boutons[i][j] = new JButton(vivant);
                
                //ajoute le bouton au JFrame
                
                cont.add(boutons[i][j]);
                
                //désactive le bouton
                
                boutons[i][j].setEnabled(false);
            }
        }
        
        //affichage du score
        
        score.setText("SCORE : ");
        cont.add(score);
        setContentPane(cont);
    }

    public static void main(String[] args) {
    	
        //démarre le jeu
    	
        new ChasseAuxGenies();
    }
}