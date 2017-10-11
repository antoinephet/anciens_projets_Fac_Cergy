package transaction;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.DataUtility;

public class TestTransaction extends Thread {
	private int sleepTime;

	public TestTransaction(int sleepTime) {
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		Transaction transaction = null;
		Session session = DBConnection.getSession();
		try {
			transaction = session.beginTransaction();
			Person person = (Person) session.get(Person.class, "1");
			
			long oldVersion = person.getVersion();

			try {
				sleep(sleepTime * 1000);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}

			session.refresh(person);
			long newVersion = person.getVersion();
			if (oldVersion != newVersion) {
				throw new Exception();
			}
			person.setAge(person.getAge() + 1);
			session.flush();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			session.close();
			System.err.println("Dirty update aborted !");
		}
	}

	public static void main(String[] args) {
		DataInit.createTables();

		Session session = DBConnection.getSession();

		session.beginTransaction();
		Person person = new Person("Paul", "Dupont", Gender.MALE, DataUtility.createBirthdate(1, 6, 1986), 27);
		session.persist(person);
		session.getTransaction().commit();
		session.close();

		TestTransaction transaction1 = new TestTransaction(5);
		TestTransaction transaction2 = new TestTransaction(2);
		transaction1.start();
		transaction2.start();

	}
}
