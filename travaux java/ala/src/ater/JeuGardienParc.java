package ater;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class JeuGardienParc extends JPanel implements ActionListener, KeyListener{
	
	private Timer gamelooptimer;
	private Grille g1;
	private Gardien p;
	
	
	
	public JeuGardienParc() {
		requestFocus();
		setFocusable(true);
		setBackground(Color.WHITE);
		gamelooptimer = new Timer(10,this);
		gamelooptimer.start();
		g1 = new Grille(1122, 714);
		p = new Gardien(300, 400);
		addKeyListener(new KeyInput(p));
		
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g1.draw(g2d);
		p.draw(g2d);
		//c.draw(g2d);
				
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("RUNNING GAME LOOP");
		
		
		//c.update();
		g1.update();
		p.update();
		repaint();
		
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}
