package marioSokoban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import marioSokobanEditor.EditorFrame;
import marioSokobanGame.GameBoard;
import marioSokobanGame.GameFrame;

public class MenuFrame extends JFrame implements ActionListener {
	
	JButton cmdGame = new JButton("GAME !!!");
	JButton cmdEditor = new JButton("EDITOR !!!");
	JPanel pan = new JPanel();

	public MenuFrame(){
		
		this.setTitle("MAIN MENU");
		this.setSize(414, 436);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		
		pan.add(cmdGame);
		pan.add(cmdEditor);
		
		cmdGame.addActionListener(this);
		cmdEditor.addActionListener(this);
		
		this.setContentPane(pan);
		this.setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getSource() == cmdGame){
			GameFrame frm = new GameFrame();
			dispose();
			
		} else if(arg0.getSource() == cmdEditor){
			EditorFrame frm = new EditorFrame();
			dispose();
			
		}
		
		
		
	}

}
