package ater;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;




public class Gardien extends Entite{
	//private int x ; // protected
	//private int y ;
	private String playerImage = "/images/gardien.png";
	private int velX = 0;
	private int velY = 0;
	private int speed = 5;
	private int choix = (int)(Math.random()*4+1);
	boolean activeUser = false;
	
	
	private int xDirection, yDirection;
    
    boolean resting = false;
    boolean shouldSetRandDir = false;
	
	
	
	public Gardien(int x, int y) {
		super(x,y);
	}


	
	public void update(){
		// vitesse deplacement rectiligne et horizontal de l'ennemi
		if(!activeUser){
			if(!resting){
            	if(shouldSetRandDir){
                	setXDirection(chooseRandomDirection());
                	setYDirection(chooseRandomDirection());
                	shouldSetRandDir = false;
            	}
            	
            		move();
            		try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		
            	
            	resting = true;
            }
            else{
            	try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	shouldSetRandDir = true;
            	resting = false;
                
            }
        }
			
			
			/*if(choix == 1){
				x+=speed;
				}else if(choix == 2){
					x-=speed;
				}else if(choix == 3){
					y-=speed;
				}else if(choix == 4){
					y+=speed;
				}
			
			if(x >= 1052){
				speed = -5;
			}
			else if(x <= 34){
				speed = 5;
			}
			else if(y >= 614){
				speed = -5;
			}
			else if(y <= 34){
				speed = 5;
			}*/
			
		
		
		if(activeUser){
			
		
			x +=velX;
			y +=velY;
			
			// Collision, joueur doit pas sortir du JFrame
			if(x <= 34){
				
				x = 34;
				
			}
			
			if(y <= 34){
				
				y = 34;
				}
			
			if(x >= 1052){
				
				x = 1052;
				
			}
			
			if(y >= 614){
				
				y = 614;
				
			}
			
		}
			
		
	}
	
	public int chooseRandomDirection(){
    	Random r = new Random();
    	int[] randDirections = new int[3];
    	randDirections[0] = 0;
    	randDirections[1] = 15;
    	randDirections[2] = -15;
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
        x += xDirection;
        y += yDirection;
        
        if(x >= 1052){
        	x = 1052;
		}
		else if(x <= 34){
			x = 34;
		}
		
		else if(y >= 614){
			y = 614;
		}
		else if(y <= 34){
			y = 34;
		}
        
    }
    
		
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32, 32);
	}
	
	public void draw(Graphics2D g2d){
		
		// dessine le joueur
		g2d.drawImage(getGardienImage(), x, y, null);
		//g2d.draw(getBounds());
	}
	
	public Image getGardienImage(){
		
		// retourne l'image instanciť
		ImageIcon i = new ImageIcon(getClass().getResource(playerImage));
		return i.getImage();
		
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}



	@Override
	public String toString() {
		return "Gardien [x=" + x + ", y=" + y + "]";
	}
	
	public void keyPressed(KeyEvent e) {
		// attribution des touches du clavier
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT && activeUser){
			velX = 5;
		}
		else if(key == KeyEvent.VK_LEFT && activeUser){
			velX = -5;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN && activeUser){
			velY = 5;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP && activeUser){
			velY = -5;
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_P){
			
			activeUser = true;
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_C){
			
			activeUser = false;
			
		}
	
		
	}

	
	public void keyReleased(KeyEvent e) {
		// attribution des touches du clavier
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT && activeUser){
			velX = 0;
		}
		else if(key == KeyEvent.VK_LEFT && activeUser){
			velX = 0;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN && activeUser){
			velY = 0;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP && activeUser){
			velY = 0;
			
		}
		
	}


	
}
