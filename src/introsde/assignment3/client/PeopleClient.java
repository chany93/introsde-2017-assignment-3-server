package introsde.assignment3.client;

import introsde.assignment3.model.Activity;
import introsde.assignment3.model.Person;
import introsde.assignment3.soap.People;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class PeopleClient{
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://192.168.1.82:6905/ws/people?wsdl");
        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://soap.assignment3.introsde/", "PeopleService");
        Service service = Service.create(url, qname);
        
        String out = "";

        People people = service.getPort(People.class);
       // people.deletePerson(1);
        
        List<Activity> aList = people.readPreferences();
        for (Activity activity : aList) {
	 		System.out.println("Activity " + activity.getIdActivity() + " => " + activity.getName());
	 	}
	 
       	out = out + "\nMethod #1:" + "\n" 
       			+ "Paramenter: None\n"
       			+ "Response: \n";
       	
        List<Person> pList = people.readPersonList();
     
       
        for(Person person : pList) {
        	 	out = out + "	- Person " + person.getIdPerson() + " in the list ==> "+person.getFirstname();
        	 	for (Activity activity : person.getActivity()) {
        	 		out = out + "		- Activity " + activity.getIdActivity() + " => " + activity.getName();
        	 	}
        }
        /*  
        out = out + "\n=============================\n";
        out = out + "\nMethod #1:" + "\n" 
       			+ "Paramenter: None\n"
       			+ "Response: \n";
        Person p = people.readPerson(1);
        System.out.println("Result ==> "+p);
      
       
        List<Activity> aList = people.readPersonPreferencesByType(1, "Sport");
        System.out.println("Result ==> "+aList);
        for(Activity activity : aList) {
    	 	System.out.println("Activity " + activity.getIdActivity() + " in the list ==> "+activity.getName());
    }
        
         List<Activity> aList = people.readPreferences();
         for(Activity activity : aList) {
     	 	System.out.println("Activity " + activity.getIdActivity() + " in the list ==> "+activity.getName());
         }
         
         
        List<Activity> aList = people.readPersonPreferencesById(3, 4);
        System.out.println("Result ==> "+aList);
        for(Activity activity : aList) {
    	 	System.out.println("Activity " + activity.getIdActivity() + " in the list ==> "+activity.getName());
    }
       
        
     
        people.savePersonPreferences(1, Activity.getActivityById(102));
        aList = people.readPersonPreferencesByType(1, "Work");
        System.out.println("Result ==> "+aList);
        for(Activity activity : aList) {
    	 	System.out.println("Activity " + activity.getIdActivity() + " in the list ==> "+activity.getName());
    }
      
       
        */
     /*   
        people.evaluatePersonPreferences(3, Activity.getActivityById(5),1);
        people.evaluatePersonPreferences(3, Activity.getActivityById(4),4);
        people.evaluatePersonPreferences(3, Activity.getActivityById(6),3);
        
         
        
     
        
     
        
        aList = people.getBestPersonPreferences(3);
       for(Activity activity : aList) {
   	 	System.out.println("Activity " + activity.getIdActivity() + " in the list ==> "+activity.getName());
       
   	 	
       
       } 
        */ 
        System.out.println(out);
    }

	public static void xmlToLog(String text) {
	 	
	    Logger logger = Logger.getLogger("MyLog");
	    FileHandler fh;
	     
	    try {
	         
	        // This block configure the logger with handler and formatter
	        fh = new FileHandler("client-server-xml.log", false);
	        logger.addHandler(fh);
	        //logger.setLevel(Level.ALL);
	        SimpleFormatter formatter = new SimpleFormatter();
	        fh.setFormatter(formatter);
	         
	        // the following statement is used to log any messages
	        logger.info(text);
	         
	    } catch (SecurityException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	}
}
