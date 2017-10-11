package bcbroz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

public class Keying extends JPanel {
	

	private static final long serialVersionUID = 1L;
	public Rectangle character;
	public Rectangle bottomBox;
	
	public int charW = 24;
	public int charH = 36;
	public boolean left = false;
	public boolean right = false;
	
	public boolean mouseActive = false;
	
	public Point mouse;
	
	public Keying(Display f,Images i){
		
		character = new Rectangle(180,180,charW,charH);
		bottomBox = new Rectangle(0,350,9000,30);
		
		f.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					
					mouseActive = false;
					right = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					
					mouseActive = false;
					left = true;
					
				} // active le mode souris
				if(e.getKeyCode() == KeyEvent.VK_M){
					
					mouseActive = true;
					
				}
				
			}
			
			public void keyReleased(KeyEvent e){
				
				if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					
					right = false;
					
					
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					
					left = false;
					
				}
				
			}
		});
		
		f.addMouseMotionListener(new MouseMotionAdapter() {
			
			public void mouseMoved(MouseEvent e){
				// creation du point de la souris et ses coordonnes
				mouse = new Point(e.getX(),e.getY() - 25);
				// le mouvement de la souris + pas sur de la moitie de la parenthese
				if(mouseActive && character.x !=Main.w - charW){
					
					character.x = mouse.x;
					character.y = mouse.y;
					
				}
				
				repaint();
			}
		});
		
		f.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				mouse = new Point(e.getX(),e.getY() - 25);
				
				if(e.getButton() == MouseEvent.BUTTON1 && !mouseActive){
					
					character.x = mouse.x;
					character.y = mouse.y;
					
				}
				
			}
		});
		
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		// le perso reste sur la ligne blanche
		Point pt1 = new Point(character.x, character.y + character.height);
		if(!bottomBox.contains(pt1) && !mouseActive){
			character.y++;
		}
		
		this.setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		g.fillRect(character.x, character.y, character.width, character.height);
		g.fillRect(bottomBox.x, bottomBox.y, bottomBox.width, bottomBox.height);
		
		// le perso s'arrete à un point précis, ne va pas jusqu'au bout
		if(right && character.x !=Main.w - charW){
			
			character.x += 1;
		}
		// le perso ne peut pas reculer en négatif
		if(left && character.x !=0){
			
			character.x -= 1;
		}
		
		repaint();
		
		
	}

}
