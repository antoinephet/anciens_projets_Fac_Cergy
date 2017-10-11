package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;



public class Game extends Canvas implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public static String TITLE = "2D Space Game";
	
	private boolean running = false;
	private Thread thread;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	private BufferedImage background = null;
	
	private boolean isShooting = false;
	
	private Player p;
	private Controller c;
	private Textures tex;
	
	//temp
	//private BufferedImage player;
	
	public void init(){
		requestFocus();
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			spriteSheet = loader.loadImage("/gardien.png");
			background = loader.loadImage("/background1.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//SpriteSheet ss = new SpriteSheet(spriteSheet);
		//player = ss.gradImage(1, 1, 32, 32);
		
		addKeyListener(new KeyInput(this));
		tex = new Textures(this);
		p = new Player(200, 200,tex);
		c = new Controller(tex);
		//c = new Controller(this,tex);
		
	}
	
	
	private synchronized void start(){
		if(running){
			return;
			
		}
		running =true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running){
			return;
			
		}
		running =false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		// this would be the game loop
		
		init();
		
		long lastTime = System.nanoTime();
		final double amountofTicks = 60.0;
		double ns = 1000000000 / amountofTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		
		while(running){
			
			//System.out.println("WORKING");
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + " Ticks,fps " + frames);
				updates = 0;
				frames = 0;
				
			}
			
		}
		stop();
		
	}
	
	private void tick(){
		p.tick();
		c.tick();
		
	}
	
	
	private void render(){
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null ){
			createBufferStrategy(3);
			return;
			
		}
		// dessine l'�cran g�n�ral
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		g.setColor(Color.RED);
		g.fillRect(0, 0, 800, 800);
		g.drawImage(background, 0, 0, null);
		// desssine le joueur
		p.render(g);
		// active les actions et renvoie les bullets
		c.render(g);
		//g.drawImage(player, 100, 100, this);
		g.dispose();
		bs.show();
		
	}
	
	public BufferedImage getSpriteSheet(){
		return spriteSheet;
	}
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT){
			p.setVelX(5);
		}
		else if(key == KeyEvent.VK_LEFT){
			p.setVelX(-5);	
		}
		else if(key == KeyEvent.VK_DOWN){
			p.setVelY(5);
		}
		else if(key == KeyEvent.VK_UP){
			p.setVelY(-5);

		}else if(key == KeyEvent.VK_SPACE && !isShooting){
			isShooting = true;
			c.addEntity(new Bullet(p.getX(), p.getY(), tex));
			//c.addBullet(new Bullet(p.getX(), p.getY(), tex));

		}
		
	}

	public void keyReleased(KeyEvent e) {
		
		
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT){
			p.setVelX(0);
		}
		else if(key == KeyEvent.VK_LEFT){
			p.setVelX(0);	
		}
		else if(key == KeyEvent.VK_DOWN){
			p.setVelY(0);
		}
		else if(key == KeyEvent.VK_UP){
			p.setVelY(0);

		}
		else if(key == KeyEvent.VK_SPACE){
			isShooting = false;
			

		}
		
	}
	
	
	public static void main(String[] args) {
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		game.start();
	}

	

}
