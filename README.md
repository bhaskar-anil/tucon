# tucon
task solution

How to run:
It is a Spring Boot (microservice) project
Can be build using pom.xml

Or simple run the uploaded fat jar
Visit http://locathost:8080
For cab request - http://locathost:8080/book

Solution:
Following are the main classes for the application:

Fube (Cab/Customer)
  - Identity (Plate Number/ Phone Number)
  - Location (Location of Cab/Customer)
  - CarType (Type of a cab/ Choice of the customer)
  - isAvailabe (Is cab/customer alloted)
  - a flag to differentiate between Cab/Customer
  
 Location
  - Latitude
  - Longitude
  
 Constants
 CarType: LIMO, SPORTS etc.
 isAvailabe: SEEKING, ALLOTED.
 
 Main utility methods:
 Finding a nearest cab: (Greedy Algorithm) Time Complexity: O(n), where n is the number of availabe cabs
 
 //get all availabe cabs (with choice type, if customer has a choice)
 //iterate through the list of cabs
 //return the cab which is nearest
