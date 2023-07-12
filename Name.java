/*
Date: 10/16/2020
Juan Carlos Alfonso Vina
Class:  CITC 1314    -  Java Programming
Assignment: Lab6 - Using classes and methods
*/

 
class Name {

    private String firstName;
    private String lastName;

    public Name() {
        firstName = "";
        lastName = "";
        
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        
    }
    // Return a String representing FistName
    public String getFirstName() {
        return firstName;
    }
     // Sets the firstName from supplied String parameter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Return a String representing LastName
    public String getLastName() {
        return lastName;
    }

     // Sets the lastName from supplied String parameter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Return a String representing FullName
    public String getFullName() {
        return firstName + " " + lastName;
    }

}
