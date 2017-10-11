package outils;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChronometerGUI extends JFrame {

	private Chronometer chronometer;

	private JButton incrementButtuon = new JButton(" Increment ");
	private JButton decrementButton = new JButton(" Decrement ");

	private JLabel hourLabel = new JLabel("Hour : ");
	private JLabel minuteLabel = new JLabel("Minute : ");
	private JLabel secondLabel = new JLabel("Second : ");

	private JTextField hourValue = new JTextField(5);
	private JTextField minuteValue = new JTextField(5);
	private JTextField secondValue = new JTextField(5);

	private Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);

	public ChronometerGUI(String title) {
		super(title);
		chronometer = new Chronometer();
		updateValues();
		
		init();
	}

	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		hourLabel.setFont(font);
		contentPane.add(hourLabel);
		hourValue.setFont(font);
		contentPane.add(hourValue);

		minuteLabel.setFont(font);
		contentPane.add(minuteLabel);
		minuteValue.setFont(font);
		contentPane.add(minuteValue);

		secondLabel.setFont(font);
		contentPane.add(secondLabel);
		secondValue.setFont(font);
		contentPane.add(secondValue);

		incrementButtuon.setFont(font);
		incrementButtuon.addActionListener(new IncrementAction());
		contentPane.add(incrementButtuon);

		decrementButton.setFont(font);
		decrementButton.addActionListener(new DecrementAction());
		contentPane.add(decrementButton);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	//Update hour, minute and second values in the window, according to the corresponding values in the chronometer.
	private void updateValues() {
		hourValue.setText(String.valueOf(chronometer.getHour().getValue()));
		minuteValue.setText(String.valueOf(chronometer.getMinute().getValue()));
		secondValue.setText(String.valueOf(chronometer.getSecond().getValue()));
	}

	private class IncrementAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			chronometer.increment();
			updateValues();
		}
	}

	private class DecrementAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			chronometer.decrement();
			updateValues();
		}

	}

	public static void main(String[] args) {
		new ChronometerGUI("Chronometer");
	}

}
