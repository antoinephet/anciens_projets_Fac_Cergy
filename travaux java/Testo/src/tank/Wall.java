//Wall.java

package tank;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * wall
 *
 */

public class Wall {
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;
	private Color color = Color.BLACK;

	
	
	public Wall(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	
	public Wall(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	
	
	public void draw(Graphics g) {
		Color orgColor = g.getColor();
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(orgColor);
	}
	
	

	public Rectangle getRect() {
		return new Rectangle(x, y, width, height);
	}
}
