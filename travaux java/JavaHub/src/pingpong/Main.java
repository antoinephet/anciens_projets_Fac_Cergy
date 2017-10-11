package pingpong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	//Double buffering
    Image dbImage;
    Graphics dbg;
    
    //Ball objects
    static Ball b = new Ball(193, 143);
    
    // partie 14
    Thread ball = new Thread(b);
    Thread p1 = new Thread(b.p1);
    Thread p2 = new Thread(b.p2);
    
    boolean gameStarted = false;
    boolean startHover;
    boolean quitHover;
    
    //Menu Buttons
    Rectangle startButton = new Rectangle(150, 100, 100, 25);
    Rectangle quitButton = new Rectangle(150, 150, 100, 25);
    
    //Variables for screen size
    int
    GWIDTH = 400,
    GHEIGHT = 300;
    //Dimension of GWIDTH*GHEIGHT
    Dimension screenSize = new Dimension(GWIDTH, GHEIGHT);
    
    //Create constructor to spawn window
    public Main(){
        this.setTitle("Pong Game");
        this.setSize(screenSize);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.DARK_GRAY);
        this.addKeyListener(new AL());
        
        // partie menus
        this.addMouseListener(new MouseHandler());
        this.addMouseMotionListener(new MouseHandler());
    }
    
    public void startGame(){
    	gameStarted = true;
    	ball.start();
    	p1.start();
    	p2.start();
    }
    
    public static void main(String[] args){
        Main m = new Main();
        //Create and start threads
        Thread ball = new Thread(b);
        ball.start();
        Thread p1 = new Thread(b.p1);
        Thread p2 = new Thread(b.p2);
        p1.start();
        p2.start();
    }
    
    @Override
    public void paint(Graphics g){
    	
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        draw(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    public void draw(Graphics g){
    	
    	//Menu
    	if(!gameStarted){
	        g.setFont(new Font("Arial", Font.BOLD, 26));
	        g.setColor(Color.WHITE);
	        g.drawString("Pong Game!", 125, 75);
	        if(!startHover){
	        	g.setColor(Color.CYAN);
	        }else{
	        	g.setColor(Color.PINK);
	        	
	        }
	        g.fillRect(startButton.x, startButton.y, startButton.width, startButton.height);
	        g.setFont(new Font("Arial", Font.BOLD, 12));
	        g.setColor(Color.GRAY);
	        g.drawString("Start Game", startButton.x+20, startButton.y+17);
	        if(!quitHover){
	        	g.setColor(Color.CYAN);
	        	
	        }else{
	        	g.setColor(Color.PINK);
	        	
	        }
	        
	        g.fillRect(quitButton.x, quitButton.y, quitButton.width, quitButton.height);
	        g.setColor(Color.GRAY);
	        g.drawString("Quit Game", quitButton.x+20, quitButton.y+17);
    	}
    	
    	else{
	        //Game drawings
	        b.draw(g);
	        b.p1.draw(g);
	        b.p2.draw(g);
	        
	        //Scores
	        g.setColor(Color.WHITE);
	        g.drawString(""+b.p1Score, 15, 50);
	        g.drawString(""+b.p2Score, 370, 50);
    	}
        repaint();
    }
    
    ////////EVENT LISTENER CLASS/////////
    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            b.p1.keyPressed(e);
            b.p2.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e){
            b.p1.keyReleased(e);
            b.p2.keyReleased(e);
        }
    }
    
    
    public class MouseHandler extends MouseAdapter {
    	
        @Override
        public void mouseMoved(MouseEvent e){
        	int mx = e.getX();
        	int my = e.getY();
        	if(mx > startButton.x && mx < startButton.x + startButton.width && my > 
        	startButton.y && my < startButton.y+startButton.height){
        		startHover = true;
        	}else{
        		startHover = false;
        	}
        	if(mx > quitButton.x && mx < quitButton.x + quitButton.width && my > 
        	quitButton.y && my < quitButton.y+quitButton.height){
        		quitHover = true;
        	}else{
        		quitHover = false;
        	}
            
        }
        
        @Override
        public void mousePressed(MouseEvent e){
        	int mx = e.getX();
        	int my = e.getY();
        	if(mx > startButton.x && mx < startButton.x + startButton.width && my > 
        	startButton.y && my < startButton.y+startButton.height){
        		startGame();
        	}
        	
        	if(mx > quitButton.x && mx < quitButton.x + quitButton.width && my > 
        	quitButton.y && my < quitButton.y+quitButton.height){
        		dispose();
        	}
            
        }
    }
    ///////END EVENT LISTENER CLASS/////

}
