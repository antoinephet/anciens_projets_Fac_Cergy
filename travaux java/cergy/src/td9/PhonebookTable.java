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
import java.util.NoSuchElementException;

public class PhonebookTable implements Phonebook {
	private Contact[] contacts;
	private int capacity;
	private int currentContactCount;

	public PhonebookTable(int capacity) {
		this.capacity = capacity;
		contacts = new Contact[capacity];
		currentContactCount = 0;
	}

	@Override
	public void add(Contact contact) throws ContactAlreadyExistsExceptions {
		try {
			String number = contact.getNumber();
			searchName(number);
			throw new ContactAlreadyExistsExceptions(number);
		} catch (NoSuchElementException e) {
			if (currentContactCount < capacity) {
				contacts[currentContactCount] = contact;
				currentContactCount++;
			}
		}
	}

	@Override
	public String searchNumber(String name) throws NoSuchElementException {
		for (int i = 0; i <= currentContactCount - 1; i++) {
			Contact contact = contacts[i];
			String contactName = contact.getName();
			if (contactName.equals(name)) {
				return contact.getNumber();
			}
		}
		throw new NoSuchElementException("No contact with name " + name
				+ " found ! ");
	}

	@Override
	public String searchName(String number) throws NoSuchElementException {
		for (int i = 0; i <= currentContactCount - 1; i++) {
			Contact contact = contacts[i];
			String contactNumber = contact.getNumber();
			if (contactNumber.equals(number)) {
				return contact.getName();
			}
		}
		throw new NoSuchElementException("No contact with number " + number
				+ " found !");
	}

	@Override
	public void modifyNumber(String name, String newNumber) {
		for (int i = 0; i <= currentContactCount - 1; i++) {
			Contact contact = contacts[i];
			String contactName = contact.getName();
			if (contactName.equals(name)) {
				contact.setNumber(newNumber);
				break;
			}
		}
	}

	@Override
	public void remove(Contact contact) {
		int indiceToRemove = -1;
		for (int i = 0; i <= currentContactCount - 1; i++) {
			Contact currentContact = contacts[i];
			String name = currentContact.getName();
			String number = currentContact.getNumber();
			if (name.equals(contact.getName()) && number.equals(contact.getNumber())) {
				indiceToRemove = i;
				break;
			}
		}

		if (indiceToRemove != -1) {
			for (int i = indiceToRemove; i <= currentContactCount - 2; i++) {
				contacts[i] = contacts[i + 1];
			}
			contacts[currentContactCount - 1] = null;
			currentContactCount--;
		}
	}

	@Override
	public int getCurrentContactCount() {
		return currentContactCount;
	}

	public String toString() {
		if (getCurrentContactCount() == 0) {
			return "No contact in the phonebook \n";
		} else {
			String result = "";
			for (int i = 0; i <= currentContactCount - 1; i++) {
				result += contacts[i].toString() + "\n";
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
			System.err.println("End of file reading");
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
			for (int index = 0; index < currentContactCount; index++) {
				Contact contact = contacts[index];
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
		for (int index = 0; index < currentContactCount; index++) {
			contacts[index] = null;
		}
		currentContactCount = 0;
	}
}
