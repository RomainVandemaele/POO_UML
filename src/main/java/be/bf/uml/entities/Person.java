package be.bf.uml.entities;

import be.bf.uml.utils.ColorText;

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

    protected Person fiance;
    protected boolean isFianced = false;
    protected String e = "";


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

    public void askInMarriage(Person person) {
        if(person==null) return;
        if(person==this) {
            System.out.println(ColorText.RED + "You cannot marry yourself" + ColorText.RESET);
        }else {
            System.out.println("Will you marry me " + person  + " ?");
        }
    }

    public void answerMarriageDemand(boolean answer) {
        System.out.println("The answer is " + (answer?"yes":"no"));
        this.isFianced = true;
    }

    public void setFiance(Person person) {
        if(person == null) return;
        this.fiance = person;
    }

    public boolean giveMarritalStatus(){
        return this.isFianced;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(firstName).append(' ');
        sb.append(lastName).append(' ');
        return sb.toString();
    }
}
