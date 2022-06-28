package be.bf.uml.entities;

import be.bf.uml.exception.AlreadyMarriedException;
import be.bf.uml.exception.DateFutureException;
import be.bf.uml.exception.MarryYourselfException;
import be.bf.uml.exception.NoDemandException;
import be.bf.uml.utils.ColorText;
import be.bf.uml.utils.Sex;

import java.time.LocalDate;

/**
 * Class representing a person
 * FA Person{firstname,lastname}
 *
 * @attributes firstName int
 * @attribute lastName int
 * @attribute fiance Person
 * @attribute isFiance boolean
 *
 * @invariant firstName not null
 * @invariant nPerson >=0
 * @invarianr birthday present or past date
 */
public abstract class Person {
    protected String firstName;
    protected String lastName;

    protected Person fiance;
    protected boolean isFianced = false;

    private static int nPerson = 0;

    private LocalDate birthday;


    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        Person.nPerson++;
    }

    public Person(String firstName, String lastName, LocalDate birthday) {
        this(firstName,lastName);
        this.setBirthday(birthday);
    }

    public Person(String firstName) {
        this(firstName,"");
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

    public static void displayNPerson() {
        StringBuilder sb = new StringBuilder("There is ");
        sb.append(Person.nPerson).append(" persons");
        System.out.println(sb.toString());
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if(birthday==null) throw new NullPointerException();
        if(!birthday.isBefore(LocalDate.now())) throw new DateFutureException();
        this.birthday = birthday;
    }

    public void displayAge() {
        System.out.printf("I am %d years old\n",this.getAge());
    }

    public int getAge() throws NullPointerException {
        if(this.birthday == null) throw new NullPointerException();
        LocalDate now = LocalDate.now();
        int age =  now.getYear() - this.birthday.getYear();
        if( (now.getMonthValue() > this.birthday.getMonthValue() ) ||
                (   (now.getMonthValue() == this.birthday.getMonthValue()) &&  now.getDayOfMonth() > birthday.getDayOfMonth() )  ) {
            age--;
        }
        return age;
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

    public void askInMarriage(Person person) throws NullPointerException,MarryYourselfException{
        if(person==null) throw new NullPointerException();
        if(person==this) throw new MarryYourselfException();
        if(this.isFianced) throw new AlreadyMarriedException();

        System.out.println("Will you marry me " + person  + " ?");
        this.setFiance(person);
        //this.isFianced = true;
        person.setFiance(this);
        //person.isFianced = true;
    }

    public void answerMarriageDemand(boolean answer) throws NoDemandException {
        if(this.fiance!=null) {
            System.out.println("The answer is " + (answer?"yes":"no"));
            if(!answer) {
                System.out.println(this.firstName + " is not engaged");
                this.fiance.isFianced = false;
                this.isFianced = false;
                this.fiance.setFiance(null);
                this.setFiance(null);
            }else {
                this.isFianced = true;
                this.fiance.isFianced = true;
                System.out.println(this.firstName + " is engaged to "+ this.fiance);
            }
        }else  {
            throw new NoDemandException();
        }
    }

    public void setFiance(Person person) {
        this.fiance = person;
    }

    public void giveMarritalStatus(){
        if(this.isFianced) {
            System.out.println(this.firstName + " is engaged");
            System.out.println("Engaged to : "+this.fiance);
        }else if(this.fiance!=null) {
            System.out.println(this.firstName + " has a marriage demand ");
            System.out.println("demand from : "+this.fiance);
        }else {
            System.out.println(this.firstName + " is not engaged");
        }
    }

    public static void whoAreYou() {
        System.out.println("I am a person");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(firstName).append(' ');
        sb.append(lastName).append(' ');
        return sb.toString();
    }
}
