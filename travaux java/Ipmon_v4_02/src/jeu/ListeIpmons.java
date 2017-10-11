package jeu;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ListeIpmons extends JDialog implements KeyListener{
	private JDialog f = new JDialog();
	private JLabel liste = new JLabel();
	
	public ListeIpmons(Joueur j){
		f.setBounds(250, 280, 300, 300);
		f.setTitle("Liste des Impons de " + j.getPseudo());
		
		if(j.listeIpmons().isEmpty()){
			liste.setText("Aucun Ipmon");
		}
		else{
			liste.setText("<html>");
			for (int i =0; i<j.listeIpmons().size(); i++){
				liste.setText(liste.getText() + "<br>" + j.listeIpmons().get(i));
			}
			liste.setText(liste.getText() + "</html>");
		}

		f.add(liste);
		f.setLayout(new BorderLayout());
		f.add(liste, BorderLayout.NORTH);
		f.addKeyListener(this);
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
}
