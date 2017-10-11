package bcbroz;

import javax.swing.JFrame;

public class Main {

	/**
	 * @param args
	 */
	
	public static Display f = new Display();
	public static int w = 600;
	public static int h = 400;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f.setSize(w, h);
		f.setResizable(true);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Voila");
		f.setLocationRelativeTo(null);
		f.setAlwaysOnTop(true);
		

	}

}
