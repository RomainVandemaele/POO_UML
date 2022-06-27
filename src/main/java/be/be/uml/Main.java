package be.be.uml;

import be.be.uml.Entities.Man;
import be.be.uml.Entities.Person;
import be.be.uml.Entities.Woman;

public class Main {
    public static void main(String[] args) {
        Woman w= new Woman("Sarah","Van der veeld",false);
        System.out.printf("%s Is pregnant : %b\n",w.getFirstName(),w.isPregnant());
        w.setPregnant(true);
        System.out.printf("%s Is pregnant : %b\n",w.getFirstName(),w.isPregnant());
        w.giveBirth();

    }
}
