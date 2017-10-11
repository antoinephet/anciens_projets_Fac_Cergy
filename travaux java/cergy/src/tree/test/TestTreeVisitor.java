package tree.test;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import tree.engine.CalculationVisitor;
import tree.engine.HeigtVisitor;
import tree.engine.SearchConstantVisitor;
import tree.engine.SearchVariableVisitor;
import tree.engine.TreeVisitor;
import tree.model.Constant;
import tree.model.Operation;
import tree.model.Variable;

public class TestTreeVisitor extends TestCase {
	private static Operation tree = TreeUtility.createTree();

	@Test
	public void testCalculationVisitor() {
		TreeVisitor<Integer> visitor = new CalculationVisitor();
		Integer result = tree.accept(visitor);
		assertEquals(Integer.valueOf(-4), result);
	}

	@Test
	public void testConstantVistor() {
		TreeVisitor<List<Constant>> visitor = new SearchConstantVisitor();
		List<Constant> results = tree.accept(visitor);

		assertEquals(3, results.size());

		assertEquals(2, results.get(0).getValue());
		assertEquals(3, results.get(1).getValue());
		assertEquals(4, results.get(2).getValue());
	}

	@Test
	public void testVariableVisitor() {
		TreeVisitor<List<Variable>> visitor = new SearchVariableVisitor();
		List<Variable> results = tree.accept(visitor);

		assertEquals(3, results.size());

		assertEquals("X", results.get(0).getName());
		assertEquals("Y", results.get(1).getName());
		assertEquals("Z", results.get(2).getName());
	}
	
	@Test
	public void testHeightVisitor() {
		HeigtVisitor visitor = new HeigtVisitor();
		tree.accept(visitor);
		
		assertEquals(3, visitor.getHeight());
	}

}
