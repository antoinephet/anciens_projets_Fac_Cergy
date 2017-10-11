package ihm;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExceptionMessage extends JFrame {

	private  ExceptionPanel panelMessage;

	private Font font = new Font(Font.MONOSPACED, Font.BOLD, 15);
	
	public ExceptionMessage(String string) {
		super("Exception");
		
		panelMessage= new ExceptionPanel(string);
		panelMessage.setFont(font);
		
		setContentPane(panelMessage);
		
		setVisible(true);
		setSize(545, 200);
	}
   
}
