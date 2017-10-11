package testunidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Class1 {
	@Id
	@GeneratedValue
	private String id;

	@OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Class2.class)
	@JoinColumn(name = "class2_id", nullable = false, updatable = false)
	private Class2 class2;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Class3.class)
	@JoinColumn(name = "class1_id", nullable = false)
	private List<Class3> class3List = new ArrayList<Class3>();

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

}
