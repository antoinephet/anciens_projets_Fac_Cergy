package transaction;

import org.hibernate.Session;

import utils.DataUtility;

public class TestPerson {

	public static void main(String[] args) {
		DataInit.createTables();

		Session session = DBConnection.getSession();
		//Test persist.
		session.beginTransaction();
		Person person = new Person("Paul", "Dupont", Gender.MALE, DataUtility.createBirthdate(1, 6, 1986), 27);
		session.persist(person);
		session.getTransaction().commit();

		//Test flush.
		session.beginTransaction();
		Person retrievedPerson = (Person) session.get(Person.class, "1");
		System.out.println(retrievedPerson.toString());
		retrievedPerson.setFirstname("Luc");
		session.flush();
		session.getTransaction().commit();
		
		//Test merge.
		session.beginTransaction();
		Person retrievedPerson2 = (Person) session.get(Person.class, "1");
		System.out.println(retrievedPerson.toString());
		session.getTransaction().commit();
		session.close();
		retrievedPerson2.setFirstname("Thierry");
		session = DBConnection.getSession();
		session.beginTransaction();
		session.merge(retrievedPerson2);
		session.getTransaction().commit();
		
		
		//Test delete
		session.clear();
		session.beginTransaction();
		session.delete(retrievedPerson);
		session.getTransaction().commit();
	}
}
