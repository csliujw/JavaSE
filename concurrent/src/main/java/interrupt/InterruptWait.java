package interrupt;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.InterruptSleep")
public class InterruptWait {
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    log.debug("wait");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        th1.start();
        TimeUnit.SECONDS.sleep(1);
        th1.interrupt();
        log.debug(String.valueOf(th1.isInterrupted()));
    }

}
