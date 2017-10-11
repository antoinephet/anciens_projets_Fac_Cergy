package outils;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CounterGUI extends JFrame {
	private JLabel valueLabel = new JLabel("Value : ");
	private JTextField valueField = new JTextField(5);
	private JButton incrementButton = new JButton("increment");
	private JButton decrementButton = new JButton("decrement");
	private JButton resetButton = new JButton("reset");
	private JButton quitButton = new JButton("quit");
	private JPanel rightPanel = new JPanel();

	private Counter counter;

	public CounterGUI(String title) {
		super(title);

		counter = new Counter(0);

		init();

		valueField.setText(String.valueOf(counter.getValue()));

		incrementButton.addActionListener(new IncrementAction());
		decrementButton.addActionListener(new DecrementAction());
		resetButton.addActionListener(new ResetAction());
		//Use a parameter (this) to give the current window (JFrame) to be closed.
		quitButton.addActionListener(new QuitAction(this));
	}

	private void init() {
		BorderLayout border = new BorderLayout();
		getContentPane().setLayout(border);

		getContentPane().add(BorderLayout.WEST, valueLabel);
		getContentPane().add(BorderLayout.CENTER, valueField);
		getContentPane().add(BorderLayout.NORTH, incrementButton);
		getContentPane().add(BorderLayout.SOUTH, decrementButton);

		rightPanel.setLayout(new GridLayout(2, 1));
		rightPanel.add(resetButton);
		rightPanel.add(quitButton);
		getContentPane().add(BorderLayout.EAST, rightPanel);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private class IncrementAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// If the user changes manually the value in the text field ...
				counter.setValue(Integer.valueOf(valueField.getText()));

				counter.increment();
				valueField.setText(String.valueOf(counter.getValue()));
			} catch (LimitReachedException e1) {
				// No need to show the message in the window.
				System.err.println(e1.getMessage());
			}
		}

	}

	private class DecrementAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// If the user changes manually the value in the text field ...
				counter.setValue(Integer.valueOf(valueField.getText()));

				counter.decrement();
				valueField.setText(String.valueOf(counter.getValue()));
			} catch (LimitReachedException e1) {
				// No need to show the message in the window.
				System.err.println(e1.getMessage());
			}
		}

	}

	private class ResetAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			counter.setValue(0);
			valueField.setText(String.valueOf(counter.getValue()));
		}

	}

	private class QuitAction implements ActionListener {
		//Window to be closed.
		private JFrame window;

		public QuitAction(JFrame window) {
			this.window = window;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			window.dispose();
		}

	}

	public static void main(String[] args) {
		new CounterGUI("Counter GUI");
	}

}
