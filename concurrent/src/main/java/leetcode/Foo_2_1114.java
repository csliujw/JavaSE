package leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 按序打印
 * first、second、third
 */
public class Foo_2_1114 {
    /**
     * 确保 先执行一，一执行后在通知二执行，二执行后再通知三执行。
     * 设置一个 flag，以表示谁可以执行
     * - 2 3 可能先拿到锁，但是不允许执行，此时要放弃锁。
     * - 放弃执行后要确保后面 2 3可以继续执行，直到2 3 分别被执行了一次
     */

    // 法二：纯cas
    static class Foo {
        AtomicInteger atomic = new AtomicInteger(1);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            atomic.getAndIncrement();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (atomic.get() != 2) Thread.yield();
            printSecond.run();
            atomic.getAndIncrement();
        }


        public void third(Runnable printThird) throws InterruptedException {
            while (atomic.get() != 3) Thread.yield();
            printThird.run();
        }
    }

}
