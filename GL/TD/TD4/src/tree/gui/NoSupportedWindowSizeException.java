package tree.gui;

public class NoSupportedWindowSizeException extends Exception {

	private static final long serialVersionUID = 6283354569704527540L;

	public NoSupportedWindowSizeException(int width) {
		super("The radical parameter Window Width can't be " + width);
	}

}
