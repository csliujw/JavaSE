package leetcode;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 每个线程都有一个 printNumber 方法来输出一个整数。
 * 请修改给出的代码以输出整数序列 010203040506... ，
 * 其中序列的长度必须为 2n
 * <p>
 * CountDownLatch 实现
 * 一步一步分析：
 * zero 先运行，如果 odd 和 even 抢先运行了（条件判断他们是否抢先运行了），那么就阻塞他们。
 * zero 打印后，在选择 odd 和 even 中的一个运行；lock 精准唤醒
 * - zero 唤醒  odd 或 even
 * - odd 和 even 唤醒 zero
 */
public class ZeroEvenOdd_4_1116 {
    static class ZeroEvenOdd {
        private int n;

        CountDownLatch zero = new CountDownLatch(0);
        CountDownLatch odd = new CountDownLatch(1);
        CountDownLatch even = new CountDownLatch(1);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                zero.await();
                zero = new CountDownLatch(1); // 先于 countDown 怕死锁；假设 odd.countDown 了，然后 odd 执行完毕了，zero.countDown() 执行了，好了 zero 方法才执行到 new，没人给他计数-1了，死锁了
                printNumber.accept(0);
                if ((i & 1) == 1) {
                    odd.countDown();
                } else {
                    even.countDown();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) { // 2 4 6 8 10
                even.await();
                printNumber.accept(i);
                even = new CountDownLatch(1);
                zero.countDown();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) { // 1 3 5 7 9
                odd.await();
                printNumber.accept(i);
                odd = new CountDownLatch(1);
                zero.countDown();
            }
        }
    }


    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(o -> {
                    System.out.println(o + " zero \t");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "1").start();

        new Thread(() -> {
            try {
                zeroEvenOdd.odd(o -> {
                    System.out.println(o + " odd \t");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "2").start();

        new Thread(() -> {
            try {
                zeroEvenOdd.even(o -> {
                    System.out.println(o + " even \t");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "3").start();
    }

}
