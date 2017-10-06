package console;

import java.util.List;
import data.IllegalArithmeticOperationException;
import data.OperationFactory;
import engine.CalculationVisitor;
import engine.HightVistor;
import engine.SearchConstantVisitor;
import engine.SearchVariableVisitor;
import engine.TreeVisitor;

import model.*;

/**
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class TestFormula {

	public static void main(String[] args) {

		try {
			Operation tree = createTree();
			TreeVisitor<Integer> calculationVisitor = new CalculationVisitor();
			String formulaString = tree.toString();
			Object calculationResult = tree.accept(calculationVisitor);
			System.out.println("The result of the formula " + formulaString + " is : " + calculationResult);

			TreeVisitor<List<Constant>> searchConstantVisitor = new SearchConstantVisitor();
			List<Constant> results = tree.accept(searchConstantVisitor);
			for (Constant constant : results) {
				System.out.println("Constant " + constant.getValue());
			}

			TreeVisitor<List<Variable>> searchVariableVisitor = new SearchVariableVisitor();

			List<Variable> resultsVariable = tree.accept(searchVariableVisitor);
			for (Variable variable : resultsVariable) {
				System.out.println("Variable " + variable.getName());
			}
			
			HightVistor heightVisitor = new HightVistor();
			tree.accept(heightVisitor);
			System.out.println("The height of the tree is " + heightVisitor.getHeight());
		} catch (IllegalArithmeticOperationException e) {
			System.err.println(e.getMessage());
		}

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
