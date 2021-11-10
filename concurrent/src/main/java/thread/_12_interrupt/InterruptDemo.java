package thread._12_interrupt;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断demo
 */
public class InterruptDemo {
    public static void testInterrupt() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true)
                Thread.yield();
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

    public static void testIsInterrupted() throws InterruptedException {
        Thread thread = new Thread(() -> {
            int count = 0;
            while (true) {
                count = (int) (Math.random() * 100_000);
                System.out.println(count);
                if (Thread.currentThread().isInterrupted() && count > 99_997) {
                    System.out.println("break current thread");
                    break;
                }
                // 放弃cpu执行权限
                Thread.yield();
            }
        });
        thread.start();
        thread.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        testIsInterrupted();
    }
}
