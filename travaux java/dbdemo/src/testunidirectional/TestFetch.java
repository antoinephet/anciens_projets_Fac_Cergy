package testunidirectional;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Run first {@link TestCascadePersist} before running this test.
 */
public class TestFetch {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		Query readQuery = session.createQuery("from Class1");
		List result = readQuery.list();
		Class1 class1 = (Class1) result.get(0);
		
		Class2 class2 = class1.getClass2();
		System.out.println(class2.getId());
		
		Class3 class3 = class1.getClass3List().get(1);
		System.out.println(class3.getId());

		readTransaction.commit();
		session.close();
	}

}
