package leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Foo_5_1114 {
    /**
     * 使用 JUC 的 Semaphore 条件限制执行顺序
     * Semaphore，先拿到许可证的可以先执行。
     * <p>
     * 线程通信 + 有序执行
     */
    static class Foo {
        Semaphore second = new Semaphore(0);
        Semaphore third = new Semaphore(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            // first 先执行，不必阻塞。 second 和 third 如果先执行了会因为拿不到许可证而被阻塞。
            printFirst.run();
            // first 执行完毕后，精准发放许可证，让 second 可以执行
            second.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            second.acquire(); // 如果 2 先执行的话，会被阻塞住，除非有人发放了许可证
            printSecond.run();
            // second 执行完毕后，精准发放许可证，让 second 可以执行
            third.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            third.acquire();
            printThird.run();
        }
    }
}
