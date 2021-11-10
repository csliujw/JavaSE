package monitor.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDemo {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantDemo re = new ReentrantDemo();
        Thread th = new Thread(() -> {
            re.m1();
        });
        th.start();
    }

    public void m1() {
        try {
            lock.lock();
            System.out.println("m1");
            m2();
        } finally {
            lock.unlock();
        }
    }

    public void m2() {
        try {
            lock.lock();
            System.out.println("m2");
        } finally {
            lock.unlock();
        }
    }
}
