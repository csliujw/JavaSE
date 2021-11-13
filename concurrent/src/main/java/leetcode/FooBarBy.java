package leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class FooBarBy {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        semaphore.acquire();
        semaphore.release();
        CountDownLatch downLatch = new CountDownLatch(2);
        downLatch.countDown();
        System.out.println(123);
    }

    // foo bar foo bar foo bar 交替输出
    // 先打 foo 在打 bar
    static class FooBar {
        Object object = new Object();
        private int n;
        private int a = 0;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (object) {
                    if (a % 2 != 0) {
                        object.wait();
                        object.notify();
                    }
                    printFoo.run();
                    a++;
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (object) {
                    if (a % 2 == 0) {
                        object.wait();
                        object.notify();
                    }
                    printBar.run();
                    a++;
                }
            }
        }
    }
}
