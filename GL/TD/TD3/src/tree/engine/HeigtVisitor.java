package tree.engine;

import tree.model.Addition;
import tree.model.ArithmeticOperation;
import tree.model.Constant;
import tree.model.Multiplication;
import tree.model.Subtraction;
import tree.model.Variable;

public class HeigtVisitor implements TreeVisitor<Void> {
	private int height = 0;
	private int currentHeight = 0;

	public int getHeight() {
		return height;
	}

	public void setDeepest(int deepest) {
		this.height = deepest;
	}

	@Override
	public Void visit(Constant operation) {
		if (height < currentHeight) {
			height = currentHeight;
		}
		return null;
	}

	@Override
	public Void visit(Variable operation) {
		if (height < currentHeight) {
			height = currentHeight;
		}
		return null;
	}

	@Override
	public Void visit(Addition operation) {
		processArithmeticOperation(operation);
		return null;
	}

	@Override
	public Void visit(Subtraction operation) {
		processArithmeticOperation(operation);
		return null;
	}

	@Override
	public Void visit(Multiplication operation) {
		processArithmeticOperation(operation);
		return null;
	}

	private void processArithmeticOperation(ArithmeticOperation operation) {
		currentHeight++;
		operation.getLeftOperand().accept(this);
		operation.getRightOperand().accept(this);
		currentHeight--;
	}

}
