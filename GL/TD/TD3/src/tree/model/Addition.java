package tree.model;

import tree.engine.TreeVisitor;

public class Addition extends ArithmeticOperation {

	public Addition(Operation leftOperand, Operation rightOperand) {
		super(leftOperand, rightOperand);

	}

	@Override
	public String toString() {
		return getLeftOperand().toString() + " + " + getRightOperand().toString();
	}

	@Override
	public <T> T accept(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
