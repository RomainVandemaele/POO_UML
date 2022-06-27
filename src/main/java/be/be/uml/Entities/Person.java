package be.be.uml.Entities;

public class Person {
    protected String firstName;
    protected String lastName;


    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public Person(String firstName) {
        setFirstName(firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public void present() {
        System.out.printf("I am %s %s\n",firstName,lastName);
    }

    public void speak(String sentence) {
        System.out.printf("%s %s says : %s\n",firstName,lastName,sentence);
    }

}
