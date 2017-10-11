package javagame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JavaGame extends JFrame implements Runnable{
	
	int x,y,xDirection,yDirection;
	private Image dbImage;
	private Graphics dbg;
	Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	Image face;
	
	public void move(){
		x += xDirection;
		y += yDirection;
		if(x <= 0){
			x = 0;
			
		}
		if(x >= 200){
			x = 200;
			
		}
		if(y <= 0){
			y = 0;
			
		}
		if(y >= 200){
			y = 200;
			
		}
	}
	
	public void setXDirection(int xdir){
		xDirection = xdir;
		
	}
	
	public void setYDirection(int ydir){
		yDirection = ydir;
		
	}
	public class AL extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			
			if(keyCode == e.VK_LEFT){
				setXDirection(-1);
				
			}
			if(keyCode == e.VK_RIGHT){
				
				setXDirection(+1);
					
			}
			if(keyCode == e.VK_UP){
				setYDirection(-1);
				
			}
			if(keyCode == e.VK_DOWN){
				setYDirection(+1);
			}
		}

		/*@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyCode = e.getKeyCode();
			
			if(keyCode == e.VK_LEFT){
				if(x <= 0){
					x = 0;
					
				}else{
					x += -5;
					
				}
				
			}
			if(keyCode == e.VK_RIGHT){
				if(x >= 230){
					x = 230;
					
				}else{
					x += +5;
					
				}
				
			}
			if(keyCode == e.VK_UP){
				if(y <= 20){
					y = 20;
					
				}else{
					y += -5;
					
				}

			}
			if(keyCode == e.VK_DOWN){
				if(y >= 230){
					y = 230;
					
				}else{
					y += +5;
					
				}
				
				
			}
		}*/

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
			int keyCode = e.getKeyCode();
			
			if(keyCode == e.VK_LEFT){
				setXDirection(0);
				
			}
			if(keyCode == e.VK_RIGHT){
				
				setXDirection(0);
					
			}
			if(keyCode == e.VK_UP){
				setYDirection(0);
				
			}
			if(keyCode == e.VK_DOWN){
				setYDirection(0);
			}

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		
	}
	
	public JavaGame(){
		// Load images
		ImageIcon i = new ImageIcon(getClass().getResource("/images/gardien.png"));
		face = i.getImage();
		
		// Game properties
		addKeyListener(new AL());
		setTitle("Java Game");
		setResizable(true);
		setVisible(true);
		setSize(250, 250);
		setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x = 150;
		y = 150;
	}
	
	public void paint(Graphics g){
		// Double Buffering, cad on ne voit que le point noir, pas de trace noir
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
		
	}
	
	public void paintComponent(Graphics g){
		g.setFont(font);
		g.setColor(Color.MAGENTA);
		g.drawString("Hello World", 50, 50);
		
		// dans la 2e partie de la vid, il dessine les traces noires laisser par le point noir de départ si c'est paint()
		// dessine ici un point
		//g.setColor(Color.RED);
		//g.fillOval(x, y, 15, 15);
		
		g.drawImage(face, x, y, this);
		repaint();
		
	}
	
	public static void main(String[] args) {
		
		JavaGame frm = new JavaGame();
		Thread t1 = new Thread(frm);
		t1.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(true){
				move();
				Thread.sleep(1);
				
			}
		}catch(Exception e){
			System.out.println("Error");
			
		}
		
		
	}

}
