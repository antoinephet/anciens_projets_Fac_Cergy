package testinheritence;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Run first {@link TestPersist} before running this test.
 */
public class TestQuery {

	public static void main(String[] args) {
		Session session = DBConnection.getSession();
		System.out.println("######### Initial read #############");
		testPolymorphismQuery(session);
		System.out.println("######### Query with parameter #############");
		testWhereClause(session, "Jean");
		testUpdate(session, "Mike", "Dubois");
		testDelete(session, "Dupont");
		System.out.println("######### Read after update and delete #############");
		testPolymorphismQuery(session);
		session.close();
	}

	@SuppressWarnings("rawtypes")
	private static void testPolymorphismQuery(Session session) {
		Transaction readTransaction = session.beginTransaction();
		Query readQuery = session.createQuery("from Person");
		List result = readQuery.list();
		Iterator iterator = result.iterator();
		while (iterator.hasNext()) {
			Person person = (Person) iterator.next();
			System.out.println(person.toString());
		}
		readTransaction.commit();
	}

	@SuppressWarnings("rawtypes")
	private static void testWhereClause(Session session, String firstname) {
		Transaction readTransaction = session.beginTransaction();
		Query readQuery = session.createQuery("from Person p where p.firstname=:firstname");
		readQuery.setString("firstname", firstname);
		List result = readQuery.list();
		Iterator iterator = result.iterator();
		while (iterator.hasNext()) {
			Person person = (Person) iterator.next();
			System.out.println(person.toString());
		}
		readTransaction.commit();
	}
	
	private static void testUpdate(Session session, String newFirstName, String lastname) {
		Transaction updateTransaction = session.beginTransaction();
		Query updateQuery = session.createQuery("update Person p set p.firstname = :firstname where p.lastname=:lastname");
		updateQuery.setString("firstname", newFirstName);
		updateQuery.setString("lastname", lastname);
		updateQuery.executeUpdate();
		updateTransaction.commit();
		
	}
	
	private static void testDelete(Session session, String lastname) {
		Transaction updateTransaction = session.beginTransaction();
		Query updateQuery = session.createQuery("delete Person p where p.lastname=:lastname");
		updateQuery.setString("lastname", lastname);
		updateQuery.executeUpdate();
		updateTransaction.commit();	
	}

}
