package leetcode;

import java.util.concurrent.CountDownLatch;

public class Foo_6_1114 {
    /**
     * 尝试使用 JUC 的 CountDownLatch 条件限制执行顺序
     * <p>
     * 线程通信 + 有序执行
     */
    static class Foo {
        CountDownLatch second = new CountDownLatch(1);
        CountDownLatch third = new CountDownLatch(1);


        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            second.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            second.await();
            printSecond.run();
            third.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            third.await();
            printThird.run();
        }
    }
}
