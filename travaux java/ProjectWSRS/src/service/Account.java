package service;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cp")
// Class named Account
public class Account implements Serializable {
	
	// attributes
	private int code;
	private double solde;
	
	
	// constructor
	public Account() {
		super();
	}
	public Account(int code, double solde) {
		super();
		this.code = code;
		this.solde = solde;
	}
	
	
	// getters and setters
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	

}
