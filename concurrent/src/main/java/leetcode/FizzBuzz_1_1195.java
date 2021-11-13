package leetcode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * 交替打印字符串
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * <p>
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 */
public class FizzBuzz_1_1195 {
    static class FizzBuzz {
        private int n;
        private AtomicInteger atomic = new AtomicInteger(1);

        public FizzBuzz(int n) {
            this.n = n;
        }

        public void fizz(Runnable printFizz) throws InterruptedException {
            while (atomic.get() <= n) {
                int c = atomic.get();
                if (c % 3 == 0 && c % 5 != 0) {
                    printFizz.run();
                    atomic.getAndIncrement();
                } else {
                    Thread.yield();
                }
            }

        }

        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (atomic.get() <= n) {
                int c = atomic.get();
                if (c % 5 == 0 &&c % 3 != 0) {
                    printBuzz.run();
                    atomic.getAndIncrement();
                } else {
                    Thread.yield();
                }
            }

        }

        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (atomic.get() <= n) {
                int c = atomic.get();
                if (c % 3 == 0 && c % 5 == 0) {
                    printFizzBuzz.run();
                    atomic.getAndIncrement();
                } else {
                    Thread.yield();
                }
            }

        }

        public void number(IntConsumer printNumber) throws InterruptedException {
            while (atomic.get() <= n) {
                int c = atomic.get();
                if (c % 3 != 0 && c % 5 != 0) {
                    printNumber.accept(n);
                    atomic.getAndIncrement();
                } else {
                    Thread.yield();
                }
            }
        }
    }
}
