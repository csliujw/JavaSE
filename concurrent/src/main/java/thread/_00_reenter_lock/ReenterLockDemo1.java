package thread._00_reenter_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁：一个线程连续两次获得同一把锁是允许的
 * 如果同一个线程多次获得锁，那么在释放锁的时候，也必须释放相同次数。
 * 如果释放锁的次数多了，那么会得到一个
 * java.lang.IllegalMonitorStateException异常，
 * 反之，如果释放锁的次数少了，那么相当于线程还持有这个锁，
 * 因此，其他线程也无法进入临界区
 */
public class ReenterLockDemo1 implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    //  临界资源
    public static int i = 0;


    public static void main(String[] args) throws InterruptedException {
        ReenterLockDemo1 reenterLockDemo = new ReenterLockDemo1();
        for (int j = 0; j < 100; j++) {
            Thread thread1 = new Thread(reenterLockDemo);
            Thread thread2 = new Thread(reenterLockDemo);
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            try {
                lock.lock();
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
