package jeu;

import java.awt.Color;
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

@SuppressWarnings("serial")
public class Attraper extends JDialog implements KeyListener, ActionListener{
	private JDialog f = new JDialog();
	
	private Container cont;
	
	private JButton manger = new JButton("Donner à manger");
	private JButton grimace = new JButton("Faire une grimace");
	private JButton calin = new JButton("Faire un câlin");
	
	private JLabel label = new JLabel("Tente ta chance");
	
	private boolean ok = false;
	private Joueur joueur;
	private Ipmon ipmon;
	
	public Attraper(Joueur j, Ipmon i){
		this.joueur = new Joueur();
		this.joueur = j;
		this.ipmon = new Ipmon();
		this.ipmon = i;
		
		if (j.getNombreIpmon() == 0){
			f.setBounds(250, 280, 430, 180);
			f.setTitle(j.getPseudo() +" attrapez " + ipmon.getNom() + " !");
		    cont = getContentPane();
		    cont.setLayout(new GridLayout(1,1));
		    cont.setLayout(null);
		    cont.setSize(200,200);
		    
		    label.setSize(135, 20);
		    label.setLocation(160, 30);
		    
			manger.setSize(135, 20);
			manger.setLocation(10, 80);
			

			grimace.setSize(140, 20);
			grimace.setLocation(145, 80);
			

			calin.setSize(135, 20);
			calin.setLocation(285, 80);
		    

		    cont.add(label);
		    cont.add(manger);
			cont.add(grimace);
			cont.add(calin);
		    f.add(cont);
		    manger.addActionListener(this);
		    grimace.addActionListener(this);
		    calin.addActionListener(this);

			f.addKeyListener(this);
			f.setResizable(false);
			f.setModal(true);
			f.setVisible(true);
		}
		else{
			/* Problème ici */
			f.setBounds(250, 280, 430, 180);
			f.setTitle(j.getPseudo() +" TRUC combattez " + ipmon.getNom() + " !");
			f.dispose();
			Combat c = new Combat(j, i);
			if(c.aGagne()){
				ok = true;
				joueur.ajoutIpmon(ipmon);
				ipmon.isCapture();
			}
		}
	}
	   
	public boolean getAttraper(){
		return ok;
	}
	
	public void setAttraper(boolean ok){
		this.ok= ok;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == manger){
			if (ipmon.getPreference().equals("Manger")){
				JOptionPane.showMessageDialog(null,"Bravo, vous avez capturé " + ipmon.getNom(), "Belle capture!", JOptionPane.INFORMATION_MESSAGE);
				ok = true;
				f.dispose();
				joueur.ajoutIpmon(ipmon);
				ipmon.isCapture();
			}
			else{
				label.setText("Essaye encore!");
			}
		}
		else if(arg0.getSource() == grimace){
			if (ipmon.getPreference().equals("Grimace")){
				JOptionPane.showMessageDialog(null,"Bravo, vous avez capturé " + ipmon.getNom(), "Belle capture!", JOptionPane.INFORMATION_MESSAGE);
				ok = true;
				f.dispose();
				joueur.ajoutIpmon(ipmon);
				ipmon.isCapture();
			}
			else{
				label.setText("Essaye encore!");
			}
		}
		else if (arg0.getSource() == calin){
			if (ipmon.getPreference().equals("Câlin")){
				JOptionPane.showMessageDialog(null,"Bravo, vous avez capturé " + ipmon.getNom(), "Belle capture!", JOptionPane.INFORMATION_MESSAGE);
				ok = true;
				f.dispose();
				joueur.ajoutIpmon(ipmon);
				ipmon.isCapture();
			}
			else{
				label.setText("Essaye encore!");
			}
		}
	}
	   
	@Override
	public void keyPressed(KeyEvent ke) {
		int key = ke.getKeyCode();
		switch (key) {				    
		case  KeyEvent.VK_ESCAPE :
			int option = JOptionPane.showConfirmDialog(null, "Voulez-vous abandonner ?", "Abandonner", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.YES_OPTION) f.dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}
}
