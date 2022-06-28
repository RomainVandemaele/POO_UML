package be.bf.uml.entities;

import be.bf.uml.exception.NotPregnantException;
import be.bf.uml.utils.ColorText;
import be.bf.uml.utils.Sex;

import java.security.SecureRandom;
import java.time.LocalDate;


/**
 * Class representing a woman extending Person abstract class
 * FA Woman{FirstName, lastName, isPregnant}
 *
 * @attribute isPregnant boolean
 * @invariant nWoman >=0
 */
public class Woman extends Person implements Sense{

    private boolean isPregnant = false;

    public static Sex SEX = Sex.Woman;
    private static int nWoman = 0;

    public Woman(String firstName) {
        this(firstName,"");
    }

    public Woman(String firstName, String lastName) {
        this(firstName,lastName,false);
    }

    public Woman(String firstName, String lastName, LocalDate birthday) {
        this(firstName,lastName);
        this.setBirthday(birthday);
    }

    public Woman(String firstName, String lastName, boolean isPregnant) {
        super(firstName, lastName);
        this.isPregnant = isPregnant;
        Woman.nWoman++;
    }

    public boolean isPregnant() {
        return this.isPregnant;
    }

    public void setPregnant(boolean isPregnant) {
        this.isPregnant  = isPregnant;
    }

    public static void displayNWoman() {
        StringBuilder sb = new StringBuilder("There is ");
        sb.append(Woman.nWoman).append(" women");
        System.out.println(sb.toString());
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
    public void giveBirth() throws  NotPregnantException {
        if(!this.isPregnant()) throw new NotPregnantException();
        SecureRandom sr = new SecureRandom();
        boolean isBoy = sr.nextBoolean();
        if(isBoy) {
            System.out.println(ColorText.BLUE + "It is a boy" + ColorText.RESET);
        }else {
            System.out.println(ColorText.RED + "It is a girl" + ColorText.RESET);
        }
        setPregnant(false);
    }

    public static void whoAreYou() {
        Person.whoAreYou();
        System.out.println("I am a woman");
    }

    @Override
    public void listen() {
        System.out.println("I listen to everything");
    }

    @Override
    public void see() {
        System.out.println("I see everything");
    }
}
