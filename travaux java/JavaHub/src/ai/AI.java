package ai;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class AI implements Runnable{
	
	Rectangle AI, target;
    
    int xDirection, yDirection;
    
    boolean resting = false;
    boolean shouldSetRandDir = false;
    
    Image octoroc;
    
    public AI(Rectangle r){ //Rectangle t
        AI = r;
        //target = t;
       
    }
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        if(AI != null)
            g.fillRect(AI.x, AI.y, AI.width, AI.height);
       
    }
    
    public int chooseRandomDirection(){
    	Random r = new Random();
    	int[] randDirections = new int[3];
    	randDirections[0] = 0;
    	randDirections[1] = 1;
    	randDirections[2] = -1;
    	int randChoice = r.nextInt(3);
    	return randDirections[randChoice];
    	
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
        
    }
    //In Run method, move in that direction and then wait
    @Override
    public void run(){
        try{
            while(true){
                if(!resting){
                	if(shouldSetRandDir){
	                	setXDirection(chooseRandomDirection());
	                	setYDirection(chooseRandomDirection());
	                	shouldSetRandDir = false;
                	}
                	long start = System.currentTimeMillis();
                	long end = start + 1*1000;
                	while(System.currentTimeMillis() < end){
                		move();
                		Thread.sleep(10);
                		
                	}
                	resting = true;
                }
                else{
                	Thread.sleep(30);
                	shouldSetRandDir = true;
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
