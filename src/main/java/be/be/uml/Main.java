package be.be.uml;

import be.be.uml.Entities.Man;
import be.be.uml.Entities.Person;

public class Main {
    public static void main(String[] args) {
        Person p = new Man("Tan","Phan",1);
        p.speak("Hello");
        p.present();
    }
}
