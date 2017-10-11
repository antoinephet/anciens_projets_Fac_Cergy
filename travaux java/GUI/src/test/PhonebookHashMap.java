package test;

import java.util.Collection;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class PhonebookHashMap implements Phonebook {
	/**
	 * Use contact number as key.
	 */
	private HashMap<String, Contact> contacts = new HashMap<String, Contact>();

	@Override
	public void add(Contact contact) throws ContactAlreadyExistsExceptions{
		String number = contact.getNumber();
		if (!contacts.containsKey(number)) {
			contacts.put(number, contact);
		} else {
		    throw new ContactAlreadyExistsExceptions(number);
		}
	}

	@Override
	public void remove(Contact contact) {
		contacts.remove(contact.getNumber());
	}

	@Override
	public void modifyNumber(String name, String newNumber) {
		Collection<Contact> values = contacts.values();
		for (Contact contact : values) {
			if (contact.getName().equals(name)) {
				contact.setNumber(newNumber);
			}
		}
	}

	@Override
	public String searchName(String number) throws NoSuchElementException{
		Contact contact = contacts.get(number);
		if (contact != null) {
			return contact.getName();
		} 
		throw new NoSuchElementException("No contact with number " + number + " found !");
	}

	@Override
	public String searchNumber(String name) throws NoSuchElementException{
		Collection<Contact> values = contacts.values();
		for (Contact contact : values) {
			if (contact.getName().equals(name)) {
				return contact.getNumber();
			}
		}
		throw new NoSuchElementException("No contact with name " + name  + " found ! " );
	}

	@Override
	public int getCurrentContactCount() {
		return contacts.size();
	}

	@Override
	public String toString() {
		String result = "";
		Collection<Contact> values = contacts.values();
		for (Contact contact : values) {
			result += contact.toString() + "\n";
		}
		return result;
	}
	
}
