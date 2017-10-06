package tree.gui;

/**
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class Intersection {
	private int x;
	private int y;
	private int scale;

	public Intersection(int x, int y, int scale) {
		this.x = x;
		this.y = y;
		this.scale = scale;
	}

	public int getPositionX() {
		return x * scale;
	}

	public int getPositionY() {
		return y * scale;
	}

	public void moveUp() {
		y--;
	}

	public void moveDown() {
		y++;
	}

	public void moveLeft() {
		x--;
	}

	public void moveRight() {
		x++;
	}

}
