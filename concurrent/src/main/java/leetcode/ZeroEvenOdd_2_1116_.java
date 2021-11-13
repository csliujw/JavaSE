package leetcode;


import java.util.function.IntConsumer;

/**
 * 每个线程都有一个 printNumber 方法来输出一个整数。
 * 请修改给出的代码以输出整数序列 010203040506... ，
 * 其中序列的长度必须为 2n
 * <p>
 * sync 实现
 * 一步一步分析：
 * zero 先运行，如果 odd 和 even 抢先运行了（条件判断他们是否抢先运行了），那么就阻塞他们。
 * zero 打印后，在选择 odd 和 even 中的一个运行；由于 sync 不能精准唤醒，所以只能 notifyAll，所以 odd 和 even 还是要判断是不是自己运行
 */
public class ZeroEvenOdd_2_1116_ {

    static class ZeroEvenOdd {
        private int n;
        private int flag = -1;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                synchronized (this) {
                    printNumber.accept(0);
                    flag = (i & 1) == 1 ? 1 : 2;
                    this.notifyAll();
                    if (i != n)
                        this.wait();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                synchronized (this) {
                    // 如果是奇数 或者 是 0
                    while (flag != 2) {
                        this.wait();
                    }
                    printNumber.accept(i);
                    flag = -1;
                    this.notifyAll();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                synchronized (this) {
                    // 如果是 偶数 或者是 0
                    while (flag != 1) {
                        this.wait();
                    }
                    printNumber.accept(i);
                    flag = -1;
                    this.notifyAll();
                }
            }
        }
    }


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
}
