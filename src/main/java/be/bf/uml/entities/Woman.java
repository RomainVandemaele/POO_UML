package be.bf.uml.entities;

import be.bf.uml.utils.ColorText;

import java.security.SecureRandom;


/**
 * Class representing a woman extending Person abstract class
 * FA Woman{FirstName, lastName, isPregnant}
 *
 * @attribute isPregnant boolean
 */
public class Woman extends Person{

    private boolean isPregnant = false;

    public Woman(String firstName) {
        this(firstName,"");
    }

    public Woman(String firstName, String lastName) {
        this(firstName,lastName,false);
    }

    public Woman(String firstName, String lastName, boolean isPregnant) {
        super(firstName, lastName);
        this.isPregnant = isPregnant;
        this.e = "e";
    }

    public boolean isPregnant() {
        return this.isPregnant;
    }

    public void setPregnant(boolean isPregnant) {
        this.isPregnant  = isPregnant;
    }

    /**
     * Method allowing woman to stop their pregnancy
     */
    public void abort() {
        setPregnant(false);
    }

    /**
     * Method allowing woman to give birth to a child boy or girl
     */
    public void giveBirth() {
        if(!this.isPregnant()) return;
        setPregnant(false);
        SecureRandom sr = new SecureRandom();
        boolean isBoy = sr.nextBoolean();
        if(isBoy) {
            System.out.println(ColorText.BLUE + "It is a boy" + ColorText.RESET);
        }else {
            System.out.println(ColorText.RED + "It is a girl" + ColorText.RESET);
        }
    }

    public static void whoAreYou() {
        Person.whoAreYou();
        System.out.println("I am a woman");
    }

}
