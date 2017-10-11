package testbidirectional;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestCascadePersist {

	public static void main(String[] args) {
		DataInit.createTables();

		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();
		Class1 class1 = new Class1();
		Class2 class2 = new Class2();
		class2.setClass1(class1);
		
		Class3 class3A = new Class3();
		Class3 class3B = new Class3();
		class3A.setClass1(class1);
		class3B.setClass1(class1);
		
		
		Class4 class4A = new Class4();
		Class4 class4B = new Class4();
		class4A.getClass1List().add(class1);
		class4B.getClass1List().add(class1);
		
		//persist class2, class3A, class3B, class4A, class4B, cascade to class1
		session.persist(class2);
		session.persist(class3A);
		session.persist(class3B);
		session.persist(class4A);
		session.persist(class4B);
		persistTransaction1.commit();

		session.close();

	}
}
