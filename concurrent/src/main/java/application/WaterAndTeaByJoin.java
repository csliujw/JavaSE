package application;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 多线程案例。烧水泡茶。用 join 实现。
 */
@Slf4j(topic = "c.WaterAndTea")
public class WaterAndTeaByJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(() -> {
            try {
                log.debug("洗水壶");
                TimeUnit.SECONDS.sleep(1);
                log.debug("烧开水");
                TimeUnit.SECONDS.sleep(15);
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long start = System.currentTimeMillis();
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        long end = System.currentTimeMillis();
        log.debug("over~ {}", end - start);
    }
}
