package tree.data;

import java.util.HashMap;
import java.util.Map;

import tree.model.Variable;

/**
 * @author Tianxiao.Liu@u-cergy.fr
 **/
public class VariableRepository {
	private Map<String, Integer> variables = new HashMap<String, Integer>();

	private VariableRepository() {

	}

	private static VariableRepository instance = new VariableRepository();

	public static VariableRepository getInstance() {
		return instance;
	}

	public void register(Variable variable, int initialValue) {
		variables.put(variable.getName(), initialValue);
	}

	public int search(Variable variable) {
		return variables.get(variable.getName());
	}

}
