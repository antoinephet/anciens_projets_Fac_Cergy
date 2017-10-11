package training.tangara.chrono;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Tianxiao.Liu@u-cergy.fr
 **/
public class ChronometerGUI extends JFrame implements Runnable {
	private static final int SPEED = 1000;
	private static final long serialVersionUID = 1L;
	private Chronometer chronometer;

	private JButton startButton = new JButton(" Start ");
	private JButton clearButton = new JButton(" Clear ");
	private JButton stopButton = new JButton (" Stop ");

	private JLabel hourLabel = new JLabel("Hour : ");
	private JLabel minuteLabel = new JLabel("Minute : ");
	private JLabel secondLabel = new JLabel("Second : ");

	private JTextField hourValue = new JTextField(5);
	private JTextField minuteValue = new JTextField(5);
	private JTextField secondValue = new JTextField(5);

	private ChronometerGUI instance = this;

	private boolean stop = true;

	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);

	private JPanel control = new JPanel();
	private Dashboard dashboard = new Dashboard();

	public ChronometerGUI(String title) {
		super(title);
		chronometer = new Chronometer(0, 0, 0);
		init();
	}

	private void init() {
		updateValues();

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		control.setLayout(new FlowLayout(FlowLayout.CENTER));
		hourLabel.setFont(font);
		control.add(hourLabel);
		hourValue.setFont(font);
		control.add(hourValue);

		minuteLabel.setFont(font);
		control.add(minuteLabel);
		minuteValue.setFont(font);
		control.add(minuteValue);

		secondLabel.setFont(font);
		control.add(secondLabel);
		secondValue.setFont(font);
		control.add(secondValue);

		startButton.setFont(font);
		startButton.addActionListener(new StartStopAction());
		control.add(startButton);
		
		//stopbutton
		
		stopButton.setFont(font);
		stopButton.addActionListener(new StopAction());
		control.add(stopButton);

		clearButton.setFont(font);
		clearButton.addActionListener(new ClearAction());
		control.add(clearButton);

		contentPane.add(BorderLayout.NORTH, control);

		dashboard.setPreferredSize(new Dimension(500, 300));
		contentPane.add(BorderLayout.SOUTH, dashboard);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setResizable(false);
	}

	private void updateValues() {
		CyclicCounter hour = chronometer.getHour();
		hourValue.setText(hour.toString());

		CyclicCounter minute = chronometer.getMinute();
		minuteValue.setText(minute.toString());

		CyclicCounter second = chronometer.getSecond();
		secondValue.setText(second.toString());

		double hourRadian = calculateRadian(hour.getValue());
		dashboard.setHourPositionX((int) (150 + 100 * Math.cos(hourRadian)));
		dashboard.setHourPositionY((int) (150 - 100 * Math.sin(hourRadian)));

		double minuteRadian = calculateRadian(minute.getValue());
		dashboard.setMinutePositionX((int) (400 + 100 * Math.cos(minuteRadian)));
		dashboard.setMinutePositionY((int) (150 - 100 * Math.sin(minuteRadian)));

		double secondRadian = calculateRadian(second.getValue());
		dashboard.setSecondPositionX((int) (650 + 100 * Math.cos(secondRadian)));
		dashboard.setSecondPositionY((int) (150 - 100 * Math.sin(secondRadian)));
		dashboard.repaint();
	}

	private double calculateRadian(float value) {
		if (value > 15 && value <= 45) {
			return -((value - 15) / 30 * Math.PI);
		} else if (value <= 15 && value >= 0) {
			return (15 - value) / 15 * Math.PI / 2;
		} else {
			return (60 - value) / 15 * Math.PI / 2 + Math.PI / 2;
		}
	}

	@Override
	public void run() {
		while (!stop) {
			try {
				Thread.sleep(SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			chronometer.increment();
			updateValues();
		}
	}

	private class StartStopAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!stop) {
				stop = true;
				startButton.setText(" Start ");
			} else {
				stop = false;
				startButton.setText(" Pause ");
				Thread chronoThread = new Thread(instance);
				chronoThread.start();
			}
		}
	}
	/*private class StopAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!stop) {
				stop = true;
				stopButton.setText(" Start ");
				
			} else {
				stop = false;
				stopButton.setText(" Pause ");
				Thread chronoThread = new Thread(instance);
				chronoThread.start();
			}
		}
	}*/
	private class ClearAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			stop = true;
			startButton.setText(" Start ");
			chronometer.init();
			updateValues();
			startButton.setEnabled(true);
		}

	}
//modification apporté 
	
	private class StopAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			stop = true;
			stopButton.setText(" Stop ");
			startButton.setEnabled(false);
			updateValues();
			Thread chronoThread = new Thread(instance);
			chronoThread.stop();
		}

	}

	public static void main(String[] args) {
		new ChronometerGUI("Chronometer");
	}

}
