package be.bf.uml;

import be.bf.uml.entities.Man;
import be.bf.uml.entities.Woman;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Woman w= new Woman("Cleopatre","D'Egypte",false);
        Man m = new Man("Jules","Cesar");

        System.out.println(Woman.SEX);
        System.out.println(Man.SEX);

    }
}
