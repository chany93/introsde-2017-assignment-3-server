package introsde.assignment3.soap;

import introsde.assignment3.model.Activity;
import introsde.assignment3.model.Person;


import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface People {
	
    @WebMethod(operationName="readPerson")
    @WebResult(name="person") 
    public Person readPerson(@WebParam(name="idPerson") long id);

    @WebMethod(operationName="readPersonList")
    @WebResult(name="people") 
    public List<Person> readPersonList();

    @WebMethod(operationName="createPerson")
    @WebResult(name="idPerson") 
    public Person createPerson(@WebParam(name="person") Person person);
    
    @WebMethod(operationName="createActivity")
    @WebResult(name="preference") 
    public Activity createActivity(@WebParam(name="idActivity") Activity activity);

    @WebMethod(operationName="updatePerson")
    @WebResult(name="idPerson") 
    public Person updatePerson(@WebParam(name="person") Person person);

    @WebMethod(operationName="deletePerson")
    @WebResult(name="person") 
    public long deletePerson(@WebParam(name="idPerson") long id);
    
    @WebMethod(operationName="readPersonPreferencesByType")
    @WebResult(name="preferences") 
    public List<Activity> readPersonPreferencesByType(@WebParam(name="idPerson") long id,
    														@WebParam(name="type") String type);

    @WebMethod(operationName="readPreferences")
    @WebResult(name="preferences") 
    public List<Activity> readPreferences();
    
    @WebMethod(operationName="readPersonPreferencesById")
    @WebResult(name="preference") 
    public Activity readPersonPreferencesById(@WebParam(name="idPerson") long id, 
    													@WebParam(name="idActivity") long idActivity);

    @WebMethod(operationName="savePersonPreferences")
    @WebResult(name="preference") 
    public long savePersonPreferences(@WebParam(name="idPerson") long id, 
    												@WebParam(name="activity") Activity activity);

    @WebMethod(operationName="updatePersonPreferences")
    @WebResult(name="preference") 
    public Activity updatePersonPreferences(@WebParam(name="idPerson") long id,
    													@WebParam(name="activity") Activity activity);
    
    @WebMethod(operationName="evaluatePersonPreferences")
    @WebResult(name="preference") 
    public Activity evaluatePersonPreferences(@WebParam(name="idPerson") long id, 
    													@WebParam(name="activity") Activity activity,
    													@WebParam(name="value") int value);
   
    @WebMethod(operationName="getBestPersonPreferences")
    @WebResult(name="preferences") 
    public List<Activity> getBestPersonPreferences(@WebParam(name="idPerson") long id);
    
   

}