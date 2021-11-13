package leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar_2_1115 {
    /**
     * 两个线程通信的问题。交替执行，要确保 foo 先执行。
     * ReentrantLock + flag 判断谁先执行
     */
    static class FooBar {
        private int n;
        ReentrantLock lock = new ReentrantLock();
        Condition foo = lock.newCondition();
        Condition bar = lock.newCondition();

        volatile boolean flag = true;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                if (!flag) {
                    foo.await();
                }
                printFoo.run();
                flag = !flag;
                bar.signal();
                lock.unlock();
            }

        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                if (flag) {
                    bar.await();
                }
                printBar.run();
                flag = !flag;
                foo.signal();
                lock.unlock();
            }

        }
    }
}