package model;

import engine.TreeVisitor;

public class Multiplication extends ArithmeticOperation{

	public Multiplication(Operation leftOperand, Operation rightOperand) {
		super(leftOperand, rightOperand);
	}
	
	@Override
	public String toString() {
		return getLeftOperand().toString() + " * "+ getRightOperand().toString();
	}

	@Override
	public <T> T accept(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
