package be.bf.uml;

import be.bf.uml.entities.Man;
import be.bf.uml.entities.Person;
import be.bf.uml.entities.Woman;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        Woman w= new Woman("Cleopatre","D'Egypte",false);
        Man m = new Man("Jules","Cesar");

        Woman.whoAreYou();
        w.present();
        w.see();
        w.listen();

        Man.whoAreYou();
        m.present();
        m.see();
        m.listen();

    }
}
