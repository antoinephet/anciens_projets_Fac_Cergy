package boxe;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

//classe avec un JFrame et un ActionListener

public class MorpionBoxeur extends JFrame implements ActionListener {
	
    //tableau de boutons. Nous utilisons un tableau et non un ArrayList car
    //le nombre de boutons est constant.
	
    JButton boutons[] = new JButton[9];
    
    //garde trace des tours : les tours pairs sont ceux du joueur 1, les tours
    //impairs ceux du joueur 2. On les diff�rencie avec l'op�rateur modulo (%)
    //we will use mod (%) to differentiate the values:
    
    int tour = 1;
    
    //images pour repr�senter les camps
    
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
        
        //contiendra les boutons
        
        Container cont = getContentPane();
        
        //indique la disposition des boutons
        
        cont.setLayout(null);
        cont.add(titre);
        titre.setBounds(0, 0, 350, 288);
        int nouvelleLigne = 0;
        int compteurLigne = 0;
        for (int i = 0; i < boutons.length; i++) {
        	
            //initialisation avec une image vide
        	
            boutons[i] = new JButton(blanc);
            
            //regarde s'il faut cr�er une ligne
            
            if (i == 3 || i == 6) {
                nouvelleLigne++;
                compteurLigne = 0;
            }
            //d�finit la position du bouton
            
            boutons[i].setBounds(15 + (compteurLigne * 100), 288 + (nouvelleLigne * 100), 100, 100);
            
            //ajoute le bouton au conteneur
            
            cont.add(boutons[i]);
            
            //ajoute l'ActionListener
            
            boutons[i].addActionListener(this);
            compteurLigne++;
        }
        
        //rafra�chit l'�cran
        
        cont.repaint();
    }
    
//m�thode obligatoire
    
    public void actionPerformed(ActionEvent e) {
    	
        //regarde sur quel bouton on a appuy�
    	
        for (int i = 0; i < boutons.length; i++) {
            if (e.getSource() == boutons[i]) {
            	
                //le bouton passe � X
            	
                boutons[i].setIcon(rouge);
                
                //d�sactive le bouton pour qu'il ne puisse pas �tre rejou�
                
                boutons[i].removeActionListener(this);
            }
        }
        tour++;
        
        //avant de laisser l'ordinateur jouer, regarde si quelqu'un a gagn�
        
        verifieVictoire();
        
        //l'ordinateur joue
        
        ia();
    }

    public void verifieVictoire() {
    	
        //on commence par trois it�rations pour chercher des victoires
        //en vertical ou en horizontal sans �crire trop de code
    	
        for (int i = 0; i < 3; i++) {
        	
            //cherche une victoire X en vertical
        	
            if (boutons[i].getIcon().equals(rouge) &&
                    boutons[i + 3].getIcon().equals(rouge) &&
                    boutons[i + 6].getIcon().equals(rouge)) {
                JOptionPane.showMessageDialog(null, "Vous avez gagn� !");
                return;
            }
            
            //cherche une vitoire O en vertical
            
            if (boutons[i].getIcon().equals(bleu) &&
                    boutons[i + 3].getIcon().equals(bleu) &&
                    boutons[i + 6].getIcon().equals(bleu)) {
                JOptionPane.showMessageDialog(null, "Vous avez perdu !");
                return;
            }
            
            //cherche une victoire X en horizontal
            
            if (boutons[i * 3].getIcon().equals(rouge) &&
                    boutons[(i * 3) + 1].getIcon().equals(rouge) &&
                    boutons[(i * 3) + 2].getIcon().equals(rouge)) {
                JOptionPane.showMessageDialog(null, "Vous avez gagné !");
                return;
            }
            
            //cherche une victoire O en horizontal
            
            if (boutons[i * 3].getIcon().equals(bleu) &&
                    boutons[(i * 3) + 1].getIcon().equals(bleu) &&
                    boutons[(i * 3) + 2].getIcon().equals(bleu)) {
                JOptionPane.showMessageDialog(null, "Vous avez perdu !");
                return;
            }
        }
        
        //cette boucle cherche les victoires en diagonal
        
        for (int i = 0; i <= 2; i += 2) {
        	
            //cherche une victoire X en diagonal
        	
            if (boutons[i].getIcon().equals(rouge) &&
                    boutons[4].getIcon().equals(rouge) &&
                    boutons[8 - i].getIcon().equals(rouge)) {
                JOptionPane.showMessageDialog(null, "Vous avez gagné !");
                return;
            }
            
            //cherche un victoire O en diagonal
            
            if (boutons[i].getIcon().equals(bleu) &&
                    boutons[4].getIcon().equals(bleu) &&
                    boutons[8 - i].getIcon().equals(bleu)) {
                JOptionPane.showMessageDialog(null, "Vous avez perdu !");
                return;
            }
        }
    }

    public void ia() {
        boolean mouvementFait;
        
        //si c'est le premier tour de l'ordinateur, essaie de prendre la case en
        //haut � gauche. Si elle est d�j� prise, prend la case du milieu.
        
        if (tour == 2) {
            //si la case en haut � gauche est prise, prend celle du milieu
            if (boutons[0].getIcon().equals(rouge)) {
                boutons[4].setIcon(bleu);
                boutons[4].removeActionListener(this);
                mouvementFait = true;
            } //sinon, prend celle en haut � gauche
            else {
                boutons[0].setIcon(bleu);
                boutons[0].removeActionListener(this);
                mouvementFait = true;
            }
        } //si ce n'est pas le premier tour, cherche les lignes o� deux cases sont prises
        //s'il n'en existe pas, prend la première case disponible
        else {
        	
            //appel de la méthode pour v�rifier deux cases de la couleur pass�e en argument
            //la m�thode prend alors la case
        	
            mouvementFait = deuxAlignes(bleu);
            
            //si l'ordinateur n'a pas trouv� de case offensive, trouve une case d�fensive
            
            if (!mouvementFait) {
                mouvementFait = deuxAlignes(rouge);
                
                //s'il n'y a pas de mouvement d�fensif à faire, prend la premi�re case
                //qu'il trouve
                
                if (!mouvementFait) {
                	
                    //trouve la premi�re case disponible
                	
                    for (int i = 0; i < boutons.length; i++) {
                    	
                        //si elle est vide, prendre la case
                    	
                        if (boutons[i].getIcon().equals(blanc)) {
                            boutons[i].setIcon(bleu);
                            boutons[i].removeActionListener(this);
                            mouvementFait = true;
                            break;
                        }
                    }
                }
            }
        }
        tour++;
        System.out.println(tour);
        verifieVictoire();
        if (!mouvementFait) {
        	
            //si aucune case n'a �t� prise, match nul
        	
            JOptionPane.showMessageDialog(null, "Match nul !!!");
        }
    }

    public boolean deuxAlignes(Icon a) {
        for (int i = 0; i < 3; i++) {
        	
            //cherche les colonnes avec deux �l�ments identiques en haut
        	
            if (boutons[i].getIcon().equals(a) &&
                    boutons[i + 3].getIcon().equals(a) &&
                    boutons[i + 6].getIcon().equals(blanc)) {
                boutons[i + 6].setIcon(bleu);
                boutons[i + 6].removeActionListener(this);
                return true;
            }
            
            //cherche les colonnes du type "un �l�ment, un trou, un �l�ment"
            
            if (boutons[i].getIcon().equals(a) &&
                    boutons[i + 6].getIcon().equals(a) &&
                    boutons[i + 3].getIcon().equals(blanc)) {
                boutons[i + 3].setIcon(bleu);
                boutons[i + 3].removeActionListener(this);
                return true;
            }
            
            //cherche les colonnes avec deux �l�ments identiques en bas
            
            if (boutons[i + 6].getIcon().equals(a) &&
                    boutons[i + 3].getIcon().equals(a) &&
                    boutons[i].getIcon().equals(blanc)) {
                boutons[i].setIcon(bleu);
                boutons[i].removeActionListener(this);
                return true;
            }
            
            //cherche les lignes avec deux �l�ments identiques � gauche
            
            if (boutons[i * 3].getIcon().equals(a) &&
                    boutons[(i * 3) + 1].getIcon().equals(a) &&
                    boutons[(i * 3) + 2].getIcon().equals(blanc)) {
                boutons[(i * 3) + 2].setIcon(bleu);
                boutons[(i * 3) + 2].removeActionListener(this);
                return true;
            }
            
            //cherche les lignes du type "un �l�ment, un trou, un �l�ment"
            
            if (boutons[i * 3].getIcon().equals(a) &&
                    boutons[(i * 3) + 2].getIcon().equals(a) &&
                    boutons[(i * 3) + 1].getIcon().equals(blanc)) {
                boutons[(i * 3) + 1].setIcon(bleu);
                boutons[(i * 3) + 1].removeActionListener(this);
                return true;
            }
            
            //cherche les lignes avec deux �l�ments identiques à droite
            
            if (boutons[(i * 3) + 2].getIcon().equals(a) &&
                    boutons[(i * 3) + 1].getIcon().equals(a) &&
                    boutons[i * 3].getIcon().equals(blanc)) {
                boutons[i * 3].setIcon(bleu);
                boutons[i * 3].removeActionListener(this);
                return true;
            }
            
            //cherche les diagonales avec deux �l�ments identiques contigus
            
            for (int j = 0; j <= 2; j += 2) {
                if (boutons[j].getIcon() == a &&
                        boutons[4].getIcon() == a &&
                        boutons[8 - j].getIcon().equals(blanc)) {
                    boutons[8 - j].setIcon(bleu);
                    boutons[8 - j].removeActionListener(this);
                    return true;
                }
                
                //cherche les diagonales du type "un �l�ment, un trou, un �l�ment"
                
                if (boutons[j].getIcon() == a &&
                        boutons[8 - j].getIcon() == a &&
                        boutons[4].getIcon().equals(blanc)) {
                    boutons[4].setIcon(bleu);
                    boutons[4].removeActionListener(this);
                    return true;
                }
                if (boutons[8 - j].getIcon() == a &&
                        boutons[4].getIcon() == a &&
                        boutons[j].getIcon().equals(blanc)) {
                    boutons[j].setIcon(bleu);
                    boutons[j].removeActionListener(this);
                    return true;
                }
            }
        }
        return false;
    }
    
    //m�thode de d�marrage
    
    public static void main(String[] args) {
        MorpionBoxeur mp = new MorpionBoxeur();
    }
}
