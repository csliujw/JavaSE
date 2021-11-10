package video.jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile非原子性的测试
 */
public class VolatileTest {
    public static AtomicInteger race = new AtomicInteger(0);
    private static final int THREAD_COUNT = 20;

    public static void increase() {
        race.getAndIncrement();
    }


    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    increase();
                    System.out.println(race);
                }
            });
            threads[i].start();
        }
        // current thread is willing to yield 当前线程 让步 当前线程为main线程
        while (Thread.activeCount() > 1)
            Thread.yield();
    }
}

