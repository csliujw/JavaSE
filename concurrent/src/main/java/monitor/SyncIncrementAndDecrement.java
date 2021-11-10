package monitor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.IncrementAndDecrement")
public class SyncIncrementAndDecrement {
    static volatile int count = 0;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread th2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 1000; i++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                        log.debug("{}", ++count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "increment");
        Thread th1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 1000; i++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(23);
                        log.debug("{}", --count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "decrement");

        th1.start();
        th2.start();
        th1.join();
        th2.join();
        log.debug("{}", count);
    }
}
