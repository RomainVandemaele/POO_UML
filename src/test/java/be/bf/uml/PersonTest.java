package be.bf.uml;

import be.bf.uml.entities.Man;
import be.bf.uml.entities.Person;
import be.bf.uml.entities.Woman;
import be.bf.uml.exception.DateFutureException;
import be.bf.uml.exception.NoDemandException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.time.LocalDate;

public class PersonTest {

    Person p;

    @BeforeEach
    public void init() {
        this.p = new Woman("Cleopatre","D'Egypte", LocalDate.of(1990,1,1));
    }

    @Test
    public void constructorArgPassedOk() {
        final String firstName = "Sarah";
        Person p2 = new Woman(firstName);
        Assertions.assertTrue(p2.getFirstName().equals(firstName));
        Assertions.assertTrue(p2.getLastName().equals(""));
    }

    @Test
    public void constructorArgPassedOk2() {
        final String firstName = "Sarah";
        final String lastName = "Sarah";
        Person p2 = new Woman(firstName,lastName);
        Assertions.assertTrue(p2.getFirstName().equals(firstName));
        Assertions.assertTrue(p2.getLastName().equals(lastName));
    }
    @Test
    public void constructorArgPassedOkWithBirthday() {
        final String firstName = "Sarah";
        final String lastName = "Sarah";
        LocalDate birthday = LocalDate.of(1984,1,1);
        Person p2 = new Woman(firstName,lastName,birthday);
        Assertions.assertTrue(p2.getFirstName().equals(firstName));
        Assertions.assertTrue(p2.getLastName().equals(lastName));
        Assertions.assertTrue(p2.getBirthday().isEqual(birthday));
    }

    @Test
    public void constructorArgPassedNotOkWithFutureBirthday() {
        final String firstName = "Sarah";
        final String lastName = "Sarah";
        LocalDate birthday = LocalDate.of(2054,1,1);
        Assertions.assertThrows(DateFutureException.class, () -> new Woman(firstName,lastName,birthday) );
    }

    @Test
    public void ageShouldBeCorrectIfBirthdayPassed() {
        Assertions.assertEquals(p.getAge(),32);
    }

    @Test
    public void ageShouldBeCorrectIfBirthdayNotYetPassed() {
        this.p.setBirthday(LocalDate.of(1990,12,31));
        Assertions.assertEquals(p.getAge(),31);
    }

    @Test
    public void ageShouldBeCorrectIfBirthdayToday() {
        LocalDate birthday = LocalDate.now();
        birthday = birthday.minusYears(15);
        this.p.setBirthday(birthday);
        Assertions.assertEquals(p.getAge(),15);
    }

    @Test
    public void marriageProposal() {
        Woman w= new Woman("Cleopatre","D'Egypte");
        Man m = new Man("Jules","Cesar");
        w.askInMarriage(m);
        Assertions.assertEquals(m.getFiance(),w);
        Assertions.assertEquals(w.getFiance(),m);
    }

    @Test
    public void marriageProposalAndAnswerYes() {
        final Woman w= new Woman("Cleopatre","D'Egypte");
        final Man m = new Man("Jules","Cesar");
        w.askInMarriage(m);
        m.answerMarriageDemand(true);
        Assertions.assertEquals(m.getFiance(),w);
        Assertions.assertEquals(w.getFiance(),m);
    }
    @Test
    public void marriageProposalAndAnswerNo() {
        final Woman w= new Woman("Cleopatre","D'Egypte");
        final Man  m = new Man("Jules","Cesar");
        w.askInMarriage(m);
        m.answerMarriageDemand(false);
        Assertions.assertEquals(m.getFiance(),null);
        Assertions.assertEquals(w.getFiance(),null);
    }

    @Test
    public void answerBeforeDemandShouldCreateException() {
        //Person p = new Woman("Cleopatre","D'Egypte", LocalDate.of(1990,10,01));
        Assertions.assertThrows(NoDemandException.class, () -> p.answerMarriageDemand(true));
        Assertions.assertThrows(NoDemandException.class, () -> p.answerMarriageDemand(false));
    }


}
