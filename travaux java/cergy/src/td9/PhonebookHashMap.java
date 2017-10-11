package td9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class PhonebookHashMap implements Phonebook {
	/**
	 * Use contact number as key.
	 */
	private HashMap<String, Contact> contacts = new HashMap<String, Contact>();

	@Override
	public void add(Contact contact) throws ContactAlreadyExistsExceptions {
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
	public String searchName(String number) throws NoSuchElementException {
		Contact contact = contacts.get(number);
		if (contact != null) {
			return contact.getName();
		}
		throw new NoSuchElementException("No contact with number " + number
				+ " found !");
	}

	@Override
	public String searchNumber(String name) throws NoSuchElementException {
		Collection<Contact> values = contacts.values();
		for (Contact contact : values) {
			if (contact.getName().equals(name)) {
				return contact.getNumber();
			}
		}
		throw new NoSuchElementException("No contact with name " + name
				+ " found ! ");
	}

	@Override
	public int getCurrentContactCount() {
		return contacts.size();
	}

	@Override
	public String toString() {
		if (getCurrentContactCount() == 0) {
			return "No contact in the phonebook \n";
		} else {
			String result = "";
			Collection<Contact> values = contacts.values();
			for (Contact contact : values) {
				result += contact.toString() + "\n";
			}
			return result;
		}
	}

	@Override
	public void removeAll() {
		contacts.clear();
	}

	@Override
	public void serializationSave(String fileName) {
		ObjectOutputStream stream;
		try {
			stream = new ObjectOutputStream(new FileOutputStream(fileName));
			for (Contact contact : contacts.values()) {
				stream.writeObject(contact);
			}
			stream.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void serializationRead(String fileName) {
		try {
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(
					fileName));
			Contact contact = null;
			while ((contact = (Contact) stream.readObject()) != null) {
				try {
					add(contact);
				} catch (ContactAlreadyExistsExceptions e) {
					System.err.println(e.getMessage());
				}
			}
			stream.close();
		} catch (EOFException e) {
			// No message predefined, we have to write here our own message.
			System.out.println("End of file reading");
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void textSave(String fileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			for (Contact contact : contacts.values()) {
				writer.write(contact.getName() + ";" + contact.getNumber() + ";"
						+ contact.getEmail());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void textRead(String fileName) {
		String line, fields[];
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while ((line = reader.readLine()) != null) {
				fields = line.split(";");
				Contact contact = new Contact(fields[0], fields[1], fields[2]);
				add(contact);
			}
			reader.close();
		} catch (ContactAlreadyExistsExceptions e) {
			System.err.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
