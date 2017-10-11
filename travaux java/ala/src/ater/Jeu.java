package ater;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Jeu extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	Timer gamelooptimer;
	
	Controller c;
	Grille g1;
	

	public Jeu(){
		// si false on peut utiliser les touches sinon false
		setFocusable(true);
		
		gamelooptimer = new Timer(10,this);
		gamelooptimer.start();
		
		//c = new Controller();
		g1 = new Grille(1100, 720);
		
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g1.draw(g2d);
		//c.draw(g2d);
				
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("RUNNING GAME LOOP");
		repaint();
		
		//c.update();
		g1.update();
		
	
		
		
		
	}
	
	
	

}
