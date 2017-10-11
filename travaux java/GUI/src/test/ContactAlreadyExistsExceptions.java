package test;

public class ContactAlreadyExistsExceptions extends Exception {
	public ContactAlreadyExistsExceptions(String number) {
		super("Contact " + number + " already exists !");
	}
}
