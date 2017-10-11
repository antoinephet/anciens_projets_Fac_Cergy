package test;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Another phonebook GUI implementation with some different style and layout.
 */
public class PhonebookGUI2 extends PhonebookGUI {
	private JPanel linePanel1;
	private JPanel linePanel2;
	private JPanel linePanel3;
	private JPanel linePanel4;

	public PhonebookGUI2(String title) {
		//This will call, in the super class, the overrided methods initStyle and initLayout.
		super(title);
	}

	@Override
	protected void initStyle() {
		nameLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		numberLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		nameField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
		numberField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));

		addButton.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		searchNameButton.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		searchNumberButton.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		removeButton.setFont(new Font(Font.DIALOG, Font.BOLD, 15));

		messageLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
		messageLabel.setForeground(Color.BLUE);
	}

	@Override
	protected void initLayout() {
		GridLayout grid = new GridLayout(4, 1);
		getContentPane().setLayout(grid);

		// First line
		linePanel1 = new JPanel();
		linePanel1.setSize(500,100);
		linePanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		linePanel1.add(nameLabel);
		linePanel1.add(nameField);
		getContentPane().add(linePanel1);

		// Second line
		linePanel2 = new JPanel();
		linePanel2.setSize(500,100);
		linePanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		linePanel2.add(numberLabel);
		linePanel2.add(numberField);
		getContentPane().add(linePanel2);

		// Third line
		linePanel3 = new JPanel();
		linePanel3.setSize(500,100);
		linePanel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		linePanel3.add(addButton);
		linePanel3.add(searchNameButton);
		linePanel3.add(searchNumberButton);
		linePanel3.add(removeButton);
		getContentPane().add(linePanel3);
		
		// Fourth line
		linePanel4 = new JPanel();
		linePanel4.setSize(500,100);
		linePanel4.setLayout(new FlowLayout(FlowLayout.CENTER));
		linePanel4.add(messageLabel);
		getContentPane().add(linePanel4);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new PhonebookGUI2("Phonebook GUI");
	}

}
