package tree.model;

import tree.engine.TreeVisitor;

public class Subtraction extends ArithmeticOperation {

	public Subtraction(Operation leftOperand, Operation rightOperand) {
		super(leftOperand, rightOperand);
	}

	@Override
	public String toString() {
		return getLeftOperand().toString() + " - " + getRightOperand().toString();
	}

	@Override
	public <T> T accept(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
