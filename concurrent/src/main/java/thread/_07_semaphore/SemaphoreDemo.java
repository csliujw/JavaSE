package thread._07_semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量主要用于两个目的<br>
 * - 一个是用于共享资源的互斥使用<br>
 * - 另一个用于并发线程数的控制<br>
 * - 我们模拟一个抢车位的场景，假设一共有6个车，3个停车位<br>
 * - 那么我们首先需要定义信号量为3，也就是3个停车位<br>
 */
public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        // 非公平锁
        Semaphore semaphore = new Semaphore(3, false);
        // 模拟6辆车抢车位
        // semaphore.acquire(); 抢车位，抢到就信号量-1
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " \t 抢到车位");
                    TimeUnit.SECONDS.sleep((int) (Math.random() * 10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " \t 离开车位");
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
