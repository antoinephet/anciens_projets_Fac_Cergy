package service;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cp")
public class Compte implements Serializable {
	
	
	private int code;
	private double solde;
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
	public Compte() {
		super();
	}
	public Compte(int code, double solde) {
		super();
		this.code = code;
		this.solde = solde;
	}
	
	

}
