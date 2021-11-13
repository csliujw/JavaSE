package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Foo_4_1114 {
    /**
     * 使用 JUC 的 ReentrantLock, Condition 精准唤醒
     * <p>
     * 线程通信 + 有序执行
     * - 有序执行一般通过设置一个 flag 来判断当前线程是否可以执行，
     * 不可以就阻塞，等待唤醒后再判断是否可执行
     * <p>
     * Condition 精准唤醒线程，达到精准的顺序执行print。同样，需要好好考虑先拿到锁的线程如何处理：阻塞，唤醒
     */
    static class Foo {
        ReentrantLock lock = new ReentrantLock();
        Condition first = lock.newCondition();
        Condition second = lock.newCondition();
        Condition third = lock.newCondition();
        int flag = 1;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            printFirst.run();
            flag++;
            second.signal(); // 精准唤醒线程 second
            lock.unlock();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            if (flag != 2) { // 确保 first 先执行
                second.await();
            }
            printSecond.run();
            flag++;
            third.signal(); // // 精准唤醒线程 third
            lock.unlock();

        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            if (flag != 3) {
                third.await();
            }
            printThird.run();
            lock.unlock();
        }
    }
}
