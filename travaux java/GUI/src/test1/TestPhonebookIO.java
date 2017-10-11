package test1;

import java.util.NoSuchElementException;




public class TestPhonebookIO {

    public static void main(String[] args) {
//        Phonebook phonebook = new PhonebookTable(100);
//         Phonebook phonebook = new PhonebookArrayList();
         Phonebook phonebook = new PhonebookHashMap();

        Contact jean = new Contact("Jean", "0612121212", "jean@gmail.com");
        Contact paul = new Contact("Paul", "0618181818", "paul@yahoo.com");
        Contact luc = new Contact("Luc", "0646985221", "luc@msn.com");

        try {
            phonebook.add(jean);
            phonebook.add(paul);
            phonebook.add(luc);
        } catch (ContactAlreadyExistsExceptions e) {
            System.err.println(e.getMessage());
        }
        
        try {
            System.out.println("########## Add ################");
            System.out.println("There are "
                    + phonebook.getCurrentContactCount()
                    + " contacts in the phonebook");
            System.out.println(phonebook.toString());

            System.out.println("########## Search ################");
            System.out.println("Paul's number is "
                    + phonebook.searchNumber("Paul"));
            System.out.println("The owner of number 0646985221 is "
                    + phonebook.searchName("0646985221") + "\n");

            System.out.println("########## Modify ################");
            phonebook.modifyNumber("Paul", "0678787878");
            System.out.println("Paul's new number is "
                    + phonebook.searchNumber("Paul") + "\n");
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("########## Remove ################");
        Contact paul2 = new Contact("Paul", "0678787878", "paul@yahoo.com");
        phonebook.remove(paul2);
        System.out.println("There are " + phonebook.getCurrentContactCount()
                + " contacts in the phonebook");
        System.out.println(phonebook.toString());

    
        
        System.out.println("Before saving in the file");
        System.out.println(phonebook.toString());
        
        
        phonebook.textSave("contacts.txt");
//        phonebook.serializationSave("contacts.ser");
        
        phonebook.removeAll();
        System.out.println("After removing in the phonebook");
        System.out.println(phonebook.toString());
        
        phonebook.textRead("contacts.txt");
//        phonebook.serializationRead("contacts.ser");
        
        System.out.println("After reading frome the file");
        System.out.println(phonebook.toString());

    }
}
