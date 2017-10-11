package thirdREST;
 
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.resource.Directory;
 
public class FileApplication extends Application{
        //use file://[your path]
        //on windows, make sure that you add enough slashes at the beginning, e.g. file:///C:/[your path]
	public static final String ROOT_URI = "file:///[path to your restlet]/docs/api/";
	//for example: public static final String ROOT_URI = "file:///C:/restlet-jee-2.0.6/docs/api/";
 
        //Create an inbound root Restlet that will receive all incoming calls
	@Override  
	public Restlet createInboundRoot() {  
               //return the directory of local resources
               //an instance of Directory is used as initial application Restlet
	       return new Directory(getContext(), ROOT_URI);  
	} 
}