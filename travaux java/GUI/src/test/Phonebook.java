package test;

import java.util.NoSuchElementException;

public interface Phonebook {
	void add(Contact contact) throws ContactAlreadyExistsExceptions;

	void remove(Contact contact);

	void modifyNumber(String name, String newNumber);

	String searchName(String number) throws NoSuchElementException;

	String searchNumber(String name) throws NoSuchElementException;

	int getCurrentContactCount();

}
