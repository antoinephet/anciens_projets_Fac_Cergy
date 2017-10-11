package boxe;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

//classe avec un JFrame et un ActionListener

public class MorpionBoxeur extends JFrame implements ActionListener {
	
    //tableau de boutons. On utilise un tableau et non un arrayList
    //car le nombre de boutons est constant.
	
    JButton boutons[] = new JButton[9];
    
    //garde le d√©compte des tours. le joueur 1 est pair, le joueur 2 impair
    //on utilise le modulo (%) pour diff√©rencier les valeurs
    
    int tour = 1;
    
    //repr√©sentent les adversaires
    
    ImageIcon rouge = new ImageIcon("rouge.png");
    ImageIcon bleu = new ImageIcon("bleu.png");
    ImageIcon blanc = new ImageIcon("blanc.png");
    
    //image de titre
    
    JLabel titre = new JLabel(new ImageIcon("titre.png"));
    
    //constructeur
    
    public MorpionBoxeur() {
        super("Morpion Boxeur");
        setSize(350, 625);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //contient les boutons
        
        Container cont = getContentPane();
        
        //disposition des boutons
        
        cont.setLayout(null);
        cont.add(titre);
        titre.setBounds(0, 0, 350, 288);
        int nouvelleLigne = 0;
        int compteurLigne = 0;
        for (int i = 0; i < boutons.length; i++) {
        	
            //initialisation avec une image vide
        	
            boutons[i] = new JButton(blanc);
            
            //faut-il utiliser une nouvelle ligne ?
            
            if (i == 3 || i == 6) {
                nouvelleLigne++;
                compteurLigne = 0;
            }
            
            //position du bouton
            
            boutons[i].setBounds(15 + (compteurLigne * 100), 288 + (nouvelleLigne * 100), 100, 100);
            
            //ajout du bouton au conteneur
            
            cont.add(boutons[i]);
            
            //ajoute l'ActionListener
            
            boutons[i].addActionListener(this);
            compteurLigne++;
        }
        
        //rafraÓchit l'Ècran
        
        cont.repaint();
    }
    
    //mÈthode obligatoire
    
    public void actionPerformed(ActionEvent e) {
    	
        //surveille les clics sur les boutons
    	
        for (int i = 0; i < boutons.length; i++) {
            if (e.getSource() == boutons[i]) {
            	
                //calcule de quel joueur c'est le tour
            	
                if (tour % 2 == 0) {
                	
                    //si le tour est pair, c'est le tour du joueur 1 (X)
                	
                    boutons[i].setIcon(rouge);
                } else {
                	
                    //si le tour est impair, c'est le tour du joueur 2 (0)
                	
                    boutons[i].setIcon(bleu);
                }
                
                //dÈsactive le bouton pour qu'on ne puisse plus re-cliquer dessus
                
                boutons[i].removeActionListener(this);
            }
        }
        tour++;
        
        //avant que l'autre joueur ne joue, on regarde si quelqu'un a gagnÈ
        
        verifieVictoire();
    }

    public void verifieVictoire() {
    	
        //trois itÈrations de la boucle pour vÈrifier les victoires horizontales
        //et verticale avec peu de code
    	
        for (int i = 0; i < 3; i++) {
        	
            //cherche une victoire X en vertical
        	
            if (boutons[i].getIcon().equals(rouge) &&
                    boutons[i + 3].getIcon().equals(rouge) &&
                    boutons[i + 6].getIcon().equals(rouge)) {
                JOptionPane.showMessageDialog(null, "X gagne");
                
            //cherche une victoire O en vertical
                
            }
            if (boutons[i].getIcon().equals(bleu) &&
                    boutons[i + 3].getIcon().equals(bleu) &&
                    boutons[i + 6].getIcon().equals(bleu)) {
                JOptionPane.showMessageDialog(null, "O gagne");
                
            //cherche une victoire X en horizontal
                
            }
            if (boutons[i * 3].getIcon().equals(rouge) &&
                    boutons[(i * 3) + 1].getIcon().equals(rouge) &&
                    boutons[(i * 3) + 2].getIcon().equals(rouge)) {
                JOptionPane.showMessageDialog(null, "X gagne");
                
            //cherche une victoire O en horizontal
                
            }
            if (boutons[i * 3].getIcon().equals(bleu) &&
                    boutons[(i * 3) + 1].getIcon().equals(bleu) &&
                    boutons[(i * 3) + 2].getIcon().equals(bleu)) {
                JOptionPane.showMessageDialog(null, "O gagne");
            }
        }
        
        //cette boucle cherche les victoires en diagonal
        
        for (int i = 0; i <= 2; i += 2) {
        	
            //cherche une victoire X en diagonal
        	
            if (boutons[i].getIcon().equals(rouge) &&
                    boutons[4].getIcon().equals(rouge) &&
                    boutons[8 - i].getIcon().equals(rouge)) {
                JOptionPane.showMessageDialog(null, "X gagne");
                
            //cherche une victoire 0 en diagonal
            }
            if (boutons[i].getIcon().equals(bleu) &&
                    boutons[4].getIcon().equals(bleu) &&
                    boutons[8 - i].getIcon().equals(bleu)) {
                JOptionPane.showMessageDialog(null, "O gagne");
            }
        }
    }
    
    //mÈthode de dÈmarrage (main)
    
    public static void main(String[] args) {
        MorpionBoxeur mp = new MorpionBoxeur();
    }
}
