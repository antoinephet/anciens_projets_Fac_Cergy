package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PhonebookGUI extends JFrame{
	protected JLabel nameLabel = new JLabel("Contact name : ");
	protected JLabel numberLabel = new JLabel("Contact number: ");
	protected JLabel messageLabel = new JLabel("Everything is OK ! ");
	
	protected JTextField nameField = new JTextField(20);
	protected JTextField numberField = new JTextField(20);
	
	protected JButton addButton = new JButton("Add");
	protected JButton searchNameButton = new JButton("Search Name");
	protected JButton searchNumberButton = new JButton("Search Number");
	protected JButton removeButton = new JButton("Remove");
	
	private Phonebook phonebook;
	
	public PhonebookGUI(String title) {
		super(title);
		
		//We can choose one of the 3 classes that implement the interface.
		phonebook = new PhonebookHashMap(); 
		
		initStyle();
		
		initLayout();
		
		initActions();
	}

	protected void initActions() {
		addButton.addActionListener(new AddAction());
		searchNameButton.addActionListener(new SearchNameAction());
		searchNumberButton.addActionListener(new SearchNumberAction());
		removeButton.addActionListener(new RemoveAction());
	}

	protected void initStyle() {
		nameLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		numberLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
		nameField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		numberField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		
		addButton.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		searchNameButton.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		searchNumberButton.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		removeButton.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		
		messageLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
		messageLabel.setForeground(Color.BLUE);
	}

	protected void initLayout() {
		GridLayout grid = new GridLayout(3,3);
		getContentPane().setLayout(grid);
		
		//First line
		getContentPane().add(nameLabel);
		getContentPane().add(nameField);
		getContentPane().add(addButton);
		
		//Second line
		getContentPane().add(numberLabel);
		getContentPane().add(numberField);
		getContentPane().add(searchNameButton);
		
		//Third line
		getContentPane().add(messageLabel);
		getContentPane().add(removeButton);
		getContentPane().add(searchNumberButton);
		
		setSize(1000,200);
		setResizable(false);
		setVisible(true);
	}
	
	private class AddAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nameField.getText();
			String number = numberField.getText();
			if ((!name.equals("")) && (!number.equals(""))) {
				Contact contact = new Contact(name, number);
				try {
					phonebook.add(contact);
					updateStandardMessage("contact added !");
				} catch (ContactAlreadyExistsExceptions e1) {
					updateErrorMessage(e1.getMessage());
				}
			} else {
				messageLabel.setForeground(Color.RED);
				messageLabel.setText("Incomplete information !");
			}
		}
		
	}
	
	private class SearchNameAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String number = numberField.getText();
			if (!number.equals("")) {
				try {
					String name = phonebook.searchName(number);
					nameField.setText(name);
					updateStandardMessage("contact found !");
				} catch (NoSuchElementException e1) {
					updateErrorMessage(e1.getMessage());
				}
			} else {
				messageLabel.setForeground(Color.RED);
				messageLabel.setText("Please enter a number !");
			}
		}
		
	}
	
	private class SearchNumberAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nameField.getText();
			if (!name.equals("")) {
				try {
					String number = phonebook.searchNumber(name);
					numberField.setText(number);
					updateStandardMessage("contact found !");
				} catch (NoSuchElementException e1) {
					updateErrorMessage(e1.getMessage());
				}
			} else {
				messageLabel.setForeground(Color.RED);
				messageLabel.setText("Please enter a name !");
			}
		}
		
	}
	
	private class RemoveAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nameField.getText();
			String number = numberField.getText();
			if ((!name.equals("")) && (!number.equals(""))) {
				Contact contact = new Contact(name, number);
				
					phonebook.remove(contact);
					updateStandardMessage("contact removed !");
				
			} else {
				messageLabel.setForeground(Color.RED);
				messageLabel.setText("Incomplete information !");
			}
		}
		
	}
	
	private void updateStandardMessage(String message) {
		messageLabel.setForeground(Color.BLUE);
		messageLabel.setText(message);
	}
	
	private void updateErrorMessage(String message) {
		messageLabel.setForeground(Color.RED);
		messageLabel.setText(message);
	}
	
	public static void main(String[] args) {
		new PhonebookGUI("Phonebook GUI");
	}

}
