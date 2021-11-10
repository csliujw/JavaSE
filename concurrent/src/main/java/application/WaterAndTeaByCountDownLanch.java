package application;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 多线程案例。烧水泡茶。用 CountDownLanch 实现。
 */
@Slf4j(topic = "c.WaterAndTeaByCountDownLanch")
public class WaterAndTeaByCountDownLanch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread th1 = new Thread(() -> {
            try {
                log.debug("洗水壶");
                TimeUnit.SECONDS.sleep(1);
                log.debug("烧开水");
                TimeUnit.SECONDS.sleep(15);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread th2 = new Thread(() -> {
            log.debug("洗茶壶");
            try {
                TimeUnit.SECONDS.sleep(1);
                log.debug("洗茶杯");
                TimeUnit.SECONDS.sleep(2);
                log.debug("洗拿茶叶");
                TimeUnit.SECONDS.sleep(1);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        th1.start();
        th2.start();
        long start = System.currentTimeMillis();
        countDownLatch.await();
        long end = System.currentTimeMillis();
        log.debug("over~ {}", end - start);
    }
}
