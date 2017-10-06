package tree.console;

import java.util.List;

import tree.data.IllegalArithmeticOperationException;
import tree.data.OperationFactory;
import tree.engine.CalculationVisitor;
import tree.engine.HeigtVisitor;
import tree.engine.SearchConstantVisitor;
import tree.engine.SearchVariableVisitor;
import tree.engine.TreeVisitor;
import tree.model.*;

/**
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class TestFormula {

	public static void main(String[] args) {

		try {
			Operation tree = createTree();

			testCalculationVisitor(tree);

			testConstantVisitor(tree);

			testVariableVisitor(tree);

			testHeightVisitor(tree);

		} catch (IllegalArithmeticOperationException e) {
			System.err.println(e.getMessage());
		}

	}

	private static void testHeightVisitor(Operation tree) {
		HeigtVisitor heightVisitor = new HeigtVisitor();
		tree.accept(heightVisitor);
		System.out.println("The height of the tree is " + heightVisitor.getHeight());
	}

	private static void testVariableVisitor(Operation tree) {
		TreeVisitor<List<Variable>> searchVariableVisitor = new SearchVariableVisitor();

		List<Variable> resultsVariable = tree.accept(searchVariableVisitor);
		System.out.println("- All found variables : ");
		for (Variable variable : resultsVariable) {
			System.out.println("Variable " + variable.getName());
		}
	}

	private static void testConstantVisitor(Operation tree) {
		TreeVisitor<List<Constant>> searchConstantVisitor = new SearchConstantVisitor();
		List<Constant> results = tree.accept(searchConstantVisitor);
		System.out.println("- All found constants : ");
		for (Constant constant : results) {
			System.out.println("Constant " + constant.getValue());
		}
	}

	private static void testCalculationVisitor(Operation tree) {
		TreeVisitor<Integer> calculationVisitor = new CalculationVisitor();
		String formulaString = tree.toString();
		Object calculationResult = tree.accept(calculationVisitor);
		System.out.println("The result of the formula " + formulaString + " is : " + calculationResult);
	}

	public static Operation createTree() throws IllegalArithmeticOperationException {
		Constant c1 = OperationFactory.create(2);
		Constant c2 = OperationFactory.create(3);
		Constant c3 = OperationFactory.create(4);

		Variable vX = OperationFactory.create("X", 1);
		Variable vY = OperationFactory.create("Y", 2);
		Variable vZ = OperationFactory.create("Z", 3);

		ArithmeticOperation term1 = OperationFactory.create('*', c1, vX);
		ArithmeticOperation term2 = OperationFactory.create('*', c2, vY);
		ArithmeticOperation term3 = OperationFactory.create('+', term1, term2);
		ArithmeticOperation term4 = OperationFactory.create('*', c3, vZ);
		ArithmeticOperation root = OperationFactory.create('-', term3, term4);
		return root;
	}

}
