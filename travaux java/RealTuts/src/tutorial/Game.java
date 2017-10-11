package tutorial;




import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;




public class Game extends JPanel implements ActionListener{
	

	private static final long serialVersionUID = 1L;
	private String background = "/images/background.gif";
	private Timer gamelooptimer;
	private Player p;
	//Enemy e1;
	private Controller c;

	public Game(){
		// si false on peut utiliser les touches sinon false
		setFocusable(true);
		
		gamelooptimer = new Timer(10,this);
		gamelooptimer.start();
		p = new Player(100, 100);
		c = new Controller();
		//e1 = new Enemy(350, 350);
		
		
		addKeyListener(new KeyInput(p));
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(getBackgroundImage(), 0, 0, this);
		p.draw(g2d);
		//e1.draw(g2d);
		c.draw(g2d);
	}
	
	public Image getBackgroundImage(){
		ImageIcon i = new ImageIcon(getClass().getResource(background));
		return i.getImage();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("RUNNING GAME LOOP");
		repaint();
		p.update();
		//e1.update();
		c.update();
		
		
		
	}

}
