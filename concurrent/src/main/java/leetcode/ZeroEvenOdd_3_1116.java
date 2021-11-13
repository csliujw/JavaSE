package leetcode;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 每个线程都有一个 printNumber 方法来输出一个整数。
 * 请修改给出的代码以输出整数序列 010203040506... ，
 * 其中序列的长度必须为 2n
 * <p>
 * ReentrantLock 实现
 * 一步一步分析：
 * zero 先运行，如果 odd 和 even 抢先运行了（条件判断他们是否抢先运行了），那么就阻塞他们。
 * zero 打印后，在选择 odd 和 even 中的一个运行；lock 精准唤醒
 * - zero 唤醒  odd 或 even
 * - odd 和 even 唤醒 zero
 * <p>
 * 需要注意 IntConsumer 只能接收同样类型的数（奇数、偶数）
 */
public class ZeroEvenOdd_3_1116 {


    static class ZeroEvenOdd {
        private int n;
        private int flag = -1;

        ReentrantLock lock = new ReentrantLock();
        Condition zero = lock.newCondition();
        Condition even = lock.newCondition();
        Condition odd = lock.newCondition();

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                lock.lock();
                printNumber.accept(0);
                // 如果 cur 是奇数 唤醒 odd
                if ((i & 1) == 1) {
                    odd.signal();
                    flag = 1;
                } else {
                    even.signal();
                    flag = 2;
                }
                zero.await();
                lock.unlock();
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                lock.lock();
                if (flag != 2) {
                    even.await();
                }
                printNumber.accept(i);
                flag = -1;
                zero.signal();
                lock.unlock();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                lock.lock();
                if (flag != 1) {
                    odd.await();
                }
                printNumber.accept(i);
                flag = -1;
                zero.signal();
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
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
