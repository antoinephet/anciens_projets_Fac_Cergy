package model;

public abstract class Operand implements Operation {

	@Override
	public Operation getLeftOperand() {	
		return null;
	}

	@Override
	public Operation getRightOperand() {
		return null;
	}
	

}
