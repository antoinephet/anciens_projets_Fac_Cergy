package tree.test;

import tree.data.IllegalArithmeticOperationException;
import tree.data.OperationFactory;
import tree.model.ArithmeticOperation;
import tree.model.Constant;
import tree.model.Operation;
import tree.model.Variable;

public class TreeUtility {

	public static Operation createTree() {
		try {
			Constant c1 = OperationFactory.create(2);
			Constant c2 = OperationFactory.create(3);
			Constant c3 = OperationFactory.create(4);

			Variable vX = OperationFactory.create("X", 1);
			Variable vY = OperationFactory.create("Y", 2);
			Variable vZ = OperationFactory.create("Z", 3);

			ArithmeticOperation term1;
			term1 = OperationFactory.create('*', c1, vX);

			ArithmeticOperation term2 = OperationFactory.create('*', c2, vY);
			ArithmeticOperation term3 = OperationFactory.create('+', term1, term2);
			ArithmeticOperation term4 = OperationFactory.create('*', c3, vZ);
			return OperationFactory.create('-', term3, term4);
		} catch (IllegalArithmeticOperationException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
}
