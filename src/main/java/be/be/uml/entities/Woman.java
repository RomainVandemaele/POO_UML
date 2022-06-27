package be.be.uml.entities;

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
        super(firstName);
    }

    public Woman(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Woman(String firstName, String lastName, boolean isPregnant) {
        super(firstName, lastName);
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
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        setPregnant(false);
        SecureRandom sr = new SecureRandom();
        boolean isBoy = sr.nextBoolean();
        if(isBoy) {
            System.out.println(ANSI_BLUE + "It is a boy" + ANSI_RESET);
        }else {
            System.out.println(ANSI_RED + "It is a girl" + ANSI_RESET);
        }
    }

}
