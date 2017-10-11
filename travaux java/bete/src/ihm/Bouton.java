package ihm;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class  Bouton extends JButton {
	  private String name;
	     private ImageIcon img;
	         
	     public Bouton(String str){
	             super(str);
	             this.name = str;
	             
	                     URL resource = getClass().getResource("/fond1.jpg");
						img = new ImageIcon(resource);
                        
	 
	     }
	    
	     public void paintComponent(Graphics g){
	                 
	    	 Graphics2D g2d = (Graphics2D)g;
             
             GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
             g2d.setPaint(gp);
             g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
             
             g2d.setColor(Color.white);
             g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth()/3), (this.getHeight() / 2) + 5);
             
	     }

}
