package be.bf.uml;

import be.bf.uml.entities.Man;
import be.bf.uml.entities.Person;
import be.bf.uml.entities.Woman;
import be.bf.uml.exception.DateFutureException;
import be.bf.uml.exception.NoDemandException;
import org.junit.jupiter.api.*;


import java.time.LocalDate;
@TestMethodOrder(MethodOrderer.Random.class)
public class PersonTest {

    Person p;

    @BeforeEach
    void init() {
        this.p = new Woman("Cleopatre","D'Egypte", LocalDate.of(1990,1,1));
    }

    @Test
    void constructorArgPassedOk() {
        final String firstName = "Sarah";
        Person p2 = new Woman(firstName);
        Assertions.assertTrue(p2.getFirstName().equals(firstName),"First name should correspond to the constructor first argument");
        Assertions.assertTrue(p2.getLastName().equals(""));
    }

    @Test
    void constructorArgPassedOk2() {
        final String firstName = "Sarah";
        final String lastName = "Sarah";
        Person p2 = new Woman(firstName,lastName);
        Assertions.assertTrue(p2.getFirstName().equals(firstName));
        Assertions.assertTrue(p2.getLastName().equals(lastName));
    }

    @Test
    void constructorArgPassedOkWithBirthday() {
        final String firstName = "Sarah";
        final String lastName = "Sarah";
        LocalDate birthday = LocalDate.of(1984,1,1);
        Person p2 = new Woman(firstName,lastName,birthday);
        Assertions.assertEquals(p2.getFirstName(),firstName);
        Assertions.assertEquals(p2.getLastName(),lastName);
        Assertions.assertEquals(p2.getBirthday(),birthday);
    }

    @Test
    void constructorArgPassedNotOkWithFutureBirthday() {
        final String firstName = "Sarah";
        final String lastName = "Sarah";
        LocalDate birthday = LocalDate.of(2054,1,1);
        Assertions.assertThrows(DateFutureException.class, () -> new Woman(firstName,lastName,birthday) );
    }

    @Test
    void ageShouldBeCorrectIfBirthdayPassed() {
        Assertions.assertEquals(p.getAge(),32);
    }

    @Test
    void ageShouldBeCorrectIfBirthdayNotYetPassed() {
        this.p.setBirthday(LocalDate.of(1990,12,31));
        Assertions.assertEquals(p.getAge(),31);
    }

    @Test
    void ageShouldBeCorrectIfBirthdayToday() {
        LocalDate birthday = LocalDate.now();
        birthday = birthday.minusYears(15);
        this.p.setBirthday(birthday);
        Assertions.assertEquals(p.getAge(),15);
    }

    @Test
    void marriageProposal() {
        Woman w= new Woman("Cleopatre","D'Egypte");
        Man m = new Man("Jules","Cesar");
        w.askInMarriage(m);
        Assertions.assertEquals(m.getFiance(),w);
        Assertions.assertEquals(w.getFiance(),m);
    }

    @Test
    void marriageProposalAndAnswerYes() {
        final Woman w= new Woman("Cleopatre","D'Egypte");
        final Man m = new Man("Jules","Cesar");
        w.askInMarriage(m);
        m.answerMarriageDemand(true);
        Assertions.assertEquals(m.getFiance(),w);
        Assertions.assertEquals(w.getFiance(),m);
    }
    @Test
    void marriageProposalAndAnswerNo() {
        final Woman w= new Woman("Cleopatre","D'Egypte");
        final Man  m = new Man("Jules","Cesar");
        w.askInMarriage(m);
        m.answerMarriageDemand(false);
        Assertions.assertEquals(m.getFiance(),null);
        Assertions.assertEquals(w.getFiance(),null);
    }

    @Test
    void answerBeforeDemandShouldCreateException() {
        //Person p = new Woman("Cleopatre","D'Egypte", LocalDate.of(1990,10,01));
        Assertions.assertThrows(NoDemandException.class, () -> p.answerMarriageDemand(true));
        Assertions.assertThrows(NoDemandException.class, () -> p.answerMarriageDemand(false));
    }


}
