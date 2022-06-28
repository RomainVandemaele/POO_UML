package be.bf.uml;

import be.bf.uml.entities.Person;
import be.bf.uml.entities.Woman;
import be.bf.uml.exception.NoDemandException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.time.LocalDate;

public class PersonTest {

    @Test
    public void answerBeforeDemandShouldCreateException() {
        Person p = new Woman("Cleopatre","D'Egypte", LocalDate.of(1990,10,01));
        Assertions.assertThrows(NoDemandException.class, () -> p.answerMarriageDemand(true));
        Assertions.assertThrows(NoDemandException.class, () -> p.answerMarriageDemand(false));
    }
}
