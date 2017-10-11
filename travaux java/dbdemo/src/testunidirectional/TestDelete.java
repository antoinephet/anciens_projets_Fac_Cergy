package testunidirectional;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Run first {@link TestCascadePersist} before running this test.
 */
public class TestDelete {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		Query readQuery = session.createQuery("from Class1");
		List result = readQuery.list();
		Class1 class1 = (Class1) result.get(0);

		session.delete(class1);

		readTransaction.commit();
		session.close();
	}

}
