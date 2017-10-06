package tree.test;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * @author Tianxiao.Liu@u-cergy.fr
 **/
public class TreeTestSuite extends TestSuite {
	private static TreeTestSuite suite() {
		TreeTestSuite testSuite = new TreeTestSuite();
		testSuite.addTestSuite(TestTreeVisitor.class);
		return testSuite;
	}

	public static void main(String[] args) {
		TestRunner.run(suite());
	}

}
