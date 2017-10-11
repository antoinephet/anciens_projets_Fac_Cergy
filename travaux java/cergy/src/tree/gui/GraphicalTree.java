package tree.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tree.data.IllegalArithmeticOperationException;
import tree.test.TreeUtility;

/**
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class GraphicalTree extends JFrame {

	private static final long serialVersionUID = 5193610496520599151L;
	private JPanel treePanel;

	public GraphicalTree() throws NoSupportedWindowSizeException, IllegalArithmeticOperationException {
		super("Graphical Tree Demo");

		treePanel = new TreePanel(TreeUtility.createTree());

		initLayout();
	}

	private void initLayout() {
		getContentPane().add(treePanel);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public static void main(String[] args) {
		try {
			new GraphicalTree();
		} catch (IllegalArithmeticOperationException e) {
			System.err.println(e.getMessage());
		} catch (NoSupportedWindowSizeException e) {
			System.err.println(e.getMessage());
		}
	}

}
