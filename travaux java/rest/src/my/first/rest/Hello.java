package my.first.rest;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
@Path("hello") //set your service url path to <base_url>/hello
               // the <base_url> is based on your application name, the servlet and the URL pattern from the web.xml configuration file
public class Hello {
 
  // This method is called if TEXT_PLAIN is requested
  @GET
  @Produces(MediaType.TEXT_PLAIN) // defines which MIME type is delivered by a method annotated with @GET
  public String sayHelloInPlainText() {		  
    return "Hello world!";
  }
 
  // This method is called if HTML is requested
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHelloInHtml() {
    return "<html> " + "<title>" + "Hello world!" + "</title>"
        + "<body><h1>" + "Hello world!" + "</body></h1>" + "</html> ";
  }
}
