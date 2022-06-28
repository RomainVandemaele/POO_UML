package be.bf.uml;

import be.bf.uml.entities.Woman;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Woman w= new Woman("Sarah","Van der veeld",false);
        System.out.printf("%s Is pregnant : %b\n",w.getFirstName(),w.isPregnant());
        w.setPregnant(true);
        System.out.printf("%s Is pregnant : %b\n",w.getFirstName(),w.isPregnant());
        w.giveBirth();


        DatingForm df = new DatingForm();
        df.startForm();
    }
}
