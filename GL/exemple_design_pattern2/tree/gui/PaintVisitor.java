package tree.gui;

import java.awt.Graphics;

import tree.engine.TreeVisitor;
import tree.model.Addition;
import tree.model.ArithmeticOperation;
import tree.model.Constant;
import tree.model.Multiplication;
import tree.model.Subtraction;
import tree.model.Variable;

/**
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class PaintVisitor implements TreeVisitor<Void> {
	private Graphics graphics;
	private Intersection intersection;
	private int treeHeight;
	private int currentHeight = 0;

	public PaintVisitor(Graphics graphics, Intersection intersection, int treeHeight) {
		this.graphics = graphics;
		this.intersection = intersection;
		this.treeHeight = treeHeight;
	}

	@Override
	public Void visit(Constant operation) {
		printCercle();
		int ajustedPositionX = intersection.getPositionX() - GraphicalTreeParameters.STRING_AJUSTEMENT;
		int ajustedPositionY = intersection.getPositionY() + GraphicalTreeParameters.STRING_AJUSTEMENT;
		graphics.drawString(String.valueOf(operation.getValue()), ajustedPositionX, ajustedPositionY);
		return null;
	}

	@Override
	public Void visit(Variable operation) {
		printCercle();
		int ajustedPositionX = intersection.getPositionX() - GraphicalTreeParameters.STRING_AJUSTEMENT;
		int ajustedPositionY = intersection.getPositionY() + GraphicalTreeParameters.STRING_AJUSTEMENT;
		graphics.drawString(String.valueOf(operation.getName()), ajustedPositionX, ajustedPositionY);
		return null;
	}

	@Override
	public Void visit(Addition operation) {
		processArithmeticOperation(operation);
		printArithmeticOperation("+", GraphicalTreeParameters.ADDITION_STRING_AJUSTEMENT, GraphicalTreeParameters.ADDITION_STRING_AJUSTEMENT);
		return null;
	}

	@Override
	public Void visit(Subtraction operation) {
		processArithmeticOperation(operation);
		printArithmeticOperation("-", GraphicalTreeParameters.SUBTRACTION_AJUSTEMENT, (int) (GraphicalTreeParameters.SUBTRACTION_AJUSTEMENT * 1.5));
		return null;
	}

	@Override
	public Void visit(Multiplication operation) {
		processArithmeticOperation(operation);
		printArithmeticOperation("*", GraphicalTreeParameters.MULTIPLICATION_AJUSTEMENT, GraphicalTreeParameters.MULTIPLICATION_AJUSTEMENT * 3);
		return null;
	}

	private void processArithmeticOperation(ArithmeticOperation operation) {
		printCercle();

		int currentPositionX = intersection.getPositionX();
		int currentPositionY = intersection.getPositionY();
		for (int i = 1; i <= Math.pow(2, treeHeight - currentHeight - 1); i++) {
			intersection.moveLeft();
		}
		intersection.moveDown();
		graphics.drawLine(currentPositionX, currentPositionY, intersection.getPositionX(), intersection.getPositionY());
		currentHeight++;
		operation.getLeftOperand().accept(this);
		currentHeight--;

		for (int i = 1; i <= Math.pow(2, treeHeight - currentHeight); i++) {
			intersection.moveRight();
		}
		graphics.drawLine(currentPositionX, currentPositionY, intersection.getPositionX(), intersection.getPositionY());
		currentHeight++;
		operation.getRightOperand().accept(this);
		currentHeight--;

		intersection.moveUp();
		for (int i = 1; i <= Math.pow(2, treeHeight - currentHeight - 1); i++) {
			intersection.moveLeft();
		}
	}

	private void printCercle() {
		graphics.drawOval(intersection.getPositionX() - GraphicalTreeParameters.RADIUS / 2, intersection.getPositionY() - GraphicalTreeParameters.RADIUS / 2, GraphicalTreeParameters.RADIUS,
				GraphicalTreeParameters.RADIUS);
	}

	private void printArithmeticOperation(String symbol, int xGap, int yGap) {
		graphics.drawString(symbol, intersection.getPositionX() - xGap, intersection.getPositionY() + yGap);
	}
}
