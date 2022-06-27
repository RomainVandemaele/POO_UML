package be.be.uml.Entities;

/**
 * Class representing a person
 * FA Person{firstname,lastname}
 *
 * @attributes firstName int
 * @attribute lastName int
 *
 * @invariant firstName not null
 */
public abstract class Person {
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

    /**
     * Method allowing a person to presents itselfs with its attributes
     */
    public void present() {
        System.out.printf("I am %s %s\n",firstName,lastName);
    }

    /**
     * Method allowing a person to speak with a sentence
     * @param sentence sentence to speak
     */
    public void speak(String sentence) {
        System.out.printf("%s %s says : %s\n",firstName,lastName,sentence);
    }

}
