package td9;

import java.io.Serializable;

public class Contact implements Serializable {
	private String name;
	private String number;
	private String email;

	public Contact(String name, String number, String email) {
		this.name = name;
		this.number = number;
		this.email = email;
	}

	public Contact(String name, String number) {
		this.name = name;
		this.number = number;
	}

	public String toString() {
		return "Contact [name=" + name + ", number=" + number + ", email=" + email
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			if (obj instanceof Contact) {
				Contact other = (Contact) obj;
				if (name.equals(other.getName()) && number.equals(other.getNumber())) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return number.hashCode();
	}
}