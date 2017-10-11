package draws;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Tutorial extends JFrame{
	
	 public Tutorial(){
		 
		 setTitle("Tutorial");
         setSize(400, 400);
         setVisible(true);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
            
     }

     public void paint(Graphics g){
    	 
    	 g.setColor(Color.BLUE);
    	 g.drawRect(480, 480, 200, 100);
    	 g.setColor(Color.RED);
         g.fillRect(240, 240, 200, 100);
     }

      public static void main(String[] args){
    	  
    	 Tutorial t = new Tutorial();
            
      }


}
