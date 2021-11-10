package monitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.IncrementAndDecrement")
public class IncrementAndDecrement {
    static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread th2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });
        Thread th1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count--;
            }
        });

        th1.start();
        th2.start();
        th1.join();
        th2.join();
        log.debug("{}", count);
    }
}
