package be.bf.uml.threads;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class TimerThread extends  Thread{

    @Override
    public void run() {
        SecureRandom sr = new SecureRandom();
        int nSec = sr.nextInt(1,10);
        System.out.printf("Thread %d : It's going for %ds\n",this.getId(),nSec);
        try {
            TimeUnit.SECONDS.sleep(nSec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Thread %d : Go after %ds\n",this.getId(),nSec);
    }
}
