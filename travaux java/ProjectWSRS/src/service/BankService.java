package service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path(value="/bank") // enable to use this keyword in order to use this class
public class BankService {
	@GET
	@Path(value="/message")
	@Produces(MediaType.TEXT_PLAIN)
	
	// enable to display a String message
	public String message() {
		
		return "Welcome to the bank";
		
	}
	
	
	@GET
	@Path(value="/conversion/{montant}") // enable to use this keyword in order to use this method
	@Produces(MediaType.APPLICATION_JSON)
	// enable to convert Euro money into Franc money
	public double conversion(@PathParam(value="amount")double mt) {
		
		return mt*6.559;
		
	}
	
	@GET
	@Path(value="/list") // enable to use this keyword in order to use this method
	@Produces(MediaType.APPLICATION_JSON)
	// enable to display elements from a created ArrayList, there are 3 elements here
	public List<String> list() {
		
		List<String> res=new ArrayList<String>(); // create a new Arraylist
		res.add("Mr Dupont"); // add a new element
		res.add("Miss Nottingham");
		res.add("Mr Courtois");
		return res;
	
	}
	
	@GET
	@Path(value="/accounts") // enable to use this keyword in order to use this method
	@Produces(MediaType.APPLICATION_JSON)
	// enable to add new objects type Account and display them
	public List<Account> getAccounts() {
		
		List<Account> accounts=new ArrayList<Account>(); // create a new Arraylist
		accounts.add(new Account(1,10000)); // add a new object, here code=1 solde=10000
		accounts.add(new Account(2,5000)); // add a new object, here code=2 solde=5000
		return accounts;
		
		
	
	}


}
