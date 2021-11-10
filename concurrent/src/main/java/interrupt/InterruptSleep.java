package interrupt;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.InterruptSleep")
public class InterruptSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(() -> {
            try {
                log.debug("sleep");
                TimeUnit.SECONDS.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        th1.start();
        TimeUnit.SECONDS.sleep(1);
        log.debug("interrupt");
        th1.interrupt();
        log.debug("打断标记:{}", th1.isInterrupted());
    }
}
