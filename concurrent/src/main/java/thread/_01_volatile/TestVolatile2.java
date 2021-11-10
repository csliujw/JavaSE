package thread._01_volatile;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试volatile的原子性
 * Volatile Java虚拟机提供的轻量级同步机制
 * 可见性（及时通知）
 * 不保证原子性
 * 禁止指令重排
 */
public class TestVolatile2 {

    public static void test() throws Exception {
        TestData2 data = new TestData2();
        Thread[] pool = new Thread[20];
        // 初始化20个线程
        for (int i = 0; i < 20; i++) {
            pool[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    data.add();
                }
            });
        }
        // 执行20个线程
        for (int i = 0; i < pool.length; i++) {
            pool[i].start();
        }
        // 这里判断线程数是否大于2，为什么是2？因为默认是有两个线程的，一个main线程，一个gc线程
        // 我用的idea，所以线程数>2的时候说明那20个线程中还有未执行完毕的。eclipse可能略有不同
        // 用CountDownLatch写会好一点
        while (Thread.activeCount() > 2)
            Thread.yield();
        System.out.println(data.number);
    }

    public static void testByCountDownLatch() throws Exception {
        TestData2 data = new TestData2();
        CountDownLatch countDownLatch = new CountDownLatch(20);
        Thread[] pool = new Thread[20];
        // 初始化20个线程
        for (int i = 0; i < 20; i++) {
            pool[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    data.add();
                }
                countDownLatch.countDown();
            });
        }
        // 执行20个线程
        for (int i = 0; i < pool.length; i++) {
            pool[i].start();
        }
        countDownLatch.await();
        System.out.println(data.number);
    }

    public static void main(String[] args) throws Exception {
        // 最后发现结果并不是预期的结果，为什么？
        testByCountDownLatch();
        /**
         *     public void add() {
         *         n++;
         *     }
         *     public void add();
         *     Code:
         *        0: aload_0
         *        1: dup
         *        2: getfield      #2    // Field n:I
         *        5: iconst_1
         *        6: iadd
         *        7: putfield      #2    // Field n:I
         *       10: return
         *       我们能够发现 n++这条命令，被拆分成了3个指令
         *  解决办法：加锁/用原子类替代
         */
    }
}

class TestData2 {
    volatile int number = 0;

    public synchronized void add() {
        this.number++;
    }

    public AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomic() {
        // 先自增，再获得。 还有一个方法是先获得再自增。
        atomicInteger.incrementAndGet();
    }
}
