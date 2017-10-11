package test;

import org.apache.log4j.*;

public class TestLog {

	/**
	 * @param args
	 */
	
	private static final Logger logger = Logger.getLogger(Arbre.class) ;
	private static final String FILE_LOG_CONFIG = "src/log/log4j-file.properties";
	private static final String HTML_LOG_CONFIG = "src/log/log4j-html.properties";
	
	public static Logger getLogger(Class<?> logClass) {
		// TODO Auto-generated method stub
		
		BasicConfigurator.configure();
		PropertyConfigurator.configure("./log4j.prop") ;
		
		PropertyConfigurator.configure(HTML_LOG_CONFIG);
		String className = logClass.getName();
		return Logger.getLogger(className);


	}

}
