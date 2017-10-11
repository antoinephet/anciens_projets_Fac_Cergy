package my.second.rest;
 
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
 
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


 
public class ClientRequest {
  public static void main(String[] args) {
    String HELLO_REST_URI = "http://localhost:8080/rest";
    ClientConfig config = new DefaultClientConfig(); // DefaultClientConfig()
    Client client = Client.create(config);  
 
    WebResource service = client.resource(UriBuilder.fromUri(HELLO_REST_URI).build());
 
    // Print service status
    System.out.println(service.path("hello").accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).toString());
    // Print response as plain text
    System.out.println(service.path("hello").accept(MediaType.TEXT_PLAIN).get(String.class));
    // Print response as HTML
    System.out.println(service.path("hello").accept(MediaType.TEXT_HTML).get(String.class));
 
  }
}