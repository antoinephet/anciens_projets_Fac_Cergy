package tree.data;

import log.LoggerUtility;

import org.apache.log4j.Logger;

import tree.model.*;

/**
 * @author Tianxiao.Liu@u-cergy.fr
 **/
public class OperationFactory {
	private static Logger logger = LoggerUtility.getLogger(OperationFactory.class);

	public static Constant create(int value) {
		logger.info("Create constant " + value);
		return new Constant(value);
	}

	public static Variable create(String name, int initialValue) {
		Variable variable = new Variable(name);
		VariableRepository variableRepository = VariableRepository.getInstance();
		variableRepository.register(variable, initialValue);
		logger.info("Create variable " + variable.toString());
		return variable;

	}

	public static ArithmeticOperation create(char type, Operation leftOperand, Operation rightOperand) throws IllegalArithmeticOperationException {
		logger.fatal("Create operation " + type);
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
