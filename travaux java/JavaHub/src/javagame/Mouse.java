package javagame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Mouse extends JFrame implements MouseMotionListener {
	
	private Image dbImage;
	private Graphics dbg;
	int mx,my;
	boolean mouseDragged;

	public Mouse(){
		
		setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        addMouseMotionListener(this);
		
	}
	
	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
		
	}
	
	public void paintComponent(Graphics g){
		if(mouseDragged){
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 0, getWidth(), getWidth());
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(mx, my, 20, 20);
		}else{
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, getWidth(), getWidth());
			g.setColor(Color.DARK_GRAY);
			g.fillRect(mx, my, 20, 20);
			
		}
		repaint();
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mouse mouse = new Mouse();

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mx = e.getX() - 10;
		my = e.getY() - 10;
		mouseDragged = true;
		e.consume();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mx = e.getX();
		my = e.getY();
		mouseDragged = false;
		e.consume();
		
	}

}
