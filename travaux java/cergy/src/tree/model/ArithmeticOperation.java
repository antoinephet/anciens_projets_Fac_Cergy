package tree.model;

public abstract class ArithmeticOperation implements Operation {
	private Operation leftOperand;
	private Operation rightOperand;

	public ArithmeticOperation(Operation leftOperand, Operation rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	@Override
	public Operation getLeftOperand() {
		return leftOperand;
	}

	@Override
	public Operation getRightOperand() {
		return rightOperand;
	}

}
