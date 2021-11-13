package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Foo_3_1114 {
    /**
     * 使用 JUC 的 ReentrantLock
     * <p>
     * 线程通信 + 有序执行
     * - 有序执行一般通过设置一个 flag 来判断当前线程是否可以执行，
     * 不可以就阻塞，等待唤醒后再判断是否可执行
     */
    static class Foo {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        int flag = 1;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            printFirst.run();
            flag++;
            condition.signalAll(); // 唤醒线程，从 condition 阻塞队列到 AQS 阻塞队列
            lock.unlock();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            while (flag != 2) {
                condition.await();
            }
            printSecond.run();
            flag++;
            condition.signalAll();
            lock.unlock();

        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            while (flag != 3) {
                condition.await();
            }
            printThird.run();
            flag++;
            condition.signalAll();
            lock.unlock();
        }
    }
}
