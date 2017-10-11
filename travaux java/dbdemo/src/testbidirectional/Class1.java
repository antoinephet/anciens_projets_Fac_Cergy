package testbidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Class1 {
	@Id
	@GeneratedValue
	private String id;

	@OneToOne(mappedBy="class1", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Class2.class)
	private Class2 class2;

	@OneToMany(mappedBy="class1", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Class3.class)
	private List<Class3> class3List = new ArrayList<Class3>();
	
	@ManyToMany(mappedBy="class1List", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity=Class4.class)
	private List<Class4> class4List = new ArrayList<Class4>();

	public Class1() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Class2 getClass2() {
		return class2;
	}

	public void setClass2(Class2 class2) {
		this.class2 = class2;
	}

	public List<Class3> getClass3List() {
		return class3List;
	}

	public void setClass3List(List<Class3> class3List) {
		this.class3List = class3List;
	}

	public List<Class4> getClass4List() {
		return class4List;
	}

	public void setClass4List(List<Class4> class4List) {
		this.class4List = class4List;
	}
	
	

}
