package leetcode;

/**
 * 按序打印
 * first、second、third
 */
public class Foo_1_1114 {
    /**
     * 确保 先执行一，一执行后在通知二执行，二执行后再通知三执行。
     * 设置一个 flag，以表示谁可以执行
     * - 2 3 可能先拿到锁，但是不允许执行，此时要放弃锁。
     * - 放弃执行后要确保后面 2 3可以继续执行，直到2 3 分别被执行了一次
     */

    // 法一：synchronized wait notifyAll 线程通信；注意 notifyAll 的调用
    // sync 可以 那么 ReentrantLock 也可以。
    static class Foo {
        volatile int flag = 1; // 1 先执行

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (this) {
                printFirst.run();
                flag++;
                this.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (this) {
                while (flag != 2) {
                    this.wait();
                }
                printSecond.run();
                this.notifyAll();
                flag++;
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (this) {
                while (flag != 3) {
                    this.wait();
                }
                printThird.run();
                this.notifyAll();
                flag++;
            }
        }
    }
}
