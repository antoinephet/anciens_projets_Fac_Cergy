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
	

	public Jeu(){
		// si false on peut utiliser les touches sinon false
		setFocusable(true);
		
		gamelooptimer = new Timer(10,this);
		gamelooptimer.start();
		
		c = new Controller();
		
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		c.draw(g2d);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("RUNNING GAME LOOP");
		repaint();
		
		c.update();
	
		
		
		
	}
	
	
	

}
