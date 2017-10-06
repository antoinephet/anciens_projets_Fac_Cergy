package tree.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import tree.engine.HeigtVisitor;
import tree.model.Operation;

/**
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class TreePanel extends JPanel {

	private static final long serialVersionUID = -541698616292452515L;
	private Operation tree;
	private int treeHeight;
	private boolean debug = false;

	public TreePanel(Operation tree) throws NoSupportedWindowSizeException {
		int windowWidth = GraphicalTreeParameters.WINDOW_WIDTH;
		if (windowWidth < 800 || (windowWidth % 800 != 0)) {
			throw new NoSupportedWindowSizeException(windowWidth);
		}

		this.tree = tree;
		HeigtVisitor hightVistor = new HeigtVisitor();
		tree.accept(hightVistor);
		treeHeight = hightVistor.getHeight();

		setPreferredSize(new Dimension(windowWidth, GraphicalTreeParameters.WINDOW_HEIGHT));
		setBackground(Color.WHITE);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Dialog", Font.PLAIN, GraphicalTreeParameters.POLICE_SIZE));
		g.setColor(Color.BLUE);

		if (debug) {
			drawGrid(g);
		}

		PaintVisitor paintVisitor = new PaintVisitor(g, GraphicalTreeParameters.START_POINT, treeHeight);
		tree.accept(paintVisitor);

	}

	private void drawGrid(Graphics g) {
		int width = getWidth();
		int height = getHeight();

		for (int i = GraphicalTreeParameters.SCALE; i <= width; i += GraphicalTreeParameters.SCALE) {
			g.drawLine(i, 1, i, height);
		}

		for (int i = GraphicalTreeParameters.SCALE; i <= height; i += GraphicalTreeParameters.SCALE) {
			g.drawLine(1, i, width, i);
		}
	}
}
