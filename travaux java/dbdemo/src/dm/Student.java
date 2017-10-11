package dm;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String firstname;
	private String number;
	private int age;
	private List<Course> courses = new ArrayList<Course>();

	public String getFirstname() {
		return firstname;
	}

	public String getNumber() {
		return number;
	}

	public int getAge() {
		return age;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		if (!courses.contains(course)) {
			courses.add(course);
		} 
	}

	@Override
	public String toString() {
		StringBuffer allCourses = new StringBuffer();
		for (Course course : courses) {
			allCourses.append(course.toString() + "\n");
		}
		return "Student [firstname=" + firstname + ", number=" + number + ", age=" + age + ", courses=" + allCourses + "]";
	}

}
