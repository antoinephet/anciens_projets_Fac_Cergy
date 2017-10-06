package engine;

import java.util.ArrayList;
import java.util.List;

import model.Addition;
import model.ArithmeticOperation;
import model.Constant;
import model.Multiplication;
import model.Subtraction;
import model.Variable;

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
