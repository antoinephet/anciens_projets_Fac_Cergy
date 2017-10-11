package training.phetramphand1.chrono.chrono;



/**
 * @author Tianxiao.Liu@u-cergy.fr
 **/
public class Chronometer {
	private CyclicCounter hour;
	private CyclicCounter minute;
	private CyclicCounter second;

	public Chronometer() {
		hour = new CyclicCounter(0, 23, 0);
		minute = new CyclicCounter(0, 59, 0);
		second = new CyclicCounter(0, 59, 0);

	}

	public Chronometer(int hour, int minute, int second) {
		this.hour = new CyclicCounter(hour, 23, 0);
		this.minute = new CyclicCounter(minute, 59, 0);
		this.second = new CyclicCounter(second, 59, 0);

	}

	public void increment() {
		second.increment();
		if (second.getValue() == 0) {
			minute.increment();
			if (minute.getValue() == 0) {
				hour.increment();
			}
		}

	}

	public void decrement() {
		second.decrement();
		if (second.getValue() == 59) {
			minute.decrement();
			if (minute.getValue() == 59) {
				hour.decrement();
			}
		}
	}

	public CyclicCounter getHour() {
		return hour;
	}

	public CyclicCounter getMinute() {
		return minute;
	}

	public CyclicCounter getSecond() {
		return second;
	}

	public String toString() {
		return hour.toString() + " : " + minute.toString() + " : " + second.toString();
	}

	public static String transform(int value) {// Utility
		String result = "";
		if (value < 10) {
			result = "0" + value;
		} else {
			result = String.valueOf(value);
		}
		return result;
	}

	public void init() {
		hour.setValue(0);
		minute.setValue(0);
		second.setValue(0);
	}

}