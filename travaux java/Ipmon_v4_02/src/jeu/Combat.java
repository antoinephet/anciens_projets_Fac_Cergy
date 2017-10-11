package jeu;

import java.awt.Choice;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Combat extends JDialog implements KeyListener, ActionListener{
	private JDialog f = new JDialog();
	boolean gagne = false;
	private JButton ok = new JButton("Ok");
	private Joueur joueur;
	private Ipmon ipmon;
	private Ipmon ipmonJoueur;
	
	private Container cont;
	private Choice c = new Choice();
	
	private JLabel label = new JLabel();
	JDialog f2 = new JDialog();
	
	public Combat(Joueur j, Ipmon i){
		this.joueur = new Joueur();
		this.joueur = j;
		this.ipmon = new Ipmon();
		this.ipmon = i;
		
		f.setBounds(250, 280, 430, 180);
		f.setTitle(joueur.getPseudo() +" combattez " + ipmon.getNom() + " !");
		if (joueur.listeIpmons().size()>1){
			if (joueur.listeIpmons().size()==6){
				int option = JOptionPane.showConfirmDialog(null, "Vous possédez déjà 6 Ipmons, vous ne pourrez pas le capturer, continuer ?", "Attention", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(option == JOptionPane.YES_OPTION){
					f.setTitle("Sélectionnez Ipmon");
					
					for (int k =0; k<joueur.listeIpmons().size(); k++){ 
				       c.addItem(joueur.listeIpmons().get(k).toString());  
					}
					f.add(c);
					
					f.setBounds(250, 280, 280, 100);
					f.setTitle(j.getPseudo() +" attrapez " + ipmon.getNom() + " !");
				    cont = getContentPane();
				    cont.setLayout(new GridLayout(1,1));
				    cont.setLayout(null);
				    cont.setSize(200,200);
				    
				    ok.setSize(50, 20);
				    ok.setLocation(185, 30);
				    cont.add(ok);
				    f.add(cont);
				    ok.addActionListener(this);
		
					f.setResizable(false);
					f.setModal(true);
					f.setVisible(true);
				}
			}
			else{
				f.setTitle("Sélectionnez Ipmon");
				
				for (int k =0; k<joueur.listeIpmons().size(); k++){ 
			       c.addItem(joueur.listeIpmons().get(k).toString());  
				}
				f.add(c);
				
				f.setBounds(250, 280, 280, 100);
				f.setTitle(j.getPseudo() +" attrapez " + ipmon.getNom() + " !");
			    cont = getContentPane();
			    cont.setLayout(new GridLayout(1,1));
			    cont.setLayout(null);
			    cont.setSize(200,200);
			    
			    ok.setSize(50, 20);
			    ok.setLocation(185, 30);
			    cont.add(ok);
			    f.add(cont);
			    ok.addActionListener(this);
	
				f.setResizable(false);
				f.setModal(true);
				f.setVisible(true);
			}
		}
		else{
			f.dispose();
			ipmonJoueur = joueur.listeIpmons().get(0);
			combattre(ipmonJoueur);
		}
		
	}
	public void combattre(Ipmon i){
		
		if (ipmonJoueur.getVie() >0) {
			f2.setTitle("Combat lancé !");
			f2.setBounds(250, 280, 430, 180);
			boolean mort = false;
			int rand = (int) (Math.random() * 2);
			label.setText("<html>");
			
			
			while (mort == false){
				if (rand ==0){ // L'ipmon adverse commence le combat
					if(ipmon.getVie()>0){
						label.setText(label.getText() +"L'ipmon adverse " + ipmon.getNom() + " a fait " + ipmon.getForce() + " dégâts.<br>");
						ipmonJoueur.setVie(ipmonJoueur.getVie() - ipmon.getForce());
					}
					if(ipmonJoueur.getVie()>0){
						label.setText(label.getText() +"Votre ipmon " + ipmonJoueur.getNom() + " a fait " + ipmonJoueur.getForce() + " dégâts.<br>");
						ipmon.setVie(ipmon.getVie() - ipmonJoueur.getForce());
					}
					if(ipmon.getVie()<0) ipmon.setVie(0);
					if(ipmonJoueur.getVie()<0) ipmonJoueur.setVie(0);
					label.setText(label.getText() +"Vie de l'ipmon adverse " + ipmon.getVie() + " - Vie de votre Ipmon " + ipmonJoueur.getVie() + "<br>");
				}
				else{
					if(ipmonJoueur.getVie()>0){
						label.setText(label.getText() +"Votre ipmon " + ipmonJoueur.getNom() + " a fait " + ipmonJoueur.getForce() + " dégâts.<br>");
						ipmon.setVie(ipmon.getVie() - ipmonJoueur.getForce());
					}
					if(ipmon.getVie()>0){
						label.setText(label.getText() +"L'ipmon adverse " + ipmon.getNom() + " a fait " + ipmon.getForce() + " dégâts.<br>");
						ipmonJoueur.setVie(ipmonJoueur.getVie() - ipmon.getForce());
					}
					if(ipmon.getVie()<0) ipmon.setVie(0);
					if(ipmonJoueur.getVie()<0) ipmonJoueur.setVie(0);
					label.setText(label.getText() +"Vie de l'ipmon adverse " + ipmon.getVie() + " - Vie de votre Ipmon " + ipmonJoueur.getVie() + "<br>");
				}
				if(ipmon.getVie()<=0){
					label.setText(label.getText() + "Bravo, vous avez gagné!");
					ipmon.setVie(0);
					mort = true;
					gagne = true;
				}
				else if(ipmonJoueur.getVie()<=0){
					label.setText(label.getText() + "Aïe, vous avez perdu!");
					mort = true;
					ipmonJoueur.setVie(0);
				}
			}
			label.setText(label.getText() + "</html>");
			JScrollPane j = new JScrollPane (label);
			f2.add(j);
			f2.addKeyListener(this);
			f2.setResizable(false);
			f2.setModal(true);
			f2.setVisible(true);
		}
		else JOptionPane.showMessageDialog (null, "Veuillez soigner votre Ipmon ou en choisir un autre !" , joueur.pseudo, JOptionPane.WARNING_MESSAGE);
	}
	
	public boolean aGagne(){
		return gagne;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok){
			f.dispose();
			for (int k =0; k<joueur.listeIpmons().size(); k++){
				if (c.getSelectedItem().equals(joueur.listeIpmons().get(k).toString()))
					ipmonJoueur = joueur.listeIpmons().get(k);
			}
			combattre(ipmonJoueur);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		int key = ke.getKeyCode();
		switch (key) {				    
		case  KeyEvent.VK_ESCAPE :
			f2.dispose();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
}
