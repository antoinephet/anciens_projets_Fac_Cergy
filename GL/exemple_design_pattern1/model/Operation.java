package model;

import engine.TreeVisitor;

public interface Operation {
	Operation getLeftOperand();

	Operation getRightOperand();
	
	<T> T accept(TreeVisitor<T> visitor);
}
