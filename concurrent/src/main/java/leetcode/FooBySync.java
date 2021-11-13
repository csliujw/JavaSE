package leetcode;

public class FooBySync {
    static class Foo {
        int count = 1;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            while (count < 4) {
                synchronized (Foo.class) {
                    if (count == 1) {
                        printFirst.run();
                        count++;
                    }
                }
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (count < 4) {
                synchronized (Foo.class) {
                    if (count == 2) {
                        printSecond.run();
                        count++;
                    }
                }
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (count < 4) {
                synchronized (Foo.class) {
                    if (count == 3) {
                        printThird.run();
                        count++;
                    }
                }
            }
        }
    }
}

