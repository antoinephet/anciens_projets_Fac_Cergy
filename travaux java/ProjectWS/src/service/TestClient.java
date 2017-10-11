package service;

import java.rmi.RemoteException;

import service.BankServiceStub.Conversion;
import service.BankServiceStub.ConversionResponse;
import service.BankServiceStub.GetAccounts;
import service.BankServiceStub.GetAccountsResponse;
import service.BankServiceStub.Message;

public class TestClient {

	public static void main(String[] args) throws RemoteException{
		// TODO Auto-generated method stub
		
		
		
		BankServiceStub bank = new BankServiceStub();
		Message msg = new Message();
		Conversion c = new Conversion();
		GetAccounts g = new GetAccounts();
		
		c.setMt(15.5); // set decimal number for the convertion
		ConversionResponse res1 = bank.conversion(c);
		GetAccountsResponse res = bank.getAccounts(g);
		System.out.println(res.get_return());
		
		System.out.println(res1.get_return()); // display the convertion


	}

}
