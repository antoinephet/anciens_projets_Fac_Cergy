package ihm;

import java.awt.Graphics;

import javax.swing.JPanel;

public class ExceptionPanel extends JPanel {

	private String string;
	
	public ExceptionPanel(String string){
	   
		this.string=string;
	}
		
	public void paintComponent(Graphics gr){
		
		
		gr.drawString(string, 60,60);
		
	}
}
