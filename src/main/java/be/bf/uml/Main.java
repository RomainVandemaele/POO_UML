package be.bf.uml;

import be.bf.uml.entities.Man;
import be.bf.uml.entities.Person;
import be.bf.uml.entities.Woman;
import be.bf.uml.exception.NoDemandException;
import be.bf.uml.threads.TimerThread;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Woman w= new Woman("Cleopatre","D'Egypte", LocalDate.of(1990,10,01));
        Man m = new Man("Jules","Cesar",LocalDate.of(1990,6,27));

        List<Thread> threadList = new ArrayList<>();
        for(int i =0;i<1000;++i) {
                threadList.add(new TimerThread());
                threadList.get(threadList.size()-1).start();
        }
        for(int i =0;i<10;++i) { threadList.get(i).join();}

    }
}
