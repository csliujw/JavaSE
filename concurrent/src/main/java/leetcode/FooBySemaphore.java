package leetcode;

import java.util.concurrent.Semaphore;

/**
 * 顺序执行 1 2 3
 */
public class FooBySemaphore {
    static class Foo {
        Semaphore two = new Semaphore(0);
        Semaphore three = new Semaphore(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            two.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            two.acquire();
            printSecond.run();
            three.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            three.acquire();
            printThird.run();
        }
    }
}
