package testinheritence;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestPersist {

	public static void main(String[] args) {
		DataInit.createTables();

		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();
		Person person = new Person("Jean", "Dupont");
		Student student = new Student("Paul", "Dubois", "123456", "ucp");
		Teacher teacher = new Teacher("Luc", "Deschamps", "ia");
		session.persist(person);
		session.persist(student);
		session.persist(teacher);
		persistTransaction1.commit();

		session.close();

	}
}
