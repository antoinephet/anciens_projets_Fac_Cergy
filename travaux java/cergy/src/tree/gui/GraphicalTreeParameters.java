package tree.gui;

/**
 * The experimental result shows that the minimal width is 800.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class GraphicalTreeParameters {

	/**
	 * Radical parameter.
	 */
	public static final int WINDOW_WIDTH = 800;

	public static final int WINDOW_HEIGHT = (WINDOW_WIDTH / 800) * 500;

	public static final int SCALE = (WINDOW_WIDTH / 800) * 50;

	public static final Intersection START_POINT = new Intersection(8, 1, SCALE);

	public static final int RADIUS = (WINDOW_WIDTH / 800) * 40;

	public static final int MULTIPLICATION_AJUSTEMENT = (WINDOW_WIDTH / 800) * 6;
	public static final int SUBTRACTION_AJUSTEMENT = (WINDOW_WIDTH / 800) * 5;
	public static final int ADDITION_STRING_AJUSTEMENT = (WINDOW_WIDTH / 800) * 9;

	public static final int STRING_AJUSTEMENT = (WINDOW_WIDTH / 800) * 10;

	public static final int POLICE_SIZE = (WINDOW_WIDTH / 800) * 30;

}
