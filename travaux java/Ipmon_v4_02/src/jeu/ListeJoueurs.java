package jeu;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ListeJoueurs extends JDialog implements KeyListener, ActionListener{

		private JDialog f = new JDialog();
		private Choice c = new Choice();
		private Container cont;
		private JButton ok = new JButton("Ok");
		private Joueur joueur;
		private Joueur adversaire;
		
		public ListeJoueurs(Joueur j){
			this.joueur = j;
			f.setBounds(250, 280, 280, 100);
			f.setTitle("Liste des joueurs connectés");
			
			/*for (int k =0; k<j.listeJoueurs().size(); k++){
				if(!j.listeJoueurs().get(k).toString().equals(j.toString())){
			       c.addItem(j.listeJoueurs().get(k).toString());  
				}
			}*/
			
			f.add(c);
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

		@Override
		public void keyPressed(KeyEvent ke) {
			  int key = ke.getKeyCode();
			  switch (key) {				    
			   case  KeyEvent.VK_ESCAPE :
				  f.dispose();
				  break;
			  }
		}

		@Override
		public void keyReleased(KeyEvent arg0) {}

		@Override
		public void keyTyped(KeyEvent arg0) {}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == ok){
				f.dispose();
				/*for (int k =0; k<joueur.listeJoueurs().size(); k++){
					if (c.getSelectedItem().equals(joueur.listeJoueurs().get(k).toString()))
						adversaire = joueur.listeJoueurs().get(k);
				}*/
				EchangeCombat c = new EchangeCombat(joueur);
				}
		}
		
}
