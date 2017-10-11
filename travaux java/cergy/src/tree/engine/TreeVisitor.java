package tree.engine;

import tree.model.Addition;
import tree.model.Constant;
import tree.model.Multiplication;
import tree.model.Subtraction;
import tree.model.Variable;

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