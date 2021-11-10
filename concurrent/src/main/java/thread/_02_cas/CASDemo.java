package thread._02_cas;

import java.util.concurrent.atomic.LongAdder;

class Value {
    int count = 0;
}

public class CASDemo {

    public synchronized void demo() {

    }

    public static long testLongAdder() throws InterruptedException {
        LongAdder longAdder = new LongAdder();
        Thread[] ths = new Thread[100];
        for (int i = 0; i < 100; i++) {
            ths[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000000; j++) {
                        longAdder.increment();
                    }
                }
            });
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < ths.length; i++) {
            ths[i].start();
            ths[i].join();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long test() throws InterruptedException {
        Value value = new Value();
        Thread[] ths = new Thread[100];
        for (int i = 0; i < 100; i++) {
            ths[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000000; j++) {
                        synchronized (CASDemo.class) {
                            value.count++;
                        }
                    }
                }
            });
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < ths.length; i++) {
            ths[i].start();
            ths[i].join();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
        long sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += testLongAdder();
        }
        System.out.println(sum);
        sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += test();
        }
        System.out.println(sum);
    }
    // sync
    // AQS
    // cas
    // volitale
    // JUC ReentrantLock  --> ConditionObject (LockSupport)
    // LockSupport
}
