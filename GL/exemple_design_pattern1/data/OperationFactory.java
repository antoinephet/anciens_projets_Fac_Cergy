package data;

import model.*;

/**
 * @author Tianxiao.Liu@u-cergy.fr
 **/
public class OperationFactory {

	public static Constant create(int value) {
		return new Constant(value);
	}

	public static Variable create(String name, int initialValue) {
		Variable variable = new Variable(name);
		VariableRepository variableRepository = VariableRepository.getInstance();
		variableRepository.register(variable, initialValue);
		return variable;

	}

	public static ArithmeticOperation create(char type, Operation leftOperand, Operation rightOperand) throws IllegalArithmeticOperationException {
		switch (type) {
		case '+':
			return new Addition(leftOperand, rightOperand);
		case '-':
			return new Subtraction(leftOperand, rightOperand);
		case '*':
			return new Multiplication(leftOperand, rightOperand);
		default:
			throw new IllegalArithmeticOperationException(type);
		}

	}

}
