package thread._00_create_thread;

import java.util.concurrent.*;

/**
 *
 */
public class CreateByThreadPool {

    public static void fixedThreadPool() {
        // 创建固定大小的线程池。允许最多执行2个任务，多余的任务会放入阻塞队列中。
        // 阻塞队列的大小为 Integer.MAX_VALUE
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void cachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            System.out.println(123);
        });
        executorService.shutdown();
    }

    public static void scheduledThreadPool() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
        // 周期执行。
        ScheduledFuture<?> schedule1 = scheduledThreadPool.scheduleAtFixedRate(() -> {
            System.out.println(1);
        }, 10, 10, TimeUnit.SECONDS);
    }


    public static void main(String[] args) {
        scheduledThreadPool();
    }
}
