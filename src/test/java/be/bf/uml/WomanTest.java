package be.bf.uml;

import be.bf.uml.entities.Woman;
import be.bf.uml.exception.NotPregnantException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class WomanTest {

    Woman w;

    @BeforeEach
    void init() {
        this.w = new Woman("Lotte","van Der Bergen", LocalDate.now().minusYears(69));
    }

    @Test
    void isNotPregnant() {
        Assertions.assertFalse(this.w.isPregnant());
    }

    @Test
    void canGetPregnant() {
        this.w.setPregnant(true);
        Assertions.assertTrue(this.w.isPregnant());
    }

    @Test
    void cannotGiveBirthIfNotPregnant() {
        this.w.setPregnant(false);
        Assertions.assertThrows(NotPregnantException.class,() -> this.w.giveBirth());
    }


    @Test
    void notPregnantAfterGivingBirth()  {
        try {
            this.w.setPregnant(true);
            this.w.giveBirth();
            Assertions.assertFalse(this.w.isPregnant());
        } catch (NotPregnantException e) {
            throw new RuntimeException(e);
        }

    }
}
