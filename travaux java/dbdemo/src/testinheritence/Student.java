package testinheritence;

import javax.persistence.Entity;

@Entity
public class Student extends Person {
	private String ine;
	private String university;

	public Student() {
	}

	public Student(String firstname, String lastname, String ine, String university) {
		super(firstname, lastname);
		this.ine = ine;
		this.university = university;
	}

	public String getIne() {
		return ine;
	}

	public void setIne(String ine) {
		this.ine = ine;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	@Override
	public String toString() {
		return super.toString() + "-Student [ine=" + ine + ", university=" + university + "]";
	}
	
}
