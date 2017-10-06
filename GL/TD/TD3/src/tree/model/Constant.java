package tree.model;

import tree.engine.TreeVisitor;

public class Constant extends Operand {
	private int value;

	public Constant(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	@Override
	public <T> T accept(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
