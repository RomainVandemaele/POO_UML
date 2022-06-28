package be.bf.uml;

import be.bf.uml.entities.Man;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ManTest {


    @Test
    public void ageShouldBeCorect() {
        Man m = new Man("Jules","Cesar", LocalDate.of(1990,6,26));
        Assertions.assertEquals(m.getAge(),31);
    }
}
