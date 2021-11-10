package application;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 多线程案例。烧水泡茶。用 CyclicBarrier 实现。
 */
@Slf4j(topic = "c.WaterAndTeaByCyclicBarrier")
public class WaterAndTeaByCyclicBarrier {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            log.debug("开始泡茶");
        });
        Thread th1 = new Thread(() -> {
            try {
                log.debug("洗水壶");
                TimeUnit.SECONDS.sleep(1);
                log.debug("烧开水");
                TimeUnit.SECONDS.sleep(5);
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
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
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        th1.start();
        th2.start();
    }
}
