package ai2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Main extends JFrame implements Runnable{
	
	static Rectangle player = new Rectangle(30, 50, 25, 25);
    static Rectangle enemy = new Rectangle(275, 175, 16, 16);
    
    private Image dbImage;
    private Graphics dbg;
    
    int xDirection, yDirection;
    
    static AI AI = new AI(enemy, player);
    
    public Main(){
        setSize(600,400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(Color.LIGHT_GRAY);
        addKeyListener(new AL());
    }
    
    @Override
    public void paint(Graphics g){
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    private void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(player.x, player.y, player.width, player.height);
        AI.draw(g);
        repaint();
    }
    
    public void move(){
        player.x += xDirection;
        player.y += yDirection;
    }
    
    public void setYDirection(int ydir){
        yDirection = ydir;
    }
    public void setXDirection(int xdir){
        xDirection = xdir;
    }
    
    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            if(keyCode == e.VK_LEFT){
                setXDirection(-1);
            }
            if(keyCode == e.VK_RIGHT){
                setXDirection(1);
            }
            if(keyCode == e.VK_UP){
                setYDirection(-1);
            }
            if(keyCode == e.VK_DOWN){
                setYDirection(1);
            }
        }
        @Override
        public void keyReleased(KeyEvent e){
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
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        Thread t = new Thread(main);
        t.start();
        Thread t1 = new Thread(AI);
        t1.start();
    }
    
    @Override
    public void run(){
        try{
            while(true){
                move();
                Thread.sleep(5);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

}
