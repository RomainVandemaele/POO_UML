package be.bf.uml.entities;

import be.bf.uml.utils.Sex;

/**
 * Class representing a man extending Person
 * FA Man{firstName,lastName,beardLength}
 *
 * @attribute beardLength int represents beard length
 *
 * @invariant beardLength >= 0
 * @invariant nMan >=0
 */
public class Man extends Person{

    private int beardLength = 3;
    public static Sex SEX = Sex.Man;

    private static int nMan = 0;


    public Man(String firstName) {
        this(firstName,"");
    }

    public Man(String firstName, String lastName) {
        super(firstName, lastName);
        Man.nMan++;
    }


    public Man(String firstName, String lastName, int beardLength) {
        this(firstName, lastName);
        this.beardLength = beardLength;
    }

    public int getBeardLength() {
        return beardLength;
    }

    public void setBeardLength(int beardLength) {
        if(beardLength < 0) return;
        this.beardLength = beardLength;
    }

    public static void displayNMan() {
        StringBuilder sb = new StringBuilder("There is ");
        sb.append(Man.nMan).append(" men");
        System.out.println(sb.toString());
    }

    public void shave() {
        setBeardLength(0);
    }


    public static void whoAreYou() {
        Person.whoAreYou();
        System.out.println("I am a man");
    }
}
