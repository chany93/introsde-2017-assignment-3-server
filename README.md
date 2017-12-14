# introsde-2017-assignment-3-server

## 1. Identification

Giovanni Rafael Vuolo giovannirafael.vuolo@studenti.unitn.it

My Server: https://assignsde2.herokuapp.com/assign2


### 2. Project

This is a SOAP server, with People and Activities. A person can have a number of Activities(0 to n), to be stored as preferred activities. 
It is possible to perform all the CRUD operations for people.

#### 2.1. Code

The project is composed by a _model_,in which reside the entities, a _dao_, which manages the entities and links the database to the _resources_

* _Model_: has the entities People and Acitivity with all their getters and setters and some other methods to handle them, plus an enumetarive class ActivityType (containing the 5 types for the activities)
* _Dao_: has PersonActivityDao, which provides the connection to the database
* _EndPoint_: where resides the Web Service Endpoint Publisher (PeoplePublisher), which publishes the service
* _Soap_: in which there is the interface People and Web Service Endpoint Implementation (PeopleImpl), which implements the interface 
  
#### 2.2. Task
The server can perform the following tasks:

* Method #1: _readPersonList()=> List<Person>_ | lists all the people in the database in the database.
* Method #2: _readPerson(long id) => Person_ | gives all the personal information of the Person identified by {id}.
* Method #3: _updatePerson(Person p) => Person_ | updates the Personal information of the Person identified by {id} (e.g., only the Person's information)
* Method #4: _createPerson(Person p) => Person_ | createse a new Person and return the newly created Person with its assigned id (if a preference is included, create also those values for the new Person).
* Method #5: _deletePerson(Long id)_ | deletes the Person identified by {id} from the database
* Method #6: _readPersonPreferences(Long id, String activity_type) => List<Preference>_ | returns the list of values of {activity_type} for the Person identified by {id}
* Method #7: _readPreferences() => List<Preferences>_ | returns the list of all preferences
* Method #8: _readPersonPreferences(Long id, Long activity_id) => Preference_ | returns the value identified by {activity_id} for a Person identified by {id}
* Method #9: _savePersonPreferences(Long id, Activity activity)_ | saves a new Activity {activity} of a Person identified by {id}
* Method #10: _updatePersonPreferences(Long id, Activity activity) => Preference_ | updates the activity identified with {activity.id}, related to the Person identified by {id}
* Method #11: _evaluatePersonPreferences(Long id, Activity activity, int value) => Preference_ | updates the activity identified with {activity.id}, related to the Person identified by {id} with the value that define a specific value of preferences (from 1 to 5) .
* Method #12: _getBestPersonPreference(Long id) => List<Preference>_ | returns the best preference (or preferences if there are more) of the Person identified by {id}  from his/her list of preferences.
 
## 3. Execution

clone the project and type ant execute.server on the terminal (under the project directory

## 4. Additional Notes
