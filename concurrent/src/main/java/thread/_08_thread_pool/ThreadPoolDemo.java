package thread._08_thread_pool;

import java.util.concurrent.*;

/**
 * 线程池可以复用线程、控制最大并发数、管理线程。
 * 线程池中有可以用的线程，就拿线程出来用，没有就先暂时阻塞任务，等待有线程了在执行那些任务。
 * 使用线程池在一定程度上可以减少上下文切换的开销。
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        ScheduledThreadPool();
        // new 一个线程，传入实现Runnable接口的对象。调用thread对象的start方法，从而调用Runnable的run方法
        // 实现线程调用方法。我们把Runnable对象改了就可以实现线程复用？
    }

    /**
     * Executors.newFixedThreadPool(int i) ：创建一个拥有 i 个线程的线程池
     * 执行长期的任务，性能好很多
     * 创建一个定长线程池，可控制线程数最大并发数，超出的线程会在队列中等待
     */
    public static void FixedThreadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        // 循环100次，让5个线程处理100个业务
        for (int i = 0; i < 100; i++) {
            final int ii = i;
            fixedThreadPool.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "\t 给用户" + ii + "办理业务");
                    TimeUnit.SECONDS.sleep((int) (Math.random() * 15));
                    System.out.println(Thread.currentThread().getName() + "\t 给用户" + ii + "办理业务结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 执行完成后，关闭当前线程的服务，归还给线程池
                    fixedThreadPool.shutdown();
                }
            });
        }
    }

    /**
     * Executors.newSingleThreadExecutor：创建一个只有1个线程的 单线程池
     * 一个任务一个任务执行的场景
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序执行
     */
    public static void SingleThreadPool() {

    }

    /**
     * Executors.newCacheThreadPool(); 创建一个可扩容的线程池
     * 执行很多短期异步的小程序或者负载教轻的服务器
     * 创建一个可缓存线程池，如果线程长度超过处理需要，可灵活回收空闲线程，如无可回收，则新建新线程
     */
    public static void CacheThreadPool() {

    }

    /**
     * Executors.newScheduledThreadPool(int corePoolSize)：
     * 线程池支持定时以及周期性执行任务，创建一个corePoolSize为传入参数，最大线程数为整型的最大数的线程池
     */
    public static void ScheduledThreadPool() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        // 周期执行。
        ScheduledFuture<?> schedule1 = scheduledThreadPool.scheduleAtFixedRate(() -> {
            System.out.println(1);
        }, 10, 10, TimeUnit.SECONDS);

        // 只执行一次
        ScheduledFuture<?> schedule2 = scheduledThreadPool.schedule(() -> {
            System.out.println(2);
        }, 10, TimeUnit.SECONDS);
    }
}
