package collision;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	private Image dbImage;
    private Graphics dbg;
    
    int rectX, rectY;
    
    public Main(){
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        addMouseMotionListener(new AL());
    }
    
    @Override
    public void paint(Graphics g){
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    public void paintComponent(Graphics g){
        Rectangle r1 = new Rectangle(rectX, rectY, 25, 25);
        Rectangle r2 = new Rectangle(175, 75, 50, 50);
        g.setColor(Color.RED);
        g.fillRect(r2.x, r2.y, r2.width, r2.height);
        g.setColor(Color.BLUE);
        g.fillRect(r1.x, r1.y, r1.width, r1.height);
        
        //Collision
        if(r1.intersects(r2))
            g.drawString("Collision!!", 175, 75);
        
        repaint();
    }
    
    public class AL extends MouseAdapter {
        @Override
        public void mouseMoved(MouseEvent e){
            rectX = e.getX()-12;
            rectY = e.getY()-12;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();

	}

}
