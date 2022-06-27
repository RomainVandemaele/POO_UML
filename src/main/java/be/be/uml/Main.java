package be.be.uml;

import be.be.uml.Entities.Person;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Tan","Phan");
        p.speak("Bonjour");
        p.present();
    }
}
