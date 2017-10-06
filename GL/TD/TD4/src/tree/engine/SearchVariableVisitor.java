package tree.engine;

import java.util.ArrayList;
import java.util.List;

import tree.model.Addition;
import tree.model.ArithmeticOperation;
import tree.model.Constant;
import tree.model.Multiplication;
import tree.model.Subtraction;
import tree.model.Variable;

/**
 * @author Tianxiao.Liu@u-cergy.fr
 **/
public class SearchVariableVisitor implements TreeVisitor<List<Variable>> {

	@Override
	public List<Variable> visit(Constant operation) {
		return new ArrayList<Variable>();
	}

	@Override
	public List<Variable> visit(Variable operation) {
		List<Variable> result = new ArrayList<Variable>();
		result.add(operation);
		return result;
	}

	@Override
	public List<Variable> visit(Addition operation) {
		return processArthmeticOperation(operation);
	}

	@Override
	public List<Variable> visit(Subtraction operation) {
		return processArthmeticOperation(operation);
	}

	@Override
	public List<Variable> visit(Multiplication operation) {
		return processArthmeticOperation(operation);
	}

	private List<Variable> processArthmeticOperation(ArithmeticOperation operation) {
		List<Variable> leftResult = operation.getLeftOperand().accept(this);
		List<Variable> rightResult = operation.getRightOperand().accept(this);
		leftResult.addAll(rightResult);
		return leftResult;
	}

}
