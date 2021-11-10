package monitor.lock_condition;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.TestLiveLock")
public class TestLiveLock {
    static volatile int count = 10;
    static final Object lock = new Object();

    public static void main(String[] args) {
        Thread th1 = new Thread(() -> {
            while (count > 0) {
                TestLiveLock.sleeps(1);
                count--;
                log.debug("{}", count);

            }
        }, "increment");

        Thread th2 = new Thread(() -> {
            while (count < 20) {
                TestLiveLock.sleeps(1);
                count++;
                log.debug("{}", count);
            }
        }, "decrement");
        th1.start();
        th2.start();
    }

    public static void sleeps(long time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
