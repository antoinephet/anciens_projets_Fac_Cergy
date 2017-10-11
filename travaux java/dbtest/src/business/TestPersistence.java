package business;

import persistence.Address;
import persistence.Person;
import jdbc.JdbcAddressAccess;
import jdbc.JdbcPersonAccess;

public class TestPersistence {
	public static void main(String[] args) {

		JdbcPersonAccess personAccess = new JdbcPersonAccess();
		JdbcAddressAccess addressAccess = new JdbcAddressAccess();

		Address address = new Address("1", "2", "rue Pasteur", "Paris", 75015);
		addressAccess.create(address);

		Person person = new Person("1", "Paul", "Dupont", 25, address);

		personAccess.create(person);

		System.out.println(personAccess.find(person.getId()));

		person.setAge(26);
		personAccess.update(person);

		System.out.println(personAccess.find(person.getId()));

		personAccess.delete(person);
		System.out.println(personAccess.find(person.getId()));

	}

}
