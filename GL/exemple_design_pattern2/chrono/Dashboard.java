package chrono;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Dashboard extends JPanel {

	private static final long serialVersionUID = -8894601442689885332L;
	private int hourPositionX = 150;
	private int hourPositionY = 50;
	private int minutePositionX = 400;
	private int minutePositionY = 50;
	private int secondPositionX = 650;
	private int secondPositionY = 50;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLUE);

		g.drawOval(50, 50, 200, 200);
		g.drawLine(150, 150, hourPositionX, hourPositionY);

		g.drawOval(300, 50, 200, 200);
		g.drawLine(400, 150, minutePositionX, minutePositionY);

		g.drawOval(550, 50, 200, 200);
		g.drawLine(650, 150, secondPositionX, secondPositionY);
	}

	public void setHourPositionX(int hourPositionX) {
		this.hourPositionX = hourPositionX;
	}

	public void setHourPositionY(int hourPositionY) {
		this.hourPositionY = hourPositionY;
	}

	public void setMinutePositionX(int minutePositionX) {
		this.minutePositionX = minutePositionX;
	}

	public void setMinutePositionY(int minutePositionY) {
		this.minutePositionY = minutePositionY;
	}

	public void setSecondPositionX(int secondPositionX) {
		this.secondPositionX = secondPositionX;
	}

	public void setSecondPositionY(int secondPositionY) {
		this.secondPositionY = secondPositionY;
	}
}
