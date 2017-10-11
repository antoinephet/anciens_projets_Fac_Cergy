package bcbroz;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display extends JFrame{
	

	private static final long serialVersionUID = 1L;
	public JPanel gp = (JPanel) getGlassPane();
	public Images i;
	public Keying k;
	
	
	
	public Display(){
		
		i = new Images();
		gp.setVisible(true);
		k = new Keying(this,i);
		i.loadImages();
		
		gp.setLayout(new GridLayout(1, 1, 0, 0));
		this.setLayout(new GridLayout(1, 1, 0, 0));
		gp.add(k);
		this.add(i);
		
		
	}

}
