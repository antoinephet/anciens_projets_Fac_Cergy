package test1;

public class ContactAlreadyExistsExceptions extends Exception {
	public ContactAlreadyExistsExceptions(String number) {
		super("The contact with number " + number + " already exists !");
	}
}
