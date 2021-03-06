//Explode.java

package tank;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Bomb
 * 
 *
 */

public class Explode {
	private int x = 0;
	private int y = 0;
	private Color color = Color.WHITE;
	private int totalStep = 70;
	private int speed = 8;
	private int step = 0;
	private TankClient tc = null;
	
	
	
	public Explode(int x, int y, TankClient tc) {
		this.x = x;
		this.y = y;
		this.tc = tc;
	}
	
	

	public void draw(Graphics g) {
		Color orgColor = g.getColor();
		g.setColor(color);
		g.fillOval(x - step / 2, y - step / 2, step, step);
		step+=speed;
		if (step >= totalStep) {
			step = 0;
			tc.getExplodes().remove(this);
		}
		g.setColor(orgColor);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getTotalStep() {
		return totalStep;
	}

	public void setTotalStep(int totalStep) {
		this.totalStep = totalStep;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public TankClient getTc() {
		return tc;
	}

	public void setTc(TankClient tc) {
		this.tc = tc;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}


}
