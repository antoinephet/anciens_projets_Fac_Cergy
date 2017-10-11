package jeu;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Soigner extends JDialog implements KeyListener{
	private JDialog f = new JDialog();
	private JLabel liste = new JLabel();
	
	public Soigner(Joueur j){
		f.setBounds(250, 280, 300, 300);
		f.setTitle("Soins des ipmons de " + j.getPseudo());
		
		if(j.listeIpmons().isEmpty()){
			liste.setText("Aucun Ipmon à soigner");
		}
		else{
			boolean ok = false;
			liste.setText("<html> Soins effectués pour:<br><br>");
			for (int i =0; i<j.listeIpmons().size(); i++){
				if(j.listeIpmons().get(i).getVie()< j.listeIpmons().get(i).getVieBase()){
					liste.setText(liste.getText()+ j.listeIpmons().get(i).toString() + " - " + (j.listeIpmons().get(i).getVieBase() - j.listeIpmons().get(i).getVie()) +" points soignés<br>");
					j.listeIpmons().get(i).setVie(j.listeIpmons().get(i).getVieBase());
					ok = true;
				}	
			}
			if (ok == false)	liste.setText("<html>Aucun Ipmon à soigner</html>");
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
