package transaction;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String number;
	private String street;
	private String zipCode;
	private String city;
	private String country;

	public Address() {
	}

	public Address(String number, String street, String zipCode, String city, String country) {
		this.number = number;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [number=" + number + ", street=" + street + ", zipCode=" + zipCode + ", city=" + city + ", country=" + country + "]";
	}

}
