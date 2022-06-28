package be.bf.uml;

import be.bf.uml.entities.Man;
import be.bf.uml.entities.Person;
import be.bf.uml.entities.Woman;
import be.bf.uml.exception.BeardLengthNumberException;
import be.bf.uml.exception.DateFutureException;
import be.bf.uml.exception.NoDemandException;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Woman w= new Woman("Cleopatre","D'Egypte", LocalDate.of(1990,10,01));
        try {
            w.askInMarriage(w);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Man m = new Man("Jules","Cesar",LocalDate.of(1990,6,27));
        try {
            m.setBeardLength(-2);
        }catch (BeardLengthNumberException e) {
            System.out.println(e.getMessage());
        }

        try {
            m.setBirthday(LocalDate.of(2023,1,1));
        }catch (DateFutureException e) {
            System.out.println(e.getMessage());
        }

    }
}
