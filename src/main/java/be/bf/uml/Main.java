package be.bf.uml;

import be.bf.uml.entities.Man;
import be.bf.uml.entities.Woman;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Woman w= new Woman("Cleopatre","D'Egypte",false);
        Man m = new Man("Jules","Cesar");

        Woman.whoAreYou();
        w.present();
        Man.whoAreYou();
        m.present();

    }
}
