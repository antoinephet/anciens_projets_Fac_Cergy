package my.third.rest;
 
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
 
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;
 
public class ClientRequest {
  public static void main(String[] args) {
    String HELLO_REST_URI = "http://localhost:8080/rest";
    ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);  
 
    WebResource service = client.resource(UriBuilder.fromUri(HELLO_REST_URI).build());
 
    //create a form and add to this form information of a user
    Form form = new Form();
    form.add("id", "1");	
    form.add("name", "Mary");
 
    //send this form to the server and get response
    ClientResponse response = service.path("users").type(MediaType.APPLICATION_FORM_URLENCODED)
            .post(ClientResponse.class, form);
    System.out.println(response.getEntity(String.class));
 
  }
} 