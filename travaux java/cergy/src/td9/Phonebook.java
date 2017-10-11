package td9;

import java.util.NoSuchElementException;

public interface Phonebook {
	void add(Contact contact) throws ContactAlreadyExistsExceptions;

	void remove(Contact contact);
	
	void removeAll();

	void modifyNumber(String name, String newNumber);

	String searchName(String number) throws NoSuchElementException;

	String searchNumber(String name) throws NoSuchElementException;

	int getCurrentContactCount();
	
	void serializationSave(String fileName);

	void serializationRead(String fileName);

	void textSave(String fileName);

	void textRead(String fileName);
	

}
