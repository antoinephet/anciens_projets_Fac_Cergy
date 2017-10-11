package outils;

public class BoundedCounter extends Counter implements Counting {
	private int max;

	public BoundedCounter(int value, int max) {
		super(value);
		this.max = max;
	}

	@Override
	public void increment() throws LimitReachedException{
		if (getValue() < max) {
			super.increment();
		} else {
		    throw new LimitReachedException(max);
		}
	}

	public int getMax() {
		return max;
	}

}
