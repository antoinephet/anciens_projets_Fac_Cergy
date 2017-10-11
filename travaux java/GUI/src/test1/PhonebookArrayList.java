package test1;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PhonebookArrayList implements Phonebook {
	private ArrayList<Contact> contacts = new ArrayList<Contact>();

	@Override
	public void add(Contact contact) throws ContactAlreadyExistsExceptions {
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
	public String searchName(String number) throws NoSuchElementException {
		Iterator<Contact> iterator = contacts.iterator();
		while (iterator.hasNext()) {
			Contact contact = iterator.next();
			if (contact.getNumber().equals(number)) {
				return contact.getName();
			}
		}
		throw new NoSuchElementException("No contact with number " + number
				+ " found !");
	}

	@Override
	public String searchNumber(String name) throws NoSuchElementException {
		for (int index = 0; index <= contacts.size() - 1; index++) {
			Contact contact = contacts.get(index);
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
			for (int i = 0; i <= contacts.size() - 1; i++) {
				result += contacts.get(i).toString() + "\n";
			}
			return result;
		}
	}

	@Override
	public void serializationSave(String fileName) {
		ObjectOutputStream stream;
		try {
			stream = new ObjectOutputStream(new FileOutputStream(fileName));
			for (Contact contact : contacts) {
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
			for (Contact contact : contacts) {
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

	@Override
	public void removeAll() {
		contacts.clear();
	}

}
