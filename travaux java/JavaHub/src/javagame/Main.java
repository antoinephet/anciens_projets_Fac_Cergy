package javagame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	int gWIDTH = 400;
	int gHEIGHT = 300;
	int x,y;
	private Image dbImage;
	private Graphics dbg;
	boolean mouseOnScreen;
	
	public Main(){
		
		setSize(400,300);
		setTitle("Game");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(new Mouse());
        x = 15;
        y = 15;
		
	}
	public class Mouse extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseOnScreen = true;
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseOnScreen = false;
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			int xCoord = e.getX();
			int yCoord = e.getY();
			x = xCoord-7;
			y = yCoord-7;
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			// TODO Auto-generated method stub
			
			
		}
		
		
	}
	
	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
		
	}
	
	public void paintComponent(Graphics g){
		g.fillOval(x, y, 15, 15);
		g.setColor(Color.RED);
		if(mouseOnScreen){
			g.drawString("Coord : ("+x+", "+y+")", 150, 150);
			
		}
		
		repaint();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		

	}

}
