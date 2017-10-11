package ipmon;

import javax.swing.JFrame;



public class GameFrame extends JFrame{
	
	public GameFrame(){
		
		// Creation de la fenetre
		
		this.setTitle("IPMON");
		this.setSize(408, 408);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new GameBoard(this));
		this.setVisible(true);
	}

}
