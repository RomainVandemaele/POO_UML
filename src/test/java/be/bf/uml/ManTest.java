package be.bf.uml;

import be.bf.uml.entities.Man;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class ManTest {


    public void aeShouldBeCorect() {
        Man m = new Man("Jules","Cesar", LocalDate.of(1990,6,26));
        Assertions.assertEquals(m.getAge(),31);
    }
}
