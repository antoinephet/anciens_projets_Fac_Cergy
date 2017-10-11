package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Cette classe illustre les opérations de base d'ArrayList, ainsi que les 3
 * façons pour parcourir les éléments : boucle for, Iterator et par indice.
 */
public class PhonebookArrayList implements Phonebook {
	private ArrayList<Contact> contacts = new ArrayList<Contact>();

	@Override
	public void add(Contact contact) throws ContactAlreadyExistsExceptions{
		if (!contacts.contains(contact)) {
			contacts.add(contact);
		} else {
			throw new ContactAlreadyExistsExceptions(contact.getNumber());
		}
	}

	@Override
	public void remove(Contact contact) {
		contacts.remove(contact);
	}

	@Override
	public void modifyNumber(String name, String newNumber) {
		for (Contact contact : contacts) {
			if (contact.getName().equals(name)) {
				contact.setNumber(newNumber);
			}
		}
	}

	@Override
	public String searchName(String number) throws NoSuchElementException{
		Iterator<Contact> iterator = contacts.iterator();
		while (iterator.hasNext()) {
			Contact contact = iterator.next();
			if (contact.getNumber().equals(number)) {
				return contact.getName();
			}
		}
		throw new NoSuchElementException("No contact with number " + number + " found !");
	}

	@Override
	public String searchNumber(String name) throws NoSuchElementException{
		for (int index = 0; index <= contacts.size() - 1; index++) {
			Contact contact = contacts.get(index);
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
		for (int i = 0; i <= contacts.size() - 1; i++) {
			result += contacts.get(i).toString() + "\n";
		}
		return result;
	}

}
