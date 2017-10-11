package my.third.rest;
 
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
 
@Path("users") //attach client request to resource: .../users
public class RestResource {
 
	Map<String,User> listUsers;  
 
	//initialize some resources
	public RestResource(){
		listUsers = new HashMap<String,User>();
		listUsers.put("1",new User("1", "John"));
		listUsers.put("2",new User("2", "Peter"));
	}
 
	//return list of users
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String listOfUsersInText(){
		String list="";
		for (Entry<String,User> u:listUsers.entrySet()){
			list += u.getValue().getName() + "\n";
		}
		return list;
	}
 
	//return user information corresponding to the requested uid.
	@GET
	@Path("{uid}") //attach client request to resource: .../users/<uid>
	@Produces(MediaType.TEXT_PLAIN)
	public String getUID(@PathParam("uid") String uid){ //@PathParam is used to inject values from the URL into a method parameter
                                                            // in this way you inject the id of the user into the method to get the correct user
 
		if (!listUsers.containsKey(uid))
			return "User not exist!";
 
		return listUsers.get(uid).getID()+":"+listUsers.get(uid).getName();
	}
	
	@POST
	  @Produces(MediaType.TEXT_HTML)
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED) //@Consumes(type[, more-types]) defines which MIME type is consumed by this method	
	  public String postUser(@FormParam("id") String uid, @FormParam("name") String name) { //@FormParam for POST method acts as @PathParam for GET method 
	    if (listUsers.containsKey(uid)) { 
	    	listUsers.get(uid).setName(name);
	    	return "The user is updated. Current list is: \n" + listOfUsersInText();
	    }
	    listUsers.put(uid, new User(uid, name));
		return "The user is added. Current list is: \n" + listOfUsersInText();
	  }
}