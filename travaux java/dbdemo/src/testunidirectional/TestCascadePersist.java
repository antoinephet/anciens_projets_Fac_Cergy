package testunidirectional;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestCascadePersist {

	public static void main(String[] args) {
		DataInit.createTables();

		Session session = DBConnection.getSession();
		Transaction persistTransaction = session.beginTransaction();
		Class1 class1 = new Class1();
		Class2 class2 = new Class2();
		class1.setClass2(class2);

		Class3 class3A = new Class3();
		Class3 class3B = new Class3();

		class1.getClass3List().add(class3A);
		class1.getClass3List().add(class3B);

		Class5 class5 = new Class5();
		class2.setClass5(class5);

		Class4 class4A = new Class4();
		Class4 class4B = new Class4();

		class3A.getClass4List().add(class4A);
		class3A.getClass4List().add(class4B);

		class3B.getClass4List().add(class4B);

		session.persist(class1);
		persistTransaction.commit();
		
		session.close();

	}
}
