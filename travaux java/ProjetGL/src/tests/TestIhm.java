package tests;

import javax.swing.JFrame;

import modele.GraphingData;

public class TestIhm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		  JFrame f = new JFrame();
		  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); f.add( new
		  GraphingData()); f.setSize(400,400); f.setLocation(200,200);
		  f.setVisible(true);
		 

	}

}
