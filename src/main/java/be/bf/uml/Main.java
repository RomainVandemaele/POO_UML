package be.bf.uml;

import be.bf.uml.entities.Man;
import be.bf.uml.entities.Person;
import be.bf.uml.entities.Woman;
import be.bf.uml.exception.NoDemandException;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Woman w= new Woman("Cleopatre","D'Egypte", LocalDate.of(1990,10,01));
        try {
            w.answerMarriageDemand(true);
        }catch (NoDemandException e) {
            System.out.println(e.getMessage());
        }

        Man m = new Man("Jules","Cesar",LocalDate.of(1990,6,27));

    }
}
