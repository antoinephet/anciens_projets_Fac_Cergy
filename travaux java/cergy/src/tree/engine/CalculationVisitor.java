package tree.engine;

import tree.data.VariableRepository;
import tree.model.Addition;
import tree.model.Constant;
import tree.model.Multiplication;
import tree.model.Subtraction;
import tree.model.Variable;

/**
 * @author Tianxiao.Liu@u-cergy.fr
 **/
public class CalculationVisitor implements TreeVisitor<Integer> {

	@Override
	public Integer visit(Constant operation) {
		return operation.getValue();
	}

	@Override
	public Integer visit(Variable operation) {
		VariableRepository variableRepository = VariableRepository.getInstance();
		return variableRepository.search(operation);
	}

	@Override
	public Integer visit(Addition operation) {
		Integer leftResult = operation.getLeftOperand().accept(this);
		Integer rightResult = operation.getRightOperand().accept(this);
		return leftResult + rightResult;
	}

	@Override
	public Integer visit(Subtraction operation) {
		Integer leftResult = operation.getLeftOperand().accept(this);
		Integer rightResult = operation.getRightOperand().accept(this);
		return leftResult - rightResult;
	}

	@Override
	public Integer visit(Multiplication operation) {
		Integer leftResult = operation.getLeftOperand().accept(this);
		Integer rightResult = operation.getRightOperand().accept(this);
		return leftResult * rightResult;
	}

}
