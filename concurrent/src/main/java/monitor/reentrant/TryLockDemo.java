package monitor.reentrant;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "c.TryLockDemo")
public class TryLockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread th = new Thread(() -> {
            try {
                if (!lock.tryLock()) {
                    log.debug("拿不到锁");
                    System.out.println("我不要锁了");
                    return;
                }
                log.debug("获取到了锁");
            } finally {
                lock.unlock();
            }
        }, "线程1");
        Thread th2 = new Thread(() -> {
            try {
                if (!lock.tryLock()) {
                    log.debug("拿不到锁");
                    return;
                }
                log.debug("获取到了锁");
            } finally {
                lock.unlock();
            }
        }, "线程2");
        th.start();
        th2.start();
    }
}
