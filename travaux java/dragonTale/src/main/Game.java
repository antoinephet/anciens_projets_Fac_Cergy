package main;

import javax.swing.JFrame;

public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame("Dragon Tale");
		window.setContentPane(new GamePanel()); // ajouter la fenetre ou classe GamePanel type Jpanel
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false); // pour agrandir la fenetre ou pas 
		window.pack();
		window.setVisible(true); // rendre visible la fenetre

	}

}
