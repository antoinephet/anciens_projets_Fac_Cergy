package test;

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
        throw new NoSuchElementException("No contact with name " + name  + " found ! " );
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
        throw new NoSuchElementException("No contact with number " + number + " found !");
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
            if (name.equals(contact.getName())
                    && number.equals(contact.getNumber())) {
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
        String result = "";
        for (int i = 0; i <= currentContactCount - 1; i++) {
            result += contacts[i].toString() + "\n";
        }
        return result;
    }
}
