package testbidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Class4 {
	@Id
	@GeneratedValue
	private String id;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Class1.class)
	@JoinTable(name = "class1_class4", joinColumns = @JoinColumn(name = "class1_id"), inverseJoinColumns = @JoinColumn(name = "class4_id"))
	private List<Class1> class1List = new ArrayList<Class1>();

	public Class4() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Class1> getClass1List() {
		return class1List;
	}

	public void setClass1List(List<Class1> class1List) {
		this.class1List = class1List;
	}
	
	

}