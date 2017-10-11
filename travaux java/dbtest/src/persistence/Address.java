package persistence;

public class Address {
	private String id;
	private String number;
	private String street;
	private String city;
	private int postalCode;

	public Address(String id, String number, String street, String city, int postalCode) {
		this.id = id;
		this.number = number;
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
	}

	public Address() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", number=" + number + ", street=" + street + ", city=" + city + ", postalCode=" + postalCode + "]";
	}
}
