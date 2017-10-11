package draws;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Arc2D;


import javax.swing.JFrame;

public class Tutorial1 extends JFrame {
	
	
	public Tutorial1(){
		 
		setTitle("Tutorial");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
           
    }

    public void paint(Graphics g){
    	
    	Graphics2D graph2 = (Graphics2D)g;
   	 
    	g.setColor(Color.GREEN);
   	 	g.drawRect(480, 480, 200, 200);
   	 	g.setColor(Color.ORANGE);
        g.fillOval(240, 240, 200, 100);
        g.drawArc(5, 150, 100, 100, 25, 90);
        Shape drawArc2D = new Arc2D.Double(10, 150, 100, 100,45,45,Arc2D.PIE); // x, y, w,h ,start ,extend ,type
 
        graph2.draw(drawArc2D);
    }


	public static void main(String[] args) {
		
		Tutorial1 t = new Tutorial1();

	}

}
