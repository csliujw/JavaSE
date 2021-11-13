package leetcode;


import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 每个线程都有一个 printNumber 方法来输出一个整数。
 * 请修改给出的代码以输出整数序列 010203040506... ，
 * 其中序列的长度必须为 2n
 * <p>
 * zero 必须先打印一次，所有zero的初始信号量设置为1
 * odd 和 even 能不能打印由 zero 控制释放他们的信号量
 */
public class ZeroEvenOdd_1_1116 {

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(o -> {
                    System.out.println(o);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "1").start();

        new Thread(() -> {
            try {
                zeroEvenOdd.odd(o -> {
                    System.out.println(o);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "2").start();

        new Thread(() -> {
            try {
                zeroEvenOdd.even(o -> {
                    System.out.println(o);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "3").start();
    }

    static class ZeroEvenOdd {
        private int n;
        Semaphore zero = new Semaphore(1);
        Semaphore even = new Semaphore(0);
        Semaphore odd = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                zero.acquire();
                printNumber.accept(0);
                if ((i&1)==1) {
                    odd.release();
                } else {
                    even.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                even.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                odd.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }
    }
}
