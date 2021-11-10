package monitor.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptiblyDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread th = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                System.out.println("被打断的 Exception");
            } finally {
                lock.unlock();
            }
        });
        th.start();
        // 打断 lock 锁
        th.interrupt();
    }
}
