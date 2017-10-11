package dao;

import dm.Student;

public interface StudentDAO {

	Student searchStudent(String name);

	void addStudent(Student student);

	// TODO : A compléter en TD.

}
