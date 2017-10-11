package test1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GraphingData extends JPanel {

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int width = getWidth();
		int height = getHeight();

		int scale = 34; // int scale = 100;
		for (int i = 0; i <= width; i += scale) {

			g.drawLine(i, 10, i, height); // g.drawLine(i, 20, i, height);

		}

		for (int i = scale; i <= height; i += scale) {

			g.drawLine(0, i, width, i); // g.drawLine(20, i, width, i);

		}

	}

	private int getWidth(int width) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getHeight(int height) {
		// TODO Auto-generated method stub
		return 0;
	}

}