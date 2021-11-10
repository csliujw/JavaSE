package thread._09_deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁代码
 */
public class DeadLock {
    private ReentrantLock lockA = new ReentrantLock();
    private ReentrantLock lockB = new ReentrantLock();

    public void deadLock1(String lock) {
        if ("lockA".equals(lock)) {
            try {
                lockA.lock();
                System.out.println(Thread.currentThread().getName() + ":持有了lockA的锁");
                TimeUnit.SECONDS.sleep(10);
                lockB.lock();
                System.out.println(Thread.currentThread().getName() + ":持有了lockB的锁");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lockB.unlock();
                System.out.println(Thread.currentThread().getName() + ":释放了lockB的锁");
                lockA.unlock();
                System.out.println(Thread.currentThread().getName() + ":释放了lockA的锁");
            }
        } else {
            try {
                lockB.lock();
                System.out.println(Thread.currentThread().getName() + ":持有了lockB的锁");
                TimeUnit.SECONDS.sleep(10);
                lockA.lock();
                System.out.println(Thread.currentThread().getName() + ":持有了lockA的锁");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lockA.unlock();
                System.out.println(Thread.currentThread().getName() + ":释放了lockA的锁");
                lockB.unlock();
                System.out.println(Thread.currentThread().getName() + ":释放了lockB的锁");
            }
        }
    }

    /**
     * 排查死锁的思路：
     * jsp -l 看哪个类一直在运行，如果一直在运行说明有死锁的可能。
     * 然后对可能的类用jstack pid 查看是否真的出现了死锁。
     * --> Found one Java-level deadlock:
     * =============================
     * "Thread-0":
     * waiting for ownable synchronizer 0x0000000711c01028, (a java.util.concurrent.locks.ReentrantLock$NonfairSync),
     * which is held by "Thread-1"
     * "Thread-1":
     * waiting for ownable synchronizer 0x0000000711c00ff8, (a java.util.concurrent.locks.ReentrantLock$NonfairSync),
     * which is held by "Thread-0"
     * <p>
     * --> Java stack information for the threads listed above:
     * ===================================================
     * <p>
     * Java stack information for the threads listed above:  去定位自己写的代码，看到底是哪里出现了死锁。
     * ===================================================
     * "Thread-0":
     * at jdk.internal.misc.Unsafe.park(java.base@11/Native Method)
     * - parking to wait for  <0x0000000711c01028> (a java.util.concurrent.locks.ReentrantLock$NonfairSync)
     * at java.util.concurrent.locks.LockSupport.park(java.base@11/LockSupport.java:194)
     * at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(java.base@11/AbstractQueuedSynchronizer.java:885)
     * at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireQueued(java.base@11/AbstractQueuedSynchronizer.java:917)
     * at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquire(java.base@11/AbstractQueuedSynchronizer.java:1240)
     * at java.util.concurrent.locks.ReentrantLock.lock(java.base@11/ReentrantLock.java:267)
     * at thread._09_deadlock.DeadLock.deadLock1(DeadLock.java:19)
     * at thread._09_deadlock.DeadLock.lambda$main$0(DeadLock.java:50)
     * at thread._09_deadlock.DeadLock$$Lambda$14/0x0000000800066840.run(Unknown Source)
     * at java.lang.Thread.run(java.base@11/Thread.java:834)
     * "Thread-1":
     * at jdk.internal.misc.Unsafe.park(java.base@11/Native Method)
     * - parking to wait for  <0x0000000711c00ff8> (a java.util.concurrent.locks.ReentrantLock$NonfairSync)
     * at java.util.concurrent.locks.LockSupport.park(java.base@11/LockSupport.java:194)
     * at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(java.base@11/AbstractQueuedSynchronizer.java:885)
     * at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireQueued(java.base@11/AbstractQueuedSynchronizer.java:917)
     * at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquire(java.base@11/AbstractQueuedSynchronizer.java:1240)
     * at java.util.concurrent.locks.ReentrantLock.lock(java.base@11/ReentrantLock.java:267)
     * at thread._09_deadlock.DeadLock.deadLock1(DeadLock.java:34)
     * at thread._09_deadlock.DeadLock.lambda$main$1(DeadLock.java:53)
     * at thread._09_deadlock.DeadLock$$Lambda$15/0x0000000800066c40.run(Unknown Source)
     * at java.lang.Thread.run(java.base@11/Thread.java:834)
     * Found 1 deadlock.
     *
     * @param args
     */
    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(() -> {
            deadLock.deadLock1("lockA");
        }).start();
        new Thread(() -> {
            deadLock.deadLock1("lockB");
        }).start();
    }
}
