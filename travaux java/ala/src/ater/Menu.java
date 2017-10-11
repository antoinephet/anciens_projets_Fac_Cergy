package ater;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener{
	
	private Container cont;
	private JButton cmdGame = new JButton("Commencez");
	private JButton cmdQuitter = new JButton("Quitter");
	private Color titleColor;
	private Font titleFont;

	
	public Menu(){
		
		initLayout();
		initActions();
		cont.setBackground(Color.WHITE);
		titleColor = new Color(128,0,0);
		titleFont = new Font("Century Gothic",Font.PLAIN,30);
		
		
	}
	
	private void initLayout() {
		
		setTitle("Menu Principal");
		setSize(514, 536);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		setLocationRelativeTo(null);
		
		// mise en place du conteneur principal
	    
	    cont = getContentPane();
	    cont.setLayout(null);
		
	    
	    // ajout des composants
	    
	    cont.add(cmdGame);
		cont.add(cmdQuitter);
		
		
		cmdGame.setBounds(150, 230, 200, 50);
	    cont.setComponentZOrder(cmdGame,0);
	    
	    cmdQuitter.setBounds(150, 330, 200, 50);
	    cont.setComponentZOrder(cmdQuitter,0);
		
	}
	
	private void initActions() {
		
		cmdGame.addActionListener(this);
		cmdQuitter.addActionListener(this);
	}
	
	public void paint(Graphics g){
		
		// modification taille des images
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Le Gardien de parc", 125, 160);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getSource() == cmdGame){
			dispose();
			Ihm frm = new Ihm();
			
			
		} else if(arg0.getSource() == cmdQuitter){
			dispose();
			
		}
		
	}
	

}
