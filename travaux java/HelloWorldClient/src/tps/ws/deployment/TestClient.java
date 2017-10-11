package tps.ws.deployment;

import java.rmi.RemoteException;
import tps.ws.deployment.HelloWorldStub.SayHello;


public class TestClient {

	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		HelloWorldStub hwp = new HelloWorldStub();
		SayHello s = new SayHello();
		s.setInput("from client");
		System.out.print(hwp.sayHello(s).get_return());
	}


}
