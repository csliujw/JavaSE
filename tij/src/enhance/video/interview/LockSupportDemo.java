package video.interview;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportDemo {

    public void test1() {
        System.out.println("start");
        LockSupport.park();
        System.out.println("part finish");
    }

    public void test2() {
        System.out.println("start");
        LockSupport.unpark(Thread.currentThread());
        System.out.println("unpark");
        LockSupport.park();
        System.out.println("park finish");
    }

    public void test3() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition empty = lock.newCondition();
        Condition full = lock.newCondition();

        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                empty.await();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                lock.lock();
                empty.await();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                lock.lock();
                empty.await();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        });


        Thread t4 = new Thread(() -> {
            try {
                lock.lock();
                full.await();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        });


        Thread t5 = new Thread(() -> {
            try {
                lock.lock();
                full.await();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        TimeUnit.SECONDS.sleep(10);

        System.out.println("123");
        for (; ; ) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockSupportDemo lockSupportDemo = new LockSupportDemo();
        lockSupportDemo.test3();
        new ReentrantLock();
    }
}
