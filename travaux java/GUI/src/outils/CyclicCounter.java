package outils;

public class CyclicCounter extends BoundedCounter implements Counting {

	public CyclicCounter(int value, int max) {
		super(value, max);
	}

	@Override
	public void increment() throws LimitReachedException{
		if (getValue() < getMax()) {
			super.increment();
		} else {
			setValue(0);
			throw new LimitReachedException(getMax());
		}
	}

	@Override
	public void decrement() throws LimitReachedException{
		if (getValue() > 0) {
			super.decrement();
		} else {
			setValue(getMax());
			throw new LimitReachedException(0);
		}
	}

}
