package bcbroz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Images extends JPanel{
	

	private static final long serialVersionUID = 1L;
	public int w = Main.w;
	public int h = Main.h;
	
	public boolean imagesLoaded = false;
	
	public Image bg;
	
	public Images(){
		
		this.setBackground(Color.BLACK);
		loadImages();
		
	}
	
	public void loadImages(){
		
		bg = new ImageIcon("C:/Youtube/gb.png").getImage();
		imagesLoaded = true;
		
	}

}
