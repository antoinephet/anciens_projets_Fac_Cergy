//Blood.java

package tank;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class Blood {
	private int x = 0;
	private int y = 0;
	private int blood = 15;
	private int size = 10;

	private Color color=Color.RED;

	/**
	 * @param x blood
	 * @param y blood
	 */
	
	public Blood(int x, int y) {
		this.x = x;
		this.y = y;
	}

	
	
	public Blood(int x, int y, int blood) {
		this(x, y);
		this.blood = blood;
	}
	
	
	
	public boolean hitTank(Tank t) {
		return this.getRect().intersects(t.getRect());
	}
	
	
	
	void draw(Graphics g) {
		Color orgColor = g.getColor();
		g.setColor(color);
		g.fillOval(x, y, size, size);
		g.setColor(orgColor);
	}
	
	
	
	public Rectangle getRect() {
		return new Rectangle(x, y, size, size);
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

	public int getBlood() {
		return blood;
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
