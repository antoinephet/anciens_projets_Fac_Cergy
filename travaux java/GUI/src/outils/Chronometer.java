package outils;

import javax.naming.ldap.LdapReferralException;

public class Chronometer {
	private Counting hour;
	private Counting minute;
	private Counting second;

	public Chronometer() {
		hour = new CyclicCounter(0, 23);
		minute = new CyclicCounter(0, 59);
		second = new CyclicCounter(0, 59);
	}

	public void increment() {
		try {
			second.increment();
		} catch (LimitReachedException e) {

			try {
				minute.increment();
			} catch (LimitReachedException e1) {
				try {
					hour.increment();
				} catch (LimitReachedException e2) {
					System.err.println("Max of chronometer !");
				}

			}

		}
	}

	public void decrement() {
		try {
			second.decrement();
		} catch (LimitReachedException e) {

			try {
				minute.decrement();
			} catch (LimitReachedException e1) {
				try {
					hour.decrement();
				} catch (LimitReachedException e2) {
					System.err.println("Max of chronometer !");
				}

			}

		}

	}

	public Counting getHour() {
		return hour;
	}

	public Counting getMinute() {
		return minute;
	}

	public Counting getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return "Chromometer [hour=" + hour.getValue() + ", minute="
				+ minute.getValue() + ", second=" + second.getValue() + "]";
	}

}
