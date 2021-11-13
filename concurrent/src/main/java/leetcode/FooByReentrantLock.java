package leetcode;

import java.util.concurrent.locks.ReentrantLock;

public class FooByReentrantLock {
    /**
     * ReentrantLock 实现顺序打印
     */
    static class Foo {
        ReentrantLock lock = new ReentrantLock();
        int count = 1;

        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            while (count < 4) {
                try {
                    lock.lock();
                    if (count == 1) {
                        printFirst.run();
                        count++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (count < 4) {
                try {
                    lock.lock();
                    if (count == 2) {
                        printSecond.run();
                        count++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (count < 4) {
                try {
                    lock.lock();
                    if (count == 3) {
                        printThird.run();
                        count++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
