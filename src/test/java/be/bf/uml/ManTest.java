package be.bf.uml;

import be.bf.uml.entities.Man;
import be.bf.uml.exception.BeardLengthNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ManTest {

    Man m;

    @BeforeEach
    public void init() {
        this.m = new Man("Gérard","Maillot",LocalDate.now().minusYears(25));
    }

    @Test
    public void beardLengthShouldBe3ByDefault() {
        Assertions.assertEquals(m.getBeardLength(),3);
    }

    @Test
    public void shouldChangeBeardLength() {
        final int newLength = 15;
        this.m.setBeardLength(newLength);
        Assertions.assertEquals(this.m.getBeardLength(),newLength);
    }

    @Test
    public void shouldShaveBeard() {
        this.m.shave();
        Assertions.assertEquals(this.m.getBeardLength(),0);
    }

    @Test
    public void cannotHaveNegativeBeardLength() {
        Assertions.assertThrows(BeardLengthNumberException.class ,() -> this.m.setBeardLength(-5) );
    }


    @Test
    public void ageShouldBeCorect() {
        Man m = new Man("Jules","Cesar", LocalDate.of(1990,6,26));
        Assertions.assertEquals(m.getAge(),32);
    }
}
