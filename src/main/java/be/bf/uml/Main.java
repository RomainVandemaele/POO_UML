package be.bf.uml;

import be.bf.uml.entities.Man;
import be.bf.uml.entities.Person;
import be.bf.uml.entities.Woman;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Woman w= new Woman("Cleopatre","D'Egypte", LocalDate.of(1990,10,01));
        w.present();
        w.displayAge();
        Man m = new Man("Jules","Cesar",LocalDate.of(1990,6,27));
        m.present();
        m.displayAge();
    }
}
