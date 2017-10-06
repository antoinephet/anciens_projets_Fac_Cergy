package tree.model;

import tree.engine.TreeVisitor;

public interface Operation {
	Operation getLeftOperand();

	Operation getRightOperand();

	<T> T accept(TreeVisitor<T> visitor);
}
