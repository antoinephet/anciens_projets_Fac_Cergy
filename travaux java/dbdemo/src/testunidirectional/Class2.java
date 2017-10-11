package testunidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Class2 {
	@Id
	@GeneratedValue
	private String id;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Class5.class)
	@JoinColumn(name = "class5_id", nullable = false, updatable = false)
	private Class5 class5;

	public Class2() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Class5 getClass5() {
		return class5;
	}

	public void setClass5(Class5 class5) {
		this.class5 = class5;
	}

}