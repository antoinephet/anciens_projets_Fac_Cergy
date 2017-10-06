package engine;

import model.Addition;
import model.Constant;
import model.Multiplication;
import model.Subtraction;
import model.Variable;

/**
 * @author Tianxiao.Liu@u-cergy.fr
 **/
public interface TreeVisitor<T> {

	T visit(Constant operation);

	T visit(Variable operation);

	T visit(Addition operation);

	T visit(Subtraction operation);

	T visit(Multiplication operation);

}