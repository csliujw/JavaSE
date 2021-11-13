package leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class FooByAtomic {

    static class Foo {
        AtomicInteger atomic = new AtomicInteger(1);

        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            atomic.incrementAndGet();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (atomic.get() != 2) ;
            printSecond.run();
            atomic.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (atomic.get() != 3) ;
            printThird.run();
            atomic.incrementAndGet();
        }
    }
}
