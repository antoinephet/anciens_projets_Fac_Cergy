package testunidirectional;

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
public class Class3 {
	@Id
	@GeneratedValue
	private String id;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Class4.class)
	@JoinTable(name = "class3_class4", joinColumns = @JoinColumn(name = "class3_id"), inverseJoinColumns = @JoinColumn(name = "class4_id"))
	private List<Class4> class4List = new ArrayList<Class4>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Class4> getClass4List() {
		return class4List;
	}

	public void setClass4List(List<Class4> class4List) {
		this.class4List = class4List;
	}

	public Class3() {
	}

}