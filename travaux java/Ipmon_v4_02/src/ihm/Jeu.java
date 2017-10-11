package ihm;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import jeu.Arbre;
import jeu.Attraper;
import jeu.Ipmon;
import jeu.Joueur;
import jeu.ListeIpmons;
import jeu.ListeJoueurs;
import jeu.Soigner;

public class Jeu extends JPanel implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	
	private int nbLigne=(int) (15);
	private int nbColonne=(int) (15);
	private String grille[][] = new String[nbColonne][nbLigne];
		
	private static ArrayList<Arbre> arbres;
	private static ArrayList<Ipmon> ipmons;

	private Joueur joueur = new Joueur();
	private Ipmon ipmon;
	private Arbre arbre;
	private JFrame f;
	JDialog f2 = new JDialog();

	public Jeu(Joueur j, JFrame f){
		this.f = f;
		this.joueur = j;
		setBackground(Color.WHITE);
		f.setSize(nbColonne*35,nbLigne*37);
		f.setResizable(false);
		chargerCarte(joueur);
		f.addKeyListener(this);
		for (int x = 0; x<15; x++){
			for(int y = 0; y<15; y++){
				System.out.print(grille[y][x]);
			}
			System.out.println();
		}
	}
			
	//Dessine les objets instanciés dans la grille
	public void paint(Graphics g){
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
				
		for(int i=0;i < arbres.size();i++){
			arbre = (Arbre) arbres.get(i);
			g2d.drawImage(arbre.getArbre(), arbre.getX(), arbre.getY(), null);	
		}

		g2d.drawImage(joueur.getJoueur(), joueur.getX(), joueur.getY(), null);	
		
		for(int i=0;i < ipmons.size();i++){
			ipmon = (Ipmon) ipmons.get(i);
			g2d.drawImage(ipmon.getIpmon(), ipmon.getX(), ipmon.getY(), null);	
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	//Lit les fichiers et instancie les objets 
	public void chargerCarte(Joueur joueur){
		try{
			arbres = new ArrayList<Arbre>();
			ipmons = new ArrayList<Ipmon>();
			int numeroJoueur=0;
			int caseNb =0;
			
			for (int i=0; i<nbColonne;i++){
				for (int j=0; j<nbLigne; j++){
					if(grille[i][j]== null){
						if (i==0 || i == nbColonne-1 ||j==0 || j == nbLigne-1){
							grille[i][j] = "A";
							arbre = new Arbre(i * 34, j * 34);
							arbres.add(arbre);
						}
						else{
							caseNb = (int) (Math.random() * 7);
							if (caseNb == 0){
								grille[i][j] = "A";
								arbre = new Arbre(i * 34, j * 34);
								arbres.add(arbre);
							}
							else if (caseNb == 1){
								if(numeroJoueur <1){
									numeroJoueur++;
									grille[i][j] = "J-"+numeroJoueur;
									
									joueur.setNumero(numeroJoueur);
									joueur.setPseudo(joueur.getPseudo());
									joueur.setX(i * 34);
									joueur.setY(j * 34);
									System.out.println(joueur.toString());
								}
								else grille[i][j] = " ";
							}
							else if (caseNb == 2){
								if(ipmons.size()<24){
									grille[i][j] = "I";
									ipmon = new Ipmon(i * 34, j * 34);
									ipmons.add(ipmon);
								}
								else grille[i][j] = " ";
							}
							else{
								grille[i][j] = " ";
							}
						}
					}
				}
			}
		}
		catch(Exception ex){}
		repaint();
	}


	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent ke) {
	  int key = ke.getKeyCode();
	  boolean bool = false;
	  boolean bool2 = false;
	  int nb =0;
	  for (int x = 0; x<15; x++){
		  for (int y =0; y<15; y++){
			  if (grille[x][y].equals("J-1") && bool == false){					  
						  switch (key) {				    
						   case  KeyEvent.VK_DOWN :
							   if (grille[joueur.getX()/34][joueur.getY()/34 +1].equals(" ")){
								   joueur.setY(joueur.getY() + 34);
								   grille[joueur.getX()/34][joueur.getY()/34]= "J-"+joueur.getNumero();
								   grille[joueur.getX()/34][joueur.getY()/34 -1]= " ";
								   bool = true;
							   }
							   else if (grille[joueur.getX()/34][joueur.getY()/34 +1].equals("I")){
								   for (int k =0; k<ipmons.size(); k++){
									   if ((joueur.getX() == ipmons.get(k).getX()) && (joueur.getY()+34 == ipmons.get(k).getY()) && bool2 ==false){
										   Attraper a = new Attraper(joueur, ipmons.get(k));
										   if(a.getAttraper()){
											   grille[joueur.getX()/34][joueur.getY()/34 +1]= " ";
											  
										   }
										   bool2 = true;
									   }
								   }
								   bool = true;
							   }
						    break;
						    
						   case KeyEvent.VK_UP:
							   if (grille[joueur.getX()/34][joueur.getY()/34 -1].equals(" ")){
								   joueur.setY(joueur.getY() - 34);
								   grille[joueur.getX()/34][joueur.getY()/34]= "J-"+joueur.getNumero();
								   grille[joueur.getX()/34][joueur.getY()/34 +1]= " ";
								   bool = true;
							   }
							   else if (grille[joueur.getX()/34][joueur.getY()/34 -1].equals("I")){
								   for (int k =0; k<ipmons.size(); k++){
									   if ((joueur.getX() == ipmons.get(k).getX()) && (joueur.getY()-34 == ipmons.get(k).getY()) && bool2 ==false){
										   Attraper a = new Attraper(joueur, ipmons.get(k));
										   if(a.getAttraper()){
											   grille[joueur.getX()/34][joueur.getY()/34 -1]= " ";
										   }
										   bool2 = true;
									   }
								   }
								   bool = true;
							   }
						    break;
						    
						   case KeyEvent.VK_RIGHT:
							   if (grille[joueur.getX()/34 +1][joueur.getY()/34].equals(" ")){
								   joueur.setX(joueur.getX() + 34);
								   grille[joueur.getX()/34][joueur.getY()/34]="J-"+joueur.getNumero() ;
								   grille[joueur.getX()/34-1][joueur.getY()/34]= " ";
								   bool = true;
							   }
							   else if (grille[joueur.getX()/34 +1][joueur.getY()/34].equals("I")){
								   for (int k =0; k<ipmons.size(); k++){
									   if ((joueur.getX()+34 == ipmons.get(k).getX()) && (joueur.getY() == ipmons.get(k).getY()) && bool2 ==false){
										   Attraper a = new Attraper(joueur, ipmons.get(k));
										   if(a.getAttraper()){
											   grille[joueur.getX()/34 +1][joueur.getY()/34]= " ";
										   }
										   bool2 = true;
									   }
								   }
								   bool = true;
							   }
						    break;
						    
						   case KeyEvent.VK_LEFT:
							   if (grille[joueur.getX()/34 -1][joueur.getY()/34].equals(" ")){
								   joueur.setX(joueur.getX() - 34);
								   grille[joueur.getX()/34][joueur.getY()/34]= "J-"+joueur.getNumero();
								   grille[joueur.getX()/34+1][joueur.getY()/34]= " ";
								   bool = true;
							   }
							   else if (grille[joueur.getX()/34 -1][joueur.getY()/34].equals("I")){
								   for (int k =0; k<ipmons.size(); k++){
									   if ((joueur.getX()-34 == ipmons.get(k).getX()) && (joueur.getY() == ipmons.get(k).getY()) && bool2 ==false){
										   Attraper a = new Attraper(joueur, ipmons.get(k));
										   if(a.getAttraper()){
											   grille[joueur.getX()/34 -1][joueur.getY()/34]= " ";
										   }
										   bool2 = true;
									   }
								   }
								   bool = true;
							   }
						    break;
						    
						   case  KeyEvent.VK_C:
						          Soigner s = new Soigner(joueur);            
						         break;
						         
					         case  KeyEvent.VK_H:
					          JLabel liste = new JLabel();
					          f2.setBounds(250, 280, 300, 300);
					          f2.setTitle("Besoin d'aide?");
					          liste.setText("<html>Liste des commandes:<br><br>C: Soigner les ipmons<br>"
					              + "J: Liste des joueurs disponibles<br>"
					              + "R: Relancer une carte<br>"
					              + "X: Accéder à la liste des Ipmons<br>"
					              + "Echap: Quitter la fenêtre<br>"
					              + "Flèches : Se déplacer</html>");
					          f2.add(liste);
					          f2.setLayout(new BorderLayout());
					          f2.add(liste, BorderLayout.NORTH);
					          f2.addKeyListener(this);
					          f2.setResizable(false);
					          f2.setModal(true);
					          f2.setVisible(true);
					         break;
					         
					         case  KeyEvent.VK_J:
					        	 ListeJoueurs lj = new ListeJoueurs(joueur);;            
						     break;  
						         case  KeyEvent.VK_R:
						          if(nb==0){
						           int option = JOptionPane.showConfirmDialog(null, "Voulez-vous recharger la carte ?", "Recharger la carte", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						           if(option == JOptionPane.YES_OPTION){
						            for (int i=0; i<15; i++){
						             for(int j=0; j<15; j++){
						              grille[i][j] = null;
						             }
						            }
						            this.chargerCarte(joueur);
						           }
						        nb++;   
						          }
						         break;
						         
						         case  KeyEvent.VK_X:
						          ListeIpmons l = new ListeIpmons(joueur);            
						         break;
						         
						         case  KeyEvent.VK_ESCAPE:
						          if(f2.isActive()){
						        	 System.out.println(f2.getTitle());
						           f2.dispose();
						          }
						          else{
						           int option2 = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter le jeu ?", "Quitter le jeu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						           if(option2 == JOptionPane.YES_OPTION) f.dispose();
						          }
						          break;
						        }
						        repaint();
			  }
		  }
	  }
	}
}
