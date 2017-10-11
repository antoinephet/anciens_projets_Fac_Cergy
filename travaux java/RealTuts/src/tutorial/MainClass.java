package tutorial;

import javax.swing.JFrame;




public class MainClass {

	/**
	 * @param args
	 */
	
	public static final int WIDTH = 640 ,HEIGHT = 480;
	public static String title = "Tutorial Test";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame(title);
		frame.pack();
		frame.setSize(WIDTH,HEIGHT);
		//frame.setTitle("Tutorial Test");
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Game());
		frame.setVisible(true);

	}

}
