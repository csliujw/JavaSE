package application;

import java.util.concurrent.TimeUnit;

/**
 * 多核 CPU 多线程 提高效率。
 */
public class ThreadApplication {
    public static volatile int flag1 = 0;
    public static volatile int flag2 = 0;
    public static volatile int flag3 = 0;

    public static void main(String[] args) throws InterruptedException {
        // 4个线程，4个操作。
        Thread th1 = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
                flag1 = 1;
            } catch (InterruptedException e) {

            }
        });

        Thread th2 = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(11);
                flag2 = 1;
            } catch (InterruptedException e) {

            }
        });
        Thread th3 = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(9);
                flag3 = 1;
            } catch (InterruptedException e) {

            }
        });
        long start = System.currentTimeMillis();
        th1.start();
        th2.start();
        th3.start();
        th1.join();
        th2.join();
        th3.join();

        while (flag1 + flag3 + flag2 == 3) {
            TimeUnit.MILLISECONDS.sleep(1);
            System.out.println(System.currentTimeMillis() - start);
            return;
        }
    }
}
