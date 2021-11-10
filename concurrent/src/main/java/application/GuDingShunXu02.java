package application;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

// 先打印2，在打印1
@Slf4j(topic = "c.GuDingShunXu02")
public class GuDingShunXu02 {

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(() -> {
            LockSupport.park();
            log.debug("1");
        });
        Thread th2 = new Thread(() -> {
            log.debug("2");
            LockSupport.unpark(th1);
        });

        th1.start();
        TimeUnit.SECONDS.sleep(2);
        th2.start();
    }
}
