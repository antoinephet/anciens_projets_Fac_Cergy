package transaction;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "complex_person_table")
@SecondaryTable(name = "person_detail")
public class ComplexPerson {
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "first", column = @Column(name = "person_firstname", length = 50)),
			@AttributeOverride(name = "last", column = @Column(name = "person_lastname", length = 50)) })
	private Name name;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "number", column = @Column(name = "street_number", length = 50)) })
	private Address address;

	@Enumerated(EnumType.ORDINAL)
	private Gender gender;

	@Column(table = "person_detail", name = "birthdate")
	@Temporal(TemporalType.DATE)
	private Date birthdate;

	@Column(table = "person_detail", name = "portrait")
	@Lob 
	@Basic(fetch = FetchType.LAZY)
	private byte[] portrait;

	public ComplexPerson() {
	}

	public ComplexPerson(Name name, Address address, Gender gender, Date birthdate) {
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.birthdate = birthdate;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public byte[] getPortrait() {
		return portrait;
	}

	public void setPortrait(byte[] portrait) {
		this.portrait = portrait;
	}

	@Override
	public String toString() {
		return "ComplexPerson [name=" + name + ", address=" + address + ", gender=" + gender + ", birthdate=" + birthdate + "]";
	}

}
