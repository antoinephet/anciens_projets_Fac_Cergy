package testinheritence;

import javax.persistence.Entity;

@Entity
public class Teacher extends Person {
	private String major;

	public Teacher() {

	}

	public Teacher(String firstname, String lastname, String major) {
		super(firstname, lastname);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return super.toString() + "-Teacher [major=" + major + "]";
	}

}
