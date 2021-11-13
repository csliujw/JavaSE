package leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar_3_1115 {
    /**
     * 两个线程通信的问题。交替执行，要确保 foo 先执行。
     * Semaphore 控制执行顺序
     */
    static class FooBar {
        private int n;

        volatile boolean flag = true;
        Semaphore foo = new Semaphore(0);
        Semaphore bar = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                printFoo.run();
                bar.release();
                foo.acquire();
            }

        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                bar.acquire();
                printBar.run();
                foo.release();
            }
        }
    }
}