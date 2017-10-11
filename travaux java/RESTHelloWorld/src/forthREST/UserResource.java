package forthREST;
 
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
 
public class UserResource extends ServerResource {  	
	@Get  
	public String toString() {
		String uid = (String) getRequestAttributes().get("uid");
		return "Information about user \"" + uid + "\" is: <nothing>";  
	}  
}  