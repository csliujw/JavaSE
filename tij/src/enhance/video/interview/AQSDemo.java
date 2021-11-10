package video.interview;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AQSDemo {
    /**
     * ReentrantLock 中的Node内部类的state包含了状态信息
     */
    public void test1() {
        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("A thread come in");
                try {
                    TimeUnit.MINUTES.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }, "A");

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("B  thread come in");
                try {
                    TimeUnit.MINUTES.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }, "B");

        t1.start();
        t2.start();
    }


    public void test4() {
        new ReentrantReadWriteLock();
    }

    public static void main(String[] args) {
        int i = 1000;
        byte s = (byte) i;
        System.out.println(s);
    }
}
