package ai2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class AI implements Runnable{
	
	Rectangle AI, target;
    
    int xDirection, yDirection;
    
    boolean resting = false;
    
    Image octoroc;
    
    public AI(Rectangle r, Rectangle t){
        AI = r;
        target = t;
        octoroc = new ImageIcon(getClass().getResource("/images/gardien.png")).getImage();
    }
    public void draw(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        if(AI != null)
            g.drawRect(AI.x, AI.y, AI.width, AI.height);
        g.drawImage(octoroc, AI.x, AI.y, null);
    }
    
    //Find a path to the target
    public void findPathToTarget(){
    	if(AI.x < target.x){
    		setXDirection(1);
    		
    	}
    	if(AI.x > target.x){
    		setXDirection(-1);
    		
    	}
    	if(AI.y < target.y){
    		setYDirection(1);
    		
    	}
    	if(AI.y > target.y){
    		setYDirection(-1);
    		
    	}
    	
    }
    
    //Move in that direction
    public void detectEdges(){
        if(AI.x <= 0)
            setXDirection(1);
        if(AI.x >= 600-AI.width)
            setXDirection(-1);
        if(AI.y <= 25)
            setYDirection(1);
        if(AI.y > 400-AI.height)
            setYDirection(-1);
    }
    public void setXDirection(int dir){
        xDirection = dir;
    }
    public void setYDirection(int dir){
        yDirection = dir;
    }
    public void move(){
        AI.x += xDirection;
        AI.y += yDirection;
        /*if(xDirection == 1)
            octoroc = new ImageIcon("C:/Users/Oliver/Documents/NetBeansProjects/AI/src/TheCarePackage/right.gif").getImage();
        if(xDirection == -1)
            octoroc = new ImageIcon("C:/Users/Oliver/Documents/NetBeansProjects/AI/src/TheCarePackage/left.gif").getImage();
        if(yDirection == 1)
            octoroc = new ImageIcon("C:/Users/Oliver/Documents/NetBeansProjects/AI/src/TheCarePackage/down.gif").getImage();
        if(yDirection == -1)
            octoroc = new ImageIcon("C:/Users/Oliver/Documents/NetBeansProjects/AI/src/TheCarePackage/up.gif").getImage();*/
    }
    //In Run method, move in that direction and then wait
    @Override
    public void run(){
        try{
            while(true){
                if(!resting){
                    long start = System.currentTimeMillis();
                    long end = start + 3*500;
                    while(System.currentTimeMillis() < end){
                    	findPathToTarget();
                        move();
                        detectEdges();
                        Thread.sleep(10);
                    }
                    resting = true;
                }
                else{
                    Thread.sleep(20);
                    resting = false;
                }
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void log(String s){
        System.out.println(s);
    }

}
