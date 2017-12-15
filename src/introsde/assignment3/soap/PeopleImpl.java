package introsde.assignment3.soap;


import introsde.assignment3.model.Activity;
import introsde.assignment3.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.jws.WebService;



//Service Implementation

@WebService(endpointInterface = "introsde.assignment3.soap.People",
    serviceName="PeopleService")
public class PeopleImpl implements People {
	
	
	
	//Method#21
    @Override
    public Person readPerson(long id) {
        System.out.println("---> Reading Person by id = "+id);
        Person p = Person.getPersonById(id);
        if (p!=null) {
            System.out.println("---> Found Person by id = "+id+" => "+p.getFirstname());
        } else {
            System.out.println("---> Didn't find any Person with  id = "+id);
        }
        return p;
    }

  //Method#1
    @Override
    public List<Person> readPersonList() {
        return Person.getAll();
    }

    
  //Method#4
    @Override
    public Person createPerson(Person person) {
        Person.savePerson(person);
        return person;
    }

  //Method#3
    @Override
    public Person updatePerson(Person person) {	
        Person.updatePerson(person);
        person = Person.getPersonById(person.getIdPerson());
        return person;
    }

  //Method#5
    @Override
    public long deletePerson(long id) {
        Person p = Person.getPersonById(id);
        if (p!=null) {
            Person.removePerson(p);
            return 0;
        } else {
            return -1;
        }
    }
    
  //Method#6
    @Override
    public List<Activity> readPersonPreferencesByType(long id, String type) {
    	
    		Person person = Person.getPersonById(id);
    	 	System.out.println("Getting activities from person id: " + id);
	    List<Activity> personActivities = new ArrayList<>();
	    personActivities = person.getActivitiesByType(type);
	    return personActivities;
    }
    
  //Method#7
    @Override
    public List<Activity> readPreferences(){
    		return Activity.getAll();
    }
    
  //Method#8
    @Override
    public Activity readPersonPreferencesById(long id, long idActivity) {
    	
		Person person = Person.getPersonById(id);
	 	System.out.println("Getting activities from person id: " + id);
	    List<Activity> personActivities = new ArrayList<>();
	    Activity retAct = new Activity();
	    personActivities = person.getActivitiesById(idActivity);
	    for(Activity act : personActivities) {
	    		retAct = act;
	    }
	    return retAct;
}

  //Method#9
	@Override
	public long savePersonPreferences(long id, Activity activity) {
		
		Person person = Person.getPersonById(id);
		System.out.println("Adding new activity to person with id: " + id);
		activity.setPerson(person);	
		person.setActivity(activity);
		Person.updatePerson(person);
		
		return 0;
	}

	//Method#10
	@Override
	public Activity updatePersonPreferences(long id, Activity activity) {
		
		Person person = Person.getPersonById(id);
		System.out.println("Updating activity: " + activity.getName() + " of person with id: " + id);
		
		Activity.updateActivity(activity);
		//person.setActivity(activity);	
		Person.updatePerson(person);
		
		return activity;
	}

	//Method#11
	@Override
	public Activity evaluatePersonPreferences(long id, Activity activity, int value) {
		
		Person person = Person.getPersonById(id);
	
		
		Map<String, Integer> eval = new HashMap<>();
		eval = person.getEvaluation();
		
		System.out.println("Evaluating activity with id: " + activity.getIdActivity() + " person with id: " + id);
		
			if (0<value && value<6 ) {
				eval.put(activity.getName(), value);
				person.setEvaluation(eval);
				Person.updatePerson(person);
				
			    	String key =activity.getName();
			    	String rating = eval.get(activity.getName()).toString();  
			    	System.out.println(key + " " + rating);  
			    	
			
			}else {
				System.out.println("Rating must be between 1 to 5");
			}
		
		return activity;
	}

	
	//Method#12
	@Override
	public List<Activity> getBestPersonPreferences(long id) {
		
		Person person = Person.getPersonById(id);
		
		List<Activity> bestAct = new ArrayList<>();
		
	
		int count = 0;
		Map<String, Integer> m = new HashMap<>();
		m = person.getEvaluation();
		
		
		Integer largestVal = 0;
		List<Entry<String, Integer>> largestLi = new ArrayList<Entry<String, Integer>>();
		for (Entry<String, Integer> e : m.entrySet()){
			System.out.println(++count + " " + e.getKey().toString() + " " + e.getValue() + " - " + largestVal.compareTo(e.getValue()));
		     if (largestVal == 0 || largestVal  < e.getValue()){
		    	 	System.out.println(largestVal + " largest " + e.getKey());
		         largestVal = e.getValue();
		         System.out.println(largestVal + " largest after");
		         largestLi .clear();
		         largestLi .add(e);
		         System.out.println("if");
		     }else if (largestVal.compareTo(e.getValue()) == 0){
		         largestLi .add(e);
		         System.out.println(largestVal + " largest equal");
		         System.out.println("else");
		     }
		     
		     
		    	}
		for (Map.Entry<String,Integer> ent : largestLi) {
    	    
			//System.out.println(entry.getValue());
			bestAct.add(Activity.getActivityByNameAndPerson(ent.getKey(), id));
		
	        System.out.println(ent.getKey() + " " + ent.getValue());
	    }
		
		
		return bestAct;
	}

	@Override
	public Activity createActivity(Activity activity) {
		 	Activity.saveActivity(activity);
	        return activity;
	}


}